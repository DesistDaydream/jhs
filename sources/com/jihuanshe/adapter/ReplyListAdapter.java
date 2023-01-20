package com.jihuanshe.adapter;

import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.ui.page.detail.ReplyListActivity;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import e.t.j.h.g;
import e.t.k.a.c.a;
import k.e.a.d;

/* loaded from: classes2.dex */
public final class ReplyListAdapter extends a<ReplyDetailInfo> {
    @d

    /* renamed from: d  reason: collision with root package name */
    private final ReplyListActivity f3759d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final ReplyListViewModel f3760e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final MovementMethod f3761f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final g f3762g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final g f3763h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final g f3764i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final g f3765j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final e.t.r.a.a f3766k;

    public ReplyListAdapter(@d ReplyListActivity replyListActivity, @d ReplyListViewModel replyListViewModel) {
        super(null, 1, null);
        this.f3759d = replyListActivity;
        this.f3760e = replyListViewModel;
        this.f3761f = LinkMovementMethod.getInstance();
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.f3762g = dVar.a(ReplyListAdapter$onClickHead$1.INSTANCE);
        this.f3763h = dVar.a(new ReplyListAdapter$onClickMore$1(this));
        this.f3764i = dVar.a(new ReplyListAdapter$onClickFavor$1(this));
        this.f3765j = dVar.a(new ReplyListAdapter$onClickContent$1(this));
        this.f3766k = new e.t.r.a.a(0, 0, 3, null);
    }

    @d
    public final e.t.r.a.a A() {
        return this.f3766k;
    }

    @d
    public final ReplyListViewModel B() {
        return this.f3760e;
    }

    @Override // e.t.k.a.c.a
    /* renamed from: C */
    public void u(@d ReplyDetailInfo replyDetailInfo, @d ViewDataBinding viewDataBinding) {
        viewDataBinding.setVariable(2, this);
        viewDataBinding.setVariable(8, replyDetailInfo);
    }

    @d
    public final ReplyListActivity getActivity() {
        return this.f3759d;
    }

    @Override // e.t.k.a.c.a
    public int t() {
        return R.layout.item_reply_list;
    }

    @d
    public final MovementMethod v() {
        return this.f3761f;
    }

    @d
    public final g w() {
        return this.f3765j;
    }

    @d
    public final g x() {
        return this.f3764i;
    }

    @d
    public final g y() {
        return this.f3762g;
    }

    @d
    public final g z() {
        return this.f3763h;
    }
}
