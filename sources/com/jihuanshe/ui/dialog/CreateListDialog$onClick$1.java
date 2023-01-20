package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CreateListDialog$onClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CreateListDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateListDialog$onClick$1(CreateListDialog createListDialog) {
        super(1);
        this.this$0 = createListDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        String str;
        String str2;
        str = this.this$0.v;
        if (str == null || str.length() == 0) {
            return;
        }
        this.this$0.h();
        p<String, Boolean, t1> listener = this.this$0.getListener();
        str2 = this.this$0.v;
        if (str2 == null) {
            str2 = "";
        }
        listener.invoke(str2, Boolean.FALSE);
    }
}
