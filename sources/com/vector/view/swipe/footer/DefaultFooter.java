package com.vector.view.swipe.footer;

import android.content.Context;
import android.view.View;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.vector.R;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.view.ProgressView;
import h.k2.u.l;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.t1;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016R\u0014\u0010\u0005\u001a\u00020\u00068TX\u0094\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lcom/vector/view/swipe/footer/DefaultFooter;", "Lcom/vector/view/swipe/footer/BaseFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentViewId", "", "getContentViewId", "()I", "layoutLoading", "Landroid/view/View;", "getLayoutLoading", "()Landroid/view/View;", "layoutLoading$delegate", "Lkotlin/properties/ReadOnlyProperty;", "layoutReloadMore", "getLayoutReloadMore", "layoutReloadMore$delegate", "progressView", "Lcom/vector/view/ProgressView;", "getProgressView", "()Lcom/vector/view/ProgressView;", "progressView$delegate", "onError", "", "onFinish", "onLoading", "onNormal", "onReady", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DefaultFooter extends BaseFooter {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f8064g = {n0.r(new PropertyReference1Impl(n0.d(DefaultFooter.class), "layoutLoading", "getLayoutLoading()Landroid/view/View;")), n0.r(new PropertyReference1Impl(n0.d(DefaultFooter.class), "layoutReloadMore", "getLayoutReloadMore()Landroid/view/View;")), n0.r(new PropertyReference1Impl(n0.d(DefaultFooter.class), "progressView", "getProgressView()Lcom/vector/view/ProgressView;"))};
    @d

    /* renamed from: d  reason: collision with root package name */
    private final e f8065d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private final e f8066e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final e f8067f;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", AdvanceSetting.NETWORK_TYPE, "Landroid/view/View;"}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.vector.view.swipe.footer.DefaultFooter$1  reason: invalid class name */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements l<View, t1> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(View view) {
            invoke2(view);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@d View view) {
            l<View, t1> onRetryClick = DefaultFooter.this.getOnRetryClick();
            if (onRetryClick == null) {
                return;
            }
            onRetryClick.invoke(view);
        }
    }

    public DefaultFooter(@d Context context) {
        super(context, null, 0, 6, null);
        this.f8065d = BindViewKt.p(this, R.id.scrollable_footer_layout_loading);
        this.f8066e = BindViewKt.p(this, R.id.scrollable_footer_tv_reload_more);
        this.f8067f = BindViewKt.p(this, R.id.scrollable_footer_progress_view);
        ViewKt.x(getLayoutReloadMore(), new AnonymousClass1());
    }

    private final View getLayoutLoading() {
        return (View) this.f8065d.a(this, f8064g[0]);
    }

    private final View getLayoutReloadMore() {
        return (View) this.f8066e.a(this, f8064g[1]);
    }

    private final ProgressView getProgressView() {
        return (ProgressView) this.f8067f.a(this, f8064g[2]);
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void b() {
        ViewKt.I(getLayoutLoading());
        ViewKt.o(getLayoutReloadMore());
        getProgressView().A();
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void c() {
        ViewKt.I(getLayoutLoading());
        ViewKt.o(getLayoutReloadMore());
        getProgressView().z();
    }

    @Override // com.vector.view.swipe.footer.BaseFooter
    public int getContentViewId() {
        return R.layout.layout_scrollable_footer;
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onError() {
        ViewKt.o(getLayoutLoading());
        ViewKt.I(getLayoutReloadMore());
        getProgressView().A();
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onFinish() {
        getProgressView().A();
        d();
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onReady() {
    }
}
