package com.google.android.flexbox;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import e.j.a.a.d;
import e.j.a.a.f;
import e.j.a.a.h;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FlexboxLayout extends ViewGroup implements d {
    public static final int r = 0;
    public static final int s = 1;
    public static final int t = 2;
    public static final int u = 4;
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f2572c;

    /* renamed from: d  reason: collision with root package name */
    private int f2573d;

    /* renamed from: e  reason: collision with root package name */
    private int f2574e;

    /* renamed from: f  reason: collision with root package name */
    private int f2575f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private Drawable f2576g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private Drawable f2577h;

    /* renamed from: i  reason: collision with root package name */
    private int f2578i;

    /* renamed from: j  reason: collision with root package name */
    private int f2579j;

    /* renamed from: k  reason: collision with root package name */
    private int f2580k;

    /* renamed from: l  reason: collision with root package name */
    private int f2581l;

    /* renamed from: m  reason: collision with root package name */
    private int[] f2582m;
    private SparseIntArray n;
    private h o;
    private List<f> p;
    private h.b q;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface a {
    }

    public FlexboxLayout(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.f2576g == null && this.f2577h == null) {
            setWillNotDraw(true);
        } else {
            setWillNotDraw(false);
        }
    }

    private boolean k(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (this.p.get(i3).d() > 0) {
                return false;
            }
        }
        return true;
    }

    private boolean l(int i2, int i3) {
        for (int i4 = 1; i4 <= i3; i4++) {
            View r2 = r(i2 - i4);
            if (r2 != null && r2.getVisibility() != 8) {
                return false;
            }
        }
        return true;
    }

    private void m(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int right;
        int left;
        int paddingLeft = getPaddingLeft();
        int max = Math.max(0, (getWidth() - getPaddingRight()) - paddingLeft);
        int size = this.p.size();
        for (int i4 = 0; i4 < size; i4++) {
            f fVar = this.p.get(i4);
            for (int i5 = 0; i5 < fVar.f10088h; i5++) {
                int i6 = fVar.o + i5;
                View r2 = r(i6);
                if (r2 != null && r2.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) r2.getLayoutParams();
                    if (s(i6, i5)) {
                        if (z) {
                            left = r2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        } else {
                            left = (r2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f2581l;
                        }
                        p(canvas, left, fVar.b, fVar.f10087g);
                    }
                    if (i5 == fVar.f10088h - 1 && (this.f2579j & 4) > 0) {
                        if (z) {
                            right = (r2.getLeft() - ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin) - this.f2581l;
                        } else {
                            right = r2.getRight() + ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin;
                        }
                        p(canvas, right, fVar.b, fVar.f10087g);
                    }
                }
            }
            if (t(i4)) {
                if (z2) {
                    i3 = fVar.f10084d;
                } else {
                    i3 = fVar.b - this.f2580k;
                }
                o(canvas, paddingLeft, i3, max);
            }
            if (u(i4) && (this.f2578i & 4) > 0) {
                if (z2) {
                    i2 = fVar.b - this.f2580k;
                } else {
                    i2 = fVar.f10084d;
                }
                o(canvas, paddingLeft, i2, max);
            }
        }
    }

    private void n(Canvas canvas, boolean z, boolean z2) {
        int i2;
        int i3;
        int bottom;
        int top;
        int paddingTop = getPaddingTop();
        int max = Math.max(0, (getHeight() - getPaddingBottom()) - paddingTop);
        int size = this.p.size();
        for (int i4 = 0; i4 < size; i4++) {
            f fVar = this.p.get(i4);
            for (int i5 = 0; i5 < fVar.f10088h; i5++) {
                int i6 = fVar.o + i5;
                View r2 = r(i6);
                if (r2 != null && r2.getVisibility() != 8) {
                    LayoutParams layoutParams = (LayoutParams) r2.getLayoutParams();
                    if (s(i6, i5)) {
                        if (z2) {
                            top = r2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        } else {
                            top = (r2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f2580k;
                        }
                        o(canvas, fVar.a, top, fVar.f10087g);
                    }
                    if (i5 == fVar.f10088h - 1 && (this.f2578i & 4) > 0) {
                        if (z2) {
                            bottom = (r2.getTop() - ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) - this.f2580k;
                        } else {
                            bottom = r2.getBottom() + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                        }
                        o(canvas, fVar.a, bottom, fVar.f10087g);
                    }
                }
            }
            if (t(i4)) {
                if (z) {
                    i3 = fVar.f10083c;
                } else {
                    i3 = fVar.a - this.f2581l;
                }
                p(canvas, i3, paddingTop, max);
            }
            if (u(i4) && (this.f2579j & 4) > 0) {
                if (z) {
                    i2 = fVar.a - this.f2581l;
                } else {
                    i2 = fVar.f10083c;
                }
                p(canvas, i2, paddingTop, max);
            }
        }
    }

    private void o(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f2576g;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i3, i4 + i2, this.f2580k + i3);
        this.f2576g.draw(canvas);
    }

    private void p(Canvas canvas, int i2, int i3, int i4) {
        Drawable drawable = this.f2577h;
        if (drawable == null) {
            return;
        }
        drawable.setBounds(i2, i3, this.f2581l + i2, i4 + i3);
        this.f2577h.draw(canvas);
    }

    private boolean s(int i2, int i3) {
        return l(i2, i3) ? j() ? (this.f2579j & 1) != 0 : (this.f2578i & 1) != 0 : j() ? (this.f2579j & 2) != 0 : (this.f2578i & 2) != 0;
    }

    private boolean t(int i2) {
        if (i2 < 0 || i2 >= this.p.size()) {
            return false;
        }
        return k(i2) ? j() ? (this.f2578i & 1) != 0 : (this.f2579j & 1) != 0 : j() ? (this.f2578i & 2) != 0 : (this.f2579j & 2) != 0;
    }

    private boolean u(int i2) {
        if (i2 < 0 || i2 >= this.p.size()) {
            return false;
        }
        for (int i3 = i2 + 1; i3 < this.p.size(); i3++) {
            if (this.p.get(i3).d() > 0) {
                return false;
            }
        }
        return j() ? (this.f2578i & 4) != 0 : (this.f2579j & 4) != 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0182  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void v(boolean r29, int r30, int r31, int r32, int r33) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.v(boolean, int, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w(boolean r30, boolean r31, int r32, int r33, int r34, int r35) {
        /*
            Method dump skipped, instructions count: 532
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayout.w(boolean, boolean, int, int, int, int):void");
    }

    private void x(int i2, int i3) {
        this.p.clear();
        this.q.a();
        this.o.c(this.q, i2, i3);
        this.p = this.q.a;
        this.o.p(i2, i3);
        if (this.f2573d == 3) {
            for (f fVar : this.p) {
                int i4 = Integer.MIN_VALUE;
                for (int i5 = 0; i5 < fVar.f10088h; i5++) {
                    View r2 = r(fVar.o + i5);
                    if (r2 != null && r2.getVisibility() != 8) {
                        LayoutParams layoutParams = (LayoutParams) r2.getLayoutParams();
                        if (this.b != 2) {
                            i4 = Math.max(i4, r2.getMeasuredHeight() + Math.max(fVar.f10092l - r2.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).topMargin) + ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin);
                        } else {
                            i4 = Math.max(i4, r2.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams).topMargin + Math.max((fVar.f10092l - r2.getMeasuredHeight()) + r2.getBaseline(), ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin));
                        }
                    }
                }
                fVar.f10087g = i4;
            }
        }
        this.o.o(i2, i3, getPaddingTop() + getPaddingBottom());
        this.o.X();
        z(this.a, i2, i3, this.q.b);
    }

    private void y(int i2, int i3) {
        this.p.clear();
        this.q.a();
        this.o.f(this.q, i2, i3);
        this.p = this.q.a;
        this.o.p(i2, i3);
        this.o.o(i2, i3, getPaddingLeft() + getPaddingRight());
        this.o.X();
        z(this.a, i2, i3, this.q.b);
    }

    private void z(int i2, int i3, int i4, int i5) {
        int sumOfCrossSize;
        int largestMainSize;
        int resolveSizeAndState;
        int resolveSizeAndState2;
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        int mode2 = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i4);
        if (i2 == 0 || i2 == 1) {
            sumOfCrossSize = getSumOfCrossSize() + getPaddingTop() + getPaddingBottom();
            largestMainSize = getLargestMainSize();
        } else if (i2 != 2 && i2 != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + i2);
        } else {
            sumOfCrossSize = getLargestMainSize();
            largestMainSize = getSumOfCrossSize() + getPaddingLeft() + getPaddingRight();
        }
        if (mode == Integer.MIN_VALUE) {
            if (size < largestMainSize) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            } else {
                size = largestMainSize;
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i3, i5);
        } else if (mode == 0) {
            resolveSizeAndState = View.resolveSizeAndState(largestMainSize, i3, i5);
        } else if (mode == 1073741824) {
            if (size < largestMainSize) {
                i5 = View.combineMeasuredStates(i5, 16777216);
            }
            resolveSizeAndState = View.resolveSizeAndState(size, i3, i5);
        } else {
            throw new IllegalStateException("Unknown width mode is set: " + mode);
        }
        if (mode2 == Integer.MIN_VALUE) {
            if (size2 < sumOfCrossSize) {
                i5 = View.combineMeasuredStates(i5, 256);
            } else {
                size2 = sumOfCrossSize;
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i5);
        } else if (mode2 == 0) {
            resolveSizeAndState2 = View.resolveSizeAndState(sumOfCrossSize, i4, i5);
        } else if (mode2 == 1073741824) {
            if (size2 < sumOfCrossSize) {
                i5 = View.combineMeasuredStates(i5, 256);
            }
            resolveSizeAndState2 = View.resolveSizeAndState(size2, i4, i5);
        } else {
            throw new IllegalStateException("Unknown height mode is set: " + mode2);
        }
        setMeasuredDimension(resolveSizeAndState, resolveSizeAndState2);
    }

    @Override // e.j.a.a.d
    public void a(View view, int i2, int i3, f fVar) {
        if (s(i2, i3)) {
            if (j()) {
                int i4 = fVar.f10085e;
                int i5 = this.f2581l;
                fVar.f10085e = i4 + i5;
                fVar.f10086f += i5;
                return;
            }
            int i6 = fVar.f10085e;
            int i7 = this.f2580k;
            fVar.f10085e = i6 + i7;
            fVar.f10086f += i7;
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        this.f2582m = this.o.n(view, i2, layoutParams, this.n);
        super.addView(view, i2, layoutParams);
    }

    @Override // e.j.a.a.d
    public int b(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // e.j.a.a.d
    public View c(int i2) {
        return getChildAt(i2);
    }

    @Override // android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // e.j.a.a.d
    public int d(int i2, int i3, int i4) {
        return ViewGroup.getChildMeasureSpec(i2, i3, i4);
    }

    @Override // e.j.a.a.d
    public int e(View view) {
        return 0;
    }

    @Override // e.j.a.a.d
    public void f(f fVar) {
        if (j()) {
            if ((this.f2579j & 4) > 0) {
                int i2 = fVar.f10085e;
                int i3 = this.f2581l;
                fVar.f10085e = i2 + i3;
                fVar.f10086f += i3;
            }
        } else if ((this.f2578i & 4) > 0) {
            int i4 = fVar.f10085e;
            int i5 = this.f2580k;
            fVar.f10085e = i4 + i5;
            fVar.f10086f += i5;
        }
    }

    @Override // e.j.a.a.d
    public View g(int i2) {
        return r(i2);
    }

    @Override // e.j.a.a.d
    public int getAlignContent() {
        return this.f2574e;
    }

    @Override // e.j.a.a.d
    public int getAlignItems() {
        return this.f2573d;
    }

    @Nullable
    public Drawable getDividerDrawableHorizontal() {
        return this.f2576g;
    }

    @Nullable
    public Drawable getDividerDrawableVertical() {
        return this.f2577h;
    }

    @Override // e.j.a.a.d
    public int getFlexDirection() {
        return this.a;
    }

    @Override // e.j.a.a.d
    public int getFlexItemCount() {
        return getChildCount();
    }

    @Override // e.j.a.a.d
    public List<f> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.p.size());
        for (f fVar : this.p) {
            if (fVar.d() != 0) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    @Override // e.j.a.a.d
    public List<f> getFlexLinesInternal() {
        return this.p;
    }

    @Override // e.j.a.a.d
    public int getFlexWrap() {
        return this.b;
    }

    @Override // e.j.a.a.d
    public int getJustifyContent() {
        return this.f2572c;
    }

    @Override // e.j.a.a.d
    public int getLargestMainSize() {
        int i2 = Integer.MIN_VALUE;
        for (f fVar : this.p) {
            i2 = Math.max(i2, fVar.f10085e);
        }
        return i2;
    }

    @Override // e.j.a.a.d
    public int getMaxLine() {
        return this.f2575f;
    }

    public int getShowDividerHorizontal() {
        return this.f2578i;
    }

    public int getShowDividerVertical() {
        return this.f2579j;
    }

    @Override // e.j.a.a.d
    public int getSumOfCrossSize() {
        int i2;
        int i3;
        int size = this.p.size();
        int i4 = 0;
        for (int i5 = 0; i5 < size; i5++) {
            f fVar = this.p.get(i5);
            if (t(i5)) {
                if (j()) {
                    i3 = this.f2580k;
                } else {
                    i3 = this.f2581l;
                }
                i4 += i3;
            }
            if (u(i5)) {
                if (j()) {
                    i2 = this.f2580k;
                } else {
                    i2 = this.f2581l;
                }
                i4 += i2;
            }
            i4 += fVar.f10087g;
        }
        return i4;
    }

    @Override // e.j.a.a.d
    public void h(int i2, View view) {
    }

    @Override // e.j.a.a.d
    public int i(View view, int i2, int i3) {
        int i4;
        int i5;
        if (j()) {
            i4 = s(i2, i3) ? 0 + this.f2581l : 0;
            if ((this.f2579j & 4) <= 0) {
                return i4;
            }
            i5 = this.f2581l;
        } else {
            i4 = s(i2, i3) ? 0 + this.f2580k : 0;
            if ((this.f2578i & 4) <= 0) {
                return i4;
            }
            i5 = this.f2580k;
        }
        return i4 + i5;
    }

    @Override // e.j.a.a.d
    public boolean j() {
        int i2 = this.a;
        return i2 == 0 || i2 == 1;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        if (this.f2577h == null && this.f2576g == null) {
            return;
        }
        if (this.f2578i == 0 && this.f2579j == 0) {
            return;
        }
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i2 = this.a;
        if (i2 == 0) {
            m(canvas, layoutDirection == 1, this.b == 2);
        } else if (i2 == 1) {
            m(canvas, layoutDirection != 1, this.b == 2);
        } else if (i2 == 2) {
            boolean z = layoutDirection == 1;
            if (this.b == 2) {
                z = !z;
            }
            n(canvas, z, false);
        } else if (i2 != 3) {
        } else {
            boolean z2 = layoutDirection == 1;
            if (this.b == 2) {
                z2 = !z2;
            }
            n(canvas, z2, true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        boolean z2;
        int layoutDirection = ViewCompat.getLayoutDirection(this);
        int i6 = this.a;
        if (i6 == 0) {
            v(layoutDirection == 1, i2, i3, i4, i5);
        } else if (i6 == 1) {
            v(layoutDirection != 1, i2, i3, i4, i5);
        } else if (i6 == 2) {
            z2 = layoutDirection == 1;
            w(this.b == 2 ? !z2 : z2, false, i2, i3, i4, i5);
        } else if (i6 == 3) {
            z2 = layoutDirection == 1;
            w(this.b == 2 ? !z2 : z2, true, i2, i3, i4, i5);
        } else {
            throw new IllegalStateException("Invalid flex direction is set: " + this.a);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        if (this.n == null) {
            this.n = new SparseIntArray(getChildCount());
        }
        if (this.o.O(this.n)) {
            this.f2582m = this.o.m(this.n);
        }
        int i4 = this.a;
        if (i4 == 0 || i4 == 1) {
            x(i2, i3);
        } else if (i4 != 2 && i4 != 3) {
            throw new IllegalStateException("Invalid value for the flex direction is set: " + this.a);
        } else {
            y(i2, i3);
        }
    }

    @Override // android.view.ViewGroup
    /* renamed from: q */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public View r(int i2) {
        if (i2 >= 0) {
            int[] iArr = this.f2582m;
            if (i2 >= iArr.length) {
                return null;
            }
            return getChildAt(iArr[i2]);
        }
        return null;
    }

    @Override // e.j.a.a.d
    public void setAlignContent(int i2) {
        if (this.f2574e != i2) {
            this.f2574e = i2;
            requestLayout();
        }
    }

    @Override // e.j.a.a.d
    public void setAlignItems(int i2) {
        if (this.f2573d != i2) {
            this.f2573d = i2;
            requestLayout();
        }
    }

    public void setDividerDrawable(Drawable drawable) {
        setDividerDrawableHorizontal(drawable);
        setDividerDrawableVertical(drawable);
    }

    public void setDividerDrawableHorizontal(@Nullable Drawable drawable) {
        if (drawable == this.f2576g) {
            return;
        }
        this.f2576g = drawable;
        if (drawable != null) {
            this.f2580k = drawable.getIntrinsicHeight();
        } else {
            this.f2580k = 0;
        }
        A();
        requestLayout();
    }

    public void setDividerDrawableVertical(@Nullable Drawable drawable) {
        if (drawable == this.f2577h) {
            return;
        }
        this.f2577h = drawable;
        if (drawable != null) {
            this.f2581l = drawable.getIntrinsicWidth();
        } else {
            this.f2581l = 0;
        }
        A();
        requestLayout();
    }

    @Override // e.j.a.a.d
    public void setFlexDirection(int i2) {
        if (this.a != i2) {
            this.a = i2;
            requestLayout();
        }
    }

    @Override // e.j.a.a.d
    public void setFlexLines(List<f> list) {
        this.p = list;
    }

    @Override // e.j.a.a.d
    public void setFlexWrap(int i2) {
        if (this.b != i2) {
            this.b = i2;
            requestLayout();
        }
    }

    @Override // e.j.a.a.d
    public void setJustifyContent(int i2) {
        if (this.f2572c != i2) {
            this.f2572c = i2;
            requestLayout();
        }
    }

    @Override // e.j.a.a.d
    public void setMaxLine(int i2) {
        if (this.f2575f != i2) {
            this.f2575f = i2;
            requestLayout();
        }
    }

    public void setShowDivider(int i2) {
        setShowDividerVertical(i2);
        setShowDividerHorizontal(i2);
    }

    public void setShowDividerHorizontal(int i2) {
        if (i2 != this.f2578i) {
            this.f2578i = i2;
            requestLayout();
        }
    }

    public void setShowDividerVertical(int i2) {
        if (i2 != this.f2579j) {
            this.f2579j = i2;
            requestLayout();
        }
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LayoutParams) {
            return new LayoutParams((LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    public FlexboxLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f2575f = -1;
        this.o = new h(this);
        this.p = new ArrayList();
        this.q = new h.b();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout, i2, 0);
        this.a = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexDirection, 0);
        this.b = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_flexWrap, 0);
        this.f2572c = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_justifyContent, 0);
        this.f2573d = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignItems, 0);
        this.f2574e = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_alignContent, 0);
        this.f2575f = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_maxLine, -1);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawable);
        if (drawable != null) {
            setDividerDrawableHorizontal(drawable);
            setDividerDrawableVertical(drawable);
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableHorizontal);
        if (drawable2 != null) {
            setDividerDrawableHorizontal(drawable2);
        }
        Drawable drawable3 = obtainStyledAttributes.getDrawable(R.styleable.FlexboxLayout_dividerDrawableVertical);
        if (drawable3 != null) {
            setDividerDrawableVertical(drawable3);
        }
        int i3 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDivider, 0);
        if (i3 != 0) {
            this.f2579j = i3;
            this.f2578i = i3;
        }
        int i4 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerVertical, 0);
        if (i4 != 0) {
            this.f2579j = i4;
        }
        int i5 = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_showDividerHorizontal, 0);
        if (i5 != 0) {
            this.f2578i = i5;
        }
        obtainStyledAttributes.recycle();
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends ViewGroup.MarginLayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
        private int mOrder;
        private boolean mWrapBefore;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<LayoutParams> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public LayoutParams createFromParcel(Parcel parcel) {
                return new LayoutParams(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public LayoutParams[] newArray(int i2) {
                return new LayoutParams[i2];
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FlexboxLayout_Layout);
            this.mOrder = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_order, 1);
            this.mFlexGrow = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexGrow, 0.0f);
            this.mFlexShrink = obtainStyledAttributes.getFloat(R.styleable.FlexboxLayout_Layout_layout_flexShrink, 1.0f);
            this.mAlignSelf = obtainStyledAttributes.getInt(R.styleable.FlexboxLayout_Layout_layout_alignSelf, -1);
            this.mFlexBasisPercent = obtainStyledAttributes.getFraction(R.styleable.FlexboxLayout_Layout_layout_flexBasisPercent, 1, 1, -1.0f);
            this.mMinWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minWidth, -1);
            this.mMinHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_minHeight, -1);
            this.mMaxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxWidth, 16777215);
            this.mMaxHeight = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlexboxLayout_Layout_layout_maxHeight, 16777215);
            this.mWrapBefore = obtainStyledAttributes.getBoolean(R.styleable.FlexboxLayout_Layout_layout_wrapBefore, false);
            obtainStyledAttributes.recycle();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getAlignSelf() {
            return this.mAlignSelf;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexBasisPercent() {
            return this.mFlexBasisPercent;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexGrow() {
            return this.mFlexGrow;
        }

        @Override // com.google.android.flexbox.FlexItem
        public float getFlexShrink() {
            return this.mFlexShrink;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getHeight() {
            return ((ViewGroup.MarginLayoutParams) this).height;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginBottom() {
            return ((ViewGroup.MarginLayoutParams) this).bottomMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginLeft() {
            return ((ViewGroup.MarginLayoutParams) this).leftMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginRight() {
            return ((ViewGroup.MarginLayoutParams) this).rightMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMarginTop() {
            return ((ViewGroup.MarginLayoutParams) this).topMargin;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxHeight() {
            return this.mMaxHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMaxWidth() {
            return this.mMaxWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinHeight() {
            return this.mMinHeight;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getMinWidth() {
            return this.mMinWidth;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getOrder() {
            return this.mOrder;
        }

        @Override // com.google.android.flexbox.FlexItem
        public int getWidth() {
            return ((ViewGroup.MarginLayoutParams) this).width;
        }

        @Override // com.google.android.flexbox.FlexItem
        public boolean isWrapBefore() {
            return this.mWrapBefore;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setAlignSelf(int i2) {
            this.mAlignSelf = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexBasisPercent(float f2) {
            this.mFlexBasisPercent = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexGrow(float f2) {
            this.mFlexGrow = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setFlexShrink(float f2) {
            this.mFlexShrink = f2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setHeight(int i2) {
            ((ViewGroup.MarginLayoutParams) this).height = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxHeight(int i2) {
            this.mMaxHeight = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMaxWidth(int i2) {
            this.mMaxWidth = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinHeight(int i2) {
            this.mMinHeight = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setMinWidth(int i2) {
            this.mMinWidth = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setOrder(int i2) {
            this.mOrder = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWidth(int i2) {
            ((ViewGroup.MarginLayoutParams) this).width = i2;
        }

        @Override // com.google.android.flexbox.FlexItem
        public void setWrapBefore(boolean z) {
            this.mWrapBefore = z;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.mOrder);
            parcel.writeFloat(this.mFlexGrow);
            parcel.writeFloat(this.mFlexShrink);
            parcel.writeInt(this.mAlignSelf);
            parcel.writeFloat(this.mFlexBasisPercent);
            parcel.writeInt(this.mMinWidth);
            parcel.writeInt(this.mMinHeight);
            parcel.writeInt(this.mMaxWidth);
            parcel.writeInt(this.mMaxHeight);
            parcel.writeByte(this.mWrapBefore ? (byte) 1 : (byte) 0);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).bottomMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).leftMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).rightMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).topMargin);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).height);
            parcel.writeInt(((ViewGroup.MarginLayoutParams) this).width);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = layoutParams.mOrder;
            this.mFlexGrow = layoutParams.mFlexGrow;
            this.mFlexShrink = layoutParams.mFlexShrink;
            this.mAlignSelf = layoutParams.mAlignSelf;
            this.mFlexBasisPercent = layoutParams.mFlexBasisPercent;
            this.mMinWidth = layoutParams.mMinWidth;
            this.mMinHeight = layoutParams.mMinHeight;
            this.mMaxWidth = layoutParams.mMaxWidth;
            this.mMaxHeight = layoutParams.mMaxHeight;
            this.mWrapBefore = layoutParams.mWrapBefore;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(int i2, int i3) {
            super(new ViewGroup.LayoutParams(i2, i3));
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(Parcel parcel) {
            super(0, 0);
            this.mOrder = 1;
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMinWidth = -1;
            this.mMinHeight = -1;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
            this.mOrder = parcel.readInt();
            this.mFlexGrow = parcel.readFloat();
            this.mFlexShrink = parcel.readFloat();
            this.mAlignSelf = parcel.readInt();
            this.mFlexBasisPercent = parcel.readFloat();
            this.mMinWidth = parcel.readInt();
            this.mMinHeight = parcel.readInt();
            this.mMaxWidth = parcel.readInt();
            this.mMaxHeight = parcel.readInt();
            this.mWrapBefore = parcel.readByte() != 0;
            ((ViewGroup.MarginLayoutParams) this).bottomMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).leftMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).rightMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).topMargin = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).height = parcel.readInt();
            ((ViewGroup.MarginLayoutParams) this).width = parcel.readInt();
        }
    }
}
