package com.jihuanshe.ui.page.user;

import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import e.l.s.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$initObserver$2 extends Lambda implements l<a, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$initObserver$2(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        if (((SellerDetailViewModel) this.this$0.L()).X0().getValue() == null) {
            return;
        }
        SellerDetailActivity.n1(this.this$0, false, 1, null);
    }
}
