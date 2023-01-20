package com.jihuanshe.adapter;

import android.app.Activity;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.TopCommentInfo;
import e.t.j.h.g;
import e.t.k.a.c.a;
import e.t.o.d;
import e.t.r.a.b;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class CommentAdapter extends a<TopCommentInfo> {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final Activity f3748d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final b f3749e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final g f3750f;

    public CommentAdapter(@d Activity activity) {
        super(null, 1, null);
        this.f3748d = activity;
        this.f3749e = new b(d.a.c(e.t.o.d.a, null, 1, null).d(9));
        this.f3750f = e.t.j.h.d.a.a(new CommentAdapter$onClickLike$1(this));
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_top_comment;
    }

    @k.e.a.d
    public final Activity v() {
        return this.f3748d;
    }

    @k.e.a.d
    public final g w() {
        return this.f3750f;
    }

    @k.e.a.d
    public final b x() {
        return this.f3749e;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: y */
    public void u(@k.e.a.d TopCommentInfo topCommentInfo, @k.e.a.d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, topCommentInfo);
    }
}
