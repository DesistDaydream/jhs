package e.j.a.b.c.n;

import e.j.a.b.c.r.d0;
import java.util.Map;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

@d0
/* loaded from: classes2.dex */
public abstract class x {
    @GuardedBy("sLock")
    private static final Map<Object, x> a = new WeakHashMap();
    private static final Object b = new Object();

    public abstract void a(int i2);
}
