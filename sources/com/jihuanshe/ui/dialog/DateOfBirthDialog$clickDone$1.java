package com.jihuanshe.ui.dialog;

import android.view.View;
import com.google.android.material.timepicker.TimeModel;
import com.jihuanshe.base.wheelview.WheelDatePicker;
import h.k2.u.l;
import h.k2.u.q;
import h.k2.v.s0;
import h.t1;
import java.util.Arrays;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class DateOfBirthDialog$clickDone$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ DateOfBirthDialog this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateOfBirthDialog$clickDone$1(DateOfBirthDialog dateOfBirthDialog) {
        super(1);
        this.this$0 = dateOfBirthDialog;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        WheelDatePicker datePicker;
        WheelDatePicker datePicker2;
        WheelDatePicker datePicker3;
        q<String, String, String, t1> onDoneClick = this.this$0.getOnDoneClick();
        if (onDoneClick != null) {
            datePicker = this.this$0.getDatePicker();
            String valueOf = String.valueOf(datePicker.f3898e);
            s0 s0Var = s0.a;
            datePicker2 = this.this$0.getDatePicker();
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(datePicker2.f3899f)}, 1));
            datePicker3 = this.this$0.getDatePicker();
            onDoneClick.invoke(valueOf, format, String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(datePicker3.f3900g)}, 1)));
        }
        this.this$0.h();
    }
}
