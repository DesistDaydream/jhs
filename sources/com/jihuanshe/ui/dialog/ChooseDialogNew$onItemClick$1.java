package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseDialogNew$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ChooseDialogNew this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseDialogNew$onItemClick$1(ChooseDialogNew chooseDialogNew) {
        super(2);
        this.this$0 = chooseDialogNew;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        if (this.this$0.getDataList().getValue() == null || this.this$0.getOldIndex().getValue() == null) {
            return;
        }
        Integer value = this.this$0.getOldIndex().getValue();
        if (value == null || value.intValue() != -1) {
            this.this$0.getDataList().getValue().get(this.this$0.getOldIndex().getValue().intValue()).setState(0);
        }
        this.this$0.getDataList().getValue().get(i2).setState(1);
        this.this$0.getOldIndex().setValue(Integer.valueOf(i2));
        this.this$0.getDataList().n();
    }
}
