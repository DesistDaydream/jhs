package com.jihuanshe.base.ui.widget.load;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.jihuanshe.base.R;
import com.vector.util.Res;
import e.t.i.a;
import e.t.l.k;
import e.t.o.d;
import e.t.u.p;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/jihuanshe/base/ui/widget/load/LoadingView;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class LoadingView extends FrameLayout {
    public LoadingView(@d Context context) {
        this(context, null);
    }

    public LoadingView(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadingView(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a a = e.t.a.a();
        if (a.c() != 0) {
            setBackgroundResource(a.c());
        } else if (a.b() != 0) {
            setBackgroundColor(Res.k(a.b()));
        }
        View i3 = k.i(getContext(), R.layout.layout_loading_view, null, false, 6, null);
        d.a aVar = e.t.o.d.a;
        FrameLayout.LayoutParams h2 = p.h(d.a.c(aVar, null, 1, null).d(60), d.a.c(aVar, null, 1, null).d(60));
        h2.gravity = 17;
        addView(i3, h2);
    }
}
