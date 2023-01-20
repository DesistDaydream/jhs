package com.huawei.hms.hatool;

import java.util.Map;

/* loaded from: classes2.dex */
public class k {
    public boolean a;
    public boolean b;

    /* renamed from: c  reason: collision with root package name */
    public String f3557c;

    /* renamed from: d  reason: collision with root package name */
    public String f3558d;

    /* renamed from: e  reason: collision with root package name */
    public String f3559e;

    /* renamed from: f  reason: collision with root package name */
    public String f3560f;

    /* renamed from: g  reason: collision with root package name */
    public j f3561g;

    /* renamed from: h  reason: collision with root package name */
    public String f3562h;

    /* renamed from: i  reason: collision with root package name */
    public Map<String, String> f3563i;

    /* renamed from: j  reason: collision with root package name */
    public String f3564j;

    /* renamed from: k  reason: collision with root package name */
    public int f3565k;

    /* renamed from: l  reason: collision with root package name */
    public int f3566l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f3567m;
    public boolean n;
    public boolean o;
    public String p;
    public long q;

    public k() {
        this.f3559e = "";
        this.f3560f = "";
        this.f3561g = new j();
        this.f3562h = "";
        this.f3564j = "";
        this.f3565k = 10;
        this.f3566l = 7;
        this.f3567m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
    }

    public k(k kVar) {
        this.f3559e = "";
        this.f3560f = "";
        this.f3561g = new j();
        this.f3562h = "";
        this.f3564j = "";
        this.f3565k = 10;
        this.f3566l = 7;
        this.f3567m = true;
        this.n = true;
        this.o = false;
        this.q = 0L;
        this.f3561g = kVar.f3561g;
        b(kVar.a);
        a(kVar.f3557c);
        b(kVar.f3558d);
        e(kVar.f3559e);
        g(kVar.f3560f);
        d(kVar.f3562h);
        f(kVar.f3564j);
        c(kVar.b);
        a(kVar.f3565k);
        b(kVar.f3566l);
        d(kVar.f3567m);
        a(kVar.n);
        e(kVar.o);
        a(kVar.f3563i);
        c(kVar.p);
        a(kVar.q);
    }

    public void a(int i2) {
        this.f3565k = i2;
    }

    public void a(long j2) {
        this.q = j2;
    }

    public void a(String str) {
        this.f3557c = str;
    }

    public void a(Map<String, String> map) {
        this.f3563i = map;
    }

    public void a(boolean z) {
        this.n = z;
    }

    public boolean a() {
        return this.n;
    }

    public int b() {
        return this.f3565k;
    }

    public void b(int i2) {
        this.f3566l = i2;
    }

    public void b(String str) {
        this.f3558d = str;
    }

    public void b(boolean z) {
        this.a = z;
    }

    public void c(String str) {
        this.p = str;
    }

    public void c(boolean z) {
        this.b = z;
    }

    public boolean c() {
        return this.a;
    }

    public int d() {
        return this.f3566l;
    }

    public void d(String str) {
        this.f3562h = str;
    }

    public void d(boolean z) {
        this.f3567m = z;
    }

    public void e(String str) {
        this.f3559e = str;
    }

    public void e(boolean z) {
        this.o = z;
    }

    public boolean e() {
        return this.b;
    }

    public String f() {
        return this.f3557c;
    }

    public void f(String str) {
        this.f3564j = str;
    }

    public void g(String str) {
        this.f3560f = str;
    }

    public boolean g() {
        return this.f3567m;
    }

    public String h() {
        return this.f3558d;
    }

    public boolean i() {
        return this.o;
    }

    public j j() {
        return this.f3561g;
    }

    public Map<String, String> k() {
        return this.f3563i;
    }

    public long l() {
        return this.q;
    }

    public String m() {
        return this.p;
    }

    public String n() {
        return this.f3562h;
    }

    public String o() {
        return this.f3559e;
    }

    public String p() {
        return this.f3564j;
    }

    public String q() {
        return this.f3560f;
    }
}
