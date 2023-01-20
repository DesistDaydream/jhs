package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.widget.ViewDragHelper;

/* loaded from: classes2.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* renamed from: k  reason: collision with root package name */
    public static final int f2754k = 0;

    /* renamed from: l  reason: collision with root package name */
    public static final int f2755l = 1;

    /* renamed from: m  reason: collision with root package name */
    public static final int f2756m = 2;
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    private static final float q = 0.5f;
    private static final float r = 0.0f;
    private static final float s = 0.5f;
    public ViewDragHelper a;
    public c b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2757c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2759e;

    /* renamed from: d  reason: collision with root package name */
    private float f2758d = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public int f2760f = 2;

    /* renamed from: g  reason: collision with root package name */
    public float f2761g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    public float f2762h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    public float f2763i = 0.5f;

    /* renamed from: j  reason: collision with root package name */
    private final ViewDragHelper.Callback f2764j = new a();

    /* loaded from: classes2.dex */
    public class a extends ViewDragHelper.Callback {

        /* renamed from: d  reason: collision with root package name */
        private static final int f2765d = -1;
        private int a;
        private int b = -1;

        public a() {
        }

        private boolean a(@NonNull View view, float f2) {
            int i2 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            if (i2 == 0) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f2761g);
            }
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i3 = SwipeDismissBehavior.this.f2760f;
            if (i3 == 2) {
                return true;
            }
            if (i3 == 0) {
                if (z) {
                    if (f2 >= 0.0f) {
                        return false;
                    }
                } else if (i2 <= 0) {
                    return false;
                }
                return true;
            } else if (i3 == 1) {
                if (z) {
                    if (i2 <= 0) {
                        return false;
                    }
                } else if (f2 >= 0.0f) {
                    return false;
                }
                return true;
            } else {
                return false;
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(@NonNull View view, int i2, int i3) {
            int width;
            int width2;
            int width3;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            int i4 = SwipeDismissBehavior.this.f2760f;
            if (i4 == 0) {
                if (z) {
                    width = this.a - view.getWidth();
                    width2 = this.a;
                } else {
                    width = this.a;
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i4 != 1) {
                width = this.a - view.getWidth();
                width2 = view.getWidth() + this.a;
            } else if (z) {
                width = this.a;
                width3 = view.getWidth();
                width2 = width3 + width;
            } else {
                width = this.a - view.getWidth();
                width2 = this.a;
            }
            return SwipeDismissBehavior.c(width, i2, width2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NonNull View view, int i2, int i3) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(@NonNull View view) {
            return view.getWidth();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewCaptured(@NonNull View view, int i2) {
            this.b = i2;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i2) {
            c cVar = SwipeDismissBehavior.this.b;
            if (cVar != null) {
                cVar.b(i2);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NonNull View view, int i2, int i3, int i4, int i5) {
            float width = this.a + (view.getWidth() * SwipeDismissBehavior.this.f2762h);
            float width2 = this.a + (view.getWidth() * SwipeDismissBehavior.this.f2763i);
            float f2 = i2;
            if (f2 <= width) {
                view.setAlpha(1.0f);
            } else if (f2 >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.b(0.0f, 1.0f - SwipeDismissBehavior.e(width, width2, f2), 1.0f));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NonNull View view, float f2, float f3) {
            int i2;
            boolean z;
            c cVar;
            this.b = -1;
            int width = view.getWidth();
            if (a(view, f2)) {
                int left = view.getLeft();
                int i3 = this.a;
                i2 = left < i3 ? i3 - width : i3 + width;
                z = true;
            } else {
                i2 = this.a;
                z = false;
            }
            if (SwipeDismissBehavior.this.a.settleCapturedViewAt(i2, view.getTop())) {
                ViewCompat.postOnAnimation(view, new d(view, z));
            } else if (!z || (cVar = SwipeDismissBehavior.this.b) == null) {
            } else {
                cVar.a(view);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i2) {
            int i3 = this.b;
            return (i3 == -1 || i3 == i2) && SwipeDismissBehavior.this.a(view);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements AccessibilityViewCommand {
        public b() {
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand.CommandArguments commandArguments) {
            boolean z = false;
            if (SwipeDismissBehavior.this.a(view)) {
                boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
                int i2 = SwipeDismissBehavior.this.f2760f;
                if ((i2 == 0 && z2) || (i2 == 1 && !z2)) {
                    z = true;
                }
                int width = view.getWidth();
                if (z) {
                    width = -width;
                }
                ViewCompat.offsetLeftAndRight(view, width);
                view.setAlpha(0.0f);
                c cVar = SwipeDismissBehavior.this.b;
                if (cVar != null) {
                    cVar.a(view);
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(View view);

        void b(int i2);
    }

    /* loaded from: classes2.dex */
    public class d implements Runnable {
        private final View a;
        private final boolean b;

        public d(View view, boolean z) {
            this.a = view;
            this.b = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            c cVar;
            ViewDragHelper viewDragHelper = SwipeDismissBehavior.this.a;
            if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.a, this);
            } else if (!this.b || (cVar = SwipeDismissBehavior.this.b) == null) {
            } else {
                cVar.a(this.a);
            }
        }
    }

    public static float b(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    public static int c(int i2, int i3, int i4) {
        return Math.min(Math.max(i2, i3), i4);
    }

    private void d(ViewGroup viewGroup) {
        ViewDragHelper create;
        if (this.a == null) {
            if (this.f2759e) {
                create = ViewDragHelper.create(viewGroup, this.f2758d, this.f2764j);
            } else {
                create = ViewDragHelper.create(viewGroup, this.f2764j);
            }
            this.a = create;
        }
    }

    public static float e(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    private void n(View view) {
        ViewCompat.removeAccessibilityAction(view, 1048576);
        if (a(view)) {
            ViewCompat.replaceAccessibilityAction(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, null, new b());
        }
    }

    public boolean a(@NonNull View view) {
        return true;
    }

    public int f() {
        ViewDragHelper viewDragHelper = this.a;
        if (viewDragHelper != null) {
            return viewDragHelper.getViewDragState();
        }
        return 0;
    }

    @Nullable
    @VisibleForTesting
    public c g() {
        return this.b;
    }

    public void h(float f2) {
        this.f2761g = b(0.0f, f2, 1.0f);
    }

    public void i(float f2) {
        this.f2763i = b(0.0f, f2, 1.0f);
    }

    public void j(@Nullable c cVar) {
        this.b = cVar;
    }

    public void k(float f2) {
        this.f2758d = f2;
        this.f2759e = true;
    }

    public void l(float f2) {
        this.f2762h = b(0.0f, f2, 1.0f);
    }

    public void m(int i2) {
        this.f2760f = i2;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        boolean z = this.f2757c;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            z = coordinatorLayout.isPointInChildBounds(v, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.f2757c = z;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.f2757c = false;
        }
        if (z) {
            d(coordinatorLayout);
            return this.a.shouldInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, int i2) {
        boolean onLayoutChild = super.onLayoutChild(coordinatorLayout, v, i2);
        if (ViewCompat.getImportantForAccessibility(v) == 0) {
            ViewCompat.setImportantForAccessibility(v, 1);
            n(v);
        }
        return onLayoutChild;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        ViewDragHelper viewDragHelper = this.a;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(motionEvent);
            return true;
        }
        return false;
    }
}
