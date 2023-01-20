package com.jihuanshe.ui.page.user.selling;

import androidx.lifecycle.ViewModelProvider;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$parentViewModel$2 extends Lambda implements a<e.l.s.o.d.a> {
    public final /* synthetic */ SellingChildFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$parentViewModel$2(SellingChildFragment sellingChildFragment) {
        super(0);
        this.this$0 = sellingChildFragment;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final e.l.s.o.d.a invoke() {
        return (e.l.s.o.d.a) new ViewModelProvider(this.this$0.requireParentFragment()).get(e.l.s.o.d.a.class);
    }
}
