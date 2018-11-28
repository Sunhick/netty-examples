package com.local;

import lombok.extern.log4j.Log4j2;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

@Log4j2
public class SecureSocketSslContextFactory {
    public final String data = "";
    public final String algorithm = "";
    public final String keyStorePassword = "password";

    public SSLContext getSslContext()
            throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, IOException,
            CertificateException, KeyManagementException {
        SSLContext serverContext = SSLContext.getInstance("TLS");

        final KeyStore ks = KeyStore.getInstance("JKS");

        ks.load(new ByteArrayInputStream(Base64Coder.decode(data)), keyStorePassword.toCharArray());

        final KeyManagerFactory kmf = KeyManagerFactory.getInstance(algorithm);
        kmf.init(ks, keyStorePassword.toCharArray());
        serverContext.init(kmf.getKeyManagers(), null, null);

        return serverContext;
    }
}
