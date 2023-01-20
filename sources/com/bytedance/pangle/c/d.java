package com.bytedance.pangle.c;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class d {
    private static String a;
    private static List<String> b = new CopyOnWriteArrayList();

    public static String a() {
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                String processName = Application.getProcessName();
                if (!TextUtils.isEmpty(processName)) {
                    a = processName;
                }
                return a;
            }
        } catch (Throwable unused) {
        }
        try {
            Object invokeStaticMethod = MethodUtils.invokeStaticMethod(Class.forName("android.app.ActivityThread"), "currentProcessName", new Object[0]);
            if (!TextUtils.isEmpty((String) invokeStaticMethod)) {
                a = (String) invokeStaticMethod;
            }
            return a;
        } catch (Exception e2) {
            e2.printStackTrace();
            String b2 = b();
            a = b2;
            return b2;
        }
    }

    private static String b() {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream("/proc/" + Process.myPid() + "/cmdline"), "iso-8859-1"));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    int read = bufferedReader.read();
                    if (read <= 0) {
                        break;
                    }
                    sb.append((char) read);
                }
                if (ZeusLogger.isDebug()) {
                    ZeusLogger.d("Process", "get processName = " + sb.toString());
                }
                String sb2 = sb.toString();
                try {
                    bufferedReader.close();
                } catch (Exception unused) {
                }
                return sb2;
            } catch (Throwable unused2) {
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            }
        } catch (Throwable unused4) {
            bufferedReader = null;
        }
    }

    public static boolean a(Context context) {
        String a2 = a();
        return (a2 == null || !a2.contains(Constants.COLON_SEPARATOR)) && a2 != null && a2.equals(context.getPackageName());
    }

    public static String a(String str) {
        return (TextUtils.isEmpty(str) || !str.contains(Constants.COLON_SEPARATOR)) ? "main" : str.split(Constants.COLON_SEPARATOR)[1];
    }
}
