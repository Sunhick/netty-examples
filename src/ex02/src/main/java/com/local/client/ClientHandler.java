package com.local.client;

import com.local.EchoDateTimeProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        log.debug("Client handler channel read: ");
        EchoDateTimeProto.EchoDateTime ts = (EchoDateTimeProto.EchoDateTime) msg;
        log.debug("Client handler channel read: " + msg);
        ctx.writeAndFlush(ts);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("Error in client handler", cause);
        ctx.close();
    }
}