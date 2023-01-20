package e.j.c.a.a;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public interface a<V> extends Future<V> {
    void addListener(Runnable runnable, Executor executor);
}
