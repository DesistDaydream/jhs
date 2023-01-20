package e.j.a.b.c.x.f0;

import e.j.a.b.c.r.a0;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class c implements ThreadFactory {
    private final String a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final AtomicInteger f10466c;

    /* renamed from: d  reason: collision with root package name */
    private final ThreadFactory f10467d;

    @e.j.a.b.c.m.a
    public c(String str) {
        this(str, 0);
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        Thread newThread = this.f10467d.newThread(new d(runnable, 0));
        String str = this.a;
        int andIncrement = this.f10466c.getAndIncrement();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13);
        sb.append(str);
        sb.append("[");
        sb.append(andIncrement);
        sb.append("]");
        newThread.setName(sb.toString());
        return newThread;
    }

    private c(String str, int i2) {
        this.f10466c = new AtomicInteger();
        this.f10467d = Executors.defaultThreadFactory();
        this.a = (String) a0.l(str, "Name must not be null");
        this.b = 0;
    }
}
