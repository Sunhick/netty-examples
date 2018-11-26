package com.local;

import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Level;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Log4j2
public class Starter {

    public static void main(String[] args) throws InterruptedException {
        final List<Level> VALUES =
                Collections.unmodifiableList(Arrays.asList(Level.values()));
        final int SIZE = VALUES.size();
        final Random RANDOM = new Random();

        while (true) {
            log.log(VALUES.get(RANDOM.nextInt(SIZE)), "Hi there, quick brown fox jumped quickly over");
            Thread.sleep(500);
        }
    }
}
