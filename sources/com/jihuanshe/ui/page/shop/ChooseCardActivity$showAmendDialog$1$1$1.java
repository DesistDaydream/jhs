package com.jihuanshe.ui.page.shop;

import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseCardActivity$showAmendDialog$1$1$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ ChooseCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardActivity$showAmendDialog$1$1$1(ChooseCardActivity chooseCardActivity) {
        super(1);
        this.this$0 = chooseCardActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        this.this$0.m0().setValue(null);
        e.l.h.j.b.e.h(this.this$0, Res.w(Res.a, R.string.success, null, 2, null), null, null, null, 0, null, 62, null);
    }
}
