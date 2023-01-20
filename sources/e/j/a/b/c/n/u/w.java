package e.j.a.b.c.n.u;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.Feature;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.a.b;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class w<A extends a.b, ResultT> {
    private final Feature[] a;
    private final boolean b;

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static class a<A extends a.b, ResultT> {
        private r<A, e.j.a.b.j.l<ResultT>> a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private Feature[] f10330c;

        private a() {
            this.b = true;
        }

        @e.j.a.b.c.m.a
        public w<A, ResultT> a() {
            e.j.a.b.c.r.a0.b(this.a != null, "execute parameter required");
            return new l2(this, this.f10330c, this.b);
        }

        @e.j.a.b.c.m.a
        @Deprecated
        public a<A, ResultT> b(e.j.a.b.c.x.d<A, e.j.a.b.j.l<ResultT>> dVar) {
            this.a = new r(dVar) { // from class: e.j.a.b.c.n.u.k2
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
        public a<A, ResultT> c(r<A, e.j.a.b.j.l<ResultT>> rVar) {
            this.a = rVar;
            return this;
        }

        @e.j.a.b.c.m.a
        public a<A, ResultT> d(boolean z) {
            this.b = z;
            return this;
        }

        @e.j.a.b.c.m.a
        public a<A, ResultT> e(Feature... featureArr) {
            this.f10330c = featureArr;
            return this;
        }
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public w() {
        this.a = null;
        this.b = false;
    }

    @e.j.a.b.c.m.a
    public static <A extends a.b, ResultT> a<A, ResultT> a() {
        return new a<>();
    }

    @e.j.a.b.c.m.a
    public abstract void b(A a2, e.j.a.b.j.l<ResultT> lVar) throws RemoteException;

    @e.j.a.b.c.m.a
    public boolean c() {
        return this.b;
    }

    @Nullable
    public final Feature[] d() {
        return this.a;
    }

    @e.j.a.b.c.m.a
    private w(Feature[] featureArr, boolean z) {
        this.a = featureArr;
        this.b = z;
    }
}
