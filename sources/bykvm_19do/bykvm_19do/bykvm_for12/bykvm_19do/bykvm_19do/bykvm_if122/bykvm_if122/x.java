package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x implements e {
    public final v a;
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.j b;

    /* renamed from: c  reason: collision with root package name */
    private p f666c;

    /* renamed from: d  reason: collision with root package name */
    public final y f667d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f668e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f669f;

    /* loaded from: classes.dex */
    public final class a extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b {
        private final f b;

        public a(f fVar) {
            super("OkHttp %s", x.this.c());
            this.b = fVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.b
        public void b() {
            boolean z;
            a0 a;
            try {
                try {
                    a = x.this.a();
                    try {
                        if (x.this.b.a()) {
                            this.b.a(x.this, new IOException("Canceled"));
                        } else {
                            this.b.a(x.this, a);
                        }
                    } catch (IOException e2) {
                        e = e2;
                        z = true;
                        if (z) {
                            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e b = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b();
                            b.a(4, "Callback failure for " + x.this.d(), e);
                        } else {
                            x.this.f666c.a(x.this, e);
                            this.b.a(x.this, e);
                        }
                        return;
                    }
                } finally {
                    x.this.a.g().b(this);
                }
            } catch (IOException e3) {
                e = e3;
                z = false;
            }
            if (a.f307c != 0) {
                return;
            }
            throw new IOException(a.f308d);
        }

        public String c() {
            return x.this.f667d.g().g();
        }
    }

    private x(v vVar, y yVar, boolean z) {
        this.a = vVar;
        this.f667d = yVar;
        this.f668e = z;
        this.b = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.j(vVar, z);
    }

    public static x a(v vVar, y yVar, boolean z) {
        x xVar = new x(vVar, yVar, z);
        xVar.f666c = vVar.j().a(xVar);
        return xVar;
    }

    private void e() {
        this.b.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a("response.body().close()"));
    }

    public a0 a() throws IOException {
        ArrayList arrayList = new ArrayList(this.a.n());
        arrayList.add(this.b);
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.a(this.a.f()));
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_19do.a(this.a.o()));
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.a(this.a));
        if (!this.f668e) {
            arrayList.addAll(this.a.p());
        }
        arrayList.add(new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.b(this.f668e));
        return new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.g(arrayList, null, null, null, 0, this.f667d, this, this.f666c, this.a.c(), this.a.u(), this.a.y()).a(this.f667d);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e
    public void a(f fVar) {
        synchronized (this) {
            if (this.f669f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f669f = true;
        }
        e();
        this.f666c.b(this);
        this.a.g().a(new a(fVar));
    }

    public boolean b() {
        return this.b.a();
    }

    public String c() {
        return this.f667d.g().l();
    }

    /* renamed from: clone */
    public x m11clone() {
        return a(this.a, this.f667d, this.f668e);
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        sb.append(b() ? "canceled " : "");
        sb.append(this.f668e ? "web socket" : "call");
        sb.append(" to ");
        sb.append(c());
        return sb.toString();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e
    public a0 i() throws IOException {
        synchronized (this) {
            if (this.f669f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f669f = true;
        }
        e();
        this.f666c.b(this);
        try {
            try {
                this.a.g().a(this);
                a0 a2 = a();
                if (a2 != null) {
                    if (a2.f307c != 0) {
                        return a2;
                    }
                    throw new IOException(a2.f308d);
                }
                throw new IOException("Canceled");
            } catch (IOException e2) {
                this.f666c.a(this, e2);
                throw e2;
            }
        } finally {
            this.a.g().b(this);
        }
    }
}
