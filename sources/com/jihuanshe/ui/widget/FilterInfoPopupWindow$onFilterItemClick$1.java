package com.jihuanshe.ui.widget;

import android.view.View;
import android.view.animation.Animation;
import e.l.s.a;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterInfoPopupWindow$onFilterItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ FilterInfoPopupWindow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInfoPopupWindow$onFilterItemClick$1(FilterInfoPopupWindow filterInfoPopupWindow) {
        super(2);
        this.this$0 = filterInfoPopupWindow;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        if (this.this$0.e() == null) {
            return;
        }
        Animation i3 = this.this$0.i();
        boolean z = false;
        if (i3 != null && !i3.hasEnded()) {
            z = true;
        }
        if (z) {
            return;
        }
        l<a, t1> g2 = this.this$0.g();
        if (g2 != null) {
            g2.invoke(this.this$0.e().get(i2));
        }
        this.this$0.dismiss();
    }
}
