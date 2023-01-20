package com.meizu.cloud.pushsdk.c.g;

import androidx.annotation.NonNull;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes2.dex */
public final class i implements d {
    private final b a;
    private final m b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4794c;

    public i(m mVar) {
        this(mVar, new b());
    }

    public i(m mVar, b bVar) {
        if (mVar == null) {
            throw new IllegalArgumentException("source == null");
        }
        this.a = bVar;
        this.b = mVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m
    public long b(b bVar, long j2) {
        if (bVar != null) {
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            } else if (this.f4794c) {
                throw new IllegalStateException("closed");
            } else {
                b bVar2 = this.a;
                if (bVar2.b == 0 && this.b.b(bVar2, 2048L) == -1) {
                    return -1L;
                }
                return this.a.b(bVar, Math.min(j2, this.a.b));
            }
        }
        throw new IllegalArgumentException("sink == null");
    }

    @Override // com.meizu.cloud.pushsdk.c.g.m, java.lang.AutoCloseable
    public void close() {
        if (this.f4794c) {
            return;
        }
        this.f4794c = true;
        this.b.close();
        this.a.j();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public InputStream d() {
        return new InputStream() { // from class: com.meizu.cloud.pushsdk.c.g.i.1
            @Override // java.io.InputStream
            public int available() {
                if (i.this.f4794c) {
                    throw new IOException("closed");
                }
                return (int) Math.min(i.this.a.b, 2147483647L);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                i.this.close();
            }

            @Override // java.io.InputStream
            public int read() {
                if (i.this.f4794c) {
                    throw new IOException("closed");
                }
                if (i.this.a.b == 0 && i.this.b.b(i.this.a, 2048L) == -1) {
                    return -1;
                }
                return i.this.a.f() & 255;
            }

            @Override // java.io.InputStream
            public int read(@NonNull byte[] bArr, int i2, int i3) {
                if (i.this.f4794c) {
                    throw new IOException("closed");
                }
                o.a(bArr.length, i2, i3);
                if (i.this.a.b == 0 && i.this.b.b(i.this.a, 2048L) == -1) {
                    return -1;
                }
                return i.this.a.a(bArr, i2, i3);
            }

            public String toString() {
                return i.this + ".inputStream()";
            }
        };
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public String h() {
        this.a.a(this.b);
        return this.a.h();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.d
    public byte[] i() {
        this.a.a(this.b);
        return this.a.i();
    }

    public String toString() {
        return "buffer(" + this.b + ")";
    }
}
