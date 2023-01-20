package h.p2.b0.g.t.k.r;

import h.a2.d1;
import h.a2.y;
import h.k2.u.l;
import h.k2.v.u;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.n0;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public final class b implements MemberScope {
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    public static final a f15478d = new a(null);
    @k.e.a.d
    private final String b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final MemberScope[] f15479c;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.d
        public final MemberScope a(@k.e.a.d String str, @k.e.a.d Iterable<? extends MemberScope> iterable) {
            h.p2.b0.g.t.p.d dVar = new h.p2.b0.g.t.p.d();
            for (MemberScope memberScope : iterable) {
                if (memberScope != MemberScope.b.b) {
                    if (memberScope instanceof b) {
                        y.s0(dVar, ((b) memberScope).f15479c);
                    } else {
                        dVar.add(memberScope);
                    }
                }
            }
            return b(str, dVar);
        }

        @k.e.a.d
        public final MemberScope b(@k.e.a.d String str, @k.e.a.d List<? extends MemberScope> list) {
            int size = list.size();
            if (size != 0) {
                if (size != 1) {
                    Object[] array = list.toArray(new MemberScope[0]);
                    Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
                    return new b(str, (MemberScope[]) array, null);
                }
                return list.get(0);
            }
            return MemberScope.b.b;
        }
    }

    private b(String str, MemberScope[] memberScopeArr) {
        this.b = str;
        this.f15479c = memberScopeArr;
    }

    public /* synthetic */ b(String str, MemberScope[] memberScopeArr, u uVar) {
        this(str, memberScopeArr);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @k.e.a.d
    public Collection<n0> a(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        MemberScope[] memberScopeArr = this.f15479c;
        int length = memberScopeArr.length;
        if (length != 0) {
            int i2 = 0;
            if (length != 1) {
                Collection<n0> collection = null;
                int length2 = memberScopeArr.length;
                while (i2 < length2) {
                    MemberScope memberScope = memberScopeArr[i2];
                    i2++;
                    collection = h.p2.b0.g.t.o.k.a.a(collection, memberScope.a(fVar, bVar));
                }
                return collection == null ? d1.k() : collection;
            }
            return memberScopeArr[0].a(fVar, bVar);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> b() {
        MemberScope[] memberScopeArr = this.f15479c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            y.q0(linkedHashSet, memberScope.b());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Collection<j0> c(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        MemberScope[] memberScopeArr = this.f15479c;
        int length = memberScopeArr.length;
        if (length != 0) {
            int i2 = 0;
            if (length != 1) {
                Collection<j0> collection = null;
                int length2 = memberScopeArr.length;
                while (i2 < length2) {
                    MemberScope memberScope = memberScopeArr[i2];
                    i2++;
                    collection = h.p2.b0.g.t.o.k.a.a(collection, memberScope.c(fVar, bVar));
                }
                return collection == null ? d1.k() : collection;
            }
            return memberScopeArr[0].c(fVar, bVar);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.d
    public Set<h.p2.b0.g.t.g.f> d() {
        MemberScope[] memberScopeArr = this.f15479c;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (MemberScope memberScope : memberScopeArr) {
            y.q0(linkedHashSet, memberScope.d());
        }
        return linkedHashSet;
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @k.e.a.e
    public Set<h.p2.b0.g.t.g.f> e() {
        return g.a(ArraysKt___ArraysKt.Y4(this.f15479c));
    }

    @Override // h.p2.b0.g.t.k.r.h
    @k.e.a.e
    public h.p2.b0.g.t.c.f f(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        MemberScope[] memberScopeArr = this.f15479c;
        int length = memberScopeArr.length;
        h.p2.b0.g.t.c.f fVar2 = null;
        int i2 = 0;
        while (i2 < length) {
            MemberScope memberScope = memberScopeArr[i2];
            i2++;
            h.p2.b0.g.t.c.f f2 = memberScope.f(fVar, bVar);
            if (f2 != null) {
                if (!(f2 instanceof h.p2.b0.g.t.c.g) || !((h.p2.b0.g.t.c.g) f2).i0()) {
                    return f2;
                }
                if (fVar2 == null) {
                    fVar2 = f2;
                }
            }
        }
        return fVar2;
    }

    @Override // h.p2.b0.g.t.k.r.h
    @k.e.a.d
    public Collection<k> g(@k.e.a.d d dVar, @k.e.a.d l<? super h.p2.b0.g.t.g.f, Boolean> lVar) {
        MemberScope[] memberScopeArr = this.f15479c;
        int length = memberScopeArr.length;
        if (length != 0) {
            int i2 = 0;
            if (length != 1) {
                Collection<k> collection = null;
                int length2 = memberScopeArr.length;
                while (i2 < length2) {
                    MemberScope memberScope = memberScopeArr[i2];
                    i2++;
                    collection = h.p2.b0.g.t.o.k.a.a(collection, memberScope.g(dVar, lVar));
                }
                return collection == null ? d1.k() : collection;
            }
            return memberScopeArr[0].g(dVar, lVar);
        }
        return CollectionsKt__CollectionsKt.E();
    }

    @Override // h.p2.b0.g.t.k.r.h
    public void h(@k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d h.p2.b0.g.t.d.b.b bVar) {
        for (MemberScope memberScope : this.f15479c) {
            memberScope.h(fVar, bVar);
        }
    }

    @k.e.a.d
    public String toString() {
        return this.b;
    }
}
