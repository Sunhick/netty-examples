package com.local;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class EchoServer {
    private ServerBootstrap echoServer;

    @Inject
    public EchoServer(ServerBootstrap echoServer) {
        this.echoServer = echoServer;
    }

    public void start() throws InterruptedException {
        log.info("Starting the echo server");
        ChannelFuture channelFuture = echoServer.bind().sync();

    }

    public void stop() {
        log.info("Stopping the echo server");
    }
}
