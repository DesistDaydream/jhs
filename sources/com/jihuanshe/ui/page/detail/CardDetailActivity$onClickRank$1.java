package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.CardDetailInfo;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Ranking;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.page.rank.RankActivityCreator;
import com.jihuanshe.viewmodel.detail.CardDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onClickRank$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onClickRank$1(CardDetailActivity cardDetailActivity) {
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
        Ranking ranking;
        Ranking ranking2;
        CardDetailInfo value = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        Integer num = null;
        if ((value == null ? null : value.getRanking()) == null) {
            return;
        }
        this.this$0.w1(STATConstant.OP_CARD_OR_PACK_DETAIL.CLICK_RANK);
        RankActivityCreator fromType = RankActivityCreator.create().fromType(Constants.Companion.getTYPE_CARD());
        CardDetailInfo value2 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        RankActivityCreator rankTypeId = fromType.rankTypeId((value2 == null || (ranking = value2.getRanking()) == null) ? null : ranking.getRankTypeID());
        CardDetailInfo value3 = ((CardDetailViewModel) this.this$0.L()).C0().getValue();
        if (value3 != null && (ranking2 = value3.getRanking()) != null) {
            num = ranking2.getAllGame();
        }
        rankTypeId.allGame(num).gameKey(this.this$0.w0()).gameSubKey(this.this$0.x0()).start(this.this$0);
    }
}
