package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.d.r;
import java.util.HashMap;

/* loaded from: classes3.dex */
public final class t implements r.a {
    public final /* synthetic */ s a;

    public t(s sVar) {
        this.a = sVar;
    }

    @Override // com.vivo.push.d.r.a
    public final void a() {
        Context context;
        Context context2;
        long l2 = com.vivo.push.e.a().l();
        if (l2 < 1400 && l2 != 1340) {
            com.vivo.push.util.p.b("OnNotificationArrivedTask", "引擎版本太低，不支持正向展示功能，pushEngineSDKVersion：".concat(String.valueOf(l2)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.a.b.f()));
        context = this.a.f8121c.a;
        context2 = this.a.f8121c.a;
        String b = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("app_id", b);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.e.a(6L, hashMap);
    }

    @Override // com.vivo.push.d.r.a
    public final void b() {
        Context context;
        Context context2;
        HashMap hashMap = new HashMap();
        hashMap.put(com.heytap.mcssdk.constant.b.f3335c, String.valueOf(this.a.b.f()));
        context = this.a.f8121c.a;
        context2 = this.a.f8121c.a;
        String b = com.vivo.push.util.z.b(context, context2.getPackageName());
        if (!TextUtils.isEmpty(b)) {
            hashMap.put("remoteAppId", b);
        }
        com.vivo.push.util.e.a(2122L, hashMap);
    }
}
