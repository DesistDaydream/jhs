package com.google.android.material.navigationrail;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class NavigationRailMenuView extends NavigationBarMenuView {
    private final FrameLayout.LayoutParams x;

    public NavigationRailMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        this.x = layoutParams;
        layoutParams.gravity = 49;
        setLayoutParams(layoutParams);
    }

    private int r(int i2, int i3, int i4) {
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i2), i3 / Math.max(1, i4)), 0);
    }

    private int s(View view, int i2, int i3) {
        if (view.getVisibility() != 8) {
            view.measure(i2, i3);
            return view.getMeasuredHeight();
        }
        return 0;
    }

    private int t(int i2, int i3, int i4, View view) {
        int makeMeasureSpec;
        r(i2, i3, i4);
        if (view == null) {
            makeMeasureSpec = r(i2, i3, i4);
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(view.getMeasuredHeight(), 0);
        }
        int childCount = getChildCount();
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (childAt != view) {
                i5 += s(childAt, i2, makeMeasureSpec);
            }
        }
        return i5;
    }

    private int u(int i2, int i3, int i4) {
        int i5;
        View childAt = getChildAt(getSelectedItemPosition());
        if (childAt != null) {
            i5 = s(childAt, i2, r(i2, i3, i4));
            i3 -= i5;
            i4--;
        } else {
            i5 = 0;
        }
        return i5 + t(i2, i3, i4, childAt);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView e(@NonNull Context context) {
        return new NavigationRailItemView(context);
    }

    public int getMenuGravity() {
        return this.x.gravity;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = 0;
        for (int i8 = 0; i8 < childCount; i8++) {
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                int measuredHeight = childAt.getMeasuredHeight() + i7;
                childAt.layout(0, i7, i6, measuredHeight);
                i7 = measuredHeight;
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int t;
        int size = View.MeasureSpec.getSize(i3);
        int size2 = getMenu().getVisibleItems().size();
        if (size2 > 1 && i(getLabelVisibilityMode(), size2)) {
            t = u(i2, size, size2);
        } else {
            t = t(i2, size, size2, null);
        }
        setMeasuredDimension(View.resolveSizeAndState(View.MeasureSpec.getSize(i2), i2, 0), View.resolveSizeAndState(t, i3, 0));
    }

    public boolean q() {
        return (this.x.gravity & 112) == 48;
    }

    public void setMenuGravity(int i2) {
        FrameLayout.LayoutParams layoutParams = this.x;
        if (layoutParams.gravity != i2) {
            layoutParams.gravity = i2;
            setLayoutParams(layoutParams);
        }
    }
}
