package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.eq;
import com.xiaomi.push.fr;
import com.xiaomi.push.fs;
import com.xiaomi.push.ft;
import com.xiaomi.push.fv;
import com.xiaomi.push.gp;
import com.xiaomi.push.jc;
import com.xiaomi.push.service.aj;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class cf {
    private cu a = new cu();

    public static String a(aj.b bVar) {
        StringBuilder sb;
        String str;
        if ("9".equals(bVar.f9080h)) {
            sb = new StringBuilder();
            sb.append(bVar.a);
            str = ".permission.MIMC_RECEIVE";
        } else {
            sb = new StringBuilder();
            sb.append(bVar.a);
            str = ".permission.MIPUSH_RECEIVE";
        }
        sb.append(str);
        return sb.toString();
    }

    private static void a(Context context, Intent intent, aj.b bVar) {
        if ("com.xiaomi.xmsf".equals(context.getPackageName())) {
            context.sendBroadcast(intent);
        } else {
            context.sendBroadcast(intent, a(bVar));
        }
    }

    public aj.b a(eq eqVar) {
        Collection<aj.b> c2 = aj.a().c(Integer.toString(eqVar.c()));
        if (c2.isEmpty()) {
            return null;
        }
        Iterator<aj.b> it = c2.iterator();
        if (c2.size() == 1) {
            return it.next();
        }
        String j2 = eqVar.j();
        while (it.hasNext()) {
            aj.b next = it.next();
            if (TextUtils.equals(j2, next.b)) {
                return next;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.xiaomi.push.service.aj.b a(com.xiaomi.push.ft r6) {
        /*
            r5 = this;
            com.xiaomi.push.service.aj r0 = com.xiaomi.push.service.aj.a()
            java.lang.String r1 = r6.l()
            java.util.Collection r0 = r0.c(r1)
            boolean r1 = r0.isEmpty()
            r2 = 0
            if (r1 == 0) goto L14
            return r2
        L14:
            java.util.Iterator r1 = r0.iterator()
            int r0 = r0.size()
            r3 = 1
            if (r0 != r3) goto L26
            java.lang.Object r6 = r1.next()
            com.xiaomi.push.service.aj$b r6 = (com.xiaomi.push.service.aj.b) r6
            return r6
        L26:
            java.lang.String r0 = r6.n()
            java.lang.String r6 = r6.m()
        L2e:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L4b
            java.lang.Object r3 = r1.next()
            com.xiaomi.push.service.aj$b r3 = (com.xiaomi.push.service.aj.b) r3
            java.lang.String r4 = r3.b
            boolean r4 = android.text.TextUtils.equals(r0, r4)
            if (r4 != 0) goto L4a
            java.lang.String r4 = r3.b
            boolean r4 = android.text.TextUtils.equals(r6, r4)
            if (r4 == 0) goto L2e
        L4a:
            return r3
        L4b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.cf.a(com.xiaomi.push.ft):com.xiaomi.push.service.aj$b");
    }

    @SuppressLint({"WrongConstant"})
    public void a(Context context) {
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.service_started");
        if (jc.e()) {
            intent.addFlags(16777216);
        }
        com.xiaomi.a.a.a.c.a("[Bcst] send ***.push.service_started broadcast to inform push service has started.");
        context.sendBroadcast(intent);
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, aj.b bVar, int i2) {
        if ("5".equalsIgnoreCase(bVar.f9080h)) {
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_closed");
        intent.setPackage(bVar.a);
        intent.putExtra(an.t, bVar.f9080h);
        intent.putExtra("ext_reason", i2);
        intent.putExtra(an.q, bVar.b);
        intent.putExtra(an.F, bVar.f9082j);
        if (bVar.o == null || !"9".equals(bVar.f9080h)) {
            com.xiaomi.a.a.a.c.a(String.format("[Bcst] notify channel closed. %s,%s,%d", bVar.f9080h, bVar.a, Integer.valueOf(i2)));
            a(context, intent, bVar);
            return;
        }
        try {
            bVar.o.send(Message.obtain(null, 17, intent));
        } catch (RemoteException unused) {
            bVar.o = null;
            StringBuilder sb = new StringBuilder();
            sb.append("peer may died: ");
            String str = bVar.b;
            sb.append(str.substring(str.lastIndexOf(64)));
            com.xiaomi.a.a.a.c.a(sb.toString());
        }
    }

    public void a(Context context, aj.b bVar, String str, String str2) {
        if (bVar == null) {
            com.xiaomi.a.a.a.c.d("error while notify kick by server!");
        } else if ("5".equalsIgnoreCase(bVar.f9080h)) {
            com.xiaomi.a.a.a.c.d("mipush kicked by server");
        } else {
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.kicked");
            intent.setPackage(bVar.a);
            intent.putExtra("ext_kick_type", str);
            intent.putExtra("ext_kick_reason", str2);
            intent.putExtra("ext_chid", bVar.f9080h);
            intent.putExtra(an.q, bVar.b);
            intent.putExtra(an.F, bVar.f9082j);
            com.xiaomi.a.a.a.c.a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", bVar.f9080h, bVar.a, str2));
            a(context, intent, bVar);
        }
    }

    @SuppressLint({"DefaultLocale"})
    public void a(Context context, aj.b bVar, boolean z, int i2, String str) {
        if ("5".equalsIgnoreCase(bVar.f9080h)) {
            this.a.a(context, bVar, z, i2, str);
            return;
        }
        Intent intent = new Intent();
        intent.setAction("com.xiaomi.push.channel_opened");
        intent.setPackage(bVar.a);
        intent.putExtra("ext_succeeded", z);
        if (!z) {
            intent.putExtra("ext_reason", i2);
        }
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("ext_reason_msg", str);
        }
        intent.putExtra("ext_chid", bVar.f9080h);
        intent.putExtra(an.q, bVar.b);
        intent.putExtra(an.F, bVar.f9082j);
        com.xiaomi.a.a.a.c.a(String.format("[Bcst] notify channel open result. %s,%s,%b,%d", bVar.f9080h, bVar.a, Boolean.valueOf(z), Integer.valueOf(i2)));
        a(context, intent, bVar);
    }

    public void a(XMPushService xMPushService, String str, eq eqVar) {
        q qVar;
        aj.b a = a(eqVar);
        if (a == null) {
            com.xiaomi.a.a.a.c.d("error while notify channel closed! channel " + str + " not registered");
        } else if ("5".equalsIgnoreCase(str)) {
            this.a.a(xMPushService, eqVar, a);
        } else {
            String str2 = a.a;
            Intent intent = new Intent();
            intent.setAction("com.xiaomi.push.new_msg");
            intent.setPackage(str2);
            intent.putExtra("ext_rcv_timestamp", SystemClock.elapsedRealtime());
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_raw_packet", eqVar.d(a.f9081i));
            intent.putExtra(an.F, a.f9082j);
            intent.putExtra(an.x, a.f9081i);
            if (a.o != null) {
                try {
                    a.o.send(Message.obtain(null, 17, intent));
                    com.xiaomi.a.a.a.c.a("message was sent by messenger for chid=" + str);
                    return;
                } catch (RemoteException unused) {
                    a.o = null;
                    StringBuilder sb = new StringBuilder();
                    sb.append("peer may died: ");
                    String str3 = a.b;
                    sb.append(str3.substring(str3.lastIndexOf(64)));
                    com.xiaomi.a.a.a.c.a(sb.toString());
                }
            }
            if ("com.xiaomi.xmsf".equals(str2)) {
                return;
            }
            com.xiaomi.a.a.a.c.a(String.format("[Bcst] notify packet(blob) arrival. %s,%s,%s", a.f9080h, a.a, eqVar.h()));
            a(xMPushService, intent, a);
            if (!"10".equals(str) || (qVar = eqVar.f8538c) == null) {
                return;
            }
            qVar.f9192h = System.currentTimeMillis();
            if (gp.a(xMPushService, 1)) {
                bc.a("category_coord_down", "coord_down", "com.xiaomi.xmsf", eqVar.f8538c);
            }
        }
    }

    public void a(XMPushService xMPushService, String str, ft ftVar) {
        String str2;
        String str3;
        aj.b a = a(ftVar);
        if (a != null) {
            if ("5".equalsIgnoreCase(str)) {
                this.a.a(xMPushService, ftVar, a);
                return;
            }
            String str4 = a.a;
            if (ftVar instanceof fs) {
                str3 = "com.xiaomi.push.new_msg";
            } else if (ftVar instanceof fr) {
                str3 = "com.xiaomi.push.new_iq";
            } else if (ftVar instanceof fv) {
                str3 = "com.xiaomi.push.new_pres";
            } else {
                str2 = "unknown packet type, drop it";
            }
            Intent intent = new Intent();
            intent.setAction(str3);
            intent.setPackage(str4);
            intent.putExtra("ext_chid", str);
            intent.putExtra("ext_packet", ftVar.b());
            intent.putExtra(an.F, a.f9082j);
            intent.putExtra(an.x, a.f9081i);
            com.xiaomi.a.a.a.c.a(String.format("[Bcst] notify packet arrival. %s,%s,%s", a.f9080h, a.a, ftVar.k()));
            a(xMPushService, intent, a);
            return;
        }
        str2 = "error while notify channel closed! channel " + str + " not registered";
        com.xiaomi.a.a.a.c.d(str2);
    }
}
