package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes3.dex */
public final class m implements Runnable {
    public final /* synthetic */ com.vivo.push.b.m a;
    public final /* synthetic */ l b;

    public m(l lVar, com.vivo.push.b.m mVar) {
        this.b = lVar;
        this.a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) lVar).b;
        context = lVar.a;
        pushMessageCallback.onListTags(context, this.a.h(), this.a.d(), this.a.g());
    }
}
