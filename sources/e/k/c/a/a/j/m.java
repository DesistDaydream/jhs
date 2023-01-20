package e.k.c.a.a.j;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.bytedance.msdk.api.AdError;
import com.moor.imkf.lib.socket.java_websocket.WebSocketImpl;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

/* loaded from: classes2.dex */
public class m extends Thread {

    /* renamed from: i  reason: collision with root package name */
    private static final String f11947i = m.class.getSimpleName();
    private SSLSocketFactory a;
    private HostnameVerifier b;

    /* renamed from: c  reason: collision with root package name */
    private org.apache.http.conn.ssl.SSLSocketFactory f11948c;

    /* renamed from: d  reason: collision with root package name */
    private X509HostnameVerifier f11949d;

    /* renamed from: e  reason: collision with root package name */
    private SslErrorHandler f11950e;

    /* renamed from: f  reason: collision with root package name */
    private String f11951f;

    /* renamed from: g  reason: collision with root package name */
    private a f11952g;

    /* renamed from: h  reason: collision with root package name */
    private Context f11953h;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Context context, String str);

        void b(Context context, String str);
    }

    /* loaded from: classes2.dex */
    public static class b implements Callback {
        public final /* synthetic */ a a;
        public final /* synthetic */ Context b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f11954c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ SslErrorHandler f11955d;

        public b(a aVar, Context context, String str, SslErrorHandler sslErrorHandler) {
            this.a = aVar;
            this.b = context;
            this.f11954c = str;
            this.f11955d = sslErrorHandler;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            String str = m.f11947i;
            e.k.c.a.a.j.q.i.d(str, "onFailure , IO Exception : " + iOException.getMessage());
            a aVar = this.a;
            if (aVar != null) {
                aVar.b(this.b, this.f11954c);
            } else {
                this.f11955d.cancel();
            }
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws IOException {
            e.k.c.a.a.j.q.i.d(m.f11947i, "onResponse . proceed");
            a aVar = this.a;
            if (aVar != null) {
                aVar.a(this.b, this.f11954c);
            } else {
                this.f11955d.proceed();
            }
        }
    }

    public m() {
    }

    private void b() {
        String str = f11947i;
        e.k.c.a.a.j.q.i.e(str, "callbackCancel: ");
        a aVar = this.f11952g;
        if (aVar != null) {
            aVar.b(this.f11953h, this.f11951f);
        } else if (this.f11950e != null) {
            e.k.c.a.a.j.q.i.e(str, "callbackCancel 2: ");
            this.f11950e.cancel();
        }
    }

    private void c() {
        e.k.c.a.a.j.q.i.e(f11947i, "callbackProceed: ");
        a aVar = this.f11952g;
        if (aVar != null) {
            aVar.a(this.f11953h, this.f11951f);
            return;
        }
        SslErrorHandler sslErrorHandler = this.f11950e;
        if (sslErrorHandler != null) {
            sslErrorHandler.proceed();
        }
    }

    public static void d(SslErrorHandler sslErrorHandler, String str, Context context) {
        e(sslErrorHandler, str, context, null);
    }

    public static void e(SslErrorHandler sslErrorHandler, String str, Context context, a aVar) {
        if (sslErrorHandler != null && !TextUtils.isEmpty(str) && context != null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            try {
                i iVar = new i(new o(context));
                iVar.k(context);
                builder.sslSocketFactory(iVar, new o(context));
                builder.hostnameVerifier(new e.k.c.a.a.j.p.b());
                builder.build().newCall(new Request.Builder().url(str).build()).enqueue(new b(aVar, context, str, sslErrorHandler));
                return;
            } catch (Exception e2) {
                String str2 = f11947i;
                e.k.c.a.a.j.q.i.d(str2, "checkServerCertificateWithOK: exception : " + e2.getMessage());
                sslErrorHandler.cancel();
                return;
            }
        }
        e.k.c.a.a.j.q.i.d(f11947i, "checkServerCertificateWithOK: handler or url or context is null");
    }

    public X509HostnameVerifier f() {
        return this.f11949d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory g() {
        return this.f11948c;
    }

    public Context getContext() {
        return this.f11953h;
    }

    public a h() {
        return this.f11952g;
    }

    public HostnameVerifier i() {
        return this.b;
    }

    public SslErrorHandler j() {
        return this.f11950e;
    }

    public SSLSocketFactory k() {
        return this.a;
    }

    public String l() {
        return this.f11951f;
    }

    public void m(X509HostnameVerifier x509HostnameVerifier) {
        this.f11949d = x509HostnameVerifier;
    }

    public void n(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.f11948c = sSLSocketFactory;
    }

    public void o(a aVar) {
        this.f11952g = aVar;
    }

    public void p(Context context) {
        this.f11953h = context;
    }

    public void q(HostnameVerifier hostnameVerifier) {
        this.b = hostnameVerifier;
    }

    public void r(SslErrorHandler sslErrorHandler) {
        this.f11950e = sslErrorHandler;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [javax.net.ssl.HostnameVerifier] */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        Exception e2;
        HttpsURLConnection httpsURLConnection;
        super.run();
        HttpsURLConnection httpsURLConnection2 = null;
        if (this.f11948c != null && this.f11949d != null) {
            if (this.f11950e != null) {
                try {
                    if (!TextUtils.isEmpty(this.f11951f)) {
                        try {
                            this.f11948c.setHostnameVerifier(this.f11949d);
                            org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory = this.f11948c;
                            if (sSLSocketFactory instanceof g) {
                                ((g) sSLSocketFactory).m(this.f11953h);
                            }
                            BasicHttpParams basicHttpParams = new BasicHttpParams();
                            HttpConnectionParams.setConnectionTimeout(basicHttpParams, 30000);
                            HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
                            SchemeRegistry schemeRegistry = new SchemeRegistry();
                            schemeRegistry.register(new Scheme("https", this.f11948c, (int) WebSocketImpl.DEFAULT_WSS_PORT));
                            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
                            DefaultHttpClient defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams, schemeRegistry), basicHttpParams);
                            HttpGet httpGet = new HttpGet();
                            httpGet.setURI(new URI(this.f11951f));
                            HttpResponse execute = defaultHttpClient.execute(httpGet);
                            e.k.c.a.a.j.q.i.e(f11947i, "status code is : " + execute.getStatusLine().getStatusCode());
                            e.k.c.a.a.j.q.h.i(null);
                            c();
                            return;
                        } catch (Exception e3) {
                            e.k.c.a.a.j.q.i.d(f11947i, "run: exception : " + e3.getMessage());
                            b();
                            e.k.c.a.a.j.q.h.i(null);
                            return;
                        }
                    }
                } catch (Throwable th) {
                    e.k.c.a.a.j.q.h.i(null);
                    throw th;
                }
            }
            e.k.c.a.a.j.q.i.d(f11947i, "sslErrorHandler or url is null");
            b();
            return;
        }
        if (this.a != null) {
            HttpsURLConnection httpsURLConnection3 = this.b;
            try {
                if (httpsURLConnection3 != 0) {
                    try {
                        URLConnection openConnection = new URL(this.f11951f).openConnection();
                        if (openConnection instanceof HttpsURLConnection) {
                            httpsURLConnection = (HttpsURLConnection) openConnection;
                            try {
                                httpsURLConnection.setSSLSocketFactory(this.a);
                                httpsURLConnection.setHostnameVerifier(this.b);
                                httpsURLConnection.setRequestMethod("GET");
                                httpsURLConnection.setConnectTimeout(10000);
                                httpsURLConnection.setReadTimeout(AdError.ERROR_CODE_AD_LOAD_SUCCESS);
                                httpsURLConnection.connect();
                                httpsURLConnection2 = httpsURLConnection;
                            } catch (Exception e4) {
                                e2 = e4;
                                e.k.c.a.a.j.q.i.d(f11947i, "exception : " + e2.getMessage());
                                b();
                                if (httpsURLConnection != null) {
                                    httpsURLConnection.disconnect();
                                    return;
                                }
                                return;
                            }
                        }
                        if (httpsURLConnection2 != null) {
                            httpsURLConnection2.disconnect();
                        }
                        c();
                        return;
                    } catch (Exception e5) {
                        e2 = e5;
                        httpsURLConnection = null;
                    } catch (Throwable th2) {
                        th = th2;
                        httpsURLConnection3 = 0;
                        if (httpsURLConnection3 != 0) {
                            httpsURLConnection3.disconnect();
                        }
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        b();
    }

    public void s(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    public void t(String str) {
        this.f11951f = str;
    }

    public m(SslErrorHandler sslErrorHandler, String str, Context context) throws CertificateException, NoSuchAlgorithmException, IOException, KeyManagementException, KeyStoreException, IllegalAccessException {
        r(sslErrorHandler);
        t(str);
        p(context);
        s(new i(new o(context)));
        q(new e.k.c.a.a.j.p.b());
        try {
            n(new g((KeyStore) null, new o(context)));
        } catch (UnrecoverableKeyException e2) {
            String str2 = f11947i;
            e.k.c.a.a.j.q.i.d(str2, "WebViewSSLCheckThread: UnrecoverableKeyException : " + e2.getMessage());
        }
        m(g.f11914j);
    }

    @Deprecated
    public m(SslErrorHandler sslErrorHandler, String str, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        r(sslErrorHandler);
        t(str);
        s(sSLSocketFactory);
        q(hostnameVerifier);
    }

    @Deprecated
    public m(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        r(sslErrorHandler);
        t(str);
        n(sSLSocketFactory);
        m(x509HostnameVerifier);
    }

    @Deprecated
    public m(SslErrorHandler sslErrorHandler, String str, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, a aVar, Context context) {
        this.f11950e = sslErrorHandler;
        this.f11951f = str;
        this.f11948c = sSLSocketFactory;
        this.f11949d = x509HostnameVerifier;
        this.f11952g = aVar;
        this.f11953h = context;
    }
}
