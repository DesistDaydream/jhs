package com.vector.view.pager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import androidx.viewpager.widget.PagerAdapter;
import e.t.v.h.d.c;
import h.k2.h;
import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001B\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0013J\u0010\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\nJ\u000e\u0010\"\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\u001cJ\u0010\u0010$\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u001fH\u0016J\u0010\u0010&\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\u001fH\u0017R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/vector/view/pager/ScrollableViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "TAG", "", "downX", "", "downY", "indicator", "Lcom/vector/view/pager/indicator/PageIndicator;", "getIndicator", "()Lcom/vector/view/pager/indicator/PageIndicator;", "setIndicator", "(Lcom/vector/view/pager/indicator/PageIndicator;)V", "isInterceptEvent", "", "()Z", "setInterceptEvent", "(Z)V", "isScrollable", "setScrollable", "touchSlop", "", "disallowIntercept", "", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "isBackward", "x", "isForward", "notifyDataSetChanged", "onInterceptTouchEvent", "event", "onTouchEvent", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class ScrollableViewPager extends androidx.viewpager.widget.ViewPager {
    @d
    private final String TAG;
    private float downX;
    private float downY;
    @e
    private c indicator;
    private boolean isInterceptEvent;
    private boolean isScrollable;
    private final int touchSlop;

    @h
    public ScrollableViewPager(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ ScrollableViewPager(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    public final void disallowIntercept(boolean z) {
        if (this.isInterceptEvent) {
            getParent().requestDisallowInterceptTouchEvent(z);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@d MotionEvent motionEvent) {
        try {
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action != 1) {
                    if (action == 2) {
                        float abs = Math.abs(motionEvent.getX() - this.downX);
                        float abs2 = Math.abs(motionEvent.getY() - this.downY);
                        if (abs > abs2) {
                            PagerAdapter adapter = getAdapter();
                            int count = adapter == null ? 0 : adapter.getCount();
                            if (count != 0 && count != 1) {
                                int currentItem = getCurrentItem();
                                if (currentItem == 0) {
                                    if (isForward(motionEvent.getX())) {
                                        disallowIntercept(false);
                                    } else {
                                        disallowIntercept(true);
                                    }
                                } else if (currentItem == count - 1) {
                                    if (isBackward(motionEvent.getX())) {
                                        disallowIntercept(false);
                                    } else {
                                        disallowIntercept(true);
                                    }
                                } else if (abs >= this.touchSlop) {
                                    disallowIntercept(true);
                                }
                            } else {
                                disallowIntercept(false);
                                return super.dispatchTouchEvent(motionEvent);
                            }
                        } else if (abs2 >= this.touchSlop) {
                            disallowIntercept(false);
                        }
                    } else if (action != 3) {
                    }
                }
                disallowIntercept(false);
            } else {
                this.downX = motionEvent.getX();
                this.downY = motionEvent.getY();
                disallowIntercept(true);
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            Log.e(this.TAG, f0.C("dispatchTouchEvent error:", e2.getMessage()));
            return false;
        }
    }

    @e
    public final c getIndicator() {
        return this.indicator;
    }

    public final boolean isBackward(float f2) {
        return f2 - this.downX <= ((float) (-this.touchSlop));
    }

    public final boolean isForward(float f2) {
        return f2 - this.downX >= ((float) this.touchSlop);
    }

    public final boolean isInterceptEvent() {
        return this.isInterceptEvent;
    }

    public final boolean isScrollable() {
        return this.isScrollable;
    }

    public final void notifyDataSetChanged() {
        PagerAdapter adapter = getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
        c cVar = this.indicator;
        if (cVar == null) {
            return;
        }
        cVar.e();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(@d MotionEvent motionEvent) {
        try {
            if (this.isScrollable) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@d MotionEvent motionEvent) {
        try {
            if (this.isScrollable) {
                return super.onTouchEvent(motionEvent);
            }
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void setIndicator(@e c cVar) {
        this.indicator = cVar;
    }

    public final void setInterceptEvent(boolean z) {
        this.isInterceptEvent = z;
    }

    public final void setScrollable(boolean z) {
        this.isScrollable = z;
    }

    @h
    public ScrollableViewPager(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.TAG = "ScrollableViewPager";
        this.isScrollable = true;
        this.isInterceptEvent = true;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        if (getId() == -1) {
            setId(ViewCompat.generateViewId());
        }
    }
}
