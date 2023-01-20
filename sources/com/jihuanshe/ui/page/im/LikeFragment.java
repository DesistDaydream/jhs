package com.jihuanshe.ui.page.im;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.adapter.LikeAdapter;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.im.LikeViewModel;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.util.LayoutManagers;
import e.l.h.d.f;
import e.l.h.j.b.f.b;
import e.l.j.a;
import e.l.k.w6;
import e.t.j.h.d;
import e.t.j.h.l;
import e.t.j.h.p;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;

@Creator
/* loaded from: classes2.dex */
public final class LikeFragment extends BaseFragment<LikeViewModel> {
    @d
    private final w r = z.c(LikeFragment$adapter$2.INSTANCE);
    @d
    private final w s = z.c(LikeFragment$layoutManager$2.INSTANCE);
    @d
    private final w t = z.c(LikeFragment$decoration$2.INSTANCE);
    @d
    private final p u = d.g.a.a(new LikeFragment$onLoadMore$1(this));
    @k.e.a.d
    private final l v = d.e.a.a(new LikeFragment$onItemClick$1(this));

    private final void j0() {
        f.b.e(this).g(a.w, new LikeFragment$initObserver$1(this));
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public SimpleFragEx.LazyLoadMode F() {
        return SimpleFragEx.LazyLoadMode.RESUME;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        j0();
        BinderKt.p(BinderKt.t(LikeViewModel.r0((LikeViewModel) T(), null, 1, null), this, false, 2, null));
    }

    @k.e.a.d
    public final LikeAdapter e0() {
        return (LikeAdapter) this.r.getValue();
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
    public final l h0() {
        return this.v;
    }

    @k.e.a.d
    public final p i0() {
        return this.u;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        w6 e2 = w6.e(getLayoutInflater());
        e2.i(this);
        e2.j((LikeViewModel) T());
        return e2;
    }
}
