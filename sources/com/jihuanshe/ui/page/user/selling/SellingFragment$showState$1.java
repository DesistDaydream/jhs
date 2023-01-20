package com.jihuanshe.ui.page.user.selling;

import e.l.s.o.d.a;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingFragment$showState$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ SellingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingFragment$showState$1(SellingFragment sellingFragment) {
        super(1);
        this.this$0 = sellingFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        ((a) this.this$0.T()).t0().setValue(Boolean.valueOf(z));
    }
}
