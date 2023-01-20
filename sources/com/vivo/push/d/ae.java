package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes3.dex */
public final class ae implements Runnable {
    public final /* synthetic */ com.vivo.push.b.i a;
    public final /* synthetic */ ad b;

    public ae(ad adVar, com.vivo.push.b.i iVar) {
        this.b = adVar;
        this.a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ad adVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) adVar).b;
        context = adVar.a;
        pushMessageCallback.onUnBind(context, this.a.h(), this.a.d());
    }
}
