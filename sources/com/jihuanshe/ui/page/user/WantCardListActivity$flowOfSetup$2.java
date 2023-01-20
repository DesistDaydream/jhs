package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.WantCardListViewModel;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantCardListActivity$flowOfSetup$2 extends Lambda implements a<t1> {
    public final /* synthetic */ WantCardListActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantCardListActivity$flowOfSetup$2(WantCardListActivity wantCardListActivity) {
        super(0);
        this.this$0 = wantCardListActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        e.g.d.a w0 = WantCardListViewModel.w0((WantCardListViewModel) this.this$0.L(), this.this$0.f0().getId(), null, null, 4, null);
        WantCardListActivity wantCardListActivity = this.this$0;
        BinderKt.k(BinderKt.e(w0, wantCardListActivity, wantCardListActivity.a0(), false, 4, null), this.this$0, false, 2, null);
    }
}
