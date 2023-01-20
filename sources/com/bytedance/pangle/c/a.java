package com.bytedance.pangle.c;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.util.MethodUtils;

/* loaded from: classes.dex */
public class a {
    private static Class a;
    private static Object b;

    public static final Object a() {
        if (b == null) {
            try {
                synchronized (a.class) {
                    if (b == null) {
                        if (a == null) {
                            a = Class.forName("android.app.ActivityThread");
                        }
                        b = MethodUtils.invokeStaticMethod(a, "currentActivityThread", new Object[0]);
                    }
                    if (b == null && Looper.myLooper() != Looper.getMainLooper()) {
                        final Object obj = new Object();
                        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.bytedance.pangle.c.a.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                try {
                                    try {
                                        Object unused = a.b = MethodUtils.invokeStaticMethod(a.a, "currentActivityThread", new Object[0]);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    } catch (Exception e2) {
                                        ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper main looper invoke currentActivityThread failed.", e2);
                                        synchronized (obj) {
                                            obj.notify();
                                        }
                                    }
                                } catch (Throwable th) {
                                    synchronized (obj) {
                                        obj.notify();
                                        throw th;
                                    }
                                }
                            }
                        });
                        if (b == null) {
                            synchronized (obj) {
                                try {
                                    obj.wait(5000L);
                                } catch (InterruptedException e2) {
                                    ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread interruptedException failed.", e2);
                                }
                            }
                        }
                    }
                }
            } catch (Exception e3) {
                ZeusLogger.errReport(ZeusLogger.TAG, "ActivityThreadHelper currentActivityThread failed.", e3);
            }
        }
        return b;
    }
}
