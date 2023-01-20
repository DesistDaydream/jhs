package com.ss.android.socialbase.downloader.e;

import android.os.Process;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.p;
import com.ss.android.socialbase.downloader.i.f;
import java.io.InputStream;
import java.util.concurrent.Future;

/* loaded from: classes3.dex */
public class a implements b {
    private final InputStream a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final int f5634c;

    /* renamed from: f  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f5637f;

    /* renamed from: g  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f5638g;

    /* renamed from: h  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f5639h;

    /* renamed from: i  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f5640i;

    /* renamed from: j  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f5641j;

    /* renamed from: k  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.f.a f5642k;

    /* renamed from: l  reason: collision with root package name */
    private volatile boolean f5643l;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f5644m;
    private volatile Throwable n;
    private volatile Future o;
    private int p;

    /* renamed from: d  reason: collision with root package name */
    private final Object f5635d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private final Object f5636e = new Object();
    private final Runnable q = new Runnable() { // from class: com.ss.android.socialbase.downloader.e.a.1
        @Override // java.lang.Runnable
        public void run() {
            com.ss.android.socialbase.downloader.f.a d2;
            Process.setThreadPriority(10);
            do {
                try {
                    d2 = a.this.d();
                    d2.f5646c = a.this.a.read(d2.a);
                    a.this.c(d2);
                } catch (Throwable th) {
                    try {
                        a.this.n = th;
                        th.printStackTrace();
                        synchronized (a.this.f5636e) {
                            a.this.f5644m = true;
                            a.this.f5636e.notify();
                            f.a(a.this.a);
                            return;
                        }
                    } catch (Throwable th2) {
                        synchronized (a.this.f5636e) {
                            a.this.f5644m = true;
                            a.this.f5636e.notify();
                            f.a(a.this.a);
                            throw th2;
                        }
                    }
                }
            } while (d2.f5646c != -1);
            synchronized (a.this.f5636e) {
                a.this.f5644m = true;
                a.this.f5636e.notify();
            }
            f.a(a.this.a);
        }
    };

    public a(InputStream inputStream, int i2, int i3) throws Throwable {
        this.a = inputStream;
        this.b = i2;
        if (i3 < 1) {
            i3 = 1;
        } else if (i3 > 64) {
            i3 = 64;
        }
        this.f5634c = i3;
        c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.ss.android.socialbase.downloader.f.a d() throws p, InterruptedException {
        int i2;
        com.ss.android.socialbase.downloader.f.a aVar = this.f5639h;
        if (aVar != null) {
            if (!this.f5643l) {
                this.f5639h = aVar.f5647d;
                aVar.f5647d = null;
                return aVar;
            }
            throw new p("");
        }
        synchronized (this.f5635d) {
            if (!this.f5643l) {
                com.ss.android.socialbase.downloader.f.a aVar2 = this.f5637f;
                if (aVar2 == null && (i2 = this.p) < this.f5634c) {
                    this.p = i2 + 1;
                    return new com.ss.android.socialbase.downloader.f.a(this.b);
                }
                while (aVar2 == null) {
                    this.f5635d.wait();
                    if (!this.f5643l) {
                        aVar2 = this.f5637f;
                    } else {
                        throw new p("");
                    }
                }
                this.f5639h = aVar2.f5647d;
                this.f5638g = null;
                this.f5637f = null;
                aVar2.f5647d = null;
                return aVar2;
            }
            throw new p("");
        }
    }

    private com.ss.android.socialbase.downloader.f.a e() throws BaseException, InterruptedException {
        com.ss.android.socialbase.downloader.f.a aVar;
        com.ss.android.socialbase.downloader.f.a aVar2 = this.f5642k;
        if (aVar2 != null) {
            this.f5642k = aVar2.f5647d;
            aVar2.f5647d = null;
            return aVar2;
        }
        synchronized (this.f5636e) {
            aVar = this.f5640i;
            if (aVar == null) {
                do {
                    if (this.f5644m) {
                        f();
                    }
                    this.f5636e.wait();
                    aVar = this.f5640i;
                } while (aVar == null);
                this.f5642k = aVar.f5647d;
                this.f5641j = null;
                this.f5640i = null;
                aVar.f5647d = null;
            } else {
                this.f5642k = aVar.f5647d;
                this.f5641j = null;
                this.f5640i = null;
                aVar.f5647d = null;
            }
        }
        return aVar;
    }

    private void f() throws BaseException {
        Throwable th = this.n;
        if (th != null) {
            if (th instanceof p) {
                throw new BaseException(1068, "async reader closed!");
            }
            f.a(th, "async_read");
        }
        throw new BaseException(1069, "async reader terminated!");
    }

    private void c() throws Throwable {
        this.o = com.ss.android.socialbase.downloader.downloader.c.q().submit(this.q);
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void b() {
        synchronized (this.f5635d) {
            this.f5643l = true;
            this.f5635d.notify();
        }
        Future future = this.o;
        if (future != null) {
            try {
                future.cancel(true);
            } catch (Throwable unused) {
            }
            this.o = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.f5636e) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f5641j;
            if (aVar2 == null) {
                this.f5641j = aVar;
                this.f5640i = aVar;
                this.f5636e.notify();
            } else {
                aVar2.f5647d = aVar;
                this.f5641j = aVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public com.ss.android.socialbase.downloader.f.a a() throws BaseException, InterruptedException {
        return e();
    }

    @Override // com.ss.android.socialbase.downloader.e.b
    public void a(com.ss.android.socialbase.downloader.f.a aVar) {
        b(aVar);
    }

    private void b(com.ss.android.socialbase.downloader.f.a aVar) {
        synchronized (this.f5635d) {
            com.ss.android.socialbase.downloader.f.a aVar2 = this.f5638g;
            if (aVar2 == null) {
                this.f5638g = aVar;
                this.f5637f = aVar;
                this.f5635d.notify();
            } else {
                aVar2.f5647d = aVar;
                this.f5638g = aVar;
            }
        }
    }
}
