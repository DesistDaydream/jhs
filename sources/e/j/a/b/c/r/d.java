package e.j.a.b.c.r;

import android.os.Looper;
import android.util.Log;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class d {
    private d() {
        throw new AssertionError("Uninstantiable");
    }

    @e.j.a.b.c.m.a
    public static void a(String str) {
        if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
            return;
        }
        String valueOf = String.valueOf(Thread.currentThread());
        String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 57 + String.valueOf(valueOf2).length());
        sb.append("checkMainThread: current thread ");
        sb.append(valueOf);
        sb.append(" IS NOT the main thread ");
        sb.append(valueOf2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(str);
    }

    @e.j.a.b.c.m.a
    public static void b(String str) {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            return;
        }
        String valueOf = String.valueOf(Thread.currentThread());
        String valueOf2 = String.valueOf(Looper.getMainLooper().getThread());
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length());
        sb.append("checkNotMainThread: current thread ");
        sb.append(valueOf);
        sb.append(" IS the main thread ");
        sb.append(valueOf2);
        sb.append("!");
        Log.e("Asserts", sb.toString());
        throw new IllegalStateException(str);
    }

    @e.j.a.b.c.m.a
    public static void c(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("null reference");
        }
    }

    @e.j.a.b.c.m.a
    public static void d(Object obj, Object obj2) {
        if (obj == null) {
            throw new IllegalArgumentException(String.valueOf(obj2));
        }
    }

    @e.j.a.b.c.m.a
    public static void e(Object obj) {
        if (obj != null) {
            throw new IllegalArgumentException("non-null reference");
        }
    }

    @e.j.a.b.c.m.a
    public static void f(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    @e.j.a.b.c.m.a
    public static void g(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
