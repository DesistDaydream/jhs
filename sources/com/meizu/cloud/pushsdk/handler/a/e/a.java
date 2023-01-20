package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.PushSwitchStatus;

/* loaded from: classes2.dex */
public class a extends com.meizu.cloud.pushsdk.handler.a.a<PushSwitchStatus> {
    public a(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 256;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(PushSwitchStatus pushSwitchStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || pushSwitchStatus == null) {
            return;
        }
        c().a(d(), pushSwitchStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        e.p.a.a.a.c("AbstractMessageHandler", "start PushSwitchStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_PUSH_STATUS.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public PushSwitchStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        PushSwitchStatus c2 = !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.c(stringExtra) : (PushSwitchStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SWITCH_STATUS);
        if (BasicPushStatus.SUCCESS_CODE.equals(c2.getCode())) {
            String g2 = g(intent);
            e.p.a.a.a.f("AbstractMessageHandler", "PushSwitchStatusHandler update local " + g2 + " switch status " + c2);
            com.meizu.cloud.pushsdk.util.b.a(d(), g2, c2.isSwitchNotificationMessage());
            com.meizu.cloud.pushsdk.util.b.b(d(), g2, c2.isSwitchThroughMessage());
        }
        return c2;
    }
}
