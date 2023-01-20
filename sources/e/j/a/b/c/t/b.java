package e.j.a.b.c.t;

import e.j.a.b.c.t.a;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public final class b implements a.InterfaceC0344a {
    @Override // e.j.a.b.c.t.a.InterfaceC0344a
    public final ScheduledExecutorService a() {
        return Executors.newSingleThreadScheduledExecutor();
    }
}
