package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.MineStorehouseViewModel;
import com.vector.design.ui.delegate.LoadMore;
import e.g.d.a;
import e.t.v.j.g;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class MineStorehouseFragment$onLoadMore$1 extends Lambda implements p<g<?>, LoadMore.State, t1> {
    public final /* synthetic */ MineStorehouseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MineStorehouseFragment$onLoadMore$1(MineStorehouseFragment mineStorehouseFragment) {
        super(2);
        this.this$0 = mineStorehouseFragment;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar, LoadMore.State state) {
        invoke2(gVar, state);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar, @d LoadMore.State state) {
        a G0;
        a G02;
        a G03;
        String k0 = this.this$0.k0();
        if (f0.g(k0, "FRAGMENT_CHECK")) {
            Integer value = ((MineStorehouseViewModel) this.this$0.T()).F0().getValue();
            if (value != null && value.intValue() == 1) {
                G03 = ((MineStorehouseViewModel) this.this$0.T()).G0(SearchChildCheckFragment.B, (r13 & 2) != 0 ? null : state, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
                BinderKt.d(G03, this.this$0, gVar, true);
                return;
            }
            BinderKt.d(MineStorehouseViewModel.A0((MineStorehouseViewModel) this.this$0.T(), state, null, null, 6, null), this.this$0, gVar, true);
        } else if (f0.g(k0, "FRAGMENT_HOUSE")) {
            Integer value2 = ((MineStorehouseViewModel) this.this$0.T()).F0().getValue();
            if (value2 != null && value2.intValue() == 1) {
                G02 = ((MineStorehouseViewModel) this.this$0.T()).G0(SearchChildCheckFragment.C, (r13 & 2) != 0 ? null : state, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
                BinderKt.d(G02, this.this$0, gVar, true);
                return;
            }
            G0 = ((MineStorehouseViewModel) this.this$0.T()).G0(SearchChildCheckFragment.D, (r13 & 2) != 0 ? null : state, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
            BinderKt.d(G0, this.this$0, gVar, true);
        } else {
            Integer value3 = ((MineStorehouseViewModel) this.this$0.T()).F0().getValue();
            if (value3 != null && value3.intValue() == 1) {
                BinderKt.d(((MineStorehouseViewModel) this.this$0.T()).C0(1, state), this.this$0, gVar, true);
            } else {
                BinderKt.d(((MineStorehouseViewModel) this.this$0.T()).C0(0, state), this.this$0, gVar, true);
            }
        }
    }
}
