package com.local.client.dagger;

import com.local.client.EchoClientChannelInitializer;
import com.local.common.DiscoveryModule;
import dagger.Module;
import dagger.Provides;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

@Module(includes = {DiscoveryModule.class})
public class EchoClientModule {
    @Provides
    public EchoClientChannelInitializer provideClientChannel() {
        return new EchoClientChannelInitializer();
    }

    @Provides
    public Bootstrap provideClient(EchoClientChannelInitializer echoClientChannelInitializer) {
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap client = new Bootstrap();
        return client.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(echoClientChannelInitializer);
    }
}
