package com.tencent.android.tpns.mqtt.internal.security;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpns.mqtt.MqttSecurityException;
import com.tencent.android.tpns.mqtt.logging.Logger;
import h.k2.v.n;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.Hashtable;
import java.util.Properties;
import java.util.Vector;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;

/* loaded from: classes3.dex */
public class SSLSocketFactoryFactory {
    private static final String CLASS_NAME = "com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory";
    public static final String DEFAULT_PROTOCOL = "TLS";
    public static final String SYSKEYMGRALGO = "ssl.KeyManagerFactory.algorithm";
    public static final String SYSKEYSTORE = "javax.net.ssl.keyStore";
    public static final String SYSKEYSTOREPWD = "javax.net.ssl.keyStorePassword";
    public static final String SYSKEYSTORETYPE = "javax.net.ssl.keyStoreType";
    public static final String SYSTRUSTMGRALGO = "ssl.TrustManagerFactory.algorithm";
    public static final String SYSTRUSTSTORE = "javax.net.ssl.trustStore";
    public static final String SYSTRUSTSTOREPWD = "javax.net.ssl.trustStorePassword";
    public static final String SYSTRUSTSTORETYPE = "javax.net.ssl.trustStoreType";
    private static final String xorTag = "{xor}";
    private Hashtable configs;
    private Properties defaultProperties;
    private Logger logger;
    public static final String SSLPROTOCOL = "com.ibm.ssl.protocol";
    public static final String JSSEPROVIDER = "com.ibm.ssl.contextProvider";
    public static final String KEYSTORE = "com.ibm.ssl.keyStore";
    public static final String KEYSTOREPWD = "com.ibm.ssl.keyStorePassword";
    public static final String KEYSTORETYPE = "com.ibm.ssl.keyStoreType";
    public static final String KEYSTOREPROVIDER = "com.ibm.ssl.keyStoreProvider";
    public static final String KEYSTOREMGR = "com.ibm.ssl.keyManager";
    public static final String TRUSTSTORE = "com.ibm.ssl.trustStore";
    public static final String TRUSTSTOREPWD = "com.ibm.ssl.trustStorePassword";
    public static final String TRUSTSTORETYPE = "com.ibm.ssl.trustStoreType";
    public static final String TRUSTSTOREPROVIDER = "com.ibm.ssl.trustStoreProvider";
    public static final String TRUSTSTOREMGR = "com.ibm.ssl.trustManager";
    public static final String CIPHERSUITES = "com.ibm.ssl.enabledCipherSuites";
    public static final String CLIENTAUTH = "com.ibm.ssl.clientAuthentication";
    private static final String[] propertyKeys = {SSLPROTOCOL, JSSEPROVIDER, KEYSTORE, KEYSTOREPWD, KEYSTORETYPE, KEYSTOREPROVIDER, KEYSTOREMGR, TRUSTSTORE, TRUSTSTOREPWD, TRUSTSTORETYPE, TRUSTSTOREPROVIDER, TRUSTSTOREMGR, CIPHERSUITES, CLIENTAUTH};
    private static final byte[] key = {-99, -89, ExifInterface.MARKER_EOI, n.a, 5, -72, -119, -100};

    public SSLSocketFactoryFactory() {
        this.logger = null;
        this.configs = new Hashtable();
    }

    private void checkPropertyKeys(Properties properties) throws IllegalArgumentException {
        for (String str : properties.keySet()) {
            if (!keyValid(str)) {
                throw new IllegalArgumentException(str + " is not a valid IBM SSL property key.");
            }
        }
    }

    private void convertPassword(Properties properties) {
        String property = properties.getProperty(KEYSTOREPWD);
        if (property != null && !property.startsWith(xorTag)) {
            properties.put(KEYSTOREPWD, obfuscate(property.toCharArray()));
        }
        String property2 = properties.getProperty(TRUSTSTOREPWD);
        if (property2 == null || property2.startsWith(xorTag)) {
            return;
        }
        properties.put(TRUSTSTOREPWD, obfuscate(property2.toCharArray()));
    }

