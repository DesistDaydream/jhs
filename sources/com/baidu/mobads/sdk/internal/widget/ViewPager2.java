package com.baidu.mobads.sdk.internal.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RequiresApi;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.badge.BadgeDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class ViewPager2 extends ViewGroup {
    public static final int a = 0;
    public static final int b = 1;

    /* renamed from: c  reason: collision with root package name */
    public static final int f1650c = 0;

    /* renamed from: d  reason: collision with root package name */
    public static final int f1651d = 1;

    /* renamed from: e  reason: collision with root package name */
    public static final int f1652e = 2;

    /* renamed from: f  reason: collision with root package name */
    public static final int f1653f = -1;

    /* renamed from: g  reason: collision with root package name */
    public static boolean f1654g = true;
    private int A;

    /* renamed from: h  reason: collision with root package name */
    public int f1655h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f1656i;

    /* renamed from: j  reason: collision with root package name */
    public RecyclerView f1657j;

    /* renamed from: k  reason: collision with root package name */
    public ScrollEventAdapter f1658k;

    /* renamed from: l  reason: collision with root package name */
    public AccessibilityProvider f1659l;

    /* renamed from: m  reason: collision with root package name */
    private final Rect f1660m;
    private final Rect n;
    private CompositeOnPageChangeCallback o;
    private RecyclerView.AdapterDataObserver p;
    private LinearLayoutManager q;
    private int r;
    private Parcelable s;
    private PagerSnapHelper t;
    private CompositeOnPageChangeCallback u;
    private FakeDrag v;
    private PageTransformerAdapter w;
    private RecyclerView.ItemAnimator x;
    private boolean y;
    private boolean z;

    /* loaded from: classes.dex */
    public abstract class AccessibilityProvider {
        private AccessibilityProvider() {
        }

        public void a(@NonNull AccessibilityEvent accessibilityEvent) {
        }

        public void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        }

        public void a(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        public void a(@NonNull CompositeOnPageChangeCallback compositeOnPageChangeCallback, @NonNull RecyclerView recyclerView) {
        }

        public boolean a() {
            return false;
        }

        public boolean a(int i2, Bundle bundle) {
            return false;
        }

        public String b() {
            throw new IllegalStateException("Not implemented.");
        }

        public void b(@Nullable RecyclerView.Adapter<?> adapter) {
        }

        public void c() {
        }

        public void d() {
        }

        public void e() {
        }

        public void f() {
        }

        public void g() {
        }

        public boolean handlesLmPerformAccessibilityAction(int i2) {
            return false;
        }

        public boolean handlesRvGetAccessibilityClassName() {
            return false;
        }

        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        }

        public boolean onLmPerformAccessibilityAction(int i2) {
            throw new IllegalStateException("Not implemented.");
        }

        public CharSequence onRvGetAccessibilityClassName() {
            throw new IllegalStateException("Not implemented.");
        }

        public boolean b(int i2, Bundle bundle) {
            throw new IllegalStateException("Not implemented.");
        }
    }

    /* loaded from: classes.dex */
    public class BasicAccessibilityProvider extends AccessibilityProvider {
        public BasicAccessibilityProvider() {
            super();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesLmPerformAccessibilityAction(int i2) {
            return (i2 == 8192 || i2 == 4096) && !ViewPager2.this.isUserInputEnabled();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean handlesRvGetAccessibilityClassName() {
            return true;
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public void onLmInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (ViewPager2.this.isUserInputEnabled()) {
                return;
            }
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
            accessibilityNodeInfoCompat.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
            accessibilityNodeInfoCompat.setScrollable(false);
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public boolean onLmPerformAccessibilityAction(int i2) {
            if (handlesLmPerformAccessibilityAction(i2)) {
                return false;
            }
            throw new IllegalStateException();
        }

        @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.AccessibilityProvider
        public CharSequence onRvGetAccessibilityClassName() {
            if (handlesRvGetAccessibilityClassName()) {
                return "androidx.viewpager.widget.ViewPager";
            }
            throw new IllegalStateException();
        }
    }

    /* loaded from: classes.dex */
    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public abstract void onChanged();

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeInserted(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeMoved(int i2, int i3, int i4) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeRemoved(int i2, int i3) {
            onChanged();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
        public final void onItemRangeChanged(int i2, int i3, @Nullable Object obj) {
            onChanged();
        }
    }

    /* loaded from: classes.dex */
    public class LinearLayoutManagerImpl extends LinearLayoutManager {
        public LinearLayoutManagerImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public int getExtraLayoutSpace(RecyclerView.State state) {
            int offscreenPageLimit = ViewPager2.this.getOffscreenPageLimit();
            if (offscreenPageLimit == -1) {
                return super.getExtraLayoutSpace(state);
            }
            return ViewPager2.this.b() * offscreenPageLimit;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(recycler, state, accessibilityNodeInfoCompat);
            ViewPager2.this.f1659l.onLmInitializeAccessibilityNodeInfo(accessibilityNodeInfoCompat);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean performAccessibilityAction(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int i2, @Nullable Bundle bundle) {
            if (ViewPager2.this.f1659l.handlesLmPerformAccessibilityAction(i2)) {
                return ViewPager2.this.f1659l.onLmPerformAccessibilityAction(i2);
            }
            return super.performAccessibilityAction(recycler, state, i2, bundle);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z, boolean z2) {
            return false;
        }
    }

    @IntRange(from = 1)
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OffscreenPageLimit {
    }

    /* loaded from: classes.dex */
    public interface OnOverScrollListener {
        void onOverScrollEnd();

        void onOverScrollStart();
    }

    /* loaded from: classes.dex */
    public static abstract class OnPageChangeCallback {
        public void onPageScrollStateChanged(int i2) {
        }

        public void onPageScrolled(int i2, float f2, @Px int i3) {
        }

        public void onPageSelected(int i2) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    public interface PageTransformer {
        void transformPage(@NonNull View view, float f2);
    }

    /* loaded from: classes.dex */
    public class PagerSnapHelperImpl extends PagerSnapHelper {
        public PagerSnapHelperImpl() {
        }

        @Override // com.baidu.mobads.sdk.internal.widget.PagerSnapHelper, androidx.recyclerview.widget.SnapHelper
        @Nullable
        public View findSnapView(RecyclerView.LayoutManager layoutManager) {
            if (ViewPager2.this.isFakeDragging()) {
                return null;
            }
            return super.findSnapView(layoutManager);
        }
    }

    /* loaded from: classes.dex */
    public class RecyclerViewImpl extends RecyclerView {
        public RecyclerViewImpl(Context context) {
            super(context);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
        @RequiresApi(23)
        public CharSequence getAccessibilityClassName() {
            if (ViewPager2.this.f1659l.handlesRvGetAccessibilityClassName()) {
                return ViewPager2.this.f1659l.onRvGetAccessibilityClassName();
            }
            return super.getAccessibilityClassName();
        }

        @Override // android.view.View
        public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setFromIndex(ViewPager2.this.f1655h);
            accessibilityEvent.setToIndex(ViewPager2.this.f1655h);
            ViewPager2.this.f1659l.a(accessibilityEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onInterceptTouchEvent(motionEvent);
        }

        @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
        @SuppressLint({"ClickableViewAccessibility"})
        public boolean onTouchEvent(MotionEvent motionEvent) {
            return ViewPager2.this.isUserInputEnabled() && super.onTouchEvent(motionEvent);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ScrollState {
    }

    /* loaded from: classes.dex */
    public static class SmoothScrollToPosition implements Runnable {
        private final int a;
        private final RecyclerView b;

        public SmoothScrollToPosition(int i2, RecyclerView recyclerView) {
            this.a = i2;
            this.b = recyclerView;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.smoothScrollToPosition(this.a);
        }
    }

    public ViewPager2(@NonNull Context context) {
        super(context);
        this.f1660m = new Rect();
        this.n = new Rect();
        this.o = new CompositeOnPageChangeCallback(3);
        this.f1656i = false;
        this.p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f1656i = true;
                viewPager2.f1658k.a();
            }
        };
        this.r = -1;
        this.x = null;
        this.y = false;
        this.z = true;
        this.A = -1;
        a(context, (AttributeSet) null);
    }

    private void a(Context context, AttributeSet attributeSet) {
        this.f1659l = new BasicAccessibilityProvider();
        RecyclerViewImpl recyclerViewImpl = new RecyclerViewImpl(context);
        this.f1657j = recyclerViewImpl;
        recyclerViewImpl.setId(ViewCompat.generateViewId());
        this.f1657j.setDescendantFocusability(131072);
        LinearLayoutManagerImpl linearLayoutManagerImpl = new LinearLayoutManagerImpl(context);
        this.q = linearLayoutManagerImpl;
        this.f1657j.setLayoutManager(linearLayoutManagerImpl);
        this.f1657j.setScrollingTouchSlop(1);
        setOrientation(0);
        this.f1657j.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f1657j.addOnChildAttachStateChangeListener(e());
        ScrollEventAdapter scrollEventAdapter = new ScrollEventAdapter(this);
        this.f1658k = scrollEventAdapter;
        this.v = new FakeDrag(this, scrollEventAdapter, this.f1657j);
        PagerSnapHelperImpl pagerSnapHelperImpl = new PagerSnapHelperImpl();
        this.t = pagerSnapHelperImpl;
        pagerSnapHelperImpl.attachToRecyclerView(this.f1657j);
        this.f1657j.addOnScrollListener(this.f1658k);
        CompositeOnPageChangeCallback compositeOnPageChangeCallback = new CompositeOnPageChangeCallback(3);
        this.u = compositeOnPageChangeCallback;
        this.f1658k.a(compositeOnPageChangeCallback);
        OnPageChangeCallback onPageChangeCallback = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.2
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                if (i2 == 0) {
                    ViewPager2.this.a();
                }
            }

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2 viewPager2 = ViewPager2.this;
                if (viewPager2.f1655h != i2) {
                    viewPager2.f1655h = i2;
                    viewPager2.f1659l.e();
                }
            }
        };
        OnPageChangeCallback onPageChangeCallback2 = new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.3
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageSelected(int i2) {
                ViewPager2.this.clearFocus();
                if (ViewPager2.this.hasFocus()) {
                    ViewPager2.this.f1657j.requestFocus(2);
                }
            }
        };
        this.u.a(onPageChangeCallback);
        this.u.a(onPageChangeCallback2);
        this.f1659l.a(this.u, this.f1657j);
        this.u.a(this.o);
        PageTransformerAdapter pageTransformerAdapter = new PageTransformerAdapter(this.q);
        this.w = pageTransformerAdapter;
        this.u.a(pageTransformerAdapter);
        RecyclerView recyclerView = this.f1657j;
        attachViewToParent(recyclerView, 0, recyclerView.getLayoutParams());
    }

    private void b(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.unregisterAdapterDataObserver(this.p);
        }
    }

    private RecyclerView.OnChildAttachStateChangeListener e() {
        return new RecyclerView.OnChildAttachStateChangeListener() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.4
            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewAttachedToWindow(@NonNull View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (((ViewGroup.MarginLayoutParams) layoutParams).width != -1 || ((ViewGroup.MarginLayoutParams) layoutParams).height != -1) {
                    throw new IllegalStateException("Pages must fill the whole ViewPager2 (use match_parent)");
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
            public void onChildViewDetachedFromWindow(@NonNull View view) {
            }
        };
    }

    private void f() {
        RecyclerView.Adapter adapter;
        if (this.r == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        Parcelable parcelable = this.s;
        if (parcelable != null) {
            if (adapter instanceof StatefulAdapter) {
                ((StatefulAdapter) adapter).restoreState(parcelable);
            }
            this.s = null;
        }
        int max = Math.max(0, Math.min(this.r, adapter.getItemCount() - 1));
        this.f1655h = max;
        this.r = -1;
        this.f1657j.scrollToPosition(max);
        this.f1659l.c();
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f1657j.addItemDecoration(itemDecoration);
    }

    public boolean beginFakeDrag() {
        return this.v.b();
    }

    public boolean c() {
        return this.q.getLayoutDirection() == 1;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        return this.f1657j.canScrollHorizontally(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        return this.f1657j.canScrollVertically(i2);
    }

    public void d() {
        View findSnapView = this.t.findSnapView(this.q);
        if (findSnapView == null) {
            return;
        }
        int[] calculateDistanceToFinalSnap = this.t.calculateDistanceToFinalSnap(this.q, findSnapView);
        if (calculateDistanceToFinalSnap[0] == 0 && calculateDistanceToFinalSnap[1] == 0) {
            return;
        }
        this.f1657j.smoothScrollBy(calculateDistanceToFinalSnap[0], calculateDistanceToFinalSnap[1]);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        Parcelable parcelable = sparseArray.get(getId());
        if (parcelable instanceof SavedState) {
            int i2 = ((SavedState) parcelable).a;
            sparseArray.put(this.f1657j.getId(), sparseArray.get(i2));
            sparseArray.remove(i2);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        f();
    }

    public boolean endFakeDrag() {
        return this.v.c();
    }

    public boolean fakeDragBy(@Px @SuppressLint({"SupportAnnotationUsage"}) float f2) {
        return this.v.a(f2);
    }

    @Override // android.view.ViewGroup, android.view.View
    @RequiresApi(23)
    public CharSequence getAccessibilityClassName() {
        if (this.f1659l.a()) {
            return this.f1659l.b();
        }
        return super.getAccessibilityClassName();
    }

    @Nullable
    public RecyclerView.Adapter getAdapter() {
        return this.f1657j.getAdapter();
    }

    public int getCurrentItem() {
        return this.f1655h;
    }

    @NonNull
    public RecyclerView.ItemDecoration getItemDecorationAt(int i2) {
        return this.f1657j.getItemDecorationAt(i2);
    }

    public int getItemDecorationCount() {
        return this.f1657j.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.A;
    }

    public int getOrientation() {
        return this.q.getOrientation();
    }

    public int getScrollState() {
        return this.f1658k.d();
    }

    public void invalidateItemDecorations() {
        this.f1657j.invalidateItemDecorations();
    }

    public boolean isFakeDragging() {
        return this.v.a();
    }

    public boolean isUserInputEnabled() {
        return this.z;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        this.f1659l.a(accessibilityNodeInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int measuredWidth = this.f1657j.getMeasuredWidth();
        int measuredHeight = this.f1657j.getMeasuredHeight();
        this.f1660m.left = getPaddingLeft();
        this.f1660m.right = (i4 - i2) - getPaddingRight();
        this.f1660m.top = getPaddingTop();
        this.f1660m.bottom = (i5 - i3) - getPaddingBottom();
        Gravity.apply(BadgeDrawable.r, measuredWidth, measuredHeight, this.f1660m, this.n);
        RecyclerView recyclerView = this.f1657j;
        Rect rect = this.n;
        recyclerView.layout(rect.left, rect.top, rect.right, rect.bottom);
        if (this.f1656i) {
            a();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        measureChild(this.f1657j, i2, i3);
        int measuredWidth = this.f1657j.getMeasuredWidth();
        int measuredHeight = this.f1657j.getMeasuredHeight();
        int measuredState = this.f1657j.getMeasuredState();
        int paddingLeft = measuredWidth + getPaddingLeft() + getPaddingRight();
        int paddingTop = measuredHeight + getPaddingTop() + getPaddingBottom();
        setMeasuredDimension(ViewGroup.resolveSizeAndState(Math.max(paddingLeft, getSuggestedMinimumWidth()), i2, measuredState), ViewGroup.resolveSizeAndState(Math.max(paddingTop, getSuggestedMinimumHeight()), i3, measuredState << 16));
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.r = savedState.b;
        this.s = savedState.f1665c;
    }

    @Override // android.view.View
    @Nullable
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.a = this.f1657j.getId();
        int i2 = this.r;
        if (i2 == -1) {
            i2 = this.f1655h;
        }
        savedState.b = i2;
        Parcelable parcelable = this.s;
        if (parcelable != null) {
            savedState.f1665c = parcelable;
        } else {
            RecyclerView.Adapter adapter = this.f1657j.getAdapter();
            if (adapter instanceof StatefulAdapter) {
                savedState.f1665c = ((StatefulAdapter) adapter).saveState();
            }
        }
        return savedState;
    }

    @Override // android.view.ViewGroup
    public void onViewAdded(View view) {
        throw new IllegalStateException(getClass().getSimpleName() + " does not support direct child views");
    }

    @Override // android.view.View
    @RequiresApi(16)
    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        if (this.f1659l.a(i2, bundle)) {
            return this.f1659l.b(i2, bundle);
        }
        return super.performAccessibilityAction(i2, bundle);
    }

    public void registerOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.o.a(onPageChangeCallback);
    }

    public void removeItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration) {
        this.f1657j.removeItemDecoration(itemDecoration);
    }

    public void removeItemDecorationAt(int i2) {
        this.f1657j.removeItemDecorationAt(i2);
    }

    public void requestTransform() {
        if (this.w.a() == null) {
            return;
        }
        double h2 = this.f1658k.h();
        int i2 = (int) h2;
        float f2 = (float) (h2 - i2);
        this.w.onPageScrolled(i2, f2, Math.round(b() * f2));
    }

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        RecyclerView.Adapter adapter2 = this.f1657j.getAdapter();
        this.f1659l.b(adapter2);
        b(adapter2);
        this.f1657j.setAdapter(adapter);
        this.f1655h = 0;
        f();
        this.f1659l.a(adapter);
        a(adapter);
    }

    public void setCurrentItem(int i2) {
        setCurrentItem(i2, true);
    }

    @Override // android.view.View
    @RequiresApi(17)
    public void setLayoutDirection(int i2) {
        super.setLayoutDirection(i2);
        this.f1659l.g();
    }

    public void setOffscreenPageLimit(int i2) {
        if (i2 < 1 && i2 != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.A = i2;
        this.f1657j.requestLayout();
    }

    public void setOnOverScrollListener(final OnOverScrollListener onOverScrollListener) {
        if (onOverScrollListener == null) {
            return;
        }
        registerOnPageChangeCallback(new OnPageChangeCallback() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.5
            public boolean a = false;
            public boolean b = false;

            /* renamed from: c  reason: collision with root package name */
            public boolean f1661c = false;

            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.OnPageChangeCallback
            public void onPageScrollStateChanged(int i2) {
                if (i2 != 0) {
                    if (i2 == 1) {
                        this.f1661c = true;
                        return;
                    } else if (i2 != 2) {
                        return;
                    } else {
                        this.a = false;
                        this.b = false;
                        return;
                    }
                }
                RecyclerView.Adapter adapter = ViewPager2.this.getAdapter();
                if (adapter == null || adapter.getItemCount() <= 1 || !this.f1661c) {
                    return;
                }
                if (1 == ViewPager2.this.getOrientation()) {
                    if (!ViewPager2.this.canScrollVertically(-1)) {
                        if (this.a) {
                            onOverScrollListener.onOverScrollStart();
                        } else {
                            this.a = true;
                        }
                    } else if (!ViewPager2.this.canScrollVertically(1)) {
                        if (this.b) {
                            onOverScrollListener.onOverScrollEnd();
                        } else {
                            this.b = true;
                        }
                    }
                } else if (ViewPager2.this.getOrientation() == 0) {
                    if (!ViewPager2.this.canScrollHorizontally(-1)) {
                        if (this.a) {
                            onOverScrollListener.onOverScrollStart();
                        } else {
                            this.a = true;
                        }
                    } else if (!ViewPager2.this.canScrollHorizontally(1)) {
                        if (this.b) {
                            onOverScrollListener.onOverScrollEnd();
                        } else {
                            this.b = true;
                        }
                    }
                }
                this.f1661c = false;
            }
        });
    }

    public void setOrientation(int i2) {
        this.q.setOrientation(i2);
        this.f1659l.d();
    }

    public void setPageTransformer(@Nullable PageTransformer pageTransformer) {
        if (pageTransformer != null) {
            if (!this.y) {
                this.x = this.f1657j.getItemAnimator();
                this.y = true;
            }
            this.f1657j.setItemAnimator(null);
        } else if (this.y) {
            this.f1657j.setItemAnimator(this.x);
            this.x = null;
            this.y = false;
        }
        if (pageTransformer == this.w.a()) {
            return;
        }
        this.w.a(pageTransformer);
        requestTransform();
    }

    public void setUserInputEnabled(boolean z) {
        this.z = z;
        this.f1659l.f();
    }

    public void unregisterOnPageChangeCallback(@NonNull OnPageChangeCallback onPageChangeCallback) {
        this.o.b(onPageChangeCallback);
    }

    /* loaded from: classes.dex */
    public static class SavedState extends View.BaseSavedState {

        /* renamed from: d  reason: collision with root package name */
        public static final Parcelable.Creator<SavedState> f1664d = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.SavedState.1
            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return Build.VERSION.SDK_INT >= 24 ? new SavedState(parcel, classLoader) : new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel, (ClassLoader) null);
            }
        };
        public int a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public Parcelable f1665c;

        @RequiresApi(24)
        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            a(parcel, classLoader);
        }

        private void a(Parcel parcel, ClassLoader classLoader) {
            this.a = parcel.readInt();
            this.b = parcel.readInt();
            this.f1665c = parcel.readParcelable(classLoader);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.a);
            parcel.writeInt(this.b);
            parcel.writeParcelable(this.f1665c, i2);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            a(parcel, null);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    public void addItemDecoration(@NonNull RecyclerView.ItemDecoration itemDecoration, int i2) {
        this.f1657j.addItemDecoration(itemDecoration, i2);
    }

    public int b() {
        int height;
        int paddingBottom;
        RecyclerView recyclerView = this.f1657j;
        if (getOrientation() == 0) {
            height = recyclerView.getWidth() - recyclerView.getPaddingLeft();
            paddingBottom = recyclerView.getPaddingRight();
        } else {
            height = recyclerView.getHeight() - recyclerView.getPaddingTop();
            paddingBottom = recyclerView.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public void setCurrentItem(int i2, boolean z) {
        if (!isFakeDragging()) {
            a(i2, z);
            return;
        }
        throw new IllegalStateException("Cannot change current item when ViewPager2 is fake dragging");
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1660m = new Rect();
        this.n = new Rect();
        this.o = new CompositeOnPageChangeCallback(3);
        this.f1656i = false;
        this.p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f1656i = true;
                viewPager2.f1658k.a();
            }
        };
        this.r = -1;
        this.x = null;
        this.y = false;
        this.z = true;
        this.A = -1;
        a(context, attributeSet);
    }

    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f1660m = new Rect();
        this.n = new Rect();
        this.o = new CompositeOnPageChangeCallback(3);
        this.f1656i = false;
        this.p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f1656i = true;
                viewPager2.f1658k.a();
            }
        };
        this.r = -1;
        this.x = null;
        this.y = false;
        this.z = true;
        this.A = -1;
        a(context, attributeSet);
    }

    private void a(@Nullable RecyclerView.Adapter<?> adapter) {
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.p);
        }
    }

    public void a() {
        PagerSnapHelper pagerSnapHelper = this.t;
        if (pagerSnapHelper != null) {
            View findSnapView = pagerSnapHelper.findSnapView(this.q);
            if (findSnapView == null) {
                return;
            }
            int position = this.q.getPosition(findSnapView);
            if (position != this.f1655h && getScrollState() == 0) {
                this.u.onPageSelected(position);
            }
            this.f1656i = false;
            return;
        }
        throw new IllegalStateException("Design assumption violated.");
    }

    public void a(int i2, boolean z) {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter == null) {
            if (this.r != -1) {
                this.r = Math.max(i2, 0);
            }
        } else if (adapter.getItemCount() <= 0) {
        } else {
            int min = Math.min(Math.max(i2, 0), adapter.getItemCount() - 1);
            if (min == this.f1655h && this.f1658k.e()) {
                return;
            }
            int i3 = this.f1655h;
            if (min == i3 && z) {
                return;
            }
            double d2 = i3;
            this.f1655h = min;
            this.f1659l.e();
            if (!this.f1658k.e()) {
                d2 = this.f1658k.h();
            }
            this.f1658k.a(min, z);
            if (!z) {
                this.f1657j.scrollToPosition(min);
                return;
            }
            double d3 = min;
            if (Math.abs(d3 - d2) > 3.0d) {
                this.f1657j.scrollToPosition(d3 > d2 ? min - 3 : min + 3);
                RecyclerView recyclerView = this.f1657j;
                recyclerView.post(new SmoothScrollToPosition(min, recyclerView));
                return;
            }
            this.f1657j.smoothScrollToPosition(min);
        }
    }

    @RequiresApi(21)
    public ViewPager2(@NonNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        this.f1660m = new Rect();
        this.n = new Rect();
        this.o = new CompositeOnPageChangeCallback(3);
        this.f1656i = false;
        this.p = new DataSetChangeObserver() { // from class: com.baidu.mobads.sdk.internal.widget.ViewPager2.1
            @Override // com.baidu.mobads.sdk.internal.widget.ViewPager2.DataSetChangeObserver, androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                ViewPager2 viewPager2 = ViewPager2.this;
                viewPager2.f1656i = true;
                viewPager2.f1658k.a();
            }
        };
        this.r = -1;
        this.x = null;
        this.y = false;
        this.z = true;
        this.A = -1;
        a(context, attributeSet);
    }
}
