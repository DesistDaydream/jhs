package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import java.io.Closeable;

/* loaded from: classes.dex */
public final class a0 implements Closeable {
    public final y a;
    public final w b;

    /* renamed from: c  reason: collision with root package name */
    public final int f307c;

    /* renamed from: d  reason: collision with root package name */
    public final String f308d;

    /* renamed from: e  reason: collision with root package name */
    public final q f309e;

    /* renamed from: f  reason: collision with root package name */
    public final r f310f;

    /* renamed from: g  reason: collision with root package name */
    public final b0 f311g;

    /* renamed from: h  reason: collision with root package name */
    public final a0 f312h;

    /* renamed from: i  reason: collision with root package name */
    public final a0 f313i;

    /* renamed from: j  reason: collision with root package name */
    public final a0 f314j;

    /* renamed from: k  reason: collision with root package name */
    public final long f315k;

    /* renamed from: l  reason: collision with root package name */
    public final long f316l;

    /* renamed from: m  reason: collision with root package name */
    private volatile d f317m;

    /* loaded from: classes.dex */
    public static class a {
        public y a;
        public w b;

        /* renamed from: c  reason: collision with root package name */
        public int f318c;

        /* renamed from: d  reason: collision with root package name */
        public String f319d;

        /* renamed from: e  reason: collision with root package name */
        public q f320e;

        /* renamed from: f  reason: collision with root package name */
        public r.a f321f;

        /* renamed from: g  reason: collision with root package name */
        public b0 f322g;

        /* renamed from: h  reason: collision with root package name */
        public a0 f323h;

        /* renamed from: i  reason: collision with root package name */
        public a0 f324i;

        /* renamed from: j  reason: collision with root package name */
        public a0 f325j;

        /* renamed from: k  reason: collision with root package name */
        public long f326k;

        /* renamed from: l  reason: collision with root package name */
        public long f327l;

        public a() {
            this.f318c = -1;
            this.f321f = new r.a();
        }

        public a(a0 a0Var) {
            this.f318c = -1;
            this.a = a0Var.a;
            this.b = a0Var.b;
            this.f318c = a0Var.f307c;
            this.f319d = a0Var.f308d;
            this.f320e = a0Var.f309e;
            this.f321f = a0Var.f310f.a();
            this.f322g = a0Var.f311g;
            this.f323h = a0Var.f312h;
            this.f324i = a0Var.f313i;
            this.f325j = a0Var.f314j;
            this.f326k = a0Var.f315k;
            this.f327l = a0Var.f316l;
        }

        private void a(String str, a0 a0Var) {
            if (a0Var.f311g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (a0Var.f312h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (a0Var.f313i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (a0Var.f314j == null) {
            } else {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        private void d(a0 a0Var) {
            if (a0Var.f311g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        public a a(int i2) {
            this.f318c = i2;
            return this;
        }

        public a a(long j2) {
            this.f327l = j2;
            return this;
        }

        public a a(a0 a0Var) {
            if (a0Var != null) {
                a("cacheResponse", a0Var);
            }
            this.f324i = a0Var;
            return this;
        }

        public a a(b0 b0Var) {
            this.f322g = b0Var;
            return this;
        }

        public a a(q qVar) {
            this.f320e = qVar;
            return this;
        }

        public a a(r rVar) {
            this.f321f = rVar.a();
            return this;
        }

        public a a(w wVar) {
            this.b = wVar;
            return this;
        }

        public a a(y yVar) {
            this.a = yVar;
            return this;
        }

        public a a(String str) {
            this.f319d = str;
            return this;
        }

        public a a(String str, String str2) {
            this.f321f.a(str, str2);
            return this;
        }

        public a0 a() {
            if (this.a != null) {
                if (this.b != null) {
                    if (this.f318c >= 0) {
                        if (this.f319d != null) {
                            return new a0(this);
                        }
                        throw new IllegalStateException("message == null");
                    }
                    throw new IllegalStateException("code < 0: " + this.f318c);
                }
                throw new IllegalStateException("protocol == null");
            }
            throw new IllegalStateException("request == null");
        }

        public a b(long j2) {
            this.f326k = j2;
            return this;
        }

        public a b(a0 a0Var) {
            if (a0Var != null) {
                a("networkResponse", a0Var);
            }
            this.f323h = a0Var;
            return this;
        }

        public a c(a0 a0Var) {
            if (a0Var != null) {
                d(a0Var);
            }
            this.f325j = a0Var;
            return this;
        }
    }

    public a0(a aVar) {
        this.a = aVar.a;
        this.b = aVar.b;
        this.f307c = aVar.f318c;
        this.f308d = aVar.f319d;
        this.f309e = aVar.f320e;
        this.f310f = aVar.f321f.a();
        this.f311g = aVar.f322g;
        this.f312h = aVar.f323h;
        this.f313i = aVar.f324i;
        this.f314j = aVar.f325j;
        this.f315k = aVar.f326k;
        this.f316l = aVar.f327l;
    }

    public String a(String str, String str2) {
        String a2 = this.f310f.a(str);
        return a2 != null ? a2 : str2;
    }

    public String b(String str) {
        return a(str, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        b0 b0Var = this.f311g;
        if (b0Var == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        b0Var.close();
    }

    public b0 i() {
        return this.f311g;
    }

    public d j() {
        d dVar = this.f317m;
        if (dVar != null) {
            return dVar;
        }
        d a2 = d.a(this.f310f);
        this.f317m = a2;
        return a2;
    }

    public int k() {
        return this.f307c;
    }

    public q l() {
        return this.f309e;
    }

    public r m() {
        return this.f310f;
    }

    public boolean n() {
        int i2 = this.f307c;
        return i2 >= 200 && i2 < 300;
    }

    public String o() {
        return this.f308d;
    }

    public a p() {
        return new a(this);
    }

    public a0 q() {
        return this.f314j;
    }

    public long r() {
        return this.f316l;
    }

    public y s() {
        return this.a;
    }

    public long t() {
        return this.f315k;
    }

    public String toString() {
        return "Response{protocol=" + this.b + ", code=" + this.f307c + ", message=" + this.f308d + ", url=" + this.a.g() + '}';
    }
}
