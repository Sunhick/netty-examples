package com.local.client;

import com.local.server.EchoDateTimeProto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Starter {
    public static void main(String[] args) {
        System.out.println("Welcome to netty client");

        Date dt = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
        String timestamp = dateFormat.format(dt);
        EchoDateTimeProto.EchoDateTime datetime = EchoDateTimeProto.EchoDateTime.newBuilder()
                .setTimestamp(timestamp).build();

        System.out.println(datetime);
    }
}
