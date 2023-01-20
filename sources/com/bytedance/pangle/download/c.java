package com.bytedance.pangle.download;

import android.os.Handler;
import android.os.Looper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class c {

    /* renamed from: e  reason: collision with root package name */
    private static volatile c f2240e;
    public final Map<String, Long> a = new ConcurrentHashMap();
    public final Handler b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Runnable> f2241c = new ConcurrentHashMap();

    /* renamed from: d  reason: collision with root package name */
    public final Map<String, Runnable> f2242d = new ConcurrentHashMap();

    private c() {
    }

    public static c a() {
        if (f2240e == null) {
            synchronized (c.class) {
                if (f2240e == null) {
                    f2240e = new c();
                }
            }
        }
        return f2240e;
    }
}
