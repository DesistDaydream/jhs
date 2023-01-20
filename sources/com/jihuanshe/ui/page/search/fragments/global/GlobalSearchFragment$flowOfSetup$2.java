package com.jihuanshe.ui.page.search.fragments.global;

import e.l.s.m.d.b;
import e.n.f;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchFragment$flowOfSetup$2 extends Lambda implements l<String, t1> {
    public final /* synthetic */ GlobalSearchFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchFragment$flowOfSetup$2(GlobalSearchFragment globalSearchFragment) {
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
        List<CharSequence> list;
        f<List<CharSequence>> m0 = this.this$0.m0();
        list = this.this$0.t;
        m0.r(list);
        ((b) this.this$0.T()).o(str);
        ((b) this.this$0.T()).q0(str);
    }
}
