package e.j.a.b.c.n;

import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.k;

/* loaded from: classes2.dex */
public final class v implements k.a {
    private final /* synthetic */ b a;

    public v(b bVar) {
        this.a = bVar;
    }

    @Override // e.j.a.b.c.n.k.a
    public final void a(Status status) {
        Object obj;
        int i2;
        boolean z;
        boolean z2;
        Status status2;
        k[] kVarArr;
        obj = this.a.u;
        synchronized (obj) {
            if (this.a.f()) {
                return;
            }
            if (status.isCanceled()) {
                this.a.s = true;
            } else if (!status.isSuccess()) {
                this.a.r = true;
            }
            b.y(this.a);
            i2 = this.a.q;
            if (i2 == 0) {
                z = this.a.s;
                if (z) {
                    super/*com.google.android.gms.common.api.internal.BasePendingResult*/.e();
                } else {
                    z2 = this.a.r;
                    if (z2) {
                        status2 = new Status(13);
                    } else {
                        status2 = Status.RESULT_SUCCESS;
                    }
                    b bVar = this.a;
                    kVarArr = bVar.t;
                    bVar.setResult(new c(status2, kVarArr));
                }
            }
        }
    }
}
