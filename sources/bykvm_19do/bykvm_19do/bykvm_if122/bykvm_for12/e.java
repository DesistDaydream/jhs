package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.y;

/* loaded from: classes.dex */
public class e {
    private static int a = -1;
    private static long b;

    public static int a(Context context) {
        if (a == -1 || System.currentTimeMillis() - b > com.heytap.mcssdk.constant.a.f3314d) {
            a = y.b(context);
            b = System.currentTimeMillis();
        }
        return a;
    }

    public static int b(Context context) {
        return y.a(a(context));
    }

    public static String c(Context context) {
        return y.b(a(context));
    }
}
