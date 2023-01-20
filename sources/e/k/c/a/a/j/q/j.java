package e.k.c.a.a.j.q;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: classes2.dex */
public class j {
    private static final String a = "h";

    public static String a(String str) {
        Context a2 = e.a();
        if (a2 == null) {
            return "";
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            String str2 = a;
            i.d(str2, "getVersion NameNotFoundException : " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            String str3 = a;
            i.d(str3, "getVersion: " + e3.getMessage());
            return "";
        } catch (Throwable unused) {
            i.d(a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context a2 = e.a();
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            i.d(a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e2) {
            String str2 = a;
            i.d(str2, "getVersion: " + e2.getMessage());
            return 0;
        }
    }
}
