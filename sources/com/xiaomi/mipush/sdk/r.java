package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.cq;
import com.xiaomi.push.gq;
import com.xiaomi.push.hd;
import com.xiaomi.push.hq;

/* loaded from: classes3.dex */
public class r implements cq {
    private Context a;

    public r(Context context) {
        this.a = context;
    }

    @Override // com.xiaomi.push.cq
    public String a() {
        return b.m74a(this.a).d();
    }

    @Override // com.xiaomi.push.cq
    public void a(hq hqVar, gq gqVar, hd hdVar) {
        ao.a(this.a).a((ao) hqVar, gqVar, hdVar);
    }
}
