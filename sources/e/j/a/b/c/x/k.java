package e.j.a.b.c.x;

import android.os.SystemClock;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class k implements g {
    private static final k a = new k();

    private k() {
    }

    @e.j.a.b.c.m.a
    public static g d() {
        return a;
    }

    @Override // e.j.a.b.c.x.g
    public long a() {
        return System.currentTimeMillis();
    }

    @Override // e.j.a.b.c.x.g
    public long b() {
        return SystemClock.currentThreadTimeMillis();
    }

    @Override // e.j.a.b.c.x.g
    public long c() {
        return SystemClock.elapsedRealtime();
    }

    @Override // e.j.a.b.c.x.g
    public long nanoTime() {
        return System.nanoTime();
    }
}
