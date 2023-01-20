package com.bytedance.pangle.res.a;

import java.io.InputStream;

/* loaded from: classes.dex */
public final class e extends j {
    private long a;

    public e(InputStream inputStream) {
        super(inputStream);
    }

    @Override // com.bytedance.pangle.res.a.j
    public final synchronized void a(int i2) {
        if (i2 != -1) {
            this.a += i2;
        }
    }

    public final synchronized long b() {
        return this.a;
    }

    @Override // com.bytedance.pangle.res.a.j, java.io.FilterInputStream, java.io.InputStream
    public final synchronized long skip(long j2) {
        long skip;
        skip = super.skip(j2);
        this.a += skip;
        return skip;
    }

    public final int a() {
        long b = b();
        if (b <= 2147483647L) {
            return (int) b;
        }
        throw new ArithmeticException("The byte count " + b + " is too large to be converted to an int");
    }
}
