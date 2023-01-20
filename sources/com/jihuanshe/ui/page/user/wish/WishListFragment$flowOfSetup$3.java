package com.jihuanshe.ui.page.user.wish;

import e.l.s.o.e.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListFragment$flowOfSetup$3 extends Lambda implements l<String, t1> {
    public final /* synthetic */ WishListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListFragment$flowOfSetup$3(WishListFragment wishListFragment) {
        super(1);
        this.this$0 = wishListFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e String str) {
        a q0;
        q0 = this.this$0.q0();
        if (f0.g(q0.q0().getValue(), this.this$0.i0())) {
            this.this$0.u0(str);
            this.this$0.s0();
        }
    }
}
