package com.local;

import dagger.Module;
import dagger.Provides;
import org.apache.commons.lang3.RandomStringUtils;

@Module
public class FooModule {
    @Provides
    @FooScope
    public String provideId() {
        return RandomStringUtils.randomAlphabetic(5);
    }
}
