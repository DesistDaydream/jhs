package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$flowOfSetup$9 extends Lambda implements l<String, t1> {
    public final /* synthetic */ SellingChildFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$flowOfSetup$9(SellingChildFragment sellingChildFragment) {
        super(1);
        this.this$0 = sellingChildFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        ((SellingChildViewModel) this.this$0.T()).I0(str);
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
