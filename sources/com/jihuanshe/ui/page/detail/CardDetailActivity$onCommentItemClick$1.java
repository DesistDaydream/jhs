package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.stat.STATConstant;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onCommentItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onCommentItemClick$1(CardDetailActivity cardDetailActivity) {
        super(2);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        this.this$0.X0();
        this.this$0.w1(STATConstant.OP_CARD_OR_PACK_DETAIL.CLICK_HOT_REVIEW);
    }
}
