package com.vector.design.ui.decor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.android.tpush.common.MessageKey;
import com.vector.util.Res;
import com.vector.view.ProgressView;
import e.t.i.a;
import h.k2.h;
import h.k2.v.u;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\u0018\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0002R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vector/design/ui/decor/LoadingView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pv", "Lcom/vector/view/ProgressView;", "getPv", "()Lcom/vector/view/ProgressView;", "pv$delegate", "Lkotlin/Lazy;", "pvDelegate", "Lkotlin/Lazy;", "onAttachedToWindow", "", "onDetachedFromWindow", "onVisibilityChanged", "changedView", "Landroid/view/View;", "visibility", MessageKey.MSG_ACCEPT_TIME_START, "stop", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class LoadingView extends RelativeLayout {
    @d
    private final w<ProgressView> a;
    @d
    private final w b;

    @h
    public LoadingView(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public LoadingView(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ LoadingView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void a() {
        getPv().z();
    }

    private final void b() {
        if (this.a.isInitialized()) {
            getPv().A();
        }
    }

    private final ProgressView getPv() {
        return (ProgressView) this.b.getValue();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getVisibility() == 0) {
            a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@d View view, int i2) {
        if (i2 == 0) {
            a();
        } else if (i2 == 4 || i2 == 8) {
            b();
        }
    }

    @h
    public LoadingView(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        w<ProgressView> c2 = z.c(new LoadingView$pvDelegate$1(context, this));
        this.a = c2;
        this.b = c2;
        a a = e.t.a.a();
        if (a.c() != 0) {
            setBackgroundResource(a.c());
        } else if (a.b() != 0) {
            setBackgroundColor(Res.k(a.b()));
        }
    }
}
