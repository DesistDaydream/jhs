package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public abstract class d<T extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> {
    private bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a a;
    private Queue<T> b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    private String f1064c;

    public d(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122.a aVar, Queue<String> queue, String str) {
        this.f1064c = "EventMemoryCacheManager";
        this.a = aVar;
        this.f1064c = str;
    }

    public void a(int i2, List<T> list) {
        synchronized (this) {
            if (i2 == -1 || i2 == 200 || i2 == 509) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d(this.f1064c + " memory size：" + this.b.size());
            } else {
                this.b.addAll(list);
            }
        }
    }

    public void a(T t) {
        Queue<T> queue = this.b;
        if (queue == null || t == null) {
            return;
        }
        queue.offer(t);
    }

    public boolean a(int i2, int i3) {
        boolean z;
        synchronized (this) {
            int size = this.b.size();
            int b = this.a.b();
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d(this.f1064c + " size:" + size + " cacheCount:" + b + " message:" + i2);
            z = false;
            if (i2 != 2 && i2 != 1) {
                if (size < b) {
                }
            }
            z = !bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.a.d() ? true : true;
        }
        return z;
    }

    public List<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> b(int i2, int i3) {
        ArrayList arrayList;
        synchronized (this) {
            if (a(i2, i3)) {
                arrayList = new ArrayList(this.a.b());
                do {
                    T poll = this.b.poll();
                    if (poll == null) {
                        break;
                    }
                    arrayList.add(poll);
                } while (arrayList.size() != this.a.a());
            } else {
                arrayList = null;
            }
        }
        return arrayList;
    }
}
