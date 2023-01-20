package com.jihuanshe.ui.page.main.shop;

import com.vector.design.ui.decor.ViewState;
import com.vector.design.ui.delegate.LoadMore;
import e.g.e.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$onRetryClick$2 extends Lambda implements l<a, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$onRetryClick$2(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        this.this$0.R(ViewState.NORMAL);
        this.this$0.u0().f(LoadMore.State.END);
        this.this$0.L0();
    }
}
