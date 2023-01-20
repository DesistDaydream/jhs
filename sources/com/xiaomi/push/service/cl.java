package com.xiaomi.push.service;

import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.util.Objects;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes3.dex */
public class cl {
    private static long a;
    private static long b;

    /* renamed from: c  reason: collision with root package name */
    private static long f9151c;

    /* renamed from: d  reason: collision with root package name */
    private final c f9152d;

    /* renamed from: e  reason: collision with root package name */
    private final a f9153e;

    /* loaded from: classes3.dex */
    public static final class a {
        private final c a;

        public a(c cVar) {
            this.a = cVar;
        }

        public void finalize() {
            try {
                synchronized (this.a) {
                    this.a.f9157e = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b implements Runnable {

        /* renamed from: f  reason: collision with root package name */
        public int f9154f;

        public b(int i2) {
            this.f9154f = i2;
        }
    }

    /* loaded from: classes3.dex */
    public static final class c extends Thread {

        /* renamed from: d  reason: collision with root package name */
        private boolean f9156d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f9157e;
        private volatile long a = 0;
        private volatile boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private long f9155c = 50;

        /* renamed from: f  reason: collision with root package name */
        private a f9158f = new a();

        /* loaded from: classes3.dex */
        public static final class a {
            private int a;
            private d[] b;

            /* renamed from: c  reason: collision with root package name */
            private int f9159c;

            /* renamed from: d  reason: collision with root package name */
            private int f9160d;

            private a() {
                this.a = 256;
                this.b = new d[256];
                this.f9159c = 0;
                this.f9160d = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int b(d dVar) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr = this.b;
                    if (i2 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i2] == dVar) {
                        return i2;
                    }
                    i2++;
                }
            }

            private void c(d dVar) {
                Intent c2;
                b bVar = dVar.f9162d;
                int i2 = bVar.f9154f;
                if (i2 == 8) {
                    XMPushService.d dVar2 = (XMPushService.d) bVar;
                    if (dVar2.c().f8538c != null) {
                        dVar2.c().f8538c.f9190f = System.currentTimeMillis();
                        dVar2.c().f8538c.b = b(dVar);
                    }
                } else if (i2 == 15 && (c2 = ((XMPushService.i) bVar).c()) != null && "10".equals(c2.getStringExtra("ext_chid"))) {
                    c2.putExtra("enqueue", System.currentTimeMillis());
                    c2.putExtra("num", b(dVar));
                }
            }

            private void d(int i2) {
                int i3 = (i2 * 2) + 1;
                while (true) {
                    int i4 = this.f9159c;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.b;
                        if (dVarArr[i5].f9161c < dVarArr[i3].f9161c) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.b;
                    if (dVarArr2[i2].f9161c < dVarArr2[i3].f9161c) {
                        return;
                    }
                    d dVar = dVarArr2[i2];
                    dVarArr2[i2] = dVarArr2[i3];
                    dVarArr2[i3] = dVar;
                    int i6 = i3;
                    i3 = (i3 * 2) + 1;
                    i2 = i6;
                }
            }

            private void e() {
                int i2 = this.f9159c - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.b;
                    if (dVarArr[i2].f9161c >= dVarArr[i3].f9161c) {
                        return;
                    }
                    d dVar = dVarArr[i2];
                    dVarArr[i2] = dVarArr[i3];
                    dVarArr[i3] = dVar;
                    int i4 = i3;
                    i3 = (i3 - 1) / 2;
                    i2 = i4;
                }
            }

            public d a() {
                return this.b[0];
            }

            public void a(int i2, b bVar) {
                for (int i3 = 0; i3 < this.f9159c; i3++) {
                    d[] dVarArr = this.b;
                    if (dVarArr[i3].f9162d == bVar) {
                        dVarArr[i3].a();
                    }
                }
                d();
            }

            public void a(d dVar) {
                d[] dVarArr = this.b;
                int length = dVarArr.length;
                int i2 = this.f9159c;
                if (length == i2) {
                    d[] dVarArr2 = new d[i2 * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                    this.b = dVarArr2;
                }
                d[] dVarArr3 = this.b;
                int i3 = this.f9159c;
                this.f9159c = i3 + 1;
                dVarArr3[i3] = dVar;
                e();
                c(dVar);
            }

            public boolean a(int i2) {
                for (int i3 = 0; i3 < this.f9159c; i3++) {
                    if (this.b[i3].f9163e == i2) {
                        return true;
                    }
                }
                return false;
            }

            public void b(int i2) {
                for (int i3 = 0; i3 < this.f9159c; i3++) {
                    d[] dVarArr = this.b;
                    if (dVarArr[i3].f9163e == i2) {
                        dVarArr[i3].a();
                    }
                }
                d();
            }

            public boolean b() {
                return this.f9159c == 0;
            }

            public void c() {
                this.b = new d[this.a];
                this.f9159c = 0;
            }

            public void c(int i2) {
                int i3;
                if (i2 < 0 || i2 >= (i3 = this.f9159c)) {
                    return;
                }
                d[] dVarArr = this.b;
                int i4 = i3 - 1;
                this.f9159c = i4;
                dVarArr[i2] = dVarArr[i4];
                dVarArr[i4] = null;
                d(i2);
            }

            public void d() {
                int i2 = 0;
                while (i2 < this.f9159c) {
                    if (this.b[i2].b) {
                        this.f9160d++;
                        c(i2);
                        i2--;
                    }
                    i2++;
                }
            }
        }

        public c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f9158f.a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f9156d = true;
            this.f9158f.c();
            notify();
        }

        public boolean b() {
            return this.b && SystemClock.uptimeMillis() - this.a > 600000;
        }

        /* JADX WARN: Code restructure failed: missing block: B:50:0x008e, code lost:
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.b = true;
            r2.f9162d.run();
            r10.b = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:52:0x009f, code lost:
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:53:0x00a0, code lost:
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x00a1, code lost:
            r10.f9156d = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00a4, code lost:
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r10 = this;
            L0:
                monitor-enter(r10)
                boolean r0 = r10.f9156d     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L7
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                return
            L7:
                com.xiaomi.push.service.cl$c$a r0 = r10.f9158f     // Catch: java.lang.Throwable -> Lae
                boolean r0 = r0.b()     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L1a
                boolean r0 = r10.f9157e     // Catch: java.lang.Throwable -> Lae
                if (r0 == 0) goto L15
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                return
            L15:
                r10.wait()     // Catch: java.lang.InterruptedException -> L18 java.lang.Throwable -> Lae
            L18:
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                goto L0
            L1a:
                long r0 = com.xiaomi.push.service.cl.a()     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.cl$c$a r2 = r10.f9158f     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.cl$d r2 = r2.a()     // Catch: java.lang.Throwable -> Lae
                java.lang.Object r3 = r2.a     // Catch: java.lang.Throwable -> Lae
                monitor-enter(r3)     // Catch: java.lang.Throwable -> Lae
                boolean r4 = r2.b     // Catch: java.lang.Throwable -> Lab
                r5 = 0
                if (r4 == 0) goto L33
                com.xiaomi.push.service.cl$c$a r0 = r10.f9158f     // Catch: java.lang.Throwable -> Lab
                r0.c(r5)     // Catch: java.lang.Throwable -> Lab
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                goto L18
            L33:
                long r6 = r2.f9161c     // Catch: java.lang.Throwable -> Lab
                long r6 = r6 - r0
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                r0 = 50
                r3 = 0
                int r8 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
                if (r8 <= 0) goto L55
                long r2 = r10.f9155c     // Catch: java.lang.Throwable -> Lae
                int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
                if (r4 <= 0) goto L46
                r6 = r2
            L46:
                long r2 = r2 + r0
                r10.f9155c = r2     // Catch: java.lang.Throwable -> Lae
                r0 = 500(0x1f4, double:2.47E-321)
                int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
                if (r4 <= 0) goto L51
                r10.f9155c = r0     // Catch: java.lang.Throwable -> Lae
            L51:
                r10.wait(r6)     // Catch: java.lang.InterruptedException -> L18 java.lang.Throwable -> Lae
                goto L18
            L55:
                r10.f9155c = r0     // Catch: java.lang.Throwable -> Lae
                java.lang.Object r0 = r2.a     // Catch: java.lang.Throwable -> Lae
                monitor-enter(r0)     // Catch: java.lang.Throwable -> Lae
                com.xiaomi.push.service.cl$c$a r1 = r10.f9158f     // Catch: java.lang.Throwable -> La8
                com.xiaomi.push.service.cl$d r1 = r1.a()     // Catch: java.lang.Throwable -> La8
                long r6 = r1.f9161c     // Catch: java.lang.Throwable -> La8
                long r8 = r2.f9161c     // Catch: java.lang.Throwable -> La8
                int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r1 == 0) goto L6f
                com.xiaomi.push.service.cl$c$a r1 = r10.f9158f     // Catch: java.lang.Throwable -> La8
                int r1 = com.xiaomi.push.service.cl.c.a.a(r1, r2)     // Catch: java.lang.Throwable -> La8
                goto L70
            L6f:
                r1 = 0
            L70:
                boolean r6 = r2.b     // Catch: java.lang.Throwable -> La8
                if (r6 == 0) goto L7f
                com.xiaomi.push.service.cl$c$a r1 = r10.f9158f     // Catch: java.lang.Throwable -> La8
                int r2 = com.xiaomi.push.service.cl.c.a.a(r1, r2)     // Catch: java.lang.Throwable -> La8
                r1.c(r2)     // Catch: java.lang.Throwable -> La8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                goto L18
            L7f:
                long r6 = r2.f9161c     // Catch: java.lang.Throwable -> La8
                r2.a(r6)     // Catch: java.lang.Throwable -> La8
                com.xiaomi.push.service.cl$c$a r6 = r10.f9158f     // Catch: java.lang.Throwable -> La8
                r6.c(r1)     // Catch: java.lang.Throwable -> La8
                r2.f9161c = r3     // Catch: java.lang.Throwable -> La8
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                r0 = 1
                long r3 = android.os.SystemClock.uptimeMillis()     // Catch: java.lang.Throwable -> L9f
                r10.a = r3     // Catch: java.lang.Throwable -> L9f
                r10.b = r0     // Catch: java.lang.Throwable -> L9f
                com.xiaomi.push.service.cl$b r1 = r2.f9162d     // Catch: java.lang.Throwable -> L9f
                r1.run()     // Catch: java.lang.Throwable -> L9f
                r10.b = r5     // Catch: java.lang.Throwable -> L9f
                goto L0
            L9f:
                r1 = move-exception
                monitor-enter(r10)
                r10.f9156d = r0     // Catch: java.lang.Throwable -> La5
                monitor-exit(r10)     // Catch: java.lang.Throwable -> La5
                throw r1
            La5:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> La5
                throw r0
            La8:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> La8
                throw r1     // Catch: java.lang.Throwable -> Lae
            Lab:
                r0 = move-exception
                monitor-exit(r3)     // Catch: java.lang.Throwable -> Lab
                throw r0     // Catch: java.lang.Throwable -> Lae
            Lae:
                r0 = move-exception
                monitor-exit(r10)     // Catch: java.lang.Throwable -> Lae
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.cl.c.run():void");
        }
    }

    /* loaded from: classes3.dex */
    public static class d {
        public final Object a = new Object();
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public long f9161c;

        /* renamed from: d  reason: collision with root package name */
        public b f9162d;

        /* renamed from: e  reason: collision with root package name */
        public int f9163e;

        /* renamed from: f  reason: collision with root package name */
        private long f9164f;

        public void a(long j2) {
            synchronized (this.a) {
                this.f9164f = j2;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.a) {
                z = !this.b && this.f9161c > 0;
                this.b = true;
            }
            return z;
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        a = elapsedRealtime;
        b = elapsedRealtime;
    }

    public cl() {
        this(false);
    }

    public cl(String str) {
        this(str, false);
    }

    public cl(String str, boolean z) {
        Objects.requireNonNull(str, "name == null");
        c cVar = new c(str, z);
        this.f9152d = cVar;
        this.f9153e = new a(cVar);
    }

    public cl(boolean z) {
        this("Timer-" + e(), z);
    }

    public static synchronized long a() {
        long j2;
        synchronized (cl.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            long j3 = b;
            if (elapsedRealtime > j3) {
                a += elapsedRealtime - j3;
            }
            b = elapsedRealtime;
            j2 = a;
        }
        return j2;
    }

    private void b(b bVar, long j2) {
        synchronized (this.f9152d) {
            if (this.f9152d.f9156d) {
                throw new IllegalStateException("Timer was canceled");
            }
            long a2 = j2 + a();
            if (a2 < 0) {
                throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + a2);
            }
            d dVar = new d();
            dVar.f9163e = bVar.f9154f;
            dVar.f9162d = bVar;
            dVar.f9161c = a2;
            this.f9152d.a(dVar);
        }
    }

    private static synchronized long e() {
        long j2;
        synchronized (cl.class) {
            j2 = f9151c;
            f9151c = 1 + j2;
        }
        return j2;
    }

    public void a(int i2, b bVar) {
        synchronized (this.f9152d) {
            this.f9152d.f9158f.a(i2, bVar);
        }
    }

    public void a(b bVar) {
        if (com.xiaomi.a.a.a.c.a() >= 1 || Thread.currentThread() == this.f9152d) {
            bVar.run();
        } else {
            com.xiaomi.a.a.a.c.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
    }

    public void a(b bVar, long j2) {
        if (j2 >= 0) {
            b(bVar, j2);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j2);
    }

    public boolean a(int i2) {
        boolean a2;
        synchronized (this.f9152d) {
            a2 = this.f9152d.f9158f.a(i2);
        }
        return a2;
    }

    public void b() {
        com.xiaomi.a.a.a.c.a("quit. finalizer:" + this.f9153e);
        this.f9152d.a();
    }

    public void b(int i2) {
        synchronized (this.f9152d) {
            this.f9152d.f9158f.b(i2);
        }
    }

    public void c() {
        synchronized (this.f9152d) {
            this.f9152d.f9158f.c();
        }
    }

    public boolean d() {
        return this.f9152d.b();
    }
}
