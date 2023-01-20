package e.k.c.a.a.j.q;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/* loaded from: classes2.dex */
public final class b {
    private static final String a = "CertificateUtil";

    private b() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.io.InputStream] */
    public static X509Certificate a(Context context) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(l.f11980e);
                inputStream = context.getAssets().open("hmsrootcas.bks");
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                i.d(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                h.g(context);
                return x509Certificate;
            } catch (KeyStoreException e3) {
                e = e3;
                inputStream = null;
                i.d(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                h.g(context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                inputStream = null;
                i.d(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                h.g(context);
                return x509Certificate;
            } catch (CertificateException e5) {
                e = e5;
                inputStream = null;
                i.d(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                h.g(context);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                h.g(inputStream2);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(l.f11981f);
                context = inputStream;
            } catch (IOException e6) {
                e = e6;
                i.d(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                h.g(context);
                return x509Certificate;
            } catch (KeyStoreException e7) {
                e = e7;
                i.d(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                h.g(context);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                i.d(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                h.g(context);
                return x509Certificate;
            } catch (CertificateException e9) {
                e = e9;
                i.d(a, "loadBksCA: exception : " + e.getMessage());
                context = inputStream;
                h.g(context);
                return x509Certificate;
            }
            h.g(context);
            return x509Certificate;
        } catch (Throwable th2) {
            inputStream2 = context;
            th = th2;
            h.g(inputStream2);
            throw th;
        }
    }
}
