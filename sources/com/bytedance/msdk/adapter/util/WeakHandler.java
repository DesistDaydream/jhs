package com.bytedance.msdk.adapter.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class WeakHandler extends Handler {
    private final WeakReference<IHandler> a;

    /* loaded from: classes.dex */
    public interface IHandler {
        void handleMsg(Message message);
    }

    public WeakHandler(Looper looper, IHandler iHandler) {
        super(looper);
        this.a = new WeakReference<>(iHandler);
    }

    public WeakHandler(IHandler iHandler) {
        this.a = new WeakReference<>(iHandler);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        IHandler iHandler = this.a.get();
        if (iHandler == null || message == null) {
            return;
        }
        iHandler.handleMsg(message);
    }
}
