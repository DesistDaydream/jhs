package com.jihuanshe.ui.dialog;

import android.view.View;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseDialogNew$onClickConfirm$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ChooseDialogNew this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseDialogNew$onClickConfirm$1(ChooseDialogNew chooseDialogNew) {
        super(1);
        this.this$0 = chooseDialogNew;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        Integer value = this.this$0.getOldIndex().getValue();
        if (value != null && value.intValue() == -1) {
            e.f(this.this$0, "您未选择快递", (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
            return;
        }
        this.this$0.getListener().invoke(this.this$0.getDataList().getValue().get(this.this$0.getOldIndex().getValue().intValue()).getName());
        this.this$0.h();
    }
}
