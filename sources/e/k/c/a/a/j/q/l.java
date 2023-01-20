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
public class l {
    private static final String b = "X509CertificateUtil";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11978c = "hmsrootcas.bks";

    /* renamed from: d  reason: collision with root package name */
    public static final String f11979d = "";

    /* renamed from: e  reason: collision with root package name */
    public static final String f11980e = "bks";

    /* renamed from: f  reason: collision with root package name */
    public static final String f11981f = "052root";

    /* renamed from: g  reason: collision with root package name */
    private static final String f11982g = "hmsincas.bks";

    /* renamed from: h  reason: collision with root package name */
    private static final String f11983h = "huawei cbg application integration ca";
    private Context a;

    public l(Context context) {
        this.a = context;
    }

    public X509Certificate a() {
        return b(f11982g, f11983h);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7 */
    public X509Certificate b(String str, String str2) {
        InputStream inputStream;
        KeyStore keyStore;
        InputStream inputStream2 = null;
        X509Certificate x509Certificate = null;
        try {
            try {
                keyStore = KeyStore.getInstance(f11980e);
                inputStream = this.a.getAssets().open(str);
            } catch (IOException e2) {
                e = e2;
                inputStream = null;
                i.d(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                h.g(str);
                return x509Certificate;
            } catch (KeyStoreException e3) {
                e = e3;
                inputStream = null;
                i.d(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                h.g(str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e4) {
                e = e4;
                inputStream = null;
                i.d(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                h.g(str);
                return x509Certificate;
            } catch (CertificateException e5) {
                e = e5;
                inputStream = null;
                i.d(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                h.g(str);
                return x509Certificate;
            } catch (Throwable th) {
                th = th;
                h.g(inputStream2);
                throw th;
            }
            try {
                inputStream.reset();
                keyStore.load(inputStream, "".toCharArray());
                x509Certificate = (X509Certificate) keyStore.getCertificate(str2);
                str = inputStream;
            } catch (IOException e6) {
                e = e6;
                i.d(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                h.g(str);
                return x509Certificate;
            } catch (KeyStoreException e7) {
                e = e7;
                i.d(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                h.g(str);
                return x509Certificate;
            } catch (NoSuchAlgorithmException e8) {
                e = e8;
                i.d(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                h.g(str);
                return x509Certificate;
            } catch (CertificateException e9) {
                e = e9;
                i.d(b, "loadBksCA: exception : " + e.getMessage());
                str = inputStream;
                h.g(str);
                return x509Certificate;
            }
            h.g(str);
            return x509Certificate;
        } catch (Throwable th2) {
            th = th2;
            inputStream2 = str;
            h.g(inputStream2);
            throw th;
        }
    }

    public X509Certificate c() {
        return b("hmsrootcas.bks", f11981f);
    }
}
