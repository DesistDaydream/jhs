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

/* loaded from: classes2.dex */
public class i extends SSLSocketFactory {

    /* renamed from: i  reason: collision with root package name */
    private static final String f11933i = i.class.getSimpleName();

    /* renamed from: j  reason: collision with root package name */
    private static volatile i f11934j = null;
    public SSLContext a;
    public SSLSocket b;

    /* renamed from: c  reason: collision with root package name */
    public Context f11935c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f11936d;

    /* renamed from: e  reason: collision with root package name */
    public X509TrustManager f11937e;

    /* renamed from: f  reason: collision with root package name */
    public String[] f11938f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f11939g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f11940h;

    public i(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.b = null;
        this.a = f.i();
        a aVar = new a(inputStream, str);
        o(aVar);
        this.a.init(null, new X509TrustManager[]{aVar}, null);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (e.k.c.a.a.j.q.c.a(this.f11940h)) {
            z = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11933i, "set protocols");
            f.h((SSLSocket) socket, this.f11940h);
            z = true;
        }
        if (e.k.c.a.a.j.q.c.a(this.f11939g) && e.k.c.a.a.j.q.c.a(this.f11938f)) {
            z2 = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11933i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (!e.k.c.a.a.j.q.c.a(this.f11939g)) {
                f.l(sSLSocket, this.f11939g);
            } else {
                f.e(sSLSocket, this.f11938f);
            }
        }
        if (!z) {
            e.k.c.a.a.j.q.i.e(f11933i, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.k.c.a.a.j.q.i.e(f11933i, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    public static i d(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException, IllegalArgumentException {
        long currentTimeMillis = System.currentTimeMillis();
        e.k.c.a.a.j.q.e.b(context);
        if (f11934j == null) {
            synchronized (i.class) {
                if (f11934j == null) {
                    f11934j = new i(context);
                }
            }
        }
        if (f11934j.f11935c == null && context != null) {
            f11934j.k(context);
        }
        String str = f11933i;
        e.k.c.a.a.j.q.i.b(str, "getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return f11934j;
    }

    public String[] b() {
        return this.f11938f;
    }

    public X509Certificate[] c() {
        X509TrustManager x509TrustManager = this.f11937e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.k.c.a.a.j.q.i.e(f11933i, "createSocket: host , port");
        Socket createSocket = this.a.getSocketFactory().createSocket(str, i2);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11936d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public String[] e() {
        return this.f11940h;
    }

    public SSLContext f() {
        return this.a;
    }

    public SSLSocket g() {
        return this.b;
    }

    public Context getContext() {
        return this.f11935c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f11936d;
        return strArr != null ? strArr : new String[0];
    }

    public String[] h() {
        return this.f11939g;
    }

    public X509TrustManager i() {
        return this.f11937e;
    }

    public void j(String[] strArr) {
        this.f11938f = strArr;
    }

    public void k(Context context) {
        this.f11935c = context.getApplicationContext();
    }

    public void l(String[] strArr) {
        this.f11940h = strArr;
    }

    public void m(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void n(String[] strArr) {
        this.f11939g = strArr;
    }

    public void o(X509TrustManager x509TrustManager) {
        this.f11937e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    private i(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.a = null;
        this.b = null;
        if (context == null) {
            e.k.c.a.a.j.q.i.d(f11933i, "SecureSSLSocketFactory: context is null");
            return;
        }
        k(context);
        m(f.i());
        k a = j.a(context);
        this.f11937e = a;
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
        e.k.c.a.a.j.q.i.e(f11933i, "createSocket s host port autoClose");
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11936d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public i(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.b = null;
        this.a = f.i();
        o(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }
}
