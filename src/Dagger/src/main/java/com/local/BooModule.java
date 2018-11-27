package com.local;

import dagger.Module;
import dagger.Provides;
import org.apache.commons.lang3.RandomStringUtils;

@Module
public class BooModule {
    @BooScope
    @NumericId
    @Provides
    public String provideId() {
        return RandomStringUtils.randomNumeric(3);
    }

    // observer the effect of scope on this Module vs class
    // where we make use of @Inject constructor.
    @BooScope
    @Provides
    public Boo provideBoo(Foo foo, @NumericId String id) {
        return new Boo(foo, id);
    }
}
