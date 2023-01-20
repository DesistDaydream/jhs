package com.jihuanshe.ui.page.order;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import com.jihuanshe.model.OrderDetailInfo;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import e.g.d.a;
import e.l.k.k2;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onClickModifyExpress$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickModifyExpress$1$1  reason: invalid class name */
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
            this.this$0.F();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onClickModifyExpress$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
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
        EditText editText;
        Editable text;
        String value = ((SellerOrderDetailViewModel) this.this$0.L()).A0().getValue();
        k2 Y = this.this$0.Y();
        String obj = (Y == null || (editText = Y.f12989d) == null || (text = editText.getText()) == null) ? null : text.toString();
        if (value == null || value.length() == 0) {
            return;
        }
        if (obj == null || obj.length() == 0) {
            return;
        }
        SellerOrderDetailViewModel sellerOrderDetailViewModel = (SellerOrderDetailViewModel) this.this$0.L();
        OrderDetailInfo value2 = ((SellerOrderDetailViewModel) this.this$0.L()).C0().getValue();
        int id = value2 != null ? value2.getId() : 0;
        Integer value3 = ((SellerOrderDetailViewModel) this.this$0.L()).B0().getValue();
        if (value3 == null) {
            value3 = -1;
        }
        a.j(sellerOrderDetailViewModel.F0(id, value3.intValue(), ((SellerOrderDetailViewModel) this.this$0.L()).A0().getValue(), obj), null, new AnonymousClass1(this.this$0), 1, null);
    }
}
