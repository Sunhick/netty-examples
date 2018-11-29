package com.local.server.dagger;

import com.local.server.UdpEchoServer;
import dagger.Component;

@Component(modules = {UdpEchoServerModule.class})
public interface UdpEchoServerComponent {
    UdpEchoServer createUdpServer();
}
