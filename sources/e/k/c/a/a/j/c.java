package e.k.c.a.a.j;

import android.content.Context;
import java.io.IOException;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;

/* loaded from: classes2.dex */
public class c extends SSLSocketFactory {

    /* renamed from: i  reason: collision with root package name */
    private static final String f11891i = c.class.getSimpleName();

    /* renamed from: j  reason: collision with root package name */
    private static volatile c f11892j = null;
    private SSLContext a;
    private SSLSocket b;

    /* renamed from: c  reason: collision with root package name */
    private Context f11893c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f11894d;

    /* renamed from: e  reason: collision with root package name */
    private X509TrustManager f11895e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f11896f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f11897g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f11898h;

    private c(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.b = null;
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (e.k.c.a.a.j.q.c.a(this.f11898h)) {
            z = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11891i, "set protocols");
            f.h((SSLSocket) socket, this.f11898h);
            z = true;
        }
        if (e.k.c.a.a.j.q.c.a(this.f11897g) && e.k.c.a.a.j.q.c.a(this.f11896f)) {
            z2 = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11891i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (!e.k.c.a.a.j.q.c.a(this.f11897g)) {
                f.l(sSLSocket, this.f11897g);
            } else {
                f.e(sSLSocket, this.f11896f);
            }
        }
        if (!z) {
            e.k.c.a.a.j.q.i.e(f11891i, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.k.c.a.a.j.q.i.e(f11891i, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    public static void b(X509TrustManager x509TrustManager) {
        e.k.c.a.a.j.q.i.e(f11891i, "sasfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f11892j = new c((KeyStore) null, x509TrustManager);
        } catch (KeyManagementException unused) {
            e.k.c.a.a.j.q.i.d(f11891i, "KeyManagementException");
        } catch (KeyStoreException unused2) {
            e.k.c.a.a.j.q.i.d(f11891i, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused3) {
            e.k.c.a.a.j.q.i.d(f11891i, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused4) {
            e.k.c.a.a.j.q.i.d(f11891i, "UnrecoverableKeyException");
        }
        String str = f11891i;
        e.k.c.a.a.j.q.i.b(str, "sasf system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static c e(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        e.k.c.a.a.j.q.e.b(context);
        if (f11892j == null) {
            synchronized (g.class) {
                if (f11892j == null) {
                    f11892j = new c(keyStore, context);
                }
            }
        }
        return f11892j;
    }

    public String[] c() {
        return this.f11896f;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.k.c.a.a.j.q.i.e(f11891i, "createSocket: socket host port autoClose");
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11894d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public X509Certificate[] d() {
        X509TrustManager x509TrustManager = this.f11895e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public String[] f() {
        return this.f11898h;
    }

    public SSLContext g() {
        return this.a;
    }

    public Context getContext() {
        return this.f11893c;
    }

    public SSLSocket h() {
        return this.b;
    }

    public String[] i() {
        String[] strArr = this.f11894d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] j() {
        return this.f11897g;
    }

    public X509TrustManager k() {
        return this.f11895e;
    }

    public void l(String[] strArr) {
        this.f11896f = strArr;
    }

    public void m(Context context) {
        this.f11893c = context.getApplicationContext();
    }

    public void n(String[] strArr) {
        this.f11898h = strArr;
    }

    public void o(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void p(SSLSocket sSLSocket) {
        this.b = sSLSocket;
    }

    public void q(String[] strArr) {
        this.f11897g = strArr;
    }

    public void r(X509TrustManager x509TrustManager) {
        this.f11895e = x509TrustManager;
    }

    private c(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.b = null;
        if (context == null) {
            e.k.c.a.a.j.q.i.d(f11891i, "SecureSSLSocketFactory: context is null");
            return;
        }
        m(context);
        o(f.i());
        k a = e.a(context);
        this.f11895e = a;
        this.a.init(null, new X509TrustManager[]{a}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.k.c.a.a.j.q.i.e(f11891i, "createSocket: ");
        Socket createSocket = this.a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11894d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public c(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException, UnrecoverableKeyException, KeyStoreException {
        super(keyStore);
        this.b = null;
        this.a = f.i();
        r(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
