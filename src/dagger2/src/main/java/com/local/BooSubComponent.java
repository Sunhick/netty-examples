package com.local;

import dagger.Subcomponent;

@BooScope
@Subcomponent(modules = {BooModule.class})
public interface BooSubComponent {
    Boo createBoo();
}
