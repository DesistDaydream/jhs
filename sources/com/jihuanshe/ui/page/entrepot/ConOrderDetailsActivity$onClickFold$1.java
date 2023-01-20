package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.ui.dialog.ExpressDialog;
import com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConOrderDetailsActivity$onClickFold$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ConOrderDetailsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConOrderDetailsActivity$onClickFold$1(ConOrderDetailsActivity conOrderDetailsActivity) {
        super(1);
        this.this$0 = conOrderDetailsActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (f0.g(((ConOrderDetailsViewModel) this.this$0.L()).F0().getValue(), Boolean.TRUE)) {
            ConOrderDetailsActivity conOrderDetailsActivity = this.this$0;
            new ExpressDialog(conOrderDetailsActivity, ((ConOrderDetailsViewModel) conOrderDetailsActivity.L()).r0().getValue(), ((ConOrderDetailsViewModel) this.this$0.L()).t0().getValue(), ((ConOrderDetailsViewModel) this.this$0.L()).v0().getValue()).y();
        }
    }
}
