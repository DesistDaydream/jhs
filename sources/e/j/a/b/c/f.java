package e.j.a.b.c;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.r.e1;
import e.j.a.b.c.r.p;

@e.j.a.b.c.m.a
@e.j.a.b.c.r.d0
/* loaded from: classes2.dex */
public class f {
    @e.j.a.b.c.m.a
    public static final String b = "com.google.android.gms";
    @e.j.a.b.c.m.a

    /* renamed from: c  reason: collision with root package name */
    public static final String f10127c = "com.android.vending";
    @e.j.a.b.c.m.a

    /* renamed from: d  reason: collision with root package name */
    public static final String f10128d = "d";
    @e.j.a.b.c.m.a

    /* renamed from: e  reason: collision with root package name */
    public static final String f10129e = "n";
    @e.j.a.b.c.m.a
    public static final int a = h.a;

    /* renamed from: f  reason: collision with root package name */
    private static final f f10130f = new f();

    @e.j.a.b.c.m.a
    public static f i() {
        return f10130f;
    }

    @e.j.a.b.c.x.d0
    private static String q(@Nullable Context context, @Nullable String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("gcore_");
        sb.append(a);
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (!TextUtils.isEmpty(str)) {
            sb.append(str);
        }
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (context != null) {
            sb.append(context.getPackageName());
        }
        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (context != null) {
            try {
                sb.append(e.j.a.b.c.y.c.a(context).e(context.getPackageName(), 0).versionCode);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        return sb.toString();
    }

    @e.j.a.b.c.m.a
    public void a(Context context) {
        h.a(context);
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public int b(Context context) {
        return h.d(context);
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public int c(Context context) {
        return h.e(context);
    }

    @Deprecated
    @Nullable
    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public Intent d(int i2) {
        return e(null, i2, null);
    }

    @Nullable
    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public Intent e(Context context, int i2, @Nullable String str) {
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                return null;
            }
            return e1.b("com.google.android.gms");
        } else if (context != null && e.j.a.b.c.x.l.h(context)) {
            return e1.c();
        } else {
            return e1.a("com.google.android.gms", q(context, str));
        }
    }

    @Nullable
    @e.j.a.b.c.m.a
    public PendingIntent f(Context context, int i2, int i3) {
        return g(context, i2, i3, null);
    }

    @Nullable
    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public PendingIntent g(Context context, int i2, int i3, @Nullable String str) {
        Intent e2 = e(context, i2, str);
        if (e2 == null) {
            return null;
        }
        return PendingIntent.getActivity(context, i3, e2, 134217728);
    }

    @e.j.a.b.c.m.a
    public String h(int i2) {
        return h.g(i2);
    }

    @e.j.a.b.c.m.a
    @p
    public int j(Context context) {
        return k(context, a);
    }

    @e.j.a.b.c.m.a
    public int k(Context context, int i2) {
        int m2 = h.m(context, i2);
        if (h.o(context, m2)) {
            return 18;
        }
        return m2;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public boolean l(Context context, int i2) {
        return h.o(context, i2);
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public boolean m(Context context, int i2) {
        return h.p(context, i2);
    }

    @e.j.a.b.c.m.a
    public boolean n(Context context, String str) {
        return h.s(context, str);
    }

    @e.j.a.b.c.m.a
    public boolean o(int i2) {
        return h.t(i2);
    }

    @e.j.a.b.c.m.a
    public void p(Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        h.c(context, i2);
    }
}
