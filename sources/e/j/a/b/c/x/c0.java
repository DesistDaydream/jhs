package e.j.a.b.c.x;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class c0 {
    private c0() {
    }

    @e.j.a.b.c.m.a
    public static boolean a(Context context, int i2) {
        if (b(context, i2, "com.google.android.gms")) {
            try {
                return e.j.a.b.c.i.a(context).b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
            } catch (PackageManager.NameNotFoundException unused) {
                if (Log.isLoggable("UidVerifier", 3)) {
                    Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
                }
                return false;
            }
        }
        return false;
    }

    @e.j.a.b.c.m.a
    @TargetApi(19)
    public static boolean b(Context context, int i2, String str) {
        return e.j.a.b.c.y.c.a(context).i(i2, str);
    }
}
