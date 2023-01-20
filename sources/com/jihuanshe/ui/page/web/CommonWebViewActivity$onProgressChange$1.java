package com.jihuanshe.ui.page.web;

import e.l.s.p.a;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CommonWebViewActivity$onProgressChange$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ CommonWebViewActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CommonWebViewActivity$onProgressChange$1(CommonWebViewActivity commonWebViewActivity) {
        super(1);
        this.this$0 = commonWebViewActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        if (i2 == 100) {
            ((a) this.this$0.L()).t0().setValue(Boolean.valueOf(this.this$0.p0().d()));
        }
    }
}
