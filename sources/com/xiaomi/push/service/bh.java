package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Context;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public final class bh extends m.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f9129c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f9130d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Notification f9131e;

    public bh(int i2, String str, Context context, String str2, Notification notification) {
        this.a = i2;
        this.b = str;
        this.f9129c = context;
        this.f9130d = str2;
        this.f9131e = notification;
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        String b;
        b = bg.b(this.a, this.b);
        return b;
    }

    @Override // java.lang.Runnable
    @TargetApi(19)
    public void run() {
        bg.c(this.f9129c, this.f9130d, this.a, this.b, this.f9131e);
    }
}
