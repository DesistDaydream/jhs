package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class t {

    /* renamed from: d  reason: collision with root package name */
    public static final t f296d = new a();
    private boolean a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f297c;

    /* loaded from: classes.dex */
    public static final class a extends t {
        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
        public t a(long j2) {
            return this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
        public t a(long j2, TimeUnit timeUnit) {
            return this;
        }

        @Override // bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t
        public void e() throws IOException {
        }
    }

    public t a() {
        this.a = false;
        return this;
    }

    public t a(long j2) {
        this.a = true;
        this.b = j2;
        return this;
    }

    public t a(long j2, TimeUnit timeUnit) {
        if (j2 >= 0) {
            if (timeUnit != null) {
                this.f297c = timeUnit.toNanos(j2);
                return this;
            }
            throw new IllegalArgumentException("unit == null");
        }
        throw new IllegalArgumentException("timeout < 0: " + j2);
    }

    public t b() {
        this.f297c = 0L;
        return this;
    }

    public long c() {
        if (this.a) {
            return this.b;
        }
        throw new IllegalStateException("No deadline");
    }

    public boolean d() {
        return this.a;
    }

    public void e() throws IOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        } else if (this.a && this.b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public long f() {
        return this.f297c;
    }
}
