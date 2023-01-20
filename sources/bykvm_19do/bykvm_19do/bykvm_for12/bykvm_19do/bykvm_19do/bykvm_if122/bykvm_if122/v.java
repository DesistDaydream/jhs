package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import com.tencent.android.tpns.mqtt.internal.security.SSLSocketFactoryFactory;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

/* loaded from: classes.dex */
public class v implements Cloneable, e.a, e0 {
    public static final List<w> A = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(w.HTTP_2, w.HTTP_1_1);
    public static final List<k> B = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(k.f597f, k.f598g);
    public final n a;
    public final Proxy b;

    /* renamed from: c */
    public final List<w> f640c;

    /* renamed from: d */
    public final List<k> f641d;

    /* renamed from: e */
    public final List<t> f642e;

    /* renamed from: f */
    public final List<t> f643f;

    /* renamed from: g */
    public final p.c f644g;

    /* renamed from: h */
    public final ProxySelector f645h;

    /* renamed from: i */
    public final m f646i;

    /* renamed from: j */
    public final c f647j;

    /* renamed from: k */
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d f648k;

    /* renamed from: l */
    public final SocketFactory f649l;

    /* renamed from: m */
    public final SSLSocketFactory f650m;
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c n;
    public final HostnameVerifier o;
    public final g p;
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b q;
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b r;
    public final j s;
    public final o t;
    public final boolean u;
    public final boolean v;
    public final boolean w;
    public final int x;
    public final int y;
    public final int z;

    /* loaded from: classes.dex */
    public static final class a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a {
        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public int a(a0.a aVar) {
            return aVar.f318c;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c a(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c0 c0Var) {
            return jVar.a(aVar, gVar, c0Var);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.d a(j jVar) {
            return jVar.f594e;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public Socket a(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar) {
            return jVar.a(aVar, gVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(k kVar, SSLSocket sSLSocket, boolean z) {
            kVar.a(sSLSocket, z);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(r.a aVar, String str) {
            aVar.a(str);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void a(r.a aVar, String str, String str2) {
            aVar.b(str, str2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar2) {
            return aVar.a(aVar2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public boolean a(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
            return jVar.a(cVar);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a
        public void b(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar) {
            jVar.b(cVar);
        }
    }

    /* loaded from: classes.dex */
    public static final class b {
        public int A;
        public Proxy b;

        /* renamed from: j */
        public c f658j;

        /* renamed from: k */
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d f659k;

        /* renamed from: m */
        public SSLSocketFactory f661m;
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c n;
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b q;
        public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b r;
        public j s;
        public o t;
        public boolean u;
        public boolean v;
        public boolean w;
        public int x;
        public int y;
        public int z;

        /* renamed from: e */
        public final List<t> f653e = new ArrayList();

        /* renamed from: f */
        public final List<t> f654f = new ArrayList();
        public n a = new n();

        /* renamed from: c */
        public List<w> f651c = v.A;

        /* renamed from: d */
        public List<k> f652d = v.B;

        /* renamed from: g */
        public p.c f655g = p.a(p.a);

        /* renamed from: h */
        public ProxySelector f656h = ProxySelector.getDefault();

        /* renamed from: i */
        public m f657i = m.a;

        /* renamed from: l */
        public SocketFactory f660l = SocketFactory.getDefault();
        public HostnameVerifier o = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a;
        public g p = g.f576c;

        public b() {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b bVar = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b.a;
            this.q = bVar;
            this.r = bVar;
            this.s = new j();
            this.t = o.a;
            this.u = true;
            this.v = true;
            this.w = true;
            this.x = 10000;
            this.y = 10000;
            this.z = 10000;
            this.A = 0;
        }

        public b a(long j2, TimeUnit timeUnit) {
            this.x = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j2, timeUnit);
            return this;
        }

        public b a(t tVar) {
            if (tVar != null) {
                this.f653e.add(tVar);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public v a() {
            return new v(this);
        }

        public b b(long j2, TimeUnit timeUnit) {
            this.y = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j2, timeUnit);
            return this;
        }

        public b c(long j2, TimeUnit timeUnit) {
            this.z = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("timeout", j2, timeUnit);
            return this;
        }
    }

    static {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a = new a();
    }

    public v() {
        this(new b());
    }

    public v(b bVar) {
        boolean z;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c cVar;
        this.a = bVar.a;
        this.b = bVar.b;
        this.f640c = bVar.f651c;
        List<k> list = bVar.f652d;
        this.f641d = list;
        this.f642e = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bVar.f653e);
        this.f643f = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bVar.f654f);
        this.f644g = bVar.f655g;
        this.f645h = bVar.f656h;
        this.f646i = bVar.f657i;
        this.f647j = bVar.f658j;
        this.f648k = bVar.f659k;
        this.f649l = bVar.f660l;
        loop0: while (true) {
            for (k kVar : list) {
                z = z || kVar.b();
            }
        }
        SSLSocketFactory sSLSocketFactory = bVar.f661m;
        if (sSLSocketFactory == null && z) {
            X509TrustManager z2 = z();
            this.f650m = a(z2);
            cVar = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.c.a(z2);
        } else {
            this.f650m = sSLSocketFactory;
            cVar = bVar.n;
        }
        this.n = cVar;
        this.o = bVar.o;
        this.p = bVar.p.a(this.n);
        this.q = bVar.q;
        this.r = bVar.r;
        this.s = bVar.s;
        this.t = bVar.t;
        this.u = bVar.u;
        this.v = bVar.v;
        this.w = bVar.w;
        this.x = bVar.x;
        this.y = bVar.y;
        this.z = bVar.z;
        int i2 = bVar.A;
        if (this.f642e.contains(null)) {
            throw new IllegalStateException("Null interceptor: " + this.f642e);
        } else if (this.f643f.contains(null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f643f);
        }
    }

    private SSLSocketFactory a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = SSLContext.getInstance(SSLSocketFactoryFactory.DEFAULT_PROTOCOL);
            sSLContext.init(null, new TrustManager[]{x509TrustManager}, null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("No System TLS", (Exception) e2);
        }
    }

    private X509TrustManager z() {
        try {
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            trustManagerFactory.init((KeyStore) null);
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException e2) {
            throw bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a("No System TLS", (Exception) e2);
        }
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b a() {
        return this.r;
    }

    public e a(y yVar) {
        return x.a(this, yVar, false);
    }

    public g b() {
        return this.p;
    }

    public int c() {
        return this.x;
    }

    public j d() {
        return this.s;
    }

    public List<k> e() {
        return this.f641d;
    }

    public m f() {
        return this.f646i;
    }

    public n g() {
        return this.a;
    }

    public o h() {
        return this.t;
    }

    public p.c j() {
        return this.f644g;
    }

    public boolean k() {
        return this.v;
    }

    public boolean l() {
        return this.u;
    }

    public HostnameVerifier m() {
        return this.o;
    }

    public List<t> n() {
        return this.f642e;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.d o() {
        c cVar = this.f647j;
        return cVar != null ? cVar.a : this.f648k;
    }

    public List<t> p() {
        return this.f643f;
    }

    public List<w> q() {
        return this.f640c;
    }

    public Proxy r() {
        return this.b;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b s() {
        return this.q;
    }

    public ProxySelector t() {
        return this.f645h;
    }

    public int u() {
        return this.y;
    }

    public boolean v() {
        return this.w;
    }

    public SocketFactory w() {
        return this.f649l;
    }

    public SSLSocketFactory x() {
        return this.f650m;
    }

    public int y() {
        return this.z;
    }
}
