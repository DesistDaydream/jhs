package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.viewmodel.entrepot.SearchHouseProductViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchHouseProductFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ SearchHouseProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchHouseProductFragment$onItemClick$1(SearchHouseProductFragment searchHouseProductFragment) {
        super(2);
        this.this$0 = searchHouseProductFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<GameCard> value = ((SearchHouseProductViewModel) this.this$0.T()).q0().getValue();
        GameCard gameCard = value == null ? null : (GameCard) CollectionsKt___CollectionsKt.J2(value, i2);
        if (gameCard == null) {
            return;
        }
        SellerDetailActivityCreator.create(Integer.valueOf(this.this$0.l0()), Integer.valueOf(gameCard.getVersionId())).start(this.this$0.getActivity());
    }
}
