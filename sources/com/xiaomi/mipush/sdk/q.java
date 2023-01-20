package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.di;
import com.xiaomi.push.gv;
import com.xiaomi.push.service.ad;

/* loaded from: classes3.dex */
public final class q extends ad.a {
    public final /* synthetic */ Context a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(int i2, String str, Context context) {
        super(i2, str);
        this.a = context;
    }

    @Override // com.xiaomi.push.service.ad.a
    public void onCallback() {
        di.a(this.a).a(com.xiaomi.push.service.ad.a(this.a).a(gv.AwakeInfoUploadWaySwitch.a(), 0));
    }
}
