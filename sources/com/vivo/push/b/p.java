package com.vivo.push.b;

import android.text.TextUtils;
import com.vivo.push.model.InsideNotificationItem;

/* loaded from: classes3.dex */
public final class p extends com.vivo.push.o {
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f8097c;

    /* renamed from: d  reason: collision with root package name */
    private long f8098d;

    /* renamed from: e  reason: collision with root package name */
    private InsideNotificationItem f8099e;

    public p(String str, long j2, InsideNotificationItem insideNotificationItem) {
        super(5);
        this.a = str;
        this.f8098d = j2;
        this.f8099e = insideNotificationItem;
    }

    @Override // com.vivo.push.o
    public final void c(com.vivo.push.a aVar) {
        aVar.a("package_name", this.a);
        aVar.a("notify_id", this.f8098d);
        aVar.a("notification_v1", com.vivo.push.util.q.b(this.f8099e));
        aVar.a("open_pkg_name", this.b);
        aVar.a("open_pkg_name_encode", this.f8097c);
    }

    public final String d() {
        return this.a;
    }

    public final long e() {
        return this.f8098d;
    }

    public final InsideNotificationItem f() {
        return this.f8099e;
    }

    @Override // com.vivo.push.o
    public final String toString() {
        return "OnNotificationClickCommand";
    }

    @Override // com.vivo.push.o
    public final void d(com.vivo.push.a aVar) {
        this.a = aVar.a("package_name");
        this.f8098d = aVar.b("notify_id", -1L);
        this.b = aVar.a("open_pkg_name");
        this.f8097c = aVar.b("open_pkg_name_encode");
        String a = aVar.a("notification_v1");
        if (!TextUtils.isEmpty(a)) {
            this.f8099e = com.vivo.push.util.q.a(a);
        }
        InsideNotificationItem insideNotificationItem = this.f8099e;
        if (insideNotificationItem != null) {
            insideNotificationItem.setMsgId(this.f8098d);
        }
    }

    public p() {
        super(5);
    }
}
