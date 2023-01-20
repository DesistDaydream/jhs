package com.xiaomi.push;

import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;

/* loaded from: classes3.dex */
public class eh implements aj.b.a {
    private XMPushService a;
    private aj.b b;

    /* renamed from: c */
    private fb f8518c;

    /* renamed from: e */
    private int f8520e;

    /* renamed from: f */
    private boolean f8521f = false;

    /* renamed from: d */
    private aj.c f8519d = aj.c.binding;

    public eh(XMPushService xMPushService, aj.b bVar) {
        this.a = xMPushService;
        this.b = bVar;
    }

    private void b() {
        this.b.b(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c() {
        /*
            r4 = this;
            r4.b()
            boolean r0 = r4.f8521f
            if (r0 != 0) goto L8
            return
        L8:
            int r0 = r4.f8520e
            r1 = 11
            if (r0 != r1) goto Lf
            return
        Lf:
            com.xiaomi.push.em r0 = com.xiaomi.push.em.a()
            com.xiaomi.push.ef r0 = r0.f()
            int[] r1 = com.xiaomi.push.ej.a
            com.xiaomi.push.service.aj$c r2 = r4.f8519d
            int r2 = r2.ordinal()
            r1 = r1[r2]
            r2 = 1
            if (r1 == r2) goto L31
            r3 = 3
            if (r1 == r3) goto L28
            goto L5c
        L28:
            com.xiaomi.push.ed r1 = com.xiaomi.push.ed.BIND_SUCCESS
        L2a:
            int r1 = r1.a()
            r0.b = r1
            goto L5c
        L31:
            int r1 = r4.f8520e
            r3 = 17
            if (r1 != r3) goto L3a
            com.xiaomi.push.ed r1 = com.xiaomi.push.ed.BIND_TCP_READ_TIMEOUT
            goto L2a
        L3a:
            r3 = 21
            if (r1 != r3) goto L41
            com.xiaomi.push.ed r1 = com.xiaomi.push.ed.BIND_TIMEOUT
            goto L2a
        L41:
            com.xiaomi.push.el r1 = com.xiaomi.push.em.b()     // Catch: java.lang.NullPointerException -> L5b
            java.lang.Exception r1 = r1.a()     // Catch: java.lang.NullPointerException -> L5b
            com.xiaomi.push.ek$a r1 = com.xiaomi.push.ek.c(r1)     // Catch: java.lang.NullPointerException -> L5b
            com.xiaomi.push.ed r3 = r1.a     // Catch: java.lang.NullPointerException -> L5b
            int r3 = r3.a()     // Catch: java.lang.NullPointerException -> L5b
            r0.b = r3     // Catch: java.lang.NullPointerException -> L5b
            java.lang.String r1 = r1.b     // Catch: java.lang.NullPointerException -> L5b
            r0.c(r1)     // Catch: java.lang.NullPointerException -> L5b
            goto L5c
        L5b:
            r0 = 0
        L5c:
            if (r0 == 0) goto L83
            com.xiaomi.push.fb r1 = r4.f8518c
            java.lang.String r1 = r1.e()
            r0.b(r1)
            com.xiaomi.push.service.aj$b r1 = r4.b
            java.lang.String r1 = r1.b
            r0.d(r1)
            r0.f8505c = r2
            com.xiaomi.push.service.aj$b r1 = r4.b     // Catch: java.lang.NumberFormatException -> L7c
            java.lang.String r1 = r1.f9080h     // Catch: java.lang.NumberFormatException -> L7c
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L7c
            byte r1 = (byte) r1     // Catch: java.lang.NumberFormatException -> L7c
            r0.a(r1)     // Catch: java.lang.NumberFormatException -> L7c
        L7c:
            com.xiaomi.push.em r1 = com.xiaomi.push.em.a()
            r1.a(r0)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.eh.c():void");
    }

    public void a() {
        this.b.a(this);
        this.f8518c = this.a.h();
    }

    @Override // com.xiaomi.push.service.aj.b.a
    public void a(aj.c cVar, aj.c cVar2, int i2) {
        if (!this.f8521f && cVar == aj.c.binding) {
            this.f8519d = cVar2;
            this.f8520e = i2;
            this.f8521f = true;
        }
        this.a.a(new ei(this, 4));
    }
}
