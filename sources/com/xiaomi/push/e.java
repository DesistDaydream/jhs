package com.xiaomi.push;

import android.os.Environment;
import android.os.StatFs;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;

/* loaded from: classes3.dex */
public class e {
    public static boolean a() {
        try {
            return Environment.getExternalStorageState().equals("removed");
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return true;
        }
    }

    public static boolean b() {
        try {
            return true ^ Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e2) {
            Log.e("XMPush-", "check SDCard is busy: " + e2);
            return true;
        }
    }

    public static boolean c() {
        return e() <= 102400;
    }

    public static boolean d() {
        return (b() || c() || a()) ? false : true;
    }

    public static long e() {
        File externalStorageDirectory;
        if (!b() && (externalStorageDirectory = Environment.getExternalStorageDirectory()) != null && !TextUtils.isEmpty(externalStorageDirectory.getPath())) {
            try {
                StatFs statFs = new StatFs(externalStorageDirectory.getPath());
                return statFs.getBlockSize() * (statFs.getAvailableBlocks() - 4);
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }
}
