package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1;

import android.util.Log;

/* loaded from: classes.dex */
public final class j {
    public static void a(String str) {
        if (bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.f().d()) {
            Log.i("npth", str);
        }
    }

    public static void a(Throwable th) {
        if (bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.f().d()) {
            Log.e("npth", "NPTH Catch Error", th);
        }
    }

    public static void b(Throwable th) {
        if (bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i.f().d()) {
            Log.w("npth", "NPTH Catch Error", th);
        }
    }
}
