package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLSocket;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: e  reason: collision with root package name */
    private static final h[] f596e;

    /* renamed from: f  reason: collision with root package name */
    public static final k f597f;

    /* renamed from: g  reason: collision with root package name */
    public static final k f598g;
    public final boolean a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    public final String[] f599c;

    /* renamed from: d  reason: collision with root package name */
    public final String[] f600d;

    /* loaded from: classes.dex */
    public static final class a {
        public boolean a;
        public String[] b;

        /* renamed from: c  reason: collision with root package name */
        public String[] f601c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f602d;

        public a(k kVar) {
            this.a = kVar.a;
            this.b = kVar.f599c;
            this.f601c = kVar.f600d;
            this.f602d = kVar.b;
        }

        public a(boolean z) {
            this.a = z;
        }

        public a a(boolean z) {
            if (this.a) {
                this.f602d = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public a a(d0... d0VarArr) {
            if (this.a) {
                String[] strArr = new String[d0VarArr.length];
                for (int i2 = 0; i2 < d0VarArr.length; i2++) {
                    strArr[i2] = d0VarArr[i2].a;
                }
                return b(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a a(h... hVarArr) {
            if (this.a) {
                String[] strArr = new String[hVarArr.length];
                for (int i2 = 0; i2 < hVarArr.length; i2++) {
                    strArr[i2] = hVarArr[i2].a;
                }
                return a(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public a a(String... strArr) {
            if (this.a) {
                if (strArr.length != 0) {
                    this.b = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public k a() {
            return new k(this);
        }

        public a b(String... strArr) {
            if (this.a) {
                if (strArr.length != 0) {
                    this.f601c = (String[]) strArr.clone();
                    return this;
                }
                throw new IllegalArgumentException("At least one TLS version is required");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }
    }

    static {
        h[] hVarArr = {h.f589m, h.o, h.n, h.p, h.r, h.q, h.f585i, h.f587k, h.f586j, h.f588l, h.f583g, h.f584h, h.f581e, h.f582f, h.f580d};
        f596e = hVarArr;
        a a2 = new a(true).a(hVarArr);
        d0 d0Var = d0.TLS_1_0;
        k a3 = a2.a(d0.TLS_1_3, d0.TLS_1_2, d0.TLS_1_1, d0Var).a(true).a();
        f597f = a3;
        new a(a3).a(d0Var).a(true).a();
        f598g = new a(false).a();
    }

    public k(a aVar) {
        this.a = aVar.a;
        this.f599c = aVar.b;
        this.f600d = aVar.f601c;
        this.b = aVar.f602d;
    }

    private k b(SSLSocket sSLSocket, boolean z) {
        String[] a2 = this.f599c != null ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(h.b, sSLSocket.getEnabledCipherSuites(), this.f599c) : sSLSocket.getEnabledCipherSuites();
        String[] a3 = this.f600d != null ? bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.o, sSLSocket.getEnabledProtocols(), this.f600d) : sSLSocket.getEnabledProtocols();
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int a4 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(h.b, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && a4 != -1) {
            a2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a2, supportedCipherSuites[a4]);
        }
        return new a(this).a(a2).b(a3).a();
    }

    public List<h> a() {
        String[] strArr = this.f599c;
        if (strArr != null) {
            return h.a(strArr);
        }
        return null;
    }

    public void a(SSLSocket sSLSocket, boolean z) {
        k b = b(sSLSocket, z);
        String[] strArr = b.f600d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f599c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    public boolean a(SSLSocket sSLSocket) {
        String[] strArr;
        String[] strArr2;
        return this.a && ((strArr = this.f600d) == null || bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.o, strArr, sSLSocket.getEnabledProtocols())) && ((strArr2 = this.f599c) == null || bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.b(h.b, strArr2, sSLSocket.getEnabledCipherSuites()));
    }

    public boolean b() {
        return this.a;
    }

    public boolean c() {
        return this.b;
    }

    public List<d0> d() {
        String[] strArr = this.f600d;
        if (strArr != null) {
            return d0.a(strArr);
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            if (obj == this) {
                return true;
            }
            k kVar = (k) obj;
            boolean z = this.a;
            if (z == kVar.a) {
                if (!z) {
                    return true;
                }
                if (Arrays.equals(this.f599c, kVar.f599c) && Arrays.equals(this.f600d, kVar.f600d) && this.b == kVar.b) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        if (this.a) {
            return ((((Arrays.hashCode(this.f599c) + 527) * 31) + Arrays.hashCode(this.f600d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (this.a) {
            String obj = this.f599c != null ? a().toString() : "[all enabled]";
            String obj2 = this.f600d != null ? d().toString() : "[all enabled]";
            return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + obj2 + ", supportsTlsExtensions=" + this.b + ")";
        }
        return "ConnectionSpec()";
    }
}
