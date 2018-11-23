package com.local;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EchoChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        log.debug("Inside path channel initializer InitChannel");
        ch.pipeline().addLast(new EchoHandler());
    }
}
