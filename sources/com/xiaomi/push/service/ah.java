package com.xiaomi.push.service;

import android.text.TextUtils;
import com.bytedance.msdk.api.reward.RewardItem;
import com.xiaomi.push.db;
import com.xiaomi.push.ed;
import com.xiaomi.push.eo;
import com.xiaomi.push.eq;
import com.xiaomi.push.fc;
import com.xiaomi.push.fq;
import com.xiaomi.push.fr;
import com.xiaomi.push.fs;
import com.xiaomi.push.ft;
import com.xiaomi.push.gi;
import com.xiaomi.push.service.aj;
import java.util.Date;

/* loaded from: classes3.dex */
public class ah {
    private XMPushService a;

    public ah(XMPushService xMPushService) {
        this.a = xMPushService;
    }

    private void a(fq fqVar) {
        String c2 = fqVar.c();
        if (TextUtils.isEmpty(c2)) {
            return;
        }
        String[] split = c2.split(";");
        com.xiaomi.push.bu a = com.xiaomi.push.by.a().a(fc.a(), false);
        if (a == null || split.length <= 0) {
            return;
        }
        a.a(split);
        this.a.a(20, (Exception) null);
        this.a.a(true);
    }

    private void b(ft ftVar) {
        aj.b b;
        String m2 = ftVar.m();
        String l2 = ftVar.l();
        if (TextUtils.isEmpty(m2) || TextUtils.isEmpty(l2) || (b = aj.a().b(l2, m2)) == null) {
            return;
        }
        gi.a(this.a, b.a, gi.a(ftVar.c()), true, true, System.currentTimeMillis());
    }

    private void c(eq eqVar) {
        aj.b b;
        String j2 = eqVar.j();
        String num = Integer.toString(eqVar.c());
        if (TextUtils.isEmpty(j2) || TextUtils.isEmpty(num) || (b = aj.a().b(num, j2)) == null) {
            return;
        }
        gi.a(this.a, b.a, eqVar.l(), true, true, System.currentTimeMillis());
    }

    public void a(eq eqVar) {
        if (5 != eqVar.c()) {
            c(eqVar);
        }
        try {
            b(eqVar);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("handle Blob chid = " + eqVar.c() + " cmd = " + eqVar.a() + " packetid = " + eqVar.h() + " failure ", e2);
        }
    }

    public void a(ft ftVar) {
        if (!"5".equals(ftVar.l())) {
            b(ftVar);
        }
        String l2 = ftVar.l();
        if (TextUtils.isEmpty(l2)) {
            l2 = "1";
            ftVar.l("1");
        }
        if (l2.equals("0")) {
            com.xiaomi.a.a.a.c.a("Received wrong packet with chid = 0 : " + ftVar.c());
        }
        if (ftVar instanceof fr) {
            fq p = ftVar.p("kick");
            if (p != null) {
                String m2 = ftVar.m();
                String a = p.a("type");
                String a2 = p.a(RewardItem.KEY_REASON);
                com.xiaomi.a.a.a.c.a("kicked by server, chid=" + l2 + " res=" + aj.b.a(m2) + " type=" + a + " reason=" + a2);
                if (!"wait".equals(a)) {
                    this.a.a(l2, m2, 3, a2, a);
                    aj.a().a(l2, m2);
                    return;
                }
                aj.b b = aj.a().b(l2, m2);
                if (b != null) {
                    this.a.a(b);
                    b.a(aj.c.unbind, 3, 0, a2, a);
                    return;
                }
                return;
            }
        } else if (ftVar instanceof fs) {
            fs fsVar = (fs) ftVar;
            if ("redir".equals(fsVar.a())) {
                fq p2 = fsVar.p("hosts");
                if (p2 != null) {
                    a(p2);
                    return;
                }
                return;
            }
        }
        this.a.e().a(this.a, l2, ftVar);
    }

