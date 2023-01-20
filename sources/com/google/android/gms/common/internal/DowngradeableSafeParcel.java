package com.google.android.gms.common.internal;

import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import e.j.a.b.c.m.a;

@a
/* loaded from: classes2.dex */
public abstract class DowngradeableSafeParcel extends AbstractSafeParcelable implements ReflectedParcelable {
    private static final Object zzdc = new Object();
    private static ClassLoader zzdd;
    private static Integer zzde;
    private boolean zzdf = false;

    @a
    public static boolean canUnparcelSafely(String str) {
        zzp();
        return true;
    }

    @a
    public static Integer getUnparcelClientVersion() {
        synchronized (zzdc) {
        }
        return null;
    }

    private static ClassLoader zzp() {
        synchronized (zzdc) {
        }
        return null;
    }

    @a
    public abstract boolean prepareForClientVersion(int i2);

    @a
    public void setShouldDowngrade(boolean z) {
        this.zzdf = z;
    }

    @a
    public boolean shouldDowngrade() {
        return this.zzdf;
    }
}
