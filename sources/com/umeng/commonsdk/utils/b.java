package com.umeng.commonsdk.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.umeng.commonsdk.debug.UMRTLog;
import java.util.HashMap;

/* loaded from: classes3.dex */
public class b {
    private static HashMap<String, PackageInfo> a = new HashMap<>();
    private static Object b = new Object();

    /* loaded from: classes3.dex */
    public static class a {
        private static final b a = new b();

        private a() {
        }
    }

    public static b a() {
        return a.a;
    }

    private b() {
    }

    public PackageInfo a(Context context, String str, int i2) {
        PackageInfo packageInfo;
        synchronized (b) {
            packageInfo = null;
            if (a.containsKey(str)) {
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", pkgInfo缓存命中，直接返回");
                packageInfo = a.get(str);
            } else {
                try {
                    PackageInfo packageInfo2 = context.getPackageManager().getPackageInfo(str, i2);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg： " + str + ", 获取pkgInfo并缓存");
                    a.put(str, packageInfo2);
                    packageInfo = packageInfo2;
                } catch (PackageManager.NameNotFoundException unused) {
                    a.put(str, null);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> pkg: " + str + "，目标包未安装。");
                }
            }
        }
        return packageInfo;
    }
}
