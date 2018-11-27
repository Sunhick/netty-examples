package com.local;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import lombok.extern.log4j.Log4j2;
import lombok.var;

@Log4j2
public class WebSocketConnectionHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    public WebSocketConnectionHandler() {
        super(false);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        log.debug("WebSocket connection handler");
        log.debug("Websocket channel: " + ctx.channel());
        ctx.pipeline().replace(this, WebSocketFrameHandler.class.getName(), new WebSocketFrameHandler());
        handleWebSocketHandShake(ctx, request);
        log.info("WebSocket handshake complete");
    }

    private void handleWebSocketHandShake(ChannelHandlerContext ctx, FullHttpRequest request) {
        WebSocketServerHandshakerFactory wsFactory =
                new WebSocketServerHandshakerFactory(webSocketURL(request), null, true);
        var webSocketHandshake = wsFactory.newHandshaker(request);
        if (webSocketHandshake == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            webSocketHandshake.handshake(ctx.channel(), request);
        }
    }

    private String webSocketURL(HttpRequest request) {
        String wsUrl =  "ws://" + request.headers().get("Host") + request.uri();
        log.info("web-socket URL: " + wsUrl);
        return wsUrl;
    }
}
