package com.jihuanshe.ui.dialog;

import android.view.View;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EditProductDialog$onDeleteClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ EditProductDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditProductDialog$onDeleteClick$1(EditProductDialog editProductDialog) {
        super(1);
        this.this$0 = editProductDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        UseDialog useDialog = new UseDialog(this.this$0.requireActivity());
        EditProductDialog editProductDialog = this.this$0;
        useDialog.getContent().setValue(Res.w(Res.a, R.string.sell_tip_title, null, 2, null));
        useDialog.setOnClickRightButton(new EditProductDialog$onDeleteClick$1$1$1(editProductDialog));
        useDialog.y();
    }
}
