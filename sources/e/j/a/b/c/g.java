package e.j.a.b.c;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import androidx.fragment.app.Fragment;
import e.j.a.b.c.r.p;

/* loaded from: classes2.dex */
public final class g extends h {

    /* renamed from: m  reason: collision with root package name */
    public static final String f10132m = "GooglePlayServicesErrorDialog";
    @Deprecated
    public static final int n = h.a;
    @Deprecated
    public static final String o = "com.google.android.gms";
    public static final String p = "com.android.vending";

    private g() {
    }

    public static boolean A(int i2, Activity activity, Fragment fragment, int i3, DialogInterface.OnCancelListener onCancelListener) {
        if (h.o(activity, i2)) {
            i2 = 18;
        }
        e v = e.v();
        if (fragment == null) {
            return v.z(activity, i2, i3, onCancelListener);
        }
        Dialog D = e.D(activity, i2, e.j.a.b.c.r.i.b(fragment, e.v().e(activity, i2, f.f10128d), i3), onCancelListener);
        if (D == null) {
            return false;
        }
        e.F(activity, D, f10132m, onCancelListener);
        return true;
    }

    @Deprecated
    public static void B(int i2, Context context) {
        e v = e.v();
        if (!h.o(context, i2) && !h.p(context, i2)) {
            v.A(context, i2);
        } else {
            v.G(context);
        }
    }

    @Deprecated
    public static PendingIntent f(int i2, Context context, int i3) {
        return h.f(i2, context, i3);
    }

    @e.j.a.b.c.x.d0
    @Deprecated
    public static String g(int i2) {
        return h.g(i2);
    }

    public static Context i(Context context) {
        return h.i(context);
    }

    public static Resources j(Context context) {
        return h.j(context);
    }

    @p
    @Deprecated
    public static int l(Context context) {
        return h.l(context);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static int m(Context context, int i2) {
        return h.m(context, i2);
    }

    @Deprecated
    public static boolean t(int i2) {
        return h.t(i2);
    }

    @Deprecated
    public static Dialog w(int i2, Activity activity, int i3) {
        return x(i2, activity, i3, null);
    }

    @Deprecated
    public static Dialog x(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        if (h.o(activity, i2)) {
            i2 = 18;
        }
        return e.v().t(activity, i2, i3, onCancelListener);
    }

    @Deprecated
    public static boolean y(int i2, Activity activity, int i3) {
        return z(i2, activity, i3, null);
    }

    @Deprecated
    public static boolean z(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return A(i2, activity, null, i3, onCancelListener);
    }
}
