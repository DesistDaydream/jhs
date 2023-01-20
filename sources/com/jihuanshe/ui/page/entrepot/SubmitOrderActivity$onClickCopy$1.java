package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.ApplyForOrder;
import com.jihuanshe.utils.StringUtil;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$onClickCopy$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SubmitOrderActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderActivity$onClickCopy$1(SubmitOrderActivity submitOrderActivity) {
        super(1);
        this.this$0 = submitOrderActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        StringUtil stringUtil = StringUtil.a;
        ApplyForOrder a0 = this.this$0.a0();
        stringUtil.a(String.valueOf(a0 == null ? null : a0.getCopyStr()));
    }
}
