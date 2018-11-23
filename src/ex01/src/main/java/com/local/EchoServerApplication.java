package com.local;

import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class EchoServerApplication {
    @Inject
    EchoServer echoServer;

    public EchoServerApplication() {
        EchoServerComponent echoServerComponent = DaggerEchoServerComponent.create();
        // echoServerComponent.inject(this);
        echoServer = echoServerComponent.createEchoServer();
    }

    void run() throws InterruptedException {
        echoServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.warn("Running shutdown hook task");
            echoServer.stop();
        }));
    }
}
