package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.g;
import bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.j;
import java.util.Comparator;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class d {

    /* renamed from: g  reason: collision with root package name */
    public static final d f1115g = new d();

    /* renamed from: h  reason: collision with root package name */
    public static final bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a f1116h = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a();

    /* renamed from: i  reason: collision with root package name */
    public static final long f1117i;

    /* renamed from: j  reason: collision with root package name */
    public static long f1118j;
    private volatile bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c a;
    public volatile boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f1119c = false;

    /* renamed from: d  reason: collision with root package name */
    private volatile Handler f1120d;

    /* renamed from: e  reason: collision with root package name */
    private final Comparator<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> f1121e;

    /* renamed from: f  reason: collision with root package name */
    private final PriorityBlockingQueue<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> f1122f;

    /* loaded from: classes.dex */
    public class a implements Comparator<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> {
        public a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar2) {
            return d.this.a(aVar, aVar2);
        }
    }

    /* loaded from: classes.dex */
    public class b extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c {
        public final /* synthetic */ g b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f1123c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str, g gVar, long j2) {
            super(str);
            this.b = gVar;
            this.f1123c = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.a(this.b, this.f1123c);
        }
    }

    /* loaded from: classes.dex */
    public class c extends bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1.c {
        public c(String str) {
            super(str);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (d.this.a != null) {
                d.this.a.a(2);
            }
        }
    }

    static {
        new AtomicLong(0L);
        new AtomicLong(0L);
        f1117i = System.currentTimeMillis();
        f1118j = 0L;
    }

    private d() {
        a aVar = new a();
        this.f1121e = aVar;
        this.f1122f = new PriorityBlockingQueue<>(8, aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar2) {
        long j2;
        long j3;
        long j4;
        long j5;
        if (aVar == null) {
            return aVar2 == null ? 0 : -1;
        } else if (aVar2 == null) {
            return 1;
        } else {
            if (aVar.e() == aVar2.e()) {
                if (aVar.g() != null) {
                    j2 = aVar.g().c();
                    j3 = aVar.g().b();
                } else {
                    j2 = 0;
                    j3 = 0;
                }
                if (aVar2.g() != null) {
                    j5 = aVar2.g().c();
                    j4 = aVar2.g().b();
                } else {
                    j4 = 0;
                    j5 = 0;
                }
                if (j2 == 0 || j5 == 0) {
                    return 0;
                }
                long j6 = j2 - j5;
                if (Math.abs(j6) > 2147483647L) {
                    return 0;
                }
                if (j6 == 0) {
                    if (j3 == 0 || j4 == 0) {
                        return 0;
                    }
                    return (int) (j3 - j4);
                }
                return (int) j6;
            }
            return aVar.e() - aVar2.e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(g gVar, long j2) {
        if (gVar == null || this.a == null) {
            return;
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a aVar = f1116h;
        this.a.a(gVar.a(aVar.a(j2)), true);
        aVar.h0();
    }

    private void a(g gVar, bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar) {
        if (gVar == null || !gVar.e()) {
            return;
        }
        long j2 = 0;
        if (aVar != null && aVar.g() != null) {
            j2 = aVar.g().b();
        }
        long j3 = j2;
        if (j3 == 1) {
            f1118j = System.currentTimeMillis();
        }
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(f1116h.f0(), 1);
        if (j3 == 200) {
            if (Looper.getMainLooper() != Looper.myLooper()) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("==> monitor upload index1:" + j3);
                a(gVar, j3);
                return;
            }
            Executor a2 = gVar.a();
            if (a2 == null) {
                a2 = gVar.b();
            }
            if (a2 != null) {
                a2.execute(new b("report", gVar, j3));
            }
        }
    }

    public void a(Handler handler) {
        this.f1120d = handler;
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a aVar, int i2) {
        a();
        g b2 = j.l().b();
        if (this.a != null) {
            a(b2, aVar);
            this.a.a(aVar, aVar.e() == 4);
        }
    }

    public boolean a() {
        boolean z;
        synchronized (this) {
            try {
            } catch (Throwable th) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.b(th.getMessage());
            }
            if (this.a != null && this.a.isAlive()) {
                bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("LogThread state:" + this.a.getState());
                z = false;
            }
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.a("--start LogThread--");
            this.a = new bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c(this.f1122f);
            this.a.start();
            z = true;
        }
        return z;
    }

    public void b() {
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.b.a(f1116h.C(), 1);
        bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("flushMemoryAndDB()");
        if (Looper.myLooper() != Looper.getMainLooper()) {
            if (this.a != null) {
                this.a.a(2);
                return;
            }
            return;
        }
        g b2 = j.l().b();
        if (b2 == null) {
            bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_for12.c.d("discard flush");
            return;
        }
        Executor a2 = b2.a();
        if (a2 == null) {
            a2 = b2.b();
        }
        if (a2 != null) {
            a2.execute(new c("flush"));
        }
    }

    public PriorityBlockingQueue<bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.a> c() {
        return this.f1122f;
    }

    public void d() {
        a();
        b();
    }

    public void e() {
        synchronized (this) {
            if (this.a != null && this.a.isAlive()) {
                if (this.f1120d != null) {
                    this.f1120d.removeCallbacksAndMessages(null);
                }
                this.a.a(false);
                if (Build.VERSION.SDK_INT >= 18) {
                    this.a.quitSafely();
                } else {
                    this.a.quit();
                }
                this.a = null;
            }
        }
    }
}
