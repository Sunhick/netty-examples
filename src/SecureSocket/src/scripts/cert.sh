keytool -genkey -alias cert \
    -keyalg RSA -keystore keystore.jks \
    -dname "CN=Sunil, OU=localhost, O=Local, L=Seattle, S=Washington, C=US" \
    -storepass password -keypass password

keytool -export -keystore keystore.jks -alias cert -file keystore.cert