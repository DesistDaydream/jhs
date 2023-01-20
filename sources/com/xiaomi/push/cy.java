package com.xiaomi.push;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

/* loaded from: classes3.dex */
public class cy extends cx {
    public cy(Context context, int i2) {
        super(context, i2);
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "23";
    }

    @Override // com.xiaomi.push.cx
    public String b() {
        return "ram:" + ii.b() + Constants.ACCEPT_TIME_SEPARATOR_SP + "rom:" + ii.d() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "ramOriginal:" + ii.e() + Constants.ACCEPT_TIME_SEPARATOR_SP + "romOriginal:" + ii.f();
    }

    @Override // com.xiaomi.push.cx
    public gs c() {
        return gs.Storage;
    }
}
