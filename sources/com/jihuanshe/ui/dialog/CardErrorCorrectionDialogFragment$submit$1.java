package com.jihuanshe.ui.dialog;

import com.jihuanshe.R;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardErrorCorrectionDialogFragment$submit$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ CardErrorCorrectionDialogFragment this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardErrorCorrectionDialogFragment$submit$1(CardErrorCorrectionDialogFragment cardErrorCorrectionDialogFragment) {
        super(1);
        this.this$0 = cardErrorCorrectionDialogFragment;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        e.l.h.j.b.e.e(this.this$0, R.string.success, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        this.this$0.dismiss();
    }
}
