package h.p2.b0.g.t.e.a.u;

import h.a2.u;
import h.p2.b0.g.t.c.v0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ValueParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors.LazyJavaStaticClassScope;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class g {
    @k.e.a.d
    public static final List<v0> a(@k.e.a.d Collection<h> collection, @k.e.a.d Collection<? extends v0> collection2, @k.e.a.d h.p2.b0.g.t.c.a aVar) {
        collection.size();
        collection2.size();
        List<Pair> V5 = CollectionsKt___CollectionsKt.V5(collection, collection2);
        ArrayList arrayList = new ArrayList(u.Y(V5, 10));
        for (Pair pair : V5) {
            h hVar = (h) pair.component1();
            v0 v0Var = (v0) pair.component2();
            arrayList.add(new ValueParameterDescriptorImpl(aVar, null, v0Var.f(), v0Var.getAnnotations(), v0Var.getName(), hVar.getType(), hVar.a(), v0Var.p0(), v0Var.n0(), v0Var.t0() != null ? DescriptorUtilsKt.l(aVar).k().k(hVar.getType()) : null, v0Var.getSource()));
        }
        return arrayList;
    }

    @k.e.a.e
    public static final LazyJavaStaticClassScope b(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        h.p2.b0.g.t.c.d p = DescriptorUtilsKt.p(dVar);
        if (p == null) {
            return null;
        }
        MemberScope k0 = p.k0();
        LazyJavaStaticClassScope lazyJavaStaticClassScope = k0 instanceof LazyJavaStaticClassScope ? (LazyJavaStaticClassScope) k0 : null;
        return lazyJavaStaticClassScope == null ? b(p) : lazyJavaStaticClassScope;
    }
}
