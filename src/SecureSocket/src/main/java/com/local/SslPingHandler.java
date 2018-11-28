package com.local;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SslPingHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private final String response = "<!DOCTYPE html>\n" +
            "<html lang=\"en\">\n" +
            "    <head>\n" +
            "        <meta charset=\"utf-8\">\n" +
            "        <title>HTML5 : Hello World Example</title>\n" +
            "    </head>\n" +
            "    <body>\n" +
            "        <h1>Hello World</h1>\n" +
            "        <p>\n" +
            "            Hey there!\n" +
            "        </p>\n" +
            "    </body>\n" +
            "</html>";
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest msg) throws Exception {
        log.info("Ssl ping handler. Message: " + msg);
        // String response = "Hi Ssl handler\n";
        DefaultHttpResponse reply = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK,
                Unpooled.wrappedBuffer(response.getBytes()));

        reply.headers()
                .set(HttpHeaderNames.CONTENT_TYPE, "text/html")
                .set(HttpHeaderNames.CONTENT_LENGTH, response.length());

        ctx.writeAndFlush(reply);
    }


}
