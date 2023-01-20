package com.jihuanshe.ui.dialog;

import e.l.g.d0;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ListDialog$adapter$2 extends Lambda implements a<d0> {
    public final /* synthetic */ ListDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListDialog$adapter$2(ListDialog listDialog) {
        super(0);
        this.this$0 = listDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final d0 invoke() {
        return new d0(this.this$0.getChoose());
    }
}
