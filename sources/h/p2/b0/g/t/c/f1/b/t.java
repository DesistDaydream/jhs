package h.p2.b0.g.t.c.f1.b;

import h.k2.v.f0;
import java.util.Collection;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes3.dex */
public final class t extends u implements h.p2.b0.g.t.e.a.x.v {
    @k.e.a.d
    private final Class<?> b;
    @k.e.a.d

    /* renamed from: c */
    private final Collection<h.p2.b0.g.t.e.a.x.a> f15202c = CollectionsKt__CollectionsKt.E();

    /* renamed from: d */
    private final boolean f15203d;

    public t(@k.e.a.d Class<?> cls) {
        this.b = cls;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    public boolean D() {
        return this.f15203d;
    }

    @Override // h.p2.b0.g.t.c.f1.b.u
    @k.e.a.d
    /* renamed from: S */
    public Class<?> R() {
        return this.b;
    }

    @Override // h.p2.b0.g.t.e.a.x.d
    @k.e.a.d
    public Collection<h.p2.b0.g.t.e.a.x.a> getAnnotations() {
        return this.f15202c;
    }

    @Override // h.p2.b0.g.t.e.a.x.v
    @k.e.a.e
    public PrimitiveType getType() {
        if (f0.g(R(), Void.TYPE)) {
            return null;
        }
        return JvmPrimitiveType.get(R().getName()).getPrimitiveType();
    }
}
