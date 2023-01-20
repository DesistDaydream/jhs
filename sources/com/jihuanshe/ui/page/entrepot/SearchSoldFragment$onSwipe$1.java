package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.SearchSoldViewModel;
import e.t.v.j.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchSoldFragment$onSwipe$1 extends Lambda implements l<g<?>, t1> {
    public final /* synthetic */ SearchSoldFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchSoldFragment$onSwipe$1(SearchSoldFragment searchSoldFragment) {
        super(1);
        this.this$0 = searchSoldFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar) {
        invoke2(gVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar) {
        BinderKt.p(BinderKt.e(SearchSoldViewModel.s0((SearchSoldViewModel) this.this$0.T(), Integer.valueOf(this.this$0.getType()), this.this$0.l0().s0().getValue(), null, 4, null), this.this$0, gVar, false, 4, null));
    }
}
