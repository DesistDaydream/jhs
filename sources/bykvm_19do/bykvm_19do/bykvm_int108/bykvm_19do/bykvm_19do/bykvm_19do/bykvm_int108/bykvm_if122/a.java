package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_int108.bykvm_if122;

import com.baidu.mobads.sdk.internal.bc;

/* loaded from: classes.dex */
public class a {
    public final int a;
    public final int b;

    public a(int i2, int i3, long j2) {
        if (i3 < i2) {
            throw new IllegalStateException("atMostBatchSendCount should meet a condition (atMostBatchSendCount >= maxCacheCount)");
        }
        this.a = i2;
        this.b = i3;
    }

    public static a a(int i2, int i3, long j2) {
        return new a(i2, i3, j2);
    }

    public static a c() {
        return new a(1, 100, bc.f1470e);
    }

    public int a() {
        return this.b;
    }

    public int b() {
        return this.a;
    }
}
