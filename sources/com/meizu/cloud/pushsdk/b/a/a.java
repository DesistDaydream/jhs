package com.meizu.cloud.pushsdk.b.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import androidx.core.app.NotificationCompat;

/* loaded from: classes2.dex */
public class a {
    private AlarmManager a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Runnable f4624c;

    /* renamed from: d  reason: collision with root package name */
    private long f4625d;

    /* renamed from: e  reason: collision with root package name */
    private int f4626e;

    /* renamed from: f  reason: collision with root package name */
    private C0154a f4627f;

    /* renamed from: g  reason: collision with root package name */
    private PendingIntent f4628g;

    /* renamed from: h  reason: collision with root package name */
    private String f4629h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f4630i;

    /* renamed from: com.meizu.cloud.pushsdk.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0154a extends BroadcastReceiver {
        private C0154a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null || !intent.getAction().equals("alarm.util")) {
                return;
            }
            e.p.a.a.a.c("AlarmUtils", "on receive delayed task, keyword: " + a.this.f4629h);
            a.this.f4630i = true;
            a.this.c();
            a.this.f4624c.run();
        }
    }

    public a(Context context, Runnable runnable, long j2) {
        this(context, runnable, j2, true);
    }

    public a(Context context, Runnable runnable, long j2, boolean z) {
        Context applicationContext = context.getApplicationContext();
        this.b = applicationContext;
        this.f4624c = runnable;
        this.f4625d = j2;
        this.f4626e = !z ? 1 : 0;
        this.a = (AlarmManager) applicationContext.getSystemService(NotificationCompat.CATEGORY_ALARM);
        this.f4630i = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        try {
            C0154a c0154a = this.f4627f;
            if (c0154a != null) {
                this.b.unregisterReceiver(c0154a);
                this.f4627f = null;
            }
        } catch (Exception e2) {
            e.p.a.a.a.f("AlarmUtils", "clean error, " + e2.getMessage());
        }
    }

    public boolean a() {
        if (!this.f4630i) {
            e.p.a.a.a.f("AlarmUtils", "last task not completed");
            return false;
        }
        this.f4630i = false;
        C0154a c0154a = new C0154a();
        this.f4627f = c0154a;
        this.b.registerReceiver(c0154a, new IntentFilter("alarm.util"));
        this.f4629h = String.valueOf(System.currentTimeMillis());
        this.f4628g = PendingIntent.getBroadcast(this.b, 0, new Intent("alarm.util"), 1073741824);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 23) {
            this.a.setExactAndAllowWhileIdle(this.f4626e, System.currentTimeMillis() + this.f4625d, this.f4628g);
        } else if (i2 >= 19) {
            this.a.setExact(this.f4626e, System.currentTimeMillis() + this.f4625d, this.f4628g);
        } else {
            this.a.set(this.f4626e, System.currentTimeMillis() + this.f4625d, this.f4628g);
        }
        e.p.a.a.a.c("AlarmUtils", "start delayed task, keyword: " + this.f4629h);
        return true;
    }

    public void b() {
        if (this.a != null && this.f4628g != null && !this.f4630i) {
            e.p.a.a.a.c("AlarmUtils", "cancel  delayed task, keyword: " + this.f4629h);
            this.a.cancel(this.f4628g);
        }
        c();
    }
}
