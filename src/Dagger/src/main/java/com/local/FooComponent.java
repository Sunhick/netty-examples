package com.local;

import dagger.Component;

@FooScope
@Component(modules = {FooModule.class})
public interface FooComponent {
    // Foo createFoo();

    // Dagger components will replace the Factory pattern
    // and SubComponents will replace the Factory of Factory
    // pattern aka Factory-Factory pattern or Abstract factory.

    // Read at your risk!
    // Component and SubComponent kinda violates the principle.
    // Component is a parent is class, SubComponent is a subclass/
    // specialization. But when creating we create parent Component
    // first that knows about the sub-component before hand.
    // Weird huh ?

    // Sub-components cannot have same scope as their parents.
    // This is where sub-components shine because this allows you
    // to have different behavior based on the lifespan of the
    // instance.
    BooSubComponent createBooComponent();

    // Bar is bound to the lifespan of the FooComponent.
    // It's going to behave as a singleton within the scope
    // of foo component instance.
    Bar createBar();
}
