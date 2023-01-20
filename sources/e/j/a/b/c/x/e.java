package e.j.a.b.c.x;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.annotation.Nullable;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class e {
    private e() {
    }

    @e.j.a.b.c.m.a
    public static int a(Context context, String str) {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        PackageInfo c2 = c(context, str);
        if (c2 == null || (applicationInfo = c2.applicationInfo) == null || (bundle = applicationInfo.metaData) == null) {
            return -1;
        }
        return bundle.getInt("com.google.android.gms.version", -1);
    }

    @e.j.a.b.c.m.a
    public static boolean b() {
        return false;
    }

    @Nullable
    private static PackageInfo c(Context context, String str) {
        try {
            return e.j.a.b.c.y.c.a(context).e(str, 128);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        "com.google.android.gms".equals(str);
        return (e.j.a.b.c.y.c.a(context).c(str, 0).flags & 2097152) != 0;
    }
}
