package com.local;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Starter {
    public static void main(String[] args) throws InterruptedException {
        log.debug("Welcome to netty ex03 example.");
        new PathIdentifierApp().run();
    }
}
