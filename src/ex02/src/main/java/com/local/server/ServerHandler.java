package com.local.server;

import com.local.EchoDateTimeProto;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.log4j.Log4j2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Log4j2
public class ServerHandler extends ChannelInboundHandlerAdapter {
    private final DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        EchoDateTimeProto.EchoDateTime ts = (EchoDateTimeProto.EchoDateTime) msg;
        log.info("server handler channel read: " + ts);
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        log.debug("user event triggered. " + evt);
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.ALL_IDLE) {
                EchoDateTimeProto.EchoDateTime ts = EchoDateTimeProto.EchoDateTime.newBuilder().
                        setTimestamp(dateFormat.format(new Date()))
                        .build();
                ctx.writeAndFlush(ts);
            }
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error("Exception caught.", cause);
        ctx.close();
    }
}