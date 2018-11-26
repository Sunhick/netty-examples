package com.local;

import lombok.extern.log4j.Log4j2;
import org.local.Tester;

@Log4j2
public class Starter {

    public static void main(String[] args) {
        log.debug("Welcome to netty ex03 example.");
        log.info("Welcome to netty ex03 example.");
        log.warn("Welcome to netty ex03 example.");
        log.error("Welcome to netty ex03 example.");
        log.fatal("Welcome to netty ex03 example.");
        log.trace("Welcome to netty ex03 example.");

        Tester t = new Tester();
        t.moreLog();
    }
}
