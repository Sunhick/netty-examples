package com.local;

import com.local.dagger.DaggerPathIdentifierServerApp;
import lombok.extern.log4j.Log4j2;
import lombok.var;

@Log4j2
public class PathIdentifierApp {
    public void run() throws InterruptedException {
        log.debug("Running PathIdentifierHandler Application");
        var app = DaggerPathIdentifierServerApp.create();
        PathIdentifierServer server = app.createServer();
        server.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.debug("Running the shutdown hook");
            server.stop();
        }));
    }
}
