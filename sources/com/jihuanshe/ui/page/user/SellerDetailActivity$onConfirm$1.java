package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.CardProduct;
import com.jihuanshe.ui.page.order.OrderConfirmActivityCreator;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onConfirm$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.SellerDetailActivity$onConfirm$1$1  reason: invalid class name */
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
            List<CardProduct> value = ((SellerDetailViewModel) this.this$0.L()).K0().getValue();
            if (value == null || value.isEmpty()) {
                return;
            }
            ((SellerDetailViewModel) this.this$0.L()).V0().setValue(Boolean.FALSE);
            OrderConfirmActivityCreator.create(Integer.valueOf(this.this$0.Z0()), ((SellerDetailViewModel) this.this$0.L()).T0().getValue()).start(this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onConfirm$1(SellerDetailActivity sellerDetailActivity) {
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
