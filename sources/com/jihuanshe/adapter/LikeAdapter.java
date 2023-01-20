package com.jihuanshe.adapter;

import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.InteractData;
import e.t.j.h.g;
import e.t.k.a.c.a;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class LikeAdapter extends a<InteractData> {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final e.t.r.a.a f3753d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final g f3754e;

    public LikeAdapter() {
        super(null, 1, null);
        this.f3753d = new e.t.r.a.a(0, 0, 3, null);
        this.f3754e = e.t.j.h.d.a.a(LikeAdapter$onClickUser$1.INSTANCE);
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_like;
    }

    @d
    public final g v() {
        return this.f3754e;
    }

    @d
    public final e.t.r.a.a w() {
        return this.f3753d;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: x */
    public void u(@d InteractData interactData, @d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(11, Integer.valueOf(j()));
        viewDataBinding.setVariable(8, interactData);
        viewDataBinding.setVariable(2, this);
    }
}
