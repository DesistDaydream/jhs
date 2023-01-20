package com.jihuanshe.ui.page.user.wish;

import com.jihuanshe.model.Game;
import com.jihuanshe.viewmodel.user.wish.WishListViewModel;
import e.l.s.o.e.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListFragment$flowOfSetup$2 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ WishListFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListFragment$flowOfSetup$2(WishListFragment wishListFragment) {
        super(1);
        this.this$0 = wishListFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        a q0;
        a q02;
        a q03;
        a q04;
        Integer i0 = this.this$0.i0();
        if (i0 != null && i2 == i0.intValue()) {
            Game q05 = ((WishListViewModel) this.this$0.T()).q0();
            q0 = this.this$0.q0();
            if (f0.g(q05, q0.p0().getValue())) {
                q04 = this.this$0.q0();
                if (f0.g(q04.r0().getValue(), this.this$0.j0())) {
                    return;
                }
            }
            q02 = this.this$0.q0();
            ((WishListViewModel) this.this$0.T()).w0(q02.p0().getValue());
            WishListFragment wishListFragment = this.this$0;
            q03 = wishListFragment.q0();
            wishListFragment.u0(q03.r0().getValue());
            this.this$0.s0();
        }
    }
}
