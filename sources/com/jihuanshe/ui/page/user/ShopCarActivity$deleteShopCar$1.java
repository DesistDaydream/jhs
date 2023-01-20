package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ShopCartItem;
import com.jihuanshe.viewmodel.user.ShopCarViewModel;
import e.g.d.a;
import e.t.l.p;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopCarActivity$deleteShopCar$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ShopCartItem $item;
    public final /* synthetic */ ShopCarActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.ShopCarActivity$deleteShopCar$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ ShopCartItem $item;
        public final /* synthetic */ ShopCarActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.user.ShopCarActivity$deleteShopCar$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01271 extends Lambda implements l<ShopCartItem, Boolean> {
            public final /* synthetic */ ShopCartItem $item;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01271(ShopCartItem shopCartItem) {
                super(1);
                this.$item = shopCartItem;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ Boolean invoke(ShopCartItem shopCartItem) {
                return Boolean.valueOf(invoke2(shopCartItem));
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final boolean invoke2(@d ShopCartItem shopCartItem) {
                return f0.g(shopCartItem.getSellerId(), this.$item.getSellerId());
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ShopCarActivity shopCarActivity, ShopCartItem shopCartItem) {
            super(1);
            this.this$0 = shopCarActivity;
            this.$item = shopCartItem;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            List<ShopCartItem> value = ((ShopCarViewModel) this.this$0.L()).t0().getValue();
            List<ShopCartItem> L5 = value == null ? null : CollectionsKt___CollectionsKt.L5(value);
            if (L5 != null) {
                p.d(L5, new C01271(this.$item));
            }
            ((ShopCarViewModel) this.this$0.L()).t0().setValue(L5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopCarActivity$deleteShopCar$1(ShopCartItem shopCartItem, ShopCarActivity shopCarActivity) {
        super(1);
        this.$item = shopCartItem;
        this.this$0 = shopCarActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer sellerId = this.$item.getSellerId();
        if (sellerId == null) {
            return;
        }
        sellerId.intValue();
        BinderKt.p(BinderKt.k(a.j(((ShopCarViewModel) this.this$0.L()).q0(this.$item.getSellerId().intValue()), null, new AnonymousClass1(this.this$0, this.$item), 1, null), this.this$0, false, 2, null));
    }
}
