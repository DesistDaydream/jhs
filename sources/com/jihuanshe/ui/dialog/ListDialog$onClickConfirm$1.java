package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ListDialog$onClickConfirm$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ l<Integer, t1> $listener;
    public final /* synthetic */ ListDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public ListDialog$onClickConfirm$1(ListDialog listDialog, l<? super Integer, t1> lVar) {
        super(1);
        this.this$0 = listDialog;
        this.$listener = lVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        this.this$0.h();
        this.$listener.invoke(Integer.valueOf(this.this$0.getAdapter().v()));
    }
}
