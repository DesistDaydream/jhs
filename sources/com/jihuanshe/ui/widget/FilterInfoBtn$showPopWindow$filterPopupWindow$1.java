package com.jihuanshe.ui.widget;

import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterInfoBtn$showPopWindow$filterPopupWindow$1 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ FilterInfoBtn this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterInfoBtn$showPopWindow$filterPopupWindow$1(FilterInfoBtn filterInfoBtn) {
        super(1);
        this.this$0 = filterInfoBtn;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        l<Boolean, t1> showState = this.this$0.getShowState();
        if (showState == null) {
            return;
        }
        showState.invoke(Boolean.FALSE);
    }
}
