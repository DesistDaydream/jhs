package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class m {
    private static volatile m a;
    private ScheduledThreadPoolExecutor b = new ScheduledThreadPoolExecutor(1);

    /* renamed from: c  reason: collision with root package name */
    private Map<String, ScheduledFuture> f9028c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    private Object f9029d = new Object();

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f9030e;

    /* loaded from: classes3.dex */
    public static abstract class a implements Runnable {
        public abstract String a();
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {
        public a a;

        public b(a aVar) {
            this.a = aVar;
        }

        public void a() {
        }

        public void b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a();
            this.a.run();
            b();
        }
    }

    private m(Context context) {
        this.f9030e = context.getSharedPreferences("mipush_extra", 0);
    }

    public static m a(Context context) {
        if (a == null) {
            synchronized (m.class) {
                if (a == null) {
                    a = new m(context);
                }
            }
        }
        return a;
    }

    private static String b(String str) {
        return "last_job_time" + str;
    }

    private ScheduledFuture b(a aVar) {
        ScheduledFuture scheduledFuture;
        synchronized (this.f9029d) {
            scheduledFuture = this.f9028c.get(aVar.a());
        }
        return scheduledFuture;
    }

    public void a(Runnable runnable) {
        a(runnable, 0);
    }

    public void a(Runnable runnable, int i2) {
        this.b.schedule(runnable, i2, TimeUnit.SECONDS);
    }

    public boolean a(a aVar) {
        return b(aVar, 0);
    }

    public boolean a(a aVar, int i2) {
        return a(aVar, i2, 0);
    }

    public boolean a(a aVar, int i2, int i3) {
        return a(aVar, i2, i3, false);
    }

    public boolean a(a aVar, int i2, int i3, boolean z) {
        if (aVar == null || b(aVar) != null) {
            return false;
        }
        String b2 = b(aVar.a());
        n nVar = new n(this, aVar, z, b2);
        if (!z) {
            long abs = Math.abs(System.currentTimeMillis() - this.f9030e.getLong(b2, 0L)) / 1000;
            if (abs < i2 - i3) {
                i3 = (int) (i2 - abs);
            }
        }
        try {
            ScheduledFuture<?> scheduleAtFixedRate = this.b.scheduleAtFixedRate(nVar, i3, i2, TimeUnit.SECONDS);
            synchronized (this.f9029d) {
                this.f9028c.put(aVar.a(), scheduleAtFixedRate);
            }
            return true;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return true;
        }
    }

    public boolean a(String str) {
        synchronized (this.f9029d) {
            ScheduledFuture scheduledFuture = this.f9028c.get(str);
            if (scheduledFuture == null) {
                return false;
            }
            this.f9028c.remove(str);
            return scheduledFuture.cancel(false);
        }
    }

    public boolean b(a aVar, int i2) {
        if (aVar == null || b(aVar) != null) {
            return false;
        }
        ScheduledFuture<?> schedule = this.b.schedule(new o(this, aVar), i2, TimeUnit.SECONDS);
        synchronized (this.f9029d) {
            this.f9028c.put(aVar.a(), schedule);
        }
        return true;
    }
}
