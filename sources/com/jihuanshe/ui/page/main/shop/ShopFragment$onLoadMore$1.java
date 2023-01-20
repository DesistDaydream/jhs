package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Category;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameBar;
import com.jihuanshe.viewmodel.main.shop.ShopViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.t.v.j.g;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$onLoadMore$1(ShopFragment shopFragment) {
        super(2);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        Category value = ((ShopViewModel) this.this$0.T()).x0().getValue();
        if (value != null && value.getId() == Constants.Companion.getCATEGORY_ID()) {
            ShopViewModel shopViewModel = (ShopViewModel) this.this$0.T();
            int warehouse_seller_user_id = Constants.Companion.getWAREHOUSE_SELLER_USER_ID();
            GameBar.a aVar = GameBar.b;
            Game value2 = aVar.a().getValue();
            String gameKey = value2 == null ? null : value2.getGameKey();
            if (gameKey == null) {
                gameKey = "";
            }
            Game value3 = aVar.a().getValue();
            String gameSubKey = value3 != null ? value3.getGameSubKey() : null;
            if (gameSubKey == null) {
                gameSubKey = "";
            }
            a<?> A0 = shopViewModel.A0(warehouse_seller_user_id, gameKey, gameSubKey, false, state);
            ShopFragment shopFragment = this.this$0;
            BinderKt.e(A0, shopFragment, shopFragment.u0(), false, 4, null);
            return;
        }
        BinderKt.d(((ShopViewModel) this.this$0.T()).s0(GameBar.b.a().getValue(), ((ShopViewModel) this.this$0.T()).w0().getValue(), state, false), this.this$0, gVar, true);
    }
}
