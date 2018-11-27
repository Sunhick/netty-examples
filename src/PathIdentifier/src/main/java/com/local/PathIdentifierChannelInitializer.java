package com.local;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class PathIdentifierChannelInitializer extends ChannelInitializer<SocketChannel> {
    private final int MAX_SIZE = 65536;
    private PathIdentifierHandlerFactory factory;

    @Inject
    public PathIdentifierChannelInitializer(PathIdentifierHandlerFactory factory) {
        this.factory = factory;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        log.debug("Initializing the channel. " + pipeline.names());

        pipeline.addLast(new HttpServerCodec())
                .addLast(new HttpObjectAggregator(MAX_SIZE))
                .addLast(factory.newIdentifierHandler());
        // pipeline.remove(this); Not required. ChannelIntializer already does this for you.
    }
}
