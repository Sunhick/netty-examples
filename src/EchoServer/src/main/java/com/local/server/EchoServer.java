package com.local.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.net.InetSocketAddress;

@Log4j2
public class EchoServer {
    private ServerBootstrap serverBootstrap;
    private InetSocketAddress address;
    private ChannelFuture future;

    @Inject
    public EchoServer(ServerBootstrap serverBootstrap, InetSocketAddress address) {
        this.serverBootstrap = serverBootstrap;
        this.address = address;
    }

    public void start() throws InterruptedException {
        log.info("starting the server. Listening at: " + address);
        future = serverBootstrap.bind(address).sync();
    }

    public void stop() throws InterruptedException {
        // future.channel().closeFuture().sync();
    }
}
