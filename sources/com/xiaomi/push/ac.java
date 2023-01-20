package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes3.dex */
public class ac implements v {
    private static volatile ac a;
    private v b;

    /* renamed from: c  reason: collision with root package name */
    private int f8246c = aa.a;

    private ac(Context context) {
        this.b = aa.a(context);
        com.xiaomi.a.a.a.c.a("create id manager is: " + this.f8246c);
    }

    public static ac a(Context context) {
        if (a == null) {
            synchronized (ac.class) {
                if (a == null) {
                    a = new ac(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            map.put("udid", d2);
        }
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            map.put("oaid", b);
        }
        String e2 = e();
        if (!TextUtils.isEmpty(e2)) {
            map.put("vaid", e2);
        }
        String f2 = f();
        if (!TextUtils.isEmpty(f2)) {
            map.put("aaid", f2);
        }
        map.put("oaid_type", String.valueOf(this.f8246c));
    }

    @Override // com.xiaomi.push.v
    public boolean a() {
        return this.b.a();
    }

    @Override // com.xiaomi.push.v
    public String b() {
        return a(this.b.b());
    }

    public void c() {
    }

    public String d() {
        return null;
    }

    public String e() {
        return null;
    }

    public String f() {
        return null;
    }
}
