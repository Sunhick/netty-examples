package com.local.dagger;

import com.local.UdpEchoServer;
import dagger.Component;

@Component(modules = {UdpEchoServerModule.class})
public interface UdpEchoServerComponent {
    UdpEchoServer createUdpServer();
}
