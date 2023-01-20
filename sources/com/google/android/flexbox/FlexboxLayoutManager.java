package com.google.android.flexbox;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import e.j.a.a.d;
import e.j.a.a.f;
import e.j.a.a.h;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class FlexboxLayoutManager extends RecyclerView.LayoutManager implements d, RecyclerView.SmoothScroller.ScrollVectorProvider {
    private static final String A = "FlexboxLayoutManager";
    private static final Rect B = new Rect();
    private static final boolean C = false;
    public static final /* synthetic */ boolean D = false;
    private int a;
    private int b;

    /* renamed from: c */
    private int f2583c;

    /* renamed from: d */
    private int f2584d;

    /* renamed from: e */
    private int f2585e;

    /* renamed from: f */
    private boolean f2586f;

    /* renamed from: g */
    private boolean f2587g;

    /* renamed from: h */
    private List<f> f2588h;

    /* renamed from: i */
    private final h f2589i;

    /* renamed from: j */
    private RecyclerView.Recycler f2590j;

    /* renamed from: k */
    private RecyclerView.State f2591k;

    /* renamed from: l */
    private c f2592l;

    /* renamed from: m */
    private b f2593m;
    private OrientationHelper n;
    private OrientationHelper o;
    private SavedState p;
    private int q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private SparseArray<View> v;
    private final Context w;
    private View x;
    private int y;
    private h.b z;

    /* loaded from: classes.dex */
    public class b {

        /* renamed from: i */
        public static final /* synthetic */ boolean f2594i = false;
        private int a;
        private int b;

        /* renamed from: c */
        private int f2595c;

        /* renamed from: d */
        private int f2596d;

        /* renamed from: e */
        private boolean f2597e;

        /* renamed from: f */
        private boolean f2598f;

        /* renamed from: g */
        private boolean f2599g;

        private b() {
            FlexboxLayoutManager.this = r1;
            this.f2596d = 0;
        }

        public void q() {
            if (!FlexboxLayoutManager.this.j() && FlexboxLayoutManager.this.f2586f) {
                this.f2595c = this.f2597e ? FlexboxLayoutManager.this.n.getEndAfterPadding() : FlexboxLayoutManager.this.getWidth() - FlexboxLayoutManager.this.n.getStartAfterPadding();
            } else {
                this.f2595c = this.f2597e ? FlexboxLayoutManager.this.n.getEndAfterPadding() : FlexboxLayoutManager.this.n.getStartAfterPadding();
            }
        }

        public void r(View view) {
            OrientationHelper orientationHelper = FlexboxLayoutManager.this.b == 0 ? FlexboxLayoutManager.this.o : FlexboxLayoutManager.this.n;
            if (!FlexboxLayoutManager.this.j() && FlexboxLayoutManager.this.f2586f) {
                if (this.f2597e) {
                    this.f2595c = orientationHelper.getDecoratedStart(view) + orientationHelper.getTotalSpaceChange();
                } else {
                    this.f2595c = orientationHelper.getDecoratedEnd(view);
                }
            } else if (this.f2597e) {
                this.f2595c = orientationHelper.getDecoratedEnd(view) + orientationHelper.getTotalSpaceChange();
            } else {
                this.f2595c = orientationHelper.getDecoratedStart(view);
            }
            this.a = FlexboxLayoutManager.this.getPosition(view);
            this.f2599g = false;
            int[] iArr = FlexboxLayoutManager.this.f2589i.f10097c;
            int i2 = this.a;
            if (i2 == -1) {
                i2 = 0;
            }
            int i3 = iArr[i2];
            this.b = i3 != -1 ? i3 : 0;
            if (FlexboxLayoutManager.this.f2588h.size() > this.b) {
                this.a = ((f) FlexboxLayoutManager.this.f2588h.get(this.b)).o;
            }
        }

        public void s() {
            this.a = -1;
            this.b = -1;
            this.f2595c = Integer.MIN_VALUE;
            this.f2598f = false;
            this.f2599g = false;
            if (FlexboxLayoutManager.this.j()) {
                if (FlexboxLayoutManager.this.b == 0) {
                    this.f2597e = FlexboxLayoutManager.this.a == 1;
                } else {
                    this.f2597e = FlexboxLayoutManager.this.b == 2;
                }
            } else if (FlexboxLayoutManager.this.b == 0) {
                this.f2597e = FlexboxLayoutManager.this.a == 3;
            } else {
                this.f2597e = FlexboxLayoutManager.this.b == 2;
            }
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.a + ", mFlexLinePosition=" + this.b + ", mCoordinate=" + this.f2595c + ", mPerpendicularCoordinate=" + this.f2596d + ", mLayoutFromEnd=" + this.f2597e + ", mValid=" + this.f2598f + ", mAssignedFromSavedState=" + this.f2599g + '}';
        }
    }

    /* loaded from: classes.dex */
    public static class c {

        /* renamed from: k */
        private static final int f2601k = Integer.MIN_VALUE;

        /* renamed from: l */
        private static final int f2602l = -1;

        /* renamed from: m */
        private static final int f2603m = 1;
        private static final int n = 1;
        private int a;
        private boolean b;

        /* renamed from: c */
        private int f2604c;

        /* renamed from: d */
        private int f2605d;

        /* renamed from: e */
        private int f2606e;

        /* renamed from: f */
        private int f2607f;

        /* renamed from: g */
        private int f2608g;

        /* renamed from: h */
        private int f2609h;

        /* renamed from: i */
        private int f2610i;

        /* renamed from: j */
        private boolean f2611j;

        private c() {
            this.f2609h = 1;
            this.f2610i = 1;
        }

        public static /* synthetic */ int i(c cVar) {
            int i2 = cVar.f2604c;
            cVar.f2604c = i2 + 1;
            return i2;
        }

        public static /* synthetic */ int j(c cVar) {
            int i2 = cVar.f2604c;
            cVar.f2604c = i2 - 1;
            return i2;
        }

        public boolean w(RecyclerView.State state, List<f> list) {
            int i2;
            int i3 = this.f2605d;
            return i3 >= 0 && i3 < state.getItemCount() && (i2 = this.f2604c) >= 0 && i2 < list.size();
        }

        public String toString() {
            return "LayoutState{mAvailable=" + this.a + ", mFlexLinePosition=" + this.f2604c + ", mPosition=" + this.f2605d + ", mOffset=" + this.f2606e + ", mScrollingOffset=" + this.f2607f + ", mLastScrollDelta=" + this.f2608g + ", mItemDirection=" + this.f2609h + ", mLayoutDirection=" + this.f2610i + '}';
        }
    }

    public FlexboxLayoutManager(Context context) {
        this(context, 0, 1);
    }

    private View A(int i2, int i3, boolean z) {
        int i4 = i3 > i2 ? 1 : -1;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            if (K(childAt, z)) {
                return childAt;
            }
            i2 += i4;
        }
        return null;
    }

    private View B(int i2, int i3, int i4) {
        u();
        ensureLayoutState();
        int startAfterPadding = this.n.getStartAfterPadding();
        int endAfterPadding = this.n.getEndAfterPadding();
        int i5 = i3 > i2 ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i2 != i3) {
            View childAt = getChildAt(i2);
            int position = getPosition(childAt);
            if (position >= 0 && position < i4) {
                if (((RecyclerView.LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else if (this.n.getDecoratedStart(childAt) >= startAfterPadding && this.n.getDecoratedEnd(childAt) <= endAfterPadding) {
                    return childAt;
                } else {
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            i2 += i5;
        }
        return view != null ? view : view2;
    }

    private int C(View view) {
        return getDecoratedBottom(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).bottomMargin;
    }

    private int D(View view) {
        return getDecoratedLeft(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).leftMargin;
    }

    private int E(View view) {
        return getDecoratedRight(view) + ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).rightMargin;
    }

    private int F(View view) {
        return getDecoratedTop(view) - ((ViewGroup.MarginLayoutParams) ((RecyclerView.LayoutParams) view.getLayoutParams())).topMargin;
    }

    private int H(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        u();
        int i3 = 1;
        this.f2592l.f2611j = true;
        boolean z = !j() && this.f2586f;
        if (!z ? i2 <= 0 : i2 >= 0) {
            i3 = -1;
        }
        int abs = Math.abs(i2);
        Y(i3, abs);
        int v = this.f2592l.f2607f + v(recycler, state, this.f2592l);
        if (v < 0) {
            return 0;
        }
        if (z) {
            if (abs > v) {
                i2 = (-i3) * v;
            }
        } else if (abs > v) {
            i2 = i3 * v;
        }
        this.n.offsetChildren(-i2);
        this.f2592l.f2608g = i2;
        return i2;
    }

    private int I(int i2) {
        int i3;
        if (getChildCount() == 0 || i2 == 0) {
            return 0;
        }
        u();
        boolean j2 = j();
        View view = this.x;
        int width = j2 ? view.getWidth() : view.getHeight();
        int width2 = j2 ? getWidth() : getHeight();
        if (getLayoutDirection() == 1) {
            int abs = Math.abs(i2);
            if (i2 >= 0) {
                if (this.f2593m.f2596d + i2 <= 0) {
                    return i2;
                }
                i3 = this.f2593m.f2596d;
            } else {
                i3 = Math.min((width2 + this.f2593m.f2596d) - width, abs);
            }
        } else if (i2 <= 0) {
            if (this.f2593m.f2596d + i2 >= 0) {
                return i2;
            }
            i3 = this.f2593m.f2596d;
        } else {
            return Math.min((width2 - this.f2593m.f2596d) - width, i2);
        }
        return -i3;
    }

    private boolean K(View view, boolean z) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int D2 = D(view);
        int F = F(view);
        int E = E(view);
        int C2 = C(view);
        return z ? (paddingLeft <= D2 && width >= E) && (paddingTop <= F && height >= C2) : (D2 >= width || E >= paddingLeft) && (F >= height || C2 >= paddingTop);
    }

    private int L(f fVar, c cVar) {
        if (j()) {
            return M(fVar, cVar);
        }
        return N(fVar, cVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x00ce  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int M(e.j.a.a.f r22, com.google.android.flexbox.FlexboxLayoutManager.c r23) {
        /*
            Method dump skipped, instructions count: 428
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.M(e.j.a.a.f, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int N(e.j.a.a.f r26, com.google.android.flexbox.FlexboxLayoutManager.c r27) {
        /*
            Method dump skipped, instructions count: 544
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.flexbox.FlexboxLayoutManager.N(e.j.a.a.f, com.google.android.flexbox.FlexboxLayoutManager$c):int");
    }

    private void O(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.f2611j) {
            if (cVar.f2610i == -1) {
                P(recycler, cVar);
            } else {
                Q(recycler, cVar);
            }
        }
    }

    private void P(RecyclerView.Recycler recycler, c cVar) {
        if (cVar.f2607f < 0) {
            return;
        }
        this.n.getEnd();
        int unused = cVar.f2607f;
        int childCount = getChildCount();
        if (childCount == 0) {
            return;
        }
        int i2 = childCount - 1;
        int i3 = this.f2589i.f10097c[getPosition(getChildAt(i2))];
        if (i3 == -1) {
            return;
        }
        f fVar = this.f2588h.get(i3);
        int i4 = i2;
        while (true) {
            if (i4 < 0) {
                break;
            }
            View childAt = getChildAt(i4);
            if (!r(childAt, cVar.f2607f)) {
                break;
            }
            if (fVar.o == getPosition(childAt)) {
                if (i3 <= 0) {
                    childCount = i4;
                    break;
                }
                i3 += cVar.f2610i;
                fVar = this.f2588h.get(i3);
                childCount = i4;
            }
            i4--;
        }
        recycleChildren(recycler, childCount, i2);
    }

    private void Q(RecyclerView.Recycler recycler, c cVar) {
        int childCount;
        if (cVar.f2607f >= 0 && (childCount = getChildCount()) != 0) {
            int i2 = this.f2589i.f10097c[getPosition(getChildAt(0))];
            int i3 = -1;
            if (i2 == -1) {
                return;
            }
            f fVar = this.f2588h.get(i2);
            int i4 = 0;
            while (true) {
                if (i4 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i4);
                if (!s(childAt, cVar.f2607f)) {
                    break;
                }
                if (fVar.p == getPosition(childAt)) {
                    if (i2 >= this.f2588h.size() - 1) {
                        i3 = i4;
                        break;
                    }
                    i2 += cVar.f2610i;
                    fVar = this.f2588h.get(i2);
                    i3 = i4;
                }
                i4++;
            }
            recycleChildren(recycler, 0, i3);
        }
    }

    private void R() {
        int widthMode;
        if (j()) {
            widthMode = getHeightMode();
        } else {
            widthMode = getWidthMode();
        }
        this.f2592l.b = widthMode == 0 || widthMode == Integer.MIN_VALUE;
    }

    private void S() {
        int layoutDirection = getLayoutDirection();
        int i2 = this.a;
        if (i2 == 0) {
            this.f2586f = layoutDirection == 1;
            this.f2587g = this.b == 2;
        } else if (i2 == 1) {
            this.f2586f = layoutDirection != 1;
            this.f2587g = this.b == 2;
        } else if (i2 == 2) {
            boolean z = layoutDirection == 1;
            this.f2586f = z;
            if (this.b == 2) {
                this.f2586f = !z;
            }
            this.f2587g = false;
        } else if (i2 != 3) {
            this.f2586f = false;
            this.f2587g = false;
        } else {
            boolean z2 = layoutDirection == 1;
            this.f2586f = z2;
            if (this.b == 2) {
                this.f2586f = !z2;
            }
            this.f2587g = true;
        }
    }

    private boolean T(RecyclerView.State state, b bVar) {
        View w;
        int startAfterPadding;
        boolean z = false;
        if (getChildCount() == 0) {
            return false;
        }
        if (bVar.f2597e) {
            w = y(state.getItemCount());
        } else {
            w = w(state.getItemCount());
        }
        if (w != null) {
            bVar.r(w);
            if (!state.isPreLayout() && supportsPredictiveItemAnimations()) {
                if ((this.n.getDecoratedStart(w) >= this.n.getEndAfterPadding() || this.n.getDecoratedEnd(w) < this.n.getStartAfterPadding()) ? true : true) {
                    if (bVar.f2597e) {
                        startAfterPadding = this.n.getEndAfterPadding();
                    } else {
                        startAfterPadding = this.n.getStartAfterPadding();
                    }
                    bVar.f2595c = startAfterPadding;
                }
            }
            return true;
        }
        return false;
    }

    private boolean U(RecyclerView.State state, b bVar, SavedState savedState) {
        int i2;
        int decoratedStart;
        if (!state.isPreLayout() && (i2 = this.q) != -1) {
            if (i2 >= 0 && i2 < state.getItemCount()) {
                bVar.a = this.q;
                bVar.b = this.f2589i.f10097c[bVar.a];
                SavedState savedState2 = this.p;
                if (savedState2 != null && savedState2.hasValidAnchor(state.getItemCount())) {
                    bVar.f2595c = this.n.getStartAfterPadding() + savedState.mAnchorOffset;
                    bVar.f2599g = true;
                    bVar.b = -1;
                    return true;
                } else if (this.r == Integer.MIN_VALUE) {
                    View findViewByPosition = findViewByPosition(this.q);
                    if (findViewByPosition != null) {
                        if (this.n.getDecoratedMeasurement(findViewByPosition) > this.n.getTotalSpace()) {
                            bVar.q();
                            return true;
                        } else if (this.n.getDecoratedStart(findViewByPosition) - this.n.getStartAfterPadding() < 0) {
                            bVar.f2595c = this.n.getStartAfterPadding();
                            bVar.f2597e = false;
                            return true;
                        } else if (this.n.getEndAfterPadding() - this.n.getDecoratedEnd(findViewByPosition) < 0) {
                            bVar.f2595c = this.n.getEndAfterPadding();
                            bVar.f2597e = true;
                            return true;
                        } else {
                            if (bVar.f2597e) {
                                decoratedStart = this.n.getDecoratedEnd(findViewByPosition) + this.n.getTotalSpaceChange();
                            } else {
                                decoratedStart = this.n.getDecoratedStart(findViewByPosition);
                            }
                            bVar.f2595c = decoratedStart;
                        }
                    } else {
                        if (getChildCount() > 0) {
                            bVar.f2597e = this.q < getPosition(getChildAt(0));
                        }
                        bVar.q();
                    }
                    return true;
                } else {
                    if (j() || !this.f2586f) {
                        bVar.f2595c = this.n.getStartAfterPadding() + this.r;
                    } else {
                        bVar.f2595c = this.r - this.n.getEndPadding();
                    }
                    return true;
                }
            }
            this.q = -1;
            this.r = Integer.MIN_VALUE;
        }
        return false;
    }

    private void V(RecyclerView.State state, b bVar) {
        if (U(state, bVar, this.p) || T(state, bVar)) {
            return;
        }
        bVar.q();
        bVar.a = 0;
        bVar.b = 0;
    }

    private void W(int i2) {
        if (i2 >= findLastVisibleItemPosition()) {
            return;
        }
        int childCount = getChildCount();
        this.f2589i.t(childCount);
        this.f2589i.u(childCount);
        this.f2589i.s(childCount);
        if (i2 >= this.f2589i.f10097c.length) {
            return;
        }
        this.y = i2;
        View childClosestToStart = getChildClosestToStart();
        if (childClosestToStart == null) {
            return;
        }
        this.q = getPosition(childClosestToStart);
        if (!j() && this.f2586f) {
            this.r = this.n.getDecoratedEnd(childClosestToStart) + this.n.getEndPadding();
        } else {
            this.r = this.n.getDecoratedStart(childClosestToStart) - this.n.getStartAfterPadding();
        }
    }

    private void X(int i2) {
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        int width = getWidth();
        int height = getHeight();
        boolean z = true;
        if (j()) {
            int i4 = this.s;
            z = (i4 == Integer.MIN_VALUE || i4 == width) ? false : false;
            i3 = this.f2592l.b ? this.w.getResources().getDisplayMetrics().heightPixels : this.f2592l.a;
        } else {
            int i5 = this.t;
            z = (i5 == Integer.MIN_VALUE || i5 == height) ? false : false;
            if (!this.f2592l.b) {
                i3 = this.f2592l.a;
            } else {
                i3 = this.w.getResources().getDisplayMetrics().widthPixels;
            }
        }
        int i6 = i3;
        this.s = width;
        this.t = height;
        int i7 = this.y;
        if (i7 != -1 || (this.q == -1 && !z)) {
            int min = i7 != -1 ? Math.min(i7, this.f2593m.a) : this.f2593m.a;
            this.z.a();
            if (j()) {
                if (this.f2588h.size() > 0) {
                    this.f2589i.j(this.f2588h, min);
                    this.f2589i.b(this.z, makeMeasureSpec, makeMeasureSpec2, i6, min, this.f2593m.a, this.f2588h);
                } else {
                    this.f2589i.s(i2);
                    this.f2589i.d(this.z, makeMeasureSpec, makeMeasureSpec2, i6, 0, this.f2588h);
                }
            } else if (this.f2588h.size() > 0) {
                this.f2589i.j(this.f2588h, min);
                this.f2589i.b(this.z, makeMeasureSpec2, makeMeasureSpec, i6, min, this.f2593m.a, this.f2588h);
            } else {
                this.f2589i.s(i2);
                this.f2589i.g(this.z, makeMeasureSpec, makeMeasureSpec2, i6, 0, this.f2588h);
            }
            this.f2588h = this.z.a;
            this.f2589i.q(makeMeasureSpec, makeMeasureSpec2, min);
            this.f2589i.Y(min);
        } else if (this.f2593m.f2597e) {
        } else {
            this.f2588h.clear();
            this.z.a();
            if (j()) {
                this.f2589i.e(this.z, makeMeasureSpec, makeMeasureSpec2, i6, this.f2593m.a, this.f2588h);
            } else {
                this.f2589i.h(this.z, makeMeasureSpec, makeMeasureSpec2, i6, this.f2593m.a, this.f2588h);
            }
            this.f2588h = this.z.a;
            this.f2589i.p(makeMeasureSpec, makeMeasureSpec2);
            this.f2589i.X();
            b bVar = this.f2593m;
            bVar.b = this.f2589i.f10097c[bVar.a];
            this.f2592l.f2604c = this.f2593m.b;
        }
    }

    private void Y(int i2, int i3) {
        this.f2592l.f2610i = i2;
        boolean j2 = j();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getWidth(), getWidthMode());
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getHeight(), getHeightMode());
        boolean z = !j2 && this.f2586f;
        if (i2 == 1) {
            View childAt = getChildAt(getChildCount() - 1);
            this.f2592l.f2606e = this.n.getDecoratedEnd(childAt);
            int position = getPosition(childAt);
            View z2 = z(childAt, this.f2588h.get(this.f2589i.f10097c[position]));
            this.f2592l.f2609h = 1;
            c cVar = this.f2592l;
            cVar.f2605d = position + cVar.f2609h;
            if (this.f2589i.f10097c.length <= this.f2592l.f2605d) {
                this.f2592l.f2604c = -1;
            } else {
                c cVar2 = this.f2592l;
                cVar2.f2604c = this.f2589i.f10097c[cVar2.f2605d];
            }
            if (z) {
                this.f2592l.f2606e = this.n.getDecoratedStart(z2);
                this.f2592l.f2607f = (-this.n.getDecoratedStart(z2)) + this.n.getStartAfterPadding();
                c cVar3 = this.f2592l;
                cVar3.f2607f = cVar3.f2607f >= 0 ? this.f2592l.f2607f : 0;
            } else {
                this.f2592l.f2606e = this.n.getDecoratedEnd(z2);
                this.f2592l.f2607f = this.n.getDecoratedEnd(z2) - this.n.getEndAfterPadding();
            }
            if ((this.f2592l.f2604c == -1 || this.f2592l.f2604c > this.f2588h.size() - 1) && this.f2592l.f2605d <= getFlexItemCount()) {
                int i4 = i3 - this.f2592l.f2607f;
                this.z.a();
                if (i4 > 0) {
                    if (j2) {
                        this.f2589i.d(this.z, makeMeasureSpec, makeMeasureSpec2, i4, this.f2592l.f2605d, this.f2588h);
                    } else {
                        this.f2589i.g(this.z, makeMeasureSpec, makeMeasureSpec2, i4, this.f2592l.f2605d, this.f2588h);
                    }
                    this.f2589i.q(makeMeasureSpec, makeMeasureSpec2, this.f2592l.f2605d);
                    this.f2589i.Y(this.f2592l.f2605d);
                }
            }
        } else {
            View childAt2 = getChildAt(0);
            this.f2592l.f2606e = this.n.getDecoratedStart(childAt2);
            int position2 = getPosition(childAt2);
            View x = x(childAt2, this.f2588h.get(this.f2589i.f10097c[position2]));
            this.f2592l.f2609h = 1;
            int i5 = this.f2589i.f10097c[position2];
            if (i5 == -1) {
                i5 = 0;
            }
            if (i5 > 0) {
                this.f2592l.f2605d = position2 - this.f2588h.get(i5 - 1).c();
            } else {
                this.f2592l.f2605d = -1;
            }
            this.f2592l.f2604c = i5 > 0 ? i5 - 1 : 0;
            if (z) {
                this.f2592l.f2606e = this.n.getDecoratedEnd(x);
                this.f2592l.f2607f = this.n.getDecoratedEnd(x) - this.n.getEndAfterPadding();
                c cVar4 = this.f2592l;
                cVar4.f2607f = cVar4.f2607f >= 0 ? this.f2592l.f2607f : 0;
            } else {
                this.f2592l.f2606e = this.n.getDecoratedStart(x);
                this.f2592l.f2607f = (-this.n.getDecoratedStart(x)) + this.n.getStartAfterPadding();
            }
        }
        c cVar5 = this.f2592l;
        cVar5.a = i3 - cVar5.f2607f;
    }

    private void Z(b bVar, boolean z, boolean z2) {
        if (z2) {
            R();
        } else {
            this.f2592l.b = false;
        }
        if (!j() && this.f2586f) {
            this.f2592l.a = bVar.f2595c - getPaddingRight();
        } else {
            this.f2592l.a = this.n.getEndAfterPadding() - bVar.f2595c;
        }
        this.f2592l.f2605d = bVar.a;
        this.f2592l.f2609h = 1;
        this.f2592l.f2610i = 1;
        this.f2592l.f2606e = bVar.f2595c;
        this.f2592l.f2607f = Integer.MIN_VALUE;
        this.f2592l.f2604c = bVar.b;
        if (!z || this.f2588h.size() <= 1 || bVar.b < 0 || bVar.b >= this.f2588h.size() - 1) {
            return;
        }
        c.i(this.f2592l);
        this.f2592l.f2605d += this.f2588h.get(bVar.b).c();
    }

    private void a0(b bVar, boolean z, boolean z2) {
        if (z2) {
            R();
        } else {
            this.f2592l.b = false;
        }
        if (!j() && this.f2586f) {
            this.f2592l.a = (this.x.getWidth() - bVar.f2595c) - this.n.getStartAfterPadding();
        } else {
            this.f2592l.a = bVar.f2595c - this.n.getStartAfterPadding();
        }
        this.f2592l.f2605d = bVar.a;
        this.f2592l.f2609h = 1;
        this.f2592l.f2610i = -1;
        this.f2592l.f2606e = bVar.f2595c;
        this.f2592l.f2607f = Integer.MIN_VALUE;
        this.f2592l.f2604c = bVar.b;
        if (!z || bVar.b <= 0 || this.f2588h.size() <= bVar.b) {
            return;
        }
        c.j(this.f2592l);
        this.f2592l.f2605d -= this.f2588h.get(bVar.b).c();
    }

    private int computeScrollExtent(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        u();
        View w = w(itemCount);
        View y = y(itemCount);
        if (state.getItemCount() == 0 || w == null || y == null) {
            return 0;
        }
        return Math.min(this.n.getTotalSpace(), this.n.getDecoratedEnd(y) - this.n.getDecoratedStart(w));
    }

    private int computeScrollOffset(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View w = w(itemCount);
        View y = y(itemCount);
        if (state.getItemCount() != 0 && w != null && y != null) {
            int position = getPosition(w);
            int position2 = getPosition(y);
            int abs = Math.abs(this.n.getDecoratedEnd(y) - this.n.getDecoratedStart(w));
            int[] iArr = this.f2589i.f10097c;
            int i2 = iArr[position];
            if (i2 != 0 && i2 != -1) {
                return Math.round((i2 * (abs / ((iArr[position2] - i2) + 1))) + (this.n.getStartAfterPadding() - this.n.getDecoratedStart(w)));
            }
        }
        return 0;
    }

    private int computeScrollRange(RecyclerView.State state) {
        if (getChildCount() == 0) {
            return 0;
        }
        int itemCount = state.getItemCount();
        View w = w(itemCount);
        View y = y(itemCount);
        if (state.getItemCount() == 0 || w == null || y == null) {
            return 0;
        }
        int findFirstVisibleItemPosition = findFirstVisibleItemPosition();
        return (int) ((Math.abs(this.n.getDecoratedEnd(y) - this.n.getDecoratedStart(w)) / ((findLastVisibleItemPosition() - findFirstVisibleItemPosition) + 1)) * state.getItemCount());
    }

    private void ensureLayoutState() {
        if (this.f2592l == null) {
            this.f2592l = new c();
        }
    }

    private int fixLayoutEndGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i3;
        int endAfterPadding;
        if (!j() && this.f2586f) {
            int startAfterPadding = i2 - this.n.getStartAfterPadding();
            if (startAfterPadding <= 0) {
                return 0;
            }
            i3 = H(startAfterPadding, recycler, state);
        } else {
            int endAfterPadding2 = this.n.getEndAfterPadding() - i2;
            if (endAfterPadding2 <= 0) {
                return 0;
            }
            i3 = -H(-endAfterPadding2, recycler, state);
        }
        int i4 = i2 + i3;
        if (!z || (endAfterPadding = this.n.getEndAfterPadding() - i4) <= 0) {
            return i3;
        }
        this.n.offsetChildren(endAfterPadding);
        return endAfterPadding + i3;
    }

    private int fixLayoutStartGap(int i2, RecyclerView.Recycler recycler, RecyclerView.State state, boolean z) {
        int i3;
        int startAfterPadding;
        if (!j() && this.f2586f) {
            int endAfterPadding = this.n.getEndAfterPadding() - i2;
            if (endAfterPadding <= 0) {
                return 0;
            }
            i3 = H(-endAfterPadding, recycler, state);
        } else {
            int startAfterPadding2 = i2 - this.n.getStartAfterPadding();
            if (startAfterPadding2 <= 0) {
                return 0;
            }
            i3 = -H(startAfterPadding2, recycler, state);
        }
        int i4 = i2 + i3;
        if (!z || (startAfterPadding = i4 - this.n.getStartAfterPadding()) <= 0) {
            return i3;
        }
        this.n.offsetChildren(-startAfterPadding);
        return i3 - startAfterPadding;
    }

    private View getChildClosestToStart() {
        return getChildAt(0);
    }

    private static boolean isMeasurementUpToDate(int i2, int i3, int i4) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (i4 <= 0 || i2 == i4) {
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            } else if (mode != 0) {
                return mode == 1073741824 && size == i2;
            } else {
                return true;
            }
        }
        return false;
    }

    private boolean r(View view, int i2) {
        return (j() || !this.f2586f) ? this.n.getDecoratedStart(view) >= this.n.getEnd() - i2 : this.n.getDecoratedEnd(view) <= i2;
    }

    private void recycleChildren(RecyclerView.Recycler recycler, int i2, int i3) {
        while (i3 >= i2) {
            removeAndRecycleViewAt(i3, recycler);
            i3--;
        }
    }

    private boolean s(View view, int i2) {
        return (j() || !this.f2586f) ? this.n.getDecoratedEnd(view) <= i2 : this.n.getEnd() - this.n.getDecoratedStart(view) <= i2;
    }

    private boolean shouldMeasureChild(View view, int i2, int i3, RecyclerView.LayoutParams layoutParams) {
        return (!view.isLayoutRequested() && isMeasurementCacheEnabled() && isMeasurementUpToDate(view.getWidth(), i2, ((ViewGroup.MarginLayoutParams) layoutParams).width) && isMeasurementUpToDate(view.getHeight(), i3, ((ViewGroup.MarginLayoutParams) layoutParams).height)) ? false : true;
    }

    private void t() {
        this.f2588h.clear();
        this.f2593m.s();
        this.f2593m.f2596d = 0;
    }

    private void u() {
        if (this.n != null) {
            return;
        }
        if (j()) {
            if (this.b == 0) {
                this.n = OrientationHelper.createHorizontalHelper(this);
                this.o = OrientationHelper.createVerticalHelper(this);
                return;
            }
            this.n = OrientationHelper.createVerticalHelper(this);
            this.o = OrientationHelper.createHorizontalHelper(this);
        } else if (this.b == 0) {
            this.n = OrientationHelper.createVerticalHelper(this);
            this.o = OrientationHelper.createHorizontalHelper(this);
        } else {
            this.n = OrientationHelper.createHorizontalHelper(this);
            this.o = OrientationHelper.createVerticalHelper(this);
        }
    }

    private int v(RecyclerView.Recycler recycler, RecyclerView.State state, c cVar) {
        if (cVar.f2607f != Integer.MIN_VALUE) {
            if (cVar.a < 0) {
                cVar.f2607f += cVar.a;
            }
            O(recycler, cVar);
        }
        int i2 = cVar.a;
        int i3 = cVar.a;
        int i4 = 0;
        boolean j2 = j();
        while (true) {
            if ((i3 > 0 || this.f2592l.b) && cVar.w(state, this.f2588h)) {
                f fVar = this.f2588h.get(cVar.f2604c);
                cVar.f2605d = fVar.o;
                i4 += L(fVar, cVar);
                if (j2 || !this.f2586f) {
                    cVar.f2606e += fVar.a() * cVar.f2610i;
                } else {
                    cVar.f2606e -= fVar.a() * cVar.f2610i;
                }
                i3 -= fVar.a();
            }
        }
        cVar.a -= i4;
        if (cVar.f2607f != Integer.MIN_VALUE) {
            cVar.f2607f += i4;
            if (cVar.a < 0) {
                cVar.f2607f += cVar.a;
            }
            O(recycler, cVar);
        }
        return i2 - cVar.a;
    }

    private View w(int i2) {
        View B2 = B(0, getChildCount(), i2);
        if (B2 == null) {
            return null;
        }
        int i3 = this.f2589i.f10097c[getPosition(B2)];
        if (i3 == -1) {
            return null;
        }
        return x(B2, this.f2588h.get(i3));
    }

    private View x(View view, f fVar) {
        boolean j2 = j();
        int i2 = fVar.f10088h;
        for (int i3 = 1; i3 < i2; i3++) {
            View childAt = getChildAt(i3);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f2586f && !j2) {
                    if (this.n.getDecoratedEnd(view) >= this.n.getDecoratedEnd(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.n.getDecoratedStart(view) <= this.n.getDecoratedStart(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    private View y(int i2) {
        View B2 = B(getChildCount() - 1, -1, i2);
        if (B2 == null) {
            return null;
        }
        return z(B2, this.f2588h.get(this.f2589i.f10097c[getPosition(B2)]));
    }

    private View z(View view, f fVar) {
        boolean j2 = j();
        int childCount = (getChildCount() - fVar.f10088h) - 1;
        for (int childCount2 = getChildCount() - 2; childCount2 > childCount; childCount2--) {
            View childAt = getChildAt(childCount2);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (this.f2586f && !j2) {
                    if (this.n.getDecoratedStart(view) <= this.n.getDecoratedStart(childAt)) {
                    }
                    view = childAt;
                } else {
                    if (this.n.getDecoratedEnd(view) >= this.n.getDecoratedEnd(childAt)) {
                    }
                    view = childAt;
                }
            }
        }
        return view;
    }

    public int G(int i2) {
        return this.f2589i.f10097c[i2];
    }

    public boolean J() {
        return this.f2586f;
    }

    @Override // e.j.a.a.d
    public void a(View view, int i2, int i3, f fVar) {
        calculateItemDecorationsForChild(view, B);
        if (j()) {
            int leftDecorationWidth = getLeftDecorationWidth(view) + getRightDecorationWidth(view);
            fVar.f10085e += leftDecorationWidth;
            fVar.f10086f += leftDecorationWidth;
            return;
        }
        int topDecorationHeight = getTopDecorationHeight(view) + getBottomDecorationHeight(view);
        fVar.f10085e += topDecorationHeight;
        fVar.f10086f += topDecorationHeight;
    }

    @Override // e.j.a.a.d
    public int b(int i2, int i3, int i4) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), i3, i4, canScrollHorizontally());
    }

    @Override // e.j.a.a.d
    public View c(int i2) {
        View view = this.v.get(i2);
        return view != null ? view : this.f2590j.getViewForPosition(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        if (this.b == 0) {
            return j();
        }
        if (j()) {
            int width = getWidth();
            View view = this.x;
            if (width <= (view != null ? view.getWidth() : 0)) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        if (this.b == 0) {
            return !j();
        }
        if (j()) {
            return true;
        }
        int height = getHeight();
        View view = this.x;
        return height > (view != null ? view.getHeight() : 0);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean checkLayoutParams(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeHorizontalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller.ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i2) {
        if (getChildCount() == 0) {
            return null;
        }
        int i3 = i2 < getPosition(getChildAt(0)) ? -1 : 1;
        if (j()) {
            return new PointF(0.0f, i3);
        }
        return new PointF(i3, 0.0f);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollExtent(RecyclerView.State state) {
        return computeScrollExtent(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollOffset(RecyclerView.State state) {
        return computeScrollOffset(state);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int computeVerticalScrollRange(RecyclerView.State state) {
        return computeScrollRange(state);
    }

    @Override // e.j.a.a.d
    public int d(int i2, int i3, int i4) {
        return RecyclerView.LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), i3, i4, canScrollVertically());
    }

    @Override // e.j.a.a.d
    public int e(View view) {
        int leftDecorationWidth;
        int rightDecorationWidth;
        if (j()) {
            leftDecorationWidth = getTopDecorationHeight(view);
            rightDecorationWidth = getBottomDecorationHeight(view);
        } else {
            leftDecorationWidth = getLeftDecorationWidth(view);
            rightDecorationWidth = getRightDecorationWidth(view);
        }
        return leftDecorationWidth + rightDecorationWidth;
    }

    @Override // e.j.a.a.d
    public void f(f fVar) {
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View A2 = A(0, getChildCount(), true);
        if (A2 == null) {
            return -1;
        }
        return getPosition(A2);
    }

    public int findFirstVisibleItemPosition() {
        View A2 = A(0, getChildCount(), false);
        if (A2 == null) {
            return -1;
        }
        return getPosition(A2);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View A2 = A(getChildCount() - 1, -1, true);
        if (A2 == null) {
            return -1;
        }
        return getPosition(A2);
    }

    public int findLastVisibleItemPosition() {
        View A2 = A(getChildCount() - 1, -1, false);
        if (A2 == null) {
            return -1;
        }
        return getPosition(A2);
    }

    @Override // e.j.a.a.d
    public View g(int i2) {
        return c(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public RecyclerView.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // e.j.a.a.d
    public int getAlignContent() {
        return 5;
    }

    @Override // e.j.a.a.d
    public int getAlignItems() {
        return this.f2584d;
    }

    @Override // e.j.a.a.d
    public int getFlexDirection() {
        return this.a;
    }

    @Override // e.j.a.a.d
    public int getFlexItemCount() {
        return this.f2591k.getItemCount();
    }

    @Override // e.j.a.a.d
    public List<f> getFlexLines() {
        ArrayList arrayList = new ArrayList(this.f2588h.size());
        int size = this.f2588h.size();
        for (int i2 = 0; i2 < size; i2++) {
            f fVar = this.f2588h.get(i2);
            if (fVar.c() != 0) {
                arrayList.add(fVar);
            }
        }
        return arrayList;
    }

    @Override // e.j.a.a.d
    public List<f> getFlexLinesInternal() {
        return this.f2588h;
    }

    @Override // e.j.a.a.d
    public int getFlexWrap() {
        return this.b;
    }

    @Override // e.j.a.a.d
    public int getJustifyContent() {
        return this.f2583c;
    }

    @Override // e.j.a.a.d
    public int getLargestMainSize() {
        if (this.f2588h.size() == 0) {
            return 0;
        }
        int i2 = Integer.MIN_VALUE;
        int size = this.f2588h.size();
        for (int i3 = 0; i3 < size; i3++) {
            i2 = Math.max(i2, this.f2588h.get(i3).f10085e);
        }
        return i2;
    }

    @Override // e.j.a.a.d
    public int getMaxLine() {
        return this.f2585e;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.u;
    }

    @Override // e.j.a.a.d
    public int getSumOfCrossSize() {
        int size = this.f2588h.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += this.f2588h.get(i3).f10087g;
        }
        return i2;
    }

    @Override // e.j.a.a.d
    public void h(int i2, View view) {
        this.v.put(i2, view);
    }

    @Override // e.j.a.a.d
    public int i(View view, int i2, int i3) {
        int topDecorationHeight;
        int bottomDecorationHeight;
        if (j()) {
            topDecorationHeight = getLeftDecorationWidth(view);
            bottomDecorationHeight = getRightDecorationWidth(view);
        } else {
            topDecorationHeight = getTopDecorationHeight(view);
            bottomDecorationHeight = getBottomDecorationHeight(view);
        }
        return topDecorationHeight + bottomDecorationHeight;
    }

    @Override // e.j.a.a.d
    public boolean j() {
        int i2 = this.a;
        return i2 == 0 || i2 == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(RecyclerView.Adapter adapter, RecyclerView.Adapter adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAttachedToWindow(RecyclerView recyclerView) {
        super.onAttachedToWindow(recyclerView);
        this.x = (View) recyclerView.getParent();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView.Recycler recycler) {
        super.onDetachedFromWindow(recyclerView, recycler);
        if (this.u) {
            removeAndRecycleAllViews(recycler);
            recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsAdded(recyclerView, i2, i3);
        W(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i2, int i3, int i4) {
        super.onItemsMoved(recyclerView, i2, i3, i4);
        W(Math.min(i2, i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsRemoved(recyclerView, i2, i3);
        W(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3, Object obj) {
        super.onItemsUpdated(recyclerView, i2, i3, obj);
        W(i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        int i2;
        int i3;
        this.f2590j = recycler;
        this.f2591k = state;
        int itemCount = state.getItemCount();
        if (itemCount == 0 && state.isPreLayout()) {
            return;
        }
        S();
        u();
        ensureLayoutState();
        this.f2589i.t(itemCount);
        this.f2589i.u(itemCount);
        this.f2589i.s(itemCount);
        this.f2592l.f2611j = false;
        SavedState savedState = this.p;
        if (savedState != null && savedState.hasValidAnchor(itemCount)) {
            this.q = this.p.mAnchorPosition;
        }
        if (!this.f2593m.f2598f || this.q != -1 || this.p != null) {
            this.f2593m.s();
            V(state, this.f2593m);
            this.f2593m.f2598f = true;
        }
        detachAndScrapAttachedViews(recycler);
        if (this.f2593m.f2597e) {
            a0(this.f2593m, false, true);
        } else {
            Z(this.f2593m, false, true);
        }
        X(itemCount);
        if (this.f2593m.f2597e) {
            v(recycler, state, this.f2592l);
            i3 = this.f2592l.f2606e;
            Z(this.f2593m, true, false);
            v(recycler, state, this.f2592l);
            i2 = this.f2592l.f2606e;
        } else {
            v(recycler, state, this.f2592l);
            i2 = this.f2592l.f2606e;
            a0(this.f2593m, true, false);
            v(recycler, state, this.f2592l);
            i3 = this.f2592l.f2606e;
        }
        if (getChildCount() > 0) {
            if (this.f2593m.f2597e) {
                fixLayoutStartGap(i3 + fixLayoutEndGap(i2, recycler, state, true), recycler, state, false);
            } else {
                fixLayoutEndGap(i2 + fixLayoutStartGap(i3, recycler, state, true), recycler, state, false);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutCompleted(RecyclerView.State state) {
        super.onLayoutCompleted(state);
        this.p = null;
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.y = -1;
        this.f2593m.s();
        this.v.clear();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.p = (SavedState) parcelable;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.p != null) {
            return new SavedState(this.p);
        }
        SavedState savedState = new SavedState();
        if (getChildCount() <= 0) {
            savedState.invalidateAnchor();
        } else {
            View childClosestToStart = getChildClosestToStart();
            savedState.mAnchorPosition = getPosition(childClosestToStart);
            savedState.mAnchorOffset = this.n.getDecoratedStart(childClosestToStart) - this.n.getStartAfterPadding();
        }
        return savedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (j() && (this.b != 0 || !j())) {
            int I = I(i2);
            this.f2593m.f2596d += I;
            this.o.offsetChildren(-I);
            return I;
        }
        int H = H(i2, recycler, state);
        this.v.clear();
        return H;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        this.q = i2;
        this.r = Integer.MIN_VALUE;
        SavedState savedState = this.p;
        if (savedState != null) {
            savedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, RecyclerView.Recycler recycler, RecyclerView.State state) {
        if (!j() && (this.b != 0 || j())) {
            int I = I(i2);
            this.f2593m.f2596d += I;
            this.o.offsetChildren(-I);
            return I;
        }
        int H = H(i2, recycler, state);
        this.v.clear();
        return H;
    }

    @Override // e.j.a.a.d
    public void setAlignContent(int i2) {
        throw new UnsupportedOperationException("Setting the alignContent in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to use this attribute.");
    }

    @Override // e.j.a.a.d
    public void setAlignItems(int i2) {
        int i3 = this.f2584d;
        if (i3 != i2) {
            if (i3 == 4 || i2 == 4) {
                removeAllViews();
                t();
            }
            this.f2584d = i2;
            requestLayout();
        }
    }

    @Override // e.j.a.a.d
    public void setFlexDirection(int i2) {
        if (this.a != i2) {
            removeAllViews();
            this.a = i2;
            this.n = null;
            this.o = null;
            t();
            requestLayout();
        }
    }

    @Override // e.j.a.a.d
    public void setFlexLines(List<f> list) {
        this.f2588h = list;
    }

    @Override // e.j.a.a.d
    public void setFlexWrap(int i2) {
        if (i2 != 2) {
            int i3 = this.b;
            if (i3 != i2) {
                if (i3 == 0 || i2 == 0) {
                    removeAllViews();
                    t();
                }
                this.b = i2;
                this.n = null;
                this.o = null;
                requestLayout();
                return;
            }
            return;
        }
        throw new UnsupportedOperationException("wrap_reverse is not supported in FlexboxLayoutManager");
    }

    @Override // e.j.a.a.d
    public void setJustifyContent(int i2) {
        if (this.f2583c != i2) {
            this.f2583c = i2;
            requestLayout();
        }
    }

    @Override // e.j.a.a.d
    public void setMaxLine(int i2) {
        if (this.f2585e != i2) {
            this.f2585e = i2;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z) {
        this.u = z;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.State state, int i2) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i2);
        startSmoothScroll(linearSmoothScroller);
    }

    /* loaded from: classes.dex */
    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        private int mAnchorOffset;
        private int mAnchorPosition;

        /* loaded from: classes.dex */
        public static class a implements Parcelable.Creator<SavedState> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public boolean hasValidAnchor(int i2) {
            int i3 = this.mAnchorPosition;
            return i3 >= 0 && i3 < i2;
        }

        public void invalidateAnchor() {
            this.mAnchorPosition = -1;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "SavedState{mAnchorPosition=" + this.mAnchorPosition + ", mAnchorOffset=" + this.mAnchorOffset + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.mAnchorPosition);
            parcel.writeInt(this.mAnchorOffset);
        }

        public SavedState() {
        }

        private SavedState(Parcel parcel) {
            this.mAnchorPosition = parcel.readInt();
            this.mAnchorOffset = parcel.readInt();
        }

        private SavedState(SavedState savedState) {
            this.mAnchorPosition = savedState.mAnchorPosition;
            this.mAnchorOffset = savedState.mAnchorOffset;
        }
    }

    public FlexboxLayoutManager(Context context, int i2) {
        this(context, i2, 1);
    }

    public FlexboxLayoutManager(Context context, int i2, int i3) {
        this.f2585e = -1;
        this.f2588h = new ArrayList();
        this.f2589i = new h(this);
        this.f2593m = new b();
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.v = new SparseArray<>();
        this.y = -1;
        this.z = new h.b();
        setFlexDirection(i2);
        setFlexWrap(i3);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.w = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i2, int i3) {
        super.onItemsUpdated(recyclerView, i2, i3);
        W(i2);
    }

    /* loaded from: classes.dex */
    public static class LayoutParams extends RecyclerView.LayoutParams implements FlexItem {
        public static final Parcelable.Creator<LayoutParams> CREATOR = new a();
        private int mAlignSelf;
        private float mFlexBasisPercent;
        private float mFlexGrow;
        private float mFlexShrink;
        private int mMaxHeight;
        private int mMaxWidth;
        private int mMinHeight;
        private int mMinWidth;
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
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
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
            return 1;
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
            throw new UnsupportedOperationException("Setting the order in the FlexboxLayoutManager is not supported. Use FlexboxLayout if you need to reorder using the attribute.");
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

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(RecyclerView.LayoutParams layoutParams) {
            super(layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((RecyclerView.LayoutParams) layoutParams);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
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

        public LayoutParams(Parcel parcel) {
            super(-2, -2);
            this.mFlexGrow = 0.0f;
            this.mFlexShrink = 1.0f;
            this.mAlignSelf = -1;
            this.mFlexBasisPercent = -1.0f;
            this.mMaxWidth = 16777215;
            this.mMaxHeight = 16777215;
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

    public FlexboxLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.f2585e = -1;
        this.f2588h = new ArrayList();
        this.f2589i = new h(this);
        this.f2593m = new b();
        this.q = -1;
        this.r = Integer.MIN_VALUE;
        this.s = Integer.MIN_VALUE;
        this.t = Integer.MIN_VALUE;
        this.v = new SparseArray<>();
        this.y = -1;
        this.z = new h.b();
        RecyclerView.LayoutManager.Properties properties = RecyclerView.LayoutManager.getProperties(context, attributeSet, i2, i3);
        int i4 = properties.orientation;
        if (i4 != 0) {
            if (i4 == 1) {
                if (properties.reverseLayout) {
                    setFlexDirection(3);
                } else {
                    setFlexDirection(2);
                }
            }
        } else if (properties.reverseLayout) {
            setFlexDirection(1);
        } else {
            setFlexDirection(0);
        }
        setFlexWrap(1);
        setAlignItems(4);
        setAutoMeasureEnabled(true);
        this.w = context;
    }
}
