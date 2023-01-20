package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$chooseFilter$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ int $index;
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$chooseFilter$1(CardDetailActivity cardDetailActivity, int i2) {
        super(1);
        this.this$0 = cardDetailActivity;
        this.$index = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        ((CardDetailViewModel) this.this$0.L()).L0().setValue(Integer.valueOf(this.$index));
        this.this$0.w1(STATConstant.OP_CARD_OR_PACK_DETAIL.CHANGE_PRICE_RANGE);
    }
}
