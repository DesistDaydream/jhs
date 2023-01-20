package com.vector.view.swipe;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.umeng.analytics.pro.am;
import com.vector.design.ui.delegate.SwipeRefresh;
import com.vector.view.swipe.ScrollableExtend;
import com.vector.view.swipe.header.BaseHeader;
import com.vector.view.swipe.header.DefaultHeader;
import e.j.a.b.c.r.c0;
import e.t.u.p;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.u;
import java.util.Objects;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001c*\u0003\u000b\u000e<\b\u0016\u0018\u0000 a2\u00020\u0001:\u0001aB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010@\u001a\u00020AH\u0002J\b\u0010B\u001a\u00020AH\u0002J\b\u0010C\u001a\u00020\u001eH\u0004J\u0018\u0010D\u001a\u00020\u00172\u0006\u0010E\u001a\u00020F2\u0006\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010G\u001a\u00020A2\u0006\u0010H\u001a\u00020\u0017H\u0004J\u0010\u0010I\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020FH\u0016J0\u0010J\u001a\u00020A2\u0006\u0010K\u001a\u00020\u001e2\u0006\u0010L\u001a\u00020\u00072\u0006\u0010M\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u00072\u0006\u0010O\u001a\u00020\u0007H\u0014J\u0018\u0010P\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007H\u0014J\u0010\u0010S\u001a\u00020A2\u0006\u0010E\u001a\u00020FH\u0002J\u0010\u0010T\u001a\u00020\u001e2\u0006\u0010E\u001a\u00020FH\u0017J\b\u0010)\u001a\u00020AH\u0002J&\u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020\u00072\u0006\u0010W\u001a\u00020\u00072\u0006\u0010X\u001a\u00020\u00072\u0006\u0010Y\u001a\u00020\u0007J\u000e\u0010Z\u001a\u00020A2\u0006\u0010[\u001a\u00020\u001eJ\u0018\u0010Z\u001a\u00020A2\u0006\u0010[\u001a\u00020\u001e2\u0006\u0010:\u001a\u00020\u001eH\u0002J\u0018\u0010\\\u001a\u00020A2\u0006\u0010]\u001a\u00020\u00072\u0006\u0010^\u001a\u00020\u001eH\u0002J\u0006\u0010_\u001a\u00020AJ\u0006\u0010`\u001a\u00020AR\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0018\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020&X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010/\u001a\u00020\u001eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u000e\u00101\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u00103\u001a\u00020\u001e2\u0006\u00102\u001a\u00020\u001e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u0010 R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u000e\u0010:\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020<X\u0082\u0004¢\u0006\u0004\n\u0002\u0010=R\u000e\u0010>\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006b"}, d2 = {"Lcom/vector/view/swipe/SwipeRefreshLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "activePointerId", "animateToCorrectPosition", "com/vector/view/swipe/SwipeRefreshLayout$animateToCorrectPosition$1", "Lcom/vector/view/swipe/SwipeRefreshLayout$animateToCorrectPosition$1;", "animateToStartPosition", "com/vector/view/swipe/SwipeRefreshLayout$animateToStartPosition$1", "Lcom/vector/view/swipe/SwipeRefreshLayout$animateToStartPosition$1;", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "currentDragPercent", "", "currentOffsetTop", "getCurrentOffsetTop", "()I", "setCurrentOffsetTop", "(I)V", "enabledRefresh", "", "getEnabledRefresh", "()Z", "setEnabledRefresh", "(Z)V", "from", "fromDragPercent", "header", "Lcom/vector/view/swipe/header/BaseHeader;", "getHeader", "()Lcom/vector/view/swipe/header/BaseHeader;", "setHeader", "(Lcom/vector/view/swipe/header/BaseHeader;)V", "headerInit", "initialMotionY", "interpolator", "Landroid/view/animation/Interpolator;", "isAnimating", "setAnimating", "isBeingDragged", "<set-?>", "isSwipeRefreshing", c0.a.a, "Lcom/vector/design/ui/delegate/SwipeRefresh$Listener;", "getListener", "()Lcom/vector/design/ui/delegate/SwipeRefresh$Listener;", "setListener", "(Lcom/vector/design/ui/delegate/SwipeRefresh$Listener;)V", "notify", "toStartListener", "com/vector/view/swipe/SwipeRefreshLayout$toStartListener$1", "Lcom/vector/view/swipe/SwipeRefreshLayout$toStartListener$1;", "totalDragDistance", "touchSlop", "animateOffsetToCorrectPosition", "", "animateOffsetToStartPosition", "canChildScrollUp", "getMotionEventY", "ev", "Landroid/view/MotionEvent;", "moveToStart", "interpolatedTime", "onInterceptTouchEvent", "onLayout", "changed", NotifyType.LIGHTS, am.aI, "r", "b", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onSecondaryPointerUp", "onTouchEvent", "setRefreshViewPadding", "left", "top", "right", "bottom", "setRefreshing", "refreshing", "setTargetOffsetTop", "offset", "requiresUpdate", "startRefresh", "stopRefresh", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class SwipeRefreshLayout extends LinearLayout {
    public static final int A = 700;
    public static final int B = -1;
    @k.e.a.d
    public static final a v = new a(null);
    public static final int w = 1;
    public static final int x = 60;
    public static final float y = 0.5f;
    public static final float z = 2.0f;
    public View a;
    @k.e.a.d
    private final Interpolator b;

    /* renamed from: c  reason: collision with root package name */
    private final int f8052c;

    /* renamed from: d  reason: collision with root package name */
    private int f8053d;

    /* renamed from: e  reason: collision with root package name */
    public BaseHeader f8054e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f8055f;

    /* renamed from: g  reason: collision with root package name */
    private float f8056g;

    /* renamed from: h  reason: collision with root package name */
    private int f8057h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f8058i;

    /* renamed from: j  reason: collision with root package name */
    private int f8059j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f8060k;

    /* renamed from: l  reason: collision with root package name */
    private float f8061l;

    /* renamed from: m  reason: collision with root package name */
    private int f8062m;
    private float n;
    private boolean o;
    @e
    private SwipeRefresh.b p;
    private boolean q;
    private boolean r;
    @k.e.a.d
    private final c s;
    @k.e.a.d
    private final b t;
    @k.e.a.d
    private final d u;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/view/swipe/SwipeRefreshLayout$Companion;", "", "()V", "DRAG_MAX_DISTANCE_DP", "", "DRAG_RATE", "", "FACTOR", "INVALID_POINTER", "MAX_ANIM_DURATION", "MAX_DRAG_RATE", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/view/swipe/SwipeRefreshLayout$animateToCorrectPosition$1", "Landroid/view/animation/Animation;", "applyTransformation", "", "interpolatedTime", "", am.aI, "Landroid/view/animation/Transformation;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b extends Animation {
        public b() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, @k.e.a.d Transformation transformation) {
            int top = (SwipeRefreshLayout.this.f8062m + ((int) ((SwipeRefreshLayout.this.f8053d - SwipeRefreshLayout.this.f8062m) * f2))) - SwipeRefreshLayout.this.getContentView().getTop();
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            swipeRefreshLayout.f8056g = swipeRefreshLayout.n - ((SwipeRefreshLayout.this.n - 1.0f) * f2);
            SwipeRefreshLayout.this.getHeader().j(SwipeRefreshLayout.this.f8056g, false);
            SwipeRefreshLayout.this.z(top, false);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/vector/view/swipe/SwipeRefreshLayout$animateToStartPosition$1", "Landroid/view/animation/Animation;", "applyTransformation", "", "interpolatedTime", "", am.aI, "Landroid/view/animation/Transformation;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c extends Animation {
        public c() {
        }

        @Override // android.view.animation.Animation
        public void applyTransformation(float f2, @k.e.a.d Transformation transformation) {
            SwipeRefreshLayout.this.u(f2);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/vector/view/swipe/SwipeRefreshLayout$toStartListener$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class d implements Animation.AnimationListener {
        public d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@k.e.a.d Animation animation) {
            SwipeRefreshLayout.this.getHeader().a(ScrollableExtend.State.IDLE);
            SwipeRefreshLayout swipeRefreshLayout = SwipeRefreshLayout.this;
            swipeRefreshLayout.setCurrentOffsetTop(swipeRefreshLayout.getContentView().getTop());
            SwipeRefreshLayout.this.setAnimating(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@k.e.a.d Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@k.e.a.d Animation animation) {
        }
    }

    @h
    public SwipeRefreshLayout(@k.e.a.d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public SwipeRefreshLayout(@k.e.a.d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ SwipeRefreshLayout(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void o() {
        SwipeRefresh.b bVar;
        this.r = true;
        this.f8062m = this.f8057h;
        this.n = this.f8056g;
        this.t.reset();
        this.t.setDuration(700L);
        this.t.setInterpolator(this.b);
        getHeader().clearAnimation();
        getHeader().startAnimation(this.t);
        if (this.f8058i) {
            getHeader().a(ScrollableExtend.State.LOADING);
            if (this.o && (bVar = this.p) != null) {
                bVar.a(SwipeRefresh.State.START);
            }
        } else {
            getHeader().a(ScrollableExtend.State.IDLE);
            p();
        }
        this.f8057h = getContentView().getTop();
    }

    private final void p() {
        this.r = true;
        this.f8062m = this.f8057h;
        float f2 = this.f8056g;
        this.n = f2;
        long abs = Math.abs(700 * f2);
        this.s.reset();
        this.s.setDuration(abs);
        this.s.setInterpolator(this.b);
        this.s.setAnimationListener(this.u);
        getHeader().clearAnimation();
        getHeader().startAnimation(this.s);
    }

    private final float r(MotionEvent motionEvent, int i2) {
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return motionEvent.getY(findPointerIndex);
    }

    private final void v(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f8059j) {
            this.f8059j = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
        }
    }

    private final void w() {
        if (this.f8055f) {
            return;
        }
        if (this.f8054e == null) {
            l<Context, BaseHeader> d2 = e.t.a.c().d();
            BaseHeader invoke = d2 == null ? null : d2.invoke(getContext());
            if (invoke == null) {
                invoke = new DefaultHeader(getContext(), null, 0, 6, null);
            }
            setHeader(invoke);
        }
        addView(getHeader(), 0, p.l(-1, -2));
        this.f8055f = true;
    }

    private final void y(boolean z2, boolean z3) {
        SwipeRefresh.b bVar;
        if (this.f8058i != z2) {
            this.o = z3;
            this.f8058i = z2;
            if (z2) {
                o();
                return;
            }
            p();
            if (!z3 || (bVar = this.p) == null) {
                return;
            }
            bVar.a(SwipeRefresh.State.END);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z(int i2, boolean z2) {
        getContentView().offsetTopAndBottom(i2);
        getHeader().f(i2);
        this.f8057h = getContentView().getTop();
        if (z2) {
            invalidate();
        }
    }

    public final void A() {
        y(true, true);
    }

    public final void B() {
        y(false, true);
    }

    @k.e.a.d
    public final View getContentView() {
        View view = this.a;
        Objects.requireNonNull(view);
        return view;
    }

    public final int getCurrentOffsetTop() {
        return this.f8057h;
    }

    public final boolean getEnabledRefresh() {
        return this.q;
    }

    @k.e.a.d
    public final BaseHeader getHeader() {
        BaseHeader baseHeader = this.f8054e;
        Objects.requireNonNull(baseHeader);
        return baseHeader;
    }

    @e
    public final SwipeRefresh.b getListener() {
        return this.p;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@k.e.a.d MotionEvent motionEvent) {
        try {
            if (this.q && isEnabled() && !this.f8058i && !this.r && !q()) {
                int action = motionEvent.getAction();
                boolean z2 = true;
                if (action != 0) {
                    if (action != 1) {
                        if (action == 2) {
                            int i2 = this.f8059j;
                            if (i2 == -1) {
                                return false;
                            }
                            float r = r(motionEvent, i2);
                            if (r == -1.0f) {
                                return false;
                            }
                            if (r - this.f8061l > this.f8052c && !this.f8060k) {
                                this.f8060k = true;
                            }
                        } else if (action != 3) {
                            if (action == 6) {
                                v(motionEvent);
                            }
                        }
                    }
                    this.f8060k = false;
                    this.f8059j = -1;
                } else {
                    z(0, true);
                    int pointerId = motionEvent.getPointerId(0);
                    this.f8059j = pointerId;
                    this.f8060k = false;
                    float r2 = r(motionEvent, pointerId);
                    if (r2 != -1.0f) {
                        z2 = false;
                    }
                    if (z2) {
                        return false;
                    }
                    this.f8061l = r2;
                }
                return this.f8060k;
            }
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int i6 = (measuredWidth + paddingLeft) - paddingRight;
        int paddingBottom = (measuredHeight + paddingTop) - getPaddingBottom();
        getHeader().layout(paddingLeft, paddingTop, i6, paddingBottom);
        View contentView = getContentView();
        int i7 = this.f8057h;
        contentView.layout(paddingLeft, paddingTop + i7, i6, paddingBottom + i7);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        w();
        getHeader().measure(i2, i3);
        setContentView(getChildAt(1));
        if (!(getContentView() instanceof RecyclerView) && !(getContentView() instanceof ExpandableListView)) {
            throw new IllegalStateException("can not find RecyclerView or ExpandableListView");
        }
        getContentView().measure(i2, i3);
        int size = View.MeasureSpec.getSize(i2);
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            size = getContentView().getMeasuredWidth();
        }
        int size2 = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            size2 = getContentView().getMeasuredHeight();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@k.e.a.d MotionEvent motionEvent) {
        try {
            if (!this.f8060k) {
                return super.onTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action != 1) {
                if (action == 2) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.f8059j);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    float y2 = (motionEvent.getY(findPointerIndex) - this.f8061l) * 0.5f;
                    float f2 = y2 / this.f8053d;
                    this.f8056g = f2;
                    if (f2 < 0.0f) {
                        return false;
                    }
                    float min = Math.min(1.0f, Math.abs(f2));
                    float abs = Math.abs(y2);
                    int i2 = this.f8053d;
                    float f3 = i2;
                    float f4 = 2;
                    double max = Math.max(0.0f, Math.min(abs - i2, f3 * f4) / f3) / 4;
                    int pow = (int) ((f3 * min) + (((((float) (max - Math.pow(max, 2.0d))) * 2.0f) * f3) / f4));
                    getHeader().j(this.f8056g, true);
                    if (this.f8056g >= 1.0f) {
                        getHeader().a(ScrollableExtend.State.READY);
                    } else {
                        getHeader().a(ScrollableExtend.State.IDLE);
                    }
                    z(pow - this.f8057h, true);
                } else if (action != 3) {
                    if (action == 5) {
                        this.f8059j = motionEvent.getPointerId(motionEvent.getActionIndex());
                    } else if (action == 6) {
                        v(motionEvent);
                    }
                }
                return true;
            }
            int i3 = this.f8059j;
            if (i3 == -1) {
                return false;
            }
            this.f8060k = false;
            if ((motionEvent.getY(motionEvent.findPointerIndex(i3)) - this.f8061l) * 0.5f > this.f8053d) {
                y(true, true);
            } else {
                this.f8058i = false;
                p();
            }
            this.f8059j = -1;
            return false;
        } catch (IllegalArgumentException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean q() {
        return getContentView().canScrollVertically(-1);
    }

    public final boolean s() {
        return this.r;
    }

    public final void setAnimating(boolean z2) {
        this.r = z2;
    }

    public final void setContentView(@k.e.a.d View view) {
        this.a = view;
    }

    public final void setCurrentOffsetTop(int i2) {
        this.f8057h = i2;
    }

    public final void setEnabledRefresh(boolean z2) {
        this.q = z2;
    }

    public final void setHeader(@k.e.a.d BaseHeader baseHeader) {
        this.f8054e = baseHeader;
    }

    public final void setListener(@e SwipeRefresh.b bVar) {
        this.p = bVar;
    }

    public final void setRefreshing(boolean z2) {
        if (this.f8058i != z2) {
            y(z2, false);
        }
    }

    public final boolean t() {
        return this.f8058i;
    }

    public final void u(float f2) {
        int i2 = this.f8062m;
        int top = (i2 - ((int) (i2 * f2))) - getContentView().getTop();
        this.f8056g = this.n * (1.0f - f2);
        getHeader().j(this.f8056g, true);
        z(top, false);
    }

    public final void x(int i2, int i3, int i4, int i5) {
        getHeader().setPadding(i2, i3, i4, i5);
    }

    @h
    public SwipeRefreshLayout(@k.e.a.d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.b = new DecelerateInterpolator(2.0f);
        this.f8052c = ViewConfiguration.get(context).getScaledTouchSlop();
        e.t.o.c a2 = e.t.o.d.a.a(context);
        Integer e2 = e.t.a.c().e();
        this.f8053d = a2.d(e2 == null ? 60 : e2.intValue());
        this.s = new c();
        this.t = new b();
        this.u = new d();
        setWillNotDraw(false);
        setChildrenDrawingOrderEnabled(true);
    }
}
