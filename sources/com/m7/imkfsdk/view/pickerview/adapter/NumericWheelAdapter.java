package com.m7.imkfsdk.view.pickerview.adapter;

/* loaded from: classes2.dex */
public class NumericWheelAdapter implements WheelAdapter {
    public static final int DEFAULT_MAX_VALUE = 9;
    private static final int DEFAULT_MIN_VALUE = 0;
    private int maxValue;
    private int minValue;

    public NumericWheelAdapter() {
        this(0, 9);
    }

    @Override // com.m7.imkfsdk.view.pickerview.adapter.WheelAdapter
    public Object getItem(int i2) {
        if (i2 >= 0 && i2 < getItemsCount()) {
            return Integer.valueOf(this.minValue + i2);
        }
        return 0;
    }

    @Override // com.m7.imkfsdk.view.pickerview.adapter.WheelAdapter
    public int getItemsCount() {
        return (this.maxValue - this.minValue) + 1;
    }

    @Override // com.m7.imkfsdk.view.pickerview.adapter.WheelAdapter
    public int indexOf(Object obj) {
        return ((Integer) obj).intValue() - this.minValue;
    }

    public NumericWheelAdapter(int i2, int i3) {
        this.minValue = i2;
        this.maxValue = i3;
    }
}
