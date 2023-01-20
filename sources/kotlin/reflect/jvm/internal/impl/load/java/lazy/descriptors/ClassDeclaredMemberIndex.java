package kotlin.reflect.jvm.internal.impl.load.java.lazy.descriptors;

import h.a2.s0;
import h.a2.u;
import h.k2.u.l;
import h.p2.b0.g.t.e.a.v.i.a;
import h.p2.b0.g.t.e.a.x.g;
import h.p2.b0.g.t.e.a.x.n;
import h.p2.b0.g.t.e.a.x.q;
import h.p2.b0.g.t.e.a.x.r;
import h.p2.b0.g.t.e.a.x.t;
import h.p2.b0.g.t.e.a.x.w;
import h.p2.b0.g.t.g.f;
import h.q2.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.sequences.SequencesKt___SequencesKt;

/* loaded from: classes3.dex */
public class ClassDeclaredMemberIndex implements a {
    @d
    private final g a;
    @d
    private final l<q, Boolean> b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final l<r, Boolean> f16507c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private final Map<f, List<r>> f16508d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final Map<f, n> f16509e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final Map<f, w> f16510f;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassDeclaredMemberIndex(@d g gVar, @d l<? super q, Boolean> lVar) {
        this.a = gVar;
        this.b = lVar;
        ClassDeclaredMemberIndex$methodFilter$1 classDeclaredMemberIndex$methodFilter$1 = new ClassDeclaredMemberIndex$methodFilter$1(this);
        this.f16507c = classDeclaredMemberIndex$methodFilter$1;
        m i0 = SequencesKt___SequencesKt.i0(CollectionsKt___CollectionsKt.n1(gVar.B()), classDeclaredMemberIndex$methodFilter$1);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Object obj : i0) {
            f name = ((r) obj).getName();
            Object obj2 = linkedHashMap.get(name);
            if (obj2 == null) {
                obj2 = new ArrayList();
                linkedHashMap.put(name, obj2);
            }
            ((List) obj2).add(obj);
        }
        this.f16508d = linkedHashMap;
        m i02 = SequencesKt___SequencesKt.i0(CollectionsKt___CollectionsKt.n1(this.a.y()), this.b);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Object obj3 : i02) {
            linkedHashMap2.put(((n) obj3).getName(), obj3);
        }
        this.f16509e = linkedHashMap2;
        Collection<w> i2 = this.a.i();
        l<q, Boolean> lVar2 = this.b;
        ArrayList arrayList = new ArrayList();
        for (Object obj4 : i2) {
            if (((Boolean) lVar2.invoke(obj4)).booleanValue()) {
                arrayList.add(obj4);
            }
        }
        LinkedHashMap linkedHashMap3 = new LinkedHashMap(h.o2.q.n(s0.j(u.Y(arrayList, 10)), 16));
        for (Object obj5 : arrayList) {
            linkedHashMap3.put(((w) obj5).getName(), obj5);
        }
        this.f16510f = linkedHashMap3;
    }

    @Override // h.p2.b0.g.t.e.a.v.i.a
    @d
    public Set<f> a() {
        m<t> i0 = SequencesKt___SequencesKt.i0(CollectionsKt___CollectionsKt.n1(this.a.B()), this.f16507c);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (t tVar : i0) {
            linkedHashSet.add(tVar.getName());
        }
        return linkedHashSet;
    }

    @Override // h.p2.b0.g.t.e.a.v.i.a
    @d
    public Set<f> b() {
        return this.f16510f.keySet();
    }

    @Override // h.p2.b0.g.t.e.a.v.i.a
    @d
    public Set<f> c() {
        m<t> i0 = SequencesKt___SequencesKt.i0(CollectionsKt___CollectionsKt.n1(this.a.y()), this.b);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (t tVar : i0) {
            linkedHashSet.add(tVar.getName());
        }
        return linkedHashSet;
    }

    @Override // h.p2.b0.g.t.e.a.v.i.a
    @d
    public Collection<r> d(@d f fVar) {
        List<r> list = this.f16508d.get(fVar);
        return list == null ? CollectionsKt__CollectionsKt.E() : list;
    }

    @Override // h.p2.b0.g.t.e.a.v.i.a
    @e
    public w e(@d f fVar) {
        return this.f16510f.get(fVar);
    }

    @Override // h.p2.b0.g.t.e.a.v.i.a
    @e
    public n f(@d f fVar) {
        return this.f16509e.get(fVar);
    }
}
