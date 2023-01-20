package com.jihuanshe.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.LoadMoreView;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.view.ProgressView;
import com.vector.view.swipe.footer.BaseFooter;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class LoadMoreView extends BaseFooter {

    /* renamed from: i */
    public static final /* synthetic */ n<Object>[] f4142i = {n0.r(new PropertyReference1Impl(n0.d(LoadMoreView.class), "loadMoreFail", "getLoadMoreFail()Landroid/view/View;")), n0.r(new PropertyReference1Impl(n0.d(LoadMoreView.class), "progressView", "getProgressView()Lcom/vector/view/ProgressView;")), n0.r(new PropertyReference1Impl(n0.d(LoadMoreView.class), "progressViewLoad", "getProgressViewLoad()Landroid/widget/LinearLayout;")), n0.r(new PropertyReference1Impl(n0.d(LoadMoreView.class), "noMore", "getNoMore()Landroid/view/View;")), n0.r(new PropertyReference1Impl(n0.d(LoadMoreView.class), "noMoreTv", "getNoMoreTv()Landroid/widget/TextView;"))};
    @d

    /* renamed from: d */
    private final e f4143d;
    @d

    /* renamed from: e */
    private final e f4144e;
    @d

    /* renamed from: f */
    private final e f4145f;
    @d

    /* renamed from: g */
    private final e f4146g;
    @d

    /* renamed from: h */
    private final e f4147h;

    public LoadMoreView(@d Context context) {
        super(context, null, 0, 6, null);
        this.f4143d = BindViewKt.p(this, R.id.scrollable_footer_tv_load_fail);
        this.f4144e = BindViewKt.p(this, R.id.scrollable_footer_progress_view);
        this.f4145f = BindViewKt.p(this, R.id.scrollable_footer_layout_loading);
        this.f4146g = BindViewKt.p(this, R.id.scrollable_footer_no_more);
        this.f4147h = BindViewKt.p(this, R.id.noMoreTv);
        post(new Runnable() { // from class: e.l.q.c.v
            @Override // java.lang.Runnable
            public final void run() {
                LoadMoreView.i(LoadMoreView.this);
            }
        });
    }

    private final View getLoadMoreFail() {
        return (View) this.f4143d.a(this, f4142i[0]);
    }

    private final View getNoMore() {
        return (View) this.f4146g.a(this, f4142i[3]);
    }

    private final TextView getNoMoreTv() {
        return (TextView) this.f4147h.a(this, f4142i[4]);
    }

    private final ProgressView getProgressView() {
        return (ProgressView) this.f4144e.a(this, f4142i[1]);
    }

    private final LinearLayout getProgressViewLoad() {
        return (LinearLayout) this.f4145f.a(this, f4142i[2]);
    }

    public static final void h(LoadMoreView loadMoreView) {
        ViewKt.x(loadMoreView.getLoadMoreFail(), new LoadMoreView$1$1(loadMoreView));
    }

    public static /* synthetic */ void i(LoadMoreView loadMoreView) {
        h(loadMoreView);
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void b() {
        ViewKt.n(getLoadMoreFail());
        ViewKt.n(getNoMore());
        getProgressView().A();
        ViewKt.I(getProgressViewLoad());
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void c() {
        ViewKt.n(getLoadMoreFail());
        ViewKt.n(getNoMore());
        getProgressView().z();
        ViewKt.I(getProgressViewLoad());
    }

    @Override // com.vector.view.swipe.footer.BaseFooter
    public int getContentViewId() {
        return R.layout.layout_load_more_view;
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onError() {
        ViewKt.I(getLoadMoreFail());
        ViewKt.n(getNoMore());
        getProgressView().A();
        ViewKt.n(getProgressViewLoad());
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onFinish() {
        ViewKt.I(getNoMore());
        getProgressView().A();
        ViewKt.n(getProgressViewLoad());
        ViewKt.n(getLoadMoreFail());
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onReady() {
        ViewKt.n(getLoadMoreFail());
        ViewKt.n(getNoMore());
        ViewKt.I(getProgressViewLoad());
    }

    @Override // com.vector.view.swipe.footer.BaseFooter
    public void setNoMoreText(@d String str) {
        getNoMoreTv().setText(str);
    }
}
