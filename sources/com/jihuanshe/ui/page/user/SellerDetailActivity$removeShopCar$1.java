package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.ShopCarResult;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$removeShopCar$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CardProduct $p;
    public final /* synthetic */ SellerDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.SellerDetailActivity$removeShopCar$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<ShopCarResult, t1> {
        public final /* synthetic */ CardProduct $p;
        public final /* synthetic */ SellerDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerDetailActivity sellerDetailActivity, CardProduct cardProduct) {
            super(1);
            this.this$0 = sellerDetailActivity;
            this.$p = cardProduct;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(ShopCarResult shopCarResult) {
            invoke2(shopCarResult);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e ShopCarResult shopCarResult) {
            List<CardProduct> value = ((SellerDetailViewModel) this.this$0.L()).K0().getValue();
            List<CardProduct> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
            if (L5 == null) {
                return;
            }
            CardProduct cardProduct = this.$p;
            SellerDetailActivity sellerDetailActivity = this.this$0;
            for (CardProduct cardProduct2 : L5) {
                if (cardProduct2.getPid() == cardProduct.getPid()) {
                    L5.remove(cardProduct2);
                    ((SellerDetailViewModel) sellerDetailActivity.L()).K0().setValue(L5);
                    ((SellerDetailViewModel) sellerDetailActivity.L()).L0(sellerDetailActivity.Z0());
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$removeShopCar$1(SellerDetailActivity sellerDetailActivity, CardProduct cardProduct) {
        super(1);
        this.this$0 = sellerDetailActivity;
        this.$p = cardProduct;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        BinderKt.p(BinderKt.k(a.j(((SellerDetailViewModel) this.this$0.L()).f1(this.$p.getCid()), null, new AnonymousClass1(this.this$0, this.$p), 1, null), this.this$0, false, 2, null));
    }
}
