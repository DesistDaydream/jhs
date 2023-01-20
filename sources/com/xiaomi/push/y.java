package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes3.dex */
public class y {
    private static volatile boolean a = false;

    private static void a(Class<?> cls, Context context) {
        if (a) {
            return;
        }
        try {
            a = true;
            cls.getDeclaredMethod("InitEntry", Context.class).invoke(cls, context);
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("mdid:load lib error " + th);
        }
    }

    public static boolean a(Context context) {
        try {
            Class<?> a2 = jl.a(context, "com.bun.miitmdid.core.JLibrary");
            if (a2 != null) {
                a(a2, context);
                return true;
            }
            return false;
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("mdid:check error " + th);
            return false;
        }
    }
}
