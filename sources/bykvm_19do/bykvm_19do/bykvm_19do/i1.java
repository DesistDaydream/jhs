package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import bykvm_19do.bykvm_19do.bykvm_19do.j1;
import bykvm_19do.bykvm_19do.bykvm_19do.n1;

/* loaded from: classes.dex */
public final class i1 extends p0<n1> {

    /* loaded from: classes.dex */
    public class a implements j1.b<n1, String> {
        public a(i1 i1Var) {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        public String a(n1 n1Var) {
            return n1Var.a();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_19do.j1.b
        /* renamed from: b */
        public n1 a(IBinder iBinder) {
            return n1.a.a(iBinder);
        }
    }

    public i1() {
        super("com.samsung.android.deviceidservice");
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0
    public j1.b<n1, String> a() {
        return new a(this);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.p0
    public Intent c(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        return intent;
    }
}
