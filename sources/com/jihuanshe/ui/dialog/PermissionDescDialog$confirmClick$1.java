package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class PermissionDescDialog$confirmClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ PermissionDescDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PermissionDescDialog$confirmClick$1(PermissionDescDialog permissionDescDialog) {
        super(1);
        this.this$0 = permissionDescDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        a<t1> onConfirmClick = this.this$0.getOnConfirmClick();
        if (onConfirmClick != null) {
            onConfirmClick.invoke();
        }
        this.this$0.h();
    }
}
