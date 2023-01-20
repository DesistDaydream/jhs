package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.dy;
import com.xiaomi.push.service.XMJobService;

@TargetApi(21)
/* loaded from: classes3.dex */
public class ea implements dy.a {
    public Context a;
    public JobScheduler b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8478c = false;

    public ea(Context context) {
        this.a = context;
        this.b = (JobScheduler) context.getSystemService("jobscheduler");
    }

    @Override // com.xiaomi.push.dy.a
    public void a() {
        this.f8478c = false;
        this.b.cancel(1);
    }

    public void a(long j2) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j2);
        builder.setOverrideDeadline(j2);
        builder.setRequiredNetworkType(1);
        builder.setPersisted(false);
        JobInfo build = builder.build();
        com.xiaomi.a.a.a.c.c("schedule Job = " + build.getId() + " in " + j2);
        this.b.schedule(builder.build());
    }

    @Override // com.xiaomi.push.dy.a
    public void a(boolean z) {
        if (z || this.f8478c) {
            long c2 = fi.c();
            if (z) {
                a();
                c2 -= SystemClock.elapsedRealtime() % c2;
            }
            this.f8478c = true;
            a(c2);
        }
    }

    @Override // com.xiaomi.push.dy.a
    public boolean b() {
        return this.f8478c;
    }
}
