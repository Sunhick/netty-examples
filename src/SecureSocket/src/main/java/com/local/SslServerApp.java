package com.local;

import com.local.dagger.DaggerSslServerComponent;
import com.local.dagger.SslServerComponent;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SslServerApp {
    public void run() throws InterruptedException {
        log.debug("Bootstrapping the ssl server");
        SslServerComponent component = DaggerSslServerComponent.create();
        SslServer sslServer = component.createSslServer();
        sslServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.debug("Shutting down the ssl server");
            sslServer.stop();
        }));
    }
}
