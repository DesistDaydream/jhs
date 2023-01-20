package com.vector.view.swipe.header;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.widget.TextView;
import com.vector.R;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.view.ProgressView;
import com.vector.view.swipe.ScrollableExtend;
import h.k2.h;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.w;
import h.z;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020,H\u0016J\b\u0010.\u001a\u00020,H\u0016J\b\u0010/\u001a\u00020,H\u0016J\b\u00100\u001a\u00020,H\u0016J\b\u00101\u001a\u00020,H\u0014R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u0014\u0010\u0012\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001a\u001a\u0004\b\u001c\u0010\u0018R\u001b\u0010\u001e\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010\u001a\u001a\u0004\b\u001f\u0010\u0018R\u001b\u0010!\u001a\u00020\"8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u001a\u001a\u0004\b#\u0010$R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010\u001a\u001a\u0004\b(\u0010)¨\u00062"}, d2 = {"Lcom/vector/view/swipe/header/DefaultHeader;", "Lcom/vector/view/swipe/header/BaseLayoutHeader;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "animRotateDown", "Landroid/view/animation/Animation;", "getAnimRotateDown", "()Landroid/view/animation/Animation;", "animRotateDown$delegate", "Lkotlin/Lazy;", "animRotateUp", "getAnimRotateUp", "animRotateUp$delegate", "contentViewId", "getContentViewId", "()I", "ivArrow", "Landroid/view/View;", "getIvArrow", "()Landroid/view/View;", "ivArrow$delegate", "Lkotlin/properties/ReadOnlyProperty;", "layoutLoading", "getLayoutLoading", "layoutLoading$delegate", "layoutRefresh", "getLayoutRefresh", "layoutRefresh$delegate", "progressView", "Lcom/vector/view/ProgressView;", "getProgressView", "()Lcom/vector/view/ProgressView;", "progressView$delegate", "tvHint", "Landroid/widget/TextView;", "getTvHint", "()Landroid/widget/TextView;", "tvHint$delegate", "onError", "", "onFinish", "onLoading", "onNormal", "onReady", "setViews", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class DefaultHeader extends BaseLayoutHeader {

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f8071m;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final e f8072f;
    @d

    /* renamed from: g  reason: collision with root package name */
    private final e f8073g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final e f8074h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final e f8075i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final e f8076j;
    @d

    /* renamed from: k  reason: collision with root package name */
    private final w f8077k;
    @d

    /* renamed from: l  reason: collision with root package name */
    private final w f8078l;

    static {
        n<Object>[] nVarArr = new n[7];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(DefaultHeader.class), "layoutRefresh", "getLayoutRefresh()Landroid/view/View;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(DefaultHeader.class), "ivArrow", "getIvArrow()Landroid/view/View;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(DefaultHeader.class), "tvHint", "getTvHint()Landroid/widget/TextView;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(DefaultHeader.class), "layoutLoading", "getLayoutLoading()Landroid/view/View;"));
        nVarArr[4] = n0.r(new PropertyReference1Impl(n0.d(DefaultHeader.class), "progressView", "getProgressView()Lcom/vector/view/ProgressView;"));
        f8071m = nVarArr;
    }

    @h
    public DefaultHeader(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public DefaultHeader(@d Context context, @k.e.a.e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ DefaultHeader(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final Animation getAnimRotateDown() {
        return (Animation) this.f8078l.getValue();
    }

    private final Animation getAnimRotateUp() {
        return (Animation) this.f8077k.getValue();
    }

    private final View getIvArrow() {
        return (View) this.f8073g.a(this, f8071m[1]);
    }

    private final View getLayoutLoading() {
        return (View) this.f8075i.a(this, f8071m[3]);
    }

    private final View getLayoutRefresh() {
        return (View) this.f8072f.a(this, f8071m[0]);
    }

    private final ProgressView getProgressView() {
        return (ProgressView) this.f8076j.a(this, f8071m[4]);
    }

    private final TextView getTvHint() {
        return (TextView) this.f8074h.a(this, f8071m[2]);
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void b() {
        ViewKt.I(getLayoutRefresh());
        ViewKt.n(getLayoutLoading());
        getProgressView().A();
        if (getLastState() == ScrollableExtend.State.READY) {
            getIvArrow().startAnimation(getAnimRotateDown());
        } else if (getLastState() == ScrollableExtend.State.LOADING) {
            getIvArrow().clearAnimation();
        }
        getTvHint().setText(R.string.sr_list_header_hint_normal);
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void c() {
        getIvArrow().clearAnimation();
        ViewKt.n(getLayoutRefresh());
        ViewKt.I(getLayoutLoading());
        getProgressView().z();
    }

    @Override // com.vector.view.swipe.header.BaseLayoutHeader
    public int getContentViewId() {
        return R.layout.layout_scrollable_header;
    }

    @Override // com.vector.view.swipe.header.BaseLayoutHeader
    public void n() {
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onError() {
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onFinish() {
        ViewKt.n(getLayoutRefresh());
        ViewKt.I(getLayoutLoading());
    }

    @Override // com.vector.view.swipe.ScrollableExtend
    public void onReady() {
        ViewKt.I(getLayoutRefresh());
        ViewKt.n(getLayoutLoading());
        if (getLastState() != ScrollableExtend.State.READY) {
            getIvArrow().clearAnimation();
            getIvArrow().startAnimation(getAnimRotateUp());
            getTvHint().setText(R.string.sr_list_header_hint_ready);
        }
    }

    @h
    public DefaultHeader(@d Context context, @k.e.a.e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f8072f = BindViewKt.p(this, R.id.scrollable_header_layout_refresh);
        this.f8073g = BindViewKt.p(this, R.id.scrollable_header_iv_arrow);
        this.f8074h = BindViewKt.p(this, R.id.scrollable_header_tv_hint);
        this.f8075i = BindViewKt.p(this, R.id.scrollable_header_layout_loading);
        this.f8076j = BindViewKt.p(this, R.id.scrollable_header_progress_view);
        this.f8077k = z.c(new DefaultHeader$animRotateUp$2(context));
        this.f8078l = z.c(new DefaultHeader$animRotateDown$2(context));
    }
}
