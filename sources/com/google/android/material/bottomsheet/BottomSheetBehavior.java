package com.google.android.material.bottomsheet;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import e.j.a.c.s.t;
import e.j.a.c.z.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    public static final int Y = 1;
    public static final int Z = 2;
    public static final int a0 = 3;
    public static final int b0 = 4;
    public static final int c0 = 5;
    public static final int d0 = 6;
    public static final int e0 = -1;
    public static final int f0 = 1;
    public static final int g0 = 2;
    public static final int h0 = 4;
    public static final int i0 = 8;
    public static final int j0 = -1;
    public static final int k0 = 0;
    private static final String l0 = "BottomSheetBehavior";
    private static final int m0 = 500;
    private static final float n0 = 0.5f;
    private static final float o0 = 0.1f;
    private static final int p0 = 500;
    private static final int q0 = -1;
    private static final int r0 = R.style.Widget_Design_BottomSheet_Modal;
    public float A;
    public int B;
    public float C;
    public boolean D;
    private boolean E;
    private boolean F;
    public int G;
    @Nullable
    public ViewDragHelper H;
    private boolean I;
    private int J;
    private boolean K;
    private int L;
    public int M;
    public int N;
    @Nullable
    public WeakReference<V> O;
    @Nullable
    public WeakReference<View> P;
    @NonNull
    private final ArrayList<g> Q;
    @Nullable
    private VelocityTracker R;
    public int S;
    private int T;
    public boolean U;
    @Nullable
    private Map<View, Integer> V;
    private int W;
    private final ViewDragHelper.Callback X;
    private int a;
    private boolean b;

    /* renamed from: c */
    private boolean f2789c;

    /* renamed from: d */
    private float f2790d;

    /* renamed from: e */
    private int f2791e;

    /* renamed from: f */
    private boolean f2792f;

    /* renamed from: g */
    private int f2793g;

    /* renamed from: h */
    private int f2794h;

    /* renamed from: i */
    private boolean f2795i;

    /* renamed from: j */
    private e.j.a.c.z.j f2796j;

    /* renamed from: k */
    private int f2797k;

    /* renamed from: l */
    private int f2798l;

    /* renamed from: m */
    private boolean f2799m;
    private boolean n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;
    private int s;
    private o t;
    private boolean u;
    private BottomSheetBehavior<V>.i v;
    @Nullable
    private ValueAnimator w;
    public int x;
    public int y;
    public int z;

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public boolean fitToContents;
        public boolean hideable;
        public int peekHeight;
        public boolean skipCollapsed;
        public final int state;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(@NonNull Parcel parcel) {
            this(parcel, (ClassLoader) null);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        public SavedState(Parcelable parcelable, @NonNull BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.G;
            this.peekHeight = ((BottomSheetBehavior) bottomSheetBehavior).f2791e;
            this.fitToContents = ((BottomSheetBehavior) bottomSheetBehavior).b;
            this.hideable = bottomSheetBehavior.D;
            this.skipCollapsed = ((BottomSheetBehavior) bottomSheetBehavior).E;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i2) {
            super(parcelable);
            this.state = i2;
        }
    }

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ ViewGroup.LayoutParams b;

        public a(View view, ViewGroup.LayoutParams layoutParams) {
            BottomSheetBehavior.this = r1;
            this.a = view;
            this.b = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.a.setLayoutParams(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ int b;

        public b(View view, int i2) {
            BottomSheetBehavior.this = r1;
            this.a = view;
            this.b = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.this.i0(this.a, this.b);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
            BottomSheetBehavior.this = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.this.f2796j != null) {
                BottomSheetBehavior.this.f2796j.o0(floatValue);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class d implements t.e {
        public final /* synthetic */ boolean a;

        public d(boolean z) {
            BottomSheetBehavior.this = r1;
            this.a = z;
        }

        @Override // e.j.a.c.s.t.e
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, t.f fVar) {
            BottomSheetBehavior.this.s = windowInsetsCompat.getSystemWindowInsetTop();
            boolean j2 = t.j(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.this.n) {
                BottomSheetBehavior.this.r = windowInsetsCompat.getSystemWindowInsetBottom();
                paddingBottom = fVar.f11007d + BottomSheetBehavior.this.r;
            }
            if (BottomSheetBehavior.this.o) {
                paddingLeft = (j2 ? fVar.f11006c : fVar.a) + windowInsetsCompat.getSystemWindowInsetLeft();
            }
            if (BottomSheetBehavior.this.p) {
                paddingRight = (j2 ? fVar.a : fVar.f11006c) + windowInsetsCompat.getSystemWindowInsetRight();
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.a) {
                BottomSheetBehavior.this.f2798l = windowInsetsCompat.getMandatorySystemGestureInsets().bottom;
            }
            if (BottomSheetBehavior.this.n || this.a) {
                BottomSheetBehavior.this.p0(false);
            }
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends ViewDragHelper.Callback {
        public e() {
            BottomSheetBehavior.this = r1;
        }

        private boolean a(@NonNull View view) {
            int top = view.getTop();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return top > (bottomSheetBehavior.N + bottomSheetBehavior.A()) / 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            int A = BottomSheetBehavior.this.A();
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            return MathUtils.clamp(i2, A, bottomSheetBehavior.D ? bottomSheetBehavior.N : bottomSheetBehavior.B);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NonNull View view) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            if (bottomSheetBehavior.D) {
                return bottomSheetBehavior.N;
            }
            return bottomSheetBehavior.B;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            if (i2 == 1 && BottomSheetBehavior.this.F) {
                BottomSheetBehavior.this.f0(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            BottomSheetBehavior.this.x(i3);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int i2;
            int i3 = 4;
            if (f3 < 0.0f) {
                if (BottomSheetBehavior.this.b) {
                    i2 = BottomSheetBehavior.this.y;
                } else {
                    int top = view.getTop();
                    BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
                    int i4 = bottomSheetBehavior.z;
                    if (top > i4) {
                        i2 = i4;
                        i3 = 6;
                    } else {
                        i2 = bottomSheetBehavior.A();
                    }
                }
                i3 = 3;
            } else {
                BottomSheetBehavior bottomSheetBehavior2 = BottomSheetBehavior.this;
                if (bottomSheetBehavior2.D && bottomSheetBehavior2.k0(view, f3)) {
                    if ((Math.abs(f2) >= Math.abs(f3) || f3 <= 500.0f) && !a(view)) {
                        if (BottomSheetBehavior.this.b) {
                            i2 = BottomSheetBehavior.this.y;
                        } else if (Math.abs(view.getTop() - BottomSheetBehavior.this.A()) < Math.abs(view.getTop() - BottomSheetBehavior.this.z)) {
                            i2 = BottomSheetBehavior.this.A();
                        } else {
                            i2 = BottomSheetBehavior.this.z;
                            i3 = 6;
                        }
                        i3 = 3;
                    } else {
                        i2 = BottomSheetBehavior.this.N;
                        i3 = 5;
                    }
                } else if (f3 != 0.0f && Math.abs(f2) <= Math.abs(f3)) {
                    if (BottomSheetBehavior.this.b) {
                        i2 = BottomSheetBehavior.this.B;
                    } else {
                        int top2 = view.getTop();
                        if (Math.abs(top2 - BottomSheetBehavior.this.z) < Math.abs(top2 - BottomSheetBehavior.this.B)) {
                            i2 = BottomSheetBehavior.this.z;
                            i3 = 6;
                        } else {
                            i2 = BottomSheetBehavior.this.B;
                        }
                    }
                } else {
                    int top3 = view.getTop();
                    if (BottomSheetBehavior.this.b) {
                        if (Math.abs(top3 - BottomSheetBehavior.this.y) < Math.abs(top3 - BottomSheetBehavior.this.B)) {
                            i2 = BottomSheetBehavior.this.y;
                            i3 = 3;
                        } else {
                            i2 = BottomSheetBehavior.this.B;
                        }
                    } else {
                        BottomSheetBehavior bottomSheetBehavior3 = BottomSheetBehavior.this;
                        int i5 = bottomSheetBehavior3.z;
                        if (top3 < i5) {
                            if (top3 < Math.abs(top3 - bottomSheetBehavior3.B)) {
                                i2 = BottomSheetBehavior.this.A();
                                i3 = 3;
                            } else {
                                i2 = BottomSheetBehavior.this.z;
                            }
                        } else if (Math.abs(top3 - i5) < Math.abs(top3 - BottomSheetBehavior.this.B)) {
                            i2 = BottomSheetBehavior.this.z;
                        } else {
                            i2 = BottomSheetBehavior.this.B;
                        }
                        i3 = 6;
                    }
                }
            }
            BottomSheetBehavior.this.l0(view, i3, i2, true);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NonNull View view, int i2) {
            BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.this;
            int i3 = bottomSheetBehavior.G;
            if (i3 == 1 || bottomSheetBehavior.U) {
                return false;
            }
            if (i3 == 3 && bottomSheetBehavior.S == i2) {
                WeakReference<View> weakReference = bottomSheetBehavior.P;
                View view2 = weakReference != null ? weakReference.get() : null;
                if (view2 != null && view2.canScrollVertically(-1)) {
                    return false;
                }
            }
            WeakReference<V> weakReference2 = BottomSheetBehavior.this.O;
            return weakReference2 != null && weakReference2.get() == view;
        }
    }

    /* loaded from: classes2.dex */
    public class f implements AccessibilityViewCommand {
        public final /* synthetic */ int a;

        public f(int i2) {
            BottomSheetBehavior.this = r1;
            this.a = i2;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.e0(this.a);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class g {
        public abstract void onSlide(@NonNull View view, float f2);

        public abstract void onStateChanged(@NonNull View view, int i2);
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface h {
    }

    /* loaded from: classes2.dex */
    public class i implements Runnable {
        private final View a;
        private boolean b;

        /* renamed from: c */
        public int f2802c;

        public i(View view, int i2) {
            BottomSheetBehavior.this = r1;
            this.a = view;
            this.f2802c = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewDragHelper viewDragHelper = BottomSheetBehavior.this.H;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.a, this);
            } else {
                BottomSheetBehavior.this.f0(this.f2802c);
            }
            this.b = false;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface j {
    }

    public BottomSheetBehavior() {
        this.a = 0;
        this.b = true;
        this.f2789c = false;
        this.f2797k = -1;
        this.v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new e();
    }

    private float J() {
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker == null) {
            return 0.0f;
        }
        velocityTracker.computeCurrentVelocity(1000, this.f2790d);
        return this.R.getYVelocity(this.S);
    }

    private void P(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i2) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, s(i2));
    }

    private void Q() {
        this.S = -1;
        VelocityTracker velocityTracker = this.R;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.R = null;
        }
    }

    private void R(@NonNull SavedState savedState) {
        int i2 = this.a;
        if (i2 == 0) {
            return;
        }
        if (i2 == -1 || (i2 & 1) == 1) {
            this.f2791e = savedState.peekHeight;
        }
        if (i2 == -1 || (i2 & 2) == 2) {
            this.b = savedState.fitToContents;
        }
        if (i2 == -1 || (i2 & 4) == 4) {
            this.D = savedState.hideable;
        }
        if (i2 == -1 || (i2 & 8) == 8) {
            this.E = savedState.skipCollapsed;
        }
    }

    private void h0(@NonNull View view) {
        boolean z = (Build.VERSION.SDK_INT < 29 || M() || this.f2792f) ? false : true;
        if (this.n || this.o || this.p || z) {
            t.d(view, new d(z));
        }
    }

    private void j0(int i2) {
        V v = this.O.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new b(v, i2));
        } else {
            i0(v, i2);
        }
    }

    private void m0() {
        V v;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 524288);
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        int i2 = this.W;
        if (i2 != -1) {
            ViewCompat.removeAccessibilityAction(v, i2);
        }
        if (!this.b && this.G != 6) {
            this.W = n(v, R.string.bottomsheet_action_expand_halfway, 6);
        }
        if (this.D && this.G != 5) {
            P(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        int i3 = this.G;
        if (i3 == 3) {
            P(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, this.b ? 4 : 6);
        } else if (i3 == 4) {
            P(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, this.b ? 3 : 6);
        } else if (i3 != 6) {
        } else {
            P(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_COLLAPSE, 4);
            P(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private int n(V v, @StringRes int i2, int i3) {
        return ViewCompat.addAccessibilityAction(v, v.getResources().getString(i2), s(i3));
    }

    private void n0(int i2) {
        ValueAnimator valueAnimator;
        if (i2 == 2) {
            return;
        }
        boolean z = i2 == 3;
        if (this.u != z) {
            this.u = z;
            if (this.f2796j == null || (valueAnimator = this.w) == null) {
                return;
            }
            if (valueAnimator.isRunning()) {
                this.w.reverse();
                return;
            }
            float f2 = z ? 0.0f : 1.0f;
            this.w.setFloatValues(1.0f - f2, f2);
            this.w.start();
        }
    }

    private void o0(boolean z) {
        Map<View, Integer> map;
        int i2 = Build.VERSION.SDK_INT;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null) {
            return;
        }
        ViewParent parent = weakReference.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (i2 >= 16 && z) {
                if (this.V != null) {
                    return;
                }
                this.V = new HashMap(childCount);
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = coordinatorLayout.getChildAt(i3);
                if (childAt != this.O.get()) {
                    if (z) {
                        if (i2 >= 16) {
                            this.V.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        if (this.f2789c) {
                            ViewCompat.setImportantForAccessibility(childAt, 4);
                        }
                    } else if (this.f2789c && (map = this.V) != null && map.containsKey(childAt)) {
                        ViewCompat.setImportantForAccessibility(childAt, this.V.get(childAt).intValue());
                    }
                }
            }
            if (!z) {
                this.V = null;
            } else if (this.f2789c) {
                this.O.get().sendAccessibilityEvent(8);
            }
        }
    }

    private void p() {
        int r = r();
        if (this.b) {
            this.B = Math.max(this.N - r, this.y);
        } else {
            this.B = this.N - r;
        }
    }

    public void p0(boolean z) {
        V v;
        if (this.O != null) {
            p();
            if (this.G != 4 || (v = this.O.get()) == null) {
                return;
            }
            if (z) {
                j0(this.G);
            } else {
                v.requestLayout();
            }
        }
    }

    private void q() {
        this.z = (int) (this.N * (1.0f - this.A));
    }

    private int r() {
        int i2;
        if (this.f2792f) {
            return Math.min(Math.max(this.f2793g, this.N - ((this.M * 9) / 16)), this.L) + this.r;
        }
        if (!this.f2799m && !this.n && (i2 = this.f2798l) > 0) {
            return Math.max(this.f2791e, i2 + this.f2794h);
        }
        return this.f2791e + this.r;
    }

    private AccessibilityViewCommand s(int i2) {
        return new f(i2);
    }

    private void t(@NonNull Context context, AttributeSet attributeSet, boolean z) {
        u(context, attributeSet, z, null);
    }

    private void u(@NonNull Context context, AttributeSet attributeSet, boolean z, @Nullable ColorStateList colorStateList) {
        if (this.f2795i) {
            this.t = o.e(context, attributeSet, R.attr.bottomSheetStyle, r0).m();
            e.j.a.c.z.j jVar = new e.j.a.c.z.j(this.t);
            this.f2796j = jVar;
            jVar.Y(context);
            if (z && colorStateList != null) {
                this.f2796j.n0(colorStateList);
                return;
            }
            TypedValue typedValue = new TypedValue();
            context.getTheme().resolveAttribute(16842801, typedValue, true);
            this.f2796j.setTint(typedValue.data);
        }
    }

    private void v() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.w = ofFloat;
        ofFloat.setDuration(500L);
        this.w.addUpdateListener(new c());
    }

    @NonNull
    public static <V extends View> BottomSheetBehavior<V> z(@NonNull V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
            CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
            if (behavior instanceof BottomSheetBehavior) {
                return (BottomSheetBehavior) behavior;
            }
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
    }

    public int A() {
        if (this.b) {
            return this.y;
        }
        return Math.max(this.x, this.q ? 0 : this.s);
    }

    @FloatRange(from = 0.0d, to = 1.0d)
    public float B() {
        return this.A;
    }

    public e.j.a.c.z.j C() {
        return this.f2796j;
    }

    @Px
    public int D() {
        return this.f2797k;
    }

    public int E() {
        if (this.f2792f) {
            return -1;
        }
        return this.f2791e;
    }

    @VisibleForTesting
    public int F() {
        return this.f2793g;
    }

    public int G() {
        return this.a;
    }

    public boolean H() {
        return this.E;
    }

    public int I() {
        return this.G;
    }

    public boolean K() {
        return this.F;
    }

    public boolean L() {
        return this.b;
    }

    public boolean M() {
        return this.f2799m;
    }

    public boolean N() {
        return this.D;
    }

    public void O(@NonNull g gVar) {
        this.Q.remove(gVar);
    }

    @Deprecated
    public void S(g gVar) {
        Log.w(l0, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.Q.clear();
        if (gVar != null) {
            this.Q.add(gVar);
        }
    }

    public void T(boolean z) {
        this.F = z;
    }

    public void U(int i2) {
        if (i2 >= 0) {
            this.x = i2;
            return;
        }
        throw new IllegalArgumentException("offset must be greater than or equal to 0");
    }

    public void V(boolean z) {
        if (this.b == z) {
            return;
        }
        this.b = z;
        if (this.O != null) {
            p();
        }
        f0((this.b && this.G == 6) ? 3 : this.G);
        m0();
    }

    public void W(boolean z) {
        this.f2799m = z;
    }

    public void X(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (f2 > 0.0f && f2 < 1.0f) {
            this.A = f2;
            if (this.O != null) {
                q();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
    }

    public void Y(boolean z) {
        if (this.D != z) {
            this.D = z;
            if (!z && this.G == 5) {
                e0(4);
            }
            m0();
        }
    }

    public void Z(@Px int i2) {
        this.f2797k = i2;
    }

    public void a0(int i2) {
        b0(i2, false);
    }

    public final void b0(int i2, boolean z) {
        boolean z2 = true;
        if (i2 == -1) {
            if (!this.f2792f) {
                this.f2792f = true;
            }
            z2 = false;
        } else {
            if (this.f2792f || this.f2791e != i2) {
                this.f2792f = false;
                this.f2791e = Math.max(0, i2);
            }
            z2 = false;
        }
        if (z2) {
            p0(z);
        }
    }

    public void c0(int i2) {
        this.a = i2;
    }

    public void d0(boolean z) {
        this.E = z;
    }

    public void e0(int i2) {
        if (i2 == this.G) {
            return;
        }
        if (this.O == null) {
            if (i2 == 4 || i2 == 3 || i2 == 6 || (this.D && i2 == 5)) {
                this.G = i2;
                return;
            }
            return;
        }
        j0(i2);
    }

    public void f0(int i2) {
        V v;
        if (this.G == i2) {
            return;
        }
        this.G = i2;
        WeakReference<V> weakReference = this.O;
        if (weakReference == null || (v = weakReference.get()) == null) {
            return;
        }
        if (i2 == 3) {
            o0(true);
        } else if (i2 == 6 || i2 == 5 || i2 == 4) {
            o0(false);
        }
        n0(i2);
        for (int i3 = 0; i3 < this.Q.size(); i3++) {
            this.Q.get(i3).onStateChanged(v, i2);
        }
        m0();
    }

    public void g0(boolean z) {
        this.f2789c = z;
    }

    public void i0(@NonNull View view, int i2) {
        int i3;
        int i4;
        if (i2 == 4) {
            i3 = this.B;
        } else if (i2 == 6) {
            int i5 = this.z;
            if (!this.b || i5 > (i4 = this.y)) {
                i3 = i5;
            } else {
                i3 = i4;
                i2 = 3;
            }
        } else if (i2 == 3) {
            i3 = A();
        } else if (this.D && i2 == 5) {
            i3 = this.N;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i2);
        }
        l0(view, i2, i3, false);
    }

    public boolean k0(@NonNull View view, float f2) {
        if (this.E) {
            return true;
        }
        if (view.getTop() < this.B) {
            return false;
        }
        return Math.abs((((float) view.getTop()) + (f2 * 0.1f)) - ((float) this.B)) / ((float) r()) > 0.5f;
    }

    public void l0(View view, int i2, int i3, boolean z) {
        ViewDragHelper viewDragHelper = this.H;
        if (viewDragHelper != null && (!z ? !viewDragHelper.smoothSlideViewTo(view, view.getLeft(), i3) : !viewDragHelper.settleCapturedViewAt(view.getLeft(), i3))) {
            f0(2);
            n0(i2);
            if (this.v == null) {
                this.v = new i(view, i2);
            }
            if (!((i) this.v).b) {
                BottomSheetBehavior<V>.i iVar = this.v;
                iVar.f2802c = i2;
                ViewCompat.postOnAnimation(view, iVar);
                ((i) this.v).b = true;
                return;
            }
            this.v.f2802c = i2;
            return;
        }
        f0(i2);
    }

    public void o(@NonNull g gVar) {
        if (this.Q.contains(gVar)) {
            return;
        }
        this.Q.add(gVar);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.O = null;
        this.H = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper;
        if (v.isShown() && this.F) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                Q();
            }
            if (this.R == null) {
                this.R = VelocityTracker.obtain();
            }
            this.R.addMovement(motionEvent);
            if (actionMasked == 0) {
                int x = (int) motionEvent.getX();
                this.T = (int) motionEvent.getY();
                if (this.G != 2) {
                    WeakReference<View> weakReference = this.P;
                    View view = weakReference != null ? weakReference.get() : null;
                    if (view != null && coordinatorLayout.isPointInChildBounds(view, x, this.T)) {
                        this.S = motionEvent.getPointerId(motionEvent.getActionIndex());
                        this.U = true;
                    }
                }
                this.I = this.S == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.T);
            } else if (actionMasked == 1 || actionMasked == 3) {
                this.U = false;
                this.S = -1;
                if (this.I) {
                    this.I = false;
                    return false;
                }
            }
            if (this.I || (viewDragHelper = this.H) == null || !viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
                WeakReference<View> weakReference2 = this.P;
                View view2 = weakReference2 != null ? weakReference2.get() : null;
                return (actionMasked != 2 || view2 == null || this.I || this.G == 1 || coordinatorLayout.isPointInChildBounds(view2, (int) motionEvent.getX(), (int) motionEvent.getY()) || this.H == null || Math.abs(((float) this.T) - motionEvent.getY()) <= ((float) this.H.getTouchSlop())) ? false : true;
            }
            return true;
        }
        this.I = true;
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        e.j.a.c.z.j jVar;
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        if (this.O == null) {
            this.f2793g = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            h0(v);
            this.O = new WeakReference<>(v);
            if (this.f2795i && (jVar = this.f2796j) != null) {
                ViewCompat.setBackground(v, jVar);
            }
            e.j.a.c.z.j jVar2 = this.f2796j;
            if (jVar2 != null) {
                float f2 = this.C;
                if (f2 == -1.0f) {
                    f2 = ViewCompat.getElevation(v);
                }
                jVar2.m0(f2);
                boolean z = this.G == 3;
                this.u = z;
                this.f2796j.o0(z ? 0.0f : 1.0f);
            }
            m0();
            if (ViewCompat.getImportantForAccessibility(v) == 0) {
                ViewCompat.setImportantForAccessibility(v, 1);
            }
            int measuredWidth = v.getMeasuredWidth();
            int i3 = this.f2797k;
            if (measuredWidth > i3 && i3 != -1) {
                ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
                layoutParams.width = this.f2797k;
                v.post(new a(v, layoutParams));
            }
        }
        if (this.H == null) {
            this.H = ViewDragHelper.create(coordinatorLayout, this.X);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i2);
        this.M = coordinatorLayout.getWidth();
        this.N = coordinatorLayout.getHeight();
        int height = v.getHeight();
        this.L = height;
        int i4 = this.N;
        int i5 = i4 - height;
        int i6 = this.s;
        if (i5 < i6) {
            if (this.q) {
                this.L = i4;
            } else {
                this.L = i4 - i6;
            }
        }
        this.y = Math.max(0, i4 - this.L);
        q();
        p();
        int i7 = this.G;
        if (i7 == 3) {
            ViewCompat.offsetTopAndBottom(v, A());
        } else if (i7 == 6) {
            ViewCompat.offsetTopAndBottom(v, this.z);
        } else if (this.D && i7 == 5) {
            ViewCompat.offsetTopAndBottom(v, this.N);
        } else if (i7 == 4) {
            ViewCompat.offsetTopAndBottom(v, this.B);
        } else if (i7 == 1 || i7 == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        this.P = new WeakReference<>(y(v));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, float f2, float f3) {
        WeakReference<View> weakReference = this.P;
        if (weakReference == null || view != weakReference.get()) {
            return false;
        }
        return this.G != 3 || super.onNestedPreFling(coordinatorLayout, v, view, f2, f3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, @NonNull int[] iArr, int i4) {
        if (i4 == 1) {
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (view != (weakReference != null ? weakReference.get() : null)) {
            return;
        }
        int top = v.getTop();
        int i5 = top - i3;
        if (i3 > 0) {
            if (i5 < A()) {
                iArr[1] = top - A();
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                f0(3);
            } else if (!this.F) {
                return;
            } else {
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v, -i3);
                f0(1);
            }
        } else if (i3 < 0 && !view.canScrollVertically(-1)) {
            int i6 = this.B;
            if (i5 > i6 && !this.D) {
                iArr[1] = top - i6;
                ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                f0(4);
            } else if (!this.F) {
                return;
            } else {
                iArr[1] = i3;
                ViewCompat.offsetTopAndBottom(v, -i3);
                f0(1);
            }
        }
        x(v.getTop());
        this.J = i3;
        this.K = true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2, int i3, int i4, int i5, int i6, @NonNull int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        R(savedState);
        int i2 = savedState.state;
        if (i2 != 1 && i2 != 2) {
            this.G = i2;
        } else {
            this.G = 4;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @NonNull
    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, @NonNull View view2, int i2, int i3) {
        this.J = 0;
        this.K = false;
        return (i2 & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull View view, int i2) {
        int i3;
        int i4 = 3;
        if (v.getTop() == A()) {
            f0(3);
            return;
        }
        WeakReference<View> weakReference = this.P;
        if (weakReference != null && view == weakReference.get() && this.K) {
            if (this.J > 0) {
                if (this.b) {
                    i3 = this.y;
                } else {
                    int top = v.getTop();
                    int i5 = this.z;
                    if (top > i5) {
                        i3 = i5;
                        i4 = 6;
                    } else {
                        i3 = A();
                    }
                }
            } else if (this.D && k0(v, J())) {
                i3 = this.N;
                i4 = 5;
            } else if (this.J == 0) {
                int top2 = v.getTop();
                if (this.b) {
                    if (Math.abs(top2 - this.y) < Math.abs(top2 - this.B)) {
                        i3 = this.y;
                    } else {
                        i3 = this.B;
                        i4 = 4;
                    }
                } else {
                    int i6 = this.z;
                    if (top2 < i6) {
                        if (top2 < Math.abs(top2 - this.B)) {
                            i3 = A();
                        } else {
                            i3 = this.z;
                        }
                    } else if (Math.abs(top2 - i6) < Math.abs(top2 - this.B)) {
                        i3 = this.z;
                    } else {
                        i3 = this.B;
                        i4 = 4;
                    }
                    i4 = 6;
                }
            } else {
                if (this.b) {
                    i3 = this.B;
                } else {
                    int top3 = v.getTop();
                    if (Math.abs(top3 - this.z) < Math.abs(top3 - this.B)) {
                        i3 = this.z;
                        i4 = 6;
                    } else {
                        i3 = this.B;
                    }
                }
                i4 = 4;
            }
            l0(v, i4, i3, false);
            this.K = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        if (v.isShown()) {
            int actionMasked = motionEvent.getActionMasked();
            if (this.G == 1 && actionMasked == 0) {
                return true;
            }
            ViewDragHelper viewDragHelper = this.H;
            if (viewDragHelper != null) {
                viewDragHelper.processTouchEvent(motionEvent);
            }
            if (actionMasked == 0) {
                Q();
            }
            if (this.R == null) {
                this.R = VelocityTracker.obtain();
            }
            this.R.addMovement(motionEvent);
            if (this.H != null && actionMasked == 2 && !this.I && Math.abs(this.T - motionEvent.getY()) > this.H.getTouchSlop()) {
                this.H.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
            }
            return !this.I;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @VisibleForTesting
    public void w() {
        this.w = null;
    }

    public void x(int i2) {
        float f2;
        float f3;
        V v = this.O.get();
        if (v == null || this.Q.isEmpty()) {
            return;
        }
        int i3 = this.B;
        if (i2 <= i3 && i3 != A()) {
            int i4 = this.B;
            f2 = i4 - i2;
            f3 = i4 - A();
        } else {
            int i5 = this.B;
            f2 = i5 - i2;
            f3 = this.N - i5;
        }
        float f4 = f2 / f3;
        for (int i6 = 0; i6 < this.Q.size(); i6++) {
            this.Q.get(i6).onSlide(v, f4);
        }
    }

    @Nullable
    @VisibleForTesting
    public View y(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View y = y(viewGroup.getChildAt(i2));
                if (y != null) {
                    return y;
                }
            }
            return null;
        }
        return null;
    }

    public BottomSheetBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        this.a = 0;
        this.b = true;
        this.f2789c = false;
        this.f2797k = -1;
        this.v = null;
        this.A = 0.5f;
        this.C = -1.0f;
        this.F = true;
        this.G = 4;
        this.Q = new ArrayList<>();
        this.W = -1;
        this.X = new e();
        this.f2794h = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        this.f2795i = obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance);
        int i3 = R.styleable.BottomSheetBehavior_Layout_backgroundTint;
        boolean hasValue = obtainStyledAttributes.hasValue(i3);
        if (hasValue) {
            u(context, attributeSet, hasValue, e.j.a.c.w.c.a(context, obtainStyledAttributes, i3));
        } else {
            t(context, attributeSet, hasValue);
        }
        v();
        if (Build.VERSION.SDK_INT >= 21) {
            this.C = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        }
        int i4 = R.styleable.BottomSheetBehavior_Layout_android_maxWidth;
        if (obtainStyledAttributes.hasValue(i4)) {
            Z(obtainStyledAttributes.getDimensionPixelSize(i4, -1));
        }
        int i5 = R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight;
        TypedValue peekValue = obtainStyledAttributes.peekValue(i5);
        if (peekValue != null && (i2 = peekValue.data) == -1) {
            a0(i2);
        } else {
            a0(obtainStyledAttributes.getDimensionPixelSize(i5, -1));
        }
        Y(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        W(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        V(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        d0(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        T(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        c0(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        X(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        int i6 = R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset;
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(i6);
        if (peekValue2 != null && peekValue2.type == 16) {
            U(peekValue2.data);
        } else {
            U(obtainStyledAttributes.getDimensionPixelOffset(i6, 0));
        }
        this.n = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.o = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.p = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.q = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        obtainStyledAttributes.recycle();
        this.f2790d = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }
}
