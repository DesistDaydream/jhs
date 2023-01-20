package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$onClickCardMore$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$onClickCardMore$1(CardPackDetailActivity cardPackDetailActivity) {
        super(1);
        this.this$0 = cardPackDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        PackDetailResult value = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
        if ((value == null ? null : value.getCardVersions()) == null) {
            return;
        }
        PackDetailResult value2 = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
        if (!(value2 != null ? value2.getCardVersions() : null).isEmpty()) {
            CardPackListActivityCreator.create(((CardPackDetailViewModel) this.this$0.L()).B0().getValue(), this.this$0.b0(), this.this$0.c0()).from(STATConstant.PAGE.PACK_DETAIL).start(this.this$0);
        }
    }
}
