package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.aigestudio.wheelpicker.WheelPicker;
import e.a.a.d.d;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes.dex */
public class WheelYearPicker extends WheelPicker implements d {
    private int G0;
    private int H0;
    private int I0;

    public WheelYearPicker(Context context) {
        this(context, null);
    }

    private void u() {
        setSelectedItemPosition(this.I0 - this.G0);
    }

    private void v() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = this.G0; i2 <= this.H0; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        super.setData(arrayList);
    }

    @Override // e.a.a.d.d
    public void f(int i2, int i3) {
        this.G0 = i2;
        this.H0 = i3;
        this.I0 = getCurrentYear();
        v();
        u();
    }

    @Override // e.a.a.d.d
    public int getCurrentYear() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
    }

    @Override // e.a.a.d.d
    public int getSelectedYear() {
        return this.I0;
    }

    @Override // e.a.a.d.d
    public int getYearEnd() {
        return this.H0;
    }

    @Override // e.a.a.d.d
    public int getYearStart() {
        return this.G0;
    }

    @Override // com.aigestudio.wheelpicker.WheelPicker, e.a.a.c
    public void setData(List list) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelYearPicker");
    }

    @Override // e.a.a.d.d
    public void setSelectedYear(int i2) {
        this.I0 = i2;
        u();
    }

    @Override // e.a.a.d.d
    public void setYearEnd(int i2) {
        this.H0 = i2;
        v();
    }

    @Override // e.a.a.d.d
    public void setYearStart(int i2) {
        this.G0 = i2;
        this.I0 = getCurrentYear();
        v();
        u();
    }

    public WheelYearPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.G0 = 1000;
        this.H0 = 3000;
        v();
        this.I0 = Calendar.getInstance().get(1);
        u();
    }
}
