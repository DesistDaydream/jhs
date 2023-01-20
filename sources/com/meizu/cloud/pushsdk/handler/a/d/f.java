package com.meizu.cloud.pushsdk.handler.a.d;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.a.c.h;

/* loaded from: classes2.dex */
public class f extends com.meizu.cloud.pushsdk.handler.a.a<h> {
    public f(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 262144;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: a */
    public void b(h hVar) {
        com.meizu.cloud.pushsdk.util.d.b(d(), hVar.c(), hVar.a().b().d(), hVar.a().b().a(), hVar.a().b().e(), hVar.a().b().b());
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(h hVar, com.meizu.cloud.pushsdk.notification.c cVar) {
        NotificationManager notificationManager = (NotificationManager) d().getSystemService(RemoteMessageConst.NOTIFICATION);
        if (notificationManager != null) {
            e.p.a.a.a.f("AbstractMessageHandler", "start cancel notification id " + hVar.b());
            notificationManager.cancel(hVar.b());
            com.meizu.cloud.pushsdk.handler.a.a.a b = com.meizu.cloud.pushsdk.b.a(d()).b();
            if (b != null) {
                b.a(hVar.b());
            }
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        int i2;
        e.p.a.a.a.c("AbstractMessageHandler", "start WithDrawMessageHandler match");
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        if (!TextUtils.isEmpty(stringExtra)) {
            com.meizu.cloud.pushsdk.handler.a.c.b a = com.meizu.cloud.pushsdk.handler.a.c.b.a(stringExtra);
            if (a.a() != null) {
                i2 = a.a().a();
                return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION.equals(String.valueOf(i2));
            }
        }
        i2 = 0;
        if (PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction())) {
            return false;
        }
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public h c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_PUSH_CONTROL_MESSAGE);
        String stringExtra2 = intent.getStringExtra(PushConstants.EXTRA_APP_PUSH_SEQ_ID);
        return new h(intent.getStringExtra(PushConstants.MZ_PUSH_PRIVATE_MESSAGE), g(intent), stringExtra, intent.getStringExtra(PushConstants.MZ_PUSH_MESSAGE_STATISTICS_IMEI_KEY), stringExtra2);
    }
}
