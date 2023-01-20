package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.WantBuyViewModel;
import com.vector.view.scrollable.ListView;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyActivity$flowOfSetup$2 extends Lambda implements a<t1> {
    public final /* synthetic */ WantBuyActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyActivity$flowOfSetup$2(WantBuyActivity wantBuyActivity) {
        super(0);
        this.this$0 = wantBuyActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ListView h0;
        e.g.d.a t0 = WantBuyViewModel.t0((WantBuyViewModel) this.this$0.L(), null, 1, null);
        WantBuyActivity wantBuyActivity = this.this$0;
        h0 = wantBuyActivity.h0();
        BinderKt.k(BinderKt.e(t0, wantBuyActivity, h0, false, 4, null), this.this$0, false, 2, null);
    }
}
