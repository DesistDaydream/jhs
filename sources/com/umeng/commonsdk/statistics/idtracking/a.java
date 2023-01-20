package com.umeng.commonsdk.statistics.idtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes3.dex */
public abstract class a {
    private final int a = 10;
    private final int b = 100;

    /* renamed from: c  reason: collision with root package name */
    private final String f7493c;

    /* renamed from: d  reason: collision with root package name */
    private List<com.umeng.commonsdk.statistics.proto.a> f7494d;

    /* renamed from: e  reason: collision with root package name */
    private com.umeng.commonsdk.statistics.proto.b f7495e;

    public a(String str) {
        this.f7493c = str;
    }

    private boolean g() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f7495e;
        String b = bVar == null ? null : bVar.b();
        int h2 = bVar == null ? 0 : bVar.h();
        String a = a(f());
        if (a == null || a.equals(b)) {
            return false;
        }
        if (bVar == null) {
            bVar = new com.umeng.commonsdk.statistics.proto.b();
        }
        bVar.a(a);
        bVar.a(System.currentTimeMillis());
        bVar.a(h2 + 1);
        com.umeng.commonsdk.statistics.proto.a aVar = new com.umeng.commonsdk.statistics.proto.a();
        aVar.a(this.f7493c);
        aVar.c(a);
        aVar.b(b);
        aVar.a(bVar.e());
        if (this.f7494d == null) {
            this.f7494d = new ArrayList(2);
        }
        this.f7494d.add(aVar);
        if (this.f7494d.size() > 10) {
            this.f7494d.remove(0);
        }
        this.f7495e = bVar;
        return true;
    }

    public boolean a() {
        return g();
    }

    public String b() {
        return this.f7493c;
    }

    public boolean c() {
        com.umeng.commonsdk.statistics.proto.b bVar = this.f7495e;
        return bVar == null || bVar.h() <= 100;
    }

    public com.umeng.commonsdk.statistics.proto.b d() {
        return this.f7495e;
    }

    public List<com.umeng.commonsdk.statistics.proto.a> e() {
        return this.f7494d;
    }

    public abstract String f();

    public void a(com.umeng.commonsdk.statistics.proto.b bVar) {
        this.f7495e = bVar;
    }

    public void a(List<com.umeng.commonsdk.statistics.proto.a> list) {
        this.f7494d = list;
    }

    public String a(String str) {
        if (str == null) {
            return null;
        }
        String trim = str.trim();
        if (trim.length() == 0 || "0".equals(trim) || "unknown".equals(trim.toLowerCase(Locale.US))) {
            return null;
        }
        return trim;
    }

    public void a(com.umeng.commonsdk.statistics.proto.c cVar) {
        this.f7495e = cVar.c().get(this.f7493c);
        List<com.umeng.commonsdk.statistics.proto.a> h2 = cVar.h();
        if (h2 == null || h2.size() <= 0) {
            return;
        }
        if (this.f7494d == null) {
            this.f7494d = new ArrayList();
        }
        for (com.umeng.commonsdk.statistics.proto.a aVar : h2) {
            if (this.f7493c.equals(aVar.a)) {
                this.f7494d.add(aVar);
            }
        }
    }
}
