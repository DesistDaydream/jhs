package e.j.a.b.c;

import android.annotation.TargetApi;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.R;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.jihuanshe.mmkv.UserKV;
import e.j.a.b.c.r.n1;
import e.j.a.b.c.r.p;
import e.j.a.b.c.x.v;
import java.util.concurrent.atomic.AtomicBoolean;

@e.j.a.b.c.m.a
@e.j.a.b.c.r.d0
/* loaded from: classes2.dex */
public class h {
    @e.j.a.b.c.m.a
    @Deprecated
    public static final int a = 12451000;
    @e.j.a.b.c.m.a
    @Deprecated
    public static final String b = "com.google.android.gms";
    @e.j.a.b.c.m.a

    /* renamed from: c  reason: collision with root package name */
    public static final String f10135c = "com.google.android.play.games";
    @e.j.a.b.c.m.a

    /* renamed from: d  reason: collision with root package name */
    public static final String f10136d = "com.android.vending";
    @e.j.a.b.c.m.a

    /* renamed from: e  reason: collision with root package name */
    public static final int f10137e = 39789;
    @e.j.a.b.c.m.a

    /* renamed from: f  reason: collision with root package name */
    public static final int f10138f = 10436;
    @e.j.a.b.c.x.d0

    /* renamed from: g  reason: collision with root package name */
    private static boolean f10139g = false;
    @e.j.a.b.c.x.d0

    /* renamed from: h  reason: collision with root package name */
    private static boolean f10140h = false;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f10141i = false;
    @e.j.a.b.c.x.d0

    /* renamed from: j  reason: collision with root package name */
    private static boolean f10142j = false;
    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0

    /* renamed from: k  reason: collision with root package name */
    public static final AtomicBoolean f10143k = new AtomicBoolean();

    /* renamed from: l  reason: collision with root package name */
    private static final AtomicBoolean f10144l = new AtomicBoolean();

