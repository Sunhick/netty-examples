package com.local;

import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@FooScope
@Log4j2
public class Foo {
    private String id;

    @Inject
    public Foo(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Foo(" + id + ")" + hashCode();
    }
}
