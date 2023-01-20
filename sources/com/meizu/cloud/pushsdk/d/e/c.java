package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import android.os.Build;
import com.meizu.cloud.pushsdk.d.f.e;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class c {
    private static final String a = "c";
    private final HashMap<String, String> b;

    /* renamed from: c  reason: collision with root package name */
    private final HashMap<String, Object> f4886c;

    /* renamed from: d  reason: collision with root package name */
    private final HashMap<String, String> f4887d;

    /* loaded from: classes2.dex */
    public static class a {
        private Context a = null;

        public a a(Context context) {
            this.a = context;
            return this;
        }

        public c a() {
            return new c(this);
        }
    }

    private c(a aVar) {
        this.b = new HashMap<>();
        this.f4886c = new HashMap<>();
        this.f4887d = new HashMap<>();
        d();
        e();
        f();
        g();
        if (aVar.a != null) {
            a(aVar.a);
        }
        com.meizu.cloud.pushsdk.d.f.c.c(a, "Subject created successfully.", new Object[0]);
    }

    private void a(String str, String str2) {
        if (str == null || str2 == null || str.isEmpty() || str2.isEmpty()) {
            return;
        }
        this.f4887d.put(str, str2);
    }

    private void d() {
        a("ot", "android-" + Build.VERSION.RELEASE);
    }

    private void e() {
        a("ov", Build.DISPLAY);
    }

    private void f() {
        a("dm", Build.MODEL);
    }

    private void g() {
        a("df", Build.MANUFACTURER);
    }

    public Map<String, Object> a() {
        return this.f4886c;
    }

    public void a(Context context) {
        b(context);
    }

    public Map<String, String> b() {
        return this.f4887d;
    }

    public void b(Context context) {
        String b = e.b(context);
        if (b != null) {
            a("ca", b);
        }
    }

    public Map<String, String> c() {
        return this.b;
    }
}
