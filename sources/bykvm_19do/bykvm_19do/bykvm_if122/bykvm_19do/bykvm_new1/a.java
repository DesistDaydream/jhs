package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.LinkedList;
import java.util.Queue;

/* loaded from: classes.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f891d;
    private long a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private final Queue<Long> f892c = new LinkedList();

    private a() {
    }

    public static a b() {
        if (f891d == null) {
            synchronized (a.class) {
                if (f891d == null) {
                    f891d = new a();
                }
            }
        }
        return f891d;
    }

    public void a(long j2, long j3) {
        synchronized (a.class) {
            if (this.a != j2 || this.b != j3) {
                this.a = j2;
                this.b = j3;
                this.f892c.clear();
            }
        }
    }

    public boolean a() {
        boolean z;
        Queue<Long> queue;
        Long valueOf;
        synchronized (a.class) {
            z = false;
            if (this.a > 0 && this.b > 0) {
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f892c.size() >= this.a) {
                    while (this.f892c.size() > this.a) {
                        this.f892c.poll();
                    }
                    if (Math.abs(currentTimeMillis - this.f892c.peek().longValue()) <= this.b) {
                        z = true;
                    } else {
                        this.f892c.poll();
                        queue = this.f892c;
                        valueOf = Long.valueOf(currentTimeMillis);
                    }
                } else {
                    queue = this.f892c;
                    valueOf = Long.valueOf(currentTimeMillis);
                }
                queue.offer(valueOf);
            }
        }
        return z;
    }
}
