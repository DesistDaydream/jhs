package com.meizu.cloud.pushsdk.c.g;

/* loaded from: classes2.dex */
public abstract class f implements l {
    private final l a;

    public f(l lVar) {
        if (lVar == null) {
            throw new IllegalArgumentException("delegate == null");
        }
        this.a = lVar;
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l
    public void a(b bVar, long j2) {
        this.a.a(bVar, j2);
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Closeable, java.lang.AutoCloseable, com.meizu.cloud.pushsdk.c.g.m
    public void close() {
        this.a.close();
    }

    @Override // com.meizu.cloud.pushsdk.c.g.l, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    public String toString() {
        return getClass().getSimpleName() + "(" + this.a.toString() + ")";
    }
}
