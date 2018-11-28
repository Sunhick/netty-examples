package com.local;

import lombok.extern.log4j.Log4j2;
import org.yaml.snakeyaml.external.biz.base64Coder.Base64Coder;

import javax.net.ssl.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

@Log4j2
public class SecureSocketSslContextFactory {
    public final String data = "";
    public final String keyStorePassword = "password";
    public final String keyStoreFile = "/Users/Sunny/prv/github/netty-in-action/src/SecureSocket/src/scripts/keystore.jks";

    public SSLEngine getSslEngine()
            throws NoSuchAlgorithmException, KeyStoreException, UnrecoverableKeyException, IOException,
            CertificateException, KeyManagementException {

        TrustManagerFactory tmFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        KeyStore tmpKS = null;
        tmFactory.init(tmpKS);

        final KeyStore ks = KeyStore.getInstance("JKS");

        ks.load(new FileInputStream(keyStoreFile), keyStorePassword.toCharArray());

        final KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(ks, keyStorePassword.toCharArray());

        TrustManager[] tm = tmFactory.getTrustManagers();

        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), tm, null);
        SSLEngine sslEngine = sslContext.createSSLEngine();
        sslEngine.setUseClientMode(false);
        sslEngine.setEnabledProtocols(sslEngine.getSupportedProtocols());
        sslEngine.setEnabledCipherSuites(sslEngine.getSupportedCipherSuites());
        sslEngine.setEnableSessionCreation(true);

        return sslEngine;
    }
}
