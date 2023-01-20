package com.jihuanshe.ui.page.search.fragments.desire;

import e.l.s.o.e.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchDesireFragment$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ SearchDesireFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchDesireFragment$flowOfSetup$1(SearchDesireFragment searchDesireFragment) {
        super(1);
        this.this$0 = searchDesireFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e String str) {
        ((a) this.this$0.T()).r0().setValue(str);
        ((a) this.this$0.T()).s0().setValue(Boolean.FALSE);
    }
}
