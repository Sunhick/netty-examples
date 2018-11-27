package com.local;

import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@Log4j2
public class Boo {
    private Foo foo;
    private String id;

    @Inject
    public Boo(Foo foo, @NumericId String id) {
        this.foo = foo;
        this.id = id;
    }

    @Override
    public String toString() {
        return foo.toString() + " Boo(" + id + ") " + hashCode();
    }
}
