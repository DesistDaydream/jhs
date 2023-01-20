package com.jihuanshe.ui.page.shop;

import com.jihuanshe.ui.page.common.card.ConditionOpImpl;
import com.jihuanshe.ui.widget.ConditionView;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddProductActivity$conditionOp$2 extends Lambda implements a<ConditionOpImpl> {
    public final /* synthetic */ AddProductActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddProductActivity$conditionOp$2(AddProductActivity addProductActivity) {
        super(0);
        this.this$0 = addProductActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final ConditionOpImpl invoke() {
        ConditionView a0;
        a0 = this.this$0.a0();
        return new ConditionOpImpl(a0);
    }
}
