package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes3.dex */
public final class o implements Runnable {
    public final /* synthetic */ com.vivo.push.b.n a;
    public final /* synthetic */ n b;

    public o(n nVar, com.vivo.push.b.n nVar2) {
        this.b = nVar;
        this.a = nVar2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        n nVar = this.b;
        PushMessageCallback pushMessageCallback = ((z) nVar).b;
        context = nVar.a;
        pushMessageCallback.onLog(context, this.a.d(), this.a.e(), this.a.f());
    }
}
