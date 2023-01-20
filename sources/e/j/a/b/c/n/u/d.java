package e.j.a.b.c.n.u;

import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import e.j.a.b.c.n.a;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class d {

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface b<R> {
        @e.j.a.b.c.m.a
        void a(Status status);

        @e.j.a.b.c.m.a
        void setResult(R r);
    }

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public static abstract class a<R extends e.j.a.b.c.n.p, A extends a.b> extends BasePendingResult<R> implements b<R> {
        @e.j.a.b.c.m.a
        private final a.c<A> q;
        @e.j.a.b.c.m.a
        private final e.j.a.b.c.n.a<?> r;

        @e.j.a.b.c.m.a
        @Deprecated
        public a(@NonNull a.c<A> cVar, @NonNull e.j.a.b.c.n.i iVar) {
            super((e.j.a.b.c.n.i) e.j.a.b.c.r.a0.l(iVar, "GoogleApiClient must not be null"));
            this.q = (a.c) e.j.a.b.c.r.a0.k(cVar);
            this.r = null;
        }

        @e.j.a.b.c.m.a
        private void A(@NonNull RemoteException remoteException) {
            a(new Status(8, remoteException.getLocalizedMessage(), null));
        }

        @Override // e.j.a.b.c.n.u.d.b
        @e.j.a.b.c.m.a
        public final void a(@NonNull Status status) {
            e.j.a.b.c.r.a0.b(!status.isSuccess(), "Failed result must not be success");
            R k2 = k(status);
            setResult((a<R, A>) k2);
            y(k2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // e.j.a.b.c.n.u.d.b
        @e.j.a.b.c.m.a
        public /* bridge */ /* synthetic */ void setResult(Object obj) {
            super.setResult((a<R, A>) ((e.j.a.b.c.n.p) obj));
        }

        @e.j.a.b.c.m.a
        public abstract void v(@NonNull A a) throws RemoteException;

        @e.j.a.b.c.m.a
        public final e.j.a.b.c.n.a<?> w() {
            return this.r;
        }

        @e.j.a.b.c.m.a
        public final a.c<A> x() {
            return this.q;
        }

        @e.j.a.b.c.m.a
        public void y(@NonNull R r) {
        }

        @e.j.a.b.c.m.a
        public final void z(@NonNull A a) throws DeadObjectException {
            if (a instanceof e.j.a.b.c.r.e0) {
                a = ((e.j.a.b.c.r.e0) a).o0();
            }
            try {
                v(a);
            } catch (DeadObjectException e2) {
                A(e2);
                throw e2;
            } catch (RemoteException e3) {
                A(e3);
            }
        }

        @e.j.a.b.c.m.a
        public a(@NonNull e.j.a.b.c.n.a<?> aVar, @NonNull e.j.a.b.c.n.i iVar) {
            super((e.j.a.b.c.n.i) e.j.a.b.c.r.a0.l(iVar, "GoogleApiClient must not be null"));
            e.j.a.b.c.r.a0.l(aVar, "Api must not be null");
            this.q = (a.c<A>) aVar.a();
            this.r = aVar;
        }

        @e.j.a.b.c.m.a
        @VisibleForTesting
        public a(@NonNull BasePendingResult.a<R> aVar) {
            super(aVar);
            this.q = null;
            this.r = null;
        }
    }
}
