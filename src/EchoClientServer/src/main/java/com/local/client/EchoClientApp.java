package com.local.client;

import com.local.client.dagger.DaggerEchoClientComponent;
import lombok.extern.log4j.Log4j2;
import lombok.var;

@Log4j2
public class EchoClientApp {
    public void run() {
        var echoClientComponent = DaggerEchoClientComponent.create();
        EchoClient client = echoClientComponent.createClient();
        client.run();
    }
}
