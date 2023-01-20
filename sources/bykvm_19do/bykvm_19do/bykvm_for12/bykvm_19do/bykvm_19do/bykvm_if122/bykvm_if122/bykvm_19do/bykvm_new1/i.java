package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: l  reason: collision with root package name */
    public static final /* synthetic */ boolean f499l = true;
    public long b;

    /* renamed from: c  reason: collision with root package name */
    public final int f500c;

    /* renamed from: d  reason: collision with root package name */
    public final g f501d;

    /* renamed from: e  reason: collision with root package name */
    private List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> f502e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f503f;

    /* renamed from: g  reason: collision with root package name */
    private final b f504g;

    /* renamed from: h  reason: collision with root package name */
    public final a f505h;
    public long a = 0;

    /* renamed from: i  reason: collision with root package name */
    public final c f506i = new c();

    /* renamed from: j  reason: collision with root package name */
    public final c f507j = new c();

    /* renamed from: k  reason: collision with root package name */
    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b f508k = null;

    /* loaded from: classes.dex */
    public final class a implements r {

        /* renamed from: e  reason: collision with root package name */
        public static final /* synthetic */ boolean f509e = true;
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c a = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f510c;

        public a() {
        }

        private void a(boolean z) throws IOException {
            i iVar;
            long min;
            i iVar2;
            synchronized (i.this) {
                i.this.f507j.g();
                while (true) {
                    iVar = i.this;
                    if (iVar.b > 0 || this.f510c || this.b || iVar.f508k != null) {
                        break;
                    }
                    iVar.k();
                }
                iVar.f507j.k();
                i.this.b();
                min = Math.min(i.this.b, this.a.o());
                iVar2 = i.this;
                iVar2.b -= min;
            }
            iVar2.f507j.g();
            try {
                i iVar3 = i.this;
                iVar3.f501d.a(iVar3.f500c, z && min == this.a.o(), this.a, min);
            } finally {
                i.this.f507j.k();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return i.this.f507j;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (!f509e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            this.a.b(cVar, j2);
            while (this.a.o() >= 16384) {
                a(false);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (!f509e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                if (this.b) {
                    return;
                }
                if (!i.this.f505h.f510c) {
                    if (this.a.o() > 0) {
                        while (this.a.o() > 0) {
                            a(true);
                        }
                    } else {
                        i iVar = i.this;
                        iVar.f501d.a(iVar.f500c, true, (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c) null, 0L);
                    }
                }
                synchronized (i.this) {
                    this.b = true;
                }
                i.this.f501d.flush();
                i.this.a();
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            if (!f509e && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            synchronized (i.this) {
                i.this.b();
            }
            while (this.a.o() > 0) {
                a(false);
                i.this.f501d.flush();
            }
        }
    }

    /* loaded from: classes.dex */
    public final class b implements s {

        /* renamed from: g  reason: collision with root package name */
        public static final /* synthetic */ boolean f512g = true;
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c a = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c b = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();

        /* renamed from: c  reason: collision with root package name */
        private final long f513c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f514d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f515e;

        public b(long j2) {
            this.f513c = j2;
        }

        private void h() throws IOException {
            if (this.f514d) {
                throw new IOException("stream closed");
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar = i.this.f508k;
            if (bVar != null) {
                throw new o(bVar);
            }
        }

        private void i() throws IOException {
            i.this.f506i.g();
            while (this.b.o() == 0 && !this.f515e && !this.f514d) {
                try {
                    i iVar = i.this;
                    if (iVar.f508k != null) {
                        break;
                    }
                    iVar.k();
                } finally {
                    i.this.f506i.k();
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            long a;
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            synchronized (i.this) {
                i();
                h();
                if (this.b.o() == 0) {
                    a = -1;
                } else {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar2 = this.b;
                    a = cVar2.a(cVar, Math.min(j2, cVar2.o()));
                    i iVar = i.this;
                    long j3 = iVar.a + a;
                    iVar.a = j3;
                    if (j3 >= iVar.f501d.f464m.c() / 2) {
                        i iVar2 = i.this;
                        iVar2.f501d.a(iVar2.f500c, iVar2.a);
                        i.this.a = 0L;
                    }
                    synchronized (i.this.f501d) {
                        g gVar = i.this.f501d;
                        long j4 = gVar.f462k + a;
                        gVar.f462k = j4;
                        if (j4 >= gVar.f464m.c() / 2) {
                            g gVar2 = i.this.f501d;
                            gVar2.a(0, gVar2.f462k);
                            i.this.f501d.f462k = 0L;
                        }
                    }
                }
            }
            return a;
        }

        public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            if (!f512g && Thread.holdsLock(i.this)) {
                throw new AssertionError();
            }
            while (j2 > 0) {
                synchronized (i.this) {
                    z = this.f515e;
                    z2 = true;
                    z3 = this.b.o() + j2 > this.f513c;
                }
                if (z3) {
                    eVar.skip(j2);
                    i.this.b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.FLOW_CONTROL_ERROR);
                    return;
                } else if (z) {
                    eVar.skip(j2);
                    return;
                } else {
                    long a = eVar.a(this.a, j2);
                    if (a == -1) {
                        throw new EOFException();
                    }
                    j2 -= a;
                    synchronized (i.this) {
                        if (this.b.o() != 0) {
                            z2 = false;
                        }
                        this.b.a(this.a);
                        if (z2) {
                            i.this.notifyAll();
                        }
                    }
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return i.this.f506i;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (i.this) {
                this.f514d = true;
                this.b.j();
                i.this.notifyAll();
            }
            i.this.a();
        }
    }

    /* loaded from: classes.dex */
    public class c extends bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a {
        public c() {
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        public IOException b(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a
        public void i() {
            i.this.b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
        }

        public void k() throws IOException {
            if (h()) {
                throw b((IOException) null);
            }
        }
    }

    public i(int i2, g gVar, boolean z, boolean z2, List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        Objects.requireNonNull(gVar, "connection == null");
        Objects.requireNonNull(list, "requestHeaders == null");
        this.f500c = i2;
        this.f501d = gVar;
        this.b = gVar.n.c();
        b bVar = new b(gVar.f464m.c());
        this.f504g = bVar;
        a aVar = new a();
        this.f505h = aVar;
        bVar.f515e = z2;
        aVar.f510c = z;
    }

    private boolean d(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        if (f499l || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.f508k == null && (!this.f504g.f515e || !this.f505h.f510c)) {
                    this.f508k = bVar;
                    notifyAll();
                    this.f501d.d(this.f500c);
                    return true;
                }
                return false;
            }
        }
        throw new AssertionError();
    }

    public void a() throws IOException {
        boolean z;
        boolean g2;
        if (!f499l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            b bVar = this.f504g;
            if (!bVar.f515e && bVar.f514d) {
                a aVar = this.f505h;
                if (aVar.f510c || aVar.b) {
                    z = true;
                    g2 = g();
                }
            }
            z = false;
            g2 = g();
        }
        if (z) {
            a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b.CANCEL);
        } else if (g2) {
        } else {
            this.f501d.d(this.f500c);
        }
    }

    public void a(long j2) {
        this.b += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, int i2) throws IOException {
        if (!f499l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        this.f504g.a(eVar, i2);
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) throws IOException {
        if (d(bVar)) {
            this.f501d.b(this.f500c, bVar);
        }
    }

    public void a(List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list) {
        boolean z;
        if (!f499l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            z = true;
            this.f503f = true;
            if (this.f502e == null) {
                this.f502e = list;
                z = g();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.f502e);
                arrayList.add(null);
                arrayList.addAll(list);
                this.f502e = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.f501d.d(this.f500c);
    }

    public void b() throws IOException {
        a aVar = this.f505h;
        if (aVar.b) {
            throw new IOException("stream closed");
        }
        if (aVar.f510c) {
            throw new IOException("stream finished");
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar = this.f508k;
        if (bVar != null) {
            throw new o(bVar);
        }
    }

    public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        if (d(bVar)) {
            this.f501d.c(this.f500c, bVar);
        }
    }

    public int c() {
        return this.f500c;
    }

    public void c(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b bVar) {
        synchronized (this) {
            if (this.f508k == null) {
                this.f508k = bVar;
                notifyAll();
            }
        }
    }

    public r d() {
        synchronized (this) {
            if (!this.f503f && !f()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.f505h;
    }

    public s e() {
        return this.f504g;
    }

    public boolean f() {
        return this.f501d.a == ((this.f500c & 1) == 1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001c, code lost:
        if (r2.f503f == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean g() {
        /*
            r2 = this;
            monitor-enter(r2)
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.b r0 = r2.f508k     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L6
            goto L20
        L6:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i$b r0 = r2.f504g     // Catch: java.lang.Throwable -> L23
            boolean r1 = r0.f515e     // Catch: java.lang.Throwable -> L23
            if (r1 != 0) goto L10
            boolean r0 = r0.f514d     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L1e
        L10:
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i$a r0 = r2.f505h     // Catch: java.lang.Throwable -> L23
            boolean r1 = r0.f510c     // Catch: java.lang.Throwable -> L23
            if (r1 != 0) goto L1a
            boolean r0 = r0.b     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L1e
        L1a:
            boolean r0 = r2.f503f     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L20
        L1e:
            r0 = 1
            goto L21
        L20:
            r0 = 0
        L21:
            monitor-exit(r2)
            return r0
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.i.g():boolean");
    }

    public t h() {
        return this.f506i;
    }

    public void i() {
        boolean g2;
        if (!f499l && Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        synchronized (this) {
            this.f504g.f515e = true;
            g2 = g();
            notifyAll();
        }
        if (g2) {
            return;
        }
        this.f501d.d(this.f500c);
    }

    public List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> j() throws IOException {
        List<bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1.c> list;
        synchronized (this) {
            if (!f()) {
                throw new IllegalStateException("servers cannot read response headers");
            }
            this.f506i.g();
            while (this.f502e == null && this.f508k == null) {
                k();
            }
            this.f506i.k();
            list = this.f502e;
            if (list == null) {
                throw new o(this.f508k);
            }
            this.f502e = null;
        }
        return list;
    }

    public void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            throw new InterruptedIOException();
        }
    }

    public t l() {
        return this.f507j;
    }
}
