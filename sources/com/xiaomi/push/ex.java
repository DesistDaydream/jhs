package com.xiaomi.push;

import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.db;
import com.xiaomi.push.fb;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;

/* loaded from: classes3.dex */
public class ex extends fj {
    private Thread v;
    private es w;
    private et x;
    private byte[] y;

    public ex(XMPushService xMPushService, fc fcVar) {
        super(xMPushService, fcVar);
    }

    private eq c(boolean z) {
        ew ewVar = new ew();
        if (z) {
            ewVar.a("1");
        }
        byte[] c2 = eo.c();
        if (c2 != null) {
            db.j jVar = new db.j();
            jVar.a(a.a(c2));
            ewVar.a(jVar.z(), (String) null);
        }
        return ewVar;
    }

    private void u() {
        try {
            this.w = new es(((fj) this).p.getInputStream(), this, this.f8581m);
            this.x = new et(((fj) this).p.getOutputStream(), this);
            ey eyVar = new ey(this, "Blob Reader (" + this.f8579k + ")");
            this.v = eyVar;
            eyVar.start();
        } catch (Exception e2) {
            throw new fn("Error to init reader and writer", e2);
        }
    }

    @Override // com.xiaomi.push.fj
    public synchronized void a(int i2, Exception exc) {
        es esVar = this.w;
        if (esVar != null) {
            esVar.b();
            this.w = null;
        }
        et etVar = this.x;
        if (etVar != null) {
            try {
                etVar.b();
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.a(e2);
            }
            this.x = null;
        }
        this.y = null;
        super.a(i2, exc);
    }

    public void a(eq eqVar) {
        if (eqVar == null) {
            return;
        }
        if (eqVar.d()) {
            com.xiaomi.a.a.a.c.a("[Slim] RCV blob chid=" + eqVar.c() + "; id=" + eqVar.h() + "; errCode=" + eqVar.e() + "; err=" + eqVar.f());
        }
        if (eqVar.c() == 0) {
            if ("PING".equals(eqVar.a())) {
                com.xiaomi.a.a.a.c.a("[Slim] RCV ping id=" + eqVar.h());
                t();
            } else if ("CLOSE".equals(eqVar.a())) {
                c(13, null);
            }
        }
        for (fb.a aVar : this.f8574f.values()) {
            aVar.a(eqVar);
        }
    }

    @Override // com.xiaomi.push.fb
    @Deprecated
    public void a(ft ftVar) {
        b(eq.a(ftVar, (String) null));
    }

    @Override // com.xiaomi.push.fb
    public synchronized void a(aj.b bVar) {
        ep.a(bVar, p(), this);
    }

    @Override // com.xiaomi.push.fb
    public synchronized void a(String str, String str2) {
        ep.a(str, str2, this);
    }

    @Override // com.xiaomi.push.fj
    public void a(boolean z) {
        if (this.x == null) {
            throw new fn("The BlobWriter is null.");
        }
        eq c2 = c(z);
        com.xiaomi.a.a.a.c.a("[Slim] SND ping id=" + c2.h());
        b(c2);
        s();
    }

    @Override // com.xiaomi.push.fj, com.xiaomi.push.fb
    public void a(eq[] eqVarArr) {
        for (eq eqVar : eqVarArr) {
            b(eqVar);
        }
    }

    public synchronized byte[] a() {
        if (this.y == null && !TextUtils.isEmpty(this.f8577i)) {
            String e2 = com.xiaomi.push.service.ay.e();
            StringBuilder sb = new StringBuilder();
            String str = this.f8577i;
            sb.append(str.substring(str.length() / 2));
            sb.append(e2.substring(e2.length() / 2));
            this.y = com.xiaomi.push.service.as.a(this.f8577i.getBytes(), sb.toString().getBytes());
        }
        return this.y;
    }

    @Override // com.xiaomi.push.fb
    public void b(eq eqVar) {
        et etVar = this.x;
        if (etVar == null) {
            throw new fn("the writer is null.");
        }
        try {
            int a = etVar.a(eqVar);
            this.n = SystemClock.elapsedRealtime();
            String i2 = eqVar.i();
            if (!TextUtils.isEmpty(i2)) {
                gi.a(this.f8581m, i2, a, false, true, System.currentTimeMillis());
            }
            for (fb.a aVar : this.f8575g.values()) {
                aVar.a(eqVar);
            }
        } catch (Exception e2) {
            throw new fn(e2);
        }
    }

    public void b(ft ftVar) {
        if (ftVar == null) {
            return;
        }
        for (fb.a aVar : this.f8574f.values()) {
            aVar.a(ftVar);
        }
    }

    @Override // com.xiaomi.push.fb
    public boolean b() {
        return true;
    }

    @Override // com.xiaomi.push.fj
    public synchronized void c() {
        u();
        this.x.a();
    }
}
