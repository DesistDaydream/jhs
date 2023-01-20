package com.jihuanshe.viewmodel;

import android.view.View;
import com.jihuanshe.model.Constants;
import e.n.f;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterBarImpl$onChoicePriceType$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ int $pos;
    public final /* synthetic */ FilterBarImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterBarImpl$onChoicePriceType$1(FilterBarImpl filterBarImpl, int i2) {
        super(1);
        this.this$0 = filterBarImpl;
        this.$pos = i2;
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
        f fVar;
        lVar = this.this$0.a;
        Integer value = lVar.getValue();
        int i2 = this.$pos;
        if (value != null && value.intValue() == i2) {
            return;
        }
        lVar2 = this.this$0.a;
        lVar2.setValue(Integer.valueOf(this.$pos));
        fVar = this.this$0.f4352c;
        fVar.setValue(Constants.Companion.getPRICE_TYPE().get(this.$pos));
    }
}
