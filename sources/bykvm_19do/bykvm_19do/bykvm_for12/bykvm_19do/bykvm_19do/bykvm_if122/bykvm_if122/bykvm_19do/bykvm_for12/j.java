package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import com.qiniu.android.http.request.Request;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.SocketTimeoutException;
import java.security.cert.CertificateException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: classes.dex */
public final class j implements t {
    private final v a;
    private final boolean b;

    /* renamed from: c */
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g f364c;

    /* renamed from: d */
    private Object f365d;

    /* renamed from: e */
    private volatile boolean f366e;

    public j(v vVar, boolean z) {
        this.a = vVar;
        this.b = z;
    }

    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a(s sVar) {
        SSLSocketFactory sSLSocketFactory;
        HostnameVerifier hostnameVerifier;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.g gVar;
        if (sVar.h()) {
            SSLSocketFactory x = this.a.x();
            hostnameVerifier = this.a.m();
            sSLSocketFactory = x;
            gVar = this.a.b();
        } else {
            sSLSocketFactory = null;
            hostnameVerifier = null;
            gVar = null;
        }
        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a(sVar.g(), sVar.j(), this.a.h(), this.a.w(), sSLSocketFactory, hostnameVerifier, gVar, this.a.s(), this.a.r(), this.a.q(), this.a.e(), this.a.t());
    }

    private y a(a0 a0Var) throws IOException {
        String b;
        s b2;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b a;
        if (a0Var != null) {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c b3 = this.f364c.b();
            c0 a2 = b3 != null ? b3.a() : null;
            int k2 = a0Var.k();
            String e2 = a0Var.s().e();
            if (k2 != 307 && k2 != 308) {
                if (k2 == 401) {
                    a = this.a.a();
                } else if (k2 == 407) {
                    if ((a2 != null ? a2.b() : this.a.r()).type() != Proxy.Type.HTTP) {
                        throw new ProtocolException("Received HTTP_PROXY_AUTH (407) code while not using proxy");
                    }
                    a = this.a.s();
                } else if (k2 == 408) {
                    if (this.a.v()) {
                        a0Var.s().a();
                        if (a0Var.q() == null || a0Var.q().k() != 408) {
                            return a0Var.s();
                        }
                        return null;
                    }
                    return null;
                } else {
                    switch (k2) {
                        case 300:
                        case 301:
                        case 302:
                        case 303:
                            break;
                        default:
                            return null;
                    }
                }
                return a.a(a2, a0Var);
            } else if (!e2.equals("GET") && !e2.equals(Request.HttpMethodHEAD)) {
                return null;
            }
            if (!this.a.k() || (b = a0Var.b(e.b.a.p.j.j.f9458i)) == null || (b2 = a0Var.s().g().b(b)) == null) {
                return null;
            }
            if (b2.m().equals(a0Var.s().g().m()) || this.a.l()) {
                y.a f2 = a0Var.s().f();
                if (f.b(e2)) {
                    boolean d2 = f.d(e2);
                    if (f.c(e2)) {
                        f2.a("GET", (z) null);
                    } else {
                        f2.a(e2, d2 ? a0Var.s().a() : null);
                    }
                    if (!d2) {
                        f2.a("Transfer-Encoding");
                        f2.a("Content-Length");
                        f2.a("Content-Type");
                    }
                }
                if (!a(a0Var, b2)) {
                    f2.a("Authorization");
                }
                return f2.a(b2).a();
            }
            return null;
        }
        throw new IllegalStateException();
    }

    private boolean a(a0 a0Var, s sVar) {
        s g2 = a0Var.s().g();
        return g2.g().equals(sVar.g()) && g2.j() == sVar.j() && g2.m().equals(sVar.m());
    }

    private boolean a(IOException iOException, boolean z) {
        if (iOException instanceof ProtocolException) {
            return false;
        }
        if (iOException instanceof InterruptedIOException) {
            if (!(iOException instanceof SocketTimeoutException) || z) {
                return false;
            }
        } else if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        return true;
    }

    private boolean a(IOException iOException, boolean z, y yVar) {
        this.f364c.a(iOException);
        if (this.a.v()) {
            if (z) {
                yVar.a();
            }
            if (a(iOException, z) && this.f364c.c()) {
                return true;
            }
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t
    public a0 a(t.a aVar) throws IOException {
        a0 a;
        y a2;
        y b = aVar.b();
        g gVar = (g) aVar;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e e2 = gVar.e();
        p g2 = gVar.g();
        this.f364c = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g(this.a.d(), a(b.g()), e2, g2, this.f365d);
        a0 a0Var = null;
        int i2 = 0;
        while (!this.f366e) {
            try {
                try {
                    a = gVar.a(b, this.f364c, null, null);
                    if (a0Var != null) {
                        a = a.p().c(a0Var.p().a((b0) null).a()).a();
                    }
                    a2 = a(a);
                } catch (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.e e3) {
                    if (!a(e3.a(), false, b)) {
                        throw e3.a();
                    }
                } catch (IOException e4) {
                    if (!a(e4, !(e4 instanceof bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a), b)) {
                        throw e4;
                    }
                }
                if (a2 == null) {
                    if (!this.b) {
                        this.f364c.e();
                    }
                    return a;
                }
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a.i());
                int i3 = i2 + 1;
                if (i3 > 20) {
                    this.f364c.e();
                    throw new ProtocolException("Too many follow-up requests: " + i3);
                }
                a2.a();
                if (!a(a, a2.g())) {
                    this.f364c.e();
                    this.f364c = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g(this.a.d(), a(a2.g()), e2, g2, this.f365d);
                } else if (this.f364c.a() != null) {
                    throw new IllegalStateException("Closing the body of " + a + " didn't close its backing stream. Bad interceptor?");
                }
                a0Var = a;
                b = a2;
                i2 = i3;
            } catch (Throwable th) {
                this.f364c.a((IOException) null);
                this.f364c.e();
                throw th;
            }
        }
        this.f364c.e();
        throw new IOException("Canceled");
    }

    public void a(Object obj) {
        this.f365d = obj;
    }

    public boolean a() {
        return this.f366e;
    }
}
