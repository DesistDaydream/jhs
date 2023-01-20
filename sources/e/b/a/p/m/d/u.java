package e.b.a.p.m.d;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import java.io.File;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: g  reason: collision with root package name */
    private static final String f9783g = "HardwareConfig";

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f9784h;

    /* renamed from: i  reason: collision with root package name */
    public static final boolean f9785i;
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    public static final int f9786j = 128;

    /* renamed from: k  reason: collision with root package name */
    private static final int f9787k = 0;

    /* renamed from: l  reason: collision with root package name */
    private static final File f9788l;

    /* renamed from: m  reason: collision with root package name */
    private static final int f9789m = 50;
    private static final int n = 700;
    private static final int o = 20000;
    public static final int p = -1;
    private static volatile u q;
    private static volatile int r;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f9790c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f9791d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private boolean f9792e = true;

    /* renamed from: f  reason: collision with root package name */
    private final AtomicBoolean f9793f = new AtomicBoolean(false);
    private final boolean a = h();

    static {
        int i2 = Build.VERSION.SDK_INT;
        f9784h = i2 < 29;
        f9785i = i2 >= 26;
        f9788l = new File("/proc/self/fd");
        r = -1;
    }

    @VisibleForTesting
    public u() {
        if (Build.VERSION.SDK_INT >= 28) {
            this.b = 20000;
            this.f9790c = 0;
            return;
        }
        this.b = 700;
        this.f9790c = 128;
    }

    private boolean b() {
        return f9784h && !this.f9793f.get();
    }

    public static u d() {
        if (q == null) {
            synchronized (u.class) {
                if (q == null) {
                    q = new u();
                }
            }
        }
        return q;
    }

    private int e() {
        if (r != -1) {
            return r;
        }
        return this.b;
    }

    private synchronized boolean f() {
        boolean z = true;
        int i2 = this.f9791d + 1;
        this.f9791d = i2;
        if (i2 >= 50) {
            this.f9791d = 0;
            int length = f9788l.list().length;
            long e2 = e();
            if (length >= e2) {
                z = false;
            }
            this.f9792e = z;
            if (!z && Log.isLoggable(o.f9762f, 5)) {
                Log.w(o.f9762f, "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + e2);
            }
        }
        return this.f9792e;
    }

    private static boolean h() {
        return (i() || j()) ? false : true;
    }

    private static boolean i() {
        if (Build.VERSION.SDK_INT != 26) {
            return false;
        }
        for (String str : Arrays.asList("SC-04J", "SM-N935", "SM-J720", "SM-G570F", "SM-G570M", "SM-G960", "SM-G965", "SM-G935", "SM-G930", "SM-A520", "SM-A720F", "moto e5", "moto e5 play", "moto e5 plus", "moto e5 cruise", "moto g(6) forge", "moto g(6) play")) {
            if (Build.MODEL.startsWith(str)) {
                return true;
            }
        }
        return false;
    }

    private static boolean j() {
        if (Build.VERSION.SDK_INT != 27) {
            return false;
        }
        return Arrays.asList("LG-M250", "LG-M320", "LG-Q710AL", "LG-Q710PL", "LGM-K121K", "LGM-K121L", "LGM-K121S", "LGM-X320K", "LGM-X320L", "LGM-X320S", "LGM-X401L", "LGM-X401S", "LM-Q610.FG", "LM-Q610.FGN", "LM-Q617.FG", "LM-Q617.FGN", "LM-Q710.FG", "LM-Q710.FGN", "LM-X220PM", "LM-X220QMA", "LM-X410PM").contains(Build.MODEL);
    }

    public boolean a() {
        e.b.a.v.n.b();
        return !this.f9793f.get();
    }

    public void c() {
        e.b.a.v.n.b();
        this.f9793f.set(false);
    }

    public boolean g(int i2, int i3, boolean z, boolean z2) {
        if (!z) {
            if (Log.isLoggable(f9783g, 2)) {
                Log.v(f9783g, "Hardware config disallowed by caller");
            }
            return false;
        } else if (!this.a) {
            if (Log.isLoggable(f9783g, 2)) {
                Log.v(f9783g, "Hardware config disallowed by device model");
            }
            return false;
        } else if (!f9785i) {
            if (Log.isLoggable(f9783g, 2)) {
                Log.v(f9783g, "Hardware config disallowed by sdk");
            }
            return false;
        } else if (b()) {
            if (Log.isLoggable(f9783g, 2)) {
                Log.v(f9783g, "Hardware config disallowed by app state");
            }
            return false;
        } else if (z2) {
            if (Log.isLoggable(f9783g, 2)) {
                Log.v(f9783g, "Hardware config disallowed because exif orientation is required");
            }
            return false;
        } else {
            int i4 = this.f9790c;
            if (i2 < i4) {
                if (Log.isLoggable(f9783g, 2)) {
                    Log.v(f9783g, "Hardware config disallowed because width is too small");
                }
                return false;
            } else if (i3 < i4) {
                if (Log.isLoggable(f9783g, 2)) {
                    Log.v(f9783g, "Hardware config disallowed because height is too small");
                }
                return false;
            } else if (f()) {
                return true;
            } else {
                if (Log.isLoggable(f9783g, 2)) {
                    Log.v(f9783g, "Hardware config disallowed because there are insufficient FDs");
                }
                return false;
            }
        }
    }

    @TargetApi(26)
    public boolean k(int i2, int i3, BitmapFactory.Options options, boolean z, boolean z2) {
        boolean g2 = g(i2, i3, z, z2);
        if (g2) {
            options.inPreferredConfig = Bitmap.Config.HARDWARE;
            options.inMutable = false;
        }
        return g2;
    }

    public void l() {
        e.b.a.v.n.b();
        this.f9793f.set(true);
    }
}
