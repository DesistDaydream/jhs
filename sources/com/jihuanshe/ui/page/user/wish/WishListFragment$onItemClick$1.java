package com.jihuanshe.ui.page.user.wish;

import android.view.View;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Product;
import com.jihuanshe.ui.page.detail.CardDetailActivityCreator;
import com.jihuanshe.ui.page.detail.CardPackDetailActivityCreator;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListFragment$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ WishListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListFragment$onItemClick$1(WishListFragment wishListFragment) {
        super(2);
        this.this$0 = wishListFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<Product> value = ((WishListViewModel) this.this$0.T()).r0().getValue();
        Product product = value == null ? null : (Product) CollectionsKt___CollectionsKt.J2(value, i2);
        if (product == null) {
            return;
        }
        if (f0.g(product.getType(), Constants.Companion.getTYPE_PACK())) {
            CardPackDetailActivityCreator.create(product.getId(), product.getGameKey(), product.getGameSubKey()).from("愿望单").start(this.this$0.getActivity());
        } else {
            CardDetailActivityCreator.create(product.getId(), product.getGameKey(), product.getGameSubKey()).from("愿望单").start(this.this$0.getActivity());
        }
    }
}
