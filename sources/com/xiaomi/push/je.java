package com.xiaomi.push;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes3.dex */
public class je {
    private static volatile Handler a;
    private static volatile Handler b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f9014c = new Object();

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return a(context, broadcastReceiver, intentFilter, null);
    }

    public static Intent a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str) {
        if (context == null || broadcastReceiver == null || intentFilter == null) {
            return null;
        }
        return context.registerReceiver(broadcastReceiver, intentFilter, str, b());
    }

    public static Handler a() {
        if (b == null) {
            synchronized (f9014c) {
                if (b == null) {
                    HandlerThread handlerThread = new HandlerThread("receiver_task");
                    handlerThread.start();
                    b = new Handler(handlerThread.getLooper());
                }
            }
        }
        return b;
    }

    private static void a(Context context, ComponentName componentName) {
        b().post(new jf(context, componentName));
    }

    public static void a(Context context, Class<?> cls) {
        if (context == null || cls == null) {
            return;
        }
        a(context, new ComponentName(context, cls));
    }

    private static Handler b() {
        if (a == null) {
            synchronized (je.class) {
                if (a == null) {
                    HandlerThread handlerThread = new HandlerThread("handle_receiver");
                    handlerThread.start();
                    a = new Handler(handlerThread.getLooper());
                }
            }
        }
        return a;
    }
}
