package com.local.server;

import com.local.server.dagger.DaggerEchoServerComponent;
import lombok.extern.log4j.Log4j2;
import lombok.var;

@Log4j2
public class EchoServerApp {
    public void run() throws InterruptedException {
        log.info("Running the echo server");

        var echoServerComponent = DaggerEchoServerComponent.create();
        EchoServer server = echoServerComponent.createServer();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.warn("Shutting down the echo server");
            try {
                server.stop();
            } catch (InterruptedException e) {
                log.error("Error in stopping server", e);
            }
        }));
    }
}
