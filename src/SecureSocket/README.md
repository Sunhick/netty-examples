## How to run the app ?
Run the scripts in the ```scripts``` folder first. Make any necessary changes to the scripts if required(incase if you want to change the certificates/ algorithms etc). This will create a
self-signed certificate that's ```cer``` encoded. The ```openssl``` command in the ```cert.sh``` will create ```pem``` encoded certificate that we can then use with the curl client.

Now, you may run the netty ssl-server.

``` shell
$ java -jar build/libs/SecureSocket-all-1.0.jar
```

#### Curl client:
Run curl to connect to the ssl server securely as

``` shell
$ curl https://localhost:9999/ --cacert path/to/keystore.pem -v
```

#### On Mac Browsers:
If you are a mac user, you may import the ```cer``` file into the keychain and change trust to always allow. So that you can directly open https://localhost:9999/


``` text
➜  scripts git:(master) ✗ curl --cacert keystore.pem https://localhost:9999/ -v
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 9999 (#0)
* ALPN, offering h2
* ALPN, offering http/1.1
* Cipher selection: ALL:!EXPORT:!EXPORT40:!EXPORT56:!aNULL:!LOW:!RC4:@STRENGTH
* successfully set certificate verify locations:
*   CAfile: keystore.pem
  CApath: none
* TLSv1.2 (OUT), TLS handshake, Client hello (1):
* TLSv1.2 (IN), TLS handshake, Server hello (2):
* TLSv1.2 (IN), TLS handshake, Certificate (11):
* TLSv1.2 (IN), TLS handshake, Server key exchange (12):
* TLSv1.2 (IN), TLS handshake, Server finished (14):
* TLSv1.2 (OUT), TLS handshake, Client key exchange (16):
* TLSv1.2 (OUT), TLS change cipher, Client hello (1):
* TLSv1.2 (OUT), TLS handshake, Finished (20):
* TLSv1.2 (IN), TLS change cipher, Client hello (1):
* TLSv1.2 (IN), TLS handshake, Finished (20):
* SSL connection using TLSv1.2 / ECDHE-RSA-AES128-GCM-SHA256
* ALPN, server did not agree to a protocol
* Server certificate:
*  subject: C=US; ST=Washington; L=Seattle; O=Local; OU=localhost; CN=localhost
*  start date: Nov 28 05:07:44 2018 GMT
*  expire date: Feb 26 05:07:44 2019 GMT
*  common name: localhost (matched)
*  issuer: C=US; ST=Washington; L=Seattle; O=Local; OU=localhost; CN=localhost
*  SSL certificate verify ok.
> GET / HTTP/1.1
> Host: localhost:9999
> User-Agent: curl/7.54.0
> Accept: */*
>
< HTTP/1.1 200 OK
< content-type: text/plain
< content-length: 15
<
Hi Ssl handler
* Connection #0 to host localhost left intact

```
