package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.k2.k;
import h.k2.u.l;
import h.k2.v.u;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.r.b;
import h.p2.b0.g.t.n.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import k.e.a.d;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtilsKt;

/* loaded from: classes3.dex */
public final class TypeIntersectionScope extends h.p2.b0.g.t.k.r.a {
    @d

    /* renamed from: d  reason: collision with root package name */
    public static final a f16789d = new a(null);
    @d
    private final String b;
    @d

    /* renamed from: c  reason: collision with root package name */
    private final MemberScope f16790c;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k
        @d
        public final MemberScope a(@d String str, @d Collection<? extends z> collection) {
            ArrayList arrayList = new ArrayList(h.a2.u.Y(collection, 10));
            for (z zVar : collection) {
                arrayList.add(zVar.q());
            }
            h.p2.b0.g.t.p.d<MemberScope> b = h.p2.b0.g.t.o.k.a.b(arrayList);
            MemberScope b2 = b.f15478d.b(str, b);
            return b.size() <= 1 ? b2 : new TypeIntersectionScope(str, b2, null);
        }
    }

    private TypeIntersectionScope(String str, MemberScope memberScope) {
        this.b = str;
        this.f16790c = memberScope;
    }

    public /* synthetic */ TypeIntersectionScope(String str, MemberScope memberScope, u uVar) {
        this(str, memberScope);
    }

    @k
    @d
    public static final MemberScope k(@d String str, @d Collection<? extends z> collection) {
        return f16789d.a(str, collection);
    }

    @Override // h.p2.b0.g.t.k.r.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope, h.p2.b0.g.t.k.r.h
    @d
    public Collection<n0> a(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        return OverridingUtilsKt.a(super.a(fVar, bVar), TypeIntersectionScope$getContributedFunctions$1.INSTANCE);
    }

    @Override // h.p2.b0.g.t.k.r.a, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
    @d
    public Collection<j0> c(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
        return OverridingUtilsKt.a(super.c(fVar, bVar), TypeIntersectionScope$getContributedVariables$1.INSTANCE);
    }

    @Override // h.p2.b0.g.t.k.r.a, h.p2.b0.g.t.k.r.h
    @d
    public Collection<h.p2.b0.g.t.c.k> g(@d h.p2.b0.g.t.k.r.d dVar, @d l<? super f, Boolean> lVar) {
        Collection<h.p2.b0.g.t.c.k> g2 = super.g(dVar, lVar);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : g2) {
            if (((h.p2.b0.g.t.c.k) obj) instanceof h.p2.b0.g.t.c.a) {
                arrayList.add(obj);
            } else {
                arrayList2.add(obj);
            }
        }
        Pair pair = new Pair(arrayList, arrayList2);
        return CollectionsKt___CollectionsKt.q4(OverridingUtilsKt.a((List) pair.component1(), TypeIntersectionScope$getContributedDescriptors$2.INSTANCE), (List) pair.component2());
    }

    @Override // h.p2.b0.g.t.k.r.a
    @d
    public MemberScope j() {
        return this.f16790c;
    }
}
