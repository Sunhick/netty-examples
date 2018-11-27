package com.local.dagger;

import com.local.SslServer;
import dagger.Component;

@Component(modules = {SslServerModule.class})
public interface SslServerComponent {
    SslServer createSslServer();
}
