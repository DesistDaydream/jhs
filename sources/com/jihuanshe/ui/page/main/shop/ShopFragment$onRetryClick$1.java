package com.jihuanshe.ui.page.main.shop;

import com.jihuanshe.model.Game;
import com.vector.design.ui.delegate.LoadMore;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopFragment$onRetryClick$1 extends Lambda implements l<List<? extends Game>, t1> {
    public final /* synthetic */ ShopFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopFragment$onRetryClick$1(ShopFragment shopFragment) {
        super(1);
        this.this$0 = shopFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Game> list) {
        invoke2((List<Game>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<Game> list) {
        this.this$0.u0().f(LoadMore.State.END);
        this.this$0.L0();
    }
}
