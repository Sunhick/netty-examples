package com.local.server;

import com.local.codec.EchoDateTimeDecoder;
import com.local.codec.EchoDateTimeEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;
import lombok.extern.log4j.Log4j2;

import java.io.IOException;

@Log4j2
public class Starter {
    public static void main(String[] args) throws IOException, InterruptedException {
        NioEventLoopGroup boosGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boosGroup, workerGroup);
        bootstrap.channel(NioServerSocketChannel.class);

        final EventExecutorGroup group = new DefaultEventExecutorGroup(1500); //thread pool of 1500

        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ChannelPipeline pipeline = ch.pipeline();
                pipeline.addLast("idleStateHandler",new IdleStateHandler(0,0,5));
                pipeline.addLast(new EchoDateTimeEncoder());
                pipeline.addLast(new EchoDateTimeDecoder());
                pipeline.addLast(group,"serverHandler", new ServerHandler());

                log.warn("List of server pipelines: " + ch.pipeline().names());
            }
        });

        log.info("==== Server/Starter ====");

        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.bind(19000).sync();
    }
}
