package e.b.a.p.k.y;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import androidx.annotation.VisibleForTesting;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: e  reason: collision with root package name */
    private static final String f9648e = "MemorySizeCalculator";
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    public static final int f9649f = 4;

    /* renamed from: g  reason: collision with root package name */
    private static final int f9650g = 2;
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f9651c;

    /* renamed from: d  reason: collision with root package name */
    private final int f9652d;

    /* loaded from: classes.dex */
    public static final class a {
        @VisibleForTesting

        /* renamed from: i  reason: collision with root package name */
        public static final int f9653i = 2;

        /* renamed from: j  reason: collision with root package name */
        public static final int f9654j;

        /* renamed from: k  reason: collision with root package name */
        public static final float f9655k = 0.4f;

        /* renamed from: l  reason: collision with root package name */
        public static final float f9656l = 0.33f;

        /* renamed from: m  reason: collision with root package name */
        public static final int f9657m = 4194304;
        public final Context a;
        public ActivityManager b;

        /* renamed from: c  reason: collision with root package name */
        public c f9658c;

        /* renamed from: e  reason: collision with root package name */
        public float f9660e;

        /* renamed from: d  reason: collision with root package name */
        public float f9659d = 2.0f;

        /* renamed from: f  reason: collision with root package name */
        public float f9661f = 0.4f;

        /* renamed from: g  reason: collision with root package name */
        public float f9662g = 0.33f;

        /* renamed from: h  reason: collision with root package name */
        public int f9663h = 4194304;

        static {
            f9654j = Build.VERSION.SDK_INT < 26 ? 4 : 1;
        }

        public a(Context context) {
            this.f9660e = f9654j;
            this.a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.f9658c = new b(context.getResources().getDisplayMetrics());
            if (Build.VERSION.SDK_INT < 26 || !l.e(this.b)) {
                return;
            }
            this.f9660e = 0.0f;
        }

        public l a() {
            return new l(this);
        }

        @VisibleForTesting
        public a b(ActivityManager activityManager) {
            this.b = activityManager;
            return this;
        }

        public a c(int i2) {
            this.f9663h = i2;
            return this;
        }

        public a d(float f2) {
            e.b.a.v.l.a(f2 >= 0.0f, "Bitmap pool screens must be greater than or equal to 0");
            this.f9660e = f2;
            return this;
        }

        public a e(float f2) {
            e.b.a.v.l.a(f2 >= 0.0f && f2 <= 1.0f, "Low memory max size multiplier must be between 0 and 1");
            this.f9662g = f2;
            return this;
        }

        public a f(float f2) {
            e.b.a.v.l.a(f2 >= 0.0f && f2 <= 1.0f, "Size multiplier must be between 0 and 1");
            this.f9661f = f2;
            return this;
        }

        public a g(float f2) {
            e.b.a.v.l.a(f2 >= 0.0f, "Memory cache screens must be greater than or equal to 0");
            this.f9659d = f2;
            return this;
        }

        @VisibleForTesting
        public a h(c cVar) {
            this.f9658c = cVar;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements c {
        private final DisplayMetrics a;

        public b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }

        @Override // e.b.a.p.k.y.l.c
        public int a() {
            return this.a.heightPixels;
        }

        @Override // e.b.a.p.k.y.l.c
        public int b() {
            return this.a.widthPixels;
        }
    }

    /* loaded from: classes.dex */
    public interface c {
        int a();

        int b();
    }

    public l(a aVar) {
        int i2;
        this.f9651c = aVar.a;
        if (e(aVar.b)) {
            i2 = aVar.f9663h / 2;
        } else {
            i2 = aVar.f9663h;
        }
        this.f9652d = i2;
        int c2 = c(aVar.b, aVar.f9661f, aVar.f9662g);
        float b2 = aVar.f9658c.b() * aVar.f9658c.a() * 4;
        int round = Math.round(aVar.f9660e * b2);
        int round2 = Math.round(b2 * aVar.f9659d);
        int i3 = c2 - i2;
        int i4 = round2 + round;
        if (i4 <= i3) {
            this.b = round2;
            this.a = round;
        } else {
            float f2 = i3;
            float f3 = aVar.f9660e;
            float f4 = aVar.f9659d;
            float f5 = f2 / (f3 + f4);
            this.b = Math.round(f4 * f5);
            this.a = Math.round(f5 * aVar.f9660e);
        }
        if (Log.isLoggable(f9648e, 3)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Calculation complete, Calculated memory cache size: ");
            sb.append(f(this.b));
            sb.append(", pool size: ");
            sb.append(f(this.a));
            sb.append(", byte array size: ");
            sb.append(f(i2));
            sb.append(", memory class limited? ");
            sb.append(i4 > c2);
            sb.append(", max size: ");
            sb.append(f(c2));
            sb.append(", memoryClass: ");
            sb.append(aVar.b.getMemoryClass());
            sb.append(", isLowMemoryDevice: ");
            sb.append(e(aVar.b));
            Log.d(f9648e, sb.toString());
        }
    }

    private static int c(ActivityManager activityManager, float f2, float f3) {
        boolean e2 = e(activityManager);
        float memoryClass = activityManager.getMemoryClass() * 1024 * 1024;
        if (e2) {
            f2 = f3;
        }
        return Math.round(memoryClass * f2);
    }

    @TargetApi(19)
    public static boolean e(ActivityManager activityManager) {
        if (Build.VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return true;
    }

    private String f(int i2) {
        return Formatter.formatFileSize(this.f9651c, i2);
    }

    public int a() {
        return this.f9652d;
    }

    public int b() {
        return this.a;
    }

    public int d() {
        return this.b;
    }
}
