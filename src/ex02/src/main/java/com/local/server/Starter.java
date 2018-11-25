package com.local.server;

import lombok.extern.log4j.Log4j2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
public class Starter {
    public static void main(String[] args) {
        log.debug("In main netty-in-action tutorials -- Pipelines");

        Date dt = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String timestamp = dateFormat.format(dt);
        EchoDateTimeProto.EchoDateTime datetime = EchoDateTimeProto.EchoDateTime.newBuilder()
                .setTimestamp(timestamp).build();

        System.out.println(datetime);

    }
}
