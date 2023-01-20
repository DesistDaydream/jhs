package h.p2.b0.g.t.m;

import h.t1;

/* loaded from: classes3.dex */
public interface j {
    @k.e.a.d
    public static final a a = a.a;

    /* loaded from: classes3.dex */
    public static final class a {
        public static final /* synthetic */ a a = new a();

        private a() {
        }

        @k.e.a.d
        public final d a(@k.e.a.e Runnable runnable, @k.e.a.e h.k2.u.l<? super InterruptedException, t1> lVar) {
            if (runnable != null && lVar != null) {
                return new c(runnable, lVar);
            }
            return new d(null, 1, null);
        }
    }

    void lock();

    void unlock();
}
