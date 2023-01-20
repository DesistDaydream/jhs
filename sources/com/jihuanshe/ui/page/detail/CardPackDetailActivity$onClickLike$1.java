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
public final class CardPackDetailActivity$onClickLike$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$onClickLike$1(CardPackDetailActivity cardPackDetailActivity) {
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
        Integer id;
        Integer id2;
        this.this$0.C0(STATConstant.OP_CARD_OR_PACK_DETAIL.CLICK_LIKE);
        PackDetailResult value = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
        int i2 = 0;
        if ((value == null || value.isLike()) ? false : true) {
            CardPackDetailViewModel cardPackDetailViewModel = (CardPackDetailViewModel) this.this$0.L();
            PackDetailResult value2 = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
            if (value2 != null && (id2 = value2.getId()) != null) {
                i2 = id2.intValue();
            }
            cardPackDetailViewModel.H0(i2, this.this$0.b0());
            return;
        }
        CardPackDetailViewModel cardPackDetailViewModel2 = (CardPackDetailViewModel) this.this$0.L();
        PackDetailResult value3 = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
        if (value3 != null && (id = value3.getId()) != null) {
            i2 = id.intValue();
        }
        cardPackDetailViewModel2.K0(i2, this.this$0.b0());
    }
}
