package com.jihuanshe.viewmodel.order;

import com.jihuanshe.model.UserAddress;
import e.l.n.c.n;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class OrderConfirmViewModel$initData$2 extends Lambda implements l<Pair<? extends UserAddress, ? extends n>, t1> {
    public final /* synthetic */ OrderConfirmViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OrderConfirmViewModel$initData$2(OrderConfirmViewModel orderConfirmViewModel) {
        super(1);
        this.this$0 = orderConfirmViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends UserAddress, ? extends n> pair) {
        invoke2((Pair<UserAddress, n>) pair);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Pair<UserAddress, n> pair) {
        this.this$0.r0().r(pair == null ? null : pair.getSecond());
        this.this$0.q0().r(pair != null ? pair.getFirst() : null);
    }
}
