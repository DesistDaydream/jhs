package h.p2.b0.g.t.l.b;

import h.k2.v.f0;
import h.p2.b0.g.t.c.o0;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    private final h.p2.b0.g.t.f.z.c a;
    @k.e.a.d
    private final ProtoBuf.Class b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.a f15504c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final o0 f15505d;

    public d(@k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d ProtoBuf.Class r2, @k.e.a.d h.p2.b0.g.t.f.z.a aVar, @k.e.a.d o0 o0Var) {
        this.a = cVar;
        this.b = r2;
        this.f15504c = aVar;
        this.f15505d = o0Var;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.f.z.c a() {
        return this.a;
    }

    @k.e.a.d
    public final ProtoBuf.Class b() {
        return this.b;
    }

    @k.e.a.d
    public final h.p2.b0.g.t.f.z.a c() {
        return this.f15504c;
    }

    @k.e.a.d
    public final o0 d() {
        return this.f15505d;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            d dVar = (d) obj;
            return f0.g(this.a, dVar.a) && f0.g(this.b, dVar.b) && f0.g(this.f15504c, dVar.f15504c) && f0.g(this.f15505d, dVar.f15505d);
        }
        return false;
    }

    public int hashCode() {
        return (((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.f15504c.hashCode()) * 31) + this.f15505d.hashCode();
    }

    @k.e.a.d
    public String toString() {
        return "ClassData(nameResolver=" + this.a + ", classProto=" + this.b + ", metadataVersion=" + this.f15504c + ", sourceElement=" + this.f15505d + ')';
    }
}
