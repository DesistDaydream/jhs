package com.jihuanshe.ui.page.entrepot;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.ui.BaseFragment;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.design.ui.frag.SimpleFragEx;
import e.l.k.u7;
import e.l.s.h.b;
import e.n.f;
import e.t.k.a.c.h.c;
import f.a.a.a;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class SearchMyStorehouseFragment extends BaseFragment<b> {
    @d
    private final w r = z.c(new SearchMyStorehouseFragment$parentViewModel$2(this));
    @d
    private final w s = z.c(new SearchMyStorehouseFragment$adapter$2(this));
    @d
    private final w t = z.c(new SearchMyStorehouseFragment$pagers$2(this));
    @a
    @e
    private Integer typeFrom;

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        f.g(g0().s0(), null, new SearchMyStorehouseFragment$flowOfSetup$1(this), 1, null);
    }

    @d
    public final FragPagerAdapter e0() {
        return (FragPagerAdapter) this.s.getValue();
    }

    @d
    public final c f0() {
        return (c) this.t.getValue();
    }

    @d
    public final e.l.s.m.c g0() {
        return (e.l.s.m.c) this.r.getValue();
    }

    @e
    public final Integer h0() {
        return this.typeFrom;
    }

    public final void i0(@e Integer num) {
        this.typeFrom = num;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @d
    public ViewDataBinding s() {
        u7 e2 = u7.e(getLayoutInflater());
        e2.i(this);
        e2.j((b) T());
        return e2;
    }
}
