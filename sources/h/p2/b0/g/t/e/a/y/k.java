package h.p2.b0.g.t.e.a.y;

import h.k2.v.f0;
import h.p2.b0.g.t.c.t0;
import h.p2.b0.g.t.n.z;

/* loaded from: classes3.dex */
public final class k {
    @k.e.a.d
    private final z a;
    @k.e.a.e
    private final h.p2.b0.g.t.e.a.k b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private final t0 f15301c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15302d;

    public k(@k.e.a.d z zVar, @k.e.a.e h.p2.b0.g.t.e.a.k kVar, @k.e.a.e t0 t0Var, boolean z) {
        this.a = zVar;
        this.b = kVar;
        this.f15301c = t0Var;
        this.f15302d = z;
    }

    @k.e.a.d
    public final z a() {
        return this.a;
    }

    @k.e.a.e
    public final h.p2.b0.g.t.e.a.k b() {
        return this.b;
    }

    @k.e.a.e
    public final t0 c() {
        return this.f15301c;
    }

    public final boolean d() {
        return this.f15302d;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            return f0.g(this.a, kVar.a) && f0.g(this.b, kVar.b) && f0.g(this.f15301c, kVar.f15301c) && this.f15302d == kVar.f15302d;
        }
        return false;
    }

    @k.e.a.d
    public final z getType() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        h.p2.b0.g.t.e.a.k kVar = this.b;
        int hashCode2 = (hashCode + (kVar == null ? 0 : kVar.hashCode())) * 31;
        t0 t0Var = this.f15301c;
        int hashCode3 = (hashCode2 + (t0Var != null ? t0Var.hashCode() : 0)) * 31;
        boolean z = this.f15302d;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode3 + i2;
    }

    @k.e.a.d
    public String toString() {
        return "TypeAndDefaultQualifiers(type=" + this.a + ", defaultQualifiers=" + this.b + ", typeParameterForArgument=" + this.f15301c + ", isFromStarProjection=" + this.f15302d + ')';
    }
}
