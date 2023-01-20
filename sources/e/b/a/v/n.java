package e.b.a.v;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Queue;

/* loaded from: classes.dex */
public final class n {
    private static final int a = 31;
    private static final int b = 17;

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f9952c = "0123456789abcdef".toCharArray();

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f9953d = new char[64];
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private static volatile Handler f9954e;

    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Bitmap.Config.values().length];
            a = iArr;
            try {
                iArr[Bitmap.Config.ALPHA_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.RGBA_F16.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private n() {
    }

    public static void a() {
        if (!t()) {
            throw new IllegalArgumentException("You must call this method on a background thread");
        }
    }

    public static void b() {
        if (!u()) {
            throw new IllegalArgumentException("You must call this method on the main thread");
        }
    }

    public static boolean c(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        } else if (obj instanceof e.b.a.p.l.l) {
            return ((e.b.a.p.l.l) obj).a(obj2);
        } else {
            return obj.equals(obj2);
        }
    }

    public static boolean d(@Nullable Object obj, @Nullable Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @NonNull
    private static String e(@NonNull byte[] bArr, @NonNull char[] cArr) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            int i3 = bArr[i2] & 255;
            int i4 = i2 * 2;
            char[] cArr2 = f9952c;
            cArr[i4] = cArr2[i3 >>> 4];
            cArr[i4 + 1] = cArr2[i3 & 15];
        }
        return new String(cArr);
    }

    @NonNull
    public static <T> Queue<T> f(int i2) {
        return new ArrayDeque(i2);
    }

    public static int g(int i2, int i3, @Nullable Bitmap.Config config) {
        return i2 * i3 * i(config);
    }

    @TargetApi(19)
    public static int h(@NonNull Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            if (Build.VERSION.SDK_INT >= 19) {
                try {
                    return bitmap.getAllocationByteCount();
                } catch (NullPointerException unused) {
                }
            }
            return bitmap.getHeight() * bitmap.getRowBytes();
        }
        throw new IllegalStateException("Cannot obtain size for recycled Bitmap: " + bitmap + "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig());
    }

    private static int i(@Nullable Bitmap.Config config) {
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        int i2 = a.a[config.ordinal()];
        if (i2 != 1) {
            if (i2 == 2 || i2 == 3) {
                return 2;
            }
            return i2 != 4 ? 4 : 8;
        }
        return 1;
    }

    @Deprecated
    public static int j(@NonNull Bitmap bitmap) {
        return h(bitmap);
    }

    @NonNull
    public static <T> List<T> k(@NonNull Collection<T> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (T t : collection) {
            if (t != null) {
                arrayList.add(t);
            }
        }
        return arrayList;
    }

    private static Handler l() {
        if (f9954e == null) {
            synchronized (n.class) {
                if (f9954e == null) {
                    f9954e = new Handler(Looper.getMainLooper());
                }
            }
        }
        return f9954e;
    }

    public static int m(float f2) {
        return n(f2, 17);
    }

    public static int n(float f2, int i2) {
        return p(Float.floatToIntBits(f2), i2);
    }

    public static int o(int i2) {
        return p(i2, 17);
    }

    public static int p(int i2, int i3) {
        return (i3 * 31) + i2;
    }

    public static int q(@Nullable Object obj, int i2) {
        return p(obj == null ? 0 : obj.hashCode(), i2);
    }

    public static int r(boolean z) {
        return s(z, 17);
    }

    public static int s(boolean z, int i2) {
        return p(z ? 1 : 0, i2);
    }

    public static boolean t() {
        return !u();
    }

    public static boolean u() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean v(int i2) {
        return i2 > 0 || i2 == Integer.MIN_VALUE;
    }

    public static boolean w(int i2, int i3) {
        return v(i2) && v(i3);
    }

    public static void x(Runnable runnable) {
        l().post(runnable);
    }

    public static void y(Runnable runnable) {
        l().removeCallbacks(runnable);
    }

    @NonNull
    public static String z(@NonNull byte[] bArr) {
        String e2;
        char[] cArr = f9953d;
        synchronized (cArr) {
            e2 = e(bArr, cArr);
        }
        return e2;
    }
}
