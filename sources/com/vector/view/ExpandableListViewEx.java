package com.vector.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.vector.view.ExpandableListViewEx;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes3.dex */
public class ExpandableListViewEx extends ExpandableListView {
    private static final int[] A;
    private static final int[][] B;
    private static final int[] x;
    private static final int[] y;
    private static final int[] z;
    private BaseExpandableListAdapter a;
    private AbsListView.OnScrollListener b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7927c;

    /* renamed from: d  reason: collision with root package name */
    private View f7928d;

    /* renamed from: e  reason: collision with root package name */
    private int f7929e;

    /* renamed from: f  reason: collision with root package name */
    private int f7930f;

    /* renamed from: g  reason: collision with root package name */
    private e f7931g;

    /* renamed from: h  reason: collision with root package name */
    private ExpandableListView.OnGroupClickListener f7932h;

    /* renamed from: i  reason: collision with root package name */
    private int f7933i;

    /* renamed from: j  reason: collision with root package name */
    private Object f7934j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f7935k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f7936l;

    /* renamed from: m  reason: collision with root package name */
    private Runnable f7937m;
    private GestureDetector n;
    private boolean o;
    private boolean p;
    private boolean q;
    private Drawable r;
    private int s;
    private final Rect t;
    private Runnable u;
    private Runnable v;
    private final Rect w;

