package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import androidx.annotation.BoolRes;
import androidx.annotation.DimenRes;
import androidx.annotation.Dimension;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.internal.FlowLayout;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class ChipGroup extends FlowLayout {
    private static final int n = R.style.Widget_MaterialComponents_ChipGroup;
    @Dimension

    /* renamed from: e  reason: collision with root package name */
    private int f2850e;
    @Dimension

    /* renamed from: f  reason: collision with root package name */
    private int f2851f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2852g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f2853h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private c f2854i;

    /* renamed from: j  reason: collision with root package name */
    private final b f2855j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private d f2856k;
    @IdRes

    /* renamed from: l  reason: collision with root package name */
    private int f2857l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f2858m;

    /* loaded from: classes2.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements CompoundButton.OnCheckedChangeListener {
        private b() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z) {
            if (ChipGroup.this.f2858m) {
                return;
            }
            if (ChipGroup.this.getCheckedChipIds().isEmpty() && ChipGroup.this.f2853h) {
                ChipGroup.this.s(compoundButton.getId(), true);
                ChipGroup.this.r(compoundButton.getId(), false);
                return;
            }
            int id = compoundButton.getId();
            if (z) {
                if (ChipGroup.this.f2857l != -1 && ChipGroup.this.f2857l != id && ChipGroup.this.f2852g) {
                    ChipGroup chipGroup = ChipGroup.this;
                    chipGroup.s(chipGroup.f2857l, false);
                }
                ChipGroup.this.setCheckedId(id);
            } else if (ChipGroup.this.f2857l == id) {
                ChipGroup.this.setCheckedId(-1);
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(ChipGroup chipGroup, @IdRes int i2);
    }

    /* loaded from: classes2.dex */
    public class d implements ViewGroup.OnHierarchyChangeListener {
        private ViewGroup.OnHierarchyChangeListener a;

        private d() {
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                if (view2.getId() == -1) {
                    view2.setId(ViewCompat.generateViewId());
                }
                Chip chip = (Chip) view2;
                if (chip.isChecked()) {
                    ((ChipGroup) view).m(chip.getId());
                }
                chip.setOnCheckedChangeListenerInternal(ChipGroup.this.f2855j);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            if (view == ChipGroup.this && (view2 instanceof Chip)) {
                ((Chip) view2).setOnCheckedChangeListenerInternal(null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.a;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int getChipCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if (getChildAt(i3) instanceof Chip) {
                i2++;
            }
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(int i2, boolean z) {
        this.f2857l = i2;
        c cVar = this.f2854i;
        if (cVar != null && this.f2852g && z) {
            cVar.a(this, i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(@IdRes int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof Chip) {
            this.f2858m = true;
            ((Chip) findViewById).setChecked(z);
            this.f2858m = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i2) {
        r(i2, true);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i3 = this.f2857l;
                if (i3 != -1 && this.f2852g) {
                    s(i3, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i2, layoutParams);
    }

    @Override // com.google.android.material.internal.FlowLayout
    public boolean c() {
        return super.c();
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof LayoutParams);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @IdRes
    public int getCheckedChipId() {
        if (this.f2852g) {
            return this.f2857l;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f2852g) {
                    return arrayList;
                }
            }
        }
        return arrayList;
    }

    @Dimension
    public int getChipSpacingHorizontal() {
        return this.f2850e;
    }

    @Dimension
    public int getChipSpacingVertical() {
        return this.f2851f;
    }

    public void m(@IdRes int i2) {
        int i3 = this.f2857l;
        if (i2 == i3) {
            return;
        }
        if (i3 != -1 && this.f2852g) {
            s(i3, false);
        }
        if (i2 != -1) {
            s(i2, true);
        }
        setCheckedId(i2);
    }

    public void n() {
        this.f2858m = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof Chip) {
                ((Chip) childAt).setChecked(false);
            }
        }
        this.f2858m = false;
        setCheckedId(-1);
    }

    public int o(@Nullable View view) {
        if (view instanceof Chip) {
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) instanceof Chip) {
                    if (((Chip) getChildAt(i3)) == view) {
                        return i2;
                    }
                    i2++;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f2857l;
        if (i2 != -1) {
            s(i2, true);
            setCheckedId(this.f2857l);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(getRowCount(), c() ? getChipCount() : -1, false, q() ? 1 : 2));
    }

    public boolean p() {
        return this.f2853h;
    }

    public boolean q() {
        return this.f2852g;
    }

    public void setChipSpacing(@Dimension int i2) {
        setChipSpacingHorizontal(i2);
        setChipSpacingVertical(i2);
    }

    public void setChipSpacingHorizontal(@Dimension int i2) {
        if (this.f2850e != i2) {
            this.f2850e = i2;
            setItemSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(@DimenRes int i2) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingResource(@DimenRes int i2) {
        setChipSpacing(getResources().getDimensionPixelOffset(i2));
    }

    public void setChipSpacingVertical(@Dimension int i2) {
        if (this.f2851f != i2) {
            this.f2851f = i2;
            setLineSpacing(i2);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(@DimenRes int i2) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i2));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i2) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(c cVar) {
        this.f2854i = cVar;
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f2856k.a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z) {
        this.f2853h = z;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i2) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z) {
        super.setSingleLine(z);
    }

    public void setSingleSelection(boolean z) {
        if (this.f2852g != z) {
            this.f2852g = z;
            n();
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.chipGroupStyle);
    }

    @Override // android.view.ViewGroup
    @NonNull
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public void setSingleLine(@BoolRes int i2) {
        setSingleLine(getResources().getBoolean(i2));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ChipGroup(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.chip.ChipGroup.n
            android.content.Context r8 = e.j.a.c.e0.a.a.c(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            com.google.android.material.chip.ChipGroup$b r8 = new com.google.android.material.chip.ChipGroup$b
            r0 = 0
            r8.<init>()
            r7.f2855j = r8
            com.google.android.material.chip.ChipGroup$d r8 = new com.google.android.material.chip.ChipGroup$d
            r8.<init>()
            r7.f2856k = r8
            r8 = -1
            r7.f2857l = r8
            r6 = 0
            r7.f2858m = r6
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R.styleable.ChipGroup
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r9 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r10 = com.google.android.material.R.styleable.ChipGroup_chipSpacing
            int r10 = r9.getDimensionPixelOffset(r10, r6)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingHorizontal
            int r0 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingHorizontal(r0)
            int r0 = com.google.android.material.R.styleable.ChipGroup_chipSpacingVertical
            int r10 = r9.getDimensionPixelOffset(r0, r10)
            r7.setChipSpacingVertical(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_singleLine
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleLine(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_singleSelection
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSingleSelection(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_selectionRequired
            boolean r10 = r9.getBoolean(r10, r6)
            r7.setSelectionRequired(r10)
            int r10 = com.google.android.material.R.styleable.ChipGroup_checkedChip
            int r10 = r9.getResourceId(r10, r8)
            if (r10 == r8) goto L69
            r7.f2857l = r10
        L69:
            r9.recycle()
            com.google.android.material.chip.ChipGroup$d r8 = r7.f2856k
            super.setOnHierarchyChangeListener(r8)
            r8 = 1
            androidx.core.view.ViewCompat.setImportantForAccessibility(r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
