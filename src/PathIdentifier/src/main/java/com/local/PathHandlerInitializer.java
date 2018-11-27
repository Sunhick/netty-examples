package com.local;

import io.netty.channel.ChannelInboundHandlerAdapter;
import lombok.extern.log4j.Log4j2;

import java.net.URI;

@Log4j2
public class PathHandlerInitializer implements PathInitializer {
    @Override
    public ChannelInboundHandlerAdapter create(URI uri) {
        switch (uri.getPath()) {
            case "/ping":
                log.info("Ping requested");
                return new PingHandler();

            case "/status":
                log.info("status requested");
                return new StatusHandler();

            default:
                log.warn("Nothing or unknown path specified");
                return new UnknownPathHandler();
        }
    }
}