    /* loaded from: classes3.dex */
    public class a implements AbsListView.OnScrollListener {
        public a() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
            if (ExpandableListViewEx.this.b != null) {
                ExpandableListViewEx.this.b.onScroll(absListView, i2, i3, i4);
            }
            if (!ExpandableListViewEx.this.f7927c || ExpandableListViewEx.this.a == null || ExpandableListViewEx.this.a.getGroupCount() <= 0 || i3 <= 0 || i2 < ExpandableListViewEx.this.getHeaderViewsCount()) {
                if (ExpandableListViewEx.this.f7928d != null) {
                    ExpandableListViewEx.this.f7928d.setVisibility(8);
                    return;
                }
                return;
            }
            ExpandableListViewEx.this.h(i2);
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i2) {
            if (ExpandableListViewEx.this.b != null) {
                ExpandableListViewEx.this.b.onScrollStateChanged(absListView, i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExpandableListViewEx.this.u();
            ExpandableListViewEx.this.setPressed(true);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ExpandableListViewEx.this.setPressed(false);
            if (ExpandableListViewEx.this.f7928d != null) {
                ExpandableListViewEx.this.f7928d.setPressed(false);
            }
            ExpandableListViewEx.this.invalidate();
        }
    }

    /* loaded from: classes3.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (ExpandableListViewEx.this.f7928d == null || ExpandableListViewEx.this.f7928d.isLongClickable()) {
                return;
            }
            ExpandableListView.ExpandableListContextMenuInfo expandableListContextMenuInfo = new ExpandableListView.ExpandableListContextMenuInfo(ExpandableListViewEx.this.f7928d, ExpandableListView.getPackedPositionForGroup(ExpandableListViewEx.this.f7929e), ExpandableListViewEx.this.a.getGroupId(ExpandableListViewEx.this.f7929e));
            if (Build.VERSION.SDK_INT < 29) {
                ExpandableListViewEx.v(AbsListView.class, "mContextMenuInfo", ExpandableListViewEx.this, expandableListContextMenuInfo);
            }
            ExpandableListViewEx.this.showContextMenu();
        }
    }

    /* loaded from: classes3.dex */
    public interface e {
        void a(View view, int i2);
    }

    static {
        int[] iArr = new int[0];
        x = iArr;
        int[] iArr2 = {16842920};
        y = iArr2;
        int[] iArr3 = {16842921};
        z = iArr3;
        int[] iArr4 = {16842920, 16842921};
        A = iArr4;
        B = new int[][]{iArr, iArr2, iArr3, iArr4};
    }

    public ExpandableListViewEx(Context context) {
        super(context);
        this.f7927c = true;
        this.t = new Rect();
        this.w = new Rect();
        n();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i2) {
        View childAt;
        int makeMeasureSpec;
        if (this.f7927c) {
            int packedPositionGroup = ExpandableListView.getPackedPositionGroup(getExpandableListPosition(i2));
            this.f7929e = packedPositionGroup;
            int i3 = 0;
            if (packedPositionGroup >= 0) {
                View groupView = this.a.getGroupView(packedPositionGroup, isGroupExpanded(packedPositionGroup), this.f7928d, this);
                this.f7928d = groupView;
                if (groupView == null) {
                    return;
                }
                if (isGroupExpanded(this.f7929e)) {
                    this.f7928d.setVisibility(0);
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) this.f7928d.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(-1, -2, 0);
                        this.f7928d.setLayoutParams(layoutParams);
                    }
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.f7933i, getPaddingLeft() + getPaddingRight(), layoutParams.width);
                    int i4 = layoutParams.height;
                    if (i4 > 0) {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i4, 1073741824);
                    } else {
                        makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
                    }
                    this.f7928d.measure(childMeasureSpec, makeMeasureSpec);
                    t();
                    setAttachInfo(this.f7928d);
                    if (!this.f7928d.isClickable()) {
                        this.o = true;
                        this.f7928d.setOnClickListener(new View.OnClickListener() { // from class: e.t.v.a
                            @Override // android.view.View.OnClickListener
                            public final void onClick(View view) {
                                ExpandableListViewEx.this.q(view);
                            }
                        });
                    } else {
                        this.o = false;
                    }
                } else {
                    this.f7928d.setVisibility(8);
                    return;
                }
            }
            if (this.f7928d == null) {
                return;
            }
            int flatListPosition = getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f7929e + 1)) - i2;
            if (flatListPosition >= 0 && flatListPosition < getChildCount() && (childAt = getChildAt(flatListPosition)) != null && childAt.getTop() < getPaddingTop() + this.f7928d.getMeasuredHeight() + getDividerHeight()) {
                i3 = childAt.getTop() - ((getPaddingTop() + this.f7928d.getMeasuredHeight()) + getDividerHeight());
            }
            int paddingLeft = getPaddingLeft();
            int paddingTop = getPaddingTop() + i3;
            this.f7928d.layout(paddingLeft, paddingTop, this.f7928d.getMeasuredWidth() + paddingLeft, this.f7928d.getMeasuredHeight() + paddingTop);
            this.f7930f = i3;
            e eVar = this.f7931g;
            if (eVar != null) {
                eVar.a(this.f7928d, i3);
            }
        }
    }

    private void i(Canvas canvas) {
        Rect rect;
        int firstVisiblePosition = this.s - getFirstVisiblePosition();
        if (firstVisiblePosition < 0 || firstVisiblePosition >= getChildCount() || (rect = this.t) == null || rect.isEmpty()) {
            return;
        }
        int flatListPosition = getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f7929e));
        if (this.f7928d == null || this.s != flatListPosition) {
            l(canvas);
        }
    }

    private void j(Canvas canvas) {
        Drawable drawable = (Drawable) m(ExpandableListView.class, "mGroupIndicator", this);
        if (drawable != null) {
            drawable.setState(B[isGroupExpanded(this.f7929e) | (this.a.getChildrenCount(this.f7929e) > 0 ? (char) 2 : (char) 0)]);
            int intValue = ((Integer) m(ExpandableListView.class, "mIndicatorLeft", this)).intValue();
            int intValue2 = ((Integer) m(ExpandableListView.class, "mIndicatorRight", this)).intValue();
            if (Build.VERSION.SDK_INT >= 14) {
                this.w.set(intValue + getPaddingLeft(), this.f7928d.getTop(), intValue2 + getPaddingLeft(), this.f7928d.getBottom());
            } else {
                this.w.set(intValue, this.f7928d.getTop(), intValue2, this.f7928d.getBottom());
            }
            drawable.setBounds(this.w);
            drawable.draw(canvas);
        }
    }

    private void k(Canvas canvas) {
        Rect rect = this.t;
        if (rect == null || rect.isEmpty()) {
            return;
        }
        if (this.s == getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f7929e))) {
            this.t.set(this.f7928d.getLeft(), this.f7928d.getTop(), this.f7928d.getRight(), this.f7928d.getBottom());
            l(canvas);
        }
    }

    private void l(Canvas canvas) {
        canvas.save();
        canvas.clipRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (isPressed()) {
            this.r.setState(getDrawableState());
        } else {
            this.r.setState(x);
        }
        this.r.setBounds(this.t);
        this.r.draw(canvas);
        canvas.restore();
    }

    public static Object m(Class<?> cls, String str, Object obj) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField.get(obj);
        } catch (Exception unused) {
            return null;
        }
    }

    private void n() {
        if (isInEditMode()) {
            return;
        }
        super.setOnScrollListener(new a());
        this.f7937m = new Runnable() { // from class: e.t.v.b
            @Override // java.lang.Runnable
            public final void run() {
                ExpandableListViewEx.this.s();
            }
        };
        this.u = new b();
        this.v = new c();
        this.n = new GestureDetector(getContext(), new d());
    }

    public static Object o(Class<?> cls, String str, Class<?>[] clsArr, Object obj, Object... objArr) {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void q(View view) {
        postDelayed(this.f7937m, ViewConfiguration.getPressedStateDuration());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public /* synthetic */ void s() {
        ExpandableListView.OnGroupClickListener onGroupClickListener = this.f7932h;
        boolean z2 = true;
        if (onGroupClickListener != null) {
            View view = this.f7928d;
            int i2 = this.f7929e;
            z2 = true ^ onGroupClickListener.onGroupClick(this, view, i2, this.a.getGroupId(i2));
        }
        if (z2) {
            if (isGroupExpanded(this.f7929e)) {
                collapseGroup(this.f7929e);
            } else {
                expandGroup(this.f7929e);
            }
            setSelectedGroup(this.f7929e);
        }
    }

    private void setAttachInfo(View view) {
        if (view == null) {
            return;
        }
        Object obj = this.f7934j;
        if (obj != null) {
            v(View.class, "mAttachInfo", view, obj);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                setAttachInfo(viewGroup.getChildAt(i2));
            }
        }
    }

    private void t() {
        Object m2;
        if (this.f7934j != null || (m2 = m(View.class, "mAttachInfo", this)) == null) {
            return;
        }
        this.f7934j = m2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        View view;
        if (this.p && (view = this.f7928d) != null) {
            if (Build.VERSION.SDK_INT >= 14) {
                o(AbsListView.class, "positionSelector", new Class[]{Integer.TYPE, View.class}, this, Integer.valueOf(getFlatListPosition(ExpandableListView.getPackedPositionForGroup(this.f7929e))), this.f7928d);
            } else {
                o(AbsListView.class, "positionSelector", new Class[]{View.class}, this, view);
            }
            invalidate();
        }
        this.p = false;
        removeCallbacks(this.u);
    }

    public static void v(Class<?> cls, String str, Object obj, Object obj2) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            declaredField.set(obj, obj2);
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.ExpandableListView, android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        Object m2 = m(AbsListView.class, "mSelectorPosition", this);
        if (m2 != null) {
            this.s = ((Integer) m2).intValue();
        }
        Object m3 = m(AbsListView.class, "mSelectorRect", this);
        if (m3 != null) {
            this.t.set((Rect) m3);
        }
        if (!this.q) {
            i(canvas);
        }
        super.dispatchDraw(canvas);
        if (!this.f7927c || this.f7928d == null) {
            return;
        }
        if (!this.q) {
            k(canvas);
        }
        canvas.save();
        canvas.clipRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.f7928d.getVisibility() == 0) {
            drawChild(canvas, this.f7928d, getDrawingTime());
        }
        j(canvas);
        canvas.restore();
        if (this.q) {
            i(canvas);
            k(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        View view;
        if (this.f7927c && (view = this.f7928d) != null && view.getVisibility() == 0) {
            int action = motionEvent.getAction() & 255;
            if (action == 0 || action == 3) {
                this.f7935k = false;
                this.f7936l = false;
                this.p = false;
            }
            if (!this.f7935k && !this.f7936l) {
                int[] iArr = new int[2];
                getLocationInWindow(iArr);
                if (new RectF(iArr[0] + this.f7928d.getLeft(), iArr[1] + this.f7928d.getTop(), iArr[0] + this.f7928d.getRight(), iArr[1] + this.f7928d.getBottom()).contains(motionEvent.getRawX(), motionEvent.getRawY())) {
                    if (this.o) {
                        if (action == 0) {
                            this.p = true;
                            removeCallbacks(this.u);
                            postDelayed(this.u, ViewConfiguration.getTapTimeout());
                        } else if (action == 1) {
                            u();
                            setPressed(true);
                            View view2 = this.f7928d;
                            if (view2 != null) {
                                view2.setPressed(true);
                            }
                            removeCallbacks(this.v);
                            postDelayed(this.v, ViewConfiguration.getPressedStateDuration());
                        }
                    }
                    if (this.f7928d.dispatchTouchEvent(motionEvent)) {
                        this.n.onTouchEvent(motionEvent);
                        onInterceptTouchEvent(motionEvent);
                        return true;
                    }
                }
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        this.f7935k = onInterceptTouchEvent;
        return onInterceptTouchEvent;
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.f7933i = i2;
    }

    @Override // android.widget.AbsListView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f7936l = super.onTouchEvent(motionEvent);
        View view = this.f7928d;
        if (view != null && view.getVisibility() == 0) {
            this.f7928d.setPressed(false);
        }
        return this.f7936l;
    }

    @Override // android.widget.ExpandableListView
    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        if (expandableListAdapter instanceof BaseExpandableListAdapter) {
            setAdapter((BaseExpandableListAdapter) expandableListAdapter);
            return;
        }
        throw new IllegalArgumentException("The adapter must be an instance of BaseExpandableListAdapter");
    }

    @Override // android.widget.AbsListView
    public void setDrawSelectorOnTop(boolean z2) {
        super.setDrawSelectorOnTop(z2);
        this.q = z2;
    }

    public void setFloatingGroupEnabled(boolean z2) {
        this.f7927c = z2;
    }

    @Override // android.widget.ExpandableListView
    public void setOnGroupClickListener(ExpandableListView.OnGroupClickListener onGroupClickListener) {
        super.setOnGroupClickListener(onGroupClickListener);
        this.f7932h = onGroupClickListener;
    }

    public void setOnScrollFloatingGroupListener(e eVar) {
        this.f7931g = eVar;
    }

    @Override // android.widget.AbsListView
    public void setOnScrollListener(AbsListView.OnScrollListener onScrollListener) {
        this.b = onScrollListener;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        super.setSelector(new ColorDrawable(0));
        Drawable drawable2 = this.r;
        if (drawable2 != null) {
            drawable2.setCallback(null);
            unscheduleDrawable(this.r);
        }
        this.r = drawable;
        drawable.setCallback(this);
    }

    public void setAdapter(BaseExpandableListAdapter baseExpandableListAdapter) {
        super.setAdapter((ExpandableListAdapter) baseExpandableListAdapter);
        this.a = baseExpandableListAdapter;
    }

    public ExpandableListViewEx(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7927c = true;
        this.t = new Rect();
        this.w = new Rect();
        n();
    }

    public ExpandableListViewEx(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7927c = true;
        this.t = new Rect();
        this.w = new Rect();
        n();
    }
}
