package com.xiaomi.push;

import java.util.Map;

/* loaded from: classes3.dex */
public class fc implements Cloneable {
    public static String a = "wcc-ml-test10.bj";
    public static final String b = i.b;

    /* renamed from: c */
    public static String f8582c;

    /* renamed from: d */
    private String f8583d;

    /* renamed from: e */
    private String f8584e;

    /* renamed from: f */
    private int f8585f;

    /* renamed from: g */
    private boolean f8586g = fb.a;

    /* renamed from: h */
    private boolean f8587h = true;

    /* renamed from: i */
    private String f8588i;

    /* renamed from: j */
    private fg f8589j;

    public fc(Map<String, Integer> map, int i2, String str, fg fgVar) {
        a(map, i2, str, fgVar);
    }

    public static final String a() {
        String str = f8582c;
        return str != null ? str : f.a() ? "sandbox.xmpush.xiaomi.com" : f.b() ? b : "app.chat.xiaomi.net";
    }

    public static final void a(String str) {
        if (jc.a(jl.a()) && f.b()) {
            return;
        }
        f8582c = str;
    }

    private void a(Map<String, Integer> map, int i2, String str, fg fgVar) {
        this.f8585f = i2;
        this.f8583d = str;
        this.f8589j = fgVar;
    }

    public void a(boolean z) {
        this.f8586g = z;
    }

    public String b() {
        return this.f8588i;
    }

    public void b(String str) {
        this.f8588i = str;
    }

    public void c(String str) {
        this.f8584e = str;
    }

    public byte[] c() {
        return null;
    }

    public int d() {
        return this.f8585f;
    }

    public String e() {
        if (this.f8584e == null) {
            this.f8584e = a();
        }
        return this.f8584e;
    }

    public boolean f() {
        return this.f8586g;
    }
}
