package com.m7.imkfsdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

/* loaded from: classes2.dex */
public class FlowRadioGroup extends RadioGroup {
    public FlowRadioGroup(Context context) {
        super(context);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            if (marginLayoutParams.leftMargin + paddingLeft + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin + getPaddingRight() > i4 - i2) {
                paddingLeft = getPaddingLeft();
                paddingTop += i6;
                i6 = getChildAt(i7).getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            } else {
                i6 = Math.max(i6, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
            }
            int i8 = marginLayoutParams.leftMargin + paddingLeft;
            int i9 = marginLayoutParams.topMargin + paddingTop;
            childAt.layout(i8, i9, childAt.getMeasuredWidth() + i8, childAt.getMeasuredHeight() + i9);
            paddingLeft += marginLayoutParams.leftMargin + childAt.getMeasuredWidth() + marginLayoutParams.rightMargin;
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int size = View.MeasureSpec.getSize(i2);
        int mode = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i3);
        measureChildren(i2, i3);
        int childCount = getChildCount();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
            int measuredWidth = childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            int i10 = i8 + measuredWidth;
            if (getPaddingLeft() + i10 + getPaddingRight() > size) {
                int max = Math.max(i8, i5);
                i6 += i7;
                i7 = childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                i4 = max;
                i8 = measuredWidth;
            } else {
                i7 = Math.max(i7, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i4 = i5;
                i8 = i10;
            }
            if (i9 == childCount - 1) {
                i6 += i7;
                i5 = Math.max(i8, i5);
            } else {
                i5 = i4;
            }
        }
        int paddingLeft = i5 + getPaddingLeft() + getPaddingRight();
        int paddingTop = i6 + getPaddingTop() + getPaddingBottom();
        if (mode != 1073741824) {
            size = paddingLeft;
        }
        if (mode2 != 1073741824) {
            size2 = paddingTop;
        }
        setMeasuredDimension(size, size2);
    }

    public FlowRadioGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
