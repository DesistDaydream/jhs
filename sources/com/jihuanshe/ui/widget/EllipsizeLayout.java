package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import h.k2.h;
import h.k2.v.u;
import java.util.Objects;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class EllipsizeLayout extends LinearLayout {
    @h
    public EllipsizeLayout(@e Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ EllipsizeLayout(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        boolean z;
        if (getOrientation() == 0 && View.MeasureSpec.getMode(i2) == 1073741824) {
            TextView textView = null;
            int childCount = getChildCount();
            int i4 = 0;
            boolean z2 = false;
            int i5 = 0;
            while (true) {
                if (i4 >= childCount || z2) {
                    break;
                }
                View childAt = getChildAt(i4);
                if (childAt != null && childAt.getVisibility() != 8) {
                    if (childAt instanceof TextView) {
                        TextView textView2 = (TextView) childAt;
                        if (textView2.getEllipsize() != null) {
                            if (textView == null) {
                                textView2.setMaxWidth(Integer.MAX_VALUE);
                                textView = textView2;
                            } else {
                                z2 = true;
                            }
                        }
                    }
                    ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                    Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    z2 |= layoutParams2.weight > 0.0f;
                    measureChildWithMargins(childAt, i2, 0, i3, 0);
                    i5 += childAt.getMeasuredWidth() + layoutParams2.leftMargin + layoutParams2.rightMargin;
                }
                i4++;
            }
            if (textView != null && i5 != 0) {
                z = false;
            }
            boolean z3 = z2 | z;
            int size = View.MeasureSpec.getSize(i2);
            if (!z3 && i5 > size) {
                int measuredWidth = textView.getMeasuredWidth() - (i5 - size);
                textView.setMaxWidth(measuredWidth >= 0 ? measuredWidth : 0);
            }
        }
        super.onMeasure(i2, i3);
    }

    @h
    public EllipsizeLayout(@e Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
