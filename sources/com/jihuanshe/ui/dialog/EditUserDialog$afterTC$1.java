package com.jihuanshe.ui.dialog;

import android.text.Editable;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.k2.v.f0;
import h.t1;
import h.t2.u;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class EditUserDialog$afterTC$1 extends Lambda implements l<Editable, t1> {
    public final /* synthetic */ EditUserDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserDialog$afterTC$1(EditUserDialog editUserDialog) {
        super(1);
        this.this$0 = editUserDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Editable editable) {
        invoke2(editable);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Editable editable) {
        if (this.this$0.C() && StringsKt__StringsKt.V2(editable.toString(), ".", false, 2, null)) {
            this.this$0.getEt().setText(u.k2(editable.toString(), ".", "", false, 4, null));
            this.this$0.getEt().setSelection(this.this$0.getEt().getText().length());
            EditUserDialog editUserDialog = this.this$0;
            e.f(editUserDialog, f0.C(editUserDialog.getTips(), "，只能为整数"), (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        }
    }
}
