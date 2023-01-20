package e.j.d.d;

import androidx.annotation.GuardedBy;
import e.j.a.b.c.r.a0;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public class q implements e.j.d.e.d, e.j.d.e.c {
    @GuardedBy("this")
    private final Map<Class<?>, ConcurrentHashMap<e.j.d.e.b<Object>, Executor>> a = new HashMap();
    @GuardedBy("this")
    private Queue<e.j.d.e.a<?>> b = new ArrayDeque();

    /* renamed from: c  reason: collision with root package name */
    private final Executor f11221c;

    public q(Executor executor) {
        this.f11221c = executor;
    }

    private synchronized Set<Map.Entry<e.j.d.e.b<Object>, Executor>> f(e.j.d.e.a<?> aVar) {
        ConcurrentHashMap<e.j.d.e.b<Object>, Executor> concurrentHashMap;
        concurrentHashMap = this.a.get(aVar.getType());
        return concurrentHashMap == null ? Collections.emptySet() : concurrentHashMap.entrySet();
    }

    @Override // e.j.d.e.d
    public <T> void a(Class<T> cls, e.j.d.e.b<? super T> bVar) {
        b(cls, this.f11221c, bVar);
    }

    @Override // e.j.d.e.d
    public synchronized <T> void b(Class<T> cls, Executor executor, e.j.d.e.b<? super T> bVar) {
        a0.k(cls);
        a0.k(bVar);
        a0.k(executor);
        if (!this.a.containsKey(cls)) {
            this.a.put(cls, new ConcurrentHashMap<>());
        }
        this.a.get(cls).put(bVar, executor);
    }

    @Override // e.j.d.e.c
    public void c(e.j.d.e.a<?> aVar) {
        a0.k(aVar);
        synchronized (this) {
            Queue<e.j.d.e.a<?>> queue = this.b;
            if (queue != null) {
                queue.add(aVar);
                return;
            }
            for (Map.Entry<e.j.d.e.b<Object>, Executor> entry : f(aVar)) {
                entry.getValue().execute(p.a(entry, aVar));
            }
        }
    }

    @Override // e.j.d.e.d
    public synchronized <T> void d(Class<T> cls, e.j.d.e.b<? super T> bVar) {
        a0.k(cls);
        a0.k(bVar);
        if (this.a.containsKey(cls)) {
            ConcurrentHashMap<e.j.d.e.b<Object>, Executor> concurrentHashMap = this.a.get(cls);
            concurrentHashMap.remove(bVar);
            if (concurrentHashMap.isEmpty()) {
                this.a.remove(cls);
            }
        }
    }

    public void e() {
        Queue<e.j.d.e.a<?>> queue;
        synchronized (this) {
            queue = this.b;
            if (queue != null) {
                this.b = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (e.j.d.e.a<?> aVar : queue) {
                c(aVar);
            }
        }
    }
}
