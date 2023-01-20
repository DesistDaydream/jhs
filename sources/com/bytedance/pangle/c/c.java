package com.bytedance.pangle.c;

import android.app.Application;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.pangle.GlobalParam;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.ZeusConstants;
import java.io.File;

/* loaded from: classes.dex */
public final class c {
    private static File a;
    private static File b;

    /* renamed from: c  reason: collision with root package name */
    private static File f2228c;

    private static String a(File file) {
        if (file != null) {
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getPath();
        }
        return null;
    }

    public static String b() {
        Application appApplication = Zeus.getAppApplication();
        if (f2228c == null) {
            File filesDir = appApplication.getFilesDir();
            f2228c = new File(filesDir, "." + ZeusConstants.BASE_LIB_NAME + ZeusConstants.a);
        }
        return a(f2228c);
    }

    public static String c() {
        Application appApplication = Zeus.getAppApplication();
        try {
            if ("mounted".equals(Environment.getExternalStorageState())) {
                File externalFilesDir = appApplication.getExternalFilesDir("." + ZeusConstants.BASE_LIB_NAME + ZeusConstants.b);
                if (externalFilesDir != null) {
                    return a(externalFilesDir);
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private static void d() {
        if (a == null) {
            File filesDir = Zeus.getAppApplication().getFilesDir();
            File file = new File(filesDir, ZeusConstants.BASE_LIB_NAME + ZeusConstants.f2199c);
            a = file;
            a(file);
        }
    }

    private static String a(String... strArr) {
        d();
        File file = a;
        if (strArr.length > 0) {
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    file = new File(file, str);
                }
            }
        }
        return a(file);
    }

    public static String d(String str, int i2) {
        return a(str, "version-".concat(String.valueOf(i2)), "lib");
    }

    public static String b(String str, int i2) {
        return new File(a(str, "version-".concat(String.valueOf(i2)), e.l.d.f12006d), "base-1.apk").getPath();
    }

    public static String c(String str, int i2) {
        return a(str, "version-".concat(String.valueOf(i2)), "dalvik-cache");
    }

    public static String a() {
        Application appApplication = Zeus.getAppApplication();
        if (b == null) {
            File downloadDir = GlobalParam.getInstance().getDownloadDir();
            if (downloadDir == null) {
                File filesDir = appApplication.getFilesDir();
                downloadDir = new File(filesDir, "." + ZeusConstants.BASE_LIB_NAME + ZeusConstants.b);
            }
            b = downloadDir;
        }
        return a(b);
    }

    public static String a(String str, int i2) {
        d();
        File file = a;
        String[] strArr = {str, "version-".concat(String.valueOf(i2))};
        for (int i3 = 0; i3 < 2; i3++) {
            String str2 = strArr[i3];
            if (!TextUtils.isEmpty(str2)) {
                file = new File(file, str2);
            }
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public static String a(String str) {
        return a(str);
    }
}
