package com.vector.util;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.graphics.Point;
import android.hardware.camera2.CameraManager;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.IntRange;
import androidx.core.content.ContextCompat;
import androidx.core.hardware.display.DisplayManagerCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.effective.android.panel.Constants;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.xiaomi.mipush.sdk.MiPushClient;
import e.t.a;
import e.t.u.y;
import h.k2.k;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.t1;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010%\u001a\u00020&R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\u00020\r8FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u000e\u0010\u0002\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R!\u0010\u0017\u001a\u00020\u00138FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u0012\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0016R\u001e\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u001e\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R!\u0010\u001f\u001a\u00020\u00138FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\"\u0010\u0012\u0012\u0004\b \u0010\u0002\u001a\u0004\b!\u0010\u0016R\u001e\u0010#\u001a\u00020\u00132\u0006\u0010\u0003\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0016¨\u0006("}, d2 = {"Lcom/vector/util/Screen;", "", "()V", "<set-?>", "", "density", "getDensity", "()F", "Lcom/vector/util/DensityLevel;", "densityLevel", "getDensityLevel", "()Lcom/vector/util/DensityLevel;", "hasVirtualBar", "", "getHasVirtualBar$annotations", "getHasVirtualBar", "()Z", "hasVirtualBar$delegate", "Lkotlin/Lazy;", "", "height", "getHeight", "()I", "navigationBarHeight", "getNavigationBarHeight$annotations", "getNavigationBarHeight", "navigationBarHeight$delegate", "physicalHeight", "getPhysicalHeight", "physicalWidth", "getPhysicalWidth", "statusBarHeight", "getStatusBarHeight$annotations", "getStatusBarHeight", "statusBarHeight$delegate", "width", "getWidth", "reset", "", "Brightness", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Screen {
    @d
    public static final Screen a;
    private static int b;

    /* renamed from: c  reason: collision with root package name */
    private static int f7898c;

    /* renamed from: d  reason: collision with root package name */
    private static int f7899d;

    /* renamed from: e  reason: collision with root package name */
    private static int f7900e;

    /* renamed from: f  reason: collision with root package name */
    private static float f7901f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private static DensityLevel f7902g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final w f7903h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private static final w f7904i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private static final w f7905j;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\n\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vector/util/Screen$Brightness;", "", "()V", "MAX", "", "MIN", "configMaxBrightness", "convertGetValue", "value", "getConfigMaxBrightness", "System", "Window", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Brightness {
        @d
        public static final Brightness a;
        public static final int b = 0;

        /* renamed from: c  reason: collision with root package name */
        public static final int f7906c = 255;

        /* renamed from: d  reason: collision with root package name */
        private static final int f7907d;

        @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ1\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2!\u0010\u000f\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\f0\u0010J\u0010\u0010\u0014\u001a\u00020\t2\b\b\u0001\u0010\u0005\u001a\u00020\u0004¨\u0006\u0015"}, d2 = {"Lcom/vector/util/Screen$Brightness$System;", "", "()V", "convertSetValue", "", "value", "getMode", "getValue", "isAuto", "", "isManual", MiPushClient.COMMAND_REGISTER, "", TUIConstants.TUIChat.OWNER, "Landroidx/lifecycle/LifecycleOwner;", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "brightness", "setValue", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class System {
            @d
            public static final System a = new System();

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vector/util/Screen$Brightness$System$register$observer$1", "Landroid/database/ContentObserver;", "onChange", "", "selfChange", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
            /* loaded from: classes3.dex */
            public static final class a extends ContentObserver {
                public final /* synthetic */ l<Integer, t1> a;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                public a(l<? super Integer, t1> lVar, Handler handler) {
                    super(handler);
                    this.a = lVar;
                }

                @Override // android.database.ContentObserver
                public void onChange(boolean z) {
                    this.a.invoke(Integer.valueOf(System.a.c()));
                }
            }

            private System() {
            }

            private final int a(int i2) {
                int i3 = Brightness.f7907d;
                if (i3 == 255) {
                    return i2;
                }
                return (int) (i2 * (i3 / 255.0f));
            }

            private final int b() {
                return Settings.System.getInt(e.t.a.b().getContentResolver(), "screen_brightness_mode");
            }

            public final int c() {
                try {
                    return Brightness.a.c(Settings.System.getInt(e.t.a.b().getContentResolver(), "screen_brightness"));
                } catch (Settings.SettingNotFoundException unused) {
                    return 0;
                }
            }

            public final boolean d() {
                try {
                    return b() == 1;
                } catch (Settings.SettingNotFoundException unused) {
                    return false;
                }
            }

            public final boolean e() {
                try {
                    return b() == 0;
                } catch (Settings.SettingNotFoundException unused) {
                    return false;
                }
            }

            public final void f(@d final LifecycleOwner lifecycleOwner, @d l<? super Integer, t1> lVar) {
                Looper myLooper = Looper.myLooper();
                if (myLooper == null) {
                    myLooper = Looper.getMainLooper();
                }
                final a aVar = new a(lVar, new Handler(myLooper));
                final ContentResolver contentResolver = e.t.a.b().getContentResolver();
                lifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.vector.util.Screen$Brightness$System$register$1
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public void onStateChanged(@d LifecycleOwner lifecycleOwner2, @d Lifecycle.Event event) {
                        if (event == Lifecycle.Event.ON_DESTROY) {
                            contentResolver.unregisterContentObserver(aVar);
                            lifecycleOwner.getLifecycle().removeObserver(this);
                        }
                    }
                });
                contentResolver.registerContentObserver(Settings.System.getUriFor("screen_brightness"), true, aVar);
            }

            public final boolean g(@IntRange(from = 0, to = 255) int i2) {
                boolean z;
                if (Build.VERSION.SDK_INT >= 23) {
                    z = Settings.System.canWrite(e.t.a.b());
                } else {
                    z = ContextCompat.checkSelfPermission(e.t.a.b(), "android.permission.WRITE_SETTINGS") == 0;
                }
                if (z) {
                    return Settings.System.putInt(e.t.a.b().getContentResolver(), "screen_brightness", a(i2));
                }
                return false;
            }
        }

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\t\u001a\u00020\u0004¨\u0006\n"}, d2 = {"Lcom/vector/util/Screen$Brightness$Window;", "", "()V", "getValue", "", "window", "Landroid/view/Window;", "setValue", "", "value", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class a {
            @d
            public static final a a = new a();

            private a() {
            }

            public final int a(@d Window window) {
                float f2 = window.getAttributes().screenBrightness;
                return (f2 > (-1.0f) ? 1 : (f2 == (-1.0f) ? 0 : -1)) == 0 ? System.a.c() : (int) (f2 * 255);
            }

            public final void b(@d Window window, @IntRange(from = 0, to = 255) int i2) {
                WindowManager.LayoutParams attributes = window.getAttributes();
                attributes.screenBrightness = i2 / 255.0f;
                window.setAttributes(attributes);
            }
        }

        static {
            Brightness brightness = new Brightness();
            a = brightness;
            f7907d = brightness.d();
        }

        private Brightness() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int c(int i2) {
            int i3 = f7907d;
            if (i3 == 255) {
                return i2;
            }
            return (int) (i2 * (255.0f / i3));
        }

        private final int d() {
            try {
                Resources system = Resources.getSystem();
                int identifier = system.getIdentifier("config_screenBrightnessSettingMaximum", "integer", Constants.ANDROID);
                if (identifier != 0) {
                    return system.getInteger(identifier);
                }
                return 255;
            } catch (Exception unused) {
                return 255;
            }
        }
    }

    static {
        Screen screen = new Screen();
        a = screen;
        f7902g = DensityLevel.UN_KNOW;
        screen.m();
        f7903h = z.c(Screen$hasVirtualBar$2.INSTANCE);
        f7904i = z.c(Screen$statusBarHeight$2.INSTANCE);
        f7905j = z.c(Screen$navigationBarHeight$2.INSTANCE);
    }

    private Screen() {
    }

    public static final boolean c() {
        return ((Boolean) f7903h.getValue()).booleanValue();
    }

    @k
    public static /* synthetic */ void d() {
    }

    public static final int f() {
        return ((Number) f7905j.getValue()).intValue();
    }

    @k
    public static /* synthetic */ void g() {
    }

    public static final int j() {
        return ((Number) f7904i.getValue()).intValue();
    }

    @k
    public static /* synthetic */ void k() {
    }

    public final float a() {
        return f7901f;
    }

    @d
    public final DensityLevel b() {
        return f7902g;
    }

    public final int e() {
        return f7898c;
    }

    public final int h() {
        return f7900e;
    }

    public final int i() {
        return f7899d;
    }

    public final int l() {
        return b;
    }

    public final void m() {
        WindowManager windowManager;
        Display defaultDisplay;
        WindowManager windowManager2;
        DisplayMetrics displayMetrics = a.b().getResources().getDisplayMetrics();
        b = displayMetrics.widthPixels;
        f7898c = displayMetrics.heightPixels;
        f7901f = displayMetrics.density;
        f7902g = DensityLevel.Companion.a(displayMetrics.densityDpi);
        if (y.a(30)) {
            Display[] displays = DisplayManagerCompat.getInstance(a.b()).getDisplays();
            if (!(displays.length == 0)) {
                defaultDisplay = displays[0];
            } else {
                Context b2 = a.b();
                h.p2.d d2 = n0.d(WindowManager.class);
                if (f0.g(d2, n0.d(ConnectivityManager.class))) {
                    Object systemService = b2.getApplicationContext().getSystemService("connectivity");
                    Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService;
                } else if (f0.g(d2, n0.d(ActivityManager.class))) {
                    Object systemService2 = b2.getApplicationContext().getSystemService("activity");
                    Objects.requireNonNull(systemService2, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService2;
                } else if (f0.g(d2, n0.d(WifiManager.class))) {
                    Object systemService3 = b2.getApplicationContext().getSystemService("wifi");
                    Objects.requireNonNull(systemService3, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService3;
                } else if (f0.g(d2, n0.d(PowerManager.class))) {
                    Object systemService4 = b2.getApplicationContext().getSystemService("power");
                    Objects.requireNonNull(systemService4, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService4;
                } else if (f0.g(d2, n0.d(NotificationManager.class))) {
                    Object systemService5 = b2.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
                    Objects.requireNonNull(systemService5, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService5;
                } else if (f0.g(d2, n0.d(ClipboardManager.class))) {
                    Object systemService6 = b2.getApplicationContext().getSystemService("clipboard");
                    Objects.requireNonNull(systemService6, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService6;
                } else if (f0.g(d2, n0.d(WindowManager.class))) {
                    Object systemService7 = b2.getApplicationContext().getSystemService("window");
                    Objects.requireNonNull(systemService7, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService7;
                } else if (f0.g(d2, n0.d(InputMethodManager.class))) {
                    Object systemService8 = b2.getApplicationContext().getSystemService("input_method");
                    Objects.requireNonNull(systemService8, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService8;
                } else if (f0.g(d2, n0.d(LocationManager.class))) {
                    Object systemService9 = b2.getApplicationContext().getSystemService("location");
                    Objects.requireNonNull(systemService9, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService9;
                } else if (!f0.g(d2, n0.d(CameraManager.class))) {
                    throw new IllegalArgumentException("can not find class");
                } else {
                    Object systemService10 = b2.getApplicationContext().getSystemService("camera");
                    Objects.requireNonNull(systemService10, "null cannot be cast to non-null type android.view.WindowManager");
                    windowManager2 = (WindowManager) systemService10;
                }
                defaultDisplay = windowManager2.getDefaultDisplay();
            }
        } else {
            Context b3 = a.b();
            h.p2.d d3 = n0.d(WindowManager.class);
            if (f0.g(d3, n0.d(ConnectivityManager.class))) {
                Object systemService11 = b3.getApplicationContext().getSystemService("connectivity");
                Objects.requireNonNull(systemService11, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService11;
            } else if (f0.g(d3, n0.d(ActivityManager.class))) {
                Object systemService12 = b3.getApplicationContext().getSystemService("activity");
                Objects.requireNonNull(systemService12, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService12;
            } else if (f0.g(d3, n0.d(WifiManager.class))) {
                Object systemService13 = b3.getApplicationContext().getSystemService("wifi");
                Objects.requireNonNull(systemService13, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService13;
            } else if (f0.g(d3, n0.d(PowerManager.class))) {
                Object systemService14 = b3.getApplicationContext().getSystemService("power");
                Objects.requireNonNull(systemService14, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService14;
            } else if (f0.g(d3, n0.d(NotificationManager.class))) {
                Object systemService15 = b3.getApplicationContext().getSystemService(RemoteMessageConst.NOTIFICATION);
                Objects.requireNonNull(systemService15, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService15;
            } else if (f0.g(d3, n0.d(ClipboardManager.class))) {
                Object systemService16 = b3.getApplicationContext().getSystemService("clipboard");
                Objects.requireNonNull(systemService16, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService16;
            } else if (f0.g(d3, n0.d(WindowManager.class))) {
                Object systemService17 = b3.getApplicationContext().getSystemService("window");
                Objects.requireNonNull(systemService17, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService17;
            } else if (f0.g(d3, n0.d(InputMethodManager.class))) {
                Object systemService18 = b3.getApplicationContext().getSystemService("input_method");
                Objects.requireNonNull(systemService18, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService18;
            } else if (f0.g(d3, n0.d(LocationManager.class))) {
                Object systemService19 = b3.getApplicationContext().getSystemService("location");
                Objects.requireNonNull(systemService19, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService19;
            } else if (!f0.g(d3, n0.d(CameraManager.class))) {
                throw new IllegalArgumentException("can not find class");
            } else {
                Object systemService20 = b3.getApplicationContext().getSystemService("camera");
                Objects.requireNonNull(systemService20, "null cannot be cast to non-null type android.view.WindowManager");
                windowManager = (WindowManager) systemService20;
            }
            defaultDisplay = windowManager.getDefaultDisplay();
        }
        Point point = new Point();
        if (defaultDisplay != null) {
            defaultDisplay.getRealSize(point);
        }
        f7899d = point.x;
        f7900e = point.y;
    }
}
