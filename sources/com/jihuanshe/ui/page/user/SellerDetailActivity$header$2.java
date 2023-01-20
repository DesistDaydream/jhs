package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import e.l.k.eg;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$header$2 extends Lambda implements a<View> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$header$2(SellerDetailActivity sellerDetailActivity) {
        super(0);
        this.this$0 = sellerDetailActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final View invoke() {
        eg e2 = eg.e(this.this$0.getLayoutInflater());
        e2.setLifecycleOwner(this.this$0);
        e2.i(this.this$0);
        e2.j((SellerDetailViewModel) this.this$0.L());
        return e2.getRoot();
    }
}
