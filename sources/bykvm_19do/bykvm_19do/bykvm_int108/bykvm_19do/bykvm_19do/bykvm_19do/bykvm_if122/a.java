package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import com.caverock.androidsvg.SVG;

/* loaded from: classes.dex */
public class a {
    public static long a(int i2, Context context) {
        long b = b(i2, context);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("ad limit by memory:" + b);
        return b;
    }

    public static boolean a() {
        e e2 = j.l().e();
        return (e2 == null || TextUtils.isEmpty(e2.a())) ? false : true;
    }

    private static long b(int i2, Context context) {
        if (context != null) {
            Runtime runtime = Runtime.getRuntime();
            long freeMemory = runtime.freeMemory() / SVG.H;
            long maxMemory = (runtime.maxMemory() / SVG.H) - (runtime.totalMemory() / SVG.H);
            if (maxMemory > 0) {
                long j2 = ((maxMemory + freeMemory) - 10) / 2;
                if (j2 <= 2) {
                    return 1L;
                }
                if (j2 > 10) {
                    return Math.min(j2 * 10, i2);
                }
            } else if (freeMemory <= 2) {
                return 1L;
            } else {
                if (freeMemory > 10) {
                    return Math.min((freeMemory / 2) * 10, i2);
                }
            }
            i2 = Math.min(i2, 10);
        }
        return i2;
    }

    public static boolean b() {
        e e2 = j.l().e();
        return (e2 == null || TextUtils.isEmpty(e2.d())) ? false : true;
    }

    public static boolean c() {
        e e2 = j.l().e();
        return (e2 == null || TextUtils.isEmpty(e2.b())) ? false : true;
    }

    public static boolean d() {
        e e2 = j.l().e();
        return (e2 == null || TextUtils.isEmpty(e2.f())) ? false : true;
    }

    public static boolean e() {
        e e2 = j.l().e();
        return (e2 == null || TextUtils.isEmpty(e2.e())) ? false : true;
    }

    public static boolean f() {
        e e2 = j.l().e();
        return (e2 == null || TextUtils.isEmpty(e2.c())) ? false : true;
    }
}
