package com.aigestudio.wheelpicker.widgets;

import android.content.Context;
import android.util.AttributeSet;
import com.aigestudio.wheelpicker.WheelPicker;
import e.a.a.d.c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/* loaded from: classes.dex */
public class WheelMonthPicker extends WheelPicker implements c {
    private int G0;

    public WheelMonthPicker(Context context) {
        this(context, null);
    }

    private void u() {
        setSelectedItemPosition(this.G0 - 1);
    }

    @Override // e.a.a.d.c
    public int getCurrentMonth() {
        return Integer.valueOf(String.valueOf(getData().get(getCurrentItemPosition()))).intValue();
    }

    @Override // e.a.a.d.c
    public int getSelectedMonth() {
        return this.G0;
    }

    @Override // com.aigestudio.wheelpicker.WheelPicker, e.a.a.c
    public void setData(List list) {
        throw new UnsupportedOperationException("You can not invoke setData in WheelMonthPicker");
    }

    @Override // e.a.a.d.c
    public void setSelectedMonth(int i2) {
        this.G0 = i2;
        u();
    }

    public WheelMonthPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 1; i2 <= 12; i2++) {
            arrayList.add(Integer.valueOf(i2));
        }
        super.setData(arrayList);
        this.G0 = Calendar.getInstance().get(2) + 1;
        u();
    }
}
