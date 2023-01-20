package com.jihuanshe.ui.page.entrepot;

import e.l.s.h.b;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SearchMyStorehouseFragment$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ SearchMyStorehouseFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SearchMyStorehouseFragment$flowOfSetup$1(SearchMyStorehouseFragment searchMyStorehouseFragment) {
        super(1);
        this.this$0 = searchMyStorehouseFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        ((b) this.this$0.T()).p0().setValue(Boolean.valueOf(str.length() > 0));
    }
}
