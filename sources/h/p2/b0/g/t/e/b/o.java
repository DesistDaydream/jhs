package h.p2.b0.g.t.e.b;

import h.p2.b0.g.t.c.p0;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedContainerAbiStability;

/* loaded from: classes3.dex */
public final class o implements h.p2.b0.g.t.l.b.x.e {
    @k.e.a.d
    private final m b;
    @k.e.a.e

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.l.b.n<h.p2.b0.g.t.f.a0.f.e> f15334c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f15335d;
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private final DeserializedContainerAbiStability f15336e;

    public o(@k.e.a.d m mVar, @k.e.a.e h.p2.b0.g.t.l.b.n<h.p2.b0.g.t.f.a0.f.e> nVar, boolean z, @k.e.a.d DeserializedContainerAbiStability deserializedContainerAbiStability) {
        this.b = mVar;
        this.f15334c = nVar;
        this.f15335d = z;
        this.f15336e = deserializedContainerAbiStability;
    }

    @Override // h.p2.b0.g.t.l.b.x.e
    @k.e.a.d
    public String a() {
        return "Class '" + this.b.b().b().b() + '\'';
    }

    @Override // h.p2.b0.g.t.c.o0
    @k.e.a.d
    public p0 b() {
        return p0.a;
    }

    @k.e.a.d
    public final m d() {
        return this.b;
    }

    @k.e.a.d
    public String toString() {
        return ((Object) o.class.getSimpleName()) + ": " + this.b;
    }
}
