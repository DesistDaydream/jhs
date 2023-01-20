package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes3.dex */
public final class q implements Runnable {
    public final /* synthetic */ UnvarnishedMessage a;
    public final /* synthetic */ p b;

    public q(p pVar, UnvarnishedMessage unvarnishedMessage) {
        this.b = pVar;
        this.a = unvarnishedMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        p pVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) pVar).b;
        context = pVar.a;
        pushMessageCallback.onTransmissionMessage(context, this.a);
    }
}
