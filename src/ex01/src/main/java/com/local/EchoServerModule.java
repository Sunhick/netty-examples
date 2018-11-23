package com.local;

import dagger.Module;
import dagger.Provides;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import lombok.NonNull;

import javax.inject.Named;
import java.net.InetSocketAddress;

@Module
class EchoServerModule {
    @Provides
    NioEventLoopGroup provideWorkerGroup() {
        return new NioEventLoopGroup();
    }

    @Provides
    int provideProdPort() {
        return 9999;
    }

    @Provides
    @Named("devPort")
    int provideDevPort() {
        return 8888;
    }

    @Provides
    ServerBootstrap provideEchoServer(@NonNull NioEventLoopGroup workerGroup,
                                      @Named("devPort") int port) {
        ServerBootstrap echoServer = new ServerBootstrap();
        echoServer.group(new NioEventLoopGroup(), workerGroup)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
        .childHandler(new EchoChannelInitializer());
        return echoServer;
    }
}
