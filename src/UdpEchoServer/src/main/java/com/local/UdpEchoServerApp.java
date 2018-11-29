package com.local;

import com.local.dagger.DaggerUdpEchoServerComponent;
import com.local.dagger.UdpEchoServerComponent;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UdpEchoServerApp {
    public void run() throws InterruptedException {
        log.debug("Bootstrapping udp echo server");
        UdpEchoServerComponent maker = DaggerUdpEchoServerComponent.create();
        UdpEchoServer udpServer = maker.createUdpServer();
        udpServer.start();

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            log.debug("In shutdown hook");
            udpServer.stop();
        }));
    }
}
