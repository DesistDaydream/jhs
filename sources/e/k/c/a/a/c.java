package e.k.c.a.a;

import android.content.Context;
import e.k.c.a.a.j.f;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

@Deprecated
/* loaded from: classes2.dex */
public class c extends SSLSocketFactory {

    /* renamed from: c  reason: collision with root package name */
    public static final X509HostnameVerifier f11813c = new BrowserCompatHostnameVerifier();

    /* renamed from: d  reason: collision with root package name */
    public static final X509HostnameVerifier f11814d = new StrictHostnameVerifier();

    /* renamed from: e  reason: collision with root package name */
    private static volatile c f11815e = null;
    private SSLContext a;
    private Context b;

    private c(KeyStore keyStore) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException {
        super(keyStore);
    }

    private void a(Socket socket) {
        SSLSocket sSLSocket = (SSLSocket) socket;
        f.g(sSLSocket);
        f.f(sSLSocket);
    }

    @Deprecated
    public static c b(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        if (f11815e == null) {
            synchronized (c.class) {
                if (f11815e == null) {
                    f11815e = new c(keyStore, context);
                }
            }
        }
        return f11815e;
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.LayeredSocketFactory
    public Socket createSocket(Socket socket, String str, int i2, boolean z) throws IOException {
        Socket createSocket = this.a.getSocketFactory().createSocket(socket, str, i2, z);
        a(createSocket);
        return createSocket;
    }

    private c(KeyStore keyStore, Context context) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException, IllegalAccessException {
        super(keyStore);
        this.b = context;
        this.a = f.i();
        this.a.init(null, new X509TrustManager[]{new e(this.b)}, null);
    }

    @Override // org.apache.http.conn.ssl.SSLSocketFactory, org.apache.http.conn.scheme.SocketFactory
    public Socket createSocket() throws IOException {
        Socket createSocket = this.a.getSocketFactory().createSocket();
        a(createSocket);
        return createSocket;
    }

    @Deprecated
    public c(KeyStore keyStore, InputStream inputStream, String str) throws NoSuchAlgorithmException, KeyManagementException, KeyStoreException, UnrecoverableKeyException, CertificateException, IOException {
        super(keyStore);
        this.a = f.i();
        this.a.init(null, new X509TrustManager[]{new a(inputStream, str)}, null);
    }
}
