package com.google.android.gms.common.stats;

import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public abstract class StatsEvent extends AbstractSafeParcelable implements ReflectedParcelable {

    @e.j.a.b.c.m.a
    /* loaded from: classes2.dex */
    public interface a {
        @e.j.a.b.c.m.a
        public static final int a = 7;
        @e.j.a.b.c.m.a
        public static final int b = 8;
    }

    public abstract int getEventType();

    public abstract long getTimeMillis();

    public String toString() {
        long timeMillis = getTimeMillis();
        int eventType = getEventType();
        long zzu = zzu();
        String zzv = zzv();
        StringBuilder sb = new StringBuilder(String.valueOf(zzv).length() + 53);
        sb.append(timeMillis);
        sb.append("\t");
        sb.append(eventType);
        sb.append("\t");
        sb.append(zzu);
        sb.append(zzv);
        return sb.toString();
    }

    public abstract long zzu();

    public abstract String zzv();
}
