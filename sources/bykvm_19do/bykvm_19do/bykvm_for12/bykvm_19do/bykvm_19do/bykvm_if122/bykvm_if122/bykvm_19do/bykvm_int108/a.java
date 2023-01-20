package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.i;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.a0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.h;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.k;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.v;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.y;
import com.caverock.androidsvg.SVG;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class a implements bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c {
    public final v a;
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g b;

    /* renamed from: c  reason: collision with root package name */
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e f398c;

    /* renamed from: d  reason: collision with root package name */
    public final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d f399d;

    /* renamed from: e  reason: collision with root package name */
    public int f400e = 0;

    /* renamed from: f  reason: collision with root package name */
    private long f401f = SVG.F;

    /* loaded from: classes.dex */
    public abstract class b implements s {
        public final i a;
        public boolean b;

        /* renamed from: c  reason: collision with root package name */
        public long f402c;

        private b() {
            this.a = new i(a.this.f398c.b());
            this.f402c = 0L;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            try {
                long a = a.this.f398c.a(cVar, j2);
                if (a > 0) {
                    this.f402c += a;
                }
                return a;
            } catch (IOException e2) {
                a(false, e2);
                throw e2;
            }
        }

        public final void a(boolean z, IOException iOException) throws IOException {
            a aVar = a.this;
            int i2 = aVar.f400e;
            if (i2 == 6) {
                return;
            }
            if (i2 != 5) {
                throw new IllegalStateException("state: " + a.this.f400e);
            }
            aVar.a(this.a);
            a aVar2 = a.this;
            aVar2.f400e = 6;
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = aVar2.b;
            if (gVar != null) {
                gVar.a(!z, aVar2, this.f402c, iOException);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public t b() {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public final class c implements r {
        private final i a;
        private boolean b;

        public c() {
            this.a = new i(a.this.f399d.b());
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            if (j2 == 0) {
                return;
            }
            a.this.f399d.e(j2);
            a.this.f399d.a("\r\n");
            a.this.f399d.b(cVar, j2);
            a.this.f399d.a("\r\n");
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (this) {
                if (!this.b) {
                    this.b = true;
                    a.this.f399d.a("0\r\n\r\n");
                    a.this.a(this.a);
                    a.this.f400e = 3;
                }
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            synchronized (this) {
                if (!this.b) {
                    a.this.f399d.flush();
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends b {

        /* renamed from: e  reason: collision with root package name */
        private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s f405e;

        /* renamed from: f  reason: collision with root package name */
        private long f406f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f407g;

        public d(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s sVar) {
            super();
            this.f406f = -1L;
            this.f407g = true;
            this.f405e = sVar;
        }

        private void h() throws IOException {
            if (this.f406f != -1) {
                a.this.f398c.d();
            }
            try {
                this.f406f = a.this.f398c.g();
                String trim = a.this.f398c.d().trim();
                if (this.f406f < 0 || !(trim.isEmpty() || trim.startsWith(";"))) {
                    throw new ProtocolException("expected chunk size and optional extensions but was \"" + this.f406f + trim + "\"");
                } else if (this.f406f == 0) {
                    this.f407g = false;
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a.this.a.f(), this.f405e, a.this.e());
                    a(true, (IOException) null);
                }
            } catch (NumberFormatException e2) {
                throw new ProtocolException(e2.getMessage());
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f407g) {
                    long j3 = this.f406f;
                    if (j3 == 0 || j3 == -1) {
                        h();
                        if (!this.f407g) {
                            return -1L;
                        }
                    }
                    long a = super.a(cVar, Math.min(j2, this.f406f));
                    if (a != -1) {
                        this.f406f -= a;
                        return a;
                    }
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, (IOException) protocolException);
                    throw protocolException;
                }
                return -1L;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f407g && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    /* loaded from: classes.dex */
    public final class e implements r {
        private final i a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private long f409c;

        public e(long j2) {
            this.a = new i(a.this.f399d.b());
            this.f409c = j2;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public t b() {
            return this.a;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r
        public void b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (this.b) {
                throw new IllegalStateException("closed");
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(cVar.o(), 0L, j2);
            if (j2 <= this.f409c) {
                a.this.f399d.b(cVar, j2);
                this.f409c -= j2;
                return;
            }
            throw new ProtocolException("expected " + this.f409c + " bytes but received " + j2);
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            this.b = true;
            if (this.f409c > 0) {
                throw new ProtocolException("unexpected end of stream");
            }
            a.this.a(this.a);
            a.this.f400e = 3;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.r, java.io.Flushable
        public void flush() throws IOException {
            if (this.b) {
                return;
            }
            a.this.f399d.flush();
        }
    }

    /* loaded from: classes.dex */
    public class f extends b {

        /* renamed from: e  reason: collision with root package name */
        private long f411e;

        public f(a aVar, long j2) throws IOException {
            super();
            this.f411e = j2;
            if (j2 == 0) {
                a(true, (IOException) null);
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else {
                long j3 = this.f411e;
                if (j3 == 0) {
                    return -1L;
                }
                long a = super.a(cVar, Math.min(j3, j2));
                if (a == -1) {
                    ProtocolException protocolException = new ProtocolException("unexpected end of stream");
                    a(false, (IOException) protocolException);
                    throw protocolException;
                }
                long j4 = this.f411e - a;
                this.f411e = j4;
                if (j4 == 0) {
                    a(true, (IOException) null);
                }
                return a;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (this.f411e != 0 && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(this, 100, TimeUnit.MILLISECONDS)) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    /* loaded from: classes.dex */
    public class g extends b {

        /* renamed from: e  reason: collision with root package name */
        private boolean f412e;

        public g(a aVar) {
            super();
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_int108.a.b, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s
        public long a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar, long j2) throws IOException {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.b) {
                throw new IllegalStateException("closed");
            } else {
                if (this.f412e) {
                    return -1L;
                }
                long a = super.a(cVar, j2);
                if (a == -1) {
                    this.f412e = true;
                    a(true, (IOException) null);
                    return -1L;
                }
                return a;
            }
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.b) {
                return;
            }
            if (!this.f412e) {
                a(false, (IOException) null);
            }
            this.b = true;
        }
    }

    public a(v vVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e eVar, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.d dVar) {
        this.a = vVar;
        this.b = gVar;
        this.f398c = eVar;
        this.f399d = dVar;
    }

    private String f() throws IOException {
        String c2 = this.f398c.c(this.f401f);
        this.f401f -= c2.length();
        return c2;
    }

    public r a(long j2) {
        if (this.f400e == 1) {
            this.f400e = 2;
            return new e(j2);
        }
        throw new IllegalStateException("state: " + this.f400e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public r a(y yVar, long j2) {
        if ("chunked".equalsIgnoreCase(yVar.a("Transfer-Encoding"))) {
            return c();
        }
        if (j2 != -1) {
            return a(j2);
        }
        throw new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
    }

    public s a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s sVar) throws IOException {
        if (this.f400e == 4) {
            this.f400e = 5;
            return new d(sVar);
        }
        throw new IllegalStateException("state: " + this.f400e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public a0.a a(boolean z) throws IOException {
        int i2 = this.f400e;
        if (i2 != 1 && i2 != 3) {
            throw new IllegalStateException("state: " + this.f400e);
        }
        try {
            k a = k.a(f());
            a0.a a2 = new a0.a().a(a.a).a(a.b).a(a.f367c).a(e());
            if (z && a.b == 100) {
                return null;
            }
            this.f400e = 4;
            return a2;
        } catch (EOFException e2) {
            IOException iOException = new IOException("unexpected end of stream on " + this.b);
            iOException.initCause(e2);
            throw iOException;
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public b0 a(a0 a0Var) throws IOException {
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = this.b;
        gVar.f390f.e(gVar.f389e);
        String b2 = a0Var.b("Content-Type");
        if (bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.b(a0Var)) {
            if ("chunked".equalsIgnoreCase(a0Var.b("Transfer-Encoding"))) {
                return new h(b2, -1L, l.a(a(a0Var.s().g())));
            }
            long a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.e.a(a0Var);
            return a != -1 ? new h(b2, a, l.a(b(a))) : new h(b2, -1L, l.a(d()));
        }
        return new h(b2, 0L, l.a(b(0L)));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void a() throws IOException {
        this.f399d.flush();
    }

    public void a(i iVar) {
        t g2 = iVar.g();
        iVar.a(t.f296d);
        g2.a();
        g2.b();
    }

    public void a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r rVar, String str) throws IOException {
        if (this.f400e != 0) {
            throw new IllegalStateException("state: " + this.f400e);
        }
        this.f399d.a(str).a("\r\n");
        int b2 = rVar.b();
        for (int i2 = 0; i2 < b2; i2++) {
            this.f399d.a(rVar.a(i2)).a(": ").a(rVar.b(i2)).a("\r\n");
        }
        this.f399d.a("\r\n");
        this.f400e = 1;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void a(y yVar) throws IOException {
        a(yVar.c(), bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.i.a(yVar, this.b.b().a().b().type()));
    }

    public s b(long j2) throws IOException {
        if (this.f400e == 4) {
            this.f400e = 5;
            return new f(this, j2);
        }
        throw new IllegalStateException("state: " + this.f400e);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.c
    public void b() throws IOException {
        this.f399d.flush();
    }

    public r c() {
        if (this.f400e == 1) {
            this.f400e = 2;
            return new c();
        }
        throw new IllegalStateException("state: " + this.f400e);
    }

    public s d() throws IOException {
        if (this.f400e != 4) {
            throw new IllegalStateException("state: " + this.f400e);
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122.g gVar = this.b;
        if (gVar != null) {
            this.f400e = 5;
            gVar.d();
            return new g(this);
        }
        throw new IllegalStateException("streamAllocation == null");
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.r e() throws IOException {
        r.a aVar = new r.a();
        while (true) {
            String f2 = f();
            if (f2.length() == 0) {
                return aVar.a();
            }
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.a.a.a(aVar, f2);
        }
    }
}
