package e.j.a.b.c.x;

import android.content.Context;
import android.os.DropBoxManager;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class i {
    private static final String[] a = {"android.", "com.android.", "dalvik.", "java.", "javax."};
    private static DropBoxManager b = null;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f10469c = false;

    /* renamed from: d  reason: collision with root package name */
    private static int f10470d = -1;
    @GuardedBy("CrashUtils.class")

    /* renamed from: e  reason: collision with root package name */
    private static int f10471e;
    @GuardedBy("CrashUtils.class")

    /* renamed from: f  reason: collision with root package name */
    private static int f10472f;

    @e.j.a.b.c.m.a
    public static boolean a(Context context, Throwable th) {
        return b(context, th, 536870912);
    }

    private static boolean b(Context context, Throwable th, int i2) {
        try {
            e.j.a.b.c.r.a0.k(context);
            e.j.a.b.c.r.a0.k(th);
            return false;
        } catch (Exception e2) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e2);
            return false;
        }
    }
}
