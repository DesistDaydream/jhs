package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CoinActivity$onClickQA$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CoinActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoinActivity$onClickQA$1(CoinActivity coinActivity) {
        super(1);
        this.this$0 = coinActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=balance").start(this.this$0);
    }
}
