package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchChildCheckFragment$onItemClick$1$2$2$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ SearchChildCheckFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchChildCheckFragment$onItemClick$1$2$2$1(SearchChildCheckFragment searchChildCheckFragment) {
        super(1);
        this.this$0 = searchChildCheckFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        this.this$0.M();
        e.l.h.j.b.e.d(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), (r13 & 2) != 0 ? null : null, (r13 & 4) != 0 ? null : null, (r13 & 8) != 0 ? null : null, (r13 & 16) != 0 ? 1 : 0, (r13 & 32) == 0 ? null : null);
    }
}
