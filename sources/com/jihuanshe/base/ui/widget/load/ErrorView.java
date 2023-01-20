package com.jihuanshe.base.ui.widget.load;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;
import com.jihuanshe.base.R;
import com.vector.design.ui.decor.ErrorViewEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.t.i.a;
import h.k2.h;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0014\u0010\t\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/jihuanshe/base/ui/widget/load/ErrorView;", "Lcom/vector/design/ui/decor/ErrorViewEx;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "layoutId", "getLayoutId", "()I", "tvRetry", "Landroid/widget/TextView;", "getTvRetry", "()Landroid/widget/TextView;", "tvRetry$delegate", "Lkotlin/properties/ReadOnlyProperty;", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class ErrorView extends ErrorViewEx {

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ n<Object>[] f3894c = {n0.r(new PropertyReference1Impl(n0.d(ErrorView.class), "tvRetry", "getTvRetry()Landroid/widget/TextView;"))};
    @d
    private final e b;

    @h
    public ErrorView(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public ErrorView(@d Context context, @k.e.a.e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ErrorView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @Override // com.vector.design.ui.decor.ErrorViewEx
    public int getLayoutId() {
        return R.layout.layout_error_view;
    }

    @d
    public final TextView getTvRetry() {
        return (TextView) this.b.a(this, f3894c[0]);
    }

    @h
    public ErrorView(@d Context context, @k.e.a.e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = BindViewKt.p(this, R.id.error_view_tv_retry);
        a a = e.t.a.a();
        if (a.c() != 0) {
            setBackgroundResource(a.c());
        } else if (a.b() != 0) {
            setBackgroundColor(Res.k(a.b()));
        }
        b(getTvRetry());
    }
}
