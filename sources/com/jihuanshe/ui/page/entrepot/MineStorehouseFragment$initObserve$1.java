package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import e.g.d.a;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$initObserve$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$initObserve$1(MineStorehouseFragment mineStorehouseFragment) {
        super(1);
        this.this$0 = mineStorehouseFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        a G0;
        a G02;
        a G03;
        if (i2 == 1) {
            String k0 = this.this$0.k0();
            if (f0.g(k0, "FRAGMENT_CHECK")) {
                this.this$0.m0().setVisibility(0);
                this.this$0.n0().setVisibility(8);
                this.this$0.o0().setVisibility(8);
                MineStorehouseViewModel.s0((MineStorehouseViewModel) this.this$0.T(), "waiting_receive", null, 2, null);
                G03 = ((MineStorehouseViewModel) this.this$0.T()).G0(SearchChildCheckFragment.B, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
                BinderKt.o(G03, this.this$0);
                return;
            } else if (f0.g(k0, "FRAGMENT_HOUSE")) {
                this.this$0.m0().setVisibility(0);
                this.this$0.n0().setVisibility(8);
                this.this$0.o0().setVisibility(8);
                G02 = ((MineStorehouseViewModel) this.this$0.T()).G0(SearchChildCheckFragment.C, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
                BinderKt.o(G02, this.this$0);
                return;
            } else {
                this.this$0.m0().setVisibility(8);
                this.this$0.n0().setVisibility(8);
                this.this$0.o0().setVisibility(0);
                BinderKt.o(MineStorehouseViewModel.E0((MineStorehouseViewModel) this.this$0.T(), 1, null, 2, null), this.this$0);
                return;
            }
        }
        String k02 = this.this$0.k0();
        if (f0.g(k02, "FRAGMENT_CHECK")) {
            this.this$0.m0().setVisibility(8);
            this.this$0.n0().setVisibility(0);
            this.this$0.o0().setVisibility(8);
            BinderKt.o(MineStorehouseViewModel.A0((MineStorehouseViewModel) this.this$0.T(), null, null, null, 7, null), this.this$0);
        } else if (f0.g(k02, "FRAGMENT_HOUSE")) {
            this.this$0.m0().setVisibility(0);
            this.this$0.n0().setVisibility(8);
            this.this$0.o0().setVisibility(8);
            G0 = ((MineStorehouseViewModel) this.this$0.T()).G0(SearchChildCheckFragment.D, (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
            BinderKt.o(G0, this.this$0);
        } else {
            this.this$0.m0().setVisibility(8);
            this.this$0.n0().setVisibility(8);
            this.this$0.o0().setVisibility(0);
            BinderKt.o(MineStorehouseViewModel.E0((MineStorehouseViewModel) this.this$0.T(), 0, null, 2, null), this.this$0);
        }
    }
}
