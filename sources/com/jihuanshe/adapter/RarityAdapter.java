package com.jihuanshe.adapter;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.Rarity;
import e.l.s.c;
import e.t.j.h.g;
import e.t.k.a.c.a;
import h.k2.v.u;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class RarityAdapter extends a<Rarity> {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final c f3756d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f3757e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final List<Integer> f3758f;

    public RarityAdapter(@d c cVar, boolean z) {
        super(null, 1, null);
        this.f3756d = cVar;
        this.f3757e = z;
        this.f3758f = new ArrayList();
    }

    public final boolean A(int i2) {
        return this.f3758f.contains(Integer.valueOf(i2));
    }

    @Override // e.t.k.a.c.a
    /* renamed from: B */
    public void u(@d Rarity rarity, @d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(10, this);
        viewDataBinding.setVariable(8, rarity);
        viewDataBinding.setVariable(11, Integer.valueOf(j()));
        viewDataBinding.setVariable(16, Boolean.valueOf(A(j())));
    }

    public final void C(boolean z) {
        this.f3757e = z;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.view_rarity;
    }

    public final void w() {
        this.f3758f.clear();
    }

    @d
    public final g x(int i2) {
        return e.t.j.h.d.a.a(new RarityAdapter$click$1(this, i2));
    }

    @d
    public final c y() {
        return this.f3756d;
    }

    public final boolean z() {
        return this.f3757e;
    }

    public /* synthetic */ RarityAdapter(c cVar, boolean z, int i2, u uVar) {
        this(cVar, (i2 & 2) != 0 ? false : z);
    }
}
