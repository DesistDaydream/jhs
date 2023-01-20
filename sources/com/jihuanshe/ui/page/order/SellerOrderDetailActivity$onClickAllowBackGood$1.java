package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onClickAllowBackGood$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickAllowBackGood$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ SellerOrderDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerOrderDetailActivity sellerOrderDetailActivity) {
            super(1);
            this.this$0 = sellerOrderDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            OrderDetailInfo value = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
            if (value != null) {
                value.setBackStatus(1);
            }
            ((SellerOrderDetailViewModel) this.this$0.L()).D0().setValue(5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onClickAllowBackGood$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
        super(1);
        this.this$0 = sellerOrderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        BinderKt.k(BinderKt.p(a.j(((SellerOrderDetailViewModel) this.this$0.L()).p0(this.this$0.c0()), null, new AnonymousClass1(this.this$0), 1, null)), this.this$0, false, 2, null);
    }
}
