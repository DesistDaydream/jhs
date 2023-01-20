package e.j.a.b.c.r;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.j.a.b.c.x.i0;
import java.util.Objects;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class a0 {
    private a0() {
        throw new AssertionError("Uninstantiable");
    }

    @e.j.a.b.c.m.a
    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    @e.j.a.b.c.m.a
    public static void b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @e.j.a.b.c.m.a
    public static void c(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    @e.j.a.b.c.m.a
    public static void d(Handler handler) {
        e(handler, "Must be called on the handler thread");
    }

    @e.j.a.b.c.m.a
    public static void e(Handler handler, String str) {
        if (Looper.myLooper() != handler.getLooper()) {
            throw new IllegalStateException(str);
        }
    }

    @e.j.a.b.c.m.a
    public static void f(String str) {
        if (!i0.a()) {
            throw new IllegalStateException(str);
        }
    }

    @e.j.a.b.c.m.a
    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    @e.j.a.b.c.m.a
    public static String h(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    @e.j.a.b.c.m.a
    public static void i() {
        j("Must not be called on the main application thread");
    }

    @e.j.a.b.c.m.a
    public static void j(String str) {
        if (i0.a()) {
            throw new IllegalStateException(str);
        }
    }

    @NonNull
    @e.j.a.b.c.m.a
    public static <T> T k(@Nullable T t) {
        Objects.requireNonNull(t, "null reference");
        return t;
    }

    @NonNull
    @e.j.a.b.c.m.a
    public static <T> T l(T t, Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @e.j.a.b.c.m.a
    public static int m(int i2) {
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    @e.j.a.b.c.m.a
    public static int n(int i2, Object obj) {
        if (i2 != 0) {
            return i2;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @e.j.a.b.c.m.a
    public static long o(long j2) {
        if (j2 != 0) {
            return j2;
        }
        throw new IllegalArgumentException("Given Long is zero");
    }

    @e.j.a.b.c.m.a
    public static long p(long j2, Object obj) {
        if (j2 != 0) {
            return j2;
        }
        throw new IllegalArgumentException(String.valueOf(obj));
    }

    @e.j.a.b.c.m.a
    public static void q(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @e.j.a.b.c.m.a
    public static void r(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    @e.j.a.b.c.m.a
    public static void s(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }
}
