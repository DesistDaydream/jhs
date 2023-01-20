package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.WareCache;
import com.jihuanshe.ui.dialog.ChooseDialogNew;
import com.jihuanshe.viewmodel.entrepot.SubmitOrderViewModel;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$onClickSpinner$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SubmitOrderActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.entrepot.SubmitOrderActivity$onClickSpinner$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<String, t1> {
        public final /* synthetic */ SubmitOrderActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SubmitOrderActivity submitOrderActivity) {
            super(1);
            this.this$0 = submitOrderActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(String str) {
            invoke2(str);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e String str) {
            WareCache value = ((SubmitOrderViewModel) this.this$0.L()).B0().getValue();
            if (value != null) {
                value.setExpressType(str);
            }
            ((SubmitOrderViewModel) this.this$0.L()).B0().n();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubmitOrderActivity$onClickSpinner$1(SubmitOrderActivity submitOrderActivity) {
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
        SubmitOrderActivity submitOrderActivity = this.this$0;
        List<String> value = ((SubmitOrderViewModel) submitOrderActivity.L()).z0().getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.E();
        }
        new ChooseDialogNew(submitOrderActivity, value, new AnonymousClass1(this.this$0)).y();
    }
}
