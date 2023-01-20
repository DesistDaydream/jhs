package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.k;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.q;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class c extends g.i implements i {
    private final j b;

    /* renamed from: c */
    private final c0 f370c;

    /* renamed from: d */
    private Socket f371d;

    /* renamed from: e */
    private Socket f372e;

    /* renamed from: f */
    private q f373f;

    /* renamed from: g */
    private w f374g;

    /* renamed from: h */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g f375h;

    /* renamed from: i */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f376i;

    /* renamed from: j */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f377j;

    /* renamed from: k */
    public boolean f378k;

    /* renamed from: l */
    public int f379l;

    /* renamed from: m */
    public int f380m = 1;
    public final List<Reference<g>> n = new ArrayList();
    public long o = Long.MAX_VALUE;

    public c(j jVar, c0 c0Var) {
        this.b = jVar;
        this.f370c = c0Var;
    }

    private y a(int i2, int i3, y yVar, s sVar) throws IOException {
        String str = "CONNECT " + bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(sVar, true) + " HTTP/1.1";
        while (true) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a aVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a(null, null, this.f376i, this.f377j);
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f376i.b().a(i2, timeUnit);
            this.f377j.b().a(i3, timeUnit);
            aVar.a(yVar.c(), str);
            aVar.a();
            a0 a = aVar.a(false).a(yVar).a();
            long a2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a);
            if (a2 == -1) {
                a2 = 0;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s b = aVar.b(a2);
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(b, Integer.MAX_VALUE, timeUnit);
            b.close();
            int k2 = a.k();
            if (k2 == 200) {
                if (this.f376i.a().f() && this.f377j.a().f()) {
                    return null;
                }
                throw new IOException("TLS tunnel buffered too many bytes!");
            } else if (k2 != 407) {
                throw new IOException("Unexpected response code for CONNECT: " + a.k());
            } else {
                y a3 = this.f370c.a().g().a(this.f370c, a);
                if (a3 == null) {
                    throw new IOException("Failed to authenticate with proxy");
                }
                if ("close".equalsIgnoreCase(a.b("Connection"))) {
                    return a3;
                }
                yVar = a3;
            }
        }
    }

    private void a(int i2, int i3, int i4, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        y f2 = f();
        s g2 = f2.g();
        for (int i5 = 0; i5 < 21; i5++) {
            a(i2, i3, eVar, pVar);
            f2 = a(i3, i4, f2, g2);
            if (f2 == null) {
                return;
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f371d);
            this.f371d = null;
            this.f377j = null;
            this.f376i = null;
            pVar.a(eVar, this.f370c.d(), this.f370c.b(), null);
        }
    }

    private void a(int i2, int i3, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        Proxy b = this.f370c.b();
        this.f371d = (b.type() == Proxy.Type.DIRECT || b.type() == Proxy.Type.HTTP) ? this.f370c.a().i().createSocket() : new Socket(b);
        pVar.a(eVar, this.f370c.d(), b);
        this.f371d.setSoTimeout(i3);
        try {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(this.f371d, this.f370c.d(), i2);
            try {
                this.f376i = l.a(l.b(this.f371d));
                this.f377j = l.a(l.a(this.f371d));
            } catch (NullPointerException e2) {
                if ("throw with null exception".equals(e2.getMessage())) {
                    throw new IOException(e2);
                }
            }
        } catch (ConnectException e3) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f370c.d());
            connectException.initCause(e3);
            throw connectException;
        }
    }

    private void a(b bVar) throws IOException {
        SSLSocket sSLSocket;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a = this.f370c.a();
        try {
            try {
                sSLSocket = (SSLSocket) a.j().createSocket(this.f371d, a.k().g(), a.k().j(), true);
                try {
                    k a2 = bVar.a(sSLSocket);
                    if (a2.c()) {
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket, a.k().g(), a.e());
                    }
                    sSLSocket.startHandshake();
                    q a3 = q.a(sSLSocket.getSession());
                    if (a.d().verify(a.k().g(), sSLSocket.getSession())) {
                        a.a().a(a.k().g(), a3.b());
                        String b = a2.c() ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().b(sSLSocket) : null;
                        this.f372e = sSLSocket;
                        this.f376i = l.a(l.b(sSLSocket));
                        this.f377j = l.a(l.a(this.f372e));
                        this.f373f = a3;
                        this.f374g = b != null ? w.a(b) : w.HTTP_1_1;
                        if (sSLSocket != null) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket);
                            return;
                        }
                        return;
                    }
                    X509Certificate x509Certificate = (X509Certificate) a3.b().get(0);
                    throw new SSLPeerUnverifiedException("Hostname " + a.k().g() + " not verified:\n    certificate: " + bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g.a((Certificate) x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a(x509Certificate));
                } catch (AssertionError e2) {
                    e = e2;
                    if (!bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(e)) {
                        throw e;
                    }
                    throw new IOException(e);
                } catch (Throwable th) {
                    th = th;
                    if (sSLSocket != null) {
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(sSLSocket);
                    }
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a((Socket) sSLSocket);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                sSLSocket = null;
            }
        } catch (AssertionError e3) {
            e = e3;
        }
    }

    private void a(b bVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar) throws IOException {
        if (this.f370c.a().j() == null) {
            this.f374g = w.HTTP_1_1;
            this.f372e = this.f371d;
            return;
        }
        pVar.g(eVar);
        a(bVar);
        pVar.a(eVar, this.f373f);
        if (this.f374g == w.HTTP_2) {
            this.f372e.setSoTimeout(0);
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g a = new g.h(true).a(this.f372e, this.f370c.a().k().g(), this.f376i, this.f377j).a(this).a();
            this.f375h = a;
            a.k();
        }
    }

    private y f() {
        return new y.a().a(this.f370c.a().k()).b("Host", bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this.f370c.a().k(), true)).b("Proxy-Connection", "Keep-Alive").b("User-Agent", bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.d.a()).a();
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a(v vVar, t.a aVar, g gVar) throws SocketException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar2 = this.f375h;
        if (gVar2 != null) {
            return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.f(vVar, aVar, gVar, gVar2);
        }
        this.f372e.setSoTimeout(aVar.d());
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        this.f376i.b().a(aVar.d(), timeUnit);
        this.f377j.b().a(aVar.a(), timeUnit);
        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a(vVar, gVar, this.f376i, this.f377j);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i
    public c0 a() {
        return this.f370c;
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x007d A[Catch: IOException -> 0x00e1, TRY_LEAVE, TryCatch #0 {IOException -> 0x00e1, blocks: (B:154:0x0075, B:156:0x007d), top: B:196:0x0075 }] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x00de A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r16, int r17, int r18, boolean r19, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e r20, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p r21) {
        /*
            Method dump skipped, instructions count: 305
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c.a(int, int, int, boolean, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p):void");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar) {
        synchronized (this.b) {
            this.f380m = gVar.j();
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g.i
    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i iVar) throws IOException {
        iVar.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM);
    }

    public boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, c0 c0Var) {
        if (this.n.size() < this.f380m && !this.f378k && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f370c.a(), aVar)) {
            if (aVar.k().g().equals(a().a().k().g())) {
                return true;
            }
            if (this.f375h != null && c0Var != null && c0Var.b().type() == Proxy.Type.DIRECT && this.f370c.b().type() == Proxy.Type.DIRECT && this.f370c.d().equals(c0Var.d()) && c0Var.a().d() == bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a && a(aVar.k())) {
                try {
                    aVar.a().a(aVar.k().g(), b().b());
                    return true;
                } catch (SSLPeerUnverifiedException unused) {
                }
            }
        }
        return false;
    }

    public boolean a(s sVar) {
        if (sVar.j() == this.f370c.a().k().j()) {
            if (sVar.g().equals(this.f370c.a().k().g())) {
                return true;
            }
            if (this.f373f != null && bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.e.a.a(sVar.g(), (X509Certificate) this.f373f.b().get(0))) {
                return true;
            }
        }
        return false;
    }

    public boolean a(boolean z) {
        if (!this.f372e.isClosed() && !this.f372e.isInputShutdown() && !this.f372e.isOutputShutdown()) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.g gVar = this.f375h;
            if (gVar != null) {
                return true ^ gVar.i();
            }
            if (!z) {
                return true;
            }
            try {
                int soTimeout = this.f372e.getSoTimeout();
                try {
                    this.f372e.setSoTimeout(1);
                    if (!this.f376i.f()) {
                        this.f372e.setSoTimeout(soTimeout);
                        return true;
                    }
                    this.f372e.setSoTimeout(soTimeout);
                } catch (Throwable th) {
                    this.f372e.setSoTimeout(soTimeout);
                    throw th;
                }
            } catch (SocketTimeoutException unused) {
                return true;
            } catch (IOException unused2) {
            }
        }
        return false;
    }

    public q b() {
        return this.f373f;
    }

    public boolean c() {
        return this.f375h != null;
    }

    public w d() {
        return this.f374g;
    }

    public Socket e() {
        return this.f372e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f370c.a().k().g());
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f370c.a().k().j());
        sb.append(", proxy=");
        sb.append(this.f370c.b());
        sb.append(" hostAddress=");
        sb.append(this.f370c.d());
        sb.append(" cipherSuite=");
        q qVar = this.f373f;
        sb.append(qVar != null ? qVar.a() : "none");
        sb.append(" protocol=");
        sb.append(this.f374g);
        sb.append('}');
        return sb.toString();
    }
}
