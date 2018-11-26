package com.local;

import io.netty.bootstrap.ServerBootstrap;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.net.InetSocketAddress;

@Log4j2
public class PathIdentifierServer {
    private ServerBootstrap server;
    private InetSocketAddress address;

    @Inject
    public PathIdentifierServer(ServerBootstrap server, InetSocketAddress address) {
        this.server = server;
        this.address = address;
        this.address = address;
    }

    public void start() throws InterruptedException {
        log.info("Starting the server");
        server.bind(address).sync();
    }

    public void stop() {
        log.info("Stopping the server");
    }
}
