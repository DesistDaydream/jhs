package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gq;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hq;

/* loaded from: classes3.dex */
public class MiPushClient4VR {
    public static void uploadData(Context context, String str) {
        hq hqVar = new hq();
        hqVar.c(ha.VRUpload.ah);
        hqVar.b(b.m74a(context).m75a());
        hqVar.d(context.getPackageName());
        hqVar.a("data", str);
        hqVar.a(com.xiaomi.push.service.ag.a());
        ao.a(context).a((ao) hqVar, gq.Notification, (hd) null);
    }
}
