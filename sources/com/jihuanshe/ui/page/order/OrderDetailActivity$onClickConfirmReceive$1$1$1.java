package com.jihuanshe.ui.page.order;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.order.OrderDetailViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderDetailActivity$onClickConfirmReceive$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ OrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.OrderDetailActivity$onClickConfirmReceive$1$1$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ OrderDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(OrderDetailActivity orderDetailActivity) {
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
            ((OrderDetailViewModel) this.this$0.L()).A0().setValue(4);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderDetailActivity$onClickConfirmReceive$1$1$1(OrderDetailActivity orderDetailActivity) {
        super(0);
        this.this$0 = orderDetailActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BinderKt.p(BinderKt.k(e.g.d.a.j(((OrderDetailViewModel) this.this$0.L()).s0(this.this$0.c0()), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
    }
}
