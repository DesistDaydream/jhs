package com.jihuanshe.ui.page.shop;

import android.widget.TextView;
import h.k2.u.p;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseCardActivity$onEditorAction$1 extends Lambda implements p<TextView, Integer, Boolean> {
    public final /* synthetic */ ChooseCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardActivity$onEditorAction$1(ChooseCardActivity chooseCardActivity) {
        super(2);
        this.this$0 = chooseCardActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ Boolean invoke(TextView textView, Integer num) {
        return Boolean.valueOf(invoke(textView, num.intValue()));
    }

    public final boolean invoke(@d TextView textView, int i2) {
        if (i2 == 3) {
            this.this$0.q0();
            return true;
        }
        return true;
    }
}
