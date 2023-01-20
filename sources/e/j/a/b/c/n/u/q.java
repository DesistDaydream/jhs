package e.j.a.b.c.n.u;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.a.b;
import e.j.a.b.c.n.u.q;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class q<A extends a.b, L> {
    public final p<A, L> a;
    public final y<A, L> b;

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static class a<A extends a.b, L> {
        private r<A, e.j.a.b.j.l<Void>> a;
        private r<A, e.j.a.b.j.l<Boolean>> b;

        /* renamed from: c */
        private l<L> f10312c;

        /* renamed from: d */
        private Feature[] f10313d;

        /* renamed from: e */
        private boolean f10314e;

        private a() {
            this.f10314e = true;
        }

        @e.j.a.b.c.m.a
        public q<A, L> a() {
            e.j.a.b.c.r.a0.b(this.a != null, "Must set register function");
            e.j.a.b.c.r.a0.b(this.b != null, "Must set unregister function");
            e.j.a.b.c.r.a0.b(this.f10312c != null, "Must set holder");
            return new q<>(new b2(this, this.f10312c, this.f10313d, this.f10314e), new c2(this, this.f10312c.b()));
        }

        @e.j.a.b.c.m.a
        public a<A, L> b(r<A, e.j.a.b.j.l<Void>> rVar) {
            this.a = rVar;
            return this;
        }

        @e.j.a.b.c.m.a
        @Deprecated
        public a<A, L> c(e.j.a.b.c.x.d<A, e.j.a.b.j.l<Void>> dVar) {
            this.a = new r(dVar) { // from class: e.j.a.b.c.n.u.y1
                private final e.j.a.b.c.x.d a;

                {
                    this.a = dVar;
                }

                @Override // e.j.a.b.c.n.u.r
                public final void a(Object obj, Object obj2) {
                    this.a.a((a.b) obj, (e.j.a.b.j.l) obj2);
                }
            };
            return this;
        }

        @e.j.a.b.c.m.a
        public a<A, L> d(boolean z) {
            this.f10314e = z;
            return this;
        }

        @e.j.a.b.c.m.a
        public a<A, L> e(Feature[] featureArr) {
            this.f10313d = featureArr;
            return this;
        }

        @e.j.a.b.c.m.a
        public a<A, L> f(r<A, e.j.a.b.j.l<Boolean>> rVar) {
            this.b = rVar;
            return this;
        }

        @e.j.a.b.c.m.a
        @Deprecated
        public a<A, L> g(e.j.a.b.c.x.d<A, e.j.a.b.j.l<Boolean>> dVar) {
            this.a = new r(this) { // from class: e.j.a.b.c.n.u.z1
                private final q.a a;

                {
                    this.a = this;
                }

                @Override // e.j.a.b.c.n.u.r
                public final void a(Object obj, Object obj2) {
                    this.a.j((a.b) obj, (e.j.a.b.j.l) obj2);
                }
            };
            return this;
        }

        @e.j.a.b.c.m.a
        public a<A, L> h(l<L> lVar) {
            this.f10312c = lVar;
            return this;
        }

        public final /* synthetic */ void j(a.b bVar, e.j.a.b.j.l lVar) throws RemoteException {
            this.a.a(bVar, lVar);
        }
    }

    private q(p<A, L> pVar, y<A, L> yVar) {
        this.a = pVar;
        this.b = yVar;
    }

    @e.j.a.b.c.m.a
    public static <A extends a.b, L> a<A, L> a() {
        return new a<>();
    }
}
