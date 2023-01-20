package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_try19;

import android.os.Handler;

/* loaded from: classes.dex */
public abstract class a implements Runnable {
    private Handler a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private final long f1214c;

    public a(Handler handler, long j2, long j3) {
        this.a = handler;
        this.b = j2;
        this.f1214c = j3;
    }

    public void a() {
        int i2 = (b() > 0L ? 1 : (b() == 0L ? 0 : -1));
        Handler handler = this.a;
        if (i2 > 0) {
            handler.postDelayed(this, b());
        } else {
            handler.post(this);
        }
    }

    public void a(long j2) {
        if (j2 > 0) {
            this.a.postDelayed(this, j2);
        } else {
            this.a.post(this);
        }
    }

    public long b() {
        return this.b;
    }

    public long c() {
        return this.f1214c;
    }
}
