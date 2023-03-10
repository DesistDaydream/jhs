package com.bytedance.sdk.openadsdk.api.plugin.a;

import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class c {

    /* loaded from: classes.dex */
    public static final class a {
        private static final c a = new c();
    }

    public static c a() {
        return a.a;
    }

    private X509TrustManager b() throws IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw new IOException("No System TLS", e2);
        }
    }

    private c() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
        if (r5 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x007c, code lost:
        r5.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0089, code lost:
        if (r5 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008c, code lost:
        return null;
     */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(boolean r4, java.lang.String r5, byte[] r6) {
        /*
            r3 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            javax.net.ssl.X509TrustManager r5 = r3.b()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            javax.net.ssl.SSLSocketFactory r5 = r3.a(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            javax.net.ssl.HttpsURLConnection.setDefaultSSLSocketFactory(r5)     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            java.net.URLConnection r5 = r1.openConnection()     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            javax.net.ssl.HttpsURLConnection r5 = (javax.net.ssl.HttpsURLConnection) r5     // Catch: java.lang.Throwable -> L82 java.lang.Exception -> L84
            r1 = 5000(0x1388, float:7.006E-42)
            r5.setConnectTimeout(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            com.bytedance.sdk.openadsdk.api.plugin.a.a r1 = com.bytedance.sdk.openadsdk.api.plugin.a.a.a     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r5.setHostnameVerifier(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            if (r4 == 0) goto L48
            if (r6 == 0) goto L48
            int r4 = r6.length     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            if (r4 == 0) goto L48
            r4 = 1
            r5.setDoOutput(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            int r4 = r6.length     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r5.setFixedLengthStreamingMode(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.io.OutputStream r1 = r5.getOutputStream()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4.<init>(r1)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4.write(r6)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4.flush()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r4.close()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.lang.String r4 = "POST"
            r5.setRequestMethod(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            goto L4d
        L48:
            java.lang.String r4 = "GET"
            r5.setRequestMethod(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
        L4d:
            int r4 = r5.getResponseCode()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 < r6) goto L7a
            r6 = 300(0x12c, float:4.2E-43)
            if (r4 >= r6) goto L7a
            java.lang.String r4 = "Content-Type"
            java.lang.String r4 = r5.getHeaderField(r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.lang.String r6 = "utf-8"
            java.lang.String r4 = a(r4, r6)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.lang.String r6 = new java.lang.String     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            java.io.InputStream r1 = r5.getInputStream()     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r2 = 1024(0x400, float:1.435E-42)
            byte[] r1 = a(r1, r2)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            r6.<init>(r1, r4)     // Catch: java.lang.Exception -> L80 java.lang.Throwable -> L8d
            if (r5 == 0) goto L79
            r5.disconnect()     // Catch: java.lang.Exception -> L79
        L79:
            return r6
        L7a:
            if (r5 == 0) goto L8c
        L7c:
            r5.disconnect()     // Catch: java.lang.Exception -> L8c
            goto L8c
        L80:
            r4 = move-exception
            goto L86
        L82:
            r4 = move-exception
            goto L8f
        L84:
            r4 = move-exception
            r5 = r0
        L86:
            r4.printStackTrace()     // Catch: java.lang.Throwable -> L8d
            if (r5 == 0) goto L8c
            goto L7c
        L8c:
            return r0
        L8d:
            r4 = move-exception
            r0 = r5
        L8f:
            if (r0 == 0) goto L94
            r0.disconnect()     // Catch: java.lang.Exception -> L94
        L94:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.a.c.a(boolean, java.lang.String, byte[]):java.lang.String");
    }

    private static byte[] a(InputStream inputStream, int i2) throws IOException {
        if (inputStream == null) {
            return null;
        }
        if (i2 < 1) {
            i2 = 1;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[i2];
        while (true) {
            int read = inputStream.read(bArr);
            if (read != -1) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                byteArrayOutputStream.close();
                inputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    private static String a(String str, String str2) {
        if (str != null) {
            String[] split = str.split(";", 0);
            for (int i2 = 1; i2 < split.length; i2++) {
                String[] split2 = split[i2].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str2;
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw new IOException("No System TLS", e2);
        }
    }
}
