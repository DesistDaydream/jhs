package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes3.dex */
public final class e implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ com.vivo.push.b.i b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f8114c;

    public e(d dVar, String str, com.vivo.push.b.i iVar) {
        this.f8114c = dVar;
        this.a = str;
        this.b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.a)) {
            d dVar = this.f8114c;
            PushMessageCallback pushMessageCallback = ((z) dVar).b;
            context2 = dVar.a;
            pushMessageCallback.onReceiveRegId(context2, this.a);
        }
        d dVar2 = this.f8114c;
        PushMessageCallback pushMessageCallback2 = ((z) dVar2).b;
        context = dVar2.a;
        pushMessageCallback2.onBind(context, this.b.h(), this.b.d());
    }
}
