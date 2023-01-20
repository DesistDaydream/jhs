package com.jihuanshe.ui.page.detail;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$initObserver$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$initObserver$1(CardDetailActivity cardDetailActivity) {
        super(1);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        boolean z;
        Integer id;
        ListView A0;
        z = this.this$0.X;
        if (z) {
            this.this$0.X = false;
            return;
        }
        CardDetailViewModel cardDetailViewModel = (CardDetailViewModel) this.this$0.L();
        CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        a R0 = CardDetailViewModel.R0(cardDetailViewModel, (value == null || (id = value.getId()) == null) ? 0 : id.intValue(), this.this$0.w0(), this.this$0.x0(), null, 8, null);
        CardDetailActivity cardDetailActivity = this.this$0;
        A0 = cardDetailActivity.A0();
        BinderKt.p(BinderKt.e(R0, cardDetailActivity, A0, false, 4, null));
    }
}
