package com.jihuanshe.ui.widget;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class InteractPopupWindow$onClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ InteractPopupWindow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InteractPopupWindow$onClick$1(InteractPopupWindow interactPopupWindow) {
        super(1);
        this.this$0 = interactPopupWindow;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        this.this$0.dismiss();
        this.this$0.a().a().invoke(view);
    }
}
