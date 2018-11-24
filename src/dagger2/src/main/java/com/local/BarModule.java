package com.local;

import dagger.Module;
import dagger.Provides;
import org.apache.commons.lang3.RandomStringUtils;

import javax.inject.Named;

@Module
public class BarModule {
    @FooScope
    @Provides
    @Named("BarId")
    public String provideBarId() {
        return RandomStringUtils.randomAlphanumeric(4);
    }

    @FooScope
    @Provides
    public Bar provideBar(@Named("BarId") String id) {
        return new Bar(id);
    }
}
