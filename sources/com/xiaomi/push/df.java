package com.xiaomi.push;

import android.content.Context;

/* loaded from: classes3.dex */
public final class df implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f8441c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f8442d;

    public df(Context context, String str, int i2, String str2) {
        this.a = context;
        this.b = str;
        this.f8441c = i2;
        this.f8442d = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        dd.c(this.a, this.b, this.f8441c, this.f8442d);
    }
}
