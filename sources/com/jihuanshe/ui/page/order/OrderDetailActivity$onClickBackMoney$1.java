package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.dialog.BuyerCancelReasonDialog;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$onClickBackMoney$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.OrderDetailActivity$onClickBackMoney$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<String, t1> {
        public final /* synthetic */ OrderDetailActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.order.OrderDetailActivity$onClickBackMoney$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01091 extends Lambda implements l<t1, t1> {
            public final /* synthetic */ OrderDetailActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01091(OrderDetailActivity orderDetailActivity) {
                super(1);
                this.this$0 = orderDetailActivity;
            }

            @Override // h.k2.u.l
            public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
                invoke2(t1Var);
                return t1.a;
            }

            /* renamed from: invoke  reason: avoid collision after fix types in other method */
            public final void invoke2(@e t1 t1Var) {
                ((OrderDetailViewModel) this.this$0.L()).A0().setValue(5);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OrderDetailActivity orderDetailActivity) {
            super(1);
            this.this$0 = orderDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(String str) {
            invoke2(str);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d String str) {
            BinderKt.p(BinderKt.k(a.j(((OrderDetailViewModel) this.this$0.L()).q0(this.this$0.c0(), 1, str), null, new C01091(this.this$0), 1, null), this.this$0, false, 2, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$onClickBackMoney$1(OrderDetailActivity orderDetailActivity) {
        super(1);
        this.this$0 = orderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        OrderDetailActivity orderDetailActivity = this.this$0;
        new BuyerCancelReasonDialog(orderDetailActivity, new AnonymousClass1(orderDetailActivity)).y();
    }
}
