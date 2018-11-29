package com.local.client;

import lombok.extern.log4j.Log4j2;

import java.io.IOException;
import java.net.*;

@Log4j2
public class Starter {
    public static void main(String args[]) throws IOException {
        DatagramSocket socket = new DatagramSocket();

        InetSocketAddress address;
        address = new InetSocketAddress("localhost", 9999);
        byte[] buf = "hello".getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address);

        socket.send(packet);
        log.info(buf);
    }
}
