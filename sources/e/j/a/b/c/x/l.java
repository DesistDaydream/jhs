package e.j.a.b.c.x;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.jihuanshe.mmkv.UserKV;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class l {
    private static Boolean a;
    private static Boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static Boolean f10473c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f10474d;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f10475e;

    /* renamed from: f  reason: collision with root package name */
    private static Boolean f10476f;

    /* renamed from: g  reason: collision with root package name */
    private static Boolean f10477g;

    /* renamed from: h  reason: collision with root package name */
    private static Boolean f10478h;

    private l() {
    }

    @e.j.a.b.c.m.a
    public static boolean a(Context context) {
        if (f10477g == null) {
            f10477g = Boolean.valueOf(v.n() && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"));
        }
        return f10477g.booleanValue();
    }

    @e.j.a.b.c.m.a
    public static boolean b(Context context) {
        if (f10475e == null) {
            PackageManager packageManager = context.getPackageManager();
            f10475e = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return f10475e.booleanValue();
    }

    @e.j.a.b.c.m.a
    @TargetApi(21)
    public static boolean c(Context context) {
        if (f10474d == null) {
            f10474d = Boolean.valueOf(v.j() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return f10474d.booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x003c, code lost:
        if (e.j.a.b.c.x.l.b.booleanValue() != false) goto L23;
     */
    @e.j.a.b.c.m.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.Boolean r1 = e.j.a.b.c.x.l.a
            if (r1 != 0) goto L45
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L16
            r1 = 1
            goto L17
        L16:
            r1 = 0
        L17:
            if (r1 != 0) goto L3e
            java.lang.Boolean r1 = e.j.a.b.c.x.l.b
            if (r1 != 0) goto L36
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L2f
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L2f
            r4 = 1
            goto L30
        L2f:
            r4 = 0
        L30:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            e.j.a.b.c.x.l.b = r4
        L36:
            java.lang.Boolean r4 = e.j.a.b.c.x.l.b
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L3f
        L3e:
            r0 = 1
        L3f:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            e.j.a.b.c.x.l.a = r4
        L45:
            java.lang.Boolean r4 = e.j.a.b.c.x.l.a
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.b.c.x.l.d(android.content.res.Resources):boolean");
    }

    @e.j.a.b.c.m.a
    public static boolean e(Context context) {
        if (f10478h == null) {
            PackageManager packageManager = context.getPackageManager();
            f10478h = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return f10478h.booleanValue();
    }

    @e.j.a.b.c.m.a
    public static boolean f() {
        return UserKV.f3914d.equals(Build.TYPE);
    }

    @e.j.a.b.c.m.a
    @TargetApi(20)
    public static boolean g(Context context) {
        if (f10473c == null) {
            f10473c = Boolean.valueOf(v.i() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return f10473c.booleanValue();
    }

    @e.j.a.b.c.m.a
    @TargetApi(26)
    public static boolean h(Context context) {
        if (g(context)) {
            if (v.m()) {
                return c(context) && !v.n();
            }
            return true;
        }
        return false;
    }

    public static boolean i(Context context) {
        if (f10476f == null) {
            f10476f = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return f10476f.booleanValue();
    }
}
