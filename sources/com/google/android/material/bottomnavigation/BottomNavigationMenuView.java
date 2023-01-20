package com.google.android.material.bottomnavigation;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class BottomNavigationMenuView extends NavigationBarMenuView {
    private final int A;
    private final int B;
    private boolean C;
    private int[] D;
    private final int x;
    private final int y;
    private final int z;

    public BottomNavigationMenuView(@NonNull Context context) {
        super(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        setLayoutParams(layoutParams);
        Resources resources = getResources();
        this.x = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_max_width);
        this.y = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_item_min_width);
        this.z = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_max_width);
        this.A = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_active_item_min_width);
        this.B = resources.getDimensionPixelSize(R.dimen.design_bottom_navigation_height);
        this.D = new int[5];
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuView
    @NonNull
    public NavigationBarItemView e(@NonNull Context context) {
        return new BottomNavigationItemView(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int i6 = i4 - i2;
        int i7 = i5 - i3;
        int i8 = 0;
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() != 8) {
                if (ViewCompat.getLayoutDirection(this) == 1) {
                    int i10 = i6 - i8;
                    childAt.layout(i10 - childAt.getMeasuredWidth(), 0, i10, i7);
                } else {
                    childAt.layout(i8, 0, childAt.getMeasuredWidth() + i8, i7);
                }
                i8 += childAt.getMeasuredWidth();
            }
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        MenuBuilder menu = getMenu();
        int size = View.MeasureSpec.getSize(i2);
        int size2 = menu.getVisibleItems().size();
        int childCount = getChildCount();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.B, 1073741824);
        if (i(getLabelVisibilityMode(), size2) && q()) {
            View childAt = getChildAt(getSelectedItemPosition());
            int i4 = this.A;
            if (childAt.getVisibility() != 8) {
                childAt.measure(View.MeasureSpec.makeMeasureSpec(this.z, Integer.MIN_VALUE), makeMeasureSpec);
                i4 = Math.max(i4, childAt.getMeasuredWidth());
            }
            int i5 = size2 - (childAt.getVisibility() != 8 ? 1 : 0);
            int min = Math.min(size - (this.y * i5), Math.min(i4, this.z));
            int i6 = size - min;
            int min2 = Math.min(i6 / (i5 == 0 ? 1 : i5), this.x);
            int i7 = i6 - (i5 * min2);
            int i8 = 0;
            while (i8 < childCount) {
                if (getChildAt(i8).getVisibility() != 8) {
                    this.D[i8] = i8 == getSelectedItemPosition() ? min : min2;
                    if (i7 > 0) {
                        int[] iArr = this.D;
                        iArr[i8] = iArr[i8] + 1;
                        i7--;
                    }
                } else {
                    this.D[i8] = 0;
                }
                i8++;
            }
        } else {
            int min3 = Math.min(size / (size2 == 0 ? 1 : size2), this.z);
            int i9 = size - (size2 * min3);
            for (int i10 = 0; i10 < childCount; i10++) {
                if (getChildAt(i10).getVisibility() != 8) {
                    int[] iArr2 = this.D;
                    iArr2[i10] = min3;
                    if (i9 > 0) {
                        iArr2[i10] = iArr2[i10] + 1;
                        i9--;
                    }
                } else {
                    this.D[i10] = 0;
                }
            }
        }
        int i11 = 0;
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt2 = getChildAt(i12);
            if (childAt2.getVisibility() != 8) {
                childAt2.measure(View.MeasureSpec.makeMeasureSpec(this.D[i12], 1073741824), makeMeasureSpec);
                childAt2.getLayoutParams().width = childAt2.getMeasuredWidth();
                i11 += childAt2.getMeasuredWidth();
            }
        }
        setMeasuredDimension(View.resolveSizeAndState(i11, View.MeasureSpec.makeMeasureSpec(i11, 1073741824), 0), View.resolveSizeAndState(this.B, makeMeasureSpec, 0));
    }

    public boolean q() {
        return this.C;
    }

    public void setItemHorizontalTranslationEnabled(boolean z) {
        this.C = z;
    }
}
