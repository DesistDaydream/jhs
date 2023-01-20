package com.xiaomi.push.service;

import android.text.TextUtils;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.xiaomi.push.gq;
import com.xiaomi.push.hd;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.ib;
import com.xiaomi.push.service.XMPushService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class co extends XMPushService.j {
    public final /* synthetic */ String a;
    public final /* synthetic */ List b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f9165c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ cn f9166d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public co(cn cnVar, int i2, String str, List list, String str2) {
        super(i2);
        this.f9166d = cnVar;
        this.a = str;
        this.b = list;
        this.f9165c = str2;
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public void a() {
        String a;
        XMPushService xMPushService;
        a = this.f9166d.a(this.a);
        ArrayList<hq> a2 = bc.a(this.b, this.a, a, 32768);
        if (a2 == null) {
            com.xiaomi.a.a.a.c.d("TinyData LongConnUploader.upload Get a null XmPushActionNotification list when TinyDataHelper.pack() in XMPushService.");
            return;
        }
        Iterator<hq> it = a2.iterator();
        while (it.hasNext()) {
            hq next = it.next();
            next.a("uploadWay", "longXMPushService");
            hn a3 = j.a(this.a, a, next, gq.Notification);
            if (!TextUtils.isEmpty(this.f9165c) && !TextUtils.equals(this.a, this.f9165c)) {
                if (a3.m() == null) {
                    hd hdVar = new hd();
                    hdVar.a(GMNetworkPlatformConst.AD_NETWORK_NO_PRICE);
                    a3.a(hdVar);
                }
                a3.m().b("ext_traffic_source_pkg", this.f9165c);
            }
            byte[] a4 = ib.a(a3);
            xMPushService = this.f9166d.a;
            xMPushService.a(this.a, a4, true);
        }
    }

    @Override // com.xiaomi.push.service.XMPushService.j
    public String b() {
        return "Send tiny data.";
    }
}
