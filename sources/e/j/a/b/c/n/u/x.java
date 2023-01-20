package e.j.a.b.c.n.u;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class x {
    @e.j.a.b.c.m.a
    public static void a(Status status, e.j.a.b.j.l<Void> lVar) {
        b(status, null, lVar);
    }

    @e.j.a.b.c.m.a
    public static <TResult> void b(Status status, TResult tresult, e.j.a.b.j.l<TResult> lVar) {
        if (status.isSuccess()) {
            lVar.setResult(tresult);
        } else {
            lVar.b(new ApiException(status));
        }
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static e.j.a.b.j.k<Void> c(e.j.a.b.j.k<Boolean> kVar) {
        return kVar.m(new m2());
    }
}
