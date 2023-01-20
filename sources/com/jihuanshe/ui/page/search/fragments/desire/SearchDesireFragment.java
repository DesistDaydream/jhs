package com.jihuanshe.ui.page.search.fragments.desire;

import com.jihuanshe.ui.page.user.wish.DesireFragment;
import e.l.s.m.c;
import e.l.s.o.e.a;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;

@Creator
/* loaded from: classes2.dex */
public final class SearchDesireFragment extends DesireFragment {
    @d
    private final w w = z.c(new SearchDesireFragment$parentViewModel$2(this));

    @Override // com.jihuanshe.ui.page.user.wish.DesireFragment, com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        super.d();
        ((a) T()).s0().setValue(Boolean.TRUE);
        j0().s0().j(this, new SearchDesireFragment$flowOfSetup$1(this));
    }

    @Override // com.jihuanshe.ui.page.user.wish.DesireFragment
    public boolean i0() {
        return true;
    }

    @d
    public final c j0() {
        return (c) this.w.getValue();
    }
}
