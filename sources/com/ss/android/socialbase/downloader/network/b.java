package com.ss.android.socialbase.downloader.network;

import android.net.TrafficStats;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes3.dex */
public class b {
    public static volatile boolean a = false;
    private static final String b = "b";

    /* renamed from: g  reason: collision with root package name */
    private static long f5856g = -1;

    /* renamed from: h  reason: collision with root package name */
    private static volatile b f5857h;

    /* renamed from: c  reason: collision with root package name */
    private final k f5858c = k.a();

    /* renamed from: d  reason: collision with root package name */
    private final AtomicInteger f5859d = new AtomicInteger();

    /* renamed from: e  reason: collision with root package name */
    private final a f5860e = new a(com.ss.android.socialbase.downloader.h.e.a());

    /* renamed from: f  reason: collision with root package name */
    private long f5861f;

    /* loaded from: classes3.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a() {
            sendEmptyMessage(1);
        }

        public void b() {
            removeMessages(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                return;
            }
            b.this.f();
            sendEmptyMessageDelayed(1, 1000L);
        }
    }

    private b() {
    }

    public static b a() {
        if (f5857h == null) {
            synchronized (b.class) {
                if (f5857h == null) {
                    f5857h = new b();
                }
            }
        }
        return f5857h;
    }

    public static long d() {
        return TrafficStats.getTotalRxBytes() - TrafficStats.getMobileRxBytes();
    }

    public static void e() {
        a = com.ss.android.socialbase.downloader.i.f.b(com.ss.android.socialbase.downloader.downloader.c.N());
    }

    public void b() {
        try {
            String str = b;
            com.ss.android.socialbase.downloader.c.a.c(str, "startSampling: mSamplingCounter = " + this.f5859d);
            if (this.f5859d.getAndIncrement() == 0) {
                this.f5860e.a();
                this.f5861f = SystemClock.uptimeMillis();
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        try {
            String str = b;
            com.ss.android.socialbase.downloader.c.a.c(str, "stopSampling: mSamplingCounter = " + this.f5859d);
            if (this.f5859d.decrementAndGet() == 0) {
                this.f5860e.b();
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public void f() {
        long mobileRxBytes;
        try {
            e();
            if (a) {
                mobileRxBytes = d();
            } else {
                mobileRxBytes = TrafficStats.getMobileRxBytes();
            }
            long j2 = f5856g;
            long j3 = mobileRxBytes - j2;
            if (j2 >= 0) {
                synchronized (this) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    this.f5858c.a(j3, uptimeMillis - this.f5861f);
                    this.f5861f = uptimeMillis;
                }
            }
            f5856g = mobileRxBytes;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void g() {
        f();
        f5856g = -1L;
    }
}
