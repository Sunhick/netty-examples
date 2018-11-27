package com.local;

import com.local.dagger.DaggerWebSocketServerComponent;
import com.local.dagger.WebSocketServerComponent;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WebSocketServerApp {
    public void run() throws InterruptedException {
       log.debug("Bootstrapping the WebSocket Application");
        WebSocketServerComponent serverComponent = DaggerWebSocketServerComponent.builder().build();
        WebSocketServer webSocketServer = serverComponent.createWebSocketServer();
        webSocketServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.debug("On runtime shutdown hook");
            webSocketServer.stop();
        }));
    }
}
