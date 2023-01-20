package e.k.c.a.a.j;

import android.content.Context;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes2.dex */
public class k implements X509TrustManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f11941c = k.class.getSimpleName();

    /* renamed from: d  reason: collision with root package name */
    public static final String f11942d = "hmsrootcas.bks";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11943e = "";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11944f = "X509";

    /* renamed from: g  reason: collision with root package name */
    private static final String f11945g = "bks";

    /* renamed from: h  reason: collision with root package name */
    private static final String f11946h = "AndroidCAStore";
    public List<X509TrustManager> a;
    private X509Certificate[] b;

    public k(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this(context, false);
    }

    private void a() {
        e.k.c.a.a.j.q.i.e(f11941c, "loadSystemCA");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            KeyStore keyStore = KeyStore.getInstance(f11946h);
            keyStore.load(null, null);
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f11944f);
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (int i2 = 0; i2 < trustManagers.length; i2++) {
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.a.add((X509TrustManager) trustManagers[i2]);
                }
            }
        } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
            String str = f11941c;
            e.k.c.a.a.j.q.i.d(str, "loadSystemCA: exception : " + e2.getMessage());
        }
        String str2 = f11941c;
        e.k.c.a.a.j.q.i.b(str2, "loadSystemCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    private void b(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        boolean z;
        String str = f11941c;
        e.k.c.a.a.j.q.i.e(str, "loadBksCA");
        long currentTimeMillis = System.currentTimeMillis();
        InputStream o = e.k.c.a.a.j.q.a.o(context);
        if (o != null) {
            try {
                e.k.c.a.a.j.q.i.e(str, "get bks not from assets");
                c(o);
            } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                String str2 = f11941c;
                e.k.c.a.a.j.q.i.d(str2, "loadBksCA: exception : " + e2.getMessage());
                z = false;
            }
        }
        z = true;
        if (!z || o == null) {
            e.k.c.a.a.j.q.i.e(f11941c, " get bks from assets ");
            c(context.getAssets().open("hmsrootcas.bks"));
        }
        String str3 = f11941c;
        e.k.c.a.a.j.q.i.b(str3, "loadBksCA: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    private void c(InputStream inputStream) throws NoSuchAlgorithmException, KeyStoreException, CertificateException, IOException {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f11944f);
            KeyStore keyStore = KeyStore.getInstance("bks");
            keyStore.load(inputStream, "".toCharArray());
            trustManagerFactory.init(keyStore);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            for (int i2 = 0; i2 < trustManagers.length; i2++) {
                if (trustManagers[i2] instanceof X509TrustManager) {
                    this.a.add((X509TrustManager) trustManagers[i2]);
                }
            }
        } finally {
            e.k.c.a.a.j.q.h.g(inputStream);
        }
    }

    private void d(InputStream inputStream, String str) {
        if (inputStream != null && str != null) {
            long currentTimeMillis = System.currentTimeMillis();
            try {
                try {
                    TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(f11944f);
                    KeyStore keyStore = KeyStore.getInstance("bks");
                    keyStore.load(inputStream, str.toCharArray());
                    trustManagerFactory.init(keyStore);
                    TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                    for (int i2 = 0; i2 < trustManagers.length; i2++) {
                        if (trustManagers[i2] instanceof X509TrustManager) {
                            this.a.add((X509TrustManager) trustManagers[i2]);
                        }
                    }
                    e.k.c.a.a.j.q.h.g(inputStream);
                } catch (IOException | KeyStoreException | NoSuchAlgorithmException | CertificateException e2) {
                    String str2 = f11941c;
                    e.k.c.a.a.j.q.i.d(str2, "loadInputStream: exception : " + e2.getMessage());
                }
                String str3 = f11941c;
                e.k.c.a.a.j.q.i.b(str3, "loadInputStream: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
                return;
            } finally {
                e.k.c.a.a.j.q.h.g(inputStream);
            }
        }
        throw new IllegalArgumentException("inputstream or trustPwd is null");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.k.c.a.a.j.q.i.e(f11941c, "checkClientTrusted: ");
        for (X509TrustManager x509TrustManager : this.a) {
            try {
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                return;
            } catch (CertificateException e2) {
                String str2 = f11941c;
                e.k.c.a.a.j.q.i.d(str2, "checkServerTrusted CertificateException" + e2.getMessage());
            }
        }
        throw new CertificateException("checkServerTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        g(x509CertificateArr);
        e.k.c.a.a.j.q.i.e(f11941c, "checkServerTrusted begin ,server ca chain size is : " + x509CertificateArr.length + " ,auth type is : " + str);
        long currentTimeMillis = System.currentTimeMillis();
        for (X509Certificate x509Certificate : x509CertificateArr) {
            String str2 = f11941c;
            e.k.c.a.a.j.q.i.b(str2, "server ca chain: getSubjectDN is :" + x509Certificate.getSubjectDN());
            e.k.c.a.a.j.q.i.b(str2, "IssuerDN :" + x509Certificate.getIssuerDN());
            e.k.c.a.a.j.q.i.b(str2, "SerialNumber : " + x509Certificate.getSerialNumber());
        }
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            try {
                String str3 = f11941c;
                e.k.c.a.a.j.q.i.e(str3, "check server i : " + i2);
                X509TrustManager x509TrustManager = this.a.get(i2);
                X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
                if (acceptedIssuers != null) {
                    e.k.c.a.a.j.q.i.e(str3, "client root ca size is : " + acceptedIssuers.length);
                    for (int i3 = 0; i3 < acceptedIssuers.length; i3++) {
                        e.k.c.a.a.j.q.i.b(f11941c, "client root ca getIssuerDN :" + acceptedIssuers[i3].getIssuerDN());
                    }
                }
                x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                e.k.c.a.a.j.q.i.e(f11941c, "checkServerTrusted succeed ,root ca issuer is : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                return;
            } catch (CertificateException e2) {
                String str4 = f11941c;
                e.k.c.a.a.j.q.i.d(str4, "checkServerTrusted error :" + e2.getMessage() + " , time : " + i2);
                if (i2 == size - 1) {
                    if (x509CertificateArr != null && x509CertificateArr.length > 0) {
                        e.k.c.a.a.j.q.i.d(str4, "root ca issuer : " + x509CertificateArr[x509CertificateArr.length - 1].getIssuerDN());
                    }
                    throw e2;
                }
            }
        }
        e.k.c.a.a.j.q.i.b(f11941c, "checkServerTrusted: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public X509Certificate[] e() {
        return this.b;
    }

    public List<X509TrustManager> f() {
        return this.a;
    }

    public void g(X509Certificate[] x509CertificateArr) {
        this.b = x509CertificateArr;
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager x509TrustManager : this.a) {
                arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            String str = f11941c;
            e.k.c.a.a.j.q.i.d(str, "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }

    public void h(List<X509TrustManager> list) {
        this.a = list;
    }

    public k(Context context, boolean z) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalArgumentException {
        this.a = new ArrayList();
        if (context != null) {
            e.k.c.a.a.j.q.e.b(context);
            if (z) {
                a();
            }
            b(context);
            if (this.a.isEmpty()) {
                throw new CertificateException("X509TrustManager is empty");
            }
            return;
        }
        throw new IllegalArgumentException("context is null");
    }

    public k(InputStream inputStream, String str) throws IllegalArgumentException {
        this.a = new ArrayList();
        d(inputStream, str);
    }

    public k(String str) throws IllegalArgumentException, FileNotFoundException {
        this(str, false);
    }

    public k(String str, boolean z) throws IllegalArgumentException, FileNotFoundException {
        FileInputStream fileInputStream;
        this.a = new ArrayList();
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Throwable th) {
            th = th;
            fileInputStream = null;
        }
        try {
            d(fileInputStream, "");
            e.k.c.a.a.j.q.h.g(fileInputStream);
            if (z) {
                a();
            }
        } catch (Throwable th2) {
            th = th2;
            e.k.c.a.a.j.q.h.g(fileInputStream);
            throw th;
        }
    }

    public k(InputStream inputStream, String str, boolean z) throws IllegalArgumentException {
        this.a = new ArrayList();
        if (z) {
            a();
        }
        d(inputStream, str);
    }
}
