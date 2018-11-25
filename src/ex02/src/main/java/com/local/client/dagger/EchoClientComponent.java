package com.local.client.dagger;

import com.local.client.EchoClient;
import dagger.Component;

@Component(modules = {EchoClientModule.class})
public interface EchoClientComponent {
    EchoClient createClient();
}
