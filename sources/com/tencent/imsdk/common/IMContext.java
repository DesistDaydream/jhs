package com.tencent.imsdk.common;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class IMContext {
    private static final String TAG = "IMContext";
    private Context mContext;
    private Handler mMainHandler;

    /* loaded from: classes3.dex */
    public static class Holder {
        public static IMContext instance = new IMContext();

        private Holder() {
        }
    }

    public static IMContext getInstance() {
        return Holder.instance;
    }

    public Context getApplicationContext() {
        return this.mContext;
    }

    public void init(Context context) {
        this.mContext = context;
    }

    public void runOnMainThread(Runnable runnable) {
        this.mMainHandler.post(runnable);
    }

    private IMContext() {
        this.mMainHandler = new Handler(Looper.getMainLooper());
    }
}
