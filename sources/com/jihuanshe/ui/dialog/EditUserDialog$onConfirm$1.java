package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class EditUserDialog$onConfirm$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ EditUserDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EditUserDialog$onConfirm$1(EditUserDialog editUserDialog) {
        super(1);
        this.this$0 = editUserDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        String obj = StringsKt__StringsKt.B5(this.this$0.getEt().getText()).toString();
        if (this.this$0.C()) {
            obj = new Regex("^(0+)").replace(obj, "");
        }
        this.this$0.getListener().invoke(obj);
        this.this$0.h();
    }
}
