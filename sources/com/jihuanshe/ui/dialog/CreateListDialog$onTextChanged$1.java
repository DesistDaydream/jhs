package com.jihuanshe.ui.dialog;

import android.text.Editable;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CreateListDialog$onTextChanged$1 extends Lambda implements l<Editable, t1> {
    public final /* synthetic */ CreateListDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateListDialog$onTextChanged$1(CreateListDialog createListDialog) {
        super(1);
        this.this$0 = createListDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Editable editable) {
        invoke2(editable);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Editable editable) {
        this.this$0.v = editable.toString();
    }
}
