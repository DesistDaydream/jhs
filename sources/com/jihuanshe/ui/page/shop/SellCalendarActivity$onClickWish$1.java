package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.jihuanshe.model.Product;
import com.jihuanshe.viewmodel.shop.SellCalendarViewModel;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarActivity$onClickWish$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellCalendarActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.shop.SellCalendarActivity$onClickWish$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ Object $p;
        public final /* synthetic */ SellCalendarActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellCalendarActivity sellCalendarActivity, Object obj) {
            super(0);
            this.this$0 = sellCalendarActivity;
            this.$p = obj;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List<Product> value = ((SellCalendarViewModel) this.this$0.L()).v0().getValue();
            Integer valueOf = value == null ? null : Integer.valueOf(value.indexOf(this.$p));
            if (valueOf != null && valueOf.intValue() >= 0) {
                this.this$0.d0().notifyItemChanged(valueOf.intValue());
            } else {
                this.this$0.d0().notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellCalendarActivity$onClickWish$1(SellCalendarActivity sellCalendarActivity) {
        super(1);
        this.this$0 = sellCalendarActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Product product;
        Integer id;
        WishListViewModel q0;
        Object tag = view.getTag(view.getId());
        if (!(tag instanceof Product) || (id = (product = (Product) tag).getId()) == null) {
            return;
        }
        id.intValue();
        q0 = this.this$0.q0();
        SellCalendarActivity sellCalendarActivity = this.this$0;
        q0.v0(sellCalendarActivity, product, new AnonymousClass1(sellCalendarActivity, tag));
    }
}
