package com.xiaomi.push.service;

import com.xiaomi.mipush.sdk.ErrorCode;
import com.xiaomi.push.fn;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.aj;
import java.util.Collection;

/* loaded from: classes3.dex */
public class cs extends XMPushService.j {
    private XMPushService a;
    private byte[] b;

    /* renamed from: c  reason: collision with root package name */
    private String f9175c;

    /* renamed from: d  reason: collision with root package name */
    private String f9176d;

    /* renamed from: e  reason: collision with root package name */
    private String f9177e;

    public cs(XMPushService xMPushService, String str, String str2, String str3, byte[] bArr) {
        super(9);
        this.a = xMPushService;
        this.f9175c = str;
        this.b = bArr;
        this.f9176d = str2;
        this.f9177e = str3;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        aj.b next;
        cp a = cq.a(this.a);
        if (a == null) {
            try {
                a = cq.a(this.a, this.f9175c, this.f9176d, this.f9177e);
            } catch (Exception e2) {
                com.xiaomi.a.a.a.c.d("fail to register push account. " + e2);
            }
        }
        if (a == null) {
            com.xiaomi.a.a.a.c.d("no account for registration.");
            ct.a(this.a, ErrorCode.ERROR_AUTHERICATION_ERROR, "no account.");
            return;
        }
        com.xiaomi.a.a.a.c.a("do registration now.");
        Collection<aj.b> c2 = aj.a().c("5");
        if (c2.isEmpty()) {
            next = a.a(this.a);
            j.a(this.a, next);
            aj.a().a(next);
        } else {
            next = c2.iterator().next();
        }
        if (!this.a.f()) {
            ct.a(this.f9175c, this.b);
            this.a.a(true);
            return;
        }
        try {
            aj.c cVar = next.f9085m;
            if (cVar == aj.c.binded) {
                j.a(this.a, this.f9175c, this.b);
            } else if (cVar == aj.c.unbind) {
                ct.a(this.f9175c, this.b);
                XMPushService xMPushService = this.a;
                xMPushService.getClass();
                xMPushService.a(new XMPushService.b(next));
            }
        } catch (fn e3) {
            com.xiaomi.a.a.a.c.d("meet error, disconnect connection. " + e3);
            this.a.a(10, e3);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "register app";
    }
}
