package com.local.server.dagger;

import dagger.DiscoveryModule;
import com.local.server.EchoChannelInitializer;
import dagger.Module;
import dagger.Provides;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

@Module(includes = {DiscoveryModule.class})
public class EchoServerModule {
    @Provides
    public EventExecutorGroup provideExecutorGroup(int threadsInPool) {
        return new DefaultEventExecutorGroup(threadsInPool);
    }

    @Provides
    public int threadsInPool() {
        return 1500;
    }

    @Provides
    public ServerBootstrap provideServerBootstrap(EchoChannelInitializer echoChannelInitializer) {
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        return serverBootstrap.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(echoChannelInitializer)
                .childOption(ChannelOption.SO_KEEPALIVE, true);
    }
}
