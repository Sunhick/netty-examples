package com.local.dagger;

import com.local.WebSocketServer;
import dagger.Component;

@Component(modules = {WebSocketServerModule.class})
public interface WebSocketServerComponent {
    WebSocketServer createWebSocketServer();
}
