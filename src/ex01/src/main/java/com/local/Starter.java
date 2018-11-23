package com.local;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Starter {
    public static void main(String[] args) throws InterruptedException {
        log.debug("In main netty-in-action tutorials");
        EchoServerComponent component = DaggerEchoServerComponent.create();
        EchoServer echoServer = component.createEchoServer();
        echoServer.start();
    }
}
