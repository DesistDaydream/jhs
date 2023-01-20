package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.push.p;

/* loaded from: classes3.dex */
public class q extends Handler {
    public final /* synthetic */ p a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, Looper looper) {
        super(looper);
        this.a = pVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        p.b bVar = (p.b) message.obj;
        int i2 = message.what;
        if (i2 == 0) {
            bVar.a();
        } else if (i2 == 1) {
            bVar.c();
        }
        super.handleMessage(message);
    }
}
