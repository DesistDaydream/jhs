package com.jihuanshe.ui.dialog;

import h.k2.u.p;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BackProductDialog$onCheckedChanged2$1 extends Lambda implements p<Integer, Integer, t1> {
    public final /* synthetic */ BackProductDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackProductDialog$onCheckedChanged2$1(BackProductDialog backProductDialog) {
        super(2);
        this.this$0 = backProductDialog;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return t1.a;
    }

    public final void invoke(int i2, int i3) {
        this.this$0.setReturnType(i2 + 1);
    }
}
