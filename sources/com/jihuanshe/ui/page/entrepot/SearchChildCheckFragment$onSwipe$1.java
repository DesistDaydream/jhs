package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.SearchChildCheckViewModel;
import e.g.d.a;
import e.t.v.j.g;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchChildCheckFragment$onSwipe$1 extends Lambda implements l<g<?>, t1> {
    public final /* synthetic */ SearchChildCheckFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchChildCheckFragment$onSwipe$1(SearchChildCheckFragment searchChildCheckFragment) {
        super(1);
        this.this$0 = searchChildCheckFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(g<?> gVar) {
        invoke2(gVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d g<?> gVar) {
        a s0;
        s0 = ((SearchChildCheckViewModel) this.this$0.T()).s0(this.this$0.g0(), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : this.this$0.n0().s0().getValue(), (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? null : null, (r13 & 32) == 0 ? null : null);
        BinderKt.p(BinderKt.e(s0, this.this$0, gVar, false, 4, null));
    }
}
