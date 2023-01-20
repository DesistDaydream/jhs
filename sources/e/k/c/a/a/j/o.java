package e.k.c.a.a.j;

import android.content.Context;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes2.dex */
public class o implements X509TrustManager {

    /* renamed from: c  reason: collision with root package name */
    private static final String f11961c = "WebViewX509TrustManger";
    private X509Certificate a;
    private List<X509TrustManager> b = new ArrayList();

    public o(Context context) {
        Objects.requireNonNull(context, "WebViewX509TrustManger context is null");
        e.k.c.a.a.j.q.e.b(context);
        X509Certificate c2 = new e.k.c.a.a.j.q.l(context).c();
        this.a = c2;
        Objects.requireNonNull(c2, "WebViewX509TrustManger cannot get cbg root ca");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.k.c.a.a.j.q.i.e(f11961c, "checkClientTrusted");
        if (!this.b.isEmpty()) {
            this.b.get(0).checkClientTrusted(x509CertificateArr, str);
            return;
        }
        throw new CertificateException("checkClientTrusted CertificateException");
    }

    @Override // javax.net.ssl.X509TrustManager
    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        e.k.c.a.a.j.q.i.e(f11961c, "checkServerTrusted");
        boolean z = false;
        for (int i2 = 0; i2 < x509CertificateArr.length; i2++) {
            e.k.c.a.a.j.q.i.b(f11961c, "checkServerTrusted " + i2 + " : " + x509CertificateArr[i2].getIssuerDN().getName());
        }
        X509Certificate[] x509CertificateArr2 = new X509Certificate[x509CertificateArr.length];
        for (int i3 = 0; i3 < x509CertificateArr.length; i3++) {
            x509CertificateArr2[i3] = x509CertificateArr[(x509CertificateArr.length - 1) - i3];
        }
        CertificateException e2 = new CertificateException("CBG root CA CertificateException");
        try {
            z = e.k.c.a.a.j.q.d.f(this.a, x509CertificateArr2);
        } catch (InvalidKeyException e3) {
            e.k.c.a.a.j.q.i.d(f11961c, "checkServerTrusted InvalidKeyException: " + e3.getMessage());
        } catch (NoSuchAlgorithmException e4) {
            e.k.c.a.a.j.q.i.d(f11961c, "checkServerTrusted NoSuchAlgorithmException: " + e4.getMessage());
        } catch (NoSuchProviderException e5) {
            e.k.c.a.a.j.q.i.d(f11961c, "checkServerTrusted NoSuchProviderException: " + e5.getMessage());
        } catch (SignatureException e6) {
            e.k.c.a.a.j.q.i.d(f11961c, "checkServerTrusted SignatureException: " + e6.getMessage());
        } catch (CertificateException e7) {
            e2 = e7;
            e.k.c.a.a.j.q.i.d(f11961c, "checkServerTrusted CertificateException: " + e2.getMessage());
        }
        if (!z) {
            throw e2;
        }
    }

    @Override // javax.net.ssl.X509TrustManager
    public X509Certificate[] getAcceptedIssuers() {
        try {
            ArrayList arrayList = new ArrayList();
            for (X509TrustManager x509TrustManager : this.b) {
                arrayList.addAll(Arrays.asList(x509TrustManager.getAcceptedIssuers()));
            }
            return (X509Certificate[]) arrayList.toArray(new X509Certificate[arrayList.size()]);
        } catch (Exception e2) {
            e.k.c.a.a.j.q.i.d(f11961c, "getAcceptedIssuers exception : " + e2.getMessage());
            return new X509Certificate[0];
        }
    }
}
