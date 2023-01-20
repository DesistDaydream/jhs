package com.jihuanshe.ui.page.search.fragments.global;

import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchFragment$flowOfSetup$3 extends Lambda implements l<String, t1> {
    public final /* synthetic */ GlobalSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchFragment$flowOfSetup$3(GlobalSearchFragment globalSearchFragment) {
        super(1);
        this.this$0 = globalSearchFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        this.this$0.k0().p0().setValue(Boolean.FALSE);
        this.this$0.k0().s0().r(str);
    }
}
