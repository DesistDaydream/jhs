package com.tencent.bugly.crashreport.crash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.tencent.bugly.proguard.ab;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.y;

/* loaded from: classes3.dex */
public class BuglyBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: d  reason: collision with root package name */
    private static BuglyBroadcastReceiver f6548d;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f6549c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6550e = true;
    private IntentFilter a = new IntentFilter();

    public static synchronized BuglyBroadcastReceiver getInstance() {
        BuglyBroadcastReceiver buglyBroadcastReceiver;
        synchronized (BuglyBroadcastReceiver.class) {
            if (f6548d == null) {
                f6548d = new BuglyBroadcastReceiver();
            }
            buglyBroadcastReceiver = f6548d;
        }
        return buglyBroadcastReceiver;
    }

    public synchronized void addFilter(String str) {
        if (!this.a.hasAction(str)) {
            this.a.addAction(str);
        }
        y.c("add action %s", str);
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        try {
            a(context, intent);
        } catch (Throwable th) {
            if (y.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    public synchronized void register(Context context) {
        this.b = context;
        ab.a(new Runnable() { // from class: com.tencent.bugly.crashreport.crash.BuglyBroadcastReceiver.1
            @Override // java.lang.Runnable
            public final void run() {
                try {
                    y.a(BuglyBroadcastReceiver.f6548d.getClass(), "Register broadcast receiver of Bugly.", new Object[0]);
                    synchronized (this) {
                        BuglyBroadcastReceiver.this.b.registerReceiver(BuglyBroadcastReceiver.f6548d, BuglyBroadcastReceiver.this.a, "com.tencent.bugly.BuglyBroadcastReceiver.permission", null);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        });
    }

    public synchronized void unregister(Context context) {
        try {
            y.a(getClass(), "Unregister broadcast receiver of Bugly.", new Object[0]);
            context.unregisterReceiver(this);
            this.b = context;
        } catch (Throwable th) {
            if (y.a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    private synchronized boolean a(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (intent.getAction().equals("android.net.conn.CONNECTIVITY_CHANGE")) {
                if (this.f6550e) {
                    this.f6550e = false;
                    return true;
                }
                String b = com.tencent.bugly.crashreport.common.info.b.b(this.b);
                y.c("is Connect BC " + b, new Object[0]);
                y.a("network %s changed to %s", this.f6549c, b);
                if (b == null) {
                    this.f6549c = null;
                    return true;
                }
                String str = this.f6549c;
                this.f6549c = b;
                long currentTimeMillis = System.currentTimeMillis();
                com.tencent.bugly.crashreport.common.strategy.a a = com.tencent.bugly.crashreport.common.strategy.a.a();
                v a2 = v.a();
                com.tencent.bugly.crashreport.common.info.a a3 = com.tencent.bugly.crashreport.common.info.a.a(context);
                if (a != null && a2 != null && a3 != null) {
                    if (!b.equals(str) && currentTimeMillis - a2.a(c.a) > JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS) {
                        y.a("try to upload crash on network changed.", new Object[0]);
                        c a4 = c.a();
                        if (a4 != null) {
                            a4.a(0L);
                        }
                        y.a("try to upload userinfo on network changed.", new Object[0]);
                        com.tencent.bugly.crashreport.biz.b.a.b();
                    }
                    return true;
                }
                y.d("not inited BC not work", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
