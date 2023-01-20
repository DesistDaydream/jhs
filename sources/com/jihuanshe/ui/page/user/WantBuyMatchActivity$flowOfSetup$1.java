package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.user.WantBuyMatchViewModel;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WantBuyMatchActivity$flowOfSetup$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ WantBuyMatchActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WantBuyMatchActivity$flowOfSetup$1(WantBuyMatchActivity wantBuyMatchActivity) {
        super(1);
        this.this$0 = wantBuyMatchActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        BinderKt.p(BinderKt.k(((WantBuyMatchViewModel) this.this$0.L()).p0(this.this$0.d0()), this.this$0, false, 2, null));
    }
}
