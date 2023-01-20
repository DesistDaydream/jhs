package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.model.PendingProduct;
import e.n.f;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardConsignmentDialog$clickChildDia$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ f<PendingProduct> $product;
    public final /* synthetic */ AddCardConsignmentDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardConsignmentDialog$clickChildDia$1(f<PendingProduct> fVar, AddCardConsignmentDialog addCardConsignmentDialog) {
        super(1);
        this.$product = fVar;
        this.this$0 = addCardConsignmentDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        l<f<PendingProduct>, t1> clickChild;
        if (this.$product.getValue() == null || (clickChild = this.this$0.getClickChild()) == null) {
            return;
        }
        clickChild.invoke(this.$product);
    }
}
