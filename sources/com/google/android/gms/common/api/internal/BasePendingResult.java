package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.i;
import e.j.a.b.c.n.k;
import e.j.a.b.c.n.m;
import e.j.a.b.c.n.p;
import e.j.a.b.c.n.q;
import e.j.a.b.c.n.s;
import e.j.a.b.c.n.t;
import e.j.a.b.c.n.u.g3;
import e.j.a.b.c.n.u.n2;
import e.j.a.b.c.n.u.t2;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.r;
import e.j.a.b.c.x.d0;
import e.j.a.b.f.a.o;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@e.j.a.b.c.m.a
@KeepName
/* loaded from: classes2.dex */
public abstract class BasePendingResult<R extends p> extends k<R> {
    public static final ThreadLocal<Boolean> p = new g3();
    private final Object a;
    private final a<R> b;

    /* renamed from: c  reason: collision with root package name */
    private final WeakReference<i> f2626c;

    /* renamed from: d  reason: collision with root package name */
    private final CountDownLatch f2627d;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<k.a> f2628e;

    /* renamed from: f  reason: collision with root package name */
    private q<? super R> f2629f;

    /* renamed from: g  reason: collision with root package name */
    private final AtomicReference<t2> f2630g;

    /* renamed from: h  reason: collision with root package name */
    private R f2631h;

    /* renamed from: i  reason: collision with root package name */
    private Status f2632i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f2633j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2634k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f2635l;

    /* renamed from: m  reason: collision with root package name */
    private r f2636m;
    @KeepName
    private b mResultGuardian;
    private volatile n2<R> n;
    private boolean o;

    @d0
    /* loaded from: classes2.dex */
    public static class a<R extends p> extends o {
        public a() {
            this(Looper.getMainLooper());
        }

