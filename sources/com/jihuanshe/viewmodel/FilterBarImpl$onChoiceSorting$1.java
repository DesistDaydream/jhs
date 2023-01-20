package com.jihuanshe.viewmodel;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterBarImpl$onChoiceSorting$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ FilterBarImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterBarImpl$onChoiceSorting$1(FilterBarImpl filterBarImpl) {
        super(1);
        this.this$0 = filterBarImpl;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        e.n.l lVar;
        e.n.l lVar2;
        e.n.l lVar3;
        lVar = this.this$0.r;
        Integer value = lVar.getValue();
        if (value != null && value.intValue() == 1) {
            lVar3 = this.this$0.r;
            lVar3.setValue(0);
            return;
        }
        lVar2 = this.this$0.r;
        lVar2.setValue(1);
    }
}
