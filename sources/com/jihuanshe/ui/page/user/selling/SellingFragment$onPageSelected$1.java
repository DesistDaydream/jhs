package com.jihuanshe.ui.page.user.selling;

import e.l.s.o.d.a;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingFragment$onPageSelected$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ SellingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingFragment$onPageSelected$1(SellingFragment sellingFragment) {
        super(1);
        this.this$0 = sellingFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        ((a) this.this$0.T()).p0().setValue(Integer.valueOf(i2));
    }
}
