package bykvm_19do.bykvm_19do.bykvm_19do;

import android.util.Log;

/* loaded from: classes.dex */
public class l0 {
    public static boolean a;

    public static void a(String str, Throwable th) {
        if (a) {
            Log.d("TeaLog", str, th);
        }
    }

    public static void a(Throwable th) {
        Log.e("TeaLog", "U SHALL NOT PASS!", th);
    }

    public static void b(String str, Throwable th) {
        Log.w("TeaLog", str, th);
    }

    public static void c(String str, Throwable th) {
        Log.e("TeaLog", str, th);
    }

    public static void d(String str, Throwable th) {
        Log.i("TeaLog", str, th);
    }
}
