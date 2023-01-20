package h.p2.b0.g.t.k;

import h.p2.b0.g.t.c.b0;
import h.p2.b0.g.t.c.s0;
import h.p2.b0.g.t.k.r.h;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class a extends k {
    @k.e.a.d
    public static final a a = new a();

    private a() {
    }

    private static final void b(h.p2.b0.g.t.c.d dVar, LinkedHashSet<h.p2.b0.g.t.c.d> linkedHashSet, MemberScope memberScope, boolean z) {
        for (h.p2.b0.g.t.c.k kVar : h.a.a(memberScope, h.p2.b0.g.t.k.r.d.t, null, 2, null)) {
            if (kVar instanceof h.p2.b0.g.t.c.d) {
                h.p2.b0.g.t.c.d dVar2 = (h.p2.b0.g.t.c.d) kVar;
                if (dVar2.i0()) {
                    h.p2.b0.g.t.c.f f2 = memberScope.f(dVar2.getName(), NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    if (f2 instanceof h.p2.b0.g.t.c.d) {
                        dVar2 = (h.p2.b0.g.t.c.d) f2;
                    } else {
                        dVar2 = f2 instanceof s0 ? ((s0) f2).u() : null;
                    }
                }
                if (dVar2 != null) {
                    if (c.z(dVar2, dVar)) {
                        linkedHashSet.add(dVar2);
                    }
                    if (z) {
                        b(dVar, linkedHashSet, dVar2.U(), z);
                    }
                }
            }
        }
    }

    @k.e.a.d
    public Collection<h.p2.b0.g.t.c.d> a(@k.e.a.d h.p2.b0.g.t.c.d dVar, boolean z) {
        h.p2.b0.g.t.c.k kVar;
        h.p2.b0.g.t.c.k kVar2;
        if (dVar.t() != Modality.SEALED) {
            return CollectionsKt__CollectionsKt.E();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!z) {
            kVar2 = dVar.b();
        } else {
            Iterator<h.p2.b0.g.t.c.k> it = DescriptorUtilsKt.m(dVar).iterator();
            while (true) {
                if (!it.hasNext()) {
                    kVar = null;
                    break;
                }
                kVar = it.next();
                if (kVar instanceof b0) {
                    break;
                }
            }
            kVar2 = kVar;
        }
        if (kVar2 instanceof b0) {
            b(dVar, linkedHashSet, ((b0) kVar2).q(), z);
        }
        b(dVar, linkedHashSet, dVar.U(), true);
        return linkedHashSet;
    }
}
