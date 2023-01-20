package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.model.Ranking;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.page.rank.RankActivityCreator;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$onClickRank$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$onClickRank$1(CardPackDetailActivity cardPackDetailActivity) {
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
        Ranking ranking;
        Ranking ranking2;
        PackDetailResult value = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
        Integer num = null;
        if ((value == null ? null : value.getRanking()) == null) {
            return;
        }
        this.this$0.C0(STATConstant.OP_CARD_OR_PACK_DETAIL.CLICK_RANK);
        RankActivityCreator fromType = RankActivityCreator.create().fromType(Constants.Companion.getTYPE_PACK());
        PackDetailResult value2 = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
        RankActivityCreator rankTypeId = fromType.rankTypeId((value2 == null || (ranking = value2.getRanking()) == null) ? null : ranking.getRankTypeID());
        PackDetailResult value3 = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
        if (value3 != null && (ranking2 = value3.getRanking()) != null) {
            num = ranking2.getAllGame();
        }
        rankTypeId.allGame(num).gameKey(this.this$0.b0()).gameSubKey(this.this$0.c0()).start(this.this$0);
    }
}
