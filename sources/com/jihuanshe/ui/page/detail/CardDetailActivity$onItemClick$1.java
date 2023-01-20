package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onItemClick$1(CardDetailActivity cardDetailActivity) {
        super(2);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        if (value == null) {
            return;
        }
        List<GameCard> value2 = ((CardDetailViewModel) this.this$0.L()).D0().getValue();
        GameCard gameCard = value2 == null ? null : (GameCard) CollectionsKt___CollectionsKt.J2(value2, i2);
        if (gameCard == null) {
            return;
        }
        SellerDetailActivityCreator create = SellerDetailActivityCreator.create(Integer.valueOf(gameCard.getSellerId()), value.getId());
        Integer value3 = ((CardDetailViewModel) this.this$0.L()).K0().getValue();
        create.wish(Boolean.valueOf(value3 == null || value3.intValue() != 0)).start(this.this$0);
    }
}
