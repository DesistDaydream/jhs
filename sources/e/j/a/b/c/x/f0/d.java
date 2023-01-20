package e.j.a.b.c.x.f0;

import android.os.Process;

/* loaded from: classes2.dex */
public final class d implements Runnable {
    private final Runnable a;
    private final int b;

    public d(Runnable runnable, int i2) {
        this.a = runnable;
        this.b = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(this.b);
        this.a.run();
    }
}