        public final void a(q<? super R> qVar, R r) {
            sendMessage(obtainMessage(1, new Pair(qVar, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 != 1) {
                if (i2 != 2) {
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i2);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
                }
                ((BasePendingResult) message.obj).s(Status.RESULT_TIMEOUT);
                return;
            }
            Pair pair = (Pair) message.obj;
            q qVar = (q) pair.first;
            p pVar = (p) pair.second;
            try {
                qVar.a(pVar);
            } catch (RuntimeException e2) {
                BasePendingResult.r(pVar);
                throw e2;
            }
        }

        public a(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes2.dex */
    public final class b {
        private b() {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.r(BasePendingResult.this.f2631h);
            super.finalize();
        }

        public /* synthetic */ b(BasePendingResult basePendingResult, g3 g3Var) {
            this();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.a = new Object();
        this.f2627d = new CountDownLatch(1);
        this.f2628e = new ArrayList<>();
        this.f2630g = new AtomicReference<>();
        this.o = false;
        this.b = new a<>(Looper.getMainLooper());
        this.f2626c = new WeakReference<>(null);
    }

    private final R l() {
        R r;
        synchronized (this.a) {
            a0.r(!this.f2633j, "Result has already been consumed.");
            a0.r(m(), "Result is not ready.");
            r = this.f2631h;
            this.f2631h = null;
            this.f2629f = null;
            this.f2633j = true;
        }
        t2 andSet = this.f2630g.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    private final void p(R r) {
        this.f2631h = r;
        this.f2636m = null;
        this.f2627d.countDown();
        this.f2632i = this.f2631h.getStatus();
        if (this.f2634k) {
            this.f2629f = null;
        } else if (this.f2629f == null) {
            if (this.f2631h instanceof m) {
                this.mResultGuardian = new b(this, null);
            }
        } else {
            this.b.removeMessages(2);
            this.b.a(this.f2629f, l());
        }
        ArrayList<k.a> arrayList = this.f2628e;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            k.a aVar = arrayList.get(i2);
            i2++;
            aVar.a(this.f2632i);
        }
        this.f2628e.clear();
    }

    public static void r(p pVar) {
        if (pVar instanceof m) {
            try {
                ((m) pVar).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(pVar);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    @Override // e.j.a.b.c.n.k
    public final void b(k.a aVar) {
        a0.b(aVar != null, "Callback cannot be null.");
        synchronized (this.a) {
            if (m()) {
                aVar.a(this.f2632i);
            } else {
                this.f2628e.add(aVar);
            }
        }
    }

    @Override // e.j.a.b.c.n.k
    public final R c() {
        a0.j("await must not be called on the UI thread");
        a0.r(!this.f2633j, "Result has already been consumed");
        a0.r(this.n == null, "Cannot await if then() has been called.");
        try {
            this.f2627d.await();
        } catch (InterruptedException unused) {
            s(Status.RESULT_INTERRUPTED);
        }
        a0.r(m(), "Result is not ready.");
        return l();
    }

    @Override // e.j.a.b.c.n.k
    public final R d(long j2, TimeUnit timeUnit) {
        if (j2 > 0) {
            a0.j("await must not be called on the UI thread when time is greater than zero.");
        }
        a0.r(!this.f2633j, "Result has already been consumed.");
        a0.r(this.n == null, "Cannot await if then() has been called.");
        try {
            if (!this.f2627d.await(j2, timeUnit)) {
                s(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            s(Status.RESULT_INTERRUPTED);
        }
        a0.r(m(), "Result is not ready.");
        return l();
    }

    @Override // e.j.a.b.c.n.k
    @e.j.a.b.c.m.a
    public void e() {
        synchronized (this.a) {
            if (!this.f2634k && !this.f2633j) {
                r rVar = this.f2636m;
                if (rVar != null) {
                    try {
                        rVar.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                r(this.f2631h);
                this.f2634k = true;
                p(k(Status.RESULT_CANCELED));
            }
        }
    }

    @Override // e.j.a.b.c.n.k
    public boolean f() {
        boolean z;
        synchronized (this.a) {
            z = this.f2634k;
        }
        return z;
    }

    @Override // e.j.a.b.c.n.k
    @e.j.a.b.c.m.a
    public final void g(q<? super R> qVar) {
        synchronized (this.a) {
            if (qVar == null) {
                this.f2629f = null;
                return;
            }
            boolean z = true;
            a0.r(!this.f2633j, "Result has already been consumed.");
            if (this.n != null) {
                z = false;
            }
            a0.r(z, "Cannot set callbacks if then() has been called.");
            if (f()) {
                return;
            }
            if (m()) {
                this.b.a(qVar, l());
            } else {
                this.f2629f = qVar;
            }
        }
    }

    @Override // e.j.a.b.c.n.k
    @e.j.a.b.c.m.a
    public final void h(q<? super R> qVar, long j2, TimeUnit timeUnit) {
        synchronized (this.a) {
            if (qVar == null) {
                this.f2629f = null;
                return;
            }
            boolean z = true;
            a0.r(!this.f2633j, "Result has already been consumed.");
            if (this.n != null) {
                z = false;
            }
            a0.r(z, "Cannot set callbacks if then() has been called.");
            if (f()) {
                return;
            }
            if (m()) {
                this.b.a(qVar, l());
            } else {
                this.f2629f = qVar;
                a<R> aVar = this.b;
                aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j2));
            }
        }
    }

    @Override // e.j.a.b.c.n.k
    public <S extends p> t<S> i(s<? super R, ? extends S> sVar) {
        t<S> c2;
        a0.r(!this.f2633j, "Result has already been consumed.");
        synchronized (this.a) {
            a0.r(this.n == null, "Cannot call then() twice.");
            a0.r(this.f2629f == null, "Cannot call then() if callbacks are set.");
            a0.r(this.f2634k ? false : true, "Cannot call then() if result was canceled.");
            this.o = true;
            this.n = new n2<>(this.f2626c);
            c2 = this.n.c(sVar);
            if (m()) {
                this.b.a(this.n, l());
            } else {
                this.f2629f = this.n;
            }
        }
        return c2;
    }

    @Override // e.j.a.b.c.n.k
    public final Integer j() {
        return null;
    }

    @NonNull
    @e.j.a.b.c.m.a
    public abstract R k(Status status);

    @e.j.a.b.c.m.a
    public final boolean m() {
        return this.f2627d.getCount() == 0;
    }

    @e.j.a.b.c.m.a
    public final void n(r rVar) {
        synchronized (this.a) {
            this.f2636m = rVar;
        }
    }

    public final void q(t2 t2Var) {
        this.f2630g.set(t2Var);
    }

    public final void s(Status status) {
        synchronized (this.a) {
            if (!m()) {
                setResult(k(status));
                this.f2635l = true;
            }
        }
    }

    @e.j.a.b.c.m.a
    public final void setResult(R r) {
        synchronized (this.a) {
            if (!this.f2635l && !this.f2634k) {
                m();
                boolean z = true;
                a0.r(!m(), "Results have already been set");
                if (this.f2633j) {
                    z = false;
                }
                a0.r(z, "Result has already been consumed");
                p(r);
                return;
            }
            r(r);
        }
    }

    public final boolean t() {
        boolean f2;
        synchronized (this.a) {
            if (this.f2626c.get() == null || !this.o) {
                e();
            }
            f2 = f();
        }
        return f2;
    }

    public final void u() {
        this.o = this.o || p.get().booleanValue();
    }

    @e.j.a.b.c.m.a
    public BasePendingResult(i iVar) {
        this.a = new Object();
        this.f2627d = new CountDownLatch(1);
        this.f2628e = new ArrayList<>();
        this.f2630g = new AtomicReference<>();
        this.o = false;
        this.b = new a<>(iVar != null ? iVar.q() : Looper.getMainLooper());
        this.f2626c = new WeakReference<>(iVar);
    }

    @e.j.a.b.c.m.a
    @Deprecated
    public BasePendingResult(Looper looper) {
        this.a = new Object();
        this.f2627d = new CountDownLatch(1);
        this.f2628e = new ArrayList<>();
        this.f2630g = new AtomicReference<>();
        this.o = false;
        this.b = new a<>(looper);
        this.f2626c = new WeakReference<>(null);
    }

    @e.j.a.b.c.m.a
    @d0
    public BasePendingResult(@NonNull a<R> aVar) {
        this.a = new Object();
        this.f2627d = new CountDownLatch(1);
        this.f2628e = new ArrayList<>();
        this.f2630g = new AtomicReference<>();
        this.o = false;
        this.b = (a) a0.l(aVar, "CallbackHandler must not be null");
        this.f2626c = new WeakReference<>(null);
    }
}
