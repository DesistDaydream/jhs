package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.dialog.CardBaseInfoDetailDialog;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickShowDetail$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickShowDetail$1(CardDetailActivity cardDetailActivity) {
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
        if (((CardDetailViewModel) this.this$0.L()).C0().getValue() == null) {
            return;
        }
        this.this$0.w1(STATConstant.OP_CARD_OR_PACK_DETAIL.CLICK_SHOW_DETAIL);
        CardBaseInfoDetailDialog.a aVar = CardBaseInfoDetailDialog.f3950m;
        int cardID = ((CardDetailViewModel) this.this$0.L()).C0().getValue().getCardID();
        Integer id = ((CardDetailViewModel) this.this$0.L()).C0().getValue().getId();
        int intValue = id == null ? 0 : id.intValue();
        String w0 = this.this$0.w0();
        if (w0 == null) {
            w0 = "";
        }
        aVar.a(cardID, intValue, w0).show(this.this$0.getSupportFragmentManager(), "card_detail");
    }
}
