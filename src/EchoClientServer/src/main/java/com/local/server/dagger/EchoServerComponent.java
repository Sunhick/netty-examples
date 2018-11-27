package com.local.server.dagger;

import com.local.server.EchoServer;
import dagger.Component;

@Component(modules = {EchoServerModule.class})
public interface EchoServerComponent {
    EchoServer createServer();
}
