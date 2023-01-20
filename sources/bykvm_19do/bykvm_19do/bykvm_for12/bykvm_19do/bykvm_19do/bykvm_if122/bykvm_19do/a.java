package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.caverock.androidsvg.SVG;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class a extends t {

    /* renamed from: h  reason: collision with root package name */
    private static final long f270h;

    /* renamed from: i  reason: collision with root package name */
    private static final long f271i;

    /* renamed from: j  reason: collision with root package name */
    public static a f272j;

    /* renamed from: e  reason: collision with root package name */
    private boolean f273e;

    /* renamed from: f  reason: collision with root package name */
    private a f274f;

    /* renamed from: g  reason: collision with root package name */
    private long f275g;

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0019a implements r {
        public final /* synthetic */ r a;

        public C0019a(r rVar) {
            this.a = rVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return a.this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            try {
                u.a(cVar.b, 0L, j2);
                while (true) {
                    long j3 = 0;
                    if (j2 <= 0) {
                        return;
                    }
                    o oVar = cVar.a;
                    while (true) {
                        if (j3 >= SVG.D) {
                            break;
                        }
                        j3 += oVar.f289c - oVar.b;
                        if (j3 >= j2) {
                            j3 = j2;
                            break;
                        }
                        oVar = oVar.f292f;
                    }
                    a.this.g();
                    try {
                        try {
                            this.a.b(cVar, j3);
                            j2 -= j3;
                            a.this.a(true);
                        } catch (IOException e2) {
                            throw a.this.a(e2);
                        }
                    } catch (Throwable th) {
                        a.this.a(false);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                throw new IOException(e3);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.g();
            try {
                try {
                    this.a.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            a.this.g();
            try {
                try {
                    this.a.flush();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.sink(" + this.a + ")";
        }
    }

    /* loaded from: classes.dex */
    public class b implements s {
        public final /* synthetic */ s a;

        public b(s sVar) {
            this.a = sVar;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            a.this.g();
            try {
                try {
                    long a = this.a.a(cVar, j2);
                    a.this.a(true);
                    return a;
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return a.this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            a.this.g();
            try {
                try {
                    this.a.close();
                    a.this.a(true);
                } catch (IOException e2) {
                    throw a.this.a(e2);
                }
            } catch (Throwable th) {
                a.this.a(false);
                throw th;
            }
        }

        public String toString() {
            return "AsyncTimeout.source(" + this.a + ")";
        }
    }

    /* loaded from: classes.dex */
    public static final class c extends Thread {
        public c() {
            super("Okio Watchdog");
            setDaemon(true);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x0015, code lost:
            r1.i();
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r3 = this;
                java.lang.Class<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.class
            L2:
                monitor-enter(r0)     // Catch: java.lang.InterruptedException -> L2
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.j()     // Catch: java.lang.Throwable -> L19
                if (r1 != 0) goto Lb
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                goto L2
            Lb:
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f272j     // Catch: java.lang.Throwable -> L19
                if (r1 != r2) goto L14
                r1 = 0
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f272j = r1     // Catch: java.lang.Throwable -> L19
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                return
            L14:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                r1.i()     // Catch: java.lang.InterruptedException -> L2
                goto L2
            L19:
                r1 = move-exception
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L19
                throw r1     // Catch: java.lang.InterruptedException -> L2
            */
            throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.c.run():void");
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(60L);
        f270h = millis;
        f271i = TimeUnit.MILLISECONDS.toNanos(millis);
    }

    private static void a(a aVar, long j2, boolean z) {
        synchronized (a.class) {
            if (f272j == null) {
                f272j = new a();
                c cVar = new c();
                cVar.setName("gm_t_watch_dog");
                try {
                    cVar.start();
                } catch (Throwable unused) {
                }
            }
            long nanoTime = System.nanoTime();
            int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
            if (i2 != 0 && z) {
                aVar.f275g = Math.min(j2, aVar.c() - nanoTime) + nanoTime;
            } else if (i2 != 0) {
                aVar.f275g = j2 + nanoTime;
            } else if (!z) {
                throw new AssertionError();
            } else {
                aVar.f275g = aVar.c();
            }
            long b2 = aVar.b(nanoTime);
            a aVar2 = f272j;
            while (true) {
                a aVar3 = aVar2.f274f;
                if (aVar3 == null || b2 < aVar3.b(nanoTime)) {
                    break;
                }
                aVar2 = aVar2.f274f;
            }
            aVar.f274f = aVar2.f274f;
            aVar2.f274f = aVar;
            if (aVar2 == f272j) {
                a.class.notify();
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000b, code lost:
        r1.f274f = r3.f274f;
        r3.f274f = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0012, code lost:
        r3 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r3) {
        /*
            java.lang.Class<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a> r0 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.class
            monitor-enter(r0)
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r1 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.f272j     // Catch: java.lang.Throwable -> L19
        L5:
            if (r1 == 0) goto L16
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = r1.f274f     // Catch: java.lang.Throwable -> L19
            if (r2 != r3) goto L14
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a r2 = r3.f274f     // Catch: java.lang.Throwable -> L19
            r1.f274f = r2     // Catch: java.lang.Throwable -> L19
            r1 = 0
            r3.f274f = r1     // Catch: java.lang.Throwable -> L19
            r3 = 0
            goto L17
        L14:
            r1 = r2
            goto L5
        L16:
            r3 = 1
        L17:
            monitor-exit(r0)
            return r3
        L19:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a):boolean");
    }

    private long b(long j2) {
        return this.f275g - j2;
    }

    public static a j() throws InterruptedException {
        a aVar = f272j.f274f;
        long nanoTime = System.nanoTime();
        if (aVar == null) {
            a.class.wait(f270h);
            if (f272j.f274f == null && System.nanoTime() - nanoTime >= f271i) {
                return f272j;
            }
        } else {
            long b2 = aVar.b(nanoTime);
            if (b2 <= 0) {
                f272j.f274f = aVar.f274f;
                aVar.f274f = null;
                return aVar;
            }
            long j2 = b2 / 1000000;
            a.class.wait(j2, (int) (b2 - (1000000 * j2)));
        }
        return null;
    }

    public final r a(r rVar) {
        return new C0019a(rVar);
    }

    public final s a(s sVar) {
        return new b(sVar);
    }

    public final IOException a(IOException iOException) throws IOException {
        return !h() ? iOException : b(iOException);
    }

    public final void a(boolean z) throws IOException {
        if (h() && z) {
            throw b((IOException) null);
        }
    }

    public IOException b(IOException iOException) {
        InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
        if (iOException != null) {
            interruptedIOException.initCause(iOException);
        }
        return interruptedIOException;
    }

    public final void g() {
        if (this.f273e) {
            return;
        }
        long f2 = f();
        boolean d2 = d();
        if (f2 != 0 || d2) {
            this.f273e = true;
            a(this, f2, d2);
        }
    }

    public final boolean h() {
        if (this.f273e) {
            this.f273e = false;
            return a(this);
        }
        return false;
    }

    public void i() {
    }
}
