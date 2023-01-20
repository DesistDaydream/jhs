package com.jihuanshe.ui.dialog;

import android.view.View;
import h.k2.u.l;
import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardDialog$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ l<Integer, t1> $clickedItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AddCardDialog$onItemClick$1(l<? super Integer, t1> lVar) {
        super(2);
        this.$clickedItem = lVar;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        l<Integer, t1> lVar = this.$clickedItem;
        if (lVar == null) {
            return;
        }
        lVar.invoke(Integer.valueOf(i2));
    }
}
