package e.k.c.a.a.j;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
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
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

/* loaded from: classes2.dex */
public class g extends SSLSocketFactory {

    /* renamed from: i  reason: collision with root package name */
    public static final X509HostnameVerifier f11913i = new BrowserCompatHostnameVerifier();

    /* renamed from: j  reason: collision with root package name */
    public static final X509HostnameVerifier f11914j = new StrictHostnameVerifier();

    /* renamed from: k  reason: collision with root package name */
    private static final String f11915k = g.class.getSimpleName();

    /* renamed from: l  reason: collision with root package name */
    private static volatile g f11916l = null;
    private SSLContext a;
    private SSLSocket b;

    /* renamed from: c  reason: collision with root package name */
    private Context f11917c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f11918d;

    /* renamed from: e  reason: collision with root package name */
    private X509TrustManager f11919e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f11920f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f11921g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f11922h;

    private g(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
        this.b = null;
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (e.k.c.a.a.j.q.c.a(this.f11922h)) {
            z = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11915k, "set protocols");
            f.h((SSLSocket) socket, this.f11922h);
            z = true;
        }
        if (e.k.c.a.a.j.q.c.a(this.f11921g) && e.k.c.a.a.j.q.c.a(this.f11920f)) {
            z2 = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11915k, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (!e.k.c.a.a.j.q.c.a(this.f11921g)) {
                f.l(sSLSocket, this.f11921g);
            } else {
                f.e(sSLSocket, this.f11920f);
            }
        }
        if (!z) {
            e.k.c.a.a.j.q.i.e(f11915k, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.k.c.a.a.j.q.i.e(f11915k, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    public static void b(X509TrustManager x509TrustManager) {
        e.k.c.a.a.j.q.i.e(f11915k, "sasf update socket factory trust manager");
        try {
            f11916l = new g((KeyStore) null, x509TrustManager);
        } catch (IOException unused) {
            e.k.c.a.a.j.q.i.d(f11915k, "IOException");
        } catch (KeyManagementException unused2) {
            e.k.c.a.a.j.q.i.d(f11915k, "KeyManagementException");
        } catch (KeyStoreException unused3) {
            e.k.c.a.a.j.q.i.d(f11915k, "KeyStoreException");
        } catch (NoSuchAlgorithmException unused4) {
            e.k.c.a.a.j.q.i.d(f11915k, "NoSuchAlgorithmException");
        } catch (UnrecoverableKeyException unused5) {
            e.k.c.a.a.j.q.i.d(f11915k, "UnrecoverableKeyException");
        } catch (CertificateException unused6) {
            e.k.c.a.a.j.q.i.d(f11915k, "CertificateException");
        }
    }

    public static g e(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        e.k.c.a.a.j.q.e.b(context);
        if (f11916l == null) {
            synchronized (g.class) {
                if (f11916l == null) {
                    f11916l = new g(keyStore, context);
                }
            }
        }
        return f11916l;
    }

    public String[] c() {
        return this.f11920f;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.k.c.a.a.j.q.i.e(f11915k, "createSocket: socket host port autoClose");
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11918d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public X509Certificate[] d() {
        X509TrustManager x509TrustManager = this.f11919e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public String[] f() {
        return this.f11922h;
    }

    public SSLContext g() {
        return this.a;
    }

    public Context getContext() {
        return this.f11917c;
    }

    public SSLSocket h() {
        return this.b;
    }

    public String[] i() {
        String[] strArr = this.f11918d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] j() {
        return this.f11921g;
    }

    public X509TrustManager k() {
        return this.f11919e;
    }

    public void l(String[] strArr) {
        this.f11920f = strArr;
    }

    public void m(Context context) {
        this.f11917c = context.getApplicationContext();
    }

    public void n(String[] strArr) {
        this.f11922h = strArr;
    }

    public void o(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void p(SSLSocket sSLSocket) {
        this.b = sSLSocket;
    }

    public void q(String[] strArr) {
        this.f11921g = strArr;
    }

    public void r(X509TrustManager x509TrustManager) {
        this.f11919e = x509TrustManager;
    }

    private g(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.b = null;
        if (context == null) {
            e.k.c.a.a.j.q.i.d(f11915k, "SecureSSLSocketFactory: context is null");
            return;
        }
        m(context);
        o(f.i());
        k a = j.a(context);
        this.f11919e = a;
        this.a.init(null, new X509TrustManager[]{a}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        e.k.c.a.a.j.q.i.e(f11915k, "createSocket: ");
        Socket createSocket = this.a.getSocketFactory().createSocket();
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11918d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public g(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.b = null;
        this.a = f.i();
        a aVar = new a(inputStream, str);
        r(aVar);
        this.a.init(null, new X509TrustManager[]{aVar}, null);
    }

    public g(KeyStore keyStore, X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalArgumentException {
        super(keyStore);
        this.b = null;
        this.a = f.i();
        r(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
