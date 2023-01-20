package e.j.a.b.c.n;

import com.google.android.gms.common.api.Status;
import e.j.a.b.c.r.a0;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public final class c implements p {
    private final Status a;
    private final k<?>[] b;

    public c(Status status, k<?>[] kVarArr) {
        this.a = status;
        this.b = kVarArr;
    }

    public final <R extends p> R a(d<R> dVar) {
        a0.b(dVar.a < this.b.length, "The result token does not belong to this batch");
        return (R) this.b[dVar.a].d(0L, TimeUnit.MILLISECONDS);
    }

    @Override // e.j.a.b.c.n.p
    public final Status getStatus() {
        return this.a;
    }
}
