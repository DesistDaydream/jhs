package e.j.a.b.c.n.u;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/* loaded from: classes2.dex */
public final class a0 implements e.j.a.b.j.e<Map<z2<?>, String>> {
    private s a;
    private final /* synthetic */ o3 b;

    public a0(o3 o3Var, s sVar) {
        this.b = o3Var;
        this.a = sVar;
    }

    public final void a() {
        this.a.onComplete();
    }

    @Override // e.j.a.b.j.e
    public final void onComplete(@NonNull e.j.a.b.j.k<Map<z2<?>, String>> kVar) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        Map map;
        Map map2;
        boolean n;
        Map map3;
        Map map4;
        Map map5;
        Map map6;
        ConnectionResult t;
        Condition condition;
        Map map7;
        Map map8;
        Map map9;
        lock = this.b.f10303f;
        lock.lock();
        try {
            z = this.b.n;
            if (!z) {
                this.a.onComplete();
                return;
            }
            if (kVar.v()) {
                o3 o3Var = this.b;
                map7 = o3Var.b;
                o3Var.p = new ArrayMap(map7.size());
                map8 = this.b.b;
                for (n3 n3Var : map8.values()) {
                    map9 = this.b.p;
                    map9.put(n3Var.w(), ConnectionResult.RESULT_SUCCESS);
                }
            } else if (kVar.q() instanceof AvailabilityException) {
                AvailabilityException availabilityException = (AvailabilityException) kVar.q();
                z2 = this.b.f10309l;
                if (!z2) {
                    this.b.p = availabilityException.zaj();
                } else {
                    o3 o3Var2 = this.b;
                    map = o3Var2.b;
                    o3Var2.p = new ArrayMap(map.size());
                    map2 = this.b.b;
                    for (n3 n3Var2 : map2.values()) {
                        Object w = n3Var2.w();
                        ConnectionResult connectionResult = availabilityException.getConnectionResult(n3Var2);
                        n = this.b.n(n3Var2, connectionResult);
                        if (n) {
                            map3 = this.b.p;
                            map3.put(w, new ConnectionResult(16));
                        } else {
                            map4 = this.b.p;
                            map4.put(w, connectionResult);
                        }
                    }
                }
            } else {
                Log.e("ConnectionlessGAC", "Unexpected availability exception", kVar.q());
                this.b.p = Collections.emptyMap();
            }
            if (this.b.isConnected()) {
                map5 = this.b.o;
                map6 = this.b.p;
                map5.putAll(map6);
                t = this.b.t();
                if (t == null) {
                    this.b.r();
                    this.b.s();
                    condition = this.b.f10306i;
                    condition.signalAll();
                }
            }
            this.a.onComplete();
        } finally {
            lock2 = this.b.f10303f;
            lock2.unlock();
        }
    }
}
