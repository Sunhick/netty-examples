package dagger;

import java.net.InetSocketAddress;

@Module
public class DiscoveryModule {
    @Provides
    public InetSocketAddress provideServerAddress() {
        return new InetSocketAddress("localhost", 7777);
    }
}
