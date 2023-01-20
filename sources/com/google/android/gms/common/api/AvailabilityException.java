package com.google.android.gms.common.api;

import android.text.TextUtils;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import e.j.a.b.c.n.a;
import e.j.a.b.c.n.h;
import e.j.a.b.c.n.u.z2;
import e.j.a.b.c.r.a0;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class AvailabilityException extends Exception {
    private final ArrayMap<z2<?>, ConnectionResult> zaay;

    public AvailabilityException(ArrayMap<z2<?>, ConnectionResult> arrayMap) {
        this.zaay = arrayMap;
    }

    public ConnectionResult getConnectionResult(h<? extends a.d> hVar) {
        z2<? extends a.d> w = hVar.w();
        a0.b(this.zaay.get(w) != null, "The given API was not part of the availability request.");
        return this.zaay.get(w);
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z = true;
        for (z2<?> z2Var : this.zaay.keySet()) {
            ConnectionResult connectionResult = this.zaay.get(z2Var);
            if (connectionResult.isSuccess()) {
                z = false;
            }
            String c2 = z2Var.c();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(c2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(c2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        if (z) {
            sb2.append("None of the queried APIs are available. ");
        } else {
            sb2.append("Some of the queried APIs are unavailable. ");
        }
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }

    public final ArrayMap<z2<?>, ConnectionResult> zaj() {
        return this.zaay;
    }
}
