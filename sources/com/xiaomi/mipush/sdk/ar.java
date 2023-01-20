package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;

/* loaded from: classes3.dex */
public class ar extends ContentObserver {
    public final /* synthetic */ ao a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ar(ao aoVar, Handler handler) {
        super(handler);
        this.a = aoVar;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean z) {
        Context context;
        Integer num;
        Context context2;
        Context context3;
        ao aoVar = this.a;
        context = aoVar.f26a;
        aoVar.f30a = Integer.valueOf(com.xiaomi.push.service.aq.a(context).b());
        num = this.a.f30a;
        if (num.intValue() != 0) {
            context2 = this.a.f26a;
            context2.getContentResolver().unregisterContentObserver(this);
            context3 = this.a.f26a;
            if (com.xiaomi.push.al.c(context3)) {
                this.a.m71c();
            }
        }
    }
}
