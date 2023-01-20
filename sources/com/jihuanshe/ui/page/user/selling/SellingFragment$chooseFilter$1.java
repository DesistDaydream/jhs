package com.jihuanshe.ui.page.user.selling;

import e.l.s.o.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.Pair;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingFragment$chooseFilter$1 extends Lambda implements l<Pair<? extends String, ? extends String>, t1> {
    public final /* synthetic */ SellingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingFragment$chooseFilter$1(SellingFragment sellingFragment) {
        super(1);
        this.this$0 = sellingFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Pair<? extends String, ? extends String> pair) {
        invoke2((Pair<String, String>) pair);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Pair<String, String> pair) {
        ((a) this.this$0.T()).v0().setValue(pair);
        ((a) this.this$0.T()).u0().setValue(pair.getFirst());
        ((a) this.this$0.T()).x0().setValue(Boolean.TRUE);
    }
}
