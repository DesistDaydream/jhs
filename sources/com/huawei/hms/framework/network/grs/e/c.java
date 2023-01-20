package com.huawei.hms.framework.network.grs.e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes2.dex */
public class c {
    private static final String b = "c";

    /* renamed from: c  reason: collision with root package name */
    private static final Map<String, PLSharedPreferences> f3471c = new ConcurrentHashMap(16);
    private final PLSharedPreferences a;

    public c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.d(b, "get pkgname from context is{%s}", packageName);
        Map<String, PLSharedPreferences> map = f3471c;
        if (map.containsKey(str + packageName)) {
            this.a = map.get(str + packageName);
        } else {
            PLSharedPreferences pLSharedPreferences = new PLSharedPreferences(context, str + packageName);
            this.a = pLSharedPreferences;
            map.put(str + packageName, pLSharedPreferences);
        }
        a(context);
    }

    private void a(Context context) {
        String str = b;
        Logger.i(str, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String l2 = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String a = a("version", "");
            if (l2.equals(a)) {
                return;
            }
            Logger.i(str, "app version changed! old version{%s} and new version{%s}", a, l2);
            b();
            b("version", l2);
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.w(b, "get app version failed and catch NameNotFoundException");
        }
    }

    public String a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.a.getString(str, str2);
        }
        return string;
    }

    public Map<String, ?> a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.a.getAll();
        }
        return all;
    }

    public void a(String str) {
        PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.remove(str);
        }
    }

    public void b() {
        PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.clear();
        }
    }

    public void b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.a.putString(str, str2);
        }
    }
}
