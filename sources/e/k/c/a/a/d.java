package e.k.c.a.a;

import android.content.Context;
import e.k.c.a.a.j.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
/* loaded from: classes2.dex */
public class d extends SSLSocketFactory {

    /* renamed from: c  reason: collision with root package name */
    public static final X509HostnameVerifier f11816c = new BrowserCompatHostnameVerifier();

    /* renamed from: d  reason: collision with root package name */
    public static final X509HostnameVerifier f11817d = new StrictHostnameVerifier();

    /* renamed from: e  reason: collision with root package name */
    private static volatile d f11818e = null;
    private SSLContext a;
    private Context b;

    private d(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException, IllegalAccessException {
        this.a = null;
        this.b = context;
        this.a = f.i();
        this.a.init(null, new X509TrustManager[]{new e(this.b)}, null);
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        f.g(sSLSocket);
        f.f(sSLSocket);
    }

    @Deprecated
    public static d b(Context context) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, IllegalAccessException, KeyManagementException {
        if (f11818e == null) {
            synchronized (d.class) {
                if (f11818e == null) {
                    f11818e = new d(context);
                }
            }
        }
        return f11818e;
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2) throws IOException, UnknownHostException {
        Socket createSocket = this.a.getSocketFactory().createSocket(str, i2);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public String[] getSupportedCipherSuites() {
        return new String[0];
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(String str, int i2, InetAddress inetAddress, int i3) throws IOException, UnknownHostException {
        return createSocket(str, i2);
    }

    @Override // javax.net.SocketFactory
    public Socket createSocket(InetAddress inetAddress, int i2, InetAddress inetAddress2, int i3) throws IOException {
        return createSocket(inetAddress.getHostAddress(), i2);
    }

    @Deprecated
    public d(InputStream inputStream, String str) throws IOException, NoSuchAlgorithmException, CertificateException, KeyStoreException, KeyManagementException {
        this.a = null;
        this.a = f.i();
        this.a.init(null, new X509TrustManager[]{new a(inputStream, str)}, null);
    }

    @Override // javax.net.ssl.SSLSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        if (createSocket instanceof SSLSocket) {
            a(createSocket);
        }
        return createSocket;
    }
}
