package com.ss.android.socialbase.downloader.f;

import androidx.annotation.NonNull;

/* loaded from: classes3.dex */
public class b implements c, d, e {
    private final int a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final Object f5648c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Object f5649d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private a f5650e;

    /* renamed from: f  reason: collision with root package name */
    private a f5651f;

    /* renamed from: g  reason: collision with root package name */
    private a f5652g;

    /* renamed from: h  reason: collision with root package name */
    private a f5653h;

    /* renamed from: i  reason: collision with root package name */
    private a f5654i;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f5655j;

    /* renamed from: k  reason: collision with root package name */
    private int f5656k;

    public b(int i2, int i3) {
        i2 = i2 < 64 ? 64 : i2;
        i3 = i3 < 8192 ? 8192 : i3;
        this.a = i2;
        this.b = i3;
    }

    @Override // com.ss.android.socialbase.downloader.f.d
    @NonNull
    public a a() throws p, InterruptedException {
        a aVar;
        a aVar2 = this.f5654i;
        if (aVar2 != null) {
            this.f5654i = aVar2.f5647d;
            aVar2.f5647d = null;
            return aVar2;
        }
        synchronized (this.f5649d) {
            aVar = this.f5652g;
            while (aVar == null) {
                if (!this.f5655j) {
                    this.f5649d.wait();
                    aVar = this.f5652g;
                } else {
                    throw new p("read");
                }
            }
            this.f5654i = aVar.f5647d;
            this.f5653h = null;
            this.f5652g = null;
            aVar.f5647d = null;
        }
        return aVar;
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    @NonNull
    public a b() throws p, InterruptedException {
        synchronized (this.f5648c) {
            if (!this.f5655j) {
                a aVar = this.f5650e;
                if (aVar == null) {
                    int i2 = this.f5656k;
                    if (i2 < this.a) {
                        this.f5656k = i2 + 1;
                        return new a(this.b);
                    }
                    do {
                        this.f5648c.wait();
                        if (!this.f5655j) {
                            aVar = this.f5650e;
                        } else {
                            throw new p("obtain");
                        }
                    } while (aVar == null);
                }
                this.f5650e = aVar.f5647d;
                if (aVar == this.f5651f) {
                    this.f5651f = null;
                }
                aVar.f5647d = null;
                return aVar;
            }
            throw new p("obtain");
        }
    }

    public void c() {
        this.f5655j = true;
        synchronized (this.f5648c) {
            this.f5648c.notifyAll();
        }
        synchronized (this.f5649d) {
            this.f5649d.notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.c
    public void a(@NonNull a aVar) {
        synchronized (this.f5648c) {
            a aVar2 = this.f5651f;
            if (aVar2 == null) {
                this.f5651f = aVar;
                this.f5650e = aVar;
            } else {
                aVar2.f5647d = aVar;
                this.f5651f = aVar;
            }
            this.f5648c.notify();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.e
    public void b(@NonNull a aVar) {
        synchronized (this.f5649d) {
            a aVar2 = this.f5653h;
            if (aVar2 == null) {
                this.f5653h = aVar;
                this.f5652g = aVar;
                this.f5649d.notify();
            } else {
                aVar2.f5647d = aVar;
                this.f5653h = aVar;
            }
        }
    }
}
