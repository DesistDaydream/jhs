package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes3.dex */
public final class w implements Runnable {
    public final /* synthetic */ UPSNotificationMessage a;
    public final /* synthetic */ u b;

    public w(u uVar, UPSNotificationMessage uPSNotificationMessage) {
        this.b = uVar;
        this.a = uPSNotificationMessage;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        u uVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) uVar).b;
        context = uVar.a;
        pushMessageCallback.onNotificationMessageClicked(context, this.a);
    }
}
