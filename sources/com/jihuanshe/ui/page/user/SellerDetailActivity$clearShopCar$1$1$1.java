package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$clearShopCar$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.SellerDetailActivity$clearShopCar$1$1$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ SellerDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerDetailActivity sellerDetailActivity) {
            super(1);
            this.this$0 = sellerDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            ((SellerDetailViewModel) this.this$0.L()).K0().setValue(new ArrayList());
            ((SellerDetailViewModel) this.this$0.L()).T0().r(null);
            ((SellerDetailViewModel) this.this$0.L()).V0().setValue(Boolean.FALSE);
            ((SellerDetailViewModel) this.this$0.L()).L0(this.this$0.Z0());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$clearShopCar$1$1$1(SellerDetailActivity sellerDetailActivity) {
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
        BinderKt.p(BinderKt.k(e.g.d.a.j(((SellerDetailViewModel) this.this$0.L()).C0(this.this$0.Z0()), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
    }
}
