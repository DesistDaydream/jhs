package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_new1;

import java.util.concurrent.CountDownLatch;

/* loaded from: classes.dex */
public final class l {
    private final CountDownLatch a = new CountDownLatch(1);
    private long b = -1;

    /* renamed from: c  reason: collision with root package name */
    private long f526c = -1;

    public void a() {
        if (this.f526c == -1) {
            long j2 = this.b;
            if (j2 != -1) {
                this.f526c = j2 - 1;
                this.a.countDown();
                return;
            }
        }
        throw new IllegalStateException();
    }

    public void b() {
        if (this.f526c != -1 || this.b == -1) {
            throw new IllegalStateException();
        }
        this.f526c = System.nanoTime();
        this.a.countDown();
    }

    public void c() {
        if (this.b != -1) {
            throw new IllegalStateException();
        }
        this.b = System.nanoTime();
    }
}
