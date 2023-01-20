package com.jihuanshe.viewmodel;

import android.view.View;
import com.jihuanshe.ui.page.search.SearchActivityCreator;
import e.t.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterBarImpl$onClickSearchSell$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ FilterBarImpl this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FilterBarImpl$onClickSearchSell$1(FilterBarImpl filterBarImpl) {
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
        lVar = this.this$0.a;
        Integer value = lVar.getValue();
        SearchActivityCreator.create(7).uid(Integer.valueOf((value != null && value.intValue() == 0) ? 1 : 0)).start(a.b());
    }
}
