package e.k.c.a.a.j;

import android.content.Context;
import java.io.IOException;
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
public class d extends SSLSocketFactory {

    /* renamed from: i  reason: collision with root package name */
    private static final String f11899i = d.class.getSimpleName();

    /* renamed from: j  reason: collision with root package name */
    private static volatile d f11900j = null;
    private SSLContext a;
    private SSLSocket b;

    /* renamed from: c  reason: collision with root package name */
    private Context f11901c;

    /* renamed from: d  reason: collision with root package name */
    private String[] f11902d;

    /* renamed from: e  reason: collision with root package name */
    private X509TrustManager f11903e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f11904f;

    /* renamed from: g  reason: collision with root package name */
    private String[] f11905g;

    /* renamed from: h  reason: collision with root package name */
    private String[] f11906h;

    private d(Context context) throws NoSuchAlgorithmException, CertificateException, KeyStoreException, IOException, KeyManagementException {
        this.a = null;
        this.b = null;
        if (context == null) {
            e.k.c.a.a.j.q.i.d(f11899i, "SecureSSLSocketFactory: context is null");
            return;
        }
        l(context);
        n(f.i());
        k a = e.a(context);
        this.f11903e = a;
        this.a.init(null, new X509TrustManager[]{a}, null);
    }

    private void a(Socket socket) {
        boolean z;
        boolean z2 = true;
        if (e.k.c.a.a.j.q.c.a(this.f11906h)) {
            z = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11899i, "set protocols");
            f.h((SSLSocket) socket, this.f11906h);
            z = true;
        }
        if (e.k.c.a.a.j.q.c.a(this.f11905g) && e.k.c.a.a.j.q.c.a(this.f11904f)) {
            z2 = false;
        } else {
            e.k.c.a.a.j.q.i.e(f11899i, "set white cipher or black cipher");
            SSLSocket sSLSocket = (SSLSocket) socket;
            f.g(sSLSocket);
            if (!e.k.c.a.a.j.q.c.a(this.f11905g)) {
                f.l(sSLSocket, this.f11905g);
            } else {
                f.e(sSLSocket, this.f11904f);
            }
        }
        if (!z) {
            e.k.c.a.a.j.q.i.e(f11899i, "set default protocols");
            f.g((SSLSocket) socket);
        }
        if (z2) {
            return;
        }
        e.k.c.a.a.j.q.i.e(f11899i, "set default cipher suites");
        f.f((SSLSocket) socket);
    }

    public static void b(X509TrustManager x509TrustManager) {
        e.k.c.a.a.j.q.i.e(f11899i, "ssfc update socket factory trust manager");
        long currentTimeMillis = System.currentTimeMillis();
        try {
            f11900j = new d(x509TrustManager);
        } catch (KeyManagementException unused) {
            e.k.c.a.a.j.q.i.d(f11899i, "KeyManagementException");
        } catch (NoSuchAlgorithmException unused2) {
            e.k.c.a.a.j.q.i.d(f11899i, "NoSuchAlgorithmException");
        }
        String str = f11899i;
        e.k.c.a.a.j.q.i.b(str, "SSF system ca update: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }

    public static d e(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalArgumentException {
        e.k.c.a.a.j.q.e.b(context);
        if (f11900j == null) {
            synchronized (d.class) {
                if (f11900j == null) {
                    f11900j = new d(context);
                }
            }
        }
        if (f11900j.f11901c == null && context != null) {
            f11900j.l(context);
        }
        return f11900j;
    }

    public String[] c() {
        return this.f11904f;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException {
        e.k.c.a.a.j.q.i.e(f11899i, "createSocket: host , port");
        Socket createSocket = this.a.getSocketFactory().createSocket(str, i2);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11902d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }

    public X509Certificate[] d() {
        X509TrustManager x509TrustManager = this.f11903e;
        return x509TrustManager instanceof k ? ((k) x509TrustManager).e() : new X509Certificate[0];
    }

    public String[] f() {
        return this.f11906h;
    }

    public SSLContext g() {
        return this.a;
    }

    public Context getContext() {
        return this.f11901c;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        String[] strArr = this.f11902d;
        return strArr != null ? strArr : new String[0];
    }

    public SSLSocket h() {
        return this.b;
    }

    public String[] i() {
        return this.f11905g;
    }

    public X509TrustManager j() {
        return this.f11903e;
    }

    public void k(String[] strArr) {
        this.f11904f = strArr;
    }

    public void l(Context context) {
        this.f11901c = context.getApplicationContext();
    }

    public void m(String[] strArr) {
        this.f11906h = strArr;
    }

    public void n(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void o(String[] strArr) {
        this.f11905g = strArr;
    }

    public void p(X509TrustManager x509TrustManager) {
        this.f11903e = x509TrustManager;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return createSocket(str, i2);
    }

    public d(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException, IllegalArgumentException {
        this.a = null;
        this.b = null;
        this.a = f.i();
        p(x509TrustManager);
        this.a.init(null, new X509TrustManager[]{x509TrustManager}, null);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        e.k.c.a.a.j.q.i.e(f11899i, "createSocket: s , host , port , autoClose");
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
            SSLSocket sSLSocket = (SSLSocket) createSocket;
            this.b = sSLSocket;
            this.f11902d = (String[]) sSLSocket.getEnabledCipherSuites().clone();
        }
        return createSocket;
    }
}
