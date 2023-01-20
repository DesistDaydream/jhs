package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes2.dex */
public final class h implements c {
    private final b a;
    private final l b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4793c;

    public h(l lVar) {
        this(lVar, new b());
    }

    public h(l lVar, b bVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("sink == null");
        }
        this.a = bVar;
        this.b = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public long a(m mVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j2 = 0;
        while (true) {
            long b = mVar.b(this.a, 2048L);
            if (b == -1) {
                return j2;
            }
            j2 += b;
            a();
        }
    }

    public c a() {
        if (this.f4793c) {
            throw new IllegalStateException("closed");
        }
        long e2 = this.a.e();
        if (e2 > 0) {
            this.b.a(this.a, e2);
        }
        return this;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j2) {
        if (this.f4793c) {
            throw new IllegalStateException("closed");
        }
        this.a.a(bVar, j2);
        a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public b b() {
        return this.a;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c b(e eVar) {
        if (this.f4793c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(eVar);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c b(String str) {
        if (this.f4793c) {
            throw new IllegalStateException("closed");
        }
        this.a.b(str);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c c(byte[] bArr) {
        if (this.f4793c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c c(byte[] bArr, int i2, int i3) {
        if (this.f4793c) {
            throw new IllegalStateException("closed");
        }
        this.a.c(bArr, i2, i3);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() {
        if (this.f4793c) {
            return;
        }
        Throwable th = null;
        try {
            b bVar = this.a;
            long j2 = bVar.b;
            if (j2 > 0) {
                this.b.a(bVar, j2);
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.b.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.f4793c = true;
        if (th != null) {
            o.a(th);
        }
    }

    @Override // com.meizu.cloud.pushsdk.c.g.c
    public c e(long j2) {
        if (this.f4793c) {
            throw new IllegalStateException("closed");
        }
        this.a.e(j2);
        return a();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() {
        if (this.f4793c) {
            throw new IllegalStateException("closed");
        }
        b bVar = this.a;
        long j2 = bVar.b;
        if (j2 > 0) {
            this.b.a(bVar, j2);
        }
        this.b.flush();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
