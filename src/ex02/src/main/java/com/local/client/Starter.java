package com.local.client;

import com.local.codec.EchoDateTimeDecoder;
import com.local.codec.EchoDateTimeEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class Starter {
    public static void main(String[] args) throws InterruptedException {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(workerGroup);
        b.channel(NioSocketChannel.class);

        b.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(
                        new EchoDateTimeEncoder(),
                        new EchoDateTimeDecoder(),
                        new ClientHandler());
            }
        });

        String serverIp = "127.0.0.1";
        b.connect(serverIp, 19000);
        log.info("==== Client/Starter ====");
    }
}
