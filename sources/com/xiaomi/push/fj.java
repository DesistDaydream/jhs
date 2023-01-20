package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.service.XMPushService;
import java.io.IOException;
import java.net.Socket;

/* loaded from: classes3.dex */
public abstract class fj extends fb {
    public Exception o;
    public Socket p;
    public String q;
    public XMPushService r;
    public volatile long s;
    public volatile long t;
    public volatile long u;
    private String v;
    private int w;
    private long x;

    public fj(XMPushService xMPushService, fc fcVar) {
        super(xMPushService, fcVar);
        this.o = null;
        this.q = null;
        this.s = 0L;
        this.t = 0L;
        this.u = 0L;
        this.x = 0L;
        this.r = xMPushService;
    }

    private void a(fc fcVar) {
        a(fcVar.e(), fcVar.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x033b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(java.lang.String r32, int r33) {
        /*
            Method dump skipped, instructions count: 838
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.fj.a(java.lang.String, int):void");
    }

    public synchronized void a(int i2, Exception exc) {
        if (m() == 2) {
            return;
        }
        a(2, i2, exc);
        this.f8577i = "";
        try {
            this.p.close();
        } catch (Throwable unused) {
        }
        this.s = 0L;
        this.t = 0L;
    }

    public void a(Exception exc) {
        if (SystemClock.elapsedRealtime() - this.u < 300000) {
            if (!al.c(this.r)) {
                return;
            }
            int i2 = this.w + 1;
            this.w = i2;
            if (i2 < 2) {
                return;
            }
            String e2 = e();
            com.xiaomi.a.a.a.c.a("max short conn time reached, sink down current host:" + e2);
            a(e2, 0L, exc);
        }
        this.w = 0;
    }

    public void a(String str, long j2, Exception exc) {
        bu a = by.a().a(fc.a(), false);
        if (a != null) {
            a.b(str, j2, 0L, exc);
            by.a().i();
        }
    }

    public abstract void a(boolean z);

    @Override // com.xiaomi.push.fb
    public void a(eq[] eqVarArr) {
        throw new fn("Don't support send Blob");
    }

    public bu b(String str) {
        bu a = by.a().a(str, false);
        if (!a.b()) {
            gf.a(new fm(this, str));
        }
        return a;
    }

    @Override // com.xiaomi.push.fb
    public void b(int i2, Exception exc) {
        a(i2, exc);
        if ((exc != null || i2 == 18) && this.u != 0) {
            a(exc);
        }
    }

    @Override // com.xiaomi.push.fb
    public void b(boolean z) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long currentTimeMillis = System.currentTimeMillis();
        a(z);
        com.xiaomi.push.service.ck.a(this.r).c();
        if (z) {
            return;
        }
        this.r.a(new fk(this, 13, elapsedRealtime, currentTimeMillis), com.heytap.mcssdk.constant.a.q);
    }

    public synchronized void c() {
    }

    public void c(int i2, Exception exc) {
        this.r.a(new fl(this, 2, i2, exc));
    }

    @Override // com.xiaomi.push.fb
    public String e() {
        return this.v;
    }

    public String p() {
        return this.f8577i;
    }

    public synchronized void q() {
        try {
            if (!k() && !j()) {
                a(0, 0, (Exception) null);
                a(this.f8580l);
                return;
            }
            com.xiaomi.a.a.a.c.a("WARNING: current xmpp has connected");
        } catch (IOException e2) {
            throw new fn(e2);
        }
    }

    public Socket r() {
        return new Socket();
    }

    public void s() {
        this.s = SystemClock.elapsedRealtime();
    }

    public void t() {
        this.t = SystemClock.elapsedRealtime();
    }
}
