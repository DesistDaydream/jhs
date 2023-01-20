package h.p2.b0.g.t.c.f1.a;

import h.a2.t;
import h.p2.b0.g.t.k.r.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.DeserializedDescriptorResolver;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class a {
    @k.e.a.d
    private final DeserializedDescriptorResolver a;
    @k.e.a.d
    private final g b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<h.p2.b0.g.t.g.b, MemberScope> f15190c = new ConcurrentHashMap<>();

    public a(@k.e.a.d DeserializedDescriptorResolver deserializedDescriptorResolver, @k.e.a.d g gVar) {
        this.a = deserializedDescriptorResolver;
        this.b = gVar;
    }

    @k.e.a.d
    public final MemberScope a(@k.e.a.d f fVar) {
        Collection<h.p2.b0.g.t.e.b.m> k2;
        ConcurrentHashMap<h.p2.b0.g.t.g.b, MemberScope> concurrentHashMap = this.f15190c;
        h.p2.b0.g.t.g.b b = fVar.b();
        MemberScope memberScope = concurrentHashMap.get(b);
        if (memberScope == null) {
            h.p2.b0.g.t.g.c h2 = fVar.b().h();
            if (fVar.c().c() == KotlinClassHeader.Kind.MULTIFILE_CLASS) {
                List<String> f2 = fVar.c().f();
                k2 = new ArrayList();
                for (String str : f2) {
                    h.p2.b0.g.t.e.b.m b2 = h.p2.b0.g.t.e.b.l.b(this.b, h.p2.b0.g.t.g.b.m(h.p2.b0.g.t.k.p.d.d(str).e()));
                    if (b2 != null) {
                        k2.add(b2);
                    }
                }
            } else {
                k2 = t.k(fVar);
            }
            h.p2.b0.g.t.c.d1.l lVar = new h.p2.b0.g.t.c.d1.l(this.a.e().p(), h2);
            ArrayList arrayList = new ArrayList();
            for (h.p2.b0.g.t.e.b.m mVar : k2) {
                MemberScope c2 = this.a.c(lVar, mVar);
                if (c2 != null) {
                    arrayList.add(c2);
                }
            }
            List I5 = CollectionsKt___CollectionsKt.I5(arrayList);
            b.a aVar = h.p2.b0.g.t.k.r.b.f15478d;
            MemberScope a = aVar.a("package " + h2 + " (" + fVar + ')', I5);
            MemberScope putIfAbsent = concurrentHashMap.putIfAbsent(b, a);
            memberScope = putIfAbsent != null ? putIfAbsent : a;
        }
        return memberScope;
    }
}
