package com.local;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslHandler;
import lombok.extern.log4j.Log4j2;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;

@Log4j2
public class SslChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        SecureSocketSslContextFactory factory =
                new SecureSocketSslContextFactory();
        SSLContext sslContext = factory.getSslContext();
        SSLEngine sslEngine = sslContext.createSSLEngine();

        pipeline.addLast("ssl", new SslHandler(sslEngine));
    }
}
