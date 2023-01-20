package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122;

import android.text.TextUtils;
import com.bytedance.msdk.adapter.util.Logger;

/* loaded from: classes.dex */
public class a implements b {
    private final String a = a.class.getSimpleName();
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f1006c;

    /* renamed from: d  reason: collision with root package name */
    private String f1007d;

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void c(String str) {
        this.f1007d = str;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public boolean h() {
        return TextUtils.isEmpty(this.f1007d);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long i() {
        String str = this.a;
        Logger.i(str, "getIfUseNewSdkinit = " + bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a.r().o());
        long j2 = this.f1006c - this.b;
        String str2 = this.a;
        Logger.i(str2, "InitMethodDuration = " + j2);
        return j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void j() {
        this.f1006c = System.currentTimeMillis();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long k() {
        long currentTimeMillis = System.currentTimeMillis() - this.b;
        String str = this.a;
        Logger.i(str, "SplashFillDuration = " + currentTimeMillis);
        return currentTimeMillis;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long l() {
        long currentTimeMillis = System.currentTimeMillis() - this.b;
        String str = this.a;
        Logger.i(str, "SplashRequestDuration = " + currentTimeMillis);
        return currentTimeMillis;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public boolean m() {
        String str = this.f1007d;
        String str2 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a.f928c;
        boolean equals = TextUtils.equals(str, str2);
        String str3 = this.a;
        Logger.i(str3, "canUploadInitDuration = " + equals + " 当sessionId = " + str2 + " 存储的sessionId = " + this.f1007d);
        return !equals;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void n() {
        this.b = System.currentTimeMillis();
    }
}
