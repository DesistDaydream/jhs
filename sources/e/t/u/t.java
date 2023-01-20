package e.t.u;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import com.tencent.android.tpush.common.Constants;
import com.vivo.push.PushClientConstants;
import h.a2.l0;
import h.k2.v.f0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\n\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0004J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010'\u001a\u00020(H\u0002J\b\u0010)\u001a\u00020\u0004H\u0002J\u0014\u0010*\u001a\u0004\u0018\u00010\u00042\b\u0010+\u001a\u0004\u0018\u00010\u0004H\u0007J\u0010\u0010,\u001a\u00020-2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0006\u0010.\u001a\u00020-J\u0006\u0010/\u001a\u00020\u0019J\u0010\u00100\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0006\u00101\u001a\u00020\u0019J\u000e\u00102\u001a\u00020\u00192\u0006\u0010&\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0019J\u0006\u00104\u001a\u00020\u0019J\u001a\u00105\u001a\u00020-2\b\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u00106\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00198F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b \u0010\u0013R\u0014\u0010!\u001a\u00020\"8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u00067"}, d2 = {"Lcom/vector/util/PackageUtil;", "", "()V", "ANDROID_MARKET_PACKAGE_NAME", "", "appIcon", "Landroid/graphics/drawable/Drawable;", "getAppIcon", "()Landroid/graphics/drawable/Drawable;", "appName", "", "getAppName", "()Ljava/lang/CharSequence;", "appVersionCode", "", "getAppVersionCode", "()J", "appVersionName", "getAppVersionName", "()Ljava/lang/String;", "applicationInfo", "Landroid/content/pm/ApplicationInfo;", "getApplicationInfo", "()Landroid/content/pm/ApplicationInfo;", "isAndroidMarketAvailable", "", "()Z", "packageInfo", "Landroid/content/pm/PackageInfo;", "getPackageInfo", "()Landroid/content/pm/PackageInfo;", PushClientConstants.TAG_PKG_NAME, "getPkgName", "pm", "Landroid/content/pm/PackageManager;", "getPm", "()Landroid/content/pm/PackageManager;", "checkAppInstall", Constants.FLAG_PACKAGE_NAME, "flag", "", "getBrand", "getMetaValue", "key", "gotoAppDetail", "", "gotoFacebookAppDetailPage", "isAppInBackground", "isAppInstalled", "isFacebookInstall", "isInstallApp", "isMeiZuBrand", "isXiaoMiBrand", "setMetaValue", "value", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class t {
    @k.e.a.d
    public static final t a = new t();
    @k.e.a.d
    private static final String b = "com.android.vending";

    private t() {
    }

    private final ApplicationInfo f() {
        return g(0);
    }

    private final ApplicationInfo g(int i2) {
        try {
            return l().getApplicationInfo(k(), i2);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final String h() {
        return Build.BRAND.toLowerCase(Locale.ROOT);
    }

    @h.k2.k
    @k.e.a.e
    public static final String i(@k.e.a.e String str) {
        Bundle bundle;
        Object obj;
        ApplicationInfo g2 = a.g(128);
        if (g2 == null || (bundle = g2.metaData) == null || (obj = bundle.get(str)) == null) {
            return null;
        }
        return obj.toString();
    }

    private final PackageInfo j() {
        try {
            return l().getPackageInfo(k(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private final PackageManager l() {
        return e.t.a.b().getPackageManager();
    }

    private final void m(String str) {
        Intent intent = new Intent();
        intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse(f0.C("package:", str)));
        intent.addFlags(268435456);
        e.t.a.b().startActivity(intent);
    }

    private final boolean q(String str) {
        try {
            e.t.a.b().getPackageManager().getPackageInfo(str, 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final boolean a(@k.e.a.d String str) {
        if (str.length() == 0) {
            return false;
        }
        try {
            return e.t.a.b().getPackageManager().getPackageInfo(str, 0) != null;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    @k.e.a.e
    public final Drawable b() {
        try {
            return l().getApplicationIcon(k());
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @k.e.a.e
    public final CharSequence c() {
        ApplicationInfo f2 = f();
        if (f2 == null) {
            return null;
        }
        return a.l().getApplicationLabel(f2);
    }

    public final long d() {
        if (Build.VERSION.SDK_INT >= 28) {
            PackageInfo j2 = j();
            if (j2 == null) {
                return -1L;
            }
            return j2.getLongVersionCode();
        }
        PackageInfo j3 = j();
        return j3 == null ? -1 : j3.versionCode;
    }

    @k.e.a.d
    public final String e() {
        String str;
        PackageInfo j2 = j();
        return (j2 == null || (str = j2.versionName) == null) ? "" : str;
    }

    @k.e.a.d
    public final String k() {
        return e.t.a.b().getPackageName();
    }

    public final void n() {
        m("com.facebook.katana");
    }

    public final boolean o() {
        List<PackageInfo> installedPackages = l().getInstalledPackages(0);
        h.o2.k F = CollectionsKt__CollectionsKt.F(installedPackages);
        ArrayList<PackageInfo> arrayList = new ArrayList(h.a2.u.Y(F, 10));
        Iterator<Integer> it = F.iterator();
        while (it.hasNext()) {
            arrayList.add(installedPackages.get(((l0) it).nextInt()));
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        for (PackageInfo packageInfo : arrayList) {
            if (f0.g(packageInfo.packageName, "com.android.vending")) {
                return true;
            }
        }
        return false;
    }

    public final boolean p() {
        Object systemService = e.t.a.b().getSystemService("activity");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        for (ActivityManager.RunningTaskInfo runningTaskInfo : ((ActivityManager) systemService).getRunningTasks(1)) {
            ComponentName componentName = runningTaskInfo.topActivity;
            if (f0.g(componentName == null ? null : componentName.getPackageName(), e.t.a.b().getPackageName())) {
                return false;
            }
        }
        return true;
    }

    public final boolean r() {
        return q("com.facebook.katana");
    }

    public final boolean s(@k.e.a.d String str) {
        return q(str);
    }

    public final boolean t() {
        return f0.g(h(), "meizu");
    }

    public final boolean u() {
        return f0.g(h(), "xiaomi");
    }

    @h.i(message = "")
    public final void v(@k.e.a.e String str, @k.e.a.d String str2) {
        Bundle bundle;
        ApplicationInfo g2 = g(128);
        if (g2 == null || (bundle = g2.metaData) == null) {
            return;
        }
        bundle.putString(str, str2);
    }
}
