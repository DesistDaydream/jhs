package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChangePriceDialog$onClickTip$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChangePriceDialog$onClickTip$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=seller_fee_rate").start(this.$context);
    }
}
