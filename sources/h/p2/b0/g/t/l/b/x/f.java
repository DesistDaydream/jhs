package h.p2.b0.g.t.l.b.x;

import h.a2.d1;
import h.a2.y;
import h.k2.u.l;
import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* loaded from: classes3.dex */
public class f extends DeserializedMemberScope {
    @k.e.a.d

    /* renamed from: g */
    private final b0 f15544g;
    @k.e.a.d

    /* renamed from: h */
    private final h.p2.b0.g.t.g.c f15545h;

    public f(@k.e.a.d b0 b0Var, @k.e.a.d ProtoBuf.Package r16, @k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d h.p2.b0.g.t.f.z.a aVar, @k.e.a.e e eVar, @k.e.a.d h.p2.b0.g.t.l.b.g gVar, @k.e.a.d h.k2.u.a<? extends Collection<h.p2.b0.g.t.g.f>> aVar2) {
        super(gVar.a(b0Var, cVar, new h.p2.b0.g.t.f.z.g(r16.getTypeTable()), h.p2.b0.g.t.f.z.i.b.a(r16.getVersionRequirementTable()), aVar, eVar), r16.getFunctionList(), r16.getPropertyList(), r16.getTypeAliasList(), aVar2);
        this.f15544g = b0Var;
        this.f15545h = b0Var.e();
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @k.e.a.d
    /* renamed from: A */
    public List<k> g(@k.e.a.d h.p2.b0.g.t.k.r.d dVar, @k.e.a.d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        Collection<k> l2 = l(dVar, lVar, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
        Iterable<h.p2.b0.g.t.c.c1.b> k2 = r().c().k();
        ArrayList arrayList = new ArrayList();
        for (h.p2.b0.g.t.c.c1.b bVar : k2) {
            y.q0(arrayList, bVar.a(this.f15545h));
        }
        return CollectionsKt___CollectionsKt.q4(l2, arrayList);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope, h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        h(fVar, bVar);
        return super.f(fVar, bVar);
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    public void h(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        h.p2.b0.g.t.d.a.b(r().c().o(), bVar, this.f15544g, fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public void k(@k.e.a.d Collection<k> collection, @k.e.a.d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @k.e.a.d
    public h.p2.b0.g.t.g.b o(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        return new h.p2.b0.g.t.g.b(this.f15545h, fVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @k.e.a.e
    public Set<h.p2.b0.g.t.g.f> u() {
        return d1.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> v() {
        return d1.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> w() {
        return d1.k();
    }

    @Override // kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope
    public boolean y(@k.e.a.d h.p2.b0.g.t.g.f fVar) {
        boolean z;
        if (super.y(fVar)) {
            return true;
        }
        Iterable<h.p2.b0.g.t.c.c1.b> k2 = r().c().k();
        if (!(k2 instanceof Collection) || !((Collection) k2).isEmpty()) {
            for (h.p2.b0.g.t.c.c1.b bVar : k2) {
                if (bVar.b(this.f15545h, fVar)) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        return z;
    }
}