    @e.j.a.b.c.m.a
    @Deprecated
    public static void a(Context context) {
        if (f10143k.getAndSet(true)) {
            return;
        }
        try {
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(RemoteMessageConst.NOTIFICATION);
            if (notificationManager != null) {
                notificationManager.cancel(f10138f);
            }
        } catch (SecurityException unused) {
        }
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public static void b() {
        f10144l.set(true);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static void c(Context context, int i2) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int k2 = f.i().k(context, i2);
        if (k2 != 0) {
            Intent e2 = f.i().e(context, k2, com.huawei.hms.push.e.a);
            StringBuilder sb = new StringBuilder(57);
            sb.append("GooglePlayServices not available due to error ");
            sb.append(k2);
            Log.e("GooglePlayServicesUtil", sb.toString());
            if (e2 == null) {
                throw new GooglePlayServicesNotAvailableException(k2);
            }
            throw new GooglePlayServicesRepairableException(k2, "Google Play Services not available", e2);
        }
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    @Deprecated
    public static int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    @Deprecated
    public static int e(Context context) {
        e.j.a.b.c.r.a0.q(true);
        return e.j.a.b.c.x.e.a(context, context.getPackageName());
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static PendingIntent f(int i2, Context context, int i3) {
        return f.i().f(context, i2, i3);
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.x.d0
    @Deprecated
    public static String g(int i2) {
        return ConnectionResult.zza(i2);
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    @Deprecated
    public static Intent h(int i2) {
        return f.i().e(null, i2, null);
    }

    @e.j.a.b.c.m.a
    public static Context i(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @e.j.a.b.c.m.a
    public static Resources j(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    public static boolean k(Context context) {
        try {
            if (!f10142j) {
                PackageInfo e2 = e.j.a.b.c.y.c.a(context).e("com.google.android.gms", 64);
                i.a(context);
                if (e2 != null && !i.g(e2, false) && i.g(e2, true)) {
                    f10141i = true;
                } else {
                    f10141i = false;
                }
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e3);
        } finally {
            f10142j = true;
        }
        return f10141i || !e.j.a.b.c.x.l.f();
    }

    @e.j.a.b.c.m.a
    @p
    @Deprecated
    public static int l(Context context) {
        return m(context, a);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static int m(Context context, int i2) {
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable unused) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName()) && !f10144l.get()) {
            int b2 = n1.b(context);
            if (b2 != 0) {
                int i3 = a;
                if (b2 != i3) {
                    StringBuilder sb = new StringBuilder(320);
                    sb.append("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected ");
                    sb.append(i3);
                    sb.append(" but found ");
                    sb.append(b2);
                    sb.append(".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
            }
        }
        return v(context, (e.j.a.b.c.x.l.h(context) || e.j.a.b.c.x.l.i(context)) ? false : true, i2);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static boolean n(Context context, int i2) {
        return e.j.a.b.c.x.c0.a(context, i2);
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    @Deprecated
    public static boolean o(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return s(context, "com.google.android.gms");
        }
        return false;
    }

    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    @Deprecated
    public static boolean p(Context context, int i2) {
        if (i2 == 9) {
            return s(context, "com.android.vending");
        }
        return false;
    }

    @e.j.a.b.c.m.a
    @TargetApi(18)
    public static boolean q(Context context) {
        Bundle applicationRestrictions;
        return v.g() && (applicationRestrictions = ((UserManager) context.getSystemService(UserKV.f3914d)).getApplicationRestrictions(context.getPackageName())) != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    @Deprecated
    @e.j.a.b.c.m.a
    @e.j.a.b.c.r.d0
    @e.j.a.b.c.x.d0
    public static boolean r(Context context) {
        return e.j.a.b.c.x.l.c(context);
    }

    @TargetApi(21)
    public static boolean s(Context context, String str) {
        ApplicationInfo applicationInfo;
        boolean equals = str.equals("com.google.android.gms");
        if (v.j()) {
            try {
                for (PackageInstaller.SessionInfo sessionInfo : context.getPackageManager().getPackageInstaller().getAllSessions()) {
                    if (str.equals(sessionInfo.getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        if (equals) {
            return applicationInfo.enabled;
        }
        return applicationInfo.enabled && !q(context);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public static boolean t(int i2) {
        return i2 == 1 || i2 == 2 || i2 == 3 || i2 == 9;
    }

    @e.j.a.b.c.m.a
    @TargetApi(19)
    @Deprecated
    public static boolean u(Context context, int i2, String str) {
        return e.j.a.b.c.x.c0.b(context, i2, str);
    }

    @e.j.a.b.c.x.d0
    private static int v(Context context, boolean z, int i2) {
        e.j.a.b.c.r.a0.a(i2 >= 0);
        PackageManager packageManager = context.getPackageManager();
        PackageInfo packageInfo = null;
        if (z) {
            try {
                packageInfo = packageManager.getPackageInfo("com.android.vending", 8256);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("GooglePlayServicesUtil", "Google Play Store is missing.");
                return 9;
            }
        }
        try {
            PackageInfo packageInfo2 = packageManager.getPackageInfo("com.google.android.gms", 64);
            i.a(context);
            if (!i.g(packageInfo2, true)) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            } else if (z && (!i.g(packageInfo, true) || !packageInfo.signatures[0].equals(packageInfo2.signatures[0]))) {
                Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                return 9;
            } else if (e.j.a.b.c.x.h0.a(packageInfo2.versionCode) < e.j.a.b.c.x.h0.a(i2)) {
                int i3 = packageInfo2.versionCode;
                StringBuilder sb = new StringBuilder(77);
                sb.append("Google Play services out of date.  Requires ");
                sb.append(i2);
                sb.append(" but found ");
                sb.append(i3);
                Log.w("GooglePlayServicesUtil", sb.toString());
                return 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo2.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e2) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e2);
                        return 1;
                    }
                }
                return !applicationInfo.enabled ? 3 : 0;
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }
}
