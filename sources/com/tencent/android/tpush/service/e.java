package com.tencent.android.tpush.service;

import android.os.PowerManager;

/* loaded from: classes3.dex */
public class e {
    private static e a;
    private PowerManager.WakeLock b = null;

    private e() {
    }

    public static e a() {
        if (a == null) {
            a = new e();
        }
        return a;
    }

    public PowerManager.WakeLock b() {
        return this.b;
    }
}
