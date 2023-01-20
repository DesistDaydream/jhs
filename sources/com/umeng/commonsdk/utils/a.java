package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    private static final int f7596e = 1;
    private final long a;
    private final long b;

    /* renamed from: c  reason: collision with root package name */
    private long f7597c;

    /* renamed from: f  reason: collision with root package name */
    private HandlerThread f7599f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f7600g;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7598d = false;

    /* renamed from: h  reason: collision with root package name */
    private Handler.Callback f7601h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f7598d) {
                    return true;
                }
                long elapsedRealtime = a.this.f7597c - SystemClock.elapsedRealtime();
                if (elapsedRealtime > 0) {
                    if (elapsedRealtime < a.this.b) {
                        a.this.f7600g.sendMessageDelayed(a.this.f7600g.obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        a.this.a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + a.this.b) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += a.this.b;
                        }
                        a.this.f7600g.sendMessageDelayed(a.this.f7600g.obtainMessage(1), elapsedRealtime3);
                    }
                } else {
                    a.this.c();
                    if (a.this.f7599f != null) {
                        a.this.f7599f.quit();
                    }
                }
                return false;
            }
        }
    };

    public a(long j2, long j3) {
        this.a = j2;
        this.b = j3;
        if (!d()) {
            HandlerThread handlerThread = new HandlerThread("CountDownTimerThread");
            this.f7599f = handlerThread;
            handlerThread.start();
            this.f7600g = new Handler(this.f7599f.getLooper(), this.f7601h);
            return;
        }
        this.f7600g = new Handler(this.f7601h);
    }

    public abstract void a(long j2);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f7598d = true;
        this.f7600g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f7598d = false;
        if (this.a <= 0) {
            c();
            return this;
        }
        this.f7597c = SystemClock.elapsedRealtime() + this.a;
        Handler handler = this.f7600g;
        handler.sendMessage(handler.obtainMessage(1));
        return this;
    }
}
