package com.local.dagger;

import com.local.PathHandlerInitializer;
import com.local.PathIdentifierChannelInitializer;
import com.local.PathIdentifierHandler;
import com.local.PathIdentifierHandlerFactory;
import dagger.Module;
import dagger.Provides;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.var;

import java.net.InetSocketAddress;

@Module
public class PathIdentifierModule {
    @Provides
    public InetSocketAddress provideServerAddress() {
        return new InetSocketAddress(9999);
    }

    @Provides
    public ServerBootstrap provideServerBootstrap(ChannelInitializer<SocketChannel> pathIdentifierChannelInitializer) {
        ServerBootstrap server = new ServerBootstrap();
        var parentGroup = new NioEventLoopGroup();
        var workerGroup = new NioEventLoopGroup();
        return server.group(parentGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(pathIdentifierChannelInitializer);
    }

    @Provides
    public ChannelInitializer<SocketChannel> provideChannelInitializer(PathIdentifierHandlerFactory factory) {
        return new PathIdentifierChannelInitializer(factory);
    }

    @Provides
    public PathIdentifierHandlerFactory provideHandlerInitializerFactory() {
        return () -> new PathIdentifierHandler(new PathHandlerInitializer());
    }
}
