package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;

/* loaded from: classes.dex */
public final class g {
    public static final /* synthetic */ boolean o = true;
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a a;
    private f.a b;

    /* renamed from: c */
    private c0 f387c;

    /* renamed from: d */
    private final j f388d;

    /* renamed from: e */
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e f389e;

    /* renamed from: f */
    public final p f390f;

    /* renamed from: g */
    private final Object f391g;

    /* renamed from: h */
    private final f f392h;

    /* renamed from: i */
    private int f393i;

    /* renamed from: j */
    private c f394j;

    /* renamed from: k */
    private boolean f395k;

    /* renamed from: l */
    private boolean f396l;

    /* renamed from: m */
    private boolean f397m;
    private bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c n;

    /* loaded from: classes.dex */
    public static final class a extends WeakReference<g> {
        public final Object a;

        public a(g gVar, Object obj) {
            super(gVar);
            this.a = obj;
        }
    }

    public g(j jVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a aVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e eVar, p pVar, Object obj) throws IOException {
        this.f388d = jVar;
        this.a = aVar;
        this.f389e = eVar;
        this.f390f = pVar;
        this.f392h = new f(aVar, g(), eVar, pVar);
        this.f391g = obj;
    }

    private c a(int i2, int i3, int i4, boolean z) throws IOException {
        c cVar;
        Socket f2;
        c cVar2;
        Socket socket;
        c0 c0Var;
        boolean z2;
        boolean z3;
        f.a aVar;
        synchronized (this.f388d) {
            if (this.f396l) {
                throw new IllegalStateException("released");
            }
            if (this.n != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f397m) {
                throw new IOException("Canceled");
            }
            cVar = this.f394j;
            f2 = f();
            cVar2 = this.f394j;
            socket = null;
            if (cVar2 != null) {
                cVar = null;
            } else {
                cVar2 = null;
            }
            if (!this.f395k) {
                cVar = null;
            }
            if (cVar2 == null) {
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f388d, this.a, this, null);
                c cVar3 = this.f394j;
                if (cVar3 != null) {
                    cVar2 = cVar3;
                    z2 = true;
                    c0Var = null;
                } else {
                    c0Var = this.f387c;
                }
            } else {
                c0Var = null;
            }
            z2 = false;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(f2);
        if (cVar != null) {
            this.f390f.b(this.f389e, cVar);
        }
        if (z2) {
            this.f390f.a(this.f389e, cVar2);
        }
        if (cVar2 == null) {
            if (c0Var != null || ((aVar = this.b) != null && aVar.b())) {
                z3 = false;
            } else {
                this.b = this.f392h.b();
                z3 = true;
            }
            synchronized (this.f388d) {
                if (this.f397m) {
                    throw new IOException("Canceled");
                }
                if (z3) {
                    List<c0> a2 = this.b.a();
                    int size = a2.size();
                    int i5 = 0;
                    while (true) {
                        if (i5 >= size) {
                            break;
                        }
                        c0 c0Var2 = a2.get(i5);
                        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f388d, this.a, this, c0Var2);
                        c cVar4 = this.f394j;
                        if (cVar4 != null) {
                            this.f387c = c0Var2;
                            cVar2 = cVar4;
                            z2 = true;
                            break;
                        }
                        i5++;
                    }
                }
                if (!z2) {
                    if (c0Var == null) {
                        c0Var = this.b.c();
                    }
                    this.f387c = c0Var;
                    this.f393i = 0;
                    c cVar5 = new c(this.f388d, c0Var);
                    a(cVar5, false);
                    cVar2 = cVar5;
                }
            }
            if (!z2) {
                cVar2.a(i2, i3, i4, z, this.f389e, this.f390f);
                g().a(cVar2.a());
                synchronized (this.f388d) {
                    this.f395k = true;
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.b(this.f388d, cVar2);
                    if (cVar2.c()) {
                        socket = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f388d, this.a, this);
                        cVar2 = this.f394j;
                    }
                }
                bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(socket);
            }
            this.f390f.a(this.f389e, cVar2);
        }
        return cVar2;
    }

    private c a(int i2, int i3, int i4, boolean z, boolean z2) throws IOException {
        c a2;
        while (true) {
            a2 = a(i2, i3, i4, z);
            synchronized (this.f388d) {
                if (a2.f379l != 0) {
                    if (a2.a(z2)) {
                        break;
                    }
                    d();
                } else {
                    break;
                }
            }
        }
        return a2;
    }

    private Socket a(boolean z, boolean z2, boolean z3) {
        Socket socket;
        if (o || Thread.holdsLock(this.f388d)) {
            if (z3) {
                this.n = null;
            }
            if (z2) {
                this.f396l = true;
            }
            c cVar = this.f394j;
            if (cVar != null) {
                if (z) {
                    cVar.f378k = true;
                }
                if (this.n == null) {
                    if (this.f396l || cVar.f378k) {
                        b(cVar);
                        if (this.f394j.n.isEmpty()) {
                            this.f394j.o = System.nanoTime();
                            if (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f388d, this.f394j)) {
                                socket = this.f394j.e();
                                this.f394j = null;
                                return socket;
                            }
                        }
                        socket = null;
                        this.f394j = null;
                        return socket;
                    }
                    return null;
                }
                return null;
            }
            return null;
        }
        throw new AssertionError();
    }

    private void b(c cVar) {
        int size = cVar.n.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (cVar.n.get(i2).get() == this) {
                cVar.n.remove(i2);
                return;
            }
        }
        throw new IllegalStateException();
    }

    private Socket f() {
        if (o || Thread.holdsLock(this.f388d)) {
            c cVar = this.f394j;
            if (cVar == null || !cVar.f378k) {
                return null;
            }
            return a(false, false, true);
        }
        throw new AssertionError();
    }

    private d g() {
        return bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(this.f388d);
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a() {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c cVar;
        synchronized (this.f388d) {
            cVar = this.n;
        }
        return cVar;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a(v vVar, t.a aVar, boolean z) {
        try {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c a2 = a(aVar.c(), aVar.d(), aVar.a(), vVar.v(), z).a(vVar, aVar, this);
            synchronized (this.f388d) {
                this.n = a2;
            }
            return a2;
        } catch (IOException e2) {
            throw new e(e2);
        }
    }

    public Socket a(c cVar) {
        if (o || Thread.holdsLock(this.f388d)) {
            if (this.n == null && this.f394j.n.size() == 1) {
                Socket a2 = a(true, false, false);
                this.f394j = cVar;
                cVar.n.add(this.f394j.n.get(0));
                return a2;
            }
            throw new IllegalStateException();
        }
        throw new AssertionError();
    }

    public void a(c cVar, boolean z) {
        if (!o && !Thread.holdsLock(this.f388d)) {
            throw new AssertionError();
        }
        if (this.f394j != null) {
            throw new IllegalStateException();
        }
        this.f394j = cVar;
        this.f395k = z;
        cVar.n.add(new a(this, this.f391g));
    }

    /* JADX WARN: Code restructure failed: missing block: B:99:0x001b, code lost:
        if (r6.f393i <= 1) goto L12;
     */
    /* JADX WARN: Removed duplicated region for block: B:117:0x004d A[Catch: all -> 0x0061, TryCatch #0 {, blocks: (B:92:0x0003, B:94:0x000a, B:96:0x0012, B:98:0x0019, B:115:0x0043, B:117:0x004d, B:121:0x0053, B:100:0x001d, B:101:0x0020, B:103:0x0024, B:105:0x002a, B:107:0x002e, B:109:0x0034, B:112:0x003a), top: B:129:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.io.IOException r7) {
        /*
            r6 = this;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.j r0 = r6.f388d
            monitor-enter(r0)
            boolean r1 = r7 instanceof bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.o     // Catch: java.lang.Throwable -> L61
            r2 = 0
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L20
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.o r7 = (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.o) r7     // Catch: java.lang.Throwable -> L61
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b r7 = r7.a     // Catch: java.lang.Throwable -> L61
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b r1 = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.REFUSED_STREAM     // Catch: java.lang.Throwable -> L61
            if (r7 != r1) goto L17
            int r5 = r6.f393i     // Catch: java.lang.Throwable -> L61
            int r5 = r5 + r4
            r6.f393i = r5     // Catch: java.lang.Throwable -> L61
        L17:
            if (r7 != r1) goto L1d
            int r7 = r6.f393i     // Catch: java.lang.Throwable -> L61
            if (r7 <= r4) goto L42
        L1d:
            r6.f387c = r3     // Catch: java.lang.Throwable -> L61
            goto L40
        L20:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r1 = r6.f394j     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L42
            boolean r1 = r1.c()     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L2e
            boolean r1 = r7 instanceof bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.a     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L42
        L2e:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r1 = r6.f394j     // Catch: java.lang.Throwable -> L61
            int r1 = r1.f379l     // Catch: java.lang.Throwable -> L61
            if (r1 != 0) goto L40
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0 r1 = r6.f387c     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L1d
            if (r7 == 0) goto L1d
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.f r5 = r6.f392h     // Catch: java.lang.Throwable -> L61
            r5.a(r1, r7)     // Catch: java.lang.Throwable -> L61
            goto L1d
        L40:
            r7 = 1
            goto L43
        L42:
            r7 = 0
        L43:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r1 = r6.f394j     // Catch: java.lang.Throwable -> L61
            java.net.Socket r7 = r6.a(r7, r2, r4)     // Catch: java.lang.Throwable -> L61
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.c r2 = r6.f394j     // Catch: java.lang.Throwable -> L61
            if (r2 != 0) goto L53
            boolean r2 = r6.f395k     // Catch: java.lang.Throwable -> L61
            if (r2 != 0) goto L52
            goto L53
        L52:
            r3 = r1
        L53:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L61
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(r7)
            if (r3 == 0) goto L60
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.p r7 = r6.f390f
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.e r0 = r6.f389e
            r7.b(r0, r3)
        L60:
            return
        L61:
            r7 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L61
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g.a(java.io.IOException):void");
    }

    public void a(boolean z, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c cVar, long j2, IOException iOException) {
        c cVar2;
        Socket a2;
        boolean z2;
        this.f390f.b(this.f389e, j2);
        synchronized (this.f388d) {
            if (cVar != null) {
                if (cVar == this.n) {
                    if (!z) {
                        this.f394j.f379l++;
                    }
                    cVar2 = this.f394j;
                    a2 = a(z, false, true);
                    if (this.f394j != null) {
                        cVar2 = null;
                    }
                    z2 = this.f396l;
                }
            }
            throw new IllegalStateException("expected " + this.n + " but was " + cVar);
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a2);
        if (cVar2 != null) {
            this.f390f.b(this.f389e, cVar2);
        }
        if (iOException != null) {
            this.f390f.a(this.f389e, iOException);
        } else if (z2) {
            this.f390f.a(this.f389e);
        }
    }

    public c b() {
        c cVar;
        synchronized (this) {
            cVar = this.f394j;
        }
        return cVar;
    }

    public boolean c() {
        f.a aVar;
        return this.f387c != null || ((aVar = this.b) != null && aVar.b()) || this.f392h.a();
    }

    public void d() {
        c cVar;
        Socket a2;
        synchronized (this.f388d) {
            cVar = this.f394j;
            a2 = a(true, false, false);
            if (this.f394j != null) {
                cVar = null;
            }
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a2);
        if (cVar != null) {
            this.f390f.b(this.f389e, cVar);
        }
    }

    public void e() {
        c cVar;
        Socket a2;
        synchronized (this.f388d) {
            cVar = this.f394j;
            a2 = a(false, true, false);
            if (this.f394j != null) {
                cVar = null;
            }
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(a2);
        if (cVar != null) {
            this.f390f.b(this.f389e, cVar);
        }
    }

    public String toString() {
        c b = b();
        return b != null ? b.toString() : this.a.toString();
    }
}
