package com.jihuanshe.ui.page.main.shop;

import android.view.View;
import com.jihuanshe.model.BannerPack;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.stat.STATConstant;
import com.jihuanshe.ui.page.detail.CardPackDetailActivityCreator;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$onBannerDetailClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$onBannerDetailClick$1(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        BannerPack value = ((ShopViewModel) this.this$0.T()).r0().getValue();
        Integer id = value == null ? null : value.getId();
        if (id == null) {
            return;
        }
        id.intValue();
        BannerPack value2 = ((ShopViewModel) this.this$0.T()).r0().getValue();
        Integer id2 = value2 == null ? null : value2.getId();
        GameBar.a aVar = GameBar.b;
        Game value3 = aVar.a().getValue();
        String gameKey = value3 == null ? null : value3.getGameKey();
        Game value4 = aVar.a().getValue();
        CardPackDetailActivityCreator.create(id2, gameKey, value4 != null ? value4.getGameSubKey() : null).from(STATConstant.PAGE.HOME_SHOP).start(this.this$0.getActivity());
    }
}
