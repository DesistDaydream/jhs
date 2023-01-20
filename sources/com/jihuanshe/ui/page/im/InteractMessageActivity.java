package com.jihuanshe.ui.page.im;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.viewmodel.im.InteractMessageViewModel;
import com.vector.design.ui.adapter.pager.FragPagerAdapter;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import com.vector.view.pager.ViewPager;
import e.l.h.d.f;
import e.l.j.a;
import e.l.k.e1;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.y;
import e.t.k.a.c.h.c;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class InteractMessageActivity extends BaseActivity<InteractMessageViewModel> {
    public static final /* synthetic */ n<Object>[] y;
    @d
    private final e n = BindViewKt.n(this, R.id.replyTv);
    @d
    private final e o = BindViewKt.n(this, R.id.atTv);
    @d
    private final e p = BindViewKt.n(this, R.id.likeTv);
    @d
    private final e q = BindViewKt.n(this, R.id.viewPager);
    @d
    private final c r;
    @d
    private final g s;
    @d
    private final g t;
    @d
    private final g u;
    @d
    private final y v;
    @d
    private final w w;
    @k.e.a.e
    private View x;

    static {
        n<Object>[] nVarArr = new n[5];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(InteractMessageActivity.class), "replyTv", "getReplyTv()Landroid/widget/TextView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(InteractMessageActivity.class), "atTv", "getAtTv()Landroid/widget/TextView;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(InteractMessageActivity.class), "likeTv", "getLikeTv()Landroid/widget/TextView;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(InteractMessageActivity.class), "viewPager", "getViewPager()Lcom/vector/view/pager/ViewPager;"));
        y = nVarArr;
    }

    public InteractMessageActivity() {
        Res res = Res.a;
        this.r = e.t.k.a.c.h.d.a(CollectionsKt__CollectionsKt.P(InteractMessageActivity$pager$1.INSTANCE, InteractMessageActivity$pager$2.INSTANCE, InteractMessageActivity$pager$3.INSTANCE), CollectionsKt__CollectionsKt.P(Res.w(res, R.string.comment_reply_me, null, 2, null), Res.w(res, R.string.comment_at_me, null, 2, null), Res.w(res, R.string.comment_like, null, 2, null)));
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.s = dVar.a(new InteractMessageActivity$onClickReply$1(this));
        this.t = dVar.a(new InteractMessageActivity$onClickAt$1(this));
        this.u = dVar.a(new InteractMessageActivity$onClickLike$1(this));
        this.v = d.j.a.c(new InteractMessageActivity$onPageSelect$1(this));
        this.w = z.c(new InteractMessageActivity$adapter$2(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView c0() {
        return (TextView) this.o.a(this, y[1]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView d0() {
        return (TextView) this.p.a(this, y[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TextView j0() {
        return (TextView) this.n.a(this, y[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ViewPager k0() {
        return (ViewPager) this.q.a(this, y[3]);
    }

    private final void l0() {
        f fVar = f.b;
        fVar.e(this).g(a.w, new InteractMessageActivity$initObserver$1(this));
        fVar.e(this).g(a.z, new InteractMessageActivity$initObserver$2(this));
        fVar.e(this).g(a.x, new InteractMessageActivity$initObserver$3(this));
        fVar.e(this).g(a.y, new InteractMessageActivity$initObserver$4(this));
    }

    @k.e.a.d
    public final FragPagerAdapter b0() {
        return (FragPagerAdapter) this.w.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        m(R.color.white);
        l0();
        this.v.a().invoke(0);
        ((InteractMessageViewModel) L()).p0();
    }

    @k.e.a.d
    public final g e0() {
        return this.t;
    }

    @k.e.a.d
    public final g f0() {
        return this.u;
    }

    @k.e.a.d
    public final g g0() {
        return this.s;
    }

    @k.e.a.d
    public final y h0() {
        return this.v;
    }

    @k.e.a.d
    public final c i0() {
        return this.r;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(InteractMessageActivity$flowOfAppBar$1.INSTANCE);
        this.x = w().getEnd().d(new InteractMessageActivity$flowOfAppBar$2(this));
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        e1 e2 = e1.e(getLayoutInflater());
        e2.i(this);
        e2.j((InteractMessageViewModel) L());
        return e2;
    }
}
