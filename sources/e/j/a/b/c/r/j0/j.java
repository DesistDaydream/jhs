package e.j.a.b.c.r.j0;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import e.j.a.b.c.n.i;

/* loaded from: classes2.dex */
public final class j extends e.j.a.b.c.r.k<m> {
    public j(Context context, Looper looper, e.j.a.b.c.r.f fVar, i.b bVar, i.c cVar) {
        super(context, looper, 39, fVar, bVar, cVar);
    }

    @Override // e.j.a.b.c.r.e
    public final String c() {
        return "com.google.android.gms.common.service.START";
    }

    @Override // e.j.a.b.c.r.e
    public final String q() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    @Override // e.j.a.b.c.r.e
    public final /* synthetic */ IInterface r(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
        if (queryLocalInterface instanceof m) {
            return (m) queryLocalInterface;
        }
        return new n(iBinder);
    }
}
