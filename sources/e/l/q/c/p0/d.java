package e.l.q.c.p0;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.effective.android.panel.Constants;
import com.vector.util.UIUtil;
import java.util.Objects;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class d {
    @k.e.a.d
    public static final d a = new d();
    @k.e.a.d
    private static final String b = "ScreenUtil";

    /* renamed from: c  reason: collision with root package name */
    private static final double f14188c = 0.85d;

    /* renamed from: d  reason: collision with root package name */
    private static int f14189d;

    /* renamed from: e  reason: collision with root package name */
    private static int f14190e;

    /* renamed from: f  reason: collision with root package name */
    private static int f14191f;

    /* renamed from: g  reason: collision with root package name */
    private static int f14192g;

    /* renamed from: h  reason: collision with root package name */
    private static float f14193h;

    /* renamed from: i  reason: collision with root package name */
    private static float f14194i;

    /* renamed from: j  reason: collision with root package name */
    private static float f14195j;

    /* renamed from: k  reason: collision with root package name */
    private static float f14196k;

    /* renamed from: l  reason: collision with root package name */
    private static int f14197l;

    /* renamed from: m  reason: collision with root package name */
    private static int f14198m;
    private static int n;
    private static int o;

    private d() {
    }

    public final void a(@e Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        f14189d = i2;
        int i3 = displayMetrics.heightPixels;
        f14190e = i3;
        f14191f = i2 > i3 ? i3 : i2;
        if (i2 < i3) {
            i2 = i3;
        }
        f14192g = i2;
        f14193h = displayMetrics.density;
        f14194i = displayMetrics.scaledDensity;
        f14195j = displayMetrics.xdpi;
        f14196k = displayMetrics.ydpi;
        f14197l = displayMetrics.densityDpi;
        n = g(context);
        o = d(context);
        Log.d(b, "screenWidth=" + f14189d + " screenHeight=" + f14190e + " density=" + f14193h);
    }

    public final int b(float f2) {
        return (int) ((f2 * f14193h) + 0.5f);
    }

    public final int c() {
        int i2 = (int) (f14191f * f14188c);
        f14198m = i2;
        return i2;
    }

    public final int d(@k.e.a.d Context context) {
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier(Constants.NAVIGATION_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    public final int e(@k.e.a.d Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels + UIUtil.c();
    }

    public final int f(@k.e.a.d Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Object systemService = context.getSystemService("window");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public final int g(@k.e.a.d Context context) {
        if (n == 0) {
            try {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                Object obj = cls.getField(Constants.STATUS_BAR_HEIGHT_RES_NAME).get(cls.newInstance());
                if (obj != null) {
                    n = context.getResources().getDimensionPixelSize(((Integer) obj).intValue());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (n == 0) {
            n = b(25.0f);
        }
        return n;
    }

    public final void h(@e Context context) {
        if (context == null) {
            return;
        }
        DisplayMetrics displayMetrics = context.getApplicationContext().getResources().getDisplayMetrics();
        int i2 = displayMetrics.widthPixels;
        f14189d = i2;
        int i3 = displayMetrics.heightPixels;
        f14190e = i3;
        if (i2 > i3) {
            i2 = i3;
        }
        f14191f = i2;
        f14193h = displayMetrics.density;
        f14194i = displayMetrics.scaledDensity;
        f14195j = displayMetrics.xdpi;
        f14196k = displayMetrics.ydpi;
        f14197l = displayMetrics.densityDpi;
        Log.d(b, "screenWidth=" + f14189d + " screenHeight=" + f14190e + " density=" + f14193h);
    }

    public final int i(float f2) {
        return (int) ((f2 / f14193h) + 0.5f);
    }

    public final int j(float f2) {
        return (int) ((f2 * f14194i) + 0.5f);
    }
}
