package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.android.tpush.data.RegisterEntity;
import com.tencent.android.tpush.service.cache.CacheManager;
import com.tencent.tpns.dataacquisition.CustomDeviceInfos;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class c {
    private static volatile c a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f6373c = new HashMap(10);

    /* renamed from: d  reason: collision with root package name */
    private Map<Long, String> f6374d = new HashMap(10);

    private c(Context context) {
        this.b = null;
        this.b = context.getApplicationContext();
        this.f6374d.put(-1L, "");
    }

    public static c a(Context context) {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c(context);
                }
            }
        }
        return a;
    }

    public String a(long j2) {
        if (this.f6374d.containsKey(Long.valueOf(j2))) {
            return this.f6374d.get(Long.valueOf(j2));
        }
        List<String> registerInfos = CacheManager.getRegisterInfos(this.b);
        if (registerInfos != null) {
            for (String str : registerInfos) {
                RegisterEntity registerInfoByPkgName = CacheManager.getRegisterInfoByPkgName(str);
                if (registerInfoByPkgName != null) {
                    this.f6374d.put(Long.valueOf(registerInfoByPkgName.accessId), a(str));
                }
            }
        }
        return this.f6374d.get(Long.valueOf(j2)) == null ? "" : this.f6374d.get(Long.valueOf(j2));
    }

    public String a(String str) {
        if (str == null) {
            return "";
        }
        if (this.f6373c.containsKey(str)) {
            return this.f6373c.get(str);
        }
        List<PackageInfo> appPackages = CustomDeviceInfos.getAppPackages(this.b);
        if (appPackages != null) {
            for (PackageInfo packageInfo : appPackages) {
                if (str.equals(packageInfo.packageName)) {
                    this.f6373c.put(str, packageInfo.versionName);
                    return packageInfo.versionName;
                }
            }
        }
        return "";
    }
}
