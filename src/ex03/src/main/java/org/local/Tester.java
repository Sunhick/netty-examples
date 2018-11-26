package org.local;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Tester {
    public void moreLog() {
        int i = 0;
        while (i++ < 1) {
            log.debug("Sample log: " + i);
            log.info("Sample log: " + i);
            log.trace("Sample log: " + i);
            log.error("Sample log: " + i);
            log.fatal("Sample log: " + i);
            log.warn("Sample log: " + i);
        }
    }
}
