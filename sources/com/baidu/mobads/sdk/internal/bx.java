package com.baidu.mobads.sdk.internal;

import android.content.SharedPreferences;
import android.os.Handler;
import com.baidu.mobads.sdk.internal.bp;

/* loaded from: classes.dex */
public class bx extends h {
    public final /* synthetic */ bp.c b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Handler f1537c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ bp f1538d;

    public bx(bp bpVar, bp.c cVar, Handler handler) {
        this.f1538d = bpVar;
        this.b = cVar;
        this.f1537c = handler;
    }

    @Override // com.baidu.mobads.sdk.internal.h
    public Object i() {
        bj bjVar;
        SharedPreferences m2;
        try {
            synchronized (bp.class) {
                this.f1538d.b(this.b, this.f1537c);
            }
            m2 = this.f1538d.m();
            SharedPreferences.Editor edit = m2.edit();
            edit.putString(bp.f1525d, this.f1538d.a());
            edit.apply();
            return null;
        } catch (Throwable th) {
            bjVar = this.f1538d.z;
            bjVar.a(bp.a, th);
            return null;
        }
    }
}
