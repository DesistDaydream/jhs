package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.aigestudio.wheelpicker.WheelPicker;
import e.a.a.d.b;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class WheelDayPicker extends WheelPicker implements b {
    private static final Map<Integer, List<Integer>> K0 = new HashMap();
    private Calendar G0;
    private int H0;
    private int I0;
    private int J0;

    public WheelDayPicker(Context context) {
        this(context, null);
    }

    private void u() {
        this.G0.set(1, this.H0);
        this.G0.set(2, this.I0);
        int actualMaximum = this.G0.getActualMaximum(5);
        List<Integer> list = K0.get(Integer.valueOf(actualMaximum));
        if (list == null) {
            list = new ArrayList<>();
            for (int i2 = 1; i2 <= actualMaximum; i2++) {
                list.add(Integer.valueOf(i2));
            }
            K0.put(Integer.valueOf(actualMaximum), list);
        }
        super.setData(list);
    }

    private void v() {
        setSelectedItemPosition(this.J0 - 1);
    }

    @Override // e.a.a.d.b
    public void d(int i2, int i3) {
        this.H0 = i2;
        this.I0 = i3 - 1;
        u();
    }

    @Override // e.a.a.d.b
    public int getCurrentDay() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
    }

    @Override // e.a.a.d.b
    public int getMonth() {
        return this.I0;
    }

    @Override // e.a.a.d.b
    public int getSelectedDay() {
        return this.J0;
    }

    @Override // e.a.a.d.b
    public int getYear() {
        return this.H0;
    }

    @Override // com.aigestudio.wheelpicker.WheelPicker, e.a.a.c
    public void setData(List list) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelDayPicker");
    }

    @Override // e.a.a.d.b
    public void setMonth(int i2) {
        this.I0 = i2 - 1;
        u();
    }

    @Override // e.a.a.d.b
    public void setSelectedDay(int i2) {
        this.J0 = i2;
        v();
    }

    @Override // e.a.a.d.b
    public void setYear(int i2) {
        this.H0 = i2;
        u();
    }

    public WheelDayPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Calendar calendar = Calendar.getInstance();
        this.G0 = calendar;
        this.H0 = calendar.get(1);
        this.I0 = this.G0.get(2);
        u();
        this.J0 = this.G0.get(5);
        v();
    }
}
