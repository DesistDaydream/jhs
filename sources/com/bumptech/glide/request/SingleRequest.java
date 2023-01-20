package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import androidx.annotation.DrawableRes;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import e.b.a.d;
import e.b.a.p.k.i;
import e.b.a.p.k.s;
import e.b.a.t.a;
import e.b.a.t.e;
import e.b.a.t.g;
import e.b.a.t.i;
import e.b.a.t.k.o;
import e.b.a.t.k.p;
import e.b.a.v.h;
import e.b.a.v.n;
import e.b.a.v.p.c;
import java.util.List;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class SingleRequest<R> implements e, o, i {
    private static final String D = "Glide";
    @GuardedBy("requestLock")
    private boolean A;
    @Nullable
    private RuntimeException B;
    @Nullable
    private final String a;
    private final c b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f1731c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final g<R> f1732d;

    /* renamed from: e  reason: collision with root package name */
    private final RequestCoordinator f1733e;

    /* renamed from: f  reason: collision with root package name */
    private final Context f1734f;

    /* renamed from: g  reason: collision with root package name */
    private final e.b.a.e f1735g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Object f1736h;

    /* renamed from: i  reason: collision with root package name */
    private final Class<R> f1737i;

    /* renamed from: j  reason: collision with root package name */
    private final a<?> f1738j;

    /* renamed from: k  reason: collision with root package name */
    private final int f1739k;

    /* renamed from: l  reason: collision with root package name */
    private final int f1740l;

    /* renamed from: m  reason: collision with root package name */
    private final Priority f1741m;
    private final p<R> n;
    private final e.b.a.t.l.g<? super R> o;
    private final Executor p;
    @GuardedBy("requestLock")
    private s<R> q;
    @GuardedBy("requestLock")
    private i.d r;
    @Nullable
    private final List<g<R>> requestListeners;
    @GuardedBy("requestLock")
    private long s;
    private volatile e.b.a.p.k.i t;
    @GuardedBy("requestLock")
    private Status u;
    @Nullable
    @GuardedBy("requestLock")
    private Drawable v;
    @Nullable
    @GuardedBy("requestLock")
    private Drawable w;
    @Nullable
    @GuardedBy("requestLock")
    private Drawable x;
    @GuardedBy("requestLock")
    private int y;
    @GuardedBy("requestLock")
    private int z;
    private static final String C = "Request";
    private static final boolean E = Log.isLoggable(C, 2);

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    private SingleRequest(Context context, e.b.a.e eVar, @NonNull Object obj, @Nullable Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, Priority priority, p<R> pVar, @Nullable g<R> gVar, @Nullable List<g<R>> list, RequestCoordinator requestCoordinator, e.b.a.p.k.i iVar, e.b.a.t.l.g<? super R> gVar2, Executor executor) {
        this.a = E ? String.valueOf(super.hashCode()) : null;
        this.b = c.a();
        this.f1731c = obj;
        this.f1734f = context;
        this.f1735g = eVar;
        this.f1736h = obj2;
        this.f1737i = cls;
        this.f1738j = aVar;
        this.f1739k = i2;
        this.f1740l = i3;
        this.f1741m = priority;
        this.n = pVar;
        this.f1732d = gVar;
        this.requestListeners = list;
        this.f1733e = requestCoordinator;
        this.t = iVar;
        this.o = gVar2;
        this.p = executor;
        this.u = Status.PENDING;
        if (this.B == null && eVar.g().b(d.C0302d.class)) {
            this.B = new RuntimeException("Glide request origin trace");
        }
    }

    @GuardedBy("requestLock")
    private void i() {
        if (this.A) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    @GuardedBy("requestLock")
    private boolean j() {
        RequestCoordinator requestCoordinator = this.f1733e;
        return requestCoordinator == null || requestCoordinator.i(this);
    }

    @GuardedBy("requestLock")
    private boolean k() {
        RequestCoordinator requestCoordinator = this.f1733e;
        return requestCoordinator == null || requestCoordinator.b(this);
    }

    @GuardedBy("requestLock")
    private boolean l() {
        RequestCoordinator requestCoordinator = this.f1733e;
        return requestCoordinator == null || requestCoordinator.c(this);
    }

    @GuardedBy("requestLock")
    private void m() {
        i();
        this.b.c();
        this.n.removeCallback(this);
        i.d dVar = this.r;
        if (dVar != null) {
            dVar.a();
            this.r = null;
        }
    }

    @GuardedBy("requestLock")
    private Drawable n() {
        if (this.v == null) {
            Drawable I = this.f1738j.I();
            this.v = I;
            if (I == null && this.f1738j.H() > 0) {
                this.v = r(this.f1738j.H());
            }
        }
        return this.v;
    }

    @GuardedBy("requestLock")
    private Drawable o() {
        if (this.x == null) {
            Drawable J = this.f1738j.J();
            this.x = J;
            if (J == null && this.f1738j.K() > 0) {
                this.x = r(this.f1738j.K());
            }
        }
        return this.x;
    }

    @GuardedBy("requestLock")
    private Drawable p() {
        if (this.w == null) {
            Drawable P = this.f1738j.P();
            this.w = P;
            if (P == null && this.f1738j.Q() > 0) {
                this.w = r(this.f1738j.Q());
            }
        }
        return this.w;
    }

    @GuardedBy("requestLock")
    private boolean q() {
        RequestCoordinator requestCoordinator = this.f1733e;
        return requestCoordinator == null || !requestCoordinator.getRoot().a();
    }

    @GuardedBy("requestLock")
    private Drawable r(@DrawableRes int i2) {
        return e.b.a.p.m.f.a.a(this.f1735g, i2, this.f1738j.V() != null ? this.f1738j.V() : this.f1734f.getTheme());
    }

    private void s(String str) {
        Log.v(C, str + " this: " + this.a);
    }

    private static int t(int i2, float f2) {
        return i2 == Integer.MIN_VALUE ? i2 : Math.round(f2 * i2);
    }

    @GuardedBy("requestLock")
    private void u() {
        RequestCoordinator requestCoordinator = this.f1733e;
        if (requestCoordinator != null) {
            requestCoordinator.e(this);
        }
    }

    @GuardedBy("requestLock")
    private void v() {
        RequestCoordinator requestCoordinator = this.f1733e;
        if (requestCoordinator != null) {
            requestCoordinator.g(this);
        }
    }

    public static <R> SingleRequest<R> w(Context context, e.b.a.e eVar, Object obj, Object obj2, Class<R> cls, a<?> aVar, int i2, int i3, Priority priority, p<R> pVar, g<R> gVar, @Nullable List<g<R>> list, RequestCoordinator requestCoordinator, e.b.a.p.k.i iVar, e.b.a.t.l.g<? super R> gVar2, Executor executor) {
        return new SingleRequest<>(context, eVar, obj, obj2, cls, aVar, i2, i3, priority, pVar, gVar, list, requestCoordinator, iVar, gVar2, executor);
    }

    private void x(GlideException glideException, int i2) {
        boolean z;
        this.b.c();
        synchronized (this.f1731c) {
            glideException.setOrigin(this.B);
            int h2 = this.f1735g.h();
            if (h2 <= i2) {
                Log.w(D, "Load failed for " + this.f1736h + " with size [" + this.y + "x" + this.z + "]", glideException);
                if (h2 <= 4) {
                    glideException.logRootCauses(D);
                }
            }
            this.r = null;
            this.u = Status.FAILED;
            boolean z2 = true;
            this.A = true;
            List<g<R>> list = this.requestListeners;
            if (list != null) {
                z = false;
                for (g<R> gVar : list) {
                    z |= gVar.onLoadFailed(glideException, this.f1736h, this.n, q());
                }
            } else {
                z = false;
            }
            g<R> gVar2 = this.f1732d;
            if (gVar2 == null || !gVar2.onLoadFailed(glideException, this.f1736h, this.n, q())) {
                z2 = false;
            }
            if (!(z | z2)) {
                z();
            }
            this.A = false;
            u();
        }
    }

    @GuardedBy("requestLock")
    private void y(s<R> sVar, R r, DataSource dataSource, boolean z) {
        boolean z2;
        boolean q = q();
        this.u = Status.COMPLETE;
        this.q = sVar;
        if (this.f1735g.h() <= 3) {
            Log.d(D, "Finished loading " + r.getClass().getSimpleName() + " from " + dataSource + " for " + this.f1736h + " with size [" + this.y + "x" + this.z + "] in " + h.a(this.s) + " ms");
        }
        boolean z3 = true;
        this.A = true;
        try {
            List<g<R>> list = this.requestListeners;
            if (list != null) {
                z2 = false;
                for (g<R> gVar : list) {
                    z2 |= gVar.onResourceReady(r, this.f1736h, this.n, dataSource, q);
                }
            } else {
                z2 = false;
            }
            g<R> gVar2 = this.f1732d;
            if (gVar2 == null || !gVar2.onResourceReady(r, this.f1736h, this.n, dataSource, q)) {
                z3 = false;
            }
            if (!(z3 | z2)) {
                this.n.onResourceReady(r, this.o.a(dataSource, q));
            }
            this.A = false;
            v();
        } catch (Throwable th) {
            this.A = false;
            throw th;
        }
    }

    @GuardedBy("requestLock")
    private void z() {
        if (k()) {
            Drawable o = this.f1736h == null ? o() : null;
            if (o == null) {
                o = n();
            }
            if (o == null) {
                o = p();
            }
            this.n.onLoadFailed(o);
        }
    }

    @Override // e.b.a.t.e
    public boolean a() {
        boolean z;
        synchronized (this.f1731c) {
            z = this.u == Status.COMPLETE;
        }
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004f, code lost:
        if (r6 == null) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0051, code lost:
        r5.t.l(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0056, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00aa, code lost:
        if (r6 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
        r5.t.l(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00b1, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // e.b.a.t.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(e.b.a.p.k.s<?> r6, com.bumptech.glide.load.DataSource r7, boolean r8) {
        /*
            r5 = this;
            e.b.a.v.p.c r0 = r5.b
            r0.c()
            r0 = 0
            java.lang.Object r1 = r5.f1731c     // Catch: java.lang.Throwable -> Lb9
            monitor-enter(r1)     // Catch: java.lang.Throwable -> Lb9
            r5.r = r0     // Catch: java.lang.Throwable -> Lb6
            if (r6 != 0) goto L2f
            com.bumptech.glide.load.engine.GlideException r6 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb6
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb6
            r7.<init>()     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r8 = "Expected to receive a Resource<R> with an object of "
            r7.append(r8)     // Catch: java.lang.Throwable -> Lb6
            java.lang.Class<R> r8 = r5.f1737i     // Catch: java.lang.Throwable -> Lb6
            r7.append(r8)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r8 = " inside, but instead got null."
            r7.append(r8)     // Catch: java.lang.Throwable -> Lb6
            java.lang.String r7 = r7.toString()     // Catch: java.lang.Throwable -> Lb6
            r6.<init>(r7)     // Catch: java.lang.Throwable -> Lb6
            r5.c(r6)     // Catch: java.lang.Throwable -> Lb6
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb6
            return
        L2f:
            java.lang.Object r2 = r6.get()     // Catch: java.lang.Throwable -> Lb6
            if (r2 == 0) goto L5c
            java.lang.Class<R> r3 = r5.f1737i     // Catch: java.lang.Throwable -> Lb6
            java.lang.Class r4 = r2.getClass()     // Catch: java.lang.Throwable -> Lb6
            boolean r3 = r3.isAssignableFrom(r4)     // Catch: java.lang.Throwable -> Lb6
            if (r3 != 0) goto L42
            goto L5c
        L42:
            boolean r3 = r5.l()     // Catch: java.lang.Throwable -> Lb6
            if (r3 != 0) goto L57
            r5.q = r0     // Catch: java.lang.Throwable -> Lb2
            com.bumptech.glide.request.SingleRequest$Status r7 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch: java.lang.Throwable -> Lb2
            r5.u = r7     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb2
            if (r6 == 0) goto L56
            e.b.a.p.k.i r7 = r5.t
            r7.l(r6)
        L56:
            return
        L57:
            r5.y(r6, r2, r7, r8)     // Catch: java.lang.Throwable -> Lb6
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb6
            return
        L5c:
            r5.q = r0     // Catch: java.lang.Throwable -> Lb2
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch: java.lang.Throwable -> Lb2
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb2
            r8.<init>()     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = "Expected to receive an object of "
            r8.append(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.Class<R> r0 = r5.f1737i     // Catch: java.lang.Throwable -> Lb2
            r8.append(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = " but instead got "
            r8.append(r0)     // Catch: java.lang.Throwable -> Lb2
            if (r2 == 0) goto L7b
            java.lang.Class r0 = r2.getClass()     // Catch: java.lang.Throwable -> Lb2
            goto L7d
        L7b:
            java.lang.String r0 = ""
        L7d:
            r8.append(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = "{"
            r8.append(r0)     // Catch: java.lang.Throwable -> Lb2
            r8.append(r2)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = "} inside Resource{"
            r8.append(r0)     // Catch: java.lang.Throwable -> Lb2
            r8.append(r6)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r0 = "}."
            r8.append(r0)     // Catch: java.lang.Throwable -> Lb2
            if (r2 == 0) goto L9a
            java.lang.String r0 = ""
            goto L9c
        L9a:
            java.lang.String r0 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L9c:
            r8.append(r0)     // Catch: java.lang.Throwable -> Lb2
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> Lb2
            r7.<init>(r8)     // Catch: java.lang.Throwable -> Lb2
            r5.c(r7)     // Catch: java.lang.Throwable -> Lb2
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb2
            if (r6 == 0) goto Lb1
            e.b.a.p.k.i r7 = r5.t
            r7.l(r6)
        Lb1:
            return
        Lb2:
            r7 = move-exception
            r0 = r6
            r6 = r7
            goto Lb7
        Lb6:
            r6 = move-exception
        Lb7:
            monitor-exit(r1)     // Catch: java.lang.Throwable -> Lb6
            throw r6     // Catch: java.lang.Throwable -> Lb9
        Lb9:
            r6 = move-exception
            if (r0 == 0) goto Lc1
            e.b.a.p.k.i r7 = r5.t
            r7.l(r0)
        Lc1:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.b(e.b.a.p.k.s, com.bumptech.glide.load.DataSource, boolean):void");
    }

    @Override // e.b.a.t.i
    public void c(GlideException glideException) {
        x(glideException, 5);
    }

    @Override // e.b.a.t.e
    public void clear() {
        synchronized (this.f1731c) {
            i();
            this.b.c();
            Status status = this.u;
            Status status2 = Status.CLEARED;
            if (status == status2) {
                return;
            }
            m();
            s<R> sVar = this.q;
            if (sVar != null) {
                this.q = null;
            } else {
                sVar = null;
            }
            if (j()) {
                this.n.onLoadCleared(p());
            }
            this.u = status2;
            if (sVar != null) {
                this.t.l(sVar);
            }
        }
    }

    @Override // e.b.a.t.e
    public void d() {
        synchronized (this.f1731c) {
            i();
            this.b.c();
            this.s = h.b();
            if (this.f1736h == null) {
                if (n.w(this.f1739k, this.f1740l)) {
                    this.y = this.f1739k;
                    this.z = this.f1740l;
                }
                x(new GlideException("Received null model"), o() == null ? 5 : 3);
                return;
            }
            Status status = this.u;
            Status status2 = Status.RUNNING;
            if (status != status2) {
                if (status == Status.COMPLETE) {
                    b(this.q, DataSource.MEMORY_CACHE, false);
                    return;
                }
                Status status3 = Status.WAITING_FOR_SIZE;
                this.u = status3;
                if (n.w(this.f1739k, this.f1740l)) {
                    e(this.f1739k, this.f1740l);
                } else {
                    this.n.getSize(this);
                }
                Status status4 = this.u;
                if ((status4 == status2 || status4 == status3) && k()) {
                    this.n.onLoadStarted(p());
                }
                if (E) {
                    s("finished run method in " + h.a(this.s));
                }
                return;
            }
            throw new IllegalArgumentException("Cannot restart a running request");
        }
    }

    @Override // e.b.a.t.k.o
    public void e(int i2, int i3) {
        Object obj;
        this.b.c();
        Object obj2 = this.f1731c;
        synchronized (obj2) {
            try {
                try {
                    boolean z = E;
                    if (z) {
                        s("Got onSizeReady in " + h.a(this.s));
                    }
                    if (this.u == Status.WAITING_FOR_SIZE) {
                        Status status = Status.RUNNING;
                        this.u = status;
                        float U = this.f1738j.U();
                        this.y = t(i2, U);
                        this.z = t(i3, U);
                        if (z) {
                            s("finished setup for calling load in " + h.a(this.s));
                        }
                        obj = obj2;
                        try {
                            this.r = this.t.g(this.f1735g, this.f1736h, this.f1738j.T(), this.y, this.z, this.f1738j.S(), this.f1737i, this.f1741m, this.f1738j.G(), this.f1738j.W(), this.f1738j.j0(), this.f1738j.e0(), this.f1738j.M(), this.f1738j.c0(), this.f1738j.Y(), this.f1738j.X(), this.f1738j.L(), this, this.p);
                            if (this.u != status) {
                                this.r = null;
                            }
                            if (z) {
                                s("finished onSizeReady in " + h.a(this.s));
                            }
                        } catch (Throwable th) {
                            th = th;
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    obj = obj2;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
    }

    @Override // e.b.a.t.e
    public boolean f() {
        boolean z;
        synchronized (this.f1731c) {
            z = this.u == Status.CLEARED;
        }
        return z;
    }

    @Override // e.b.a.t.i
    public Object g() {
        this.b.c();
        return this.f1731c;
    }

    @Override // e.b.a.t.e
    public boolean h(e eVar) {
        int i2;
        int i3;
        Object obj;
        Class<R> cls;
        a<?> aVar;
        Priority priority;
        int size;
        int i4;
        int i5;
        Object obj2;
        Class<R> cls2;
        a<?> aVar2;
        Priority priority2;
        int size2;
        if (eVar instanceof SingleRequest) {
            synchronized (this.f1731c) {
                i2 = this.f1739k;
                i3 = this.f1740l;
                obj = this.f1736h;
                cls = this.f1737i;
                aVar = this.f1738j;
                priority = this.f1741m;
                List<g<R>> list = this.requestListeners;
                size = list != null ? list.size() : 0;
            }
            SingleRequest singleRequest = (SingleRequest) eVar;
            synchronized (singleRequest.f1731c) {
                i4 = singleRequest.f1739k;
                i5 = singleRequest.f1740l;
                obj2 = singleRequest.f1736h;
                cls2 = singleRequest.f1737i;
                aVar2 = singleRequest.f1738j;
                priority2 = singleRequest.f1741m;
                List<g<R>> list2 = singleRequest.requestListeners;
                size2 = list2 != null ? list2.size() : 0;
            }
            return i2 == i4 && i3 == i5 && n.c(obj, obj2) && cls.equals(cls2) && aVar.equals(aVar2) && priority == priority2 && size == size2;
        }
        return false;
    }

    @Override // e.b.a.t.e
    public boolean isComplete() {
        boolean z;
        synchronized (this.f1731c) {
            z = this.u == Status.COMPLETE;
        }
        return z;
    }

    @Override // e.b.a.t.e
    public boolean isRunning() {
        boolean z;
        synchronized (this.f1731c) {
            Status status = this.u;
            z = status == Status.RUNNING || status == Status.WAITING_FOR_SIZE;
        }
        return z;
    }

    @Override // e.b.a.t.e
    public void pause() {
        synchronized (this.f1731c) {
            if (isRunning()) {
                clear();
            }
        }
    }
}
