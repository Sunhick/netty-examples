package com.local;

import lombok.extern.log4j.Log4j2;

import javax.inject.Inject;

@FooScope
@Log4j2
public class Bar {
    private String id;

    @Inject
    public Bar(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Bar(" + id + ") " + hashCode();
    }
}
