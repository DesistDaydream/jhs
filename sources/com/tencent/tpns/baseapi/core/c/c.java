package com.tencent.tpns.baseapi.core.c;

import android.os.PowerManager;

/* loaded from: classes3.dex */
public class c {
    private static c a;
    private PowerManager.WakeLock b = null;

    private c() {
    }

    public static c a() {
        if (a == null) {
            a = new c();
        }
        return a;
    }

    public PowerManager.WakeLock b() {
        return this.b;
    }

    public void a(PowerManager.WakeLock wakeLock) {
        this.b = wakeLock;
    }
}
