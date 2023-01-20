package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/* loaded from: classes.dex */
public class bh {
    public static final String a = "IOUtils";

    public static boolean a(String str, String str2) {
        try {
            File file = new File(str);
            File file2 = new File(str2);
            if (file.exists()) {
                return file.renameTo(file2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void a(InputStream inputStream, String str) {
        FileOutputStream fileOutputStream;
        FileOutputStream fileOutputStream2 = null;
        try {
            fileOutputStream = new FileOutputStream(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                fileOutputStream.write(bArr, 0, read);
            }
            inputStream.close();
            fileOutputStream.close();
            if (inputStream != null) {
                inputStream.close();
            }
            fileOutputStream.close();
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream2 != null) {
                fileOutputStream2.close();
            }
            throw th;
        }
    }

    public static void a(Context context, String str, String str2) {
        try {
            a(context.getAssets().open(str), str2);
        } catch (Exception e2) {
            bj.a().a(e2);
        }
    }

    public static boolean a(File file) {
        if (file != null) {
            try {
                if (file.exists() && file.canRead()) {
                    return file.length() > 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static boolean a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            File file = new File(str);
            if (file.exists() && file.canRead()) {
                return file.length() > 0;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
