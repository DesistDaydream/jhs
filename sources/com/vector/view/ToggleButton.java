package com.vector.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.LinearInterpolator;
import androidx.core.view.ViewCompat;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.vector.R;
import com.vector.view.ToggleButton;
import e.j.a.b.c.r.c0;
import e.t.l.g;
import h.k2.h;
import h.k2.u.p;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 M2\u00020\u0001:\u0001MB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010<\u001a\u00020/2\u0006\u0010!\u001a\u00020\"H\u0002J\b\u0010=\u001a\u00020/H\u0002J \u0010>\u001a\u00020/2\u0006\u0010?\u001a\u00020\"2\u0006\u0010@\u001a\u00020\"2\u0006\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020/2\u0006\u0010D\u001a\u00020EH\u0014J\u0018\u0010F\u001a\u00020/2\u0006\u0010G\u001a\u00020\f2\u0006\u0010H\u001a\u00020\fH\u0014J$\u0010I\u001a\u00020/2\u0006\u0010J\u001a\u00020$2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010K\u001a\u00020$H\u0007J\u0006\u0010L\u001a\u00020/R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010&\u001a\u00020$2\u0006\u0010%\u001a\u00020$@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000RT\u0010)\u001a<\u0012\u0015\u0012\u0013\u0018\u00010\u0001¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(-\u0012\u0013\u0012\u00110$¢\u0006\f\b+\u0012\b\b,\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020/\u0018\u00010*j\u0004\u0018\u0001`0X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b7\u0010\u0013\u001a\u0004\b6\u0010\u0011R\u000e\u00108\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006N"}, d2 = {"Lcom/vector/view/ToggleButton;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "animListener", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "getAnimListener", "()Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "circleCenterX", "", "circleCenterY", "circleEdgeP", "Landroid/graphics/Paint;", "getCircleEdgeP", "()Landroid/graphics/Paint;", "circleEdgeP$delegate", "Lkotlin/Lazy;", "colorCheck", "colorUnCheck", "currView", "edgePath", "Landroid/graphics/Path;", "edgeRectF", "Landroid/graphics/RectF;", "edgeStrokeWidth", "endListener", "Landroid/animation/Animator$AnimatorListener;", "getEndListener", "()Landroid/animation/Animator$AnimatorListener;", "h", "interpolation", "", "isCallBack", "", "<set-?>", "isChecked", "()Z", "isMoving", c0.a.a, "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "view", "checked", "", "Lcom/vector/view/OnToggleButtonCheckedChanged;", "getListener", "()Lkotlin/jvm/functions/Function2;", "setListener", "(Lkotlin/jvm/functions/Function2;)V", "paint", "getPaint", "paint$delegate", "radius", "rectF", "rectPath", IAdInterListener.AdReqParam.WIDTH, "computeCenter", "init", "nativeStart", "from", "to", "duration", "", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setToggleState", "check", "smooth", "stop", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ToggleButton extends View {
    private static final long v = 100;
    @d
    private Path a;
    @d
    private Path b;
    @e

    /* renamed from: c */
    private RectF f7949c;
    @e

    /* renamed from: d */
    private RectF f7950d;

    /* renamed from: e */
    private int f7951e;
    @d

    /* renamed from: f */
    private final w f7952f;
    @d

    /* renamed from: g */
    private final w f7953g;

    /* renamed from: h */
    private int f7954h;

    /* renamed from: i */
    private int f7955i;

    /* renamed from: j */
    private int f7956j;

    /* renamed from: k */
    private boolean f7957k;

    /* renamed from: l */
    private boolean f7958l;

    /* renamed from: m */
    private boolean f7959m;
    private float n;
    private int o;
    private int p;
    @e
    private View q;
    @e
    private p<? super View, ? super Boolean, t1> r;
    private final int s;
    private final int t;
    @d
    public static final a u = new a(null);
    private static final int w = Color.parseColor("#377bee");
    private static final int x = Color.parseColor("#99999a");

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/vector/view/ToggleButton$Companion;", "", "()V", "DEFAULT_COLOR_CHECK", "", "DEFAULT_COLOR_NO_CHECK", "DURATION", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/vector/view/ToggleButton$endListener$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animator", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b implements Animator.AnimatorListener {
        public b() {
            ToggleButton.this = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@d Animator animator) {
            p<View, Boolean, t1> listener;
            ToggleButton.this.B();
            if (!ToggleButton.this.f7959m || (listener = ToggleButton.this.getListener()) == null) {
                return;
            }
            listener.invoke(ToggleButton.this.q, Boolean.valueOf(ToggleButton.this.v()));
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@d Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(@d Animator animator) {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/vector/ext/view/ViewKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        /* renamed from: c */
        public final /* synthetic */ ViewTreeObserver f7960c;

        /* renamed from: d */
        public final /* synthetic */ ToggleButton f7961d;

        public c(View view, boolean z, ViewTreeObserver viewTreeObserver, ToggleButton toggleButton) {
            this.a = view;
            this.b = z;
            this.f7960c = viewTreeObserver;
            this.f7961d = toggleButton;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ToggleButton toggleButton = this.f7961d;
            toggleButton.f7956j = toggleButton.p / 2;
            ToggleButton toggleButton2 = this.f7961d;
            toggleButton2.f7954h = toggleButton2.f7956j;
            ToggleButton toggleButton3 = this.f7961d;
            toggleButton3.t(toggleButton3.n);
            this.f7961d.f7949c = new RectF(this.f7961d.f7951e, this.f7961d.f7951e, this.f7961d.o - this.f7961d.f7951e, this.f7961d.p - this.f7961d.f7951e);
            RectF rectF = this.f7961d.f7949c;
            if (rectF != null) {
                this.f7961d.a.addRoundRect(rectF, this.f7961d.f7954h - (this.f7961d.f7951e / 2), this.f7961d.f7954h - (this.f7961d.f7951e / 2), Path.Direction.CCW);
            }
            this.f7961d.f7950d = new RectF(0.0f, 0.0f, this.f7961d.o, this.f7961d.p);
            RectF rectF2 = this.f7961d.f7950d;
            if (rectF2 != null) {
                this.f7961d.b.addRoundRect(rectF2, this.f7961d.f7954h, this.f7961d.f7954h, Path.Direction.CCW);
            }
            if (this.b) {
                return true;
            }
            if (this.f7960c.isAlive()) {
                this.f7960c.removeOnPreDrawListener(this);
                return true;
            }
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public ToggleButton(@d Context context, @d AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Path();
        this.b = new Path();
        this.f7951e = e.t.o.d.a.a(context).d(1);
        this.f7952f = z.c(ToggleButton$paint$2.INSTANCE);
        this.f7953g = z.c(new ToggleButton$circleEdgeP$2(this));
        this.f7959m = true;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ToggleButton);
        this.s = obtainStyledAttributes.getColor(R.styleable.ToggleButton_toggle_colorCheck, w);
        this.t = obtainStyledAttributes.getColor(R.styleable.ToggleButton_toggle_colorUnCheck, x);
        obtainStyledAttributes.recycle();
        u();
    }

    public static /* synthetic */ void A(ToggleButton toggleButton, boolean z, boolean z2, boolean z3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = true;
        }
        if ((i2 & 4) != 0) {
            z3 = true;
        }
        toggleButton.z(z, z2, z3);
    }

    public static final void a(ToggleButton toggleButton, ValueAnimator valueAnimator) {
        Object animatedValue = valueAnimator == null ? null : valueAnimator.getAnimatedValue();
        Objects.requireNonNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        toggleButton.n = ((Float) animatedValue).floatValue();
        ViewCompat.postInvalidateOnAnimation(toggleButton);
    }

    private final ValueAnimator.AnimatorUpdateListener getAnimListener() {
        return new ValueAnimator.AnimatorUpdateListener() { // from class: e.t.v.c
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ToggleButton.w(ToggleButton.this, valueAnimator);
            }
        };
    }

    private final Paint getCircleEdgeP() {
        return (Paint) this.f7953g.getValue();
    }

    private final Animator.AnimatorListener getEndListener() {
        return new b();
    }

    private final Paint getPaint() {
        return (Paint) this.f7952f.getValue();
    }

    public final void t(float f2) {
        int i2 = this.f7954h;
        this.f7955i = i2 + ((int) ((this.o - (i2 * 2)) * f2));
    }

    private final void u() {
        if (isInEditMode()) {
            return;
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new c(this, false, viewTreeObserver, this));
        }
        setWillNotDraw(false);
    }

    public static /* synthetic */ void w(ToggleButton toggleButton, ValueAnimator valueAnimator) {
        a(toggleButton, valueAnimator);
    }

    private final void x(float f2, float f3, long j2) {
        ValueAnimator a2 = e.t.u.b.a.a(f2, f3, j2);
        a2.setInterpolator(new LinearInterpolator());
        a2.addUpdateListener(getAnimListener());
        a2.addListener(getEndListener());
        a2.start();
    }

    public final void B() {
        this.f7958l = false;
        this.f7957k = !this.f7957k;
    }

    @e
    public final p<View, Boolean, t1> getListener() {
        return this.r;
    }

    @Override // android.view.View
    public void onDraw(@d Canvas canvas) {
        if (this.o == 0 || this.p == 0) {
            return;
        }
        g.c(canvas);
        canvas.drawPath(this.b, getCircleEdgeP());
        getPaint().setColor(this.s);
        canvas.drawPath(this.a, getPaint());
        t(this.n);
        int save = canvas.save();
        canvas.clipRect(this.f7955i, 0, this.o, this.p);
        float f2 = this.n;
        canvas.scale(1.0f - f2, 1.0f - f2, this.o / 2.0f, this.f7956j);
        getPaint().setColor(-1);
        canvas.drawPath(this.a, getPaint());
        canvas.restoreToCount(save);
        canvas.drawCircle(this.f7955i, this.f7956j, this.f7954h, getCircleEdgeP());
        getPaint().setColor(-1);
        canvas.drawCircle(this.f7955i, this.f7956j, this.f7954h - getCircleEdgeP().getStrokeWidth(), getPaint());
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.o = getMeasuredWidth();
        this.p = getMeasuredHeight();
    }

    public final void setListener(@e p<? super View, ? super Boolean, t1> pVar) {
        this.r = pVar;
    }

    @h
    public final void setToggleState(boolean z) {
        A(this, z, false, false, 6, null);
    }

    public final boolean v() {
        return this.f7957k;
    }

    @h
    public final void y(boolean z, boolean z2) {
        A(this, z, z2, false, 4, null);
    }

    @h
    public final void z(boolean z, boolean z2, boolean z3) {
        if (this.f7958l) {
            return;
        }
        this.f7957k = !z;
        this.f7959m = z2;
        this.f7958l = true;
        if (z) {
            getCircleEdgeP().setColor(this.s);
            this.n = 1.0f;
            x(0.0f, 1.0f, z3 ? 100L : 0L);
            return;
        }
        getCircleEdgeP().setColor(this.t);
        this.n = 0.0f;
        x(1.0f, 0.0f, z3 ? 100L : 0L);
    }
}