    public static char[] deObfuscate(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] decode = SimpleBase64Encoder.decode(str.substring(5));
            for (int i2 = 0; i2 < decode.length; i2++) {
                byte b = decode[i2];
                byte[] bArr = key;
                decode[i2] = (byte) ((b ^ bArr[i2 % bArr.length]) & 255);
            }
            return toChar(decode);
        } catch (Throwable unused) {
            return null;
        }
    }

    private KeyManager[] getKeyManagersForSSLContext(String str) throws NoSuchAlgorithmException, NoSuchProviderException, MqttSecurityException {
        KeyStore keyStore;
        FileInputStream fileInputStream;
        KeyManagerFactory keyManagerFactory;
        String str2 = str;
        KeyManager[] keyManagerArr = null;
        keyManagerArr = null;
        FileInputStream fileInputStream2 = null;
        keyManagerArr = null;
        String property = getProperty(str2, KEYSTORE, null);
        if (property == null) {
            property = getProperty(str2, KEYSTORE, SYSKEYSTORE);
        }
        Logger logger = this.logger;
        if (logger != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr[1] = property != null ? property : "null";
            logger.fine(CLASS_NAME, "getKeyManagersForSSLContext", "12004", objArr);
        }
        char[] keyStorePassword = getKeyStorePassword(str);
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Object[] objArr2 = new Object[2];
            objArr2[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr2[1] = keyStorePassword != null ? obfuscate(keyStorePassword) : "null";
            logger2.fine(CLASS_NAME, "getKeyManagersForSSLContext", "12005", objArr2);
        }
        String keyStoreType = getKeyStoreType(str);
        if (keyStoreType == null) {
            keyStoreType = KeyStore.getDefaultType();
        }
        Logger logger3 = this.logger;
        if (logger3 != null) {
            Object[] objArr3 = new Object[2];
            objArr3[0] = str2 != null ? str2 : "null (broker defaults)";
            objArr3[1] = keyStoreType != null ? keyStoreType : "null";
            logger3.fine(CLASS_NAME, "getKeyManagersForSSLContext", "12006", objArr3);
        }
        String defaultAlgorithm = KeyManagerFactory.getDefaultAlgorithm();
        String keyStoreProvider = getKeyStoreProvider(str);
        String keyManager = getKeyManager(str);
        if (keyManager != null) {
            defaultAlgorithm = keyManager;
        }
        if (property != null && keyStoreType != null) {
            try {
                if (defaultAlgorithm != null) {
                    try {
                        keyStore = KeyStore.getInstance(keyStoreType);
                        fileInputStream = new FileInputStream(property);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                    } catch (IOException e3) {
                        e = e3;
                    } catch (KeyStoreException e4) {
                        e = e4;
                    } catch (UnrecoverableKeyException e5) {
                        e = e5;
                    } catch (CertificateException e6) {
                        e = e6;
                    }
                    try {
                        keyStore.load(fileInputStream, keyStorePassword);
                        if (keyStoreProvider != null) {
                            keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm, keyStoreProvider);
                        } else {
                            keyManagerFactory = KeyManagerFactory.getInstance(defaultAlgorithm);
                        }
                        Logger logger4 = this.logger;
                        if (logger4 != null) {
                            Object[] objArr4 = new Object[2];
                            objArr4[0] = str2 != null ? str2 : "null (broker defaults)";
                            objArr4[1] = defaultAlgorithm;
                            logger4.fine(CLASS_NAME, "getKeyManagersForSSLContext", "12010", objArr4);
                            Logger logger5 = this.logger;
                            Object[] objArr5 = new Object[2];
                            if (str2 == null) {
                                str2 = "null (broker defaults)";
                            }
                            objArr5[0] = str2;
                            objArr5[1] = keyManagerFactory.getProvider().getName();
                            logger5.fine(CLASS_NAME, "getKeyManagersForSSLContext", "12009", objArr5);
                        }
                        keyManagerFactory.init(keyStore, keyStorePassword);
                        keyManagerArr = keyManagerFactory.getKeyManagers();
                        try {
                            fileInputStream.close();
                        } catch (IOException e7) {
                            throw new MqttSecurityException(e7);
                        }
                    } catch (FileNotFoundException e8) {
                        e = e8;
                        throw new MqttSecurityException(e);
                    } catch (IOException e9) {
                        e = e9;
                        throw new MqttSecurityException(e);
                    } catch (KeyStoreException e10) {
                        e = e10;
                        throw new MqttSecurityException(e);
                    } catch (UnrecoverableKeyException e11) {
                        e = e11;
                        throw new MqttSecurityException(e);
                    } catch (CertificateException e12) {
                        e = e12;
                        throw new MqttSecurityException(e);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e13) {
                                throw new MqttSecurityException(e13);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return keyManagerArr;
    }

    private String getProperty(String str, String str2, String str3) {
        String propertyFromConfig = getPropertyFromConfig(str, str2);
        return (propertyFromConfig == null && str3 != null) ? System.getProperty(str3) : propertyFromConfig;
    }

    private String getPropertyFromConfig(String str, String str2) {
        String str3 = null;
        Properties properties = str != null ? (Properties) this.configs.get(str) : null;
        if (properties == null || (str3 = properties.getProperty(str2)) == null) {
            Properties properties2 = this.defaultProperties;
            if (properties2 == null || (str3 = properties2.getProperty(str2)) != null) {
            }
            return str3;
        }
        return str3;
    }

    private SSLContext getSSLContext(String str) throws MqttSecurityException {
        SSLContext sSLContext;
        String sSLProtocol = getSSLProtocol(str);
        if (sSLProtocol == null) {
            sSLProtocol = DEFAULT_PROTOCOL;
        }
        Logger logger = this.logger;
        if (logger != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : "null (broker defaults)";
            objArr[1] = sSLProtocol;
            logger.fine(CLASS_NAME, "getSSLContext", "12000", objArr);
        }
        String jSSEProvider = getJSSEProvider(str);
        try {
            if (jSSEProvider == null) {
                sSLContext = SSLContext.getInstance(sSLProtocol);
            } else {
                sSLContext = SSLContext.getInstance(sSLProtocol, jSSEProvider);
            }
            Logger logger2 = this.logger;
            if (logger2 != null) {
                Object[] objArr2 = new Object[2];
                objArr2[0] = str != null ? str : "null (broker defaults)";
                objArr2[1] = sSLContext.getProvider().getName();
                logger2.fine(CLASS_NAME, "getSSLContext", "12001", objArr2);
            }
            sSLContext.init(getKeyManagersForSSLContext(str), getTrustManagersForSSLContext(str), null);
            return sSLContext;
        } catch (KeyManagementException e2) {
            throw new MqttSecurityException(e2);
        } catch (NoSuchAlgorithmException e3) {
            throw new MqttSecurityException(e3);
        } catch (NoSuchProviderException e4) {
            throw new MqttSecurityException(e4);
        }
    }

    private TrustManager[] getTrustManagersForSSLContext(String str) throws NoSuchAlgorithmException, NoSuchProviderException, MqttSecurityException {
        KeyStore keyStore;
        FileInputStream fileInputStream;
        TrustManagerFactory trustManagerFactory;
        String trustStore = getTrustStore(str);
        Logger logger = this.logger;
        if (logger != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : "null (broker defaults)";
            objArr[1] = trustStore != null ? trustStore : "null";
            logger.fine(CLASS_NAME, "getTrustManagersForSSLContext", "12011", objArr);
        }
        char[] trustStorePassword = getTrustStorePassword(str);
        Logger logger2 = this.logger;
        if (logger2 != null) {
            Object[] objArr2 = new Object[2];
            objArr2[0] = str != null ? str : "null (broker defaults)";
            objArr2[1] = trustStorePassword != null ? obfuscate(trustStorePassword) : "null";
            logger2.fine(CLASS_NAME, "getTrustManagersForSSLContext", "12012", objArr2);
        }
        String trustStoreType = getTrustStoreType(str);
        if (trustStoreType == null) {
            trustStoreType = KeyStore.getDefaultType();
        }
        Logger logger3 = this.logger;
        if (logger3 != null) {
            Object[] objArr3 = new Object[2];
            objArr3[0] = str != null ? str : "null (broker defaults)";
            objArr3[1] = trustStoreType != null ? trustStoreType : "null";
            logger3.fine(CLASS_NAME, "getTrustManagersForSSLContext", "12013", objArr3);
        }
        String defaultAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
        String trustStoreProvider = getTrustStoreProvider(str);
        String trustManager = getTrustManager(str);
        if (trustManager != null) {
            defaultAlgorithm = trustManager;
        }
        TrustManager[] trustManagerArr = null;
        trustManagerArr = null;
        FileInputStream fileInputStream2 = null;
        trustManagerArr = null;
        if (trustStore != null && trustStoreType != null) {
            try {
                if (defaultAlgorithm != null) {
                    try {
                        keyStore = KeyStore.getInstance(trustStoreType);
                        fileInputStream = new FileInputStream(trustStore);
                    } catch (FileNotFoundException e2) {
                        e = e2;
                    } catch (IOException e3) {
                        e = e3;
                    } catch (KeyStoreException e4) {
                        e = e4;
                    } catch (CertificateException e5) {
                        e = e5;
                    }
                    try {
                        keyStore.load(fileInputStream, trustStorePassword);
                        if (trustStoreProvider != null) {
                            trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm, trustStoreProvider);
                        } else {
                            trustManagerFactory = TrustManagerFactory.getInstance(defaultAlgorithm);
                        }
                        Logger logger4 = this.logger;
                        if (logger4 != null) {
                            Object[] objArr4 = new Object[2];
                            objArr4[0] = str != null ? str : "null (broker defaults)";
                            objArr4[1] = defaultAlgorithm;
                            logger4.fine(CLASS_NAME, "getTrustManagersForSSLContext", "12017", objArr4);
                            Logger logger5 = this.logger;
                            Object[] objArr5 = new Object[2];
                            if (str == null) {
                                str = "null (broker defaults)";
                            }
                            objArr5[0] = str;
                            objArr5[1] = trustManagerFactory.getProvider().getName();
                            logger5.fine(CLASS_NAME, "getTrustManagersForSSLContext", "12016", objArr5);
                        }
                        trustManagerFactory.init(keyStore);
                        trustManagerArr = trustManagerFactory.getTrustManagers();
                        try {
                            fileInputStream.close();
                        } catch (IOException e6) {
                            throw new MqttSecurityException(e6);
                        }
                    } catch (FileNotFoundException e7) {
                        e = e7;
                        throw new MqttSecurityException(e);
                    } catch (IOException e8) {
                        e = e8;
                        throw new MqttSecurityException(e);
                    } catch (KeyStoreException e9) {
                        e = e9;
                        throw new MqttSecurityException(e);
                    } catch (CertificateException e10) {
                        e = e10;
                        throw new MqttSecurityException(e);
                    } catch (Throwable th) {
                        th = th;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e11) {
                                throw new MqttSecurityException(e11);
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        return trustManagerArr;
    }

    public static boolean isSupportedOnJVM() throws LinkageError, ExceptionInInitializerError {
        try {
            Class.forName("javax.net.ssl.SSLServerSocketFactory");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean keyValid(String str) {
        String[] strArr;
        int i2 = 0;
        while (true) {
            strArr = propertyKeys;
            if (i2 >= strArr.length || strArr[i2].equals(str)) {
                break;
            }
            i2++;
        }
        return i2 < strArr.length;
    }

    public static String obfuscate(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = toByte(cArr);
        for (int i2 = 0; i2 < bArr.length; i2++) {
            byte b = bArr[i2];
            byte[] bArr2 = key;
            bArr[i2] = (byte) ((b ^ bArr2[i2 % bArr2.length]) & 255);
        }
        return xorTag + new String(SimpleBase64Encoder.encode(bArr));
    }

    public static String packCipherSuites(String[] strArr) {
        if (strArr != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i2 = 0; i2 < strArr.length; i2++) {
                stringBuffer.append(strArr[i2]);
                if (i2 < strArr.length - 1) {
                    stringBuffer.append(',');
                }
            }
            return stringBuffer.toString();
        }
        return null;
    }

    public static byte[] toByte(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        byte[] bArr = new byte[cArr.length * 2];
        int i2 = 0;
        for (int i3 = 0; i3 < cArr.length; i3++) {
            int i4 = i2 + 1;
            bArr[i2] = (byte) (cArr[i3] & 255);
            i2 = i4 + 1;
            bArr[i4] = (byte) ((cArr[i3] >> '\b') & 255);
        }
        return bArr;
    }

    public static char[] toChar(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[bArr.length / 2];
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr.length) {
            int i4 = i2 + 1;
            cArr[i3] = (char) ((bArr[i2] & 255) + ((bArr[i4] & 255) << 8));
            i3++;
            i2 = i4 + 1;
        }
        return cArr;
    }

    public static String[] unpackCipherSuites(String str) {
        if (str == null) {
            return null;
        }
        Vector vector = new Vector();
        int indexOf = str.indexOf(44);
        int i2 = 0;
        while (indexOf > -1) {
            vector.add(str.substring(i2, indexOf));
            i2 = indexOf + 1;
            indexOf = str.indexOf(44, i2);
        }
        vector.add(str.substring(i2));
        String[] strArr = new String[vector.size()];
        vector.toArray(strArr);
        return strArr;
    }

    public SSLSocketFactory createSocketFactory(String str) throws MqttSecurityException {
        SSLContext sSLContext = getSSLContext(str);
        Logger logger = this.logger;
        if (logger != null) {
            Object[] objArr = new Object[2];
            objArr[0] = str != null ? str : "null (broker defaults)";
            objArr[1] = getEnabledCipherSuites(str) != null ? getProperty(str, CIPHERSUITES, null) : "null (using platform-enabled cipher suites)";
            logger.fine(CLASS_NAME, "createSocketFactory", "12020", objArr);
        }
        return sSLContext.getSocketFactory();
    }

    public boolean getClientAuthentication(String str) {
        String property = getProperty(str, CLIENTAUTH, null);
        if (property != null) {
            return Boolean.valueOf(property).booleanValue();
        }
        return false;
    }

    public Properties getConfiguration(String str) {
        Object obj;
        if (str == null) {
            obj = this.defaultProperties;
        } else {
            obj = this.configs.get(str);
        }
        return (Properties) obj;
    }

    public String[] getEnabledCipherSuites(String str) {
        return unpackCipherSuites(getProperty(str, CIPHERSUITES, null));
    }

    public String getJSSEProvider(String str) {
        return getProperty(str, JSSEPROVIDER, null);
    }

    public String getKeyManager(String str) {
        return getProperty(str, KEYSTOREMGR, SYSKEYMGRALGO);
    }

    public String getKeyStore(String str) {
        String propertyFromConfig = getPropertyFromConfig(str, KEYSTORE);
        return propertyFromConfig != null ? propertyFromConfig : System.getProperty(SYSKEYSTORE);
    }

    public char[] getKeyStorePassword(String str) {
        String property = getProperty(str, KEYSTOREPWD, SYSKEYSTOREPWD);
        if (property != null) {
            if (property.startsWith(xorTag)) {
                return deObfuscate(property);
            }
            return property.toCharArray();
        }
        return null;
    }

    public String getKeyStoreProvider(String str) {
        return getProperty(str, KEYSTOREPROVIDER, null);
    }

    public String getKeyStoreType(String str) {
        return getProperty(str, KEYSTORETYPE, SYSKEYSTORETYPE);
    }

    public String getSSLProtocol(String str) {
        return getProperty(str, SSLPROTOCOL, null);
    }

    public String getTrustManager(String str) {
        return getProperty(str, TRUSTSTOREMGR, SYSTRUSTMGRALGO);
    }

    public String getTrustStore(String str) {
        return getProperty(str, TRUSTSTORE, SYSTRUSTSTORE);
    }

    public char[] getTrustStorePassword(String str) {
        String property = getProperty(str, TRUSTSTOREPWD, SYSTRUSTSTOREPWD);
        if (property != null) {
            if (property.startsWith(xorTag)) {
                return deObfuscate(property);
            }
            return property.toCharArray();
        }
        return null;
    }

    public String getTrustStoreProvider(String str) {
        return getProperty(str, TRUSTSTOREPROVIDER, null);
    }

    public String getTrustStoreType(String str) {
        return getProperty(str, TRUSTSTORETYPE, null);
    }

    public void initialize(Properties properties, String str) throws IllegalArgumentException {
        checkPropertyKeys(properties);
        Properties properties2 = new Properties();
        properties2.putAll(properties);
        convertPassword(properties2);
        if (str != null) {
            this.configs.put(str, properties2);
        } else {
            this.defaultProperties = properties2;
        }
    }

    public void merge(Properties properties, String str) throws IllegalArgumentException {
        checkPropertyKeys(properties);
        Properties properties2 = this.defaultProperties;
        if (str != null) {
            properties2 = (Properties) this.configs.get(str);
        }
        if (properties2 == null) {
            properties2 = new Properties();
        }
        convertPassword(properties);
        properties2.putAll(properties);
        if (str != null) {
            this.configs.put(str, properties2);
        } else {
            this.defaultProperties = properties2;
        }
    }

    public boolean remove(String str) {
        if (str != null) {
            if (this.configs.remove(str) != null) {
                return true;
            }
        } else if (this.defaultProperties != null) {
            this.defaultProperties = null;
            return true;
        }
        return false;
    }

    public SSLSocketFactoryFactory(Logger logger) {
        this();
        this.logger = logger;
    }
}
