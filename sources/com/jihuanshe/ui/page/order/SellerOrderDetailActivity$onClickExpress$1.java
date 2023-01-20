package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ExpressList;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onClickExpress$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickExpress$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<ExpressList, t1> {
        public final /* synthetic */ SellerOrderDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerOrderDetailActivity sellerOrderDetailActivity) {
            super(1);
            this.this$0 = sellerOrderDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(ExpressList expressList) {
            invoke2(expressList);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e ExpressList expressList) {
            this.this$0.A0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onClickExpress$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
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
        if (!((SellerOrderDetailViewModel) this.this$0.L()).x0().isEmpty()) {
            this.this$0.A0();
        } else {
            BinderKt.p(BinderKt.k(a.j(((SellerOrderDetailViewModel) this.this$0.L()).w0(), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
        }
    }
}
