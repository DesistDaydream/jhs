package com.jihuanshe.ui.page.detail;

import androidx.recyclerview.widget.RecyclerView;
import h.k2.u.r;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onViewScroll$1 extends Lambda implements r<RecyclerView, Integer, Integer, Integer, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onViewScroll$1(CardDetailActivity cardDetailActivity) {
        super(4);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.r
    public /* bridge */ /* synthetic */ t1 invoke(RecyclerView recyclerView, Integer num, Integer num2, Integer num3) {
        invoke(recyclerView, num.intValue(), num2.intValue(), num3.intValue());
        return t1.a;
    }

    public final void invoke(@e RecyclerView recyclerView, int i2, int i3, int i4) {
        CardDetailActivity cardDetailActivity = this.this$0;
        cardDetailActivity.r1(cardDetailActivity.T0() + i3);
        if (this.this$0.b1()) {
            return;
        }
        if (this.this$0.a1() && i3 >= 3) {
            CardDetailActivity cardDetailActivity2 = this.this$0;
            cardDetailActivity2.u1(cardDetailActivity2.B0());
        } else if (this.this$0.a1() || i3 >= -3) {
        } else {
            CardDetailActivity cardDetailActivity3 = this.this$0;
            cardDetailActivity3.v1(cardDetailActivity3.B0());
        }
    }
}
