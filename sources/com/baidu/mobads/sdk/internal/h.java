package com.baidu.mobads.sdk.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public abstract class h<T> implements Runnable {
    private static final String b = "BaseTask";

    /* renamed from: c  reason: collision with root package name */
    private static final int f1591c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static final int f1592d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static final int f1593e = 3;

    /* renamed from: j  reason: collision with root package name */
    private static b f1594j;
    public Future<T> a;

    /* renamed from: f  reason: collision with root package name */
    private String f1595f;

    /* renamed from: g  reason: collision with root package name */
    private long f1596g;

    /* renamed from: h  reason: collision with root package name */
    private long f1597h;

    /* renamed from: i  reason: collision with root package name */
    private long f1598i;

    /* loaded from: classes.dex */
    public static class a<T> {
        public final h a;
        public final T b;

        public a(h hVar, T t) {
            this.a = hVar;
            this.b = t;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i2 = message.what;
            if (i2 == 1) {
                aVar.a.a((h) aVar.b);
            } else if (i2 == 2) {
                aVar.a.a((Throwable) aVar.b);
            } else if (i2 != 3) {
            } else {
                aVar.a.j();
            }
        }
    }

    public h() {
        this.f1595f = "default";
    }

    private static Handler k() {
        b bVar;
        synchronized (h.class) {
            if (f1594j == null) {
                f1594j = new b(Looper.getMainLooper());
            }
            bVar = f1594j;
        }
        return bVar;
    }

    public String a() {
        return this.f1595f;
    }

    public void a(T t) {
    }

    public void a(Throwable th) {
    }

    public void b() {
        a(false);
    }

    public boolean c() {
        Future<T> future = this.a;
        if (future != null) {
            return future.isCancelled();
        }
        return false;
    }

    public boolean d() {
        Future<T> future = this.a;
        if (future != null) {
            return future.isDone();
        }
        return false;
    }

    public long e() {
        return this.f1597h - this.f1596g;
    }

    public long f() {
        return this.f1598i - this.f1596g;
    }

    public long g() {
        return this.f1598i - this.f1597h;
    }

    public h h() {
        try {
            this.f1597h = System.currentTimeMillis();
            k().obtainMessage(1, new a(this, i())).sendToTarget();
        } finally {
            try {
                return this;
            } finally {
            }
        }
        return this;
    }

    public abstract T i();

    public void j() {
    }

    @Override // java.lang.Runnable
    public void run() {
        h();
    }

    public void a(Future future) {
        this.a = future;
    }

    public h(String str) {
        this.f1595f = str;
    }

    public void a(long j2) {
        this.f1596g = j2;
    }

    public void a(boolean z) {
        Future<T> future = this.a;
        if (future != null) {
            future.cancel(z);
            k().obtainMessage(3, new a(this, null)).sendToTarget();
        }
    }
}
