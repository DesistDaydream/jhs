package e.b.a.p.k.y;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class c {
    private final Map<String, a> a = new HashMap();
    private final b b = new b();

    /* loaded from: classes.dex */
    public static class a {
        public final Lock a = new ReentrantLock();
        public int b;
    }

    /* loaded from: classes.dex */
    public static class b {
        private static final int b = 10;
        private final Queue<a> a = new ArrayDeque();

        public a a() {
            a poll;
            synchronized (this.a) {
                poll = this.a.poll();
            }
            return poll == null ? new a() : poll;
        }

        public void b(a aVar) {
            synchronized (this.a) {
                if (this.a.size() < 10) {
                    this.a.offer(aVar);
                }
            }
        }
    }

    public void a(String str) {
        a aVar;
        synchronized (this) {
            aVar = this.a.get(str);
            if (aVar == null) {
                aVar = this.b.a();
                this.a.put(str, aVar);
            }
            aVar.b++;
        }
        aVar.a.lock();
    }

    public void b(String str) {
        a aVar;
        synchronized (this) {
            aVar = (a) e.b.a.v.l.d(this.a.get(str));
            int i2 = aVar.b;
            if (i2 >= 1) {
                int i3 = i2 - 1;
                aVar.b = i3;
                if (i3 == 0) {
                    a remove = this.a.remove(str);
                    if (remove.equals(aVar)) {
                        this.b.b(remove);
                    } else {
                        throw new IllegalStateException("Removed the wrong lock, expected to remove: " + aVar + ", but actually removed: " + remove + ", safeKey: " + str);
                    }
                }
            } else {
                throw new IllegalStateException("Cannot release a lock that is not held, safeKey: " + str + ", interestedThreads: " + aVar.b);
            }
        }
        aVar.a.unlock();
    }
}
