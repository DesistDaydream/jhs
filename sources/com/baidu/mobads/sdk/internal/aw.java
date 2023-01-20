package com.baidu.mobads.sdk.internal;

import android.util.Log;
import java.lang.Thread;

/* loaded from: classes.dex */
public class aw implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ av a;

    public aw(av avVar) {
        this.a = avVar;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Log.i("ThreadPoolFactory", "线程名字=" + thread.getName() + "线程crash信息", th);
    }
}
