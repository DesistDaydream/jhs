package e.k.c.a.a.j.q;

import android.content.Context;

/* loaded from: classes2.dex */
public class e {
    private static Context a;

    public static Context a() {
        return a;
    }

    public static void b(Context context) {
        if (context == null || a != null) {
            return;
        }
        a = context.getApplicationContext();
    }
}
