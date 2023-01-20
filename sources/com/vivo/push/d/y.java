package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes3.dex */
public final class y implements Runnable {
    public final /* synthetic */ com.vivo.push.b.r a;
    public final /* synthetic */ x b;

    public y(x xVar, com.vivo.push.b.r rVar) {
        this.b = xVar;
        this.a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        x xVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) xVar).b;
        context = xVar.a;
        pushMessageCallback.onPublish(context, this.a.h(), this.a.g());
    }
}
