package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class i extends t {

    /* renamed from: e  reason: collision with root package name */
    private t f280e;

    public i(t tVar) {
        if (tVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.f280e = tVar;
    }

    public final i a(t tVar) {
        if (tVar != null) {
            this.f280e = tVar;
            return this;
        }
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a() {
        return this.f280e.a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a(long j2) {
        return this.f280e.a(j2);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t a(long j2, TimeUnit timeUnit) {
        return this.f280e.a(j2, timeUnit);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public t b() {
        return this.f280e.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public long c() {
        return this.f280e.c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public boolean d() {
        return this.f280e.d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
    public void e() throws IOException {
        this.f280e.e();
    }

    public final t g() {
        return this.f280e;
    }
}
