package com.jihuanshe.ui.page.user.selling;

import com.jihuanshe.viewmodel.user.selling.SellingChildViewModel;
import h.k2.u.a;
import h.t1;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingChildFragment$flowOfSetup$2 extends Lambda implements a<t1> {
    public final /* synthetic */ SellingChildFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildFragment$flowOfSetup$2(SellingChildFragment sellingChildFragment) {
        super(0);
        this.this$0 = sellingChildFragment;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        ((SellingChildViewModel) this.this$0.T()).D0().setValue(CollectionsKt__CollectionsKt.E());
        this.this$0.M();
    }
}
