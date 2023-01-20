package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import com.meizu.cloud.pushsdk.platform.message.SubAliasStatus;

/* loaded from: classes2.dex */
public class d extends com.meizu.cloud.pushsdk.handler.a.a<SubAliasStatus> {
    public d(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    private void c(String str) {
        com.meizu.cloud.pushsdk.util.b.h(d(), d().getPackageName(), str);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 4096;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(SubAliasStatus subAliasStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || subAliasStatus == null) {
            return;
        }
        c().a(d(), subAliasStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        e.p.a.a.a.c("AbstractMessageHandler", "start SubScribeAliasStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBALIAS_STATUS.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public SubAliasStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        SubAliasStatus d2 = !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.d(stringExtra) : (SubAliasStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBALIAS_STATUS);
        if (BasicPushStatus.SUCCESS_CODE.equals(d2.getCode())) {
            c(d2.getAlias());
        }
        return d2;
    }
}
