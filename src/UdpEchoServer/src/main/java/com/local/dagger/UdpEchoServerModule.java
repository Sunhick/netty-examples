package com.local.dagger;

import com.local.UdpEchoServerChannelInitializer;
import dagger.Module;
import dagger.Provides;
import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LoggingHandler;
import lombok.extern.log4j.Log4j2;

import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;

@Log4j2
@Module
public class UdpEchoServerModule {
    @Provides
    public int providePort() {
        return 9999;
    }

    @Provides
    public InetSocketAddress provideAddress(int port) {
        return new InetSocketAddress(port);
    }

    @Provides
    public Bootstrap provideServerBootstrap() {
        Bootstrap server = new Bootstrap();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        server.group(worker)
                .option(ChannelOption.SO_BROADCAST, true)
                .channel(NioDatagramChannel.class)
                .handler(new UdpEchoServerChannelInitializer());
        return server;
    }
}
