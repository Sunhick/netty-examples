package com.local;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WebSocketChannelInitializer extends ChannelInitializer<SocketChannel> {
    private final int MAXSIZE = (int)Math.pow(2, 16);

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        log.debug("Initializing the Socket channel pipline. Maxsize: " + MAXSIZE);
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec())
                .addLast(new HttpObjectAggregator(MAXSIZE))
                .addLast(new HttpConnectionHandler());

    }
}
