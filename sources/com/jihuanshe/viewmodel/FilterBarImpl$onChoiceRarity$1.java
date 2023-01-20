package com.jihuanshe.viewmodel;

import android.view.View;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterBarImpl$onChoiceRarity$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ FilterBarImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterBarImpl$onChoiceRarity$1(FilterBarImpl filterBarImpl) {
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
        if (value != null && value.intValue() == 2) {
            this.this$0.f4355f.r(new Pair(Res.w(Res.a, R.string.shop_all_rarity, null, 2, null), ""));
            lVar3 = this.this$0.r;
            lVar3.setValue(0);
            return;
        }
        lVar2 = this.this$0.r;
        lVar2.setValue(2);
    }
}
