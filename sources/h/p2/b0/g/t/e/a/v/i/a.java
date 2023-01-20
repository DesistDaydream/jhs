package h.p2.b0.g.t.e.a.v.i;

import h.a2.d1;
import h.p2.b0.g.t.e.a.x.n;
import h.p2.b0.g.t.e.a.x.r;
import h.p2.b0.g.t.e.a.x.w;
import h.p2.b0.g.t.g.f;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: h.p2.b0.g.t.e.a.v.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0444a implements a {
        @k.e.a.d
        public static final C0444a a = new C0444a();

        private C0444a() {
        }

        @Override // h.p2.b0.g.t.e.a.v.i.a
        @k.e.a.d
        public Set<f> a() {
            return d1.k();
        }

        @Override // h.p2.b0.g.t.e.a.v.i.a
        @k.e.a.d
        public Set<f> b() {
            return d1.k();
        }

        @Override // h.p2.b0.g.t.e.a.v.i.a
        @k.e.a.d
        public Set<f> c() {
            return d1.k();
        }

        @Override // h.p2.b0.g.t.e.a.v.i.a
        @e
        public w e(@k.e.a.d f fVar) {
            return null;
        }

        @Override // h.p2.b0.g.t.e.a.v.i.a
        @e
        public n f(@k.e.a.d f fVar) {
            return null;
        }

        @Override // h.p2.b0.g.t.e.a.v.i.a
        @k.e.a.d
        /* renamed from: g */
        public List<r> d(@k.e.a.d f fVar) {
            return CollectionsKt__CollectionsKt.E();
        }
    }

    @k.e.a.d
    Set<f> a();

    @k.e.a.d
    Set<f> b();

    @k.e.a.d
    Set<f> c();

    @k.e.a.d
    Collection<r> d(@k.e.a.d f fVar);

    @e
    w e(@k.e.a.d f fVar);

    @e
    n f(@k.e.a.d f fVar);
}
