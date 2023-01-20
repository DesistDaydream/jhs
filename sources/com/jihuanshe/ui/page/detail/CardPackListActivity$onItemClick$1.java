package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.viewmodel.detail.CardPackListViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackListActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ CardPackListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackListActivity$onItemClick$1(CardPackListActivity cardPackListActivity) {
        super(2);
        this.this$0 = cardPackListActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<GameCard> value = ((CardPackListViewModel) this.this$0.L()).t0().getValue();
        GameCard gameCard = value == null ? null : (GameCard) CollectionsKt___CollectionsKt.J2(value, i2);
        if (gameCard == null) {
            return;
        }
        CardDetailActivityCreator.create(Integer.valueOf(gameCard.getVersionId()), this.this$0.b0(), this.this$0.c0()).from(STATConstant.PAGE.PACK_CARD_LIST).start(this.this$0);
    }
}
