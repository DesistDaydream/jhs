package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.model.ReturnOrderResult;
import com.jihuanshe.model.ReturnProduct;
import com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel;
import com.vector.ext.AnyKt;
import e.g.d.a;
import e.l.r.f0;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForReturnActivity$onClickSubmit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ApplyForReturnActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.ApplyForReturnActivity$onClickSubmit$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<ReturnOrderResult, t1> {
        public final /* synthetic */ ApplyForReturnActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ApplyForReturnActivity applyForReturnActivity) {
            super(1);
            this.this$0 = applyForReturnActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(ReturnOrderResult returnOrderResult) {
            invoke2(returnOrderResult);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e ReturnOrderResult returnOrderResult) {
            Integer orderId = returnOrderResult == null ? null : returnOrderResult.getOrderId();
            if (orderId == null) {
                return;
            }
            SubmitOrderReturnActivityCreator.create(Integer.valueOf(orderId.intValue())).start(this.this$0);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.ApplyForReturnActivity$onClickSubmit$1$2  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass2 extends Lambda implements l<ReturnOrderResult, t1> {
        public final /* synthetic */ ApplyForReturnActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ApplyForReturnActivity applyForReturnActivity) {
            super(1);
            this.this$0 = applyForReturnActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(ReturnOrderResult returnOrderResult) {
            invoke2(returnOrderResult);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e ReturnOrderResult returnOrderResult) {
            Integer orderId = returnOrderResult == null ? null : returnOrderResult.getOrderId();
            if (orderId == null) {
                return;
            }
            SubmitOrderReturnActivityCreator.create(Integer.valueOf(orderId.intValue())).start(this.this$0);
        }
    }

    /* renamed from: com.jihuanshe.ui.page.entrepot.ApplyForReturnActivity$onClickSubmit$1$4  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass4 extends Lambda implements l<ReturnOrderResult, t1> {
        public final /* synthetic */ ApplyForReturnActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(ApplyForReturnActivity applyForReturnActivity) {
            super(1);
            this.this$0 = applyForReturnActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(ReturnOrderResult returnOrderResult) {
            invoke2(returnOrderResult);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e ReturnOrderResult returnOrderResult) {
            Integer orderId = returnOrderResult == null ? null : returnOrderResult.getOrderId();
            if (orderId == null) {
                return;
            }
            SubmitOrderReturnActivityCreator.create(Integer.valueOf(orderId.intValue())).start(this.this$0);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForReturnActivity$onClickSubmit$1(ApplyForReturnActivity applyForReturnActivity) {
        super(1);
        this.this$0 = applyForReturnActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer value;
        if (!AnyKt.l(((ApplyForReturnViewModel) this.this$0.L()).y0().getValue()) && ((ApplyForReturnViewModel) this.this$0.L()).s0().getValue() != null && !((ApplyForReturnViewModel) this.this$0.L()).s0().getValue().isEmpty()) {
            if (this.this$0.d0().size() == 0 && (value = ((ApplyForReturnViewModel) this.this$0.L()).A0().getValue()) != null && value.intValue() == 2) {
                e.l.h.j.b.e.h(this.this$0, "请先选择要寄回的商品", null, null, null, 0, null, 62, null);
                return;
            }
            Integer value2 = ((ApplyForReturnViewModel) this.this$0.L()).A0().getValue();
            if (value2 != null && value2.intValue() == 0) {
                BinderKt.n(a.j(ApplyForReturnViewModel.G0((ApplyForReturnViewModel) this.this$0.L(), null, null, null, null, 15, null), null, new AnonymousClass1(this.this$0), 1, null), this.this$0);
                return;
            } else if (value2 != null && value2.intValue() == 1) {
                BinderKt.n(a.j(ApplyForReturnViewModel.G0((ApplyForReturnViewModel) this.this$0.L(), 1, null, null, null, 14, null), null, new AnonymousClass2(this.this$0), 1, null), this.this$0);
                return;
            } else if (value2 != null && value2.intValue() == 2) {
                ArrayList arrayList = new ArrayList();
                for (ReturnCardInfo returnCardInfo : this.this$0.d0()) {
                    arrayList.add(new ReturnProduct(returnCardInfo.getId(), returnCardInfo.getQuantity()));
                }
                BinderKt.n(a.j(ApplyForReturnViewModel.G0((ApplyForReturnViewModel) this.this$0.L(), null, 1, f0.a.d(arrayList), null, 8, null), null, new AnonymousClass4(this.this$0), 1, null), this.this$0);
                return;
            } else {
                return;
            }
        }
        e.l.h.j.b.e.h(this.this$0, "请先设置收货地址", null, null, null, 0, null, 62, null);
    }
}
