package com.ss.android.socialbase.downloader.notification;

import android.app.Notification;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;

/* loaded from: classes3.dex */
public abstract class a {
    public Notification a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private long f5891c;

    /* renamed from: d  reason: collision with root package name */
    private long f5892d;

    /* renamed from: e  reason: collision with root package name */
    private String f5893e;

    /* renamed from: f  reason: collision with root package name */
    private int f5894f = 0;

    /* renamed from: g  reason: collision with root package name */
    private long f5895g;

    /* renamed from: h  reason: collision with root package name */
    private int f5896h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5897i;

    public a(int i2, String str) {
        this.b = i2;
        this.f5893e = str;
    }

    public abstract void a(BaseException baseException, boolean z);

    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.b = downloadInfo.getId();
        this.f5893e = downloadInfo.getTitle();
    }

    public long b() {
        return this.f5891c;
    }

    public long c() {
        return this.f5892d;
    }

    public String d() {
        return this.f5893e;
    }

    public int e() {
        return this.f5894f;
    }

    public long f() {
        if (this.f5895g == 0) {
            this.f5895g = System.currentTimeMillis();
        }
        return this.f5895g;
    }

    public synchronized void g() {
        this.f5896h++;
    }

    public int h() {
        return this.f5896h;
    }

    public boolean i() {
        return this.f5897i;
    }

    public void b(long j2) {
        this.f5892d = j2;
    }

    public int a() {
        return this.b;
    }

    public void a(long j2) {
        this.f5891c = j2;
    }

    public void a(int i2, BaseException baseException, boolean z) {
        a(i2, baseException, z, false);
    }

    public void a(int i2, BaseException baseException, boolean z, boolean z2) {
        if (z2 || this.f5894f != i2) {
            this.f5894f = i2;
            a(baseException, z);
        }
    }

    public void a(long j2, long j3) {
        this.f5891c = j2;
        this.f5892d = j3;
        this.f5894f = 4;
        a((BaseException) null, false);
    }

    public void a(Notification notification) {
        if (this.b == 0 || notification == null) {
            return;
        }
        b.a().a(this.b, this.f5894f, notification);
    }

    public void a(boolean z) {
        this.f5897i = z;
    }
}
