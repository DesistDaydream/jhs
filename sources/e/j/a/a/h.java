package e.j.a.a;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.widget.CompoundButtonCompat;
import com.google.android.flexbox.FlexItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public class h {

    /* renamed from: f  reason: collision with root package name */
    private static final int f10094f = 10;

    /* renamed from: g  reason: collision with root package name */
    private static final long f10095g = 4294967295L;

    /* renamed from: h  reason: collision with root package name */
    public static final /* synthetic */ boolean f10096h = false;
    private final d a;
    private boolean[] b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public int[] f10097c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public long[] f10098d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private long[] f10099e;

    /* loaded from: classes.dex */
    public static class b {
        public List<f> a;
        public int b;

        public void a() {
            this.a = null;
            this.b = 0;
        }
    }

    /* loaded from: classes.dex */
    public static class c implements Comparable<c> {
        public int a;
        public int b;

        private c() {
        }

        @Override // java.lang.Comparable
        /* renamed from: a */
        public int compareTo(@NonNull c cVar) {
            int i2 = this.b;
            int i3 = cVar.b;
            return i2 != i3 ? i2 - i3 : this.a - cVar.a;
        }

        @NonNull
        public String toString() {
            return "Order{order=" + this.b + ", index=" + this.a + '}';
        }
    }

    public h(d dVar) {
        this.a = dVar;
    }

    private int A(int i2, FlexItem flexItem, int i3) {
        d dVar = this.a;
        int b2 = dVar.b(i2, dVar.getPaddingLeft() + this.a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i3, flexItem.getWidth());
        int size = View.MeasureSpec.getSize(b2);
        if (size > flexItem.getMaxWidth()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxWidth(), View.MeasureSpec.getMode(b2));
        }
        return size < flexItem.getMinWidth() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinWidth(), View.MeasureSpec.getMode(b2)) : b2;
    }

    private int B(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginBottom();
        }
        return flexItem.getMarginRight();
    }

    private int C(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginRight();
        }
        return flexItem.getMarginBottom();
    }

    private int D(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginTop();
        }
        return flexItem.getMarginLeft();
    }

    private int E(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getMarginLeft();
        }
        return flexItem.getMarginTop();
    }

    private int F(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getHeight();
        }
        return flexItem.getWidth();
    }

    private int G(FlexItem flexItem, boolean z) {
        if (z) {
            return flexItem.getWidth();
        }
        return flexItem.getHeight();
    }

    private int H(boolean z) {
        if (z) {
            return this.a.getPaddingBottom();
        }
        return this.a.getPaddingEnd();
    }

    private int I(boolean z) {
        if (z) {
            return this.a.getPaddingEnd();
        }
        return this.a.getPaddingBottom();
    }

    private int J(boolean z) {
        if (z) {
            return this.a.getPaddingTop();
        }
        return this.a.getPaddingStart();
    }

    private int K(boolean z) {
        if (z) {
            return this.a.getPaddingStart();
        }
        return this.a.getPaddingTop();
    }

    private int L(View view, boolean z) {
        if (z) {
            return view.getMeasuredHeight();
        }
        return view.getMeasuredWidth();
    }

    private int M(View view, boolean z) {
        if (z) {
            return view.getMeasuredWidth();
        }
        return view.getMeasuredHeight();
    }

    private boolean N(int i2, int i3, f fVar) {
        return i2 == i3 - 1 && fVar.d() != 0;
    }

    private boolean P(View view, int i2, int i3, int i4, int i5, FlexItem flexItem, int i6, int i7, int i8) {
        if (this.a.getFlexWrap() == 0) {
            return false;
        }
        if (flexItem.isWrapBefore()) {
            return true;
        }
        if (i2 == 0) {
            return false;
        }
        int maxLine = this.a.getMaxLine();
        if (maxLine == -1 || maxLine > i8 + 1) {
            int i9 = this.a.i(view, i6, i7);
            if (i9 > 0) {
                i5 += i9;
            }
            return i3 < i4 + i5;
        }
        return false;
    }

    private void T(int i2, int i3, f fVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        int i9 = fVar.f10085e;
        float f2 = fVar.f10091k;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i4 > i9) {
            return;
        }
        float f4 = (i9 - i4) / f2;
        fVar.f10085e = i5 + fVar.f10086f;
        if (!z) {
            fVar.f10087g = Integer.MIN_VALUE;
        }
        int i10 = 0;
        boolean z2 = false;
        int i11 = 0;
        float f5 = 0.0f;
        while (i10 < fVar.f10088h) {
            int i12 = fVar.o + i10;
            View g2 = this.a.g(i12);
            if (g2 == null || g2.getVisibility() == 8) {
                i6 = i9;
                i7 = i10;
            } else {
                FlexItem flexItem = (FlexItem) g2.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = g2.getMeasuredHeight();
                    long[] jArr = this.f10099e;
                    if (jArr != null) {
                        measuredHeight = x(jArr[i12]);
                    }
                    int measuredWidth = g2.getMeasuredWidth();
                    long[] jArr2 = this.f10099e;
                    if (jArr2 != null) {
                        measuredWidth = y(jArr2[i12]);
                    }
                    if (this.b[i12] || flexItem.getFlexShrink() <= f3) {
                        i6 = i9;
                        i7 = i10;
                    } else {
                        float flexShrink = measuredHeight - (flexItem.getFlexShrink() * f4);
                        if (i10 == fVar.f10088h - 1) {
                            flexShrink += f5;
                            f5 = 0.0f;
                        }
                        int round = Math.round(flexShrink);
                        if (round < flexItem.getMinHeight()) {
                            round = flexItem.getMinHeight();
                            this.b[i12] = true;
                            fVar.f10091k -= flexItem.getFlexShrink();
                            i6 = i9;
                            i7 = i10;
                            z2 = true;
                        } else {
                            f5 += flexShrink - round;
                            i6 = i9;
                            i7 = i10;
                            double d2 = f5;
                            if (d2 > 1.0d) {
                                round++;
                                f5 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                round--;
                                f5 += 1.0f;
                            }
                        }
                        int A = A(i2, flexItem, fVar.f10093m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        g2.measure(A, makeMeasureSpec);
                        measuredWidth = g2.getMeasuredWidth();
                        int measuredHeight2 = g2.getMeasuredHeight();
                        Z(i12, A, makeMeasureSpec, g2);
                        this.a.h(i12, g2);
                        measuredHeight = measuredHeight2;
                    }
                    i8 = Math.max(i11, measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.a.e(g2));
                    fVar.f10085e += measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom();
                } else {
                    i6 = i9;
                    int i13 = i10;
                    int measuredWidth2 = g2.getMeasuredWidth();
                    long[] jArr3 = this.f10099e;
                    if (jArr3 != null) {
                        measuredWidth2 = y(jArr3[i12]);
                    }
                    int measuredHeight3 = g2.getMeasuredHeight();
                    long[] jArr4 = this.f10099e;
                    if (jArr4 != null) {
                        measuredHeight3 = x(jArr4[i12]);
                    }
                    if (this.b[i12] || flexItem.getFlexShrink() <= 0.0f) {
                        i7 = i13;
                    } else {
                        float flexShrink2 = measuredWidth2 - (flexItem.getFlexShrink() * f4);
                        i7 = i13;
                        if (i7 == fVar.f10088h - 1) {
                            flexShrink2 += f5;
                            f5 = 0.0f;
                        }
                        int round2 = Math.round(flexShrink2);
                        if (round2 < flexItem.getMinWidth()) {
                            round2 = flexItem.getMinWidth();
                            this.b[i12] = true;
                            fVar.f10091k -= flexItem.getFlexShrink();
                            z2 = true;
                        } else {
                            f5 += flexShrink2 - round2;
                            double d3 = f5;
                            if (d3 > 1.0d) {
                                round2++;
                                f5 -= 1.0f;
                            } else if (d3 < -1.0d) {
                                round2--;
                                f5 += 1.0f;
                            }
                        }
                        int z3 = z(i3, flexItem, fVar.f10093m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        g2.measure(makeMeasureSpec2, z3);
                        int measuredWidth3 = g2.getMeasuredWidth();
                        int measuredHeight4 = g2.getMeasuredHeight();
                        Z(i12, makeMeasureSpec2, z3, g2);
                        this.a.h(i12, g2);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i11, measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.a.e(g2));
                    fVar.f10085e += measuredWidth2 + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i8 = max;
                }
                fVar.f10087g = Math.max(fVar.f10087g, i8);
                i11 = i8;
            }
            i10 = i7 + 1;
            i9 = i6;
            f3 = 0.0f;
        }
        int i14 = i9;
        if (!z2 || i14 == fVar.f10085e) {
            return;
        }
        T(i2, i3, fVar, i4, i5, true);
    }

    private int[] U(int i2, List<c> list, SparseIntArray sparseIntArray) {
        Collections.sort(list);
        sparseIntArray.clear();
        int[] iArr = new int[i2];
        int i3 = 0;
        for (c cVar : list) {
            int i4 = cVar.a;
            iArr[i3] = i4;
            sparseIntArray.append(i4, cVar.b);
            i3++;
        }
        return iArr;
    }

    private void V(View view, int i2, int i3) {
        int measuredHeight;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - flexItem.getMarginLeft()) - flexItem.getMarginRight()) - this.a.e(view), flexItem.getMinWidth()), flexItem.getMaxWidth());
        long[] jArr = this.f10099e;
        if (jArr != null) {
            measuredHeight = x(jArr[i3]);
        } else {
            measuredHeight = view.getMeasuredHeight();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec2, makeMeasureSpec);
        Z(i3, makeMeasureSpec2, makeMeasureSpec, view);
        this.a.h(i3, view);
    }

    private void W(View view, int i2, int i3) {
        int measuredWidth;
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int min = Math.min(Math.max(((i2 - flexItem.getMarginTop()) - flexItem.getMarginBottom()) - this.a.e(view), flexItem.getMinHeight()), flexItem.getMaxHeight());
        long[] jArr = this.f10099e;
        if (jArr != null) {
            measuredWidth = y(jArr[i3]);
        } else {
            measuredWidth = view.getMeasuredWidth();
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(min, 1073741824);
        view.measure(makeMeasureSpec, makeMeasureSpec2);
        Z(i3, makeMeasureSpec, makeMeasureSpec2, view);
        this.a.h(i3, view);
    }

    private void Z(int i2, int i3, int i4, View view) {
        long[] jArr = this.f10098d;
        if (jArr != null) {
            jArr[i2] = S(i3, i4);
        }
        long[] jArr2 = this.f10099e;
        if (jArr2 != null) {
            jArr2[i2] = S(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    private void a(List<f> list, f fVar, int i2, int i3) {
        fVar.f10093m = i3;
        this.a.f(fVar);
        fVar.p = i2;
        list.add(fVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void i(android.view.View r7, int r8) {
        /*
            r6 = this;
            android.view.ViewGroup$LayoutParams r0 = r7.getLayoutParams()
            com.google.android.flexbox.FlexItem r0 = (com.google.android.flexbox.FlexItem) r0
            int r1 = r7.getMeasuredWidth()
            int r2 = r7.getMeasuredHeight()
            int r3 = r0.getMinWidth()
            r4 = 1
            if (r1 >= r3) goto L1b
            int r1 = r0.getMinWidth()
        L19:
            r3 = 1
            goto L27
        L1b:
            int r3 = r0.getMaxWidth()
            if (r1 <= r3) goto L26
            int r1 = r0.getMaxWidth()
            goto L19
        L26:
            r3 = 0
        L27:
            int r5 = r0.getMinHeight()
            if (r2 >= r5) goto L32
            int r2 = r0.getMinHeight()
            goto L3e
        L32:
            int r5 = r0.getMaxHeight()
            if (r2 <= r5) goto L3d
            int r2 = r0.getMaxHeight()
            goto L3e
        L3d:
            r4 = r3
        L3e:
            if (r4 == 0) goto L55
            r0 = 1073741824(0x40000000, float:2.0)
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r0)
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r0)
            r7.measure(r1, r0)
            r6.Z(r8, r1, r0, r7)
            e.j.a.a.d r0 = r6.a
            r0.h(r8, r7)
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.a.a.h.i(android.view.View, int):void");
    }

    private List<f> k(List<f> list, int i2, int i3) {
        ArrayList arrayList = new ArrayList();
        f fVar = new f();
        fVar.f10087g = (i2 - i3) / 2;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (i4 == 0) {
                arrayList.add(fVar);
            }
            arrayList.add(list.get(i4));
            if (i4 == list.size() - 1) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    @NonNull
    private List<c> l(int i2) {
        ArrayList arrayList = new ArrayList(i2);
        for (int i3 = 0; i3 < i2; i3++) {
            c cVar = new c();
            cVar.b = ((FlexItem) this.a.c(i3).getLayoutParams()).getOrder();
            cVar.a = i3;
            arrayList.add(cVar);
        }
        return arrayList;
    }

    private void r(int i2) {
        boolean[] zArr = this.b;
        if (zArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.b = new boolean[i2];
        } else if (zArr.length < i2) {
            int length = zArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.b = new boolean[i2];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    private void v(CompoundButton compoundButton) {
        FlexItem flexItem = (FlexItem) compoundButton.getLayoutParams();
        int minWidth = flexItem.getMinWidth();
        int minHeight = flexItem.getMinHeight();
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(compoundButton);
        int minimumWidth = buttonDrawable == null ? 0 : buttonDrawable.getMinimumWidth();
        int minimumHeight = buttonDrawable != null ? buttonDrawable.getMinimumHeight() : 0;
        if (minWidth == -1) {
            minWidth = minimumWidth;
        }
        flexItem.setMinWidth(minWidth);
        if (minHeight == -1) {
            minHeight = minimumHeight;
        }
        flexItem.setMinHeight(minHeight);
    }

    private void w(int i2, int i3, f fVar, int i4, int i5, boolean z) {
        int i6;
        int i7;
        int i8;
        double d2;
        int i9;
        double d3;
        float f2 = fVar.f10090j;
        float f3 = 0.0f;
        if (f2 <= 0.0f || i4 < (i6 = fVar.f10085e)) {
            return;
        }
        float f4 = (i4 - i6) / f2;
        fVar.f10085e = i5 + fVar.f10086f;
        if (!z) {
            fVar.f10087g = Integer.MIN_VALUE;
        }
        int i10 = 0;
        boolean z2 = false;
        int i11 = 0;
        float f5 = 0.0f;
        while (i10 < fVar.f10088h) {
            int i12 = fVar.o + i10;
            View g2 = this.a.g(i12);
            if (g2 == null || g2.getVisibility() == 8) {
                i7 = i6;
            } else {
                FlexItem flexItem = (FlexItem) g2.getLayoutParams();
                int flexDirection = this.a.getFlexDirection();
                if (flexDirection != 0 && flexDirection != 1) {
                    int measuredHeight = g2.getMeasuredHeight();
                    long[] jArr = this.f10099e;
                    if (jArr != null) {
                        measuredHeight = x(jArr[i12]);
                    }
                    int measuredWidth = g2.getMeasuredWidth();
                    long[] jArr2 = this.f10099e;
                    if (jArr2 != null) {
                        measuredWidth = y(jArr2[i12]);
                    }
                    if (this.b[i12] || flexItem.getFlexGrow() <= f3) {
                        i9 = i6;
                    } else {
                        float flexGrow = measuredHeight + (flexItem.getFlexGrow() * f4);
                        if (i10 == fVar.f10088h - 1) {
                            flexGrow += f5;
                            f5 = 0.0f;
                        }
                        int round = Math.round(flexGrow);
                        if (round > flexItem.getMaxHeight()) {
                            round = flexItem.getMaxHeight();
                            this.b[i12] = true;
                            fVar.f10090j -= flexItem.getFlexGrow();
                            i9 = i6;
                            z2 = true;
                        } else {
                            f5 += flexGrow - round;
                            i9 = i6;
                            double d4 = f5;
                            if (d4 > 1.0d) {
                                round++;
                                d3 = d4 - 1.0d;
                            } else if (d4 < -1.0d) {
                                round--;
                                d3 = d4 + 1.0d;
                            }
                            f5 = (float) d3;
                        }
                        int A = A(i2, flexItem, fVar.f10093m);
                        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(round, 1073741824);
                        g2.measure(A, makeMeasureSpec);
                        measuredWidth = g2.getMeasuredWidth();
                        int measuredHeight2 = g2.getMeasuredHeight();
                        Z(i12, A, makeMeasureSpec, g2);
                        this.a.h(i12, g2);
                        measuredHeight = measuredHeight2;
                    }
                    i8 = Math.max(i11, measuredWidth + flexItem.getMarginLeft() + flexItem.getMarginRight() + this.a.e(g2));
                    fVar.f10085e += measuredHeight + flexItem.getMarginTop() + flexItem.getMarginBottom();
                    i7 = i9;
                } else {
                    int i13 = i6;
                    int measuredWidth2 = g2.getMeasuredWidth();
                    long[] jArr3 = this.f10099e;
                    if (jArr3 != null) {
                        measuredWidth2 = y(jArr3[i12]);
                    }
                    int measuredHeight3 = g2.getMeasuredHeight();
                    long[] jArr4 = this.f10099e;
                    i7 = i13;
                    if (jArr4 != null) {
                        measuredHeight3 = x(jArr4[i12]);
                    }
                    if (!this.b[i12] && flexItem.getFlexGrow() > 0.0f) {
                        float flexGrow2 = measuredWidth2 + (flexItem.getFlexGrow() * f4);
                        if (i10 == fVar.f10088h - 1) {
                            flexGrow2 += f5;
                            f5 = 0.0f;
                        }
                        int round2 = Math.round(flexGrow2);
                        if (round2 > flexItem.getMaxWidth()) {
                            round2 = flexItem.getMaxWidth();
                            this.b[i12] = true;
                            fVar.f10090j -= flexItem.getFlexGrow();
                            z2 = true;
                        } else {
                            f5 += flexGrow2 - round2;
                            double d5 = f5;
                            if (d5 > 1.0d) {
                                round2++;
                                d2 = d5 - 1.0d;
                            } else if (d5 < -1.0d) {
                                round2--;
                                d2 = d5 + 1.0d;
                            }
                            f5 = (float) d2;
                        }
                        int z3 = z(i3, flexItem, fVar.f10093m);
                        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(round2, 1073741824);
                        g2.measure(makeMeasureSpec2, z3);
                        int measuredWidth3 = g2.getMeasuredWidth();
                        int measuredHeight4 = g2.getMeasuredHeight();
                        Z(i12, makeMeasureSpec2, z3, g2);
                        this.a.h(i12, g2);
                        measuredWidth2 = measuredWidth3;
                        measuredHeight3 = measuredHeight4;
                    }
                    int max = Math.max(i11, measuredHeight3 + flexItem.getMarginTop() + flexItem.getMarginBottom() + this.a.e(g2));
                    fVar.f10085e += measuredWidth2 + flexItem.getMarginLeft() + flexItem.getMarginRight();
                    i8 = max;
                }
                fVar.f10087g = Math.max(fVar.f10087g, i8);
                i11 = i8;
            }
            i10++;
            i6 = i7;
            f3 = 0.0f;
        }
        int i14 = i6;
        if (!z2 || i14 == fVar.f10085e) {
            return;
        }
        w(i2, i3, fVar, i4, i5, true);
    }

    private int z(int i2, FlexItem flexItem, int i3) {
        d dVar = this.a;
        int d2 = dVar.d(i2, dVar.getPaddingTop() + this.a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i3, flexItem.getHeight());
        int size = View.MeasureSpec.getSize(d2);
        if (size > flexItem.getMaxHeight()) {
            return View.MeasureSpec.makeMeasureSpec(flexItem.getMaxHeight(), View.MeasureSpec.getMode(d2));
        }
        return size < flexItem.getMinHeight() ? View.MeasureSpec.makeMeasureSpec(flexItem.getMinHeight(), View.MeasureSpec.getMode(d2)) : d2;
    }

    public boolean O(SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        if (sparseIntArray.size() != flexItemCount) {
            return true;
        }
        for (int i2 = 0; i2 < flexItemCount; i2++) {
            View c2 = this.a.c(i2);
            if (c2 != null && ((FlexItem) c2.getLayoutParams()).getOrder() != sparseIntArray.get(i2)) {
                return true;
            }
        }
        return false;
    }

    public void Q(View view, f fVar, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i6 = fVar.f10087g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (this.a.getFlexWrap() != 2) {
                    int i7 = i3 + i6;
                    view.layout(i2, (i7 - view.getMeasuredHeight()) - flexItem.getMarginBottom(), i4, i7 - flexItem.getMarginBottom());
                    return;
                }
                view.layout(i2, (i3 - i6) + view.getMeasuredHeight() + flexItem.getMarginTop(), i4, (i5 - i6) + view.getMeasuredHeight() + flexItem.getMarginTop());
                return;
            } else if (alignItems == 2) {
                int measuredHeight = (((i6 - view.getMeasuredHeight()) + flexItem.getMarginTop()) - flexItem.getMarginBottom()) / 2;
                if (this.a.getFlexWrap() != 2) {
                    int i8 = i3 + measuredHeight;
                    view.layout(i2, i8, i4, view.getMeasuredHeight() + i8);
                    return;
                }
                int i9 = i3 - measuredHeight;
                view.layout(i2, i9, i4, view.getMeasuredHeight() + i9);
                return;
            } else if (alignItems == 3) {
                if (this.a.getFlexWrap() != 2) {
                    int max = Math.max(fVar.f10092l - view.getBaseline(), flexItem.getMarginTop());
                    view.layout(i2, i3 + max, i4, i5 + max);
                    return;
                }
                int max2 = Math.max((fVar.f10092l - view.getMeasuredHeight()) + view.getBaseline(), flexItem.getMarginBottom());
                view.layout(i2, i3 - max2, i4, i5 - max2);
                return;
            } else if (alignItems != 4) {
                return;
            }
        }
        if (this.a.getFlexWrap() != 2) {
            view.layout(i2, i3 + flexItem.getMarginTop(), i4, i5 + flexItem.getMarginTop());
        } else {
            view.layout(i2, i3 - flexItem.getMarginBottom(), i4, i5 - flexItem.getMarginBottom());
        }
    }

    public void R(View view, f fVar, boolean z, int i2, int i3, int i4, int i5) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        int alignItems = this.a.getAlignItems();
        if (flexItem.getAlignSelf() != -1) {
            alignItems = flexItem.getAlignSelf();
        }
        int i6 = fVar.f10087g;
        if (alignItems != 0) {
            if (alignItems == 1) {
                if (!z) {
                    view.layout(((i2 + i6) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i3, ((i4 + i6) - view.getMeasuredWidth()) - flexItem.getMarginRight(), i5);
                    return;
                } else {
                    view.layout((i2 - i6) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i3, (i4 - i6) + view.getMeasuredWidth() + flexItem.getMarginLeft(), i5);
                    return;
                }
            } else if (alignItems == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i6 - view.getMeasuredWidth()) + MarginLayoutParamsCompat.getMarginStart(marginLayoutParams)) - MarginLayoutParamsCompat.getMarginEnd(marginLayoutParams)) / 2;
                if (!z) {
                    view.layout(i2 + measuredWidth, i3, i4 + measuredWidth, i5);
                    return;
                } else {
                    view.layout(i2 - measuredWidth, i3, i4 - measuredWidth, i5);
                    return;
                }
            } else if (alignItems != 3 && alignItems != 4) {
                return;
            }
        }
        if (!z) {
            view.layout(i2 + flexItem.getMarginLeft(), i3, i4 + flexItem.getMarginLeft(), i5);
        } else {
            view.layout(i2 - flexItem.getMarginRight(), i3, i4 - flexItem.getMarginRight(), i5);
        }
    }

    @VisibleForTesting
    public long S(int i2, int i3) {
        return (i2 & f10095g) | (i3 << 32);
    }

    public void X() {
        Y(0);
    }

    public void Y(int i2) {
        View g2;
        if (i2 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        if (this.a.getAlignItems() == 4) {
            int[] iArr = this.f10097c;
            List<f> flexLinesInternal = this.a.getFlexLinesInternal();
            int size = flexLinesInternal.size();
            for (int i3 = iArr != null ? iArr[i2] : 0; i3 < size; i3++) {
                f fVar = flexLinesInternal.get(i3);
                int i4 = fVar.f10088h;
                for (int i5 = 0; i5 < i4; i5++) {
                    int i6 = fVar.o + i5;
                    if (i5 < this.a.getFlexItemCount() && (g2 = this.a.g(i6)) != null && g2.getVisibility() != 8) {
                        FlexItem flexItem = (FlexItem) g2.getLayoutParams();
                        if (flexItem.getAlignSelf() == -1 || flexItem.getAlignSelf() == 4) {
                            if (flexDirection == 0 || flexDirection == 1) {
                                W(g2, fVar.f10087g, i6);
                            } else if (flexDirection != 2 && flexDirection != 3) {
                                throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                            } else {
                                V(g2, fVar.f10087g, i6);
                            }
                        }
                    }
                }
            }
            return;
        }
        for (f fVar2 : this.a.getFlexLinesInternal()) {
            for (Integer num : fVar2.n) {
                View g3 = this.a.g(num.intValue());
                if (flexDirection == 0 || flexDirection == 1) {
                    W(g3, fVar2.f10087g, num.intValue());
                } else if (flexDirection != 2 && flexDirection != 3) {
                    throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
                } else {
                    V(g3, fVar2.f10087g, num.intValue());
                }
            }
        }
    }

    public void b(b bVar, int i2, int i3, int i4, int i5, int i6, @Nullable List<f> list) {
        int i7;
        b bVar2;
        int i8;
        int i9;
        int i10;
        List<f> list2;
        int i11;
        View view;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        f fVar;
        int i18;
        int i19 = i2;
        int i20 = i3;
        int i21 = i6;
        boolean j2 = this.a.j();
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        ArrayList arrayList = list == null ? new ArrayList() : list;
        bVar.a = arrayList;
        boolean z = i21 == -1;
        int K = K(j2);
        int I = I(j2);
        int J = J(j2);
        int H = H(j2);
        f fVar2 = new f();
        int i22 = i5;
        fVar2.o = i22;
        int i23 = I + K;
        fVar2.f10085e = i23;
        int flexItemCount = this.a.getFlexItemCount();
        boolean z2 = z;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = Integer.MIN_VALUE;
        while (true) {
            if (i22 >= flexItemCount) {
                i7 = i25;
                bVar2 = bVar;
                break;
            }
            View g2 = this.a.g(i22);
            if (g2 == null) {
                if (N(i22, flexItemCount, fVar2)) {
                    a(arrayList, fVar2, i22, i24);
                }
            } else if (g2.getVisibility() == 8) {
                fVar2.f10089i++;
                fVar2.f10088h++;
                if (N(i22, flexItemCount, fVar2)) {
                    a(arrayList, fVar2, i22, i24);
                }
            } else {
                if (g2 instanceof CompoundButton) {
                    v((CompoundButton) g2);
                }
                FlexItem flexItem = (FlexItem) g2.getLayoutParams();
                int i28 = flexItemCount;
                if (flexItem.getAlignSelf() == 4) {
                    fVar2.n.add(Integer.valueOf(i22));
                }
                int G = G(flexItem, j2);
                if (flexItem.getFlexBasisPercent() != -1.0f && mode == 1073741824) {
                    G = Math.round(size * flexItem.getFlexBasisPercent());
                }
                if (j2) {
                    int b2 = this.a.b(i19, i23 + E(flexItem, true) + C(flexItem, true), G);
                    i8 = size;
                    i9 = mode;
                    int d2 = this.a.d(i20, J + H + D(flexItem, true) + B(flexItem, true) + i24, F(flexItem, true));
                    g2.measure(b2, d2);
                    Z(i22, b2, d2, g2);
                    i10 = b2;
                } else {
                    i8 = size;
                    i9 = mode;
                    int b3 = this.a.b(i20, J + H + D(flexItem, false) + B(flexItem, false) + i24, F(flexItem, false));
                    int d3 = this.a.d(i19, E(flexItem, false) + i23 + C(flexItem, false), G);
                    g2.measure(b3, d3);
                    Z(i22, b3, d3, g2);
                    i10 = d3;
                }
                this.a.h(i22, g2);
                i(g2, i22);
                i25 = View.combineMeasuredStates(i25, g2.getMeasuredState());
                int i29 = i24;
                int i30 = i23;
                f fVar3 = fVar2;
                int i31 = i22;
                list2 = arrayList;
                int i32 = i10;
                if (P(g2, i9, i8, fVar2.f10085e, C(flexItem, j2) + M(g2, j2) + E(flexItem, j2), flexItem, i31, i26, arrayList.size())) {
                    if (fVar3.d() > 0) {
                        if (i31 > 0) {
                            i18 = i31 - 1;
                            fVar = fVar3;
                        } else {
                            fVar = fVar3;
                            i18 = 0;
                        }
                        a(list2, fVar, i18, i29);
                        i24 = fVar.f10087g + i29;
                    } else {
                        i24 = i29;
                    }
                    if (j2) {
                        if (flexItem.getHeight() == -1) {
                            d dVar = this.a;
                            i11 = i3;
                            i22 = i31;
                            view = g2;
                            view.measure(i32, dVar.d(i11, dVar.getPaddingTop() + this.a.getPaddingBottom() + flexItem.getMarginTop() + flexItem.getMarginBottom() + i24, flexItem.getHeight()));
                            i(view, i22);
                        } else {
                            i11 = i3;
                            view = g2;
                            i22 = i31;
                        }
                    } else {
                        i11 = i3;
                        view = g2;
                        i22 = i31;
                        if (flexItem.getWidth() == -1) {
                            d dVar2 = this.a;
                            view.measure(dVar2.b(i11, dVar2.getPaddingLeft() + this.a.getPaddingRight() + flexItem.getMarginLeft() + flexItem.getMarginRight() + i24, flexItem.getWidth()), i32);
                            i(view, i22);
                        }
                    }
                    fVar2 = new f();
                    fVar2.f10088h = 1;
                    i12 = i30;
                    fVar2.f10085e = i12;
                    fVar2.o = i22;
                    i13 = 0;
                    i14 = Integer.MIN_VALUE;
                } else {
                    i11 = i3;
                    view = g2;
                    i22 = i31;
                    fVar2 = fVar3;
                    i12 = i30;
                    fVar2.f10088h++;
                    i13 = i26 + 1;
                    i24 = i29;
                    i14 = i27;
                }
                fVar2.q |= flexItem.getFlexGrow() != 0.0f;
                fVar2.r |= flexItem.getFlexShrink() != 0.0f;
                int[] iArr = this.f10097c;
                if (iArr != null) {
                    iArr[i22] = list2.size();
                }
                fVar2.f10085e += M(view, j2) + E(flexItem, j2) + C(flexItem, j2);
                fVar2.f10090j += flexItem.getFlexGrow();
                fVar2.f10091k += flexItem.getFlexShrink();
                this.a.a(view, i22, i13, fVar2);
                int max = Math.max(i14, L(view, j2) + D(flexItem, j2) + B(flexItem, j2) + this.a.e(view));
                fVar2.f10087g = Math.max(fVar2.f10087g, max);
                if (j2) {
                    if (this.a.getFlexWrap() != 2) {
                        fVar2.f10092l = Math.max(fVar2.f10092l, view.getBaseline() + flexItem.getMarginTop());
                    } else {
                        fVar2.f10092l = Math.max(fVar2.f10092l, (view.getMeasuredHeight() - view.getBaseline()) + flexItem.getMarginBottom());
                    }
                }
                i15 = i28;
                if (N(i22, i15, fVar2)) {
                    a(list2, fVar2, i22, i24);
                    i24 += fVar2.f10087g;
                }
                i16 = i6;
                if (i16 != -1 && list2.size() > 0) {
                    if (list2.get(list2.size() - 1).p >= i16 && i22 >= i16 && !z2) {
                        i24 = -fVar2.a();
                        i17 = i4;
                        z2 = true;
                        if (i24 <= i17 && z2) {
                            bVar2 = bVar;
                            i7 = i25;
                            break;
                        }
                        i26 = i13;
                        i27 = max;
                        i22++;
                        i19 = i2;
                        flexItemCount = i15;
                        i20 = i11;
                        i23 = i12;
                        arrayList = list2;
                        mode = i9;
                        i21 = i16;
                        size = i8;
                    }
                }
                i17 = i4;
                if (i24 <= i17) {
                }
                i26 = i13;
                i27 = max;
                i22++;
                i19 = i2;
                flexItemCount = i15;
                i20 = i11;
                i23 = i12;
                arrayList = list2;
                mode = i9;
                i21 = i16;
                size = i8;
            }
            i8 = size;
            i9 = mode;
            i11 = i20;
            i16 = i21;
            list2 = arrayList;
            i12 = i23;
            i15 = flexItemCount;
            i22++;
            i19 = i2;
            flexItemCount = i15;
            i20 = i11;
            i23 = i12;
            arrayList = list2;
            mode = i9;
            i21 = i16;
            size = i8;
        }
        bVar2.b = i7;
    }

    public void c(b bVar, int i2, int i3) {
        b(bVar, i2, i3, Integer.MAX_VALUE, 0, -1, null);
    }

    public void d(b bVar, int i2, int i3, int i4, int i5, @Nullable List<f> list) {
        b(bVar, i2, i3, i4, i5, -1, list);
    }

    public void e(b bVar, int i2, int i3, int i4, int i5, List<f> list) {
        b(bVar, i2, i3, i4, 0, i5, list);
    }

    public void f(b bVar, int i2, int i3) {
        b(bVar, i3, i2, Integer.MAX_VALUE, 0, -1, null);
    }

    public void g(b bVar, int i2, int i3, int i4, int i5, @Nullable List<f> list) {
        b(bVar, i3, i2, i4, i5, -1, list);
    }

    public void h(b bVar, int i2, int i3, int i4, int i5, List<f> list) {
        b(bVar, i3, i2, i4, 0, i5, list);
    }

    public void j(List<f> list, int i2) {
        int i3 = this.f10097c[i2];
        if (i3 == -1) {
            i3 = 0;
        }
        for (int size = list.size() - 1; size >= i3; size--) {
            list.remove(size);
        }
        int[] iArr = this.f10097c;
        int length = iArr.length - 1;
        if (i2 > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i2, length, -1);
        }
        long[] jArr = this.f10098d;
        int length2 = jArr.length - 1;
        if (i2 > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i2, length2, 0L);
        }
    }

    public int[] m(SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        return U(flexItemCount, l(flexItemCount), sparseIntArray);
    }

    public int[] n(View view, int i2, ViewGroup.LayoutParams layoutParams, SparseIntArray sparseIntArray) {
        int flexItemCount = this.a.getFlexItemCount();
        List<c> l2 = l(flexItemCount);
        c cVar = new c();
        if (view != null && (layoutParams instanceof FlexItem)) {
            cVar.b = ((FlexItem) layoutParams).getOrder();
        } else {
            cVar.b = 1;
        }
        if (i2 != -1 && i2 != flexItemCount) {
            if (i2 < this.a.getFlexItemCount()) {
                cVar.a = i2;
                while (i2 < flexItemCount) {
                    l2.get(i2).a++;
                    i2++;
                }
            } else {
                cVar.a = flexItemCount;
            }
        } else {
            cVar.a = flexItemCount;
        }
        l2.add(cVar);
        return U(flexItemCount + 1, l2, sparseIntArray);
    }

    public void o(int i2, int i3, int i4) {
        int i5;
        int i6;
        int flexDirection = this.a.getFlexDirection();
        if (flexDirection == 0 || flexDirection == 1) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            i5 = mode;
            i6 = size;
        } else if (flexDirection != 2 && flexDirection != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        } else {
            i5 = View.MeasureSpec.getMode(i2);
            i6 = View.MeasureSpec.getSize(i2);
        }
        List<f> flexLinesInternal = this.a.getFlexLinesInternal();
        if (i5 == 1073741824) {
            int sumOfCrossSize = this.a.getSumOfCrossSize() + i4;
            int i7 = 0;
            if (flexLinesInternal.size() == 1) {
                flexLinesInternal.get(0).f10087g = i6 - i4;
            } else if (flexLinesInternal.size() >= 2) {
                int alignContent = this.a.getAlignContent();
                if (alignContent == 1) {
                    int i8 = i6 - sumOfCrossSize;
                    f fVar = new f();
                    fVar.f10087g = i8;
                    flexLinesInternal.add(0, fVar);
                } else if (alignContent == 2) {
                    this.a.setFlexLines(k(flexLinesInternal, i6, sumOfCrossSize));
                } else if (alignContent == 3) {
                    if (sumOfCrossSize >= i6) {
                        return;
                    }
                    float size2 = (i6 - sumOfCrossSize) / (flexLinesInternal.size() - 1);
                    ArrayList arrayList = new ArrayList();
                    int size3 = flexLinesInternal.size();
                    float f2 = 0.0f;
                    while (i7 < size3) {
                        arrayList.add(flexLinesInternal.get(i7));
                        if (i7 != flexLinesInternal.size() - 1) {
                            f fVar2 = new f();
                            if (i7 == flexLinesInternal.size() - 2) {
                                fVar2.f10087g = Math.round(f2 + size2);
                                f2 = 0.0f;
                            } else {
                                fVar2.f10087g = Math.round(size2);
                            }
                            int i9 = fVar2.f10087g;
                            f2 += size2 - i9;
                            if (f2 > 1.0f) {
                                fVar2.f10087g = i9 + 1;
                                f2 -= 1.0f;
                            } else if (f2 < -1.0f) {
                                fVar2.f10087g = i9 - 1;
                                f2 += 1.0f;
                            }
                            arrayList.add(fVar2);
                        }
                        i7++;
                    }
                    this.a.setFlexLines(arrayList);
                } else if (alignContent == 4) {
                    if (sumOfCrossSize >= i6) {
                        this.a.setFlexLines(k(flexLinesInternal, i6, sumOfCrossSize));
                        return;
                    }
                    int size4 = (i6 - sumOfCrossSize) / (flexLinesInternal.size() * 2);
                    ArrayList arrayList2 = new ArrayList();
                    f fVar3 = new f();
                    fVar3.f10087g = size4;
                    for (f fVar4 : flexLinesInternal) {
                        arrayList2.add(fVar3);
                        arrayList2.add(fVar4);
                        arrayList2.add(fVar3);
                    }
                    this.a.setFlexLines(arrayList2);
                } else if (alignContent == 5 && sumOfCrossSize < i6) {
                    float size5 = (i6 - sumOfCrossSize) / flexLinesInternal.size();
                    int size6 = flexLinesInternal.size();
                    float f3 = 0.0f;
                    while (i7 < size6) {
                        f fVar5 = flexLinesInternal.get(i7);
                        float f4 = fVar5.f10087g + size5;
                        if (i7 == flexLinesInternal.size() - 1) {
                            f4 += f3;
                            f3 = 0.0f;
                        }
                        int round = Math.round(f4);
                        f3 += f4 - round;
                        if (f3 > 1.0f) {
                            round++;
                            f3 -= 1.0f;
                        } else if (f3 < -1.0f) {
                            round--;
                            f3 += 1.0f;
                        }
                        fVar5.f10087g = round;
                        i7++;
                    }
                }
            }
        }
    }

    public void p(int i2, int i3) {
        q(i2, i3, 0);
    }

    public void q(int i2, int i3, int i4) {
        int size;
        int paddingLeft;
        int paddingRight;
        r(this.a.getFlexItemCount());
        if (i4 >= this.a.getFlexItemCount()) {
            return;
        }
        int flexDirection = this.a.getFlexDirection();
        int flexDirection2 = this.a.getFlexDirection();
        if (flexDirection2 == 0 || flexDirection2 == 1) {
            int mode = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            int largestMainSize = this.a.getLargestMainSize();
            if (mode != 1073741824 && largestMainSize <= size) {
                size = largestMainSize;
            }
            paddingLeft = this.a.getPaddingLeft();
            paddingRight = this.a.getPaddingRight();
        } else if (flexDirection2 != 2 && flexDirection2 != 3) {
            throw new IllegalArgumentException("Invalid flex direction: " + flexDirection);
        } else {
            int mode2 = View.MeasureSpec.getMode(i3);
            size = View.MeasureSpec.getSize(i3);
            if (mode2 != 1073741824) {
                size = this.a.getLargestMainSize();
            }
            paddingLeft = this.a.getPaddingTop();
            paddingRight = this.a.getPaddingBottom();
        }
        int i5 = paddingLeft + paddingRight;
        int[] iArr = this.f10097c;
        int i6 = iArr != null ? iArr[i4] : 0;
        List<f> flexLinesInternal = this.a.getFlexLinesInternal();
        int size2 = flexLinesInternal.size();
        for (int i7 = i6; i7 < size2; i7++) {
            f fVar = flexLinesInternal.get(i7);
            int i8 = fVar.f10085e;
            if (i8 < size && fVar.q) {
                w(i2, i3, fVar, size, i5, false);
            } else if (i8 > size && fVar.r) {
                T(i2, i3, fVar, size, i5, false);
            }
        }
    }

    public void s(int i2) {
        int[] iArr = this.f10097c;
        if (iArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f10097c = new int[i2];
        } else if (iArr.length < i2) {
            int length = iArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f10097c = Arrays.copyOf(iArr, i2);
        }
    }

    public void t(int i2) {
        long[] jArr = this.f10098d;
        if (jArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f10098d = new long[i2];
        } else if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f10098d = Arrays.copyOf(jArr, i2);
        }
    }

    public void u(int i2) {
        long[] jArr = this.f10099e;
        if (jArr == null) {
            if (i2 < 10) {
                i2 = 10;
            }
            this.f10099e = new long[i2];
        } else if (jArr.length < i2) {
            int length = jArr.length * 2;
            if (length >= i2) {
                i2 = length;
            }
            this.f10099e = Arrays.copyOf(jArr, i2);
        }
    }

    public int x(long j2) {
        return (int) (j2 >> 32);
    }

    public int y(long j2) {
        return (int) j2;
    }
}
