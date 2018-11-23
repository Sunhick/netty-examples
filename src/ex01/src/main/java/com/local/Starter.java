package com.local;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;

@Log4j2
public class Starter {
    public static void main(String[] args) {
        log.debug("In main netty-in-action tutorials");
        log.info("In main netty-in-action tutorials");
        log.warn("In main netty-in-action tutorials");
        log.fatal("In main netty-in-action tutorials");
        log.error("In main netty-in-action tutorials");
        log.trace("In main netty-in-action tutorials");
    }
}
