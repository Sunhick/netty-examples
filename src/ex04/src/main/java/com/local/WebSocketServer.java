package com.local;

import io.netty.bootstrap.ServerBootstrap;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.net.InetSocketAddress;

@Log4j2
public class WebSocketServer implements GenericServer {
    private ServerBootstrap server;
    private InetSocketAddress address;

    @Inject
    public WebSocketServer(ServerBootstrap server, InetSocketAddress address) {
        this.server = server;
        this.address = address;
    }

    public void start() throws InterruptedException {
        log.debug("Starting the WebSocket server");
        server.bind(address).sync();
    }

    public void stop() {
        log.debug("Stopping the WebSocket server");
    }
}
