package com.moor.imkf.lib.http.https;

import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes2.dex */
public class MoorHttpsUtils {

    /* loaded from: classes2.dex */
    public static class MyTrustManager implements X509TrustManager {
        private X509TrustManager defaultTrustManager;
        private X509TrustManager localTrustManager;

        public MyTrustManager(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyStoreException {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            this.defaultTrustManager = MoorHttpsUtils.chooseTrustManager(trustManagerFactory.getTrustManagers());
            this.localTrustManager = x509TrustManager;
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            try {
                this.defaultTrustManager.checkServerTrusted(x509CertificateArr, str);
            } catch (CertificateException unused) {
                this.localTrustManager.checkServerTrusted(x509CertificateArr, str);
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* loaded from: classes2.dex */
    public static class SSLParams {
        public SSLSocketFactory sSLSocketFactory;
        public X509TrustManager trustManager;
    }

    /* loaded from: classes2.dex */
    public class UnSafeHostnameVerifier implements HostnameVerifier {
        private UnSafeHostnameVerifier() {
        }

        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static class UnSafeTrustManager implements X509TrustManager {
        private UnSafeTrustManager() {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static X509TrustManager chooseTrustManager(TrustManager[] trustManagerArr) {
        for (TrustManager trustManager : trustManagerArr) {
            if (trustManager instanceof X509TrustManager) {
                return (X509TrustManager) trustManager;
            }
        }
        return null;
    }

    public static SSLParams getSslSocketFactory(InputStream[] inputStreamArr, InputStream inputStream, String str) {
        X509TrustManager unSafeTrustManager;
        SSLParams sSLParams = new SSLParams();
        try {
            TrustManager[] prepareTrustManager = prepareTrustManager(inputStreamArr);
            KeyManager[] prepareKeyManager = prepareKeyManager(inputStream, str);
            SSLContext sSLContext = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            if (prepareTrustManager != null) {
                unSafeTrustManager = new MyTrustManager(chooseTrustManager(prepareTrustManager));
            } else {
                unSafeTrustManager = new UnSafeTrustManager();
            }
            sSLContext.init(prepareKeyManager, new TrustManager[]{unSafeTrustManager}, null);
            sSLParams.sSLSocketFactory = sSLContext.getSocketFactory();
            sSLParams.trustManager = unSafeTrustManager;
            return sSLParams;
        } catch (KeyManagementException e2) {
            throw new AssertionError(e2);
        } catch (KeyStoreException e3) {
            throw new AssertionError(e3);
        } catch (NoSuchAlgorithmException e4) {
            throw new AssertionError(e4);
        }
    }

    private static KeyManager[] prepareKeyManager(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            try {
                KeyStore keyStore = KeyStore.getInstance("BKS");
                keyStore.load(inputStream, str.toCharArray());
                KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
                keyManagerFactory.init(keyStore, str.toCharArray());
                return keyManagerFactory.getKeyManagers();
            } catch (IOException e2) {
                e2.printStackTrace();
            } catch (KeyStoreException e3) {
                e3.printStackTrace();
            } catch (NoSuchAlgorithmException e4) {
                e4.printStackTrace();
            } catch (UnrecoverableKeyException e5) {
                e5.printStackTrace();
            } catch (CertificateException e6) {
                e6.printStackTrace();
            } catch (Exception e7) {
                e7.printStackTrace();
            }
        }
        return null;
    }

    private static TrustManager[] prepareTrustManager(InputStream... inputStreamArr) {
        if (inputStreamArr != null && inputStreamArr.length > 0) {
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
                keyStore.load(null);
                int length = inputStreamArr.length;
                int i2 = 0;
                int i3 = 0;
                while (i2 < length) {
                    InputStream inputStream = inputStreamArr[i2];
                    int i4 = i3 + 1;
                    keyStore.setCertificateEntry(Integer.toString(i3), certificateFactory.generateCertificate(inputStream));
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException unused) {
                        }
                    }
                    i2++;
                    i3 = i4;
                }
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
                trustManagerFactory.init(keyStore);
                return trustManagerFactory.getTrustManagers();
            } catch (KeyStoreException e2) {
                e2.printStackTrace();
            } catch (NoSuchAlgorithmException e3) {
                e3.printStackTrace();
            } catch (CertificateException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
        return null;
    }
}
