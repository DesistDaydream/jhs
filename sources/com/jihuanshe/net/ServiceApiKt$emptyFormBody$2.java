package com.jihuanshe.net;

import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import okhttp3.FormBody;

/* loaded from: classes2.dex */
public final class ServiceApiKt$emptyFormBody$2 extends Lambda implements a<FormBody> {
    public static final ServiceApiKt$emptyFormBody$2 INSTANCE = new ServiceApiKt$emptyFormBody$2();

    public ServiceApiKt$emptyFormBody$2() {
        super(0);
    }

    @Override // h.k2.u.a
    @d
    public final FormBody invoke() {
        return new FormBody.Builder(null, 1, null).build();
    }
}
