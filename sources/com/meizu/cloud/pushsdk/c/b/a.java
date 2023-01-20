package com.meizu.cloud.pushsdk.c.b;

import com.meizu.cloud.pushsdk.c.c.k;

/* loaded from: classes2.dex */
public class a extends Exception {
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private String f4727c;

    /* renamed from: d  reason: collision with root package name */
    private k f4728d;

    public a() {
        this.b = 0;
    }

    public a(k kVar) {
        this.b = 0;
        this.f4728d = kVar;
    }

    public a(Throwable th) {
        super(th);
        this.b = 0;
    }

    public k a() {
        return this.f4728d;
    }

    public void a(int i2) {
        this.b = i2;
    }

    public void a(String str) {
        this.f4727c = str;
    }

    public int b() {
        return this.b;
    }

    public void b(String str) {
        this.a = str;
    }

    public String c() {
        return this.a;
    }
}
