package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.gv;
import com.xiaomi.push.service.ad;

/* loaded from: classes3.dex */
public class g extends ad.a {
    public final /* synthetic */ f a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(f fVar, int i2, String str) {
        super(i2, str);
        this.a = fVar;
    }

    @Override // com.xiaomi.push.service.ad.a
    public void onCallback() {
        Context context;
        boolean z;
        Context context2;
        context = this.a.f48a;
        boolean a = com.xiaomi.push.service.ad.a(context).a(gv.AggregatePushSwitch.a(), true);
        z = this.a.f51a;
        if (z != a) {
            this.a.f51a = a;
            context2 = this.a.f48a;
            i.b(context2);
        }
    }
}
