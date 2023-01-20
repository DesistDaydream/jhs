package easyswipemenu;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import com.jihuanshe.R;
import java.util.ArrayList;

/* loaded from: classes3.dex */
public class EasySwipeMenuLayout extends ViewGroup {
    private static final String t = "EasySwipeMenuLayout";
    private static EasySwipeMenuLayout u;
    private static State v;
    private final ArrayList<View> a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f14742c;

    /* renamed from: d  reason: collision with root package name */
    private int f14743d;

    /* renamed from: e  reason: collision with root package name */
    private View f14744e;

    /* renamed from: f  reason: collision with root package name */
    private View f14745f;

    /* renamed from: g  reason: collision with root package name */
    private View f14746g;

    /* renamed from: h  reason: collision with root package name */
    private ViewGroup.MarginLayoutParams f14747h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f14748i;

    /* renamed from: j  reason: collision with root package name */
    private PointF f14749j;

    /* renamed from: k  reason: collision with root package name */
    private PointF f14750k;

    /* renamed from: l  reason: collision with root package name */
    private float f14751l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f14752m;
    private boolean n;
    private int o;
    private Scroller p;
    private float q;
    private float r;
    public State s;

    public EasySwipeMenuLayout(Context context) {
        this(context, null);
    }

    private void a(State state) {
        if (state == State.LEFTOPEN) {
            this.p.startScroll(getScrollX(), 0, this.f14744e.getLeft() - getScrollX(), 0);
            u = this;
            v = state;
        } else if (state == State.RIGHTOPEN) {
            u = this;
            this.p.startScroll(getScrollX(), 0, ((this.f14745f.getRight() - this.f14746g.getRight()) - this.f14747h.rightMargin) - getScrollX(), 0);
            v = state;
        } else {
            this.p.startScroll(getScrollX(), 0, -getScrollX(), 0);
            u = null;
            v = null;
        }
        invalidate();
    }

