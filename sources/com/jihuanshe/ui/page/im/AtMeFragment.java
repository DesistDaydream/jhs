package com.jihuanshe.ui.page.im;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.adapter.AtMeAdapter;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.im.AtMeViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.util.LayoutManagers;
import e.l.h.d.f;
import e.l.h.j.b.f.b;
import e.l.j.a;
import e.l.k.i6;
import e.t.j.h.d;
import e.t.j.h.l;
import e.t.j.h.p;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;

@Creator
/* loaded from: classes2.dex */
public final class AtMeFragment extends BaseFragment<AtMeViewModel> {
    @d
    private final w r = z.c(AtMeFragment$adapter$2.INSTANCE);
    @d
    private final w s = z.c(AtMeFragment$layoutManager$2.INSTANCE);
    @d
    private final w t = z.c(AtMeFragment$decoration$2.INSTANCE);
    @d
    private final p u = d.g.a.a(new AtMeFragment$loadMore$1(this));
    @k.e.a.d
    private final l v = d.e.a.a(new AtMeFragment$onItemClick$1(this));

    private final void j0() {
        f.b.e(this).g(a.w, new AtMeFragment$initObserver$1(this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        j0();
        BinderKt.p(BinderKt.t(AtMeViewModel.r0((AtMeViewModel) T(), null, 1, null), this, false, 2, null));
    }

    @k.e.a.d
    public final AtMeAdapter e0() {
        return (AtMeAdapter) this.r.getValue();
    }

    @k.e.a.d
    public final b f0() {
        return (b) this.t.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a g0() {
        return (LayoutManagers.a) this.s.getValue();
    }

    @k.e.a.d
    public final p h0() {
        return this.u;
    }

    @k.e.a.d
    public final l i0() {
        return this.v;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        i6 e2 = i6.e(getLayoutInflater());
        e2.i(this);
        e2.j((AtMeViewModel) T());
        return e2;
    }
}
