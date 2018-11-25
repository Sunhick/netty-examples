package com.local.codec;

import com.local.EchoDateTimeProto;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class EchoDateTimeDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        log.debug("Decoding the bytes to EchoDateTime object");
        final int messageLength = in.readableBytes();
        byte [] array = new byte[messageLength];
        in.readBytes(array, 0, messageLength);
        EchoDateTimeProto.EchoDateTime ts = EchoDateTimeProto.EchoDateTime.parseFrom(array);
        out.add(ts);
    }
}
