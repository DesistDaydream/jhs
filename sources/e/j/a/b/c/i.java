package e.j.a.b.c;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.util.Log;
import javax.annotation.CheckReturnValue;

@e.j.a.b.c.m.a
@e.j.a.b.c.r.d0
@CheckReturnValue
/* loaded from: classes2.dex */
public class i {

    /* renamed from: c  reason: collision with root package name */
    private static i f10145c;
    private final Context a;
    private volatile String b;

    private i(Context context) {
        this.a = context.getApplicationContext();
    }

    @e.j.a.b.c.m.a
    public static i a(Context context) {
        e.j.a.b.c.r.a0.k(context);
        synchronized (i.class) {
            if (f10145c == null) {
                c0.c(context);
                f10145c = new i(context);
            }
        }
        return f10145c;
    }

    private static e0 e(PackageInfo packageInfo, e0... e0VarArr) {
        Signature[] signatureArr = packageInfo.signatures;
        if (signatureArr == null) {
            return null;
        }
        if (signatureArr.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        f0 f0Var = new f0(packageInfo.signatures[0].toByteArray());
        for (int i2 = 0; i2 < e0VarArr.length; i2++) {
            if (e0VarArr[i2].equals(f0Var)) {
                return e0VarArr[i2];
            }
        }
        return null;
    }

    private final l0 f(String str, int i2) {
        ApplicationInfo applicationInfo;
        try {
            PackageInfo h2 = e.j.a.b.c.y.c.a(this.a).h(str, 64, i2);
            boolean k2 = h.k(this.a);
            if (h2 == null) {
                return l0.d("null pkg");
            }
            if (h2.signatures.length != 1) {
                return l0.d("single cert required");
            }
            f0 f0Var = new f0(h2.signatures[0].toByteArray());
            String str2 = h2.packageName;
            l0 a = c0.a(str2, f0Var, k2, false);
            return (!a.a || (applicationInfo = h2.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !c0.a(str2, f0Var, false, true).a) ? a : l0.d("debuggable release cert app rejected");
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return l0.d(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    public static boolean g(PackageInfo packageInfo, boolean z) {
        if (packageInfo != null && packageInfo.signatures != null) {
            if ((z ? e(packageInfo, h0.a) : e(packageInfo, h0.a[0])) != null) {
                return true;
            }
        }
        return false;
    }

    private final l0 h(String str) {
        l0 d2;
        ApplicationInfo applicationInfo;
        if (str == null) {
            return l0.d("null pkg");
        }
        if (str.equals(this.b)) {
            return l0.f();
        }
        try {
            PackageInfo e2 = e.j.a.b.c.y.c.a(this.a).e(str, 64);
            boolean k2 = h.k(this.a);
            if (e2 == null) {
                d2 = l0.d("null pkg");
            } else if (e2.signatures.length != 1) {
                d2 = l0.d("single cert required");
            } else {
                f0 f0Var = new f0(e2.signatures[0].toByteArray());
                String str2 = e2.packageName;
                l0 a = c0.a(str2, f0Var, k2, false);
                d2 = (!a.a || (applicationInfo = e2.applicationInfo) == null || (applicationInfo.flags & 2) == 0 || !c0.a(str2, f0Var, false, true).a) ? a : l0.d("debuggable release cert app rejected");
            }
            if (d2.a) {
                this.b = str;
            }
            return d2;
        } catch (PackageManager.NameNotFoundException unused) {
            String valueOf = String.valueOf(str);
            return l0.d(valueOf.length() != 0 ? "no pkg ".concat(valueOf) : new String("no pkg "));
        }
    }

    @e.j.a.b.c.m.a
    public boolean b(PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (g(packageInfo, false)) {
            return true;
        }
        if (g(packageInfo, true)) {
            if (h.k(this.a)) {
                return true;
            }
            Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        }
        return false;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public boolean c(String str) {
        l0 h2 = h(str);
        h2.g();
        return h2.a;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public boolean d(int i2) {
        l0 d2;
        String[] f2 = e.j.a.b.c.y.c.a(this.a).f(i2);
        if (f2 == null || f2.length == 0) {
            d2 = l0.d("no pkgs");
        } else {
            d2 = null;
            for (String str : f2) {
                d2 = f(str, i2);
                if (d2.a) {
                    break;
                }
            }
        }
        d2.g();
        return d2.a;
    }
}
