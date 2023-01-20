package com.xiaomi.push;

import android.net.TrafficStats;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.xiaomi.push.service.XMPushService;

/* loaded from: classes3.dex */
public class el implements fe {
    public XMPushService a;
    public fb b;

    /* renamed from: c */
    private int f8522c;

    /* renamed from: d */
    private Exception f8523d;

    /* renamed from: j */
    private long f8529j;

    /* renamed from: k */
    private long f8530k;

    /* renamed from: f */
    private long f8525f = 0;

    /* renamed from: g */
    private long f8526g = 0;

    /* renamed from: h */
    private long f8527h = 0;

    /* renamed from: i */
    private long f8528i = 0;

    /* renamed from: e */
    private String f8524e = "";

    public el(XMPushService xMPushService) {
        this.f8529j = 0L;
        this.f8530k = 0L;
        this.a = xMPushService;
        c();
        int myUid = Process.myUid();
        try {
            this.f8530k = TrafficStats.getUidRxBytes(myUid);
            this.f8529j = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("Failed to obtain traffic data during initialization: " + e2);
            this.f8530k = -1L;
            this.f8529j = -1L;
        }
    }

    private void c() {
        this.f8526g = 0L;
        this.f8528i = 0L;
        this.f8525f = 0L;
        this.f8527h = 0L;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (al.c(this.a)) {
            this.f8525f = elapsedRealtime;
        }
        if (this.a.f()) {
            this.f8527h = elapsedRealtime;
        }
    }

    private synchronized void d() {
        com.xiaomi.a.a.a.c.c("stat connpt = " + this.f8524e + " netDuration = " + this.f8526g + " ChannelDuration = " + this.f8528i + " channelConnectedTime = " + this.f8527h);
        ef efVar = new ef();
        efVar.a = (byte) 0;
        efVar.a(ed.CHANNEL_ONLINE_RATE.a());
        efVar.a(this.f8524e);
        efVar.d((int) (System.currentTimeMillis() / 1000));
        efVar.b((int) (this.f8526g / 1000));
        efVar.c((int) (this.f8528i / 1000));
        em.a().a(efVar);
        c();
    }

    public Exception a() {
        return this.f8523d;
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar) {
        this.f8522c = 0;
        this.f8523d = null;
        this.b = fbVar;
        this.f8524e = al.l(this.a);
        eo.a(0, ed.CONN_SUCCESS.a());
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, int i2, Exception exc) {
        long j2;
        if (this.f8522c == 0 && this.f8523d == null) {
            this.f8522c = i2;
            this.f8523d = exc;
            eo.b(fbVar.e(), exc);
        }
        if (i2 == 22 && this.f8527h != 0) {
            long g2 = fbVar.g() - this.f8527h;
            if (g2 < 0) {
                g2 = 0;
            }
            this.f8528i += g2 + (fi.c() / 2);
            this.f8527h = 0L;
        }
        b();
        int myUid = Process.myUid();
        long j3 = -1;
        try {
            j3 = TrafficStats.getUidRxBytes(myUid);
            j2 = TrafficStats.getUidTxBytes(myUid);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("Failed to obtain traffic data: " + e2);
            j2 = -1L;
        }
        com.xiaomi.a.a.a.c.c("Stats rx=" + (j3 - this.f8530k) + ", tx=" + (j2 - this.f8529j));
        this.f8530k = j3;
        this.f8529j = j2;
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, Exception exc) {
        eo.a(0, ed.CHANNEL_CON_FAIL.a(), 1, fbVar.e(), al.d(this.a) ? 1 : 0);
        b();
    }

    public synchronized void b() {
        XMPushService xMPushService = this.a;
        if (xMPushService == null) {
            return;
        }
        String l2 = al.l(xMPushService);
        boolean d2 = al.d(this.a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = this.f8525f;
        if (j2 > 0) {
            this.f8526g += elapsedRealtime - j2;
            this.f8525f = 0L;
        }
        long j3 = this.f8527h;
        if (j3 != 0) {
            this.f8528i += elapsedRealtime - j3;
            this.f8527h = 0L;
        }
        if (d2) {
            if ((!TextUtils.equals(this.f8524e, l2) && this.f8526g > JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS) || this.f8526g > 5400000) {
                d();
            }
            this.f8524e = l2;
            if (this.f8525f == 0) {
                this.f8525f = elapsedRealtime;
            }
            if (this.a.f()) {
                this.f8527h = elapsedRealtime;
            }
        }
    }

    @Override // com.xiaomi.push.fe
    public void b(fb fbVar) {
        b();
        this.f8527h = SystemClock.elapsedRealtime();
        eo.a(0, ed.CONN_SUCCESS.a(), fbVar.e(), fbVar.l());
    }
}
