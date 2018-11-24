package com.local;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Starter {

    public static void main(String[] args) throws InterruptedException {
        log.debug("In main netty-in-action tutorials");
        // new EchoServerApplication().run();

        FooComponent fooComponent = DaggerFooComponent.create();

        // Not possible to print the address of the object in java.
        // Want we see is in-fact a complete identityHashCode / hashCode
        // of an object.
        for (int i = 0; i < 3; i++) {
//            Creates all singletons per fooComponent here.
//            Foo foo = fooComponent.createFoo();
//            log.debug(foo.toString() + System.identityHashCode(foo));

            Bar bar = fooComponent.createBar();
            log.info(bar);

            BooSubComponent booComponent = fooComponent.createBooComponent();
            log.debug(booComponent);
            for (int j = 0; j < 3; j++) {
                Boo boo = booComponent.createBoo();
                log.warn("\t\t" + boo);
            }
        }
    }
}
