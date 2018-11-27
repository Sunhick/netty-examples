package com.local;

import io.netty.bootstrap.ServerBootstrap;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.net.InetSocketAddress;

@Log4j2
public class SslServer {
    private ServerBootstrap server;
    private InetSocketAddress address;

    @Inject
    public SslServer(ServerBootstrap server, InetSocketAddress address) {
        this.server = server;
        this.address = address;
    }

    public void start() throws InterruptedException {
        log.debug("Starting the ssl server");
        server.bind(address).sync();
    }

    public void stop() {
        log.debug("Stopping the ssl server");
    }
}
