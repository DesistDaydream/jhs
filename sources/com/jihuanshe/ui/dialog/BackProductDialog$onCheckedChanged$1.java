package com.jihuanshe.ui.dialog;

import android.content.res.ColorStateList;
import android.widget.RadioButton;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.k.m3;
import h.k2.u.p;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class BackProductDialog$onCheckedChanged$1 extends Lambda implements p<Integer, Integer, t1> {
    public final /* synthetic */ BackProductDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BackProductDialog$onCheckedChanged$1(BackProductDialog backProductDialog) {
        super(2);
        this.this$0 = backProductDialog;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(Integer num, Integer num2) {
        invoke(num.intValue(), num2.intValue());
        return t1.a;
    }

    public final void invoke(int i2, int i3) {
        boolean z = i3 == R.id.rb2;
        m3 binding = this.this$0.getBinding();
        RadioButton radioButton = binding == null ? null : binding.f13106f;
        if (radioButton != null) {
            radioButton.setEnabled(z);
        }
        m3 binding2 = this.this$0.getBinding();
        RadioButton radioButton2 = binding2 == null ? null : binding2.f13106f;
        if (radioButton2 != null) {
            radioButton2.setButtonTintList(z ? null : ColorStateList.valueOf(Res.k(R.color.black_99999a)));
        }
        this.this$0.setGoodsType(i2 + 1);
        if (this.this$0.getGoodsType() == 1) {
            m3 binding3 = this.this$0.getBinding();
            RadioButton radioButton3 = binding3 != null ? binding3.f13108h : null;
            if (radioButton3 == null) {
                return;
            }
            radioButton3.setChecked(true);
        }
    }
}
