package com.local;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.nio.NioDatagramChannel;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class UdpEchoServerChannelInitializer extends ChannelInitializer<NioDatagramChannel> {
    @Override
    protected void initChannel(NioDatagramChannel ch) throws Exception {
        log.debug("Udp echo server channel initializer");
        ch.pipeline().addLast(new UdpEchoServerHandler());
        log.debug("Pipeline: {}", ch.pipeline().names());
    }
}
