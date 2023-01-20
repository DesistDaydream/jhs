package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardConsignmentDialog$onMinusClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ AddCardConsignmentDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardConsignmentDialog$onMinusClick$1(AddCardConsignmentDialog addCardConsignmentDialog) {
        super(1);
        this.this$0 = addCardConsignmentDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer value = this.this$0.getCount().getValue();
        if (value == null) {
            value = 1;
        }
        if (value.intValue() == 1) {
            return;
        }
        this.this$0.getCount().setValue(Integer.valueOf(this.this$0.getCount().C(1)));
    }
}
