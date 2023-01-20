package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.dialog.BackProductDialog;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.k2.u.q;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$onClickBackProduct$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.OrderDetailActivity$onClickBackProduct$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements q<Integer, Integer, String, t1> {
        public final /* synthetic */ OrderDetailActivity this$0;

        /* renamed from: com.jihuanshe.ui.page.order.OrderDetailActivity$onClickBackProduct$1$1$1  reason: invalid class name and collision with other inner class name */
        /* loaded from: classes2.dex */
        public static final class C01101 extends Lambda implements l<t1, t1> {
            public final /* synthetic */ OrderDetailActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C01101(OrderDetailActivity orderDetailActivity) {
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

        /* renamed from: com.jihuanshe.ui.page.order.OrderDetailActivity$onClickBackProduct$1$1$2  reason: invalid class name */
        /* loaded from: classes2.dex */
        public static final class AnonymousClass2 extends Lambda implements l<t1, t1> {
            public final /* synthetic */ OrderDetailActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(OrderDetailActivity orderDetailActivity) {
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
                ((OrderDetailViewModel) this.this$0.L()).A0().setValue(6);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OrderDetailActivity orderDetailActivity) {
            super(3);
            this.this$0 = orderDetailActivity;
        }

        @Override // h.k2.u.q
        public /* bridge */ /* synthetic */ t1 invoke(Integer num, Integer num2, String str) {
            invoke(num.intValue(), num2.intValue(), str);
            return t1.a;
        }

        public final void invoke(int i2, int i3, @d String str) {
            if (i3 == 1) {
                BinderKt.p(BinderKt.k(a.j(((OrderDetailViewModel) this.this$0.L()).q0(this.this$0.c0(), 1, str), null, new C01101(this.this$0), 1, null), this.this$0, false, 2, null));
            } else {
                BinderKt.p(BinderKt.k(a.j(((OrderDetailViewModel) this.this$0.L()).p0(this.this$0.c0(), i2, str), null, new AnonymousClass2(this.this$0), 1, null), this.this$0, false, 2, null));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$onClickBackProduct$1(OrderDetailActivity orderDetailActivity) {
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
        new BackProductDialog(orderDetailActivity, ((OrderDetailViewModel) orderDetailActivity.L()).y0().getValue(), new AnonymousClass1(this.this$0)).y();
    }
}
