package com.jihuanshe.ui.widget;

import android.view.View;
import e.l.g.r;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ConditionView$2$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ConditionView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConditionView$2$1(ConditionView conditionView) {
        super(2);
        this.this$0 = conditionView;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@d View view, int i2) {
        r rVar;
        rVar = this.this$0.a;
        rVar.x(i2);
    }
}
