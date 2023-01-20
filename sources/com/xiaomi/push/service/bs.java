package com.xiaomi.push.service;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/* loaded from: classes3.dex */
public class bs extends Handler {
    public final /* synthetic */ XMPushService a;

    public bs(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        String str;
        super.handleMessage(message);
        if (message != null) {
            try {
                int i2 = message.what;
                if (i2 == 17) {
                    Object obj = message.obj;
                    if (obj != null) {
                        this.a.onStart((Intent) obj, 1);
                    }
                } else if (i2 == 18) {
                    Message obtain = Message.obtain((Handler) null, 0);
                    obtain.what = 18;
                    Bundle bundle = new Bundle();
                    str = this.a.f9041f;
                    bundle.putString("xmsf_region", str);
                    obtain.setData(bundle);
                    message.replyTo.send(obtain);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
