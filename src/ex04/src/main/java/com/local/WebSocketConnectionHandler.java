package com.local;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaders;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class WebSocketConnectionHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        log.debug("Web socket connection handler. Message: " + request);
        HttpHeaders headers = request.headers();

        if (!headers.contains(HttpHeaderNames.CONNECTION) || !headers.contains(HttpHeaderNames.UPGRADE)) {
            log.warn("Regular HTTP connection.");
            ctx.writeAndFlush(Unpooled.EMPTY_BUFFER);
            ctx.close();
            return;
        }

        log.info("HTTP connection with upgrade to websocket parameters");
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        
    }
}
