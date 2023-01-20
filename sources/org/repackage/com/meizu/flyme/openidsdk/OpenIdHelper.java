package org.repackage.com.meizu.flyme.openidsdk;

import android.content.Context;
import android.util.Log;
import java.lang.reflect.Method;

/* loaded from: classes4.dex */
public class OpenIdHelper {
    private static final String a = "OpenIdHelper";
    private static Method b;

    public static String a(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.a);
    }

    public static void a(boolean z) {
        b.a();
        b.a(z);
    }

    public static final boolean a() {
        Context context = null;
        try {
            if (b == null) {
                Method method = Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]);
                b = method;
                method.setAccessible(true);
            }
            context = (Context) b.invoke(null, new Object[0]);
        } catch (Exception e2) {
            Log.e(a, "ActivityThread:currentApplication --> " + e2.toString());
        }
        if (context == null) {
            return false;
        }
        return b.a().a(context, false);
    }

    public static String b(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.b);
    }

    public static String c(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.f17124d);
    }

    public static String d(Context context) {
        b a2 = b.a();
        return a2.a(context.getApplicationContext(), a2.f17123c);
    }
}
