package com.local;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.ssl.SslHandler;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class SslChannelInitializer extends ChannelInitializer<SocketChannel> {
    public final int MAXSIZE = (int)Math.pow(2, 16);
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        SecureSocketSslContextFactory factory =
                new SecureSocketSslContextFactory();

        pipeline.addLast("ssl", new SslHandler(factory.getSslEngine()))
                .addLast(new HttpServerCodec())
                .addLast(new HttpObjectAggregator(MAXSIZE))
                .addLast(new SslPingHandler());
    }
}
