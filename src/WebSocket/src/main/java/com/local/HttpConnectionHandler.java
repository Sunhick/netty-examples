package com.local;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class HttpConnectionHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    public HttpConnectionHandler() {
        super(false);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        log.debug("Web socket connection handler. Message: " + request);
        HttpHeaders headers = request.headers();

        if (!headers.contains(HttpHeaderNames.CONNECTION) || !headers.contains(HttpHeaderNames.UPGRADE)) {
            log.warn("Regular HTTP connection.");
            String str = "Only web-socket connections are supported\n";
            DefaultHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1,HttpResponseStatus.BAD_REQUEST,
                    Unpooled.wrappedBuffer(str.getBytes()));
            response.headers()
                    .set(HttpHeaderNames.CONTENT_TYPE, HttpHeaderValues.TEXT_PLAIN)
                    .set(HttpHeaderNames.CONTENT_LENGTH, str.length());

            ctx.writeAndFlush(response);
            ctx.close();
            return;
        }

        log.info("HTTP connection with upgrade to websocket parameters");
        ctx.pipeline().replace(this, WebSocketHandshakeHandler.class.getName(), new WebSocketHandshakeHandler());
        ctx.fireChannelRead(request);
    }
}
