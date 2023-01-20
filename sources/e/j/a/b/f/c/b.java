package e.j.a.b.f.c;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

/* loaded from: classes2.dex */
public interface b {
    ExecutorService a(ThreadFactory threadFactory, int i2);

    ScheduledExecutorService b(int i2, ThreadFactory threadFactory, int i3);
}
