package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class ji implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9021c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ jh f9022d;

    public ji(jh jhVar, String str, String str2, String str3) {
        this.f9022d = jhVar;
        this.a = str;
        this.b = str2;
        this.f9021c = str3;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f9022d.b;
        SharedPreferences.Editor edit = context.getSharedPreferences(this.a, 4).edit();
        edit.putString(this.b, this.f9021c);
        edit.commit();
    }
}
