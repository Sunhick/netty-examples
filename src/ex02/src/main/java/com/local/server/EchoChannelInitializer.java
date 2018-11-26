package com.local.server;

import com.local.common.codec.EchoDateTimeDecoder;
import com.local.common.codec.EchoDateTimeEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class EchoChannelInitializer extends ChannelInitializer<SocketChannel> {
    private EventExecutorGroup group;

    @Inject
    public EchoChannelInitializer(EventExecutorGroup group) {
        this.group = group;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("idleStateHandler", new IdleStateHandler(0,0,5));
        pipeline.addLast(new EchoDateTimeEncoder());
        pipeline.addLast(new EchoDateTimeDecoder());
        pipeline.addLast(group,"serverHandler", new EchoServerHandler());

        // Remove the echo channel initializer
        pipeline.remove(this);

        log.warn("List of server pipelines: " + ch.pipeline().names());
    }
}
