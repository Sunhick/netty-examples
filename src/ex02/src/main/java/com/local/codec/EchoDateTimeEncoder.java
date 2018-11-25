package com.local.codec;

import com.local.EchoDateTimeProto;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EchoDateTimeEncoder extends MessageToByteEncoder<EchoDateTimeProto.EchoDateTime> {
    @Override
    protected void encode(ChannelHandlerContext ctx, EchoDateTimeProto.EchoDateTime msg, ByteBuf out) throws Exception {
        log.debug("Encoding the EchoDateTime message");
        out.writeBytes(msg.toByteArray());
    }
}
