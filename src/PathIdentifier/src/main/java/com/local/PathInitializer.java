package com.local;

import io.netty.channel.ChannelInboundHandlerAdapter;

import java.net.URI;

public interface PathInitializer {
    ChannelInboundHandlerAdapter create(URI uri);
}
