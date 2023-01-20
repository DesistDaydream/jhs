package e.j.a.b.c.n;

import android.os.Looper;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import e.j.a.b.c.r.a0;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class l {

    /* loaded from: classes2.dex */
    public static final class a<R extends p> extends BasePendingResult<R> {
        private final R q;

        public a(R r) {
            super(Looper.getMainLooper());
            this.q = r;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R k(Status status) {
            if (status.getStatusCode() == this.q.getStatus().getStatusCode()) {
                return this.q;
            }
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    /* loaded from: classes2.dex */
    public static final class b<R extends p> extends BasePendingResult<R> {
        private final R q;

        public b(i iVar, R r) {
            super(iVar);
            this.q = r;
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R k(Status status) {
            return this.q;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c<R extends p> extends BasePendingResult<R> {
        public c(i iVar) {
            super(iVar);
        }

        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public final R k(Status status) {
            throw new UnsupportedOperationException("Creating failed results is not supported");
        }
    }

    @e.j.a.b.c.m.a
    private l() {
    }

    public static k<Status> a() {
        e.j.a.b.c.n.u.v vVar = new e.j.a.b.c.n.u.v(Looper.getMainLooper());
        vVar.e();
        return vVar;
    }

    public static <R extends p> k<R> b(R r) {
        a0.l(r, "Result must not be null");
        a0.b(r.getStatus().getStatusCode() == 16, "Status code must be CommonStatusCodes.CANCELED");
        a aVar = new a(r);
        aVar.e();
        return aVar;
    }

    @e.j.a.b.c.m.a
    public static <R extends p> k<R> c(R r, i iVar) {
        a0.l(r, "Result must not be null");
        a0.b(!r.getStatus().isSuccess(), "Status code must not be SUCCESS");
        b bVar = new b(iVar, r);
        bVar.setResult(r);
        return bVar;
    }

    @e.j.a.b.c.m.a
    public static <R extends p> j<R> d(R r) {
        a0.l(r, "Result must not be null");
        c cVar = new c(null);
        cVar.setResult(r);
        return new e.j.a.b.c.n.u.n(cVar);
    }

    @e.j.a.b.c.m.a
    public static <R extends p> j<R> e(R r, i iVar) {
        a0.l(r, "Result must not be null");
        c cVar = new c(iVar);
        cVar.setResult(r);
        return new e.j.a.b.c.n.u.n(cVar);
    }

    @e.j.a.b.c.m.a
    public static k<Status> f(Status status) {
        a0.l(status, "Result must not be null");
        e.j.a.b.c.n.u.v vVar = new e.j.a.b.c.n.u.v(Looper.getMainLooper());
        vVar.setResult(status);
        return vVar;
    }

    @e.j.a.b.c.m.a
    public static k<Status> g(Status status, i iVar) {
        a0.l(status, "Result must not be null");
        e.j.a.b.c.n.u.v vVar = new e.j.a.b.c.n.u.v(iVar);
        vVar.setResult(status);
        return vVar;
    }
}
