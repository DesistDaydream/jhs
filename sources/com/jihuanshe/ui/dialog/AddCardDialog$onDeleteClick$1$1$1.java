package com.jihuanshe.ui.dialog;

import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardDialog$onDeleteClick$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ a<t1> $delete;
    public final /* synthetic */ AddCardDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardDialog$onDeleteClick$1$1$1(AddCardDialog addCardDialog, a<t1> aVar) {
        super(0);
        this.this$0 = addCardDialog;
        this.$delete = aVar;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.h();
        a<t1> aVar = this.$delete;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }
}
