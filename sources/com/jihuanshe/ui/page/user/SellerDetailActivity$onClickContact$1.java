package com.jihuanshe.ui.page.user;

import android.view.View;
import com.jihuanshe.model.User;
import com.jihuanshe.viewmodel.user.SellerDetailViewModel;
import e.l.q.b.f.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailActivity$onClickContact$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailActivity$onClickContact$1(SellerDetailActivity sellerDetailActivity) {
        super(1);
        this.this$0 = sellerDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        SellerDetailActivity sellerDetailActivity = this.this$0;
        User value = ((SellerDetailViewModel) sellerDetailActivity.L()).X0().getValue();
        String valueOf = String.valueOf(value == null ? null : Integer.valueOf(value.getId()));
        User value2 = ((SellerDetailViewModel) this.this$0.L()).X0().getValue();
        g.a(sellerDetailActivity, valueOf, value2 != null ? value2.getName() : null);
    }
}
