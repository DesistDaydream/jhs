package com.jihuanshe.utils;

import com.m7.imkfsdk.KfStartHelper;
import com.moor.imkf.requesturl.RequestUrl;
import h.k2.u.a;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class KefuUtil$helper$2 extends Lambda implements a<KfStartHelper> {
    public static final KefuUtil$helper$2 INSTANCE = new KefuUtil$helper$2();

    public KefuUtil$helper$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    public final KfStartHelper invoke() {
        RequestUrl.setRequestBasic(RequestUrl.TENCENT_REQUEST);
        return KfStartHelper.getInstance();
    }
}
