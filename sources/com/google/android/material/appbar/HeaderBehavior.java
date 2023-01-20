package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* renamed from: k */
    private static final int f2720k = -1;
    @Nullable

    /* renamed from: d */
    private Runnable f2721d;

    /* renamed from: e */
    public OverScroller f2722e;

    /* renamed from: f */
    private boolean f2723f;

    /* renamed from: g */
    private int f2724g;

    /* renamed from: h */
    private int f2725h;

    /* renamed from: i */
    private int f2726i;
    @Nullable

    /* renamed from: j */
    private VelocityTracker f2727j;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        private final CoordinatorLayout a;
        private final View b;

        public a(CoordinatorLayout coordinatorLayout, V v) {
            HeaderBehavior.this = r1;
            this.a = coordinatorLayout;
            this.b = v;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.b == null || (overScroller = HeaderBehavior.this.f2722e) == null) {
                return;
            }
            if (overScroller.computeScrollOffset()) {
                HeaderBehavior headerBehavior = HeaderBehavior.this;
                headerBehavior.r(this.a, this.b, headerBehavior.f2722e.getCurrY());
                ViewCompat.postOnAnimation(this.b, this);
                return;
            }
            HeaderBehavior.this.p(this.a, this.b);
        }
    }

    public HeaderBehavior() {
        this.f2724g = -1;
        this.f2726i = -1;
    }

    private void k() {
        if (this.f2727j == null) {
            this.f2727j = VelocityTracker.obtain();
        }
    }

    public boolean j(V v) {
        return false;
    }

    public final boolean l(CoordinatorLayout coordinatorLayout, @NonNull V v, int i2, int i3, float f2) {
        Runnable runnable = this.f2721d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f2721d = null;
        }
        if (this.f2722e == null) {
            this.f2722e = new OverScroller(v.getContext());
        }
        this.f2722e.fling(0, b(), 0, Math.round(f2), 0, 0, i2, i3);
        if (this.f2722e.computeScrollOffset()) {
            a aVar = new a(coordinatorLayout, v);
            this.f2721d = aVar;
            ViewCompat.postOnAnimation(v, aVar);
            return true;
        }
        p(coordinatorLayout, v);
        return false;
    }

    public int m(@NonNull V v) {
        return -v.getHeight();
    }

    public int n(@NonNull V v) {
        return v.getHeight();
    }

    public int o() {
        return b();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(@NonNull CoordinatorLayout coordinatorLayout, @NonNull V v, @NonNull MotionEvent motionEvent) {
        int findPointerIndex;
        if (this.f2726i < 0) {
            this.f2726i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getActionMasked() == 2 && this.f2723f) {
            int i2 = this.f2724g;
            if (i2 == -1 || (findPointerIndex = motionEvent.findPointerIndex(i2)) == -1) {
                return false;
            }
            int y = (int) motionEvent.getY(findPointerIndex);
            if (Math.abs(y - this.f2725h) > this.f2726i) {
                this.f2725h = y;
                return true;
            }
        }
        if (motionEvent.getActionMasked() == 0) {
            this.f2724g = -1;
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            boolean z = j(v) && coordinatorLayout.isPointInChildBounds(v, x, y2);
            this.f2723f = z;
            if (z) {
                this.f2725h = y2;
                this.f2724g = motionEvent.getPointerId(0);
                k();
                OverScroller overScroller = this.f2722e;
                if (overScroller != null && !overScroller.isFinished()) {
                    this.f2722e.abortAnimation();
                    return true;
                }
            }
        }
        VelocityTracker velocityTracker = this.f2727j;
        if (velocityTracker != null) {
            velocityTracker.addMovement(motionEvent);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x008c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull androidx.coordinatorlayout.widget.CoordinatorLayout r12, @androidx.annotation.NonNull V r13, @androidx.annotation.NonNull android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r14.getActionMasked()
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 == r2) goto L4e
            r4 = 2
            if (r0 == r4) goto L2d
            r12 = 3
            if (r0 == r12) goto L72
            r12 = 6
            if (r0 == r12) goto L13
            goto L4c
        L13:
            int r12 = r14.getActionIndex()
            if (r12 != 0) goto L1b
            r12 = 1
            goto L1c
        L1b:
            r12 = 0
        L1c:
            int r13 = r14.getPointerId(r12)
            r11.f2724g = r13
            float r12 = r14.getY(r12)
            r13 = 1056964608(0x3f000000, float:0.5)
            float r12 = r12 + r13
            int r12 = (int) r12
            r11.f2725h = r12
            goto L4c
        L2d:
            int r0 = r11.f2724g
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r1) goto L36
            return r3
        L36:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r1 = r11.f2725h
            int r7 = r1 - r0
            r11.f2725h = r0
            int r8 = r11.m(r13)
            r9 = 0
            r4 = r11
            r5 = r12
            r6 = r13
            r4.q(r5, r6, r7, r8, r9)
        L4c:
            r12 = 0
            goto L81
        L4e:
            android.view.VelocityTracker r0 = r11.f2727j
            if (r0 == 0) goto L72
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f2727j
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f2727j
            int r4 = r11.f2724g
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.n(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.l(r6, r7, r8, r9, r10)
            r12 = 1
            goto L73
        L72:
            r12 = 0
        L73:
            r11.f2723f = r3
            r11.f2724g = r1
            android.view.VelocityTracker r13 = r11.f2727j
            if (r13 == 0) goto L81
            r13.recycle()
            r13 = 0
            r11.f2727j = r13
        L81:
            android.view.VelocityTracker r13 = r11.f2727j
            if (r13 == 0) goto L88
            r13.addMovement(r14)
        L88:
            boolean r13 = r11.f2723f
            if (r13 != 0) goto L90
            if (r12 == 0) goto L8f
            goto L90
        L8f:
            r2 = 0
        L90:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.onTouchEvent(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    public void p(CoordinatorLayout coordinatorLayout, V v) {
    }

    public final int q(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        return s(coordinatorLayout, v, o() - i2, i3, i4);
    }

    public int r(CoordinatorLayout coordinatorLayout, V v, int i2) {
        return s(coordinatorLayout, v, i2, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int s(CoordinatorLayout coordinatorLayout, V v, int i2, int i3, int i4) {
        int clamp;
        int b = b();
        if (i3 == 0 || b < i3 || b > i4 || b == (clamp = MathUtils.clamp(i2, i3, i4))) {
            return 0;
        }
        h(clamp);
        return b - clamp;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2724g = -1;
        this.f2726i = -1;
    }
}
