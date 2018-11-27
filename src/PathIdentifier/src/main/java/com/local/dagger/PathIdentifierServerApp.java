package com.local.dagger;

import com.local.PathIdentifierServer;
import dagger.Component;

import javax.inject.Singleton;

@Singleton
@Component(modules = {PathIdentifierModule.class})
public interface PathIdentifierServerApp {
    PathIdentifierServer createServer();
}
