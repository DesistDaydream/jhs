package com.ss.android.socialbase.appdownloader.f.a;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import androidx.annotation.NonNull;
import e.t.j.g.r;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class e {
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
        r13 = r1.getInputStream(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006e, code lost:
        r4 = r1;
        r5 = r2;
        r1 = null;
        r13 = r13;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v10, types: [java.io.FileInputStream] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo a(@androidx.annotation.NonNull java.io.File r13) {
        /*
            Method dump skipped, instructions count: 388
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.f.a.e.a(java.io.File):android.content.pm.PackageInfo");
    }

    private static String a(int i2) {
        return (i2 >>> 24) == 1 ? r.b : "";
    }

    private static PackageInfo b(@NonNull Context context, @NonNull File file, int i2) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            a("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i2);
        } catch (Throwable th) {
            a("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }

    public static PackageInfo a(@NonNull Context context, @NonNull File file, int i2) {
        int i3;
        if (com.ss.android.socialbase.downloader.i.a.a(268435456) && (i3 = Build.VERSION.SDK_INT) >= 21 && i3 < 26) {
            try {
                return a(file);
            } catch (Throwable th) {
                a("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
                return b(context, file, i2);
            }
        }
        return b(context, file, i2);
    }

    private static void a(@NonNull String str, @NonNull String str2) {
        com.ss.android.socialbase.downloader.d.b g2 = com.ss.android.socialbase.downloader.downloader.c.g();
        if (g2 == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException unused) {
        }
        g2.a(str, jSONObject, null, null);
    }

    private static String a(a aVar, int i2) {
        int b = aVar.b(i2);
        int c2 = aVar.c(i2);
        if (b == 3) {
            return aVar.d(i2);
        }
        return b == 2 ? String.format("?%s%08X", a(c2), Integer.valueOf(c2)) : (b < 16 || b > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(c2), Integer.valueOf(b)) : String.valueOf(c2);
    }

    public static String a(Context context, PackageInfo packageInfo, String str) {
        ApplicationInfo applicationInfo;
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) {
            return null;
        }
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e2) {
            a("getPackageInfo::fail_load_label", e2.getMessage());
            return null;
        }
    }
}
