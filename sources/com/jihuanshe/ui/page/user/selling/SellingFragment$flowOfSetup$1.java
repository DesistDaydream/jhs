package com.jihuanshe.ui.page.user.selling;

import com.vector.ext.view.ViewKt;
import e.l.s.o.d.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellingFragment$flowOfSetup$1 extends Lambda implements l<String, t1> {
    public final /* synthetic */ SellingFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingFragment$flowOfSetup$1(SellingFragment sellingFragment) {
        super(1);
        this.this$0 = sellingFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(String str) {
        invoke2(str);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d String str) {
        ((a) this.this$0.T()).o(str);
        ViewKt.n(this.this$0.h0());
        this.this$0.o0().g(false);
        ((a) this.this$0.T()).q0().setValue(null);
        ((a) this.this$0.T()).u0().setValue("最新发布");
        ((a) this.this$0.T()).v0().setValue(null);
    }
}
