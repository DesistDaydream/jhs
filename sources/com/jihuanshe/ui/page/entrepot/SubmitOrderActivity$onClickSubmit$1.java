package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import android.widget.EditText;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.WareCache;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel;
import com.vector.util.Res;
import e.l.h.d.f;
import e.l.h.d.i;
import e.l.j.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$onClickSubmit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SubmitOrderActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$onClickSubmit$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ SubmitOrderActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubmitOrderActivity submitOrderActivity) {
            super(1);
            this.this$0 = submitOrderActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            i.d(f.b, a.q, null, 2, null);
            e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), null, null, null, 0, null, 62, null);
            this.this$0.finish();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderActivity$onClickSubmit$1(SubmitOrderActivity submitOrderActivity) {
        super(1);
        this.this$0 = submitOrderActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        EditText c0;
        EditText c02;
        if (this.this$0.a0() == null) {
            return;
        }
        WareCache value = ((SubmitOrderViewModel) this.this$0.L()).B0().getValue();
        String expressType = value == null ? null : value.getExpressType();
        if (!(expressType == null || expressType.length() == 0)) {
            c0 = this.this$0.c0();
            if (f0.g(StringsKt__StringsKt.B5(c0.getText()).toString(), "")) {
                e.l.h.j.b.e.h(this.this$0, "您还未填写快递单号", null, null, null, 0, null, 62, null);
                return;
            }
            WareCache value2 = ((SubmitOrderViewModel) this.this$0.L()).B0().getValue();
            String imageUrl = value2 == null ? null : value2.getImageUrl();
            if (imageUrl == null || imageUrl.length() == 0) {
                e.l.h.j.b.e.h(this.this$0, "您还未上传快递单照片", null, null, null, 0, null, 62, null);
                return;
            }
            SubmitOrderViewModel submitOrderViewModel = (SubmitOrderViewModel) this.this$0.L();
            Integer warehouseOrderId = this.this$0.a0().getWarehouseOrderId();
            int intValue = warehouseOrderId != null ? warehouseOrderId.intValue() : 0;
            WareCache value3 = ((SubmitOrderViewModel) this.this$0.L()).B0().getValue();
            String expressType2 = value3 == null ? null : value3.getExpressType();
            c02 = this.this$0.c0();
            String obj = StringsKt__StringsKt.B5(c02.getText()).toString();
            WareCache value4 = ((SubmitOrderViewModel) this.this$0.L()).B0().getValue();
            BinderKt.n(e.g.d.a.j(submitOrderViewModel.C0(intValue, expressType2, obj, value4 == null ? null : value4.getImageUrl()), null, new AnonymousClass1(this.this$0), 1, null), this.this$0);
            return;
        }
        e.l.h.j.b.e.h(this.this$0, "请选择快递", null, null, null, 0, null, 62, null);
    }
}
