package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class d {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f936c;

    /* renamed from: d  reason: collision with root package name */
    public String f937d;

    /* renamed from: e  reason: collision with root package name */
    public String f938e;

    /* renamed from: f  reason: collision with root package name */
    public String f939f;

    /* renamed from: g  reason: collision with root package name */
    public String f940g;

    /* renamed from: h  reason: collision with root package name */
    public String f941h;

    /* renamed from: i  reason: collision with root package name */
    public long f942i;

    /* renamed from: j  reason: collision with root package name */
    public String f943j;

    /* renamed from: k  reason: collision with root package name */
    public String f944k;

    /* renamed from: l  reason: collision with root package name */
    public String f945l;

    /* renamed from: m  reason: collision with root package name */
    public String f946m;
    public int n;
    public String o;
    public String p;
    public int q;
    public long r;
    public String u;
    public int s = -1;
    public int t = -1;
    public Map<String, Object> v = new HashMap();
    private long w = -1;

    public static d b() {
        return new d();
    }

    public long a() {
        return this.w;
    }

    public d a(int i2) {
        this.f946m = String.valueOf(i2);
        return this;
    }

    public d a(long j2) {
        this.r = j2;
        return this;
    }

    public d a(String str) {
        this.f937d = str;
        return this;
    }

    public d a(String str, Object obj) {
        if (!TextUtils.isEmpty(str) && obj != null) {
            this.v.put(str, obj);
        }
        return this;
    }

    public d a(Map<String, Object> map) {
        if (map != null && map.size() > 0) {
            this.v.putAll(map);
        }
        return this;
    }

    public d b(int i2) {
        this.q = i2;
        return this;
    }

    public d b(long j2) {
        this.w = j2;
        return this;
    }

    public d b(String str) {
        this.f936c = str;
        return this;
    }

    public d c(int i2) {
        this.n = i2;
        return this;
    }

    public d c(long j2) {
        this.f942i = j2;
        return this;
    }

    public d c(String str) {
        this.f939f = str;
        return this;
    }

    public d d(int i2) {
        this.o = String.valueOf(i2);
        return this;
    }

    public d d(String str) {
        this.f944k = str;
        return this;
    }

    public d e(int i2) {
        this.s = i2;
        return this;
    }

    public d e(String str) {
        this.a = str;
        return this;
    }

    public d f(int i2) {
        this.p = String.valueOf(i2);
        return this;
    }

    public d f(String str) {
        this.u = str;
        return this;
    }

    public d g(int i2) {
        this.t = i2;
        return this;
    }

    public d g(String str) {
        this.b = str;
        return this;
    }

    public d h(String str) {
        this.f938e = str;
        return this;
    }

    public d i(String str) {
        this.f941h = str;
        return this;
    }

    public d j(String str) {
        this.f940g = str;
        return this;
    }

    public d k(String str) {
        this.f943j = str;
        return this;
    }
}
