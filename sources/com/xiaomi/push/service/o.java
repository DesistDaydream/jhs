package com.xiaomi.push.service;

import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public final class o extends m.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ z b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f9186c;

    public o(String str, z zVar, int i2) {
        this.a = str;
        this.b = zVar;
        this.f9186c = i2;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return this.a;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a(this.f9186c);
    }
}
