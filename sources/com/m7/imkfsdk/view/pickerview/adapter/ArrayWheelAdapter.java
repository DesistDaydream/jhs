package com.m7.imkfsdk.view.pickerview.adapter;

import java.util.ArrayList;

/* loaded from: classes2.dex */
public class ArrayWheelAdapter<T> implements WheelAdapter {
    public static final int DEFAULT_LENGTH = 4;
    private ArrayList<T> items;
    private int length;

    public ArrayWheelAdapter(ArrayList<T> arrayList, int i2) {
        this.items = arrayList;
        this.length = i2;
    }

    @Override // com.m7.imkfsdk.view.pickerview.adapter.WheelAdapter
    public Object getItem(int i2) {
        return (i2 < 0 || i2 >= this.items.size()) ? "" : this.items.get(i2);
    }

    @Override // com.m7.imkfsdk.view.pickerview.adapter.WheelAdapter
    public int getItemsCount() {
        return this.items.size();
    }

    @Override // com.m7.imkfsdk.view.pickerview.adapter.WheelAdapter
    public int indexOf(Object obj) {
        return this.items.indexOf(obj);
    }

    public ArrayWheelAdapter(ArrayList<T> arrayList) {
        this(arrayList, 4);
    }
}
