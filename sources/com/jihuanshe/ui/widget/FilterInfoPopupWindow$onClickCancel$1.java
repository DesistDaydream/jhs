package com.jihuanshe.ui.widget;

import android.view.View;
import android.view.animation.Animation;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterInfoPopupWindow$onClickCancel$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ FilterInfoPopupWindow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInfoPopupWindow$onClickCancel$1(FilterInfoPopupWindow filterInfoPopupWindow) {
        super(1);
        this.this$0 = filterInfoPopupWindow;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Animation i2 = this.this$0.i();
        boolean z = false;
        if (i2 != null && !i2.hasEnded()) {
            z = true;
        }
        if (z) {
            return;
        }
        this.this$0.dismiss();
    }
}
