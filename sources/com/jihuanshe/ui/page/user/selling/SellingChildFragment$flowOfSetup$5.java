package com.jihuanshe.ui.page.user.selling;

import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$flowOfSetup$5 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ SellingChildFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$flowOfSetup$5(SellingChildFragment sellingChildFragment) {
        super(1);
        this.this$0 = sellingChildFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        if (!this.this$0.p0() && i2 == 1 - this.this$0.getType().intValue()) {
            this.this$0.M();
        }
    }
}
