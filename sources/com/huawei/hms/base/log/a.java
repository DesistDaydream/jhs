package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* loaded from: classes2.dex */
public class a {
    public String b;
    public int a = 4;

    /* renamed from: c  reason: collision with root package name */
    public b f3436c = new e();

    public void a(Context context, int i2, String str) {
        this.a = i2;
        this.b = str;
        this.f3436c.a(context, "HMSCore");
    }

    public void b(int i2, String str, String str2, Throwable th) {
        if (a(i2)) {
            c a = a(i2, str, str2, th);
            b bVar = this.f3436c;
            bVar.a(a.c() + a.a(), i2, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }

    public b a() {
        return this.f3436c;
    }

    public void a(b bVar) {
        this.f3436c = bVar;
    }

    public boolean a(int i2) {
        return i2 >= this.a;
    }

    public void a(int i2, String str, String str2) {
        if (a(i2)) {
            c a = a(i2, str, str2, null);
            this.f3436c.a(a.c() + a.a(), i2, str, str2);
        }
    }

    public void a(String str, String str2) {
        c a = a(4, str, str2, null);
        this.f3436c.a(a.c() + '\n' + a.a(), 4, str, str2);
    }

    public final c a(int i2, String str, String str2, Throwable th) {
        c cVar = new c(8, this.b, i2, str);
        cVar.a((c) str2);
        cVar.a(th);
        return cVar;
    }
}
