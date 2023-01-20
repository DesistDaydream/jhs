package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CreateListDialog$onClickDel$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ CreateListDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateListDialog$onClickDel$1(CreateListDialog createListDialog) {
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
        this.this$0.h();
        p<String, Boolean, t1> listener = this.this$0.getListener();
        str = this.this$0.v;
        if (str == null) {
            str = "";
        }
        listener.invoke(str, Boolean.TRUE);
    }
}
