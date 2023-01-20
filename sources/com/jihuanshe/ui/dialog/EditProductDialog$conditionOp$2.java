package com.jihuanshe.ui.dialog;

import com.jihuanshe.ui.page.common.card.ConditionOpImpl;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditProductDialog$conditionOp$2 extends Lambda implements a<ConditionOpImpl> {
    public final /* synthetic */ EditProductDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProductDialog$conditionOp$2(EditProductDialog editProductDialog) {
        super(0);
        this.this$0 = editProductDialog;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final ConditionOpImpl invoke() {
        return new ConditionOpImpl(this.this$0.requireView());
    }
}
