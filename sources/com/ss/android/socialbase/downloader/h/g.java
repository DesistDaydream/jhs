package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes3.dex */
public class g {
    private Object a = new Object();
    private Queue<b> b = new ConcurrentLinkedQueue();

    /* renamed from: c  reason: collision with root package name */
    private a f5737c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f5738d;

    /* loaded from: classes3.dex */
    public class a extends HandlerThread {
        public a(String str) {
            super(str);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper looper = getLooper();
            synchronized (g.this.a) {
                g.this.f5738d = new Handler(looper);
            }
            while (!g.this.b.isEmpty()) {
                b bVar = (b) g.this.b.poll();
                g.this.f5738d.postDelayed(bVar.a, bVar.b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b {
        public Runnable a;
        public long b;

        public b(Runnable runnable, long j2) {
            this.a = runnable;
            this.b = j2;
        }
    }

    public g(String str) {
        this.f5737c = new a(str);
    }

    public void b() {
        this.f5737c.quit();
    }

    public void a() {
        this.f5737c.start();
    }

    public void a(Runnable runnable) {
        a(runnable, 0L);
    }

    public void a(Runnable runnable, long j2) {
        if (this.f5738d == null) {
            synchronized (this.a) {
                if (this.f5738d == null) {
                    this.b.add(new b(runnable, j2));
                    return;
                }
            }
        }
        this.f5738d.postDelayed(runnable, j2);
    }
}
