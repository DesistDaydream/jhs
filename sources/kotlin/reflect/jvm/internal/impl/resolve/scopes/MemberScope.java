package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import h.a2.d1;
import h.k2.u.l;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.g.f;
import h.p2.b0.g.t.k.r.h;
import java.util.Collection;
import java.util.Set;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes3.dex */
public interface MemberScope extends h {
    @d
    public static final Companion a = Companion.a;

    /* loaded from: classes3.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();
        @d
        private static final l<f, Boolean> b = MemberScope$Companion$ALL_NAME_FILTER$1.INSTANCE;

        private Companion() {
        }

        @d
        public final l<f, Boolean> a() {
            return b;
        }
    }

    /* loaded from: classes3.dex */
    public static final class a {
        public static void a(@d MemberScope memberScope, @d f fVar, @d h.p2.b0.g.t.d.b.b bVar) {
            h.a.b(memberScope, fVar, bVar);
        }
    }

    /* loaded from: classes3.dex */
    public static final class b extends h.p2.b0.g.t.k.r.f {
        @d
        public static final b b = new b();

        private b() {
        }

        @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @d
        public Set<f> b() {
            return d1.k();
        }

        @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @d
        public Set<f> d() {
            return d1.k();
        }

        @Override // h.p2.b0.g.t.k.r.f, kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope
        @d
        public Set<f> e() {
            return d1.k();
        }
    }

    @Override // h.p2.b0.g.t.k.r.h
    @d
    Collection<? extends n0> a(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar);

    @d
    Set<f> b();

    @d
    Collection<? extends j0> c(@d f fVar, @d h.p2.b0.g.t.d.b.b bVar);

    @d
    Set<f> d();

    @e
    Set<f> e();
}
