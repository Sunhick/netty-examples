package com.local;

import dagger.Module;
import dagger.Provides;
import io.netty.bootstrap.ServerBootstrap;

@Module
public class EchoServerModule {
    @Provides
    public ServerBootstrap provideEchoServer() {
        ServerBootstrap echoServer = new ServerBootstrap();
        return echoServer;
    }
}
