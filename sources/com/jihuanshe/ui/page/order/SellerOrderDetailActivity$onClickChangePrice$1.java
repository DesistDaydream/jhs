package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ChangePriceResult;
import com.jihuanshe.ui.dialog.ChangePriceDialog;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onClickChangePrice$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickChangePrice$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements p<Float, Float, t1> {
        public final /* synthetic */ SellerOrderDetailActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickChangePrice$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01131 extends Lambda implements l<ChangePriceResult, t1> {
            public final /* synthetic */ SellerOrderDetailActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01131(SellerOrderDetailActivity sellerOrderDetailActivity) {
                super(1);
                this.this$0 = sellerOrderDetailActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(ChangePriceResult changePriceResult) {
                invoke2(changePriceResult);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e ChangePriceResult changePriceResult) {
                this.this$0.F();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerOrderDetailActivity sellerOrderDetailActivity) {
            super(2);
            this.this$0 = sellerOrderDetailActivity;
        }

        @Override // h.k2.u.p
        public /* bridge */ /* synthetic */ t1 invoke(Float f2, Float f3) {
            invoke2(f2, f3);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e Float f2, @e Float f3) {
            BinderKt.p(BinderKt.k(a.j(((SellerOrderDetailViewModel) this.this$0.L()).s0(this.this$0.c0(), f2, f3), null, new C01131(this.this$0), 1, null), this.this$0, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onClickChangePrice$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
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
        SellerOrderDetailActivity sellerOrderDetailActivity = this.this$0;
        new ChangePriceDialog(sellerOrderDetailActivity, ((SellerOrderDetailViewModel) sellerOrderDetailActivity.L()).C0().getValue(), new AnonymousClass1(this.this$0)).y();
    }
}
