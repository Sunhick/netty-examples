package com.local.client;

import io.netty.bootstrap.Bootstrap;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.net.InetSocketAddress;

@Log4j2
public class EchoClient {
    private Bootstrap client;
    private InetSocketAddress address;

    @Inject
    public EchoClient(Bootstrap client, InetSocketAddress address) {
        this.client = client;
        this.address = address;
    }

    public void run() {
        log.info("Client connecting to the server: " + address);
        client.connect(address);
    }
}
