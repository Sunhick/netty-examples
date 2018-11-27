package com.local.dagger;

import com.local.SslChannelInitializer;
import dagger.Module;
import dagger.Provides;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

@Module
public class SslServerModule {
    @Provides
    public InetSocketAddress provideServerAddress() {
        return new InetSocketAddress(9999);
    }

    @Provides
    public ServerBootstrap provideServer() {
        ServerBootstrap server = new ServerBootstrap();
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        server.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childHandler(new SslChannelInitializer());

        return server;
    }
}
