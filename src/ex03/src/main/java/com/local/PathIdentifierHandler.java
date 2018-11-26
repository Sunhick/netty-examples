package com.local;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;
import java.net.URI;

@Log4j2
public class PathIdentifierHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private PathInitializer pathInitializer;

    @Inject
    public PathIdentifierHandler(PathInitializer pathInitializer) {
        super(false);
        this.pathInitializer = pathInitializer;
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        log.info("URI: " + request.uri());
        String uri = request.uri();

        ChannelInboundHandlerAdapter handler = pathInitializer.create(new URI(uri));
        log.info(handler);
        ctx.pipeline().addLast(handler);
        ctx.pipeline().remove(this);
        ctx.fireChannelRead(request);
    }
}
