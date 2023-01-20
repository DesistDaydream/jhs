package com.jihuanshe.ui.page.photo;

import androidx.core.view.ViewCompat;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.ui.BaseFragment;
import com.jihuanshe.viewmodel.photo.RecentPhotoViewModel;
import com.vector.util.LayoutManagers;
import e.l.g.n0;
import e.l.k.i7;
import e.t.j.h.d;
import e.t.j.h.l;
import e.t.j.h.p;
import f.a.a.a;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;

@Creator
/* loaded from: classes2.dex */
public final class RecentPhotoFragment extends BaseFragment<RecentPhotoViewModel> {
    @a
    @e
    private String gameKey;
    @d
    private final w r = z.c(RecentPhotoFragment$adapter$2.INSTANCE);
    @d
    private final w s = z.c(RecentPhotoFragment$layoutManager$2.INSTANCE);
    @d
    private final w t = z.c(RecentPhotoFragment$decoration$2.INSTANCE);
    @d
    private final l u = d.e.a.a(new RecentPhotoFragment$onItemClick$1(this));
    @k.e.a.d
    private final p v = d.g.a.a(new RecentPhotoFragment$onLoadMore$1(this));
    @a
    @e
    private Integer versionId;

    @Override // com.vector.design.ui.frag.SimpleFragEx, e.t.k.a.a
    public void d() {
        m(R.color.transparent);
        Q(ViewCompat.MEASURED_STATE_MASK);
        BinderKt.p(BinderKt.t(RecentPhotoViewModel.s0((RecentPhotoViewModel) T(), this.gameKey, this.versionId, null, 4, null), this, false, 2, null));
    }

    @k.e.a.d
    public final n0 e0() {
        return (n0) this.r.getValue();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.a f0() {
        return (e.l.h.j.b.f.a) this.t.getValue();
    }

    @e
    public final String g0() {
        return this.gameKey;
    }

    @k.e.a.d
    public final LayoutManagers.a h0() {
        return (LayoutManagers.a) this.s.getValue();
    }

    @k.e.a.d
    public final l i0() {
        return this.u;
    }

    @k.e.a.d
    public final p j0() {
        return this.v;
    }

    @e
    public final Integer k0() {
        return this.versionId;
    }

    public final void l0(@e String str) {
        this.gameKey = str;
    }

    public final void m0(@e Integer num) {
        this.versionId = num;
    }

    @Override // com.vector.design.ui.frag.SimpleFragEx
    @k.e.a.d
    public ViewDataBinding s() {
        i7 e2 = i7.e(getLayoutInflater());
        e2.i(this);
        e2.j((RecentPhotoViewModel) T());
        return e2;
    }
}
