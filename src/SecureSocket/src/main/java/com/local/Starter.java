package com.local;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class Starter {
    public static void main(String[] args) throws InterruptedException {
        /*
            Run the scripts before you start the netty server.
            $ ./cert.sh

            Now you can curl for https as below. or you can even https://localhost:9999/ in
            the browser.
            $ curl --cacert keystore.pem https://localhost:9999/ -v
         */
        log.debug("Example of Secure socket layer in Netty");
        new SslServerApp().run();
    }
}
