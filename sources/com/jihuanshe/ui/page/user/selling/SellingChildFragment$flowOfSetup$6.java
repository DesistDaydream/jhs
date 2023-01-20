package com.jihuanshe.ui.page.user.selling;

import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$flowOfSetup$6 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ SellingChildFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$flowOfSetup$6(SellingChildFragment sellingChildFragment) {
        super(1);
        this.this$0 = sellingChildFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        if (this.this$0.p0()) {
            return;
        }
        Integer value = this.this$0.m0().p0().getValue();
        int intValue = 1 - this.this$0.getType().intValue();
        if (value != null && value.intValue() == intValue) {
            this.this$0.M();
        }
    }
}
