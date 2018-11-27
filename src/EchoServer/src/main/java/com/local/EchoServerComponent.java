package com.local;

import dagger.Component;

@Component(modules = EchoServerModule.class)
public interface EchoServerComponent {
    EchoServer createEchoServer();
    // void inject(EchoServerApplication app);
}
