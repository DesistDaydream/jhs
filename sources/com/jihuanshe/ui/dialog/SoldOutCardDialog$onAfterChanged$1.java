package com.jihuanshe.ui.dialog;

import android.text.Editable;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SoldOutCardDialog$onAfterChanged$1 extends Lambda implements l<Editable, t1> {
    public final /* synthetic */ SoldOutCardDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SoldOutCardDialog$onAfterChanged$1(SoldOutCardDialog soldOutCardDialog) {
        super(1);
        this.this$0 = soldOutCardDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Editable editable) {
        invoke2(editable);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d Editable editable) {
        try {
            if (Integer.parseInt(editable.toString()) <= 0) {
                this.this$0.getCount().setValue(1);
            } else {
                this.this$0.getCount().setValue(Integer.valueOf(Integer.parseInt(editable.toString())));
            }
        } catch (Exception unused) {
        }
    }
}
