package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class p {
    private a a;
    private Handler b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f9033c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f9034d;

    /* renamed from: e  reason: collision with root package name */
    private int f9035e;

    /* renamed from: f  reason: collision with root package name */
    private volatile b f9036f;

    /* loaded from: classes3.dex */
    public class a extends Thread {
        private final LinkedBlockingQueue<b> b;

        public a() {
            super("PackageProcessor");
            this.b = new LinkedBlockingQueue<>();
        }

        private void a(int i2, b bVar) {
            try {
                p.this.b.sendMessage(p.this.b.obtainMessage(i2, bVar));
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
        }

        public void a(b bVar) {
            try {
                this.b.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j2 = p.this.f9035e > 0 ? p.this.f9035e : Long.MAX_VALUE;
            while (!p.this.f9033c) {
                try {
                    b poll = this.b.poll(j2, TimeUnit.SECONDS);
                    p.this.f9036f = poll;
                    if (poll != null) {
                        a(0, poll);
                        poll.b();
                        a(1, poll);
                    } else if (p.this.f9035e > 0) {
                        p.this.a();
                    }
                } catch (InterruptedException e2) {
                    com.xiaomi.a.a.a.c.a(e2);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        public void c() {
        }
    }

    public p() {
        this(false);
    }

    public p(boolean z) {
        this(z, 0);
    }

    public p(boolean z, int i2) {
        this.b = null;
        this.f9033c = false;
        this.f9035e = 0;
        this.b = new q(this, Looper.getMainLooper());
        this.f9034d = z;
        this.f9035e = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.a = null;
        this.f9033c = true;
    }

    public synchronized void a(b bVar) {
        if (this.a == null) {
            a aVar = new a();
            this.a = aVar;
            aVar.setDaemon(this.f9034d);
            this.f9033c = false;
            this.a.start();
        }
        this.a.a(bVar);
    }

    public void a(b bVar, long j2) {
        this.b.postDelayed(new r(this, bVar), j2);
    }
}
