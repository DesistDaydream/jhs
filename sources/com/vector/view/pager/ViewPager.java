package com.vector.view.pager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qiniu.android.collect.ReportItem;
import com.umeng.analytics.pro.am;
import e.j.a.b.c.f;
import h.k2.h;
import h.k2.u.l;
import h.k2.u.q;
import h.k2.v.u;
import h.t1;
import java.lang.reflect.Field;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0016\u0018\u0000 L2\u00020\u0001:\u0003LMNB\u001b\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J#\u00103\u001a\u0002042\u001b\u00105\u001a\u0017\u0012\b\u0012\u000607R\u00020\u0000\u0012\u0004\u0012\u00020406¢\u0006\u0002\b8J\u0010\u00109\u001a\u00020\u00102\u0006\u0010:\u001a\u00020;H\u0016J\b\u0010<\u001a\u00020\bH\u0016J\b\u0010=\u001a\u000204H\u0014J\b\u0010>\u001a\u000204H\u0014J\u0010\u0010?\u001a\u00020\b2\u0006\u0010@\u001a\u00020\bH\u0002J\b\u0010A\u001a\u000204H\u0002J\u0010\u0010B\u001a\u0002042\u0006\u0010C\u001a\u00020\u0016H\u0002J\u000e\u0010D\u001a\u0002042\u0006\u0010E\u001a\u00020\u0010J\u0010\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020\bH\u0016J\u0018\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u0010H\u0016J\u000e\u0010H\u001a\u0002042\u0006\u0010I\u001a\u00020\bJ\b\u0010J\u001a\u000204H\u0002J\u000e\u0010J\u001a\u0002042\u0006\u0010C\u001a\u00020\bJ\u0006\u0010K\u001a\u000204R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0012\"\u0004\b\u001c\u0010\u0014R\u000e\u0010\u001d\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\u001a\u0010!\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0012\"\u0004\b\"\u0010\u0014R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010$\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0012\"\u0004\b%\u0010\u0014R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000'X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020+X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010,\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\n\"\u0004\b.\u0010\fR\u001a\u0010/\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0012\"\u0004\b1\u0010\u0014R\u000e\u00102\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O"}, d2 = {"Lcom/vector/view/pager/ViewPager;", "Lcom/vector/view/pager/ScrollableViewPager;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", HiAnalyticsConstant.HaKey.BI_KEY_DIRECTION, "", "getDirection", "()I", "setDirection", "(I)V", "downX", "", "enableAutoScroll", "", "getEnableAutoScroll", "()Z", "setEnableAutoScroll", "(Z)V", am.aU, "", "getInterval", "()J", "setInterval", "(J)V", "isAttachedWindow", "setAttachedWindow", "isAutoScrolling", "isBorderAnimation", "isCycle", "setCycle", "isRtl", "setRtl", "isStopByTouch", "isStopScrollWhenTouch", "setStopScrollWhenTouch", "scrollHandler", "Lcom/vector/weak/WeakHandler;", "getScrollHandler$annotations", "()V", "scroller", "Lcom/vector/view/pager/ViewPager$SpeedScroller;", "slideBorderMode", "getSlideBorderMode", "setSlideBorderMode", "smoothScroll", "getSmoothScroll", "setSmoothScroll", "touchX", "addOnPageChangeListener", "", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Lcom/vector/view/pager/ViewPager$OnPageChangeListenerBuilder;", "Lkotlin/ExtensionFunctionType;", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getCurrentItem", "onAttachedToWindow", "onDetachedFromWindow", "reverse", "pos", "scrollOnce", "sendScrollMessage", "delayTimeInMills", "setAutoScroll", "enable", "setCurrentItem", "item", "setScrollDuration", "duration", "startAutoScroll", "stopAutoScroll", "Companion", "OnPageChangeListenerBuilder", "SpeedScroller", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class ViewPager extends ScrollableViewPager {
    @d
    public static final a Companion = new a(null);
    public static final long DEFAULT_INTERVAL = 4000;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int SCROLL_WHAT = 0;
    public static final int SLIDE_BORDER_MODE_CYCLE = 1;
    public static final int SLIDE_BORDER_MODE_NONE = 0;
    public static final int SLIDE_BORDER_MODE_TO_PARENT = 2;
    private int direction;
    private float downX;
    private boolean enableAutoScroll;
    private long interval;
    private boolean isAttachedWindow;
    private boolean isAutoScrolling;
    private boolean isBorderAnimation;
    private boolean isCycle;
    private boolean isRtl;
    private boolean isStopByTouch;
    private boolean isStopScrollWhenTouch;
    @d
    private final e.t.w.a<ViewPager> scrollHandler;
    @d
    private final c scroller;
    private int slideBorderMode;
    private boolean smoothScroll;
    private float touchX;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/vector/view/pager/ViewPager$Companion;", "", "()V", "DEFAULT_INTERVAL", "", "LEFT", "", "RIGHT", "SCROLL_WHAT", "SLIDE_BORDER_MODE_CYCLE", "SLIDE_BORDER_MODE_NONE", "SLIDE_BORDER_MODE_TO_PARENT", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\tJ)\u0010\u0003\u001a\u00020\t2!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004JW\u0010\u000b\u001a\u00020\t2O\u0010\u0015\u001aK\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t0\fj\u0002`\u0011J-\u0010\u0012\u001a\u00020\t2%\u0010\u0015\u001a!\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t0\u0004j\u0002`\u0013R1\u0010\u0003\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\nX\u0082\u000e¢\u0006\u0002\n\u0000R[\u0010\u000b\u001aO\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\t\u0018\u00010\fj\u0004\u0018\u0001`\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R1\u0010\u0012\u001a%\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004j\u0004\u0018\u0001`\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/vector/view/pager/ViewPager$OnPageChangeListenerBuilder;", "", "(Lcom/vector/view/pager/ViewPager;)V", "onScrollStateChanged", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "state", "", "Lcom/vector/view/pager/OnPageScrollStateChanged;", "onScrolled", "Lkotlin/Function3;", "position", "", "positionOffset", "positionOffsetPixels", "Lcom/vector/view/pager/OnPageScrolled;", "onSelected", "Lcom/vector/view/pager/OnPageSelected;", "build", ReportItem.LogTypeBlock, "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class b {
        @e
        private l<? super Integer, t1> a;
        @e
        private q<? super Integer, ? super Float, ? super Integer, t1> b;
        @e

        /* renamed from: c  reason: collision with root package name */
        private l<? super Integer, t1> f7973c;

        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"com/vector/view/pager/ViewPager$OnPageChangeListenerBuilder$build$listener$1", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "onPageScrollStateChanged", "", "state", "", "onPageScrolled", "position", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* loaded from: classes3.dex */
        public static final class a implements ViewPager.OnPageChangeListener {
            public final /* synthetic */ ViewPager b;

            public a(ViewPager viewPager) {
                this.b = viewPager;
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i2) {
                l lVar = b.this.a;
                if (lVar == null) {
                    return;
                }
                lVar.invoke(Integer.valueOf(i2));
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i2, float f2, int i3) {
                q qVar = b.this.b;
                if (qVar == null) {
                    return;
                }
                qVar.invoke(Integer.valueOf(i2), Float.valueOf(f2), Integer.valueOf(i3));
            }

            @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
            public void onPageSelected(int i2) {
                l lVar = b.this.f7973c;
                if (lVar == null) {
                    return;
                }
                lVar.invoke(Integer.valueOf(this.b.reverse(i2)));
            }
        }

        public b() {
        }

        public final void d() {
            ViewPager.this.addOnPageChangeListener(new a(ViewPager.this));
        }

        public final void e(@d l<? super Integer, t1> lVar) {
            this.a = lVar;
        }

        public final void f(@d q<? super Integer, ? super Float, ? super Integer, t1> qVar) {
            this.b = qVar;
        }

        public final void g(@d l<? super Integer, t1> lVar) {
            this.f7973c = lVar;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\bJ(\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0016J0\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/vector/view/pager/ViewPager$SpeedScroller;", "Landroid/widget/Scroller;", "context", "Landroid/content/Context;", "interpolator", "Landroid/view/animation/Interpolator;", "(Landroid/content/Context;Landroid/view/animation/Interpolator;)V", "fixedDuration", "", "setDuration", "", f.f10128d, "startScroll", "startX", "startY", "dx", "dy", "duration", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c extends Scroller {
        private int a;

        public /* synthetic */ c(Context context, Interpolator interpolator, int i2, u uVar) {
            this(context, (i2 & 2) != 0 ? null : interpolator);
        }

        public final void a(int i2) {
            this.a = i2;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5, int i6) {
            super.startScroll(i2, i3, i4, i5, this.a);
        }

        public c(@d Context context, @e Interpolator interpolator) {
            super(context, interpolator);
            this.a = 500;
        }

        @Override // android.widget.Scroller
        public void startScroll(int i2, int i3, int i4, int i5) {
            super.startScroll(i2, i3, i4, i5, this.a);
        }
    }

    @h
    public ViewPager(@d Context context) {
        this(context, null, 2, null);
    }

    public /* synthetic */ ViewPager(Context context, AttributeSet attributeSet, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet);
    }

    private static /* synthetic */ void getScrollHandler$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int reverse(int i2) {
        PagerAdapter adapter;
        return (!this.isRtl || (adapter = getAdapter()) == null) ? i2 : (adapter.getCount() - i2) - 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void scrollOnce() {
        PagerAdapter adapter = getAdapter();
        int currentItem = getCurrentItem();
        int count = adapter == null ? 0 : adapter.getCount();
        if (adapter == null || count <= 1) {
            return;
        }
        int i2 = this.direction == 0 ? currentItem - 1 : currentItem + 1;
        if (i2 < 0) {
            if (this.isCycle) {
                setCurrentItem(count - 1, this.isBorderAnimation);
            }
        } else if (i2 == count) {
            if (this.isCycle) {
                setCurrentItem(0, this.isBorderAnimation);
            }
        } else {
            setCurrentItem(i2, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sendScrollMessage(long j2) {
        this.scrollHandler.removeMessages(0);
        this.scrollHandler.sendEmptyMessageDelayed(0, j2);
    }

    private final void startAutoScroll() {
        if (this.isAutoScrolling) {
            return;
        }
        this.isAutoScrolling = true;
        sendScrollMessage(this.interval);
    }

    public final void addOnPageChangeListener(@d l<? super b, t1> lVar) {
        b bVar = new b();
        lVar.invoke(bVar);
        bVar.d();
    }

    @Override // com.vector.view.pager.ScrollableViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@d MotionEvent motionEvent) {
        try {
            if (this.isStopScrollWhenTouch) {
                if (motionEvent.getAction() == 0 && this.isAutoScrolling) {
                    this.isStopByTouch = true;
                    stopAutoScroll();
                } else if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && this.isStopByTouch) {
                    startAutoScroll();
                }
            }
            int i2 = this.slideBorderMode;
            if (i2 == 2 || i2 == 1) {
                this.touchX = motionEvent.getX();
                if (motionEvent.getAction() == 0) {
                    this.downX = this.touchX;
                }
                int currentItem = getCurrentItem();
                PagerAdapter adapter = getAdapter();
                int count = adapter == null ? 0 : adapter.getCount();
                if ((currentItem == 0 && this.downX <= this.touchX) || (currentItem == count - 1 && this.downX >= this.touchX)) {
                    if (this.slideBorderMode == 2) {
                        disallowIntercept(false);
                    } else {
                        if (count > 1) {
                            setCurrentItem((count - currentItem) - 1, this.isBorderAnimation);
                        }
                        disallowIntercept(true);
                    }
                    return super.dispatchTouchEvent(motionEvent);
                }
            }
            disallowIntercept(true);
            return super.dispatchTouchEvent(motionEvent);
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public int getCurrentItem() {
        return reverse(super.getCurrentItem());
    }

    public final int getDirection() {
        return this.direction;
    }

    public final boolean getEnableAutoScroll() {
        return this.enableAutoScroll;
    }

    public final long getInterval() {
        return this.interval;
    }

    public final int getSlideBorderMode() {
        return this.slideBorderMode;
    }

    public final boolean getSmoothScroll() {
        return this.smoothScroll;
    }

    public final boolean isAttachedWindow() {
        return this.isAttachedWindow;
    }

    public final boolean isCycle() {
        return this.isCycle;
    }

    public final boolean isRtl() {
        return this.isRtl;
    }

    public final boolean isStopScrollWhenTouch() {
        return this.isStopScrollWhenTouch;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttachedWindow = true;
        if (this.enableAutoScroll) {
            startAutoScroll();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        stopAutoScroll();
    }

    public final void setAttachedWindow(boolean z) {
        this.isAttachedWindow = z;
    }

    public final void setAutoScroll(boolean z) {
        this.enableAutoScroll = z;
        if (z && this.isAttachedWindow) {
            startAutoScroll();
        }
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i2, boolean z) {
        super.setCurrentItem(reverse(i2), z);
    }

    public final void setCycle(boolean z) {
        this.isCycle = z;
    }

    public final void setDirection(int i2) {
        this.direction = i2;
    }

    public final void setEnableAutoScroll(boolean z) {
        this.enableAutoScroll = z;
    }

    public final void setInterval(long j2) {
        this.interval = j2;
    }

    public final void setRtl(boolean z) {
        this.isRtl = z;
    }

    public final void setScrollDuration(int i2) {
        this.scroller.a(i2);
    }

    public final void setSlideBorderMode(int i2) {
        this.slideBorderMode = i2;
    }

    public final void setSmoothScroll(boolean z) {
        this.smoothScroll = z;
    }

    public final void setStopScrollWhenTouch(boolean z) {
        this.isStopScrollWhenTouch = z;
    }

    public final void stopAutoScroll() {
        if (this.isAutoScrolling) {
            this.isAutoScrolling = false;
            this.scrollHandler.removeMessages(0);
        }
    }

    @h
    public ViewPager(@d Context context, @e AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interval = DEFAULT_INTERVAL;
        this.direction = 1;
        this.isCycle = true;
        this.isStopScrollWhenTouch = true;
        this.scrollHandler = new e.t.w.a<>(this, new ViewPager$scrollHandler$1(this));
        c cVar = new c(context, new DecelerateInterpolator());
        Field declaredField = androidx.viewpager.widget.ViewPager.class.getDeclaredField("mScroller");
        declaredField.setAccessible(true);
        declaredField.set(this, cVar);
        t1 t1Var = t1.a;
        this.scroller = cVar;
        this.smoothScroll = true;
    }

    @Override // androidx.viewpager.widget.ViewPager
    public void setCurrentItem(int i2) {
        super.setCurrentItem(reverse(i2));
    }

    public final void startAutoScroll(int i2) {
        if (this.isAutoScrolling) {
            return;
        }
        this.isAutoScrolling = true;
        sendScrollMessage(i2);
    }
}
