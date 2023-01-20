package e.j.a.b.c.y;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.Process;
import e.j.a.b.c.x.v;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class b {
    private final Context a;

    public b(Context context) {
        this.a = context;
    }

    @e.j.a.b.c.m.a
    public int a(String str) {
        return this.a.checkCallingOrSelfPermission(str);
    }

    @e.j.a.b.c.m.a
    public int b(String str, String str2) {
        return this.a.getPackageManager().checkPermission(str, str2);
    }

    @e.j.a.b.c.m.a
    public ApplicationInfo c(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationInfo(str, i2);
    }

    @e.j.a.b.c.m.a
    public CharSequence d(String str) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getApplicationLabel(this.a.getPackageManager().getApplicationInfo(str, 0));
    }

    @e.j.a.b.c.m.a
    public PackageInfo e(String str, int i2) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, i2);
    }

    public final String[] f(int i2) {
        return this.a.getPackageManager().getPackagesForUid(i2);
    }

    @e.j.a.b.c.m.a
    public boolean g() {
        String nameForUid;
        if (Binder.getCallingUid() == Process.myUid()) {
            return a.a(this.a);
        }
        if (!v.n() || (nameForUid = this.a.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return this.a.getPackageManager().isInstantApp(nameForUid);
    }

    public final PackageInfo h(String str, int i2, int i3) throws PackageManager.NameNotFoundException {
        return this.a.getPackageManager().getPackageInfo(str, 64);
    }

    @TargetApi(19)
    public final boolean i(int i2, String str) {
        if (v.h()) {
            try {
                ((AppOpsManager) this.a.getSystemService("appops")).checkPackage(i2, str);
                return true;
            } catch (SecurityException unused) {
                return false;
            }
        }
        String[] packagesForUid = this.a.getPackageManager().getPackagesForUid(i2);
        if (str != null && packagesForUid != null) {
            for (String str2 : packagesForUid) {
                if (str.equals(str2)) {
                    return true;
                }
            }
        }
        return false;
    }
}
