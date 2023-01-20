package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ShopCarInfo;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onClickShopCar$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.SellerDetailActivity$onClickShopCar$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements a<t1> {
        public final /* synthetic */ SellerDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerDetailActivity sellerDetailActivity) {
            super(0);
            this.this$0 = sellerDetailActivity;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Boolean value = ((SellerDetailViewModel) this.this$0.L()).V0().getValue();
            Boolean bool = Boolean.TRUE;
            if (f0.g(value, bool)) {
                ((SellerDetailViewModel) this.this$0.L()).V0().setValue(Boolean.FALSE);
                return;
            }
            ShopCarInfo value2 = ((SellerDetailViewModel) this.this$0.L()).T0().getValue();
            if (value2 == null) {
                return;
            }
            SellerDetailActivity sellerDetailActivity = this.this$0;
            if (value2.getCount() > 0) {
                BinderKt.p(((SellerDetailViewModel) sellerDetailActivity.L()).L0(sellerDetailActivity.Z0()));
                ((SellerDetailViewModel) sellerDetailActivity.L()).V0().setValue(bool);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onClickShopCar$1(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        e.l.l.a.d(new AnonymousClass1(this.this$0));
    }
}
