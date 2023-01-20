package com.xiaomi.push;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes3.dex */
public class av {
    public static String a() {
        return Build.VERSION.RELEASE + Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL;
    }

    public static String a(Context context) {
        String b = ay.a(context).b("sp_client_report_status", "sp_client_report_key", "");
        if (TextUtils.isEmpty(b)) {
            String a = ar.a(20);
            ay.a(context).a("sp_client_report_status", "sp_client_report_key", a);
            return a;
        }
        return b;
    }

    public static void a(Context context, String str) {
        Intent intent = new Intent("com.xiaomi.xmsf.push.XMSF_UPLOAD_ACTIVE");
        intent.putExtra("pkgname", context.getPackageName());
        intent.putExtra("category", "category_client_report_data");
        intent.putExtra("name", "quality_support");
        intent.putExtra("data", str);
        context.sendBroadcast(intent, "com.xiaomi.xmsf.permission.USE_XMSF_UPLOAD");
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:0x00e4, code lost:
        if (r7 == null) goto L57;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(android.content.Context r11, java.lang.String r12, java.lang.String r13) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.av.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void a(Context context, List<String> list) {
        if (list == null || list.size() <= 0 || !b(context)) {
            return;
        }
        for (String str : list) {
            if (!TextUtils.isEmpty(str)) {
                a(context, str);
            }
        }
    }

    @TargetApi(9)
    public static byte[] a(String str) {
        byte[] copyOf = Arrays.copyOf(ao.b(str), 16);
        copyOf[0] = 68;
        copyOf[15] = 84;
        return copyOf;
    }

    public static boolean b(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo("com.xiaomi.xmsf", 0).versionCode >= 108;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public static boolean b(Context context, String str) {
        File file = new File(str);
        long e2 = com.xiaomi.b.b.b.a(context).a().e();
        if (file.exists()) {
            try {
                if (file.length() > e2) {
                    return false;
                }
            } catch (Exception e3) {
                com.xiaomi.a.a.a.c.a(e3);
                return false;
            }
        } else {
            c.b(file);
        }
        return true;
    }

    public static File[] c(Context context, String str) {
        File externalFilesDir = context.getExternalFilesDir(str);
        if (externalFilesDir != null) {
            return externalFilesDir.listFiles(new ax());
        }
        return null;
    }
}
