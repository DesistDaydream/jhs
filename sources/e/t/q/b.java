package e.t.q;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Point;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import com.huawei.hms.push.constant.RemoteMessageConst;
import h.k2.v.f0;
import h.k2.v.n0;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0015R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u001e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u001e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/vector/model/Screen;", "", "()V", "<set-?>", "", "density", "getDensity", "()F", "", "height", "getHeight", "()I", "physicalHeight", "getPhysicalHeight", "physicalWidth", "getPhysicalWidth", "width", "getWidth", "hasVirtualBar", "", "reset", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b {
    @k.e.a.d
    public static final b a;
    private static int b;

    /* renamed from: c  reason: collision with root package name */
    private static int f14607c;

    /* renamed from: d  reason: collision with root package name */
    private static int f14608d;

    /* renamed from: e  reason: collision with root package name */
    private static int f14609e;

    /* renamed from: f  reason: collision with root package name */
    private static float f14610f;

    static {
        b bVar = new b();
        a = bVar;
        bVar.g();
    }

    private b() {
    }

    public final float a() {
        return f14610f;
    }

    public final int b() {
        return f14607c;
    }

    public final int c() {
        return f14609e;
    }

    public final int d() {
        return f14608d;
    }

    public final int e() {
        return b;
    }

    public final boolean f() {
        return f14607c != f14609e;
    }

    public final void g() {
        WindowManager windowManager;
        DisplayMetrics displayMetrics = e.t.a.b().getResources().getDisplayMetrics();
        b = displayMetrics.widthPixels;
        f14607c = displayMetrics.heightPixels;
        f14610f = displayMetrics.density;
        Context b2 = e.t.a.b();
        h.p2.d d2 = n0.d(WindowManager.class);
        if (f0.g(d2, n0.d(ConnectivityManager.class))) {
            Object systemService = b2.getApplicationContext().getSystemService("connectivity");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService;
        } else if (f0.g(d2, n0.d(ActivityManager.class))) {
            Object systemService2 = b2.getApplicationContext().getSystemService("activity");
            Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService2;
        } else if (f0.g(d2, n0.d(WifiManager.class))) {
            Object systemService3 = b2.getApplicationContext().getSystemService("wifi");
            Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService3;
        } else if (f0.g(d2, n0.d(PowerManager.class))) {
            Object systemService4 = b2.getApplicationContext().getSystemService("power");
            Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService4;
        } else if (f0.g(d2, n0.d(NotificationManager.class))) {
            Object systemService5 = b2.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
            Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService5;
        } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
            Object systemService6 = b2.getApplicationContext().getSystemService("clipboard");
            Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService6;
        } else if (f0.g(d2, n0.d(WindowManager.class))) {
            Object systemService7 = b2.getApplicationContext().getSystemService("window");
            Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService7;
        } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
            Object systemService8 = b2.getApplicationContext().getSystemService("input_method");
            Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService8;
        } else if (f0.g(d2, n0.d(LocationManager.class))) {
            Object systemService9 = b2.getApplicationContext().getSystemService("location");
            Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService9;
        } else if (!f0.g(d2, n0.d(CameraManager.class))) {
            throw new IllegalArgumentException("can not find class");
        } else {
            Object systemService10 = b2.getApplicationContext().getSystemService("camera");
            Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.view.WindowManager");
            windowManager = (WindowManager) systemService10;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        if (defaultDisplay != null) {
            defaultDisplay.getRealSize(point);
        }
        f14608d = point.x;
        f14609e = point.y;
    }
}
