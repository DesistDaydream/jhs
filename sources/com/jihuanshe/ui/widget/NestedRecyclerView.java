package com.jihuanshe.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class NestedRecyclerView extends RecyclerView {
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f4159c;

    /* renamed from: d  reason: collision with root package name */
    private int f4160d;

    public NestedRecyclerView(@NonNull @d Context context) {
        super(context);
        init();
    }

    private final void init() {
        this.f4160d = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@d MotionEvent motionEvent) {
        RecyclerView.LayoutManager layoutManager = getLayoutManager();
        boolean canScrollHorizontally = layoutManager == null ? false : layoutManager.canScrollHorizontally();
        RecyclerView.LayoutManager layoutManager2 = getLayoutManager();
        boolean canScrollVertically = layoutManager2 == null ? false : layoutManager2.canScrollVertically();
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            this.a = motionEvent.getPointerId(0);
            this.b = (int) (motionEvent.getX() + 0.5f);
            this.f4159c = (int) (motionEvent.getY() + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        } else if (actionMasked != 2) {
            if (actionMasked != 5) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.a = motionEvent.getPointerId(actionIndex);
            this.b = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f4159c = (int) (motionEvent.getY(actionIndex) + 0.5f);
            return super.onInterceptTouchEvent(motionEvent);
        } else {
            int findPointerIndex = motionEvent.findPointerIndex(this.a);
            if (findPointerIndex < 0) {
                return false;
            }
            int x = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (getScrollState() != 1) {
                int i2 = x - this.b;
                int i3 = y - this.f4159c;
                boolean z = canScrollHorizontally && Math.abs(i2) > this.f4160d && Math.abs(i2) > Math.abs(i3);
                if (canScrollVertically && Math.abs(i3) > this.f4160d && Math.abs(i3) > Math.abs(i2)) {
                    z = true;
                }
                return z && super.onInterceptTouchEvent(motionEvent);
            }
            return super.onInterceptTouchEvent(motionEvent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setScrollingTouchSlop(int i2) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 == 0) {
            this.f4160d = viewConfiguration.getScaledTouchSlop();
            this.f4160d = viewConfiguration.getScaledPagingTouchSlop();
        } else if (i2 == 1) {
            this.f4160d = viewConfiguration.getScaledPagingTouchSlop();
        }
        super.setScrollingTouchSlop(i2);
    }

    public NestedRecyclerView(@NonNull @d Context context, @Nullable @e AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public NestedRecyclerView(@NonNull @d Context context, @Nullable @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }
}
