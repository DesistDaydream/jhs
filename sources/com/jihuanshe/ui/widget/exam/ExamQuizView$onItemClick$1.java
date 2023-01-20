package com.jihuanshe.ui.widget.exam;

import android.view.View;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ExamQuizView$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ExamQuizView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExamQuizView$onItemClick$1(ExamQuizView examQuizView) {
        super(2);
        this.this$0 = examQuizView;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        this.this$0.b(i2);
    }
}
