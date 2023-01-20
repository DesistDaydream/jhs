package com.jihuanshe.ui.page.order;

import android.text.Editable;
import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddAddressActivity$onTextChanged$1 extends Lambda implements l<Editable, t1> {
    public final /* synthetic */ AddAddressActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddAddressActivity$onTextChanged$1(AddAddressActivity addAddressActivity) {
        super(1);
        this.this$0 = addAddressActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Editable editable) {
        invoke2(editable);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Editable editable) {
        boolean Y;
        View n0 = this.this$0.n0();
        Y = this.this$0.Y();
        n0.setEnabled(Y);
    }
}
