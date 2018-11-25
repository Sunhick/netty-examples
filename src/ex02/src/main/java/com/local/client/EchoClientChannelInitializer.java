package com.local.client;

import com.local.codec.EchoDateTimeDecoder;
import com.local.codec.EchoDateTimeEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EchoClientChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ch.pipeline().addLast(
                new EchoDateTimeEncoder(),
                new EchoDateTimeDecoder(),
                new ClientHandler());

        log.warn("List of client pipelines: " + ch.pipeline().names());
    }
}
