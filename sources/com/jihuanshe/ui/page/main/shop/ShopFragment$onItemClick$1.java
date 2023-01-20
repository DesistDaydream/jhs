package com.jihuanshe.ui.page.main.shop;

import android.view.View;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.page.detail.CardDetailActivityCreator;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import e.l.l.b;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$onItemClick$1(ShopFragment shopFragment) {
        super(2);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<GameCard> value = ((ShopViewModel) this.this$0.T()).y0().getValue();
        GameCard gameCard = value == null ? null : (GameCard) CollectionsKt___CollectionsKt.J2(value, i2);
        if (gameCard == null) {
            return;
        }
        Category value2 = ((ShopViewModel) this.this$0.T()).x0().getValue();
        if (value2 != null && value2.getId() == Constants.Companion.getCATEGORY_ID()) {
            SellerDetailActivityCreator.create(Integer.valueOf(Constants.Companion.getWAREHOUSE_SELLER_USER_ID()), Integer.valueOf(gameCard.getVersionId())).start(this.this$0.getActivity());
            return;
        }
        CardPackage value3 = ((ShopViewModel) this.this$0.T()).w0().getValue();
        if (value3 != null ? f0.g(value3.getType(), Integer.valueOf(Constants.Companion.getTYPE_NEWEST())) : false) {
            SellerDetailActivityCreator create = SellerDetailActivityCreator.create(Integer.valueOf(gameCard.getSellerId()), Integer.valueOf(gameCard.getVersionId()));
            Pair<String, String> value4 = ((ShopViewModel) this.this$0.T()).W().getValue();
            create.wish(value4 != null ? Boolean.valueOf(b.a(value4)) : null).start(this.this$0.getActivity());
            return;
        }
        Integer valueOf = Integer.valueOf(gameCard.getVersionId());
        GameBar.a aVar = GameBar.b;
        Game value5 = aVar.a().getValue();
        String gameKey = value5 == null ? null : value5.getGameKey();
        Game value6 = aVar.a().getValue();
        CardDetailActivityCreator from = CardDetailActivityCreator.create(valueOf, gameKey, value6 == null ? null : value6.getGameSubKey()).from(STATConstant.PAGE.HOME_SHOP);
        Pair<String, String> value7 = ((ShopViewModel) this.this$0.T()).W().getValue();
        from.wish(value7 != null ? Boolean.valueOf(b.a(value7)) : null).start(this.this$0.getActivity());
    }
}
