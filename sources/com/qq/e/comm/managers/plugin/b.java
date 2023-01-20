package com.qq.e.comm.managers.plugin;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.text.TextUtils;
import java.io.Closeable;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class b {
    private static volatile String a;

    public static synchronized String a(Context context) {
        ActivityManager.RunningAppProcessInfo next;
        synchronized (b.class) {
            if (!TextUtils.isEmpty(a)) {
                return a;
            } else if (Build.VERSION.SDK_INT >= 28) {
                a = Application.getProcessName();
                return a;
            } else {
                int myPid = Process.myPid();
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
                if (runningAppProcesses != null) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                    while (it.hasNext()) {
                        try {
                            next = it.next();
                        } catch (Exception unused) {
                        }
                        if (next.pid == myPid) {
                            a = next.processName;
                            return a;
                        }
                        continue;
                    }
                }
                return null;
            }
        }
    }

    public static synchronized String a(String str) {
        synchronized (b.class) {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String str2 = a;
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            boolean endsWith = str2.endsWith("_");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(endsWith ? "" : "_");
            String str3 = null;
            try {
                String str4 = new String(str2);
                try {
                    str3 = d.a(MessageDigest.getInstance("MD5").digest(str4.getBytes("UTF-8")));
                } catch (Exception unused) {
                    str3 = str4;
                }
            } catch (Exception unused2) {
            }
            sb.append(str3);
            return sb.toString();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void b(android.content.Context r11, java.io.File r12, java.io.File r13) throws java.lang.Throwable {
        /*
            java.lang.String r0 = "gdtadv2.jar"
            java.lang.String r1 = "gdt_plugin"
            android.content.res.AssetManager r11 = r11.getAssets()
            r2 = 0
            com.qq.e.comm.managers.plugin.h.b()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String[] r3 = r11.list(r1)     // Catch: java.lang.Throwable -> Lbf
            int r3 = java.util.Arrays.binarySearch(r3, r0)     // Catch: java.lang.Throwable -> Lbf
            r4 = 0
            if (r3 < 0) goto Lac
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r3.<init>()     // Catch: java.lang.Throwable -> Lbf
            r3.append(r1)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = java.io.File.separator     // Catch: java.lang.Throwable -> Lbf
            r3.append(r1)     // Catch: java.lang.Throwable -> Lbf
            r3.append(r0)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r0 = r3.toString()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = com.qq.e.comm.constants.Sig.ASSET_PLUGIN_SIG     // Catch: java.lang.Throwable -> Lbf
            if (r1 != 0) goto L31
            java.lang.String r1 = ""
        L31:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r3.<init>()     // Catch: java.lang.Throwable -> Lbf
            int r5 = com.qq.e.comm.managers.status.SDKStatus.getBuildInPluginVersion()     // Catch: java.lang.Throwable -> Lbf
            r3.append(r5)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r5 = "#####"
            r3.append(r5)     // Catch: java.lang.Throwable -> Lbf
            r3.append(r1)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> Lbf
            com.qq.e.comm.managers.plugin.h.c(r1, r13)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r13 = com.qq.e.comm.constants.CustomPkgConstants.getAssetPluginXorKey()     // Catch: java.lang.Throwable -> Lbf
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch: java.lang.Throwable -> Lbf
            if (r13 == 0) goto L5f
            java.io.InputStream r11 = r11.open(r0)     // Catch: java.lang.Throwable -> Lbf
            boolean r4 = com.qq.e.comm.managers.plugin.h.a(r11, r12)     // Catch: java.lang.Throwable -> Lbf
            goto Lac
        L5f:
            java.io.InputStream r11 = r11.open(r0)     // Catch: java.lang.Throwable -> Lbf
            java.io.FileOutputStream r13 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> La7
            r13.<init>(r12)     // Catch: java.lang.Throwable -> La7
            java.lang.String r12 = com.qq.e.comm.constants.CustomPkgConstants.getAssetPluginXorKey()     // Catch: java.lang.Throwable -> La4
            java.lang.String r0 = "UTF-8"
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch: java.lang.Throwable -> La4
            byte[] r12 = r12.getBytes(r0)     // Catch: java.lang.Throwable -> La4
            r0 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> La4
            int r1 = r12.length     // Catch: java.lang.Throwable -> La4
            r2 = 64
            r3 = 0
            r5 = 0
        L7f:
            int r6 = r11.read(r0)     // Catch: java.lang.Throwable -> La4
            if (r6 <= 0) goto La1
            r7 = 0
        L86:
            if (r7 >= r6) goto L9d
            int r8 = r5 + 1
            if (r5 >= r2) goto L8d
            goto L99
        L8d:
            r5 = r0[r7]     // Catch: java.lang.Throwable -> La4
            int r9 = r3 + 1
            int r3 = r3 % r1
            r3 = r12[r3]     // Catch: java.lang.Throwable -> La4
            r3 = r3 ^ r5
            byte r3 = (byte) r3     // Catch: java.lang.Throwable -> La4
            r0[r7] = r3     // Catch: java.lang.Throwable -> La4
            r3 = r9
        L99:
            int r7 = r7 + 1
            r5 = r8
            goto L86
        L9d:
            r13.write(r0, r4, r6)     // Catch: java.lang.Throwable -> La4
            goto L7f
        La1:
            r12 = 1
            r2 = r13
            goto Lae
        La4:
            r12 = move-exception
            r2 = r13
            goto Lc4
        La7:
            r12 = move-exception
            r10 = r12
            r12 = r11
            r11 = r10
            goto Lc1
        Lac:
            r11 = r2
            r12 = r4
        Lae:
            c(r11)
            c(r2)
            if (r12 == 0) goto Lb7
            return
        Lb7:
            java.lang.Exception r11 = new java.lang.Exception
            java.lang.String r12 = "Plugin prepare failed"
            r11.<init>(r12)
            throw r11
        Lbf:
            r11 = move-exception
            r12 = r2
        Lc1:
            r10 = r12
            r12 = r11
            r11 = r10
        Lc4:
            java.lang.String r13 = "插件加载失败"
            com.qq.e.comm.util.GDTLogger.e(r13, r12)     // Catch: java.lang.Throwable -> Lcb
            throw r12     // Catch: java.lang.Throwable -> Lcb
        Lcb:
            r12 = move-exception
            c(r11)
            c(r2)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.managers.plugin.b.b(android.content.Context, java.io.File, java.io.File):void");
    }

    private static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }
}
