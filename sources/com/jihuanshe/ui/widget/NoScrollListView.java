package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListView;
import com.jihuanshe.R;
import com.vector.util.Res;
import h.k2.h;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class NoScrollListView extends ListView {
    @h
    public NoScrollListView(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ NoScrollListView(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    @h
    public NoScrollListView(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        setDivider(null);
        setSelector(new ColorDrawable(Res.k(R.color.transparent)));
        setVerticalScrollBarEnabled(false);
    }
}
