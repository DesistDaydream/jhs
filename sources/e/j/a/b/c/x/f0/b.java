package e.j.a.b.c.x.f0;

import e.j.a.b.c.r.a0;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class b implements ThreadFactory {
    private final String a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final ThreadFactory f10465c;

    @e.j.a.b.c.m.a
    public b(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f10465c.newThread(new d(runnable, 0));
        newThread.setName(this.a);
        return newThread;
    }

    private b(String str, int i2) {
        this.f10465c = Executors.defaultThreadFactory();
        this.a = (String) a0.l(str, "Name must not be null");
        this.b = 0;
    }
}
