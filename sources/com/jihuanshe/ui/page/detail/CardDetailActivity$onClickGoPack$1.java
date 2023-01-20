package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.Pack;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickGoPack$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickGoPack$1(CardDetailActivity cardDetailActivity) {
        super(1);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Pack pack;
        Integer packId;
        CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        int i2 = 0;
        if (value != null && (pack = value.getPack()) != null && (packId = pack.getPackId()) != null) {
            i2 = packId.intValue();
        }
        CardPackDetailActivityCreator.create(Integer.valueOf(i2), this.this$0.w0(), this.this$0.x0()).from(STATConstant.PAGE.CARD_DETAIL).start(this.this$0);
    }
}
