package com.vivo.push;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.util.z;

/* loaded from: classes3.dex */
public final class f implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ e b;

    public f(e eVar, String str) {
        this.b = eVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        Context context3;
        context = this.b.f8128h;
        if (context == null || TextUtils.isEmpty(this.a)) {
            return;
        }
        context2 = this.b.f8128h;
        context3 = this.b.f8128h;
        if (z.b(context2, context3.getPackageName(), this.a)) {
            this.b.i();
        }
    }
}
