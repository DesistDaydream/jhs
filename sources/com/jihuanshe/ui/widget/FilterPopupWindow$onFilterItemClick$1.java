package com.jihuanshe.ui.widget;

import android.view.View;
import android.view.animation.Animation;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterPopupWindow$onFilterItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ FilterPopupWindow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterPopupWindow$onFilterItemClick$1(FilterPopupWindow filterPopupWindow) {
        super(2);
        this.this$0 = filterPopupWindow;
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
        Animation j2 = this.this$0.j();
        boolean z = false;
        if (j2 != null && !j2.hasEnded()) {
            z = true;
        }
        if (z) {
            return;
        }
        l<Pair<String, String>, t1> h2 = this.this$0.h();
        if (h2 != null) {
            h2.invoke(this.this$0.e().get(i2));
        }
        this.this$0.dismiss();
    }
}