    public void b(eq eqVar) {
        StringBuilder sb;
        String c2;
        String str;
        aj.c cVar;
        int i2;
        int i3;
        String a = eqVar.a();
        if (eqVar.c() != 0) {
            String num = Integer.toString(eqVar.c());
            if (!"SECMSG".equals(eqVar.a())) {
                if (!"BIND".equals(a)) {
                    if ("KICK".equals(a)) {
                        db.g a2 = db.g.a(eqVar.k());
                        String j2 = eqVar.j();
                        String a3 = a2.a();
                        String c3 = a2.c();
                        com.xiaomi.a.a.a.c.a("kicked by server, chid=" + num + " res= " + aj.b.a(j2) + " type=" + a3 + " reason=" + c3);
                        if (!"wait".equals(a3)) {
                            this.a.a(num, j2, 3, c3, a3);
                            aj.a().a(num, j2);
                            return;
                        }
                        aj.b b = aj.a().b(num, j2);
                        if (b != null) {
                            this.a.a(b);
                            b.a(aj.c.unbind, 3, 0, c3, a3);
                            return;
                        }
                        return;
                    }
                    return;
                }
                db.d a4 = db.d.a(eqVar.k());
                String j3 = eqVar.j();
                aj.b b2 = aj.a().b(num, j3);
                if (b2 == null) {
                    return;
                }
                if (a4.a()) {
                    com.xiaomi.a.a.a.c.a("SMACK: channel bind succeeded, chid=" + eqVar.c());
                    b2.a(aj.c.binded, 1, 0, (String) null, (String) null);
                    return;
                }
                String c4 = a4.c();
                if ("auth".equals(c4)) {
                    if ("invalid-sig".equals(a4.e())) {
                        com.xiaomi.a.a.a.c.a("SMACK: bind error invalid-sig token = " + b2.f9075c + " sec = " + b2.f9081i);
                        eo.a(0, ed.BIND_INVALID_SIG.a(), 1, null, 0);
                    }
                    cVar = aj.c.unbind;
                    i2 = 1;
                    i3 = 5;
                } else if (!"cancel".equals(c4)) {
                    if ("wait".equals(c4)) {
                        this.a.a(b2);
                        b2.a(aj.c.unbind, 1, 7, a4.e(), c4);
                    }
                    str = "SMACK: channel bind failed, chid=" + num + " reason=" + a4.e();
                    com.xiaomi.a.a.a.c.a(str);
                } else {
                    cVar = aj.c.unbind;
                    i2 = 1;
                    i3 = 7;
                }
                b2.a(cVar, i2, i3, a4.e(), c4);
                aj.a().a(num, j3);
                str = "SMACK: channel bind failed, chid=" + num + " reason=" + a4.e();
                com.xiaomi.a.a.a.c.a(str);
            } else if (!eqVar.d()) {
                this.a.e().a(this.a, num, eqVar);
                return;
            } else {
                sb = new StringBuilder();
                sb.append("Recv SECMSG errCode = ");
                sb.append(eqVar.e());
                sb.append(" errStr = ");
                c2 = eqVar.f();
            }
        } else if ("PING".equals(a)) {
            byte[] k2 = eqVar.k();
            if (k2 != null && k2.length > 0) {
                db.j a5 = db.j.a(k2);
                if (a5.c()) {
                    ay.a().a(a5.d());
                }
            }
            if (!"com.xiaomi.xmsf".equals(this.a.getPackageName())) {
                this.a.a();
            }
            if ("1".equals(eqVar.h())) {
                com.xiaomi.a.a.a.c.a("received a server ping");
            } else {
                eo.b();
            }
            this.a.i();
            return;
        } else if ("SYNC".equals(a)) {
            if ("CONF".equals(eqVar.b())) {
                ay.a().a(db.b.a(eqVar.k()));
                return;
            } else if (TextUtils.equals("U", eqVar.b())) {
                db.k a6 = db.k.a(eqVar.k());
                com.xiaomi.push.cj.a(this.a).a(a6.a(), a6.c(), new Date(a6.e()), new Date(a6.g()), a6.m() * 1024, a6.i());
                eq eqVar2 = new eq();
                eqVar2.a(0);
                eqVar2.a(eqVar.a(), "UCA");
                eqVar2.a(eqVar.h());
                XMPushService xMPushService = this.a;
                xMPushService.a(new aw(xMPushService, eqVar2));
                return;
            } else if (!TextUtils.equals("P", eqVar.b())) {
                return;
            } else {
                db.i a7 = db.i.a(eqVar.k());
                eq eqVar3 = new eq();
                eqVar3.a(0);
                eqVar3.a(eqVar.a(), "PCA");
                eqVar3.a(eqVar.h());
                db.i iVar = new db.i();
                if (a7.b()) {
                    iVar.a(a7.a());
                }
                eqVar3.a(iVar.z(), (String) null);
                XMPushService xMPushService2 = this.a;
                xMPushService2.a(new aw(xMPushService2, eqVar3));
                sb = new StringBuilder();
                sb.append("ACK msgP: id = ");
                c2 = eqVar.h();
            }
        } else if (!"NOTIFY".equals(eqVar.a())) {
            return;
        } else {
            db.h a8 = db.h.a(eqVar.k());
            sb = new StringBuilder();
            sb.append("notify by server err = ");
            sb.append(a8.a());
            sb.append(" desc = ");
            c2 = a8.c();
        }
        sb.append(c2);
        str = sb.toString();
        com.xiaomi.a.a.a.c.a(str);
    }
}
