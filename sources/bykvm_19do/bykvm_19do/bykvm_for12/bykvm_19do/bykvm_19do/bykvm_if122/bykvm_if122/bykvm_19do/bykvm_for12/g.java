package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.w;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public final class g implements t.a {
    private final List<t> a;
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g b;

    /* renamed from: c */
    private final c f353c;

    /* renamed from: d */
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c f354d;

    /* renamed from: e */
    private final int f355e;

    /* renamed from: f */
    private final y f356f;

    /* renamed from: g */
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f357g;

    /* renamed from: h */
    private final p f358h;

    /* renamed from: i */
    private final int f359i;

    /* renamed from: j */
    private final int f360j;

    /* renamed from: k */
    private final int f361k;

    /* renamed from: l */
    private int f362l;

    public g(List<t> list, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c cVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2, int i2, y yVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar, int i3, int i4, int i5) {
        this.a = list;
        this.f354d = cVar2;
        this.b = gVar;
        this.f353c = cVar;
        this.f355e = i2;
        this.f356f = yVar;
        this.f357g = eVar;
        this.f358h = pVar;
        this.f359i = i3;
        this.f360j = i4;
        this.f361k = i5;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int a() {
        return this.f361k;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public a0 a(y yVar) throws IOException {
        return a(yVar, this.b, this.f353c, this.f354d);
    }

    public a0 a(y yVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, c cVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c cVar2) throws IOException {
        if (this.f355e < this.a.size()) {
            this.f362l++;
            if (this.f353c != null && !this.f354d.a(yVar.g())) {
                throw new IllegalStateException("network interceptor " + this.a.get(this.f355e - 1) + " must retain the same host and port");
            } else if (this.f353c != null && this.f362l > 1) {
                throw new IllegalStateException("network interceptor " + this.a.get(this.f355e - 1) + " must call proceed() exactly once");
            } else {
                g gVar2 = new g(this.a, gVar, cVar, cVar2, this.f355e + 1, yVar, this.f357g, this.f358h, this.f359i, this.f360j, this.f361k);
                t tVar = this.a.get(this.f355e);
                try {
                    a0 a = tVar.a(gVar2);
                    if (cVar != null && this.f355e + 1 < this.a.size() && gVar2.f362l != 1) {
                        throw new IllegalStateException("network interceptor " + tVar + " must call proceed() exactly once");
                    } else if (a == null) {
                        return new a0.a().a(yVar).a((cVar2 == null || cVar2.d() == null) ? w.a("Unknown") : cVar2.d()).a(0).a("internal error").a();
                    } else if (a.i() != null) {
                        return a;
                    } else {
                        throw new IllegalStateException("interceptor " + tVar + " returned a response with no body");
                    }
                } catch (Exception e2) {
                    throw e2;
                }
            }
        }
        throw new AssertionError();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public y b() {
        return this.f356f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int c() {
        return this.f359i;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t.a
    public int d() {
        return this.f360j;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e e() {
        return this.f357g;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.i f() {
        return this.f354d;
    }

    public p g() {
        return this.f358h;
    }

    public c h() {
        return this.f353c;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g i() {
        return this.b;
    }
}
