package com.meizu.cloud.pushsdk.handler.a.e;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;

/* loaded from: classes2.dex */
public class e extends com.meizu.cloud.pushsdk.handler.a.a<SubTagsStatus> {
    public e(Context context, com.meizu.cloud.pushsdk.handler.a aVar) {
        super(context, aVar);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public int a() {
        return 2048;
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    public void a(SubTagsStatus subTagsStatus, com.meizu.cloud.pushsdk.notification.c cVar) {
        if (c() == null || subTagsStatus == null) {
            return;
        }
        c().a(d(), subTagsStatus);
    }

    @Override // com.meizu.cloud.pushsdk.handler.c
    public boolean a(Intent intent) {
        e.p.a.a.a.c("AbstractMessageHandler", "start SubScribeTagsStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS.equals(k(intent));
    }

    @Override // com.meizu.cloud.pushsdk.handler.a.a
    /* renamed from: l */
    public SubTagsStatus c(Intent intent) {
        String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
        return !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.e(stringExtra) : (SubTagsStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS);
    }
}
