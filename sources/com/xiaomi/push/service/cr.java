package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class cr {
    private static cr a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f9172c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f9173d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f9174e = new ArrayList();

    private cr(Context context) {
        String[] split;
        String[] split2;
        String[] split3;
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        if (applicationContext == null) {
            this.b = context;
        }
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_app_info", 0);
        for (String str : sharedPreferences.getString("unregistered_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (TextUtils.isEmpty(str)) {
                this.f9172c.add(str);
            }
        }
        for (String str2 : sharedPreferences.getString("disable_push_pkg_names", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str2)) {
                this.f9173d.add(str2);
            }
        }
        for (String str3 : sharedPreferences.getString("disable_push_pkg_names_cache", "").split(Constants.ACCEPT_TIME_SEPARATOR_SP)) {
            if (!TextUtils.isEmpty(str3)) {
                this.f9174e.add(str3);
            }
        }
    }

    public static cr a(Context context) {
        if (a == null) {
            a = new cr(context);
        }
        return a;
    }

    public boolean a(String str) {
        boolean contains;
        synchronized (this.f9172c) {
            contains = this.f9172c.contains(str);
        }
        return contains;
    }

    public boolean b(String str) {
        boolean contains;
        synchronized (this.f9173d) {
            contains = this.f9173d.contains(str);
        }
        return contains;
    }

    public boolean c(String str) {
        boolean contains;
        synchronized (this.f9174e) {
            contains = this.f9174e.contains(str);
        }
        return contains;
    }

    public void d(String str) {
        synchronized (this.f9172c) {
            if (!this.f9172c.contains(str)) {
                this.f9172c.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.ar.a(this.f9172c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void e(String str) {
        synchronized (this.f9173d) {
            if (!this.f9173d.contains(str)) {
                this.f9173d.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ar.a(this.f9173d, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void f(String str) {
        synchronized (this.f9174e) {
            if (!this.f9174e.contains(str)) {
                this.f9174e.add(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ar.a(this.f9174e, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void g(String str) {
        synchronized (this.f9172c) {
            if (this.f9172c.contains(str)) {
                this.f9172c.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("unregistered_pkg_names", com.xiaomi.push.ar.a(this.f9172c, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void h(String str) {
        synchronized (this.f9173d) {
            if (this.f9173d.contains(str)) {
                this.f9173d.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names", com.xiaomi.push.ar.a(this.f9173d, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }

    public void i(String str) {
        synchronized (this.f9174e) {
            if (this.f9174e.contains(str)) {
                this.f9174e.remove(str);
                this.b.getSharedPreferences("mipush_app_info", 0).edit().putString("disable_push_pkg_names_cache", com.xiaomi.push.ar.a(this.f9174e, Constants.ACCEPT_TIME_SEPARATOR_SP)).commit();
            }
        }
    }
}
