package com.local.server;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Starter {
    public static void main(String[] args) throws InterruptedException {
        log.debug("welcome to UDP echo server in netty");
        new UdpEchoServerApp().run();
    }
}
