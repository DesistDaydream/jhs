package com.jihuanshe.ui.page.user.wish;

import e.l.s.o.e.a;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class DesireFragment$onPageSelected$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ DesireFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DesireFragment$onPageSelected$1(DesireFragment desireFragment) {
        super(1);
        this.this$0 = desireFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        ((a) this.this$0.T()).q0().r(Integer.valueOf(i2));
    }
}
