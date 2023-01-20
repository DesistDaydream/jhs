package com.xiaomi.push;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.xiaomi.push.dy;

/* loaded from: classes3.dex */
public class dz implements dy.a {
    public Context a;
    private PendingIntent b = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile long f8477c = 0;

    public dz(Context context) {
        this.a = null;
        this.a = context;
    }

    private void a(AlarmManager alarmManager, long j2, PendingIntent pendingIntent) {
        try {
            AlarmManager.class.getMethod("setExact", Integer.TYPE, Long.TYPE, PendingIntent.class).invoke(alarmManager, 2, Long.valueOf(j2), pendingIntent);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d("[Alarm] invoke setExact method meet error. " + e2);
        }
    }

    @Override // com.xiaomi.push.dy.a
    public void a() {
        if (this.b != null) {
            try {
                ((AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(this.b);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.b = null;
                com.xiaomi.a.a.a.c.c("[Alarm] unregister timer");
                this.f8477c = 0L;
                throw th;
            }
            this.b = null;
            com.xiaomi.a.a.a.c.c("[Alarm] unregister timer");
            this.f8477c = 0L;
        }
        this.f8477c = 0L;
    }

    public void a(Intent intent, long j2) {
        AlarmManager alarmManager = (AlarmManager) this.a.getSystemService(NotificationCompat.CATEGORY_ALARM);
        int i2 = Build.VERSION.SDK_INT;
        this.b = i2 >= 31 ? PendingIntent.getBroadcast(this.a, 0, intent, 33554432) : PendingIntent.getBroadcast(this.a, 0, intent, 0);
        if (i2 >= 23) {
            am.a((Object) alarmManager, "setExactAndAllowWhileIdle", 2, Long.valueOf(j2), this.b);
        } else {
            a(alarmManager, j2, this.b);
        }
        com.xiaomi.a.a.a.c.c("[Alarm] register timer " + j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
        if (r8.f8477c < r4) goto L17;
     */
    @Override // com.xiaomi.push.dy.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(boolean r9) {
        /*
            r8 = this;
            android.content.Context r0 = r8.a
            com.xiaomi.push.service.ck r0 = com.xiaomi.push.service.ck.a(r0)
            long r0 = r0.e()
            r2 = 0
            if (r9 != 0) goto L15
            long r4 = r8.f8477c
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 != 0) goto L15
            return
        L15:
            if (r9 == 0) goto L1a
            r8.a()
        L1a:
            long r4 = android.os.SystemClock.elapsedRealtime()
            if (r9 != 0) goto L39
            long r6 = r8.f8477c
            int r9 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r9 != 0) goto L27
            goto L39
        L27:
            long r2 = r8.f8477c
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 > 0) goto L3f
            long r2 = r8.f8477c
            long r2 = r2 + r0
            r8.f8477c = r2
            long r2 = r8.f8477c
            int r9 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r9 >= 0) goto L3f
            goto L3c
        L39:
            long r2 = r4 % r0
            long r0 = r0 - r2
        L3c:
            long r4 = r4 + r0
            r8.f8477c = r4
        L3f:
            android.content.Intent r9 = new android.content.Intent
            java.lang.String r0 = com.xiaomi.push.service.an.p
            r9.<init>(r0)
            android.content.Context r0 = r8.a
            java.lang.String r0 = r0.getPackageName()
            r9.setPackage(r0)
            long r0 = r8.f8477c
            r8.a(r9, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.dz.a(boolean):void");
    }

    @Override // com.xiaomi.push.dy.a
    public boolean b() {
        return this.f8477c != 0;
    }
}
