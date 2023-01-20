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
public final class q3 implements e.j.a.b.j.e<Map<z2<?>, String>> {
    private final /* synthetic */ o3 a;

    private q3(o3 o3Var) {
        this.a = o3Var;
    }

    @Override // e.j.a.b.j.e
    public final void onComplete(@NonNull e.j.a.b.j.k<Map<z2<?>, String>> kVar) {
        Lock lock;
        Lock lock2;
        boolean z;
        boolean z2;
        ConnectionResult t;
        Map map;
        Map map2;
        boolean n;
        Map map3;
        Map map4;
        Map map5;
        ConnectionResult connectionResult;
        w0 w0Var;
        ConnectionResult connectionResult2;
        Condition condition;
        Map map6;
        Map map7;
        ConnectionResult t2;
        Map map8;
        Map map9;
        Map map10;
        lock = this.a.f10303f;
        lock.lock();
        try {
            z = this.a.n;
            if (z) {
                if (kVar.v()) {
                    o3 o3Var = this.a;
                    map8 = o3Var.a;
                    o3Var.o = new ArrayMap(map8.size());
                    map9 = this.a.a;
                    for (n3 n3Var : map9.values()) {
                        map10 = this.a.o;
                        map10.put(n3Var.w(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (kVar.q() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) kVar.q();
                    z2 = this.a.f10309l;
                    if (!z2) {
                        this.a.o = availabilityException.zaj();
                    } else {
                        o3 o3Var2 = this.a;
                        map = o3Var2.a;
                        o3Var2.o = new ArrayMap(map.size());
                        map2 = this.a.a;
                        for (n3 n3Var2 : map2.values()) {
                            Object w = n3Var2.w();
                            ConnectionResult connectionResult3 = availabilityException.getConnectionResult(n3Var2);
                            n = this.a.n(n3Var2, connectionResult3);
                            if (n) {
                                map3 = this.a.o;
                                map3.put(w, new ConnectionResult(16));
                            } else {
                                map4 = this.a.o;
                                map4.put(w, connectionResult3);
                            }
                        }
                    }
                    o3 o3Var3 = this.a;
                    t = o3Var3.t();
                    o3Var3.r = t;
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", kVar.q());
                    this.a.o = Collections.emptyMap();
                    this.a.r = new ConnectionResult(8);
                }
                map5 = this.a.p;
                if (map5 != null) {
                    map6 = this.a.o;
                    map7 = this.a.p;
                    map6.putAll(map7);
                    o3 o3Var4 = this.a;
                    t2 = o3Var4.t();
                    o3Var4.r = t2;
                }
                connectionResult = this.a.r;
                if (connectionResult == null) {
                    this.a.r();
                    this.a.s();
                } else {
                    this.a.n = false;
                    w0Var = this.a.f10302e;
                    connectionResult2 = this.a.r;
                    w0Var.b(connectionResult2);
                }
                condition = this.a.f10306i;
                condition.signalAll();
            }
        } finally {
            lock2 = this.a.f10303f;
            lock2.unlock();
        }
    }
}
