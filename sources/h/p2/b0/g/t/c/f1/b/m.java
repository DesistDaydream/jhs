package h.p2.b0.g.t.c.f1.b;

import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: classes3.dex */
public final class m extends c implements h.p2.b0.g.t.e.a.x.m {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final Enum<?> f15200c;

    public m(@k.e.a.e h.p2.b0.g.t.g.f fVar, @k.e.a.d Enum<?> r3) {
        super(fVar, null);
        this.f15200c = r3;
    }

    @Override // h.p2.b0.g.t.e.a.x.m
    @k.e.a.e
    public h.p2.b0.g.t.g.b d() {
        Class<?> cls = this.f15200c.getClass();
        if (!cls.isEnum()) {
            cls = cls.getEnclosingClass();
        }
        return ReflectClassUtilKt.a(cls);
    }

    @Override // h.p2.b0.g.t.e.a.x.m
    @k.e.a.e
    public h.p2.b0.g.t.g.f e() {
        return h.p2.b0.g.t.g.f.f(this.f15200c.name());
    }
}
