package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import androidx.annotation.BoolRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import e.j.a.c.s.t;
import e.j.a.c.z.o;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;

/* loaded from: classes2.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k */
    private static final String f2815k = MaterialButtonToggleGroup.class.getSimpleName();

    /* renamed from: l */
    private static final int f2816l = R.style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    private final List<d> a;
    private final c b;

    /* renamed from: c */
    private final f f2817c;

    /* renamed from: d */
    private final LinkedHashSet<e> f2818d;

    /* renamed from: e */
    private final Comparator<MaterialButton> f2819e;

    /* renamed from: f */
    private Integer[] f2820f;

    /* renamed from: g */
    private boolean f2821g;

    /* renamed from: h */
    private boolean f2822h;

    /* renamed from: i */
    private boolean f2823i;
    @IdRes

    /* renamed from: j */
    private int f2824j;

    /* loaded from: classes2.dex */
    public class a implements Comparator<MaterialButton> {
        public a() {
            MaterialButtonToggleGroup.this = r1;
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
            int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
            if (compareTo != 0) {
                return compareTo;
            }
            int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
            return compareTo2 != 0 ? compareTo2 : Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton)).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(materialButton2)));
        }
    }

    /* loaded from: classes2.dex */
    public class b extends AccessibilityDelegateCompat {
        public b() {
            MaterialButtonToggleGroup.this = r1;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.p(view), 1, false, ((MaterialButton) view).isChecked()));
        }
    }

    /* loaded from: classes2.dex */
    public class c implements MaterialButton.b {
        private c() {
            MaterialButtonToggleGroup.this = r1;
        }

        @Override // com.google.android.material.button.MaterialButton.b
        public void a(@NonNull MaterialButton materialButton, boolean z) {
            if (MaterialButtonToggleGroup.this.f2821g) {
                return;
            }
            if (MaterialButtonToggleGroup.this.f2822h) {
                MaterialButtonToggleGroup.this.f2824j = z ? materialButton.getId() : -1;
            }
            if (MaterialButtonToggleGroup.this.z(materialButton.getId(), z)) {
                MaterialButtonToggleGroup.this.n(materialButton.getId(), materialButton.isChecked());
            }
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ c(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static class d {

        /* renamed from: e */
        private static final e.j.a.c.z.d f2825e = new e.j.a.c.z.a(0.0f);
        public e.j.a.c.z.d a;
        public e.j.a.c.z.d b;

        /* renamed from: c */
        public e.j.a.c.z.d f2826c;

        /* renamed from: d */
        public e.j.a.c.z.d f2827d;

        public d(e.j.a.c.z.d dVar, e.j.a.c.z.d dVar2, e.j.a.c.z.d dVar3, e.j.a.c.z.d dVar4) {
            this.a = dVar;
            this.b = dVar3;
            this.f2826c = dVar4;
            this.f2827d = dVar2;
        }

        public static d a(d dVar) {
            e.j.a.c.z.d dVar2 = f2825e;
            return new d(dVar2, dVar.f2827d, dVar2, dVar.f2826c);
        }

        public static d b(d dVar, View view) {
            return t.j(view) ? c(dVar) : d(dVar);
        }

        public static d c(d dVar) {
            e.j.a.c.z.d dVar2 = dVar.a;
            e.j.a.c.z.d dVar3 = dVar.f2827d;
            e.j.a.c.z.d dVar4 = f2825e;
            return new d(dVar2, dVar3, dVar4, dVar4);
        }

        public static d d(d dVar) {
            e.j.a.c.z.d dVar2 = f2825e;
            return new d(dVar2, dVar2, dVar.b, dVar.f2826c);
        }

        public static d e(d dVar, View view) {
            return t.j(view) ? d(dVar) : c(dVar);
        }

        public static d f(d dVar) {
            e.j.a.c.z.d dVar2 = dVar.a;
            e.j.a.c.z.d dVar3 = f2825e;
            return new d(dVar2, dVar3, dVar.b, dVar3);
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void a(MaterialButtonToggleGroup materialButtonToggleGroup, @IdRes int i2, boolean z);
    }

    /* loaded from: classes2.dex */
    public class f implements MaterialButton.c {
        private f() {
            MaterialButtonToggleGroup.this = r1;
        }

        @Override // com.google.android.material.button.MaterialButton.c
        public void a(@NonNull MaterialButton materialButton, boolean z) {
            MaterialButtonToggleGroup.this.invalidate();
        }

        public /* synthetic */ f(MaterialButtonToggleGroup materialButtonToggleGroup, a aVar) {
            this();
        }
    }

    public MaterialButtonToggleGroup(@NonNull Context context) {
        this(context, null);
    }

    private void A() {
        TreeMap treeMap = new TreeMap(this.f2819e);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            treeMap.put(o(i2), Integer.valueOf(i2));
        }
        this.f2820f = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            if (r(i2)) {
                return i2;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (r(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i2 = 0;
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            if ((getChildAt(i3) instanceof MaterialButton) && r(i3)) {
                i2++;
            }
        }
        return i2;
    }

    private void h() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i2 = firstVisibleChildIndex + 1; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            int min = Math.min(o.getStrokeWidth(), o(i2 - 1).getStrokeWidth());
            LinearLayout.LayoutParams i3 = i(o);
            if (getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(i3, 0);
                MarginLayoutParamsCompat.setMarginStart(i3, -min);
                i3.topMargin = 0;
            } else {
                i3.bottomMargin = 0;
                i3.topMargin = -min;
                MarginLayoutParamsCompat.setMarginStart(i3, 0);
            }
            o.setLayoutParams(i3);
        }
        v(firstVisibleChildIndex);
    }

    @NonNull
    private LinearLayout.LayoutParams i(@NonNull View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return (LinearLayout.LayoutParams) layoutParams;
        }
        return new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
    }

    private void k(int i2, boolean z) {
        MaterialButton materialButton = (MaterialButton) findViewById(i2);
        if (materialButton != null) {
            materialButton.setChecked(z);
        }
    }

    public void n(@IdRes int i2, boolean z) {
        Iterator<e> it = this.f2818d.iterator();
        while (it.hasNext()) {
            it.next().a(this, i2, z);
        }
    }

    private MaterialButton o(int i2) {
        return (MaterialButton) getChildAt(i2);
    }

    public int p(@Nullable View view) {
        if (view instanceof MaterialButton) {
            int i2 = 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == view) {
                    return i2;
                }
                if ((getChildAt(i3) instanceof MaterialButton) && r(i3)) {
                    i2++;
                }
            }
            return -1;
        }
        return -1;
    }

    @Nullable
    private d q(int i2, int i3, int i4) {
        d dVar = this.a.get(i2);
        if (i3 == i4) {
            return dVar;
        }
        boolean z = getOrientation() == 0;
        if (i2 == i3) {
            return z ? d.e(dVar, this) : d.f(dVar);
        } else if (i2 == i4) {
            return z ? d.b(dVar, this) : d.a(dVar);
        } else {
            return null;
        }
    }

    private boolean r(int i2) {
        return getChildAt(i2).getVisibility() != 8;
    }

    private void setCheckedId(int i2) {
        this.f2824j = i2;
        n(i2, true);
    }

    private void setGeneratedIdIfNeeded(@NonNull MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(ViewCompat.generateViewId());
        }
    }

    private void setupButtonChild(@NonNull MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.a(this.b);
        materialButton.setOnPressedChangeListenerInternal(this.f2817c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    private void v(int i2) {
        if (getChildCount() == 0 || i2 == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) o(i2).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams.topMargin = 0;
            layoutParams.bottomMargin = 0;
            return;
        }
        MarginLayoutParamsCompat.setMarginEnd(layoutParams, 0);
        MarginLayoutParamsCompat.setMarginStart(layoutParams, 0);
        layoutParams.leftMargin = 0;
        layoutParams.rightMargin = 0;
    }

    private void w(@IdRes int i2, boolean z) {
        View findViewById = findViewById(i2);
        if (findViewById instanceof MaterialButton) {
            this.f2821g = true;
            ((MaterialButton) findViewById).setChecked(z);
            this.f2821g = false;
        }
    }

    private static void y(o.b bVar, @Nullable d dVar) {
        if (dVar == null) {
            bVar.o(0.0f);
        } else {
            bVar.L(dVar.a).y(dVar.f2827d).Q(dVar.b).D(dVar.f2826c);
        }
    }

    public boolean z(int i2, boolean z) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.f2823i && checkedButtonIds.isEmpty()) {
            w(i2, true);
            this.f2824j = i2;
            return false;
        }
        if (z && this.f2822h) {
            checkedButtonIds.remove(Integer.valueOf(i2));
            for (Integer num : checkedButtonIds) {
                int intValue = num.intValue();
                w(intValue, false);
                n(intValue, false);
            }
        }
        return true;
    }

    @VisibleForTesting
    public void B() {
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i2 = 0; i2 < childCount; i2++) {
            MaterialButton o = o(i2);
            if (o.getVisibility() != 8) {
                o.b v = o.getShapeAppearanceModel().v();
                y(v, q(i2, firstVisibleChildIndex, lastVisibleChildIndex));
                o.setShapeAppearanceModel(v.m());
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(f2815k, "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i2, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.isChecked()) {
            z(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        o shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.a.add(new d(shapeAppearanceModel.r(), shapeAppearanceModel.j(), shapeAppearanceModel.t(), shapeAppearanceModel.l()));
        ViewCompat.setAccessibilityDelegate(materialButton, new b());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(@NonNull Canvas canvas) {
        A();
        super.dispatchDraw(canvas);
    }

    public void g(@NonNull e eVar) {
        this.f2818d.add(eVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    @IdRes
    public int getCheckedButtonId() {
        if (this.f2822h) {
            return this.f2824j;
        }
        return -1;
    }

    @NonNull
    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            if (o.isChecked()) {
                arrayList.add(Integer.valueOf(o.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public int getChildDrawingOrder(int i2, int i3) {
        Integer[] numArr = this.f2820f;
        if (numArr != null && i3 < numArr.length) {
            return numArr[i3].intValue();
        }
        Log.w(f2815k, "Child order wasn't updated");
        return i3;
    }

    public void j(@IdRes int i2) {
        if (i2 == this.f2824j) {
            return;
        }
        k(i2, true);
    }

    public void l() {
        this.f2821g = true;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            MaterialButton o = o(i2);
            o.setChecked(false);
            n(o.getId(), false);
        }
        this.f2821g = false;
        setCheckedId(-1);
    }

    public void m() {
        this.f2818d.clear();
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f2824j;
        if (i2 != -1) {
            k(i2, true);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getVisibleButtonCount(), false, t() ? 1 : 2));
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        B();
        h();
        super.onMeasure(i2, i3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.i(this.b);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.a.remove(indexOfChild);
        }
        B();
        h();
    }

    public boolean s() {
        return this.f2823i;
    }

    public void setSelectionRequired(boolean z) {
        this.f2823i = z;
    }

    public void setSingleSelection(boolean z) {
        if (this.f2822h != z) {
            this.f2822h = z;
            l();
        }
    }

    public boolean t() {
        return this.f2822h;
    }

    public void u(@NonNull e eVar) {
        this.f2818d.remove(eVar);
    }

    public void x(@IdRes int i2) {
        k(i2, false);
    }

    public MaterialButtonToggleGroup(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public MaterialButtonToggleGroup(@androidx.annotation.NonNull android.content.Context r7, @androidx.annotation.Nullable android.util.AttributeSet r8, int r9) {
        /*
            r6 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f2816l
            android.content.Context r7 = e.j.a.c.e0.a.a.c(r7, r8, r9, r4)
            r6.<init>(r7, r8, r9)
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            r6.a = r7
            com.google.android.material.button.MaterialButtonToggleGroup$c r7 = new com.google.android.material.button.MaterialButtonToggleGroup$c
            r0 = 0
            r7.<init>(r6, r0)
            r6.b = r7
            com.google.android.material.button.MaterialButtonToggleGroup$f r7 = new com.google.android.material.button.MaterialButtonToggleGroup$f
            r7.<init>(r6, r0)
            r6.f2817c = r7
            java.util.LinkedHashSet r7 = new java.util.LinkedHashSet
            r7.<init>()
            r6.f2818d = r7
            com.google.android.material.button.MaterialButtonToggleGroup$a r7 = new com.google.android.material.button.MaterialButtonToggleGroup$a
            r7.<init>()
            r6.f2819e = r7
            r7 = 0
            r6.f2821g = r7
            android.content.Context r0 = r6.getContext()
            int[] r2 = com.google.android.material.R.styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r7]
            r1 = r8
            r3 = r9
            android.content.res.TypedArray r8 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r7)
            r6.setSingleSelection(r9)
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_checkedButton
            r0 = -1
            int r9 = r8.getResourceId(r9, r0)
            r6.f2824j = r9
            int r9 = com.google.android.material.R.styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r7 = r8.getBoolean(r9, r7)
            r6.f2823i = r7
            r7 = 1
            r6.setChildrenDrawingOrderEnabled(r7)
            r8.recycle()
            androidx.core.view.ViewCompat.setImportantForAccessibility(r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(@BoolRes int i2) {
        setSingleSelection(getResources().getBoolean(i2));
    }
}
