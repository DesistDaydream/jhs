package com.jihuanshe.viewmodel.shop;

import androidx.core.view.ViewCompat;
import com.jihuanshe.model.ConfirmState;
import e.l.r.t0;
import e.t.o.d;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerConfirmViewModel$queryState$1 extends Lambda implements l<ConfirmState, t1> {
    public final /* synthetic */ SellerConfirmViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerConfirmViewModel$queryState$1(SellerConfirmViewModel sellerConfirmViewModel) {
        super(1);
        this.this$0 = sellerConfirmViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(ConfirmState confirmState) {
        invoke2(confirmState);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e ConfirmState confirmState) {
        String url;
        if (confirmState == null || (url = confirmState.getUrl()) == null) {
            return;
        }
        SellerConfirmViewModel sellerConfirmViewModel = this.this$0;
        int d2 = d.a.c(d.a, null, 1, null).d(180);
        sellerConfirmViewModel.K0().setValue(t0.a.a(url, d2, d2, "UTF-8", "H", "1", ViewCompat.MEASURED_STATE_MASK, -1));
    }
}
