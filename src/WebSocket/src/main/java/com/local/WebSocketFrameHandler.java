package com.local;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.*;
import lombok.extern.log4j.Log4j2;
import lombok.var;

@Log4j2
public class WebSocketFrameHandler extends SimpleChannelInboundHandler<WebSocketFrame> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, WebSocketFrame wsFrame) throws Exception {
        if (null == wsFrame) {
            log.error("Message is empty");
            return;
        }

        log.info("WebSocket frame received. MSG: " + wsFrame);
        log.debug("Client websocket channel : " + ctx.channel());

        if (wsFrame instanceof BinaryWebSocketFrame) {
            log.info("BinaryWebSocketFrame Received : " + wsFrame.content());
        } else if (wsFrame instanceof TextWebSocketFrame) {
            TextWebSocketFrame textFrame = ((TextWebSocketFrame) wsFrame);
            log.info("TextWebSocketFrame Received : " + textFrame.text());
            ctx.channel().writeAndFlush(new TextWebSocketFrame("Message received : " + textFrame.text()));

            for (int index = 0; index < 10; index++) {
                if (!ctx.channel().isActive()) {
                    break;
                }

                log.debug("---- " + index);
                var wsResponse = new TextWebSocketFrame(((TextWebSocketFrame) wsFrame).text() + " => " + index);
                ctx.channel().writeAndFlush(wsResponse);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    log.error("Thread interrupted", e);
                }
            }
        } else if (wsFrame instanceof PingWebSocketFrame) {
            log.info("PingWebSocketFrame Received : " + wsFrame.content());
        } else if (wsFrame instanceof PongWebSocketFrame) {
            log.info("PongWebSocketFrame Received : " + wsFrame.content());
        } else if (wsFrame instanceof CloseWebSocketFrame) {
            log.info("CloseWebSocketFrame Received : ");
            log.debug("ReasonText :" + ((CloseWebSocketFrame) wsFrame).reasonText());
            log.debug("StatusCode : " + ((CloseWebSocketFrame) wsFrame).statusCode());
        } else {
            log.debug("Unsupported WebSocketFrame");
        }
    }
}
