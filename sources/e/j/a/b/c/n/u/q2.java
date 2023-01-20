package e.j.a.b.c.n.u;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.u.d;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class q2 {

    /* renamed from: d */
    public static final Status f10317d = new Status(8, "The connection to Google Play services was lost");

    /* renamed from: e */
    private static final BasePendingResult<?>[] f10318e = new BasePendingResult[0];
    @e.j.a.b.c.x.d0
    public final Set<BasePendingResult<?>> a = Collections.synchronizedSet(Collections.newSetFromMap(new WeakHashMap()));
    private final t2 b = new r2(this);

    /* renamed from: c */
    private final Map<a.c<?>, a.f> f10319c;

    public q2(Map<a.c<?>, a.f> map) {
        this.f10319c = map;
    }

    public final void a() {
        BasePendingResult[] basePendingResultArr;
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.a.toArray(f10318e)) {
            e.j.a.b.c.n.x xVar = null;
            basePendingResult.q(null);
            if (basePendingResult.j() == null) {
                if (basePendingResult.t()) {
                    this.a.remove(basePendingResult);
                }
            } else {
                basePendingResult.g(null);
                IBinder k2 = this.f10319c.get(((d.a) basePendingResult).x()).k();
                if (basePendingResult.m()) {
                    basePendingResult.q(new s2(basePendingResult, null, k2, null));
                } else if (k2 != null && k2.isBinderAlive()) {
                    s2 s2Var = new s2(basePendingResult, null, k2, null);
                    basePendingResult.q(s2Var);
                    try {
                        k2.linkToDeath(s2Var, 0);
                    } catch (RemoteException unused) {
                        basePendingResult.e();
                        xVar.a(basePendingResult.j().intValue());
                    }
                } else {
                    basePendingResult.q(null);
                    basePendingResult.e();
                    xVar.a(basePendingResult.j().intValue());
                }
                this.a.remove(basePendingResult);
            }
        }
    }

    public final void b(BasePendingResult<? extends e.j.a.b.c.n.p> basePendingResult) {
        this.a.add(basePendingResult);
        basePendingResult.q(this.b);
    }

    public final void c() {
        for (BasePendingResult basePendingResult : (BasePendingResult[]) this.a.toArray(f10318e)) {
            basePendingResult.s(f10317d);
        }
    }
}
