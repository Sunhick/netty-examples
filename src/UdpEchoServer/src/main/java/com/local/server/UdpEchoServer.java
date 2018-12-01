package com.local.server;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.SocketUtils;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.net.InetSocketAddress;

@Log4j2
public class UdpEchoServer {
    private Bootstrap server;
    private InetSocketAddress address;

    @Inject
    public UdpEchoServer(Bootstrap server, InetSocketAddress address) {
        this.server = server;
        this.address = address;
    }

    public void start() throws InterruptedException {
        log.debug("Starting the udp server at: {}", address);
        server.bind(address).sync();
    }

    public void stop() {
        log.debug("Stopping the udp server");
    }
}
