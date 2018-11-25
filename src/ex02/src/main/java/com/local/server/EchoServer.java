package com.local.server;

import io.netty.bootstrap.ServerBootstrap;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.net.InetSocketAddress;

@Log4j2
public class EchoServer {
    private ServerBootstrap serverBootstrap;
    private InetSocketAddress address;

    @Inject
    public EchoServer(ServerBootstrap serverBootstrap, InetSocketAddress address) {
        this.serverBootstrap = serverBootstrap;
        this.address = address;
    }

    public void run() throws InterruptedException {
        log.trace("starting the server");
        serverBootstrap.bind(address).sync();
    }
}
