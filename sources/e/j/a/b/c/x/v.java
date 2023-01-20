package e.j.a.b.c.x;

import android.os.Build;
import androidx.core.os.BuildCompat;

@e.j.a.b.c.m.a
@d0
/* loaded from: classes2.dex */
public final class v {
    private v() {
    }

    @e.j.a.b.c.m.a
    public static boolean a() {
        return true;
    }

    @e.j.a.b.c.m.a
    public static boolean b() {
        return true;
    }

    @e.j.a.b.c.m.a
    public static boolean c() {
        return true;
    }

    @e.j.a.b.c.m.a
    public static boolean d() {
        return true;
    }

    @e.j.a.b.c.m.a
    public static boolean e() {
        return true;
    }

    @e.j.a.b.c.m.a
    public static boolean f() {
        return Build.VERSION.SDK_INT >= 17;
    }

    @e.j.a.b.c.m.a
    public static boolean g() {
        return Build.VERSION.SDK_INT >= 18;
    }

    @e.j.a.b.c.m.a
    public static boolean h() {
        return Build.VERSION.SDK_INT >= 19;
    }

    @e.j.a.b.c.m.a
    public static boolean i() {
        return Build.VERSION.SDK_INT >= 20;
    }

    @e.j.a.b.c.m.a
    public static boolean j() {
        return Build.VERSION.SDK_INT >= 21;
    }

    @e.j.a.b.c.m.a
    public static boolean k() {
        return Build.VERSION.SDK_INT >= 22;
    }

    @e.j.a.b.c.m.a
    public static boolean l() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @e.j.a.b.c.m.a
    public static boolean m() {
        return Build.VERSION.SDK_INT >= 24;
    }

    @e.j.a.b.c.m.a
    public static boolean n() {
        return Build.VERSION.SDK_INT >= 26;
    }

    @e.j.a.b.c.m.a
    public static boolean o() {
        return Build.VERSION.SDK_INT >= 28;
    }

    @e.j.a.b.c.m.a
    public static boolean p() {
        if (!BuildCompat.isAtLeastQ()) {
            String str = Build.VERSION.CODENAME;
            if ((!str.equals("REL") || Build.VERSION.SDK_INT < 29) && (str.length() != 1 || str.charAt(0) < 'Q' || str.charAt(0) > 'Z')) {
                return false;
            }
        }
        return true;
    }
}