    private void b(Context context, AttributeSet attributeSet, int i2) {
        this.o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.p = new Scroller(context);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.EasySwipeMenuLayout, i2, 0);
        try {
            try {
                int indexCount = obtainStyledAttributes.getIndexCount();
                for (int i3 = 0; i3 < indexCount; i3++) {
                    int index = obtainStyledAttributes.getIndex(i3);
                    if (index == 4) {
                        this.b = obtainStyledAttributes.getResourceId(4, -1);
                    } else if (index == 5) {
                        this.f14742c = obtainStyledAttributes.getResourceId(5, -1);
                    } else if (index == 2) {
                        this.f14743d = obtainStyledAttributes.getResourceId(2, -1);
                    } else if (index == 0) {
                        this.f14752m = obtainStyledAttributes.getBoolean(0, true);
                    } else if (index == 1) {
                        this.n = obtainStyledAttributes.getBoolean(1, true);
                    } else if (index == 3) {
                        this.f14751l = obtainStyledAttributes.getFloat(3, 0.5f);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private boolean e() {
        return this.q < 0.0f;
    }

    private State f(int i2) {
        View view;
        View view2;
        if (this.o >= Math.abs(this.r)) {
            return v;
        }
        Log.i(t, ">>>finalyDistanceX:" + this.r);
        float f2 = this.r;
        if (f2 < 0.0f) {
            if (getScrollX() < 0 && (view2 = this.f14744e) != null && Math.abs(view2.getWidth() * this.f14751l) < Math.abs(getScrollX())) {
                return State.LEFTOPEN;
            }
            if (getScrollX() > 0 && this.f14745f != null) {
                return State.CLOSE;
            }
        } else if (f2 > 0.0f) {
            if (getScrollX() > 0 && (view = this.f14745f) != null && Math.abs(view.getWidth() * this.f14751l) < Math.abs(getScrollX())) {
                return State.RIGHTOPEN;
            }
            if (getScrollX() < 0 && this.f14744e != null) {
                return State.CLOSE;
            }
        }
        return State.CLOSE;
    }

    public static State getStateCache() {
        return v;
    }

    public static EasySwipeMenuLayout getViewCache() {
        return u;
    }

    public boolean c() {
        return this.f14752m;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.p.computeScrollOffset()) {
            scrollTo(this.p.getCurrX(), this.p.getCurrY());
            invalidate();
        }
    }

    public boolean d() {
        return this.n;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x000e, code lost:
        if (r0 != 3) goto L8;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 313
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: easyswipemenu.EasySwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    public void g() {
        State state;
        Scroller scroller;
        if (u == null || (state = v) == null || state == State.CLOSE || (scroller = this.p) == null) {
            return;
        }
        scroller.startScroll(u.getScrollX(), 0, -u.getScrollX(), 0);
        u.invalidate();
        u = null;
        v = null;
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public float getFraction() {
        return this.f14751l;
    }

    public void h() {
        State state;
        Scroller scroller;
        if (u == null || (state = v) == null || state == State.CLOSE || (scroller = this.p) == null) {
            return;
        }
        scroller.startScroll(u.getScrollX(), 0, -u.getScrollX(), 0, 0);
        u.invalidate();
        u = null;
        v = null;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        EasySwipeMenuLayout easySwipeMenuLayout = u;
        if (this == easySwipeMenuLayout) {
            easySwipeMenuLayout.a(v);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        EasySwipeMenuLayout easySwipeMenuLayout = u;
        if (this == easySwipeMenuLayout) {
            easySwipeMenuLayout.a(State.CLOSE);
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:
        if (r0 != 3) goto L7;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r4) {
        /*
            r3 = this;
            int r0 = r4.getAction()
            r1 = 1
            if (r0 == r1) goto L1c
            r2 = 2
            if (r0 == r2) goto Le
            r2 = 3
            if (r0 == r2) goto L1c
            goto L27
        Le:
            float r0 = r3.r
            float r0 = java.lang.Math.abs(r0)
            int r2 = r3.o
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L27
            return r1
        L1c:
            boolean r0 = r3.f14748i
            if (r0 == 0) goto L27
            r4 = 0
            r3.f14748i = r4
            r4 = 0
            r3.r = r4
            return r1
        L27:
            boolean r4 = super.onInterceptTouchEvent(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: easyswipemenu.EasySwipeMenuLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft() + 0;
        getPaddingLeft();
        int paddingTop = getPaddingTop() + 0;
        getPaddingTop();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = getChildAt(i6);
            if (this.f14744e == null && childAt.getId() == this.b) {
                this.f14744e = childAt;
                childAt.setClickable(true);
            } else if (this.f14745f == null && childAt.getId() == this.f14742c) {
                this.f14745f = childAt;
                childAt.setClickable(true);
            } else if (this.f14746g == null && childAt.getId() == this.f14743d) {
                this.f14746g = childAt;
                childAt.setClickable(true);
            }
        }
        View view = this.f14746g;
        if (view != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            this.f14747h = marginLayoutParams;
            int i7 = marginLayoutParams.topMargin + paddingTop;
            int i8 = marginLayoutParams.leftMargin;
            this.f14746g.layout(paddingLeft + i8, i7, paddingLeft + i8 + this.f14746g.getMeasuredWidth(), this.f14746g.getMeasuredHeight() + i7);
        }
        View view2 = this.f14744e;
        if (view2 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view2.getLayoutParams();
            int i9 = marginLayoutParams2.topMargin + paddingTop;
            int i10 = marginLayoutParams2.rightMargin;
            this.f14744e.layout((0 - this.f14744e.getMeasuredWidth()) + marginLayoutParams2.leftMargin + i10, i9, 0 - i10, this.f14744e.getMeasuredHeight() + i9);
        }
        View view3 = this.f14745f;
        if (view3 != null) {
            ViewGroup.MarginLayoutParams marginLayoutParams3 = (ViewGroup.MarginLayoutParams) view3.getLayoutParams();
            int i11 = paddingTop + marginLayoutParams3.topMargin;
            int right = this.f14746g.getRight() + this.f14747h.rightMargin + marginLayoutParams3.leftMargin;
            this.f14745f.layout(right, i11, this.f14745f.getMeasuredWidth() + right, this.f14745f.getMeasuredHeight() + i11);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int childMeasureSpec;
        int childMeasureSpec2;
        super.onMeasure(i2, i3);
        setClickable(true);
        int childCount = getChildCount();
        boolean z = (View.MeasureSpec.getMode(i2) == 1073741824 && View.MeasureSpec.getMode(i3) == 1073741824) ? false : true;
        this.a.clear();
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8) {
                measureChildWithMargins(childAt, i2, 0, i3, 0);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i5 = Math.max(i5, childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
                i6 = Math.max(i6, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i4 = ViewGroup.combineMeasuredStates(i4, childAt.getMeasuredState());
                if (z && (marginLayoutParams.width == -1 || marginLayoutParams.height == -1)) {
                    this.a.add(childAt);
                }
            }
        }
        int i8 = i4;
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(i5, getSuggestedMinimumWidth()), i2, i8), ViewGroup.resolveSizeAndState(Math.max(i6, getSuggestedMinimumHeight()), i3, i8 << 16));
        int size = this.a.size();
        if (size > 1) {
            for (int i9 = 0; i9 < size; i9++) {
                View view = this.a.get(i9);
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int i10 = marginLayoutParams2.width;
                if (i10 == -1) {
                    childMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredWidth() - marginLayoutParams2.leftMargin) - marginLayoutParams2.rightMargin), 1073741824);
                } else {
                    childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, i10);
                }
                int i11 = marginLayoutParams2.height;
                if (i11 == -1) {
                    childMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getMeasuredHeight() - marginLayoutParams2.topMargin) - marginLayoutParams2.bottomMargin), 1073741824);
                } else {
                    childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin, i11);
                }
                view.measure(childMeasureSpec, childMeasureSpec2);
            }
        }
    }

    public void setCanLeftSwipe(boolean z) {
        this.f14752m = z;
    }

    public void setCanRightSwipe(boolean z) {
        this.n = z;
    }

    public void setFraction(float f2) {
        this.f14751l = f2;
    }

    public EasySwipeMenuLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public EasySwipeMenuLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = new ArrayList<>(1);
        this.f14751l = 0.3f;
        this.f14752m = true;
        this.n = true;
        b(context, attributeSet, i2);
    }
}
