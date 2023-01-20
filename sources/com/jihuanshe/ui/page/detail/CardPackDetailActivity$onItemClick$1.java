package com.jihuanshe.ui.page.detail;

import android.view.View;
import com.jihuanshe.model.CardVersionInfo;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ CardPackDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailActivity$onItemClick$1(CardPackDetailActivity cardPackDetailActivity) {
        super(2);
        this.this$0 = cardPackDetailActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<CardVersionInfo> cardVersions;
        PackDetailResult value = ((CardPackDetailViewModel) this.this$0.L()).B0().getValue();
        CardVersionInfo cardVersionInfo = null;
        if (value != null && (cardVersions = value.getCardVersions()) != null) {
            cardVersionInfo = (CardVersionInfo) CollectionsKt___CollectionsKt.J2(cardVersions, i2);
        }
        if (cardVersionInfo == null) {
            return;
        }
        Integer numMore = cardVersionInfo.getNumMore();
        if ((numMore == null ? 0 : numMore.intValue()) > 0) {
            CardPackListActivityCreator.create(((CardPackDetailViewModel) this.this$0.L()).B0().getValue(), this.this$0.b0(), this.this$0.c0()).from(STATConstant.PAGE.PACK_DETAIL).start(this.this$0);
        } else {
            CardDetailActivityCreator.create(cardVersionInfo.getId(), this.this$0.b0(), this.this$0.c0()).from(STATConstant.PAGE.PACK_DETAIL).start(this.this$0);
        }
    }
}
