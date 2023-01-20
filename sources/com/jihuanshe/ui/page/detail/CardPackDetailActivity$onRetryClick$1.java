package com.jihuanshe.ui.page.detail;

import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$onRetryClick$1 extends Lambda implements l<PackDetailResult, t1> {
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$onRetryClick$1(CardPackDetailActivity cardPackDetailActivity) {
        super(1);
        this.this$0 = cardPackDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(PackDetailResult packDetailResult) {
        invoke2(packDetailResult);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e PackDetailResult packDetailResult) {
        this.this$0.D0();
        ((CardPackDetailViewModel) this.this$0.L()).G0(this.this$0.b0(), this.this$0.c0());
    }
}
