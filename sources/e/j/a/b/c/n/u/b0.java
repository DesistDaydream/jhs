package e.j.a.b.c.n.u;

import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class b0 {
    private final Map<BasePendingResult<?>, Boolean> a = Collections.synchronizedMap(new WeakHashMap());
    private final Map<e.j.a.b.j.l<?>, Boolean> b = Collections.synchronizedMap(new WeakHashMap());

    private final void d(boolean z, Status status) {
        HashMap hashMap;
        HashMap hashMap2;
        synchronized (this.a) {
            hashMap = new HashMap(this.a);
        }
        synchronized (this.b) {
            hashMap2 = new HashMap(this.b);
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            if (z || ((Boolean) entry.getValue()).booleanValue()) {
                ((BasePendingResult) entry.getKey()).s(status);
            }
        }
        for (Map.Entry entry2 : hashMap2.entrySet()) {
            if (z || ((Boolean) entry2.getValue()).booleanValue()) {
                ((e.j.a.b.j.l) entry2.getKey()).c(new ApiException(status));
            }
        }
    }

    public final void b(BasePendingResult<? extends e.j.a.b.c.n.p> basePendingResult, boolean z) {
        this.a.put(basePendingResult, Boolean.valueOf(z));
        basePendingResult.b(new c0(this, basePendingResult));
    }

    public final <TResult> void c(e.j.a.b.j.l<TResult> lVar, boolean z) {
        this.b.put(lVar, Boolean.valueOf(z));
        lVar.a().e(new d0(this, lVar));
    }

    public final boolean e() {
        return (this.a.isEmpty() && this.b.isEmpty()) ? false : true;
    }

    public final void f() {
        d(false, g.n);
    }

    public final void g() {
        d(true, q2.f10317d);
    }
}
