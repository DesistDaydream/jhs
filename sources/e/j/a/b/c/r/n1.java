package e.j.a.b.c.r;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class n1 {
    private static Object a = new Object();
    @GuardedBy("sLock")
    private static boolean b;

    /* renamed from: c  reason: collision with root package name */
    private static String f10437c;

    /* renamed from: d  reason: collision with root package name */
    private static int f10438d;

    public static String a(Context context) {
        c(context);
        return f10437c;
    }

    public static int b(Context context) {
        c(context);
        return f10438d;
    }

    private static void c(Context context) {
        Bundle bundle;
        synchronized (a) {
            if (b) {
                return;
            }
            b = true;
            try {
                bundle = e.j.a.b.c.y.c.a(context).c(context.getPackageName(), 128).metaData;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.wtf("MetadataValueReader", "This should never happen.", e2);
            }
            if (bundle == null) {
                return;
            }
            f10437c = bundle.getString("com.google.app.id");
            f10438d = bundle.getInt("com.google.android.gms.version");
        }
    }
}
