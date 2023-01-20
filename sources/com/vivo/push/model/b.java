package com.vivo.push.model;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public final class b {
    private String a;

    /* renamed from: d  reason: collision with root package name */
    private String f8142d;
    private long b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f8141c = -1;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8143e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8144f = false;

    public b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.a = str;
            return;
        }
        throw new IllegalAccessError("PushPackageInfo need a non-null pkgName.");
    }

    public final String a() {
        return this.a;
    }

    public final long b() {
        return this.b;
    }

    public final boolean c() {
        return this.f8143e;
    }

    public final boolean d() {
        return this.f8144f;
    }

    public final String toString() {
        return "PushPackageInfo{mPackageName=" + this.a + ", mPushVersion=" + this.b + ", mPackageVersion=" + this.f8141c + ", mInBlackList=" + this.f8143e + ", mPushEnable=" + this.f8144f + "}";
    }

    public final void a(long j2) {
        this.b = j2;
    }

    public final void b(boolean z) {
        this.f8144f = z;
    }

    public final void a(boolean z) {
        this.f8143e = z;
    }

    public final void a(int i2) {
        this.f8141c = i2;
    }

    public final void a(String str) {
        this.f8142d = str;
    }
}
