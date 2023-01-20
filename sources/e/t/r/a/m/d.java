package e.t.r.a.m;

import android.annotation.SuppressLint;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import okhttp3.OkHttpClient;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/vector/network/image/https/UnsafeOkHttpClient;", "", "()V", "getUnsafeOkHttpClient", "Lokhttp3/OkHttpClient;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    public static final d a = new d();

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ#\u0010\n\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016¢\u0006\u0002\u0010\tJ\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"com/vector/network/image/https/UnsafeOkHttpClient$getUnsafeOkHttpClient$trustAllCerts$1", "Ljavax/net/ssl/X509TrustManager;", "checkClientTrusted", "", "chain", "", "Ljava/security/cert/X509Certificate;", "authType", "", "([Ljava/security/cert/X509Certificate;Ljava/lang/String;)V", "checkServerTrusted", "getAcceptedIssuers", "()[Ljava/security/cert/X509Certificate;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements X509TrustManager {
        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(@k.e.a.d X509Certificate[] x509CertificateArr, @k.e.a.d String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(@k.e.a.d X509Certificate[] x509CertificateArr, @k.e.a.d String str) throws CertificateException {
        }

        @Override // javax.net.ssl.X509TrustManager
        @k.e.a.d
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    private d() {
    }

    @SuppressLint({"TrustAllX509TrustManager"})
    @k.e.a.d
    public final OkHttpClient a() {
        try {
            TrustManager[] trustManagerArr = {new a()};
            SSLContext sSLContext = SSLContext.getInstance("SSL");
            sSLContext.init(null, trustManagerArr, new SecureRandom());
            SSLSocketFactory socketFactory = sSLContext.getSocketFactory();
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            builder.sslSocketFactory(socketFactory, (X509TrustManager) trustManagerArr[0]);
            builder.hostnameVerifier(new e.t.r.a.m.a());
            return builder.build();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
