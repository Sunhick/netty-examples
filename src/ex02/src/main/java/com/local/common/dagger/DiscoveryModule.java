package dagger;

import dagger.Module;
import dagger.Provides;

import java.net.InetSocketAddress;

@Module
public class DiscoveryModule {
    @Provides
    public InetSocketAddress provideServerAddress() {
        return new InetSocketAddress("localhost", 7777);
    }
}
