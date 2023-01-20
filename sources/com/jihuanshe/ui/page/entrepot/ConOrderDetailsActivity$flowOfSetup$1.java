package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardConsignmentInfo;
import com.jihuanshe.viewmodel.entrepot.ConOrderDetailsViewModel;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConOrderDetailsActivity$flowOfSetup$1 extends Lambda implements l<CardConsignmentInfo, t1> {
    public final /* synthetic */ ConOrderDetailsActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConOrderDetailsActivity$flowOfSetup$1(ConOrderDetailsActivity conOrderDetailsActivity) {
        super(1);
        this.this$0 = conOrderDetailsActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(CardConsignmentInfo cardConsignmentInfo) {
        invoke2(cardConsignmentInfo);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e CardConsignmentInfo cardConsignmentInfo) {
        ListView b0;
        a D0 = ConOrderDetailsViewModel.D0((ConOrderDetailsViewModel) this.this$0.L(), this.this$0.i0().intValue(), null, 2, null);
        ConOrderDetailsActivity conOrderDetailsActivity = this.this$0;
        b0 = conOrderDetailsActivity.b0();
        BinderKt.p(BinderKt.e(D0, conOrderDetailsActivity, b0, false, 4, null));
    }
}
