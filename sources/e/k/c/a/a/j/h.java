package e.k.c.a.a.j;

import android.content.Context;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
/* loaded from: classes2.dex */
public class h extends SSLSocketFactory {
    @Deprecated

    /* renamed from: i  reason: collision with root package name */
    public static final X509HostnameVerifier f11923i = new BrowserCompatHostnameVerifier();
    @Deprecated

    /* renamed from: j  reason: collision with root package name */
    public static final X509HostnameVerifier f11924j = new StrictHostnameVerifier();

    /* renamed from: k  reason: collision with root package name */
    private static final String f11925k = h.class.getSimpleName();

    /* renamed from: l  reason: collision with root package name */
    private static volatile h f11926l = null;
    private SSLContext a;
    private SSLSocket b;

    /* renamed from: c  reason: collision with root package name */
    private Context f11927c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f11928d;

    /* renamed from: e  reason: collision with root package name */
    private X509TrustManager f11929e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f11930f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f11931g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f11932h;

    public h(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.b = null;
        this.a = f.i();
        a aVar = new a(inputStream, str);
        p(aVar);
        this.a.init(null, new X509TrustManager[]{aVar}, null);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (e.k.c.a.a.j.q.c.a(this.f11932h)) {
            z = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11925k, "set protocols");
            f.h((SSLSocket) socket, this.f11932h);
            z = true;
        }
        if (e.k.c.a.a.j.q.c.a(this.f11931g) && e.k.c.a.a.j.q.c.a(this.f11930f)) {
            z2 = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11925k, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (!e.k.c.a.a.j.q.c.a(this.f11931g)) {
                f.l(sSLSocket, this.f11931g);
            } else {
                f.e(sSLSocket, this.f11930f);
            }
        }
        if (!z) {
            e.k.c.a.a.j.q.i.e(f11925k, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.k.c.a.a.j.q.i.e(f11925k, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    public static void b(X509TrustManager x509TrustManager) {
        e.k.c.a.a.j.q.i.e(f11925k, "ssf update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f11926l = new h(x509TrustManager);
        } catch (KeyManagementException unused) {
            e.k.c.a.a.j.q.i.d(f11925k, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.k.c.a.a.j.q.i.d(f11925k, "NoSuchAlgorithmException");
        }
        String str = f11925k;
        e.k.c.a.a.j.q.i.b(str, "update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static h e(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        e.k.c.a.a.j.q.e.b(context);
        if (f11926l == null) {
            synchronized (h.class) {
                if (f11926l == null) {
                    f11926l = new h(context);
                }
            }
        }
        if (f11926l.f11927c == null && context != null) {
            f11926l.l(context);
        }
        String str = f11925k;
        e.k.c.a.a.j.q.i.b(str, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f11926l;
    }

    public String[] c() {
        return this.f11930f;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.k.c.a.a.j.q.i.e(f11925k, "createSocket: host , port");
        Socket createSocket = this.a.getSocketFactory().createSocket(str, i2);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11928d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public X509Certificate[] d() {
        X509TrustManager x509TrustManager = this.f11929e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public String[] f() {
        return this.f11932h;
    }

    public SSLContext g() {
        return this.a;
    }

    public Context getContext() {
        return this.f11927c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f11928d;
        return strArr != null ? strArr : new String[0];
    }

    public SSLSocket h() {
        return this.b;
    }

    public String[] i() {
        return this.f11931g;
    }

    public X509TrustManager j() {
        return this.f11929e;
    }

    public void k(String[] strArr) {
        this.f11930f = strArr;
    }

    public void l(Context context) {
        this.f11927c = context.getApplicationContext();
    }

    public void m(String[] strArr) {
        this.f11932h = strArr;
    }

    public void n(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void o(String[] strArr) {
        this.f11931g = strArr;
    }

    public void p(X509TrustManager x509TrustManager) {
        this.f11929e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    private h(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.a = null;
        this.b = null;
        if (context == null) {
            e.k.c.a.a.j.q.i.d(f11925k, "SecureSSLSocketFactory: context is null");
            return;
        }
        l(context);
        n(f.i());
        k a = j.a(context);
        this.f11929e = a;
        this.a.init(null, new X509TrustManager[]{a}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.k.c.a.a.j.q.i.e(f11925k, "createSocket s host port autoClose");
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11928d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public h(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.b = null;
        this.a = f.i();
        p(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
