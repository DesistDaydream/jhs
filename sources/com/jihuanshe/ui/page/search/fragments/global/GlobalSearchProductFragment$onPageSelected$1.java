package com.jihuanshe.ui.page.search.fragments.global;

import e.l.s.m.d.a;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GlobalSearchProductFragment$onPageSelected$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ GlobalSearchProductFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GlobalSearchProductFragment$onPageSelected$1(GlobalSearchProductFragment globalSearchProductFragment) {
        super(1);
        this.this$0 = globalSearchProductFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        ((a) this.this$0.T()).r0().setValue(Integer.valueOf(i2));
        boolean z = true;
        ((a) this.this$0.T()).u0().setValue(Boolean.valueOf((i2 == 1 || ((a) this.this$0.T()).p0().getValue() == null) ? false : false));
    }
}
