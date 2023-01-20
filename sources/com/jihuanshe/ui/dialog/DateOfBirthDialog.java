package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import com.jihuanshe.R;
import com.jihuanshe.base.wheelview.WheelDatePicker;
import com.jihuanshe.ui.dialog.DateOfBirthDialog;
import com.vector.ext.bind.BindViewKt;
import com.vector.util.Res;
import e.l.k.m4;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.t.j.h.g;
import e.t.o.d;
import h.k2.u.q;
import h.k2.v.n0;
import h.m2.e;
import h.p2.n;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class DateOfBirthDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] y = {n0.r(new PropertyReference1Impl(n0.d(DateOfBirthDialog.class), "datePicker", "getDatePicker()Lcom/jihuanshe/base/wheelview/WheelDatePicker;"))};
    @d
    private final String t;
    @d
    private final e u;
    @k.e.a.e
    private q<? super String, ? super String, ? super String, t1> v;
    @d
    private final g w;
    @d
    private final g x;

    public DateOfBirthDialog(@d Context context, @d String str) {
        super(context);
        this.t = str;
        this.u = BindViewKt.p(this, R.id.date_of_birth_wheel_picker);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.w = dVar.a(new DateOfBirthDialog$clickClose$1(this));
        this.x = dVar.a(new DateOfBirthDialog$clickDone$1(this));
    }

    public static final void H(DateOfBirthDialog dateOfBirthDialog, String str, String str2, String str3) {
        dateOfBirthDialog.getDatePicker().setSelectedYear(Integer.parseInt(str));
        dateOfBirthDialog.getDatePicker().setSelectedMonth(Integer.parseInt(str2));
        dateOfBirthDialog.getDatePicker().setSelectedDay(Integer.parseInt(str3));
    }

    public final WheelDatePicker getDatePicker() {
        return (WheelDatePicker) this.u.a(this, y[0]);
    }

    /* renamed from: setCurrentDate$lambda-1 */
    public static final void m17setCurrentDate$lambda1(DateOfBirthDialog dateOfBirthDialog) {
        dateOfBirthDialog.getDatePicker().j();
    }

    public final void F() {
        post(new Runnable() { // from class: e.l.q.a.l
            {
                DateOfBirthDialog.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DateOfBirthDialog.m17setCurrentDate$lambda1(DateOfBirthDialog.this);
            }
        });
    }

    public final void G(@d final String str, @d final String str2, @d final String str3) {
        post(new Runnable() { // from class: e.l.q.a.m
            {
                DateOfBirthDialog.this = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                DateOfBirthDialog.H(DateOfBirthDialog.this, str, str2, str3);
            }
        });
    }

    public final void I() {
        G("2000", "1", "1");
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        m4 e2 = m4.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final g getClickClose() {
        return this.w;
    }

    @d
    public final g getClickDone() {
        return this.x;
    }

    @k.e.a.e
    public final q<String, String, String, t1> getOnDoneClick() {
        return this.v;
    }

    @d
    public final String getTitle() {
        return this.t;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }

    public final void setOnDoneClick(@k.e.a.e q<? super String, ? super String, ? super String, t1> qVar) {
        this.v = qVar;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void w() {
        getDatePicker().setCyclic(true);
        getDatePicker().setAtmospheric(true);
        getDatePicker().setVisibleItemCount(5);
        getDatePicker().setItemSpace(0);
        getDatePicker().setCurtain(true);
        getDatePicker().setCurtainColor(Res.k(R.color.black_1AFFFFFF));
        getDatePicker().setItemTextSize(d.a.c(e.t.o.d.a, null, 1, null).d(18));
        getDatePicker().getWheelYearPicker().setMaximumWidthText("2099");
        getDatePicker().getWheelMonthPicker().setMaximumWidthText("12");
        getDatePicker().getWheelDayPicker().setMaximumWidthText("31");
    }
}
