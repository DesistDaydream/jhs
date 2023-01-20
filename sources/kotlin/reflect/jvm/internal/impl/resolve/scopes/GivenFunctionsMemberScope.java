package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.a2.y;
import h.k2.v.f0;
import h.k2.v.n0;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.d.b.b;
import h.p2.b0.g.t.k.r.f;
import h.p2.b0.g.t.k.r.h;
import h.p2.b0.g.t.m.h;
import h.p2.b0.g.t.m.l;
import h.p2.b0.g.t.m.m;
import h.p2.b0.g.t.n.z;
import h.p2.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* loaded from: classes3.dex */
public abstract class GivenFunctionsMemberScope extends f {

    /* renamed from: d  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f16782d = {n0.r(new PropertyReference1Impl(n0.d(GivenFunctionsMemberScope.class), "allDescriptors", "getAllDescriptors()Ljava/util/List;"))};
    @d
    private final h.p2.b0.g.t.c.d b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final h f16783c;

    /* loaded from: classes3.dex */
    public static final class a extends h.p2.b0.g.t.k.f {
        public final /* synthetic */ ArrayList<k> a;
        public final /* synthetic */ GivenFunctionsMemberScope b;

        public a(ArrayList<k> arrayList, GivenFunctionsMemberScope givenFunctionsMemberScope) {
            this.a = arrayList;
            this.b = givenFunctionsMemberScope;
        }

        @Override // h.p2.b0.g.t.k.g
        public void a(@d CallableMemberDescriptor callableMemberDescriptor) {
            OverridingUtil.L(callableMemberDescriptor, null);
            this.a.add(callableMemberDescriptor);
        }

        @Override // h.p2.b0.g.t.k.f
        public void e(@d CallableMemberDescriptor callableMemberDescriptor, @d CallableMemberDescriptor callableMemberDescriptor2) {
            throw new IllegalStateException(("Conflict in scope of " + this.b.m() + ": " + callableMemberDescriptor + " vs " + callableMemberDescriptor2).toString());
        }
    }

    public GivenFunctionsMemberScope(@d m mVar, @d h.p2.b0.g.t.c.d dVar) {
        this.b = dVar;
        this.f16783c = mVar.c(new GivenFunctionsMemberScope$allDescriptors$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final List<k> k(List<? extends v> list) {
        Collection<? extends CallableMemberDescriptor> E;
        ArrayList arrayList = new ArrayList(3);
        Collection<z> j2 = this.b.j().j();
        ArrayList arrayList2 = new ArrayList();
        for (z zVar : j2) {
            y.q0(arrayList2, h.a.a(zVar.q(), null, null, 3, null));
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (obj instanceof CallableMemberDescriptor) {
                arrayList3.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj2 : arrayList3) {
            h.p2.b0.g.t.g.f name = ((CallableMemberDescriptor) obj2).getName();
            Object obj3 = linkedHashMap.get(name);
            if (obj3 == null) {
                obj3 = new ArrayList();
                linkedHashMap.put(name, obj3);
            }
            ((List) obj3).add(obj2);
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            h.p2.b0.g.t.g.f fVar = (h.p2.b0.g.t.g.f) entry.getKey();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            for (Object obj4 : (List) entry.getValue()) {
                Boolean valueOf = Boolean.valueOf(((CallableMemberDescriptor) obj4) instanceof v);
                Object obj5 = linkedHashMap2.get(valueOf);
                if (obj5 == null) {
                    obj5 = new ArrayList();
                    linkedHashMap2.put(valueOf, obj5);
                }
                ((List) obj5).add(obj4);
            }
            for (Map.Entry entry2 : linkedHashMap2.entrySet()) {
                boolean booleanValue = ((Boolean) entry2.getKey()).booleanValue();
                List list2 = (List) entry2.getValue();
                OverridingUtil overridingUtil = OverridingUtil.f16771d;
                if (booleanValue) {
                    E = new ArrayList<>();
                    for (Object obj6 : list) {
                        if (f0.g(((v) obj6).getName(), fVar)) {
                            E.add(obj6);
                        }
                    }
                } else {
                    E = CollectionsKt__CollectionsKt.E();
                }
                overridingUtil.w(fVar, list2, E, this.b, new a(arrayList, this));
            }
        }
        return h.p2.b0.g.t.p.a.c(arrayList);
    }

    private final List<k> l() {
        return (List) l.a(this.f16783c, this, f16782d[0]);
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @d
    public Collection<h.p2.b0.g.t.c.n0> a(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
        List<k> l2 = l();
        h.p2.b0.g.t.p.d dVar = new h.p2.b0.g.t.p.d();
        for (Object obj : l2) {
            if ((obj instanceof h.p2.b0.g.t.c.n0) && f0.g(((h.p2.b0.g.t.c.n0) obj).getName(), fVar)) {
                dVar.add(obj);
            }
        }
        return dVar;
    }

    @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Collection<j0> c(@d h.p2.b0.g.t.g.f fVar, @d b bVar) {
        List<k> l2 = l();
        h.p2.b0.g.t.p.d dVar = new h.p2.b0.g.t.p.d();
        for (Object obj : l2) {
            if ((obj instanceof j0) && f0.g(((j0) obj).getName(), fVar)) {
                dVar.add(obj);
            }
        }
        return dVar;
    }

    @Override // h.p2.b0.g.t.k.r.f, h.p2.b0.g.t.k.r.h
    @d
    public Collection<k> g(@d h.p2.b0.g.t.k.r.d dVar, @d h.k2.u.l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        return !dVar.a(h.p2.b0.g.t.k.r.d.p.m()) ? CollectionsKt__CollectionsKt.E() : l();
    }

    @d
    public abstract List<v> j();

    @d
    public final h.p2.b0.g.t.c.d m() {
        return this.b;
    }
}
