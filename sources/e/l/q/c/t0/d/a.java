package e.l.q.c.t0.d;

import android.view.View;

/* loaded from: classes2.dex */
public class a {
    private static final int a = 16;

    public static int a(int i2) {
        return c(i2);
    }

    private static int b(int i2) {
        return (i2 & 65280) >> 8;
    }

    private static int c(int i2) {
        return (i2 & 65280) >> 8;
    }

    public static void d(View view, Runnable runnable) {
        e(view, runnable);
    }

    private static void e(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }
}
