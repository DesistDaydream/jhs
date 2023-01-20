package com.tencent.bugly.proguard;

import android.os.Handler;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public final class ac implements Runnable {
    private final Handler a;
    private final List<com.tencent.bugly.crashreport.crash.anr.c> b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private long f6673c = 5000;

    /* renamed from: d  reason: collision with root package name */
    private final long f6674d = 5000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6675e = true;

    /* renamed from: f  reason: collision with root package name */
    private long f6676f;

    public ac(Handler handler, String str, long j2) {
        this.a = handler;
    }

    public final void a() {
        if (this.f6675e) {
            this.f6675e = false;
            this.f6676f = SystemClock.uptimeMillis();
            this.a.post(this);
        }
    }

    public final boolean b() {
        return !this.f6675e && SystemClock.uptimeMillis() >= this.f6676f + this.f6673c;
    }

    public final long c() {
        return SystemClock.uptimeMillis() - this.f6676f;
    }

    public final void d() {
        StringBuilder sb = new StringBuilder(1024);
        System.nanoTime();
        try {
            StackTraceElement[] stackTrace = this.a.getLooper().getThread().getStackTrace();
            if (stackTrace.length == 0) {
                sb.append("Thread does not have stack trace.\n");
            } else {
                for (StackTraceElement stackTraceElement : stackTrace) {
                    sb.append(stackTraceElement);
                    sb.append("\n");
                }
            }
        } catch (SecurityException e2) {
            sb.append("getStackTrace() encountered:\n");
            sb.append(e2.getMessage());
            sb.append("\n");
            y.a(e2);
        }
        System.nanoTime();
        com.tencent.bugly.crashreport.crash.anr.c cVar = new com.tencent.bugly.crashreport.crash.anr.c(sb.toString(), System.currentTimeMillis());
        cVar.a(this.a.getLooper().getThread().getName());
        synchronized (this.b) {
            while (this.b.size() >= 32) {
                this.b.remove(0);
            }
            this.b.add(cVar);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f6675e = true;
        this.f6673c = this.f6674d;
    }

    public final List<com.tencent.bugly.crashreport.crash.anr.c> b(long j2) {
        ArrayList arrayList;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.b) {
            arrayList = new ArrayList(this.b.size());
            for (int i2 = 0; i2 < this.b.size(); i2++) {
                com.tencent.bugly.crashreport.crash.anr.c cVar = this.b.get(i2);
                if (!cVar.d() && currentTimeMillis - cVar.c() < 200000) {
                    arrayList.add(cVar);
                    cVar.a(true);
                }
            }
        }
        return arrayList;
    }

    public final void a(long j2) {
        this.f6673c = 5000L;
    }
}
