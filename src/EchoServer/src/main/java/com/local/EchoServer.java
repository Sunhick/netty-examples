package com.local;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
class EchoServer {
    private ServerBootstrap echoServer;

    @Inject
    EchoServer(ServerBootstrap echoServer) {
        this.echoServer = echoServer;
    }

    void start() throws InterruptedException {
        log.info("Starting the echo server");
        ChannelFuture channelFuture = echoServer.bind().sync();
    }

    void stop() {
        log.info("Stopping the echo server");
    }
}
