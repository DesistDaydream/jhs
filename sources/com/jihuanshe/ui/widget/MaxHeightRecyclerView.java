package com.jihuanshe.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class MaxHeightRecyclerView extends RecyclerView {
    private final int a;

    @h
    public MaxHeightRecyclerView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ MaxHeightRecyclerView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4 = this.a;
        if (i4 > 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE);
        }
        super.onMeasure(i2, i3);
    }

    @h
    public MaxHeightRecyclerView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaxHeightRecyclerView);
        this.a = obtainStyledAttributes.getLayoutDimension(0, 0);
        obtainStyledAttributes.recycle();
    }
}
