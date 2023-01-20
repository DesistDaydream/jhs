package com.vector.design.ui.decor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.annotation.IdRes;
import com.vector.ext.view.ViewKt;
import e.j.a.b.c.r.c0;
import e.t.l.k;
import e.t.u.p;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0010\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u0016\u001a\u00020\u0007R\u0012\u0010\t\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/vector/design/ui/decor/ErrorViewEx;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "layoutId", "getLayoutId", "()I", c0.a.a, "Landroid/view/View$OnClickListener;", "getListener", "()Landroid/view/View$OnClickListener;", "setListener", "(Landroid/view/View$OnClickListener;)V", "retryWith", "", "v", "Landroid/view/View;", "id", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class ErrorViewEx extends RelativeLayout {
    @e
    private View.OnClickListener a;

    @h
    public ErrorViewEx(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public ErrorViewEx(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ErrorViewEx(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void a(@IdRes int i2) {
        ViewKt.x(findViewById(i2), new ErrorViewEx$retryWith$2(this));
    }

    public final void b(@e View view) {
        ViewKt.x(view, new ErrorViewEx$retryWith$1(this));
    }

    public abstract int getLayoutId();

    @e
    public final View.OnClickListener getListener() {
        return this.a;
    }

    public final void setListener(@e View.OnClickListener onClickListener) {
        this.a = onClickListener;
    }

    @h
    public ErrorViewEx(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        addView(k.i(context, getLayoutId(), null, false, 6, null), p.p(-1, -1));
    }
}
