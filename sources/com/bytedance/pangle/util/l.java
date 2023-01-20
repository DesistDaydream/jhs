package com.bytedance.pangle.util;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public class l {
    public static final /* synthetic */ boolean a = true;
    private static final Object b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private static Handler f2351c;

    private static Handler a() {
        Handler handler;
        synchronized (b) {
            if (f2351c == null) {
                f2351c = new Handler(Looper.getMainLooper());
            }
            handler = f2351c;
        }
        return handler;
    }

    public static void a(Runnable runnable) {
        if (a().getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            a().post(runnable);
        }
    }
}
