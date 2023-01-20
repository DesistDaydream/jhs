package com.jihuanshe.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;
import androidx.databinding.ObservableInt;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.SeekBarView;
import e.t.o.d;
import h.k2.h;
import h.k2.v.u;

/* loaded from: classes2.dex */
public final class SeekBarView extends View {
    @k.e.a.d
    public static final a K = new a(null);
    @k.e.a.d
    public static final String L = "SeekBarView";
    private static final int M = 40;
    @k.e.a.d
    private final RectF A;
    @k.e.a.d
    private final RectF B;
    @k.e.a.d
    private final RectF C;
    private int D;
    @k.e.a.e
    private b E;
    @k.e.a.e
    private d F;
    @k.e.a.e
    private c G;
    private float H;
    private float I;
    private long J;
    private final int a;
    private final int b;
    @k.e.a.d

    /* renamed from: c */
    private final Paint f4216c;

    /* renamed from: d */
    private int f4217d;

    /* renamed from: e */
    private int f4218e;
    @ColorInt

    /* renamed from: f */
    private int f4219f;

    /* renamed from: g */
    private float f4220g;
    @ColorInt

    /* renamed from: h */
    private int f4221h;

    /* renamed from: i */
    private float f4222i;
    @ColorInt

    /* renamed from: j */
    private int f4223j;

    /* renamed from: k */
    private float f4224k;
    @ColorInt

    /* renamed from: l */
    private int f4225l;

    /* renamed from: m */
    private int f4226m;
    @k.e.a.d
    private ObservableInt n;
    private float o;
    private float p;
    @ColorInt
    private int q;
    private float r;
    @ColorInt
    private int s;
    @ColorInt
    private int t;
    private float u;
    private boolean v;
    private float w;
    private float x;
    private boolean y;
    @k.e.a.d
    private ObjectAnimator z;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public interface b extends d, c {
    }

    /* loaded from: classes2.dex */
    public interface c {
        void a(int i2);
    }

    /* loaded from: classes2.dex */
    public interface d {
        void onProgress(int i2);
    }

    /* loaded from: classes2.dex */
    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ ObjectAnimator a;

        public e(ObjectAnimator objectAnimator) {
            this.a = objectAnimator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@k.e.a.d Animator animator) {
            this.a.removeAllListeners();
        }
    }

    @h
    public SeekBarView(@k.e.a.e Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public SeekBarView(@k.e.a.e Context context, @k.e.a.e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @h
    public SeekBarView(@k.e.a.e Context context, @k.e.a.e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = 10;
        this.b = -7829368;
        Paint paint = new Paint();
        this.f4216c = paint;
        this.f4218e = 100;
        this.f4219f = ViewCompat.MEASURED_STATE_MASK;
        d.a aVar = e.t.o.d.a;
        this.f4220g = aVar.a(context).d(4);
        this.f4221h = -1;
        this.f4222i = 3.0f;
        this.f4223j = -16711936;
        this.f4224k = aVar.a(context).d(20);
        this.f4225l = -65536;
        this.n = new ObservableInt(this.f4226m);
        this.o = aVar.a(context).c(6.0f);
        this.p = aVar.a(context).c(10.0f);
        this.q = -7829368;
        this.r = 40.0f;
        this.s = -1;
        this.t = 2110968788;
        this.u = aVar.a(context).c(2.0f);
        this.w = this.o;
        this.D = -7829368;
        paint.setAntiAlias(true);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.SeekBarView, 0, 0);
            this.f4218e = obtainStyledAttributes.getInteger(5, 100);
            this.f4217d = obtainStyledAttributes.getInteger(6, 0);
            this.v = obtainStyledAttributes.getBoolean(4, false);
            this.f4219f = obtainStyledAttributes.getColor(0, ViewCompat.MEASURED_STATE_MASK);
            this.f4220g = obtainStyledAttributes.getDimension(3, this.f4220g);
            this.f4221h = obtainStyledAttributes.getColor(1, -1);
            this.f4222i = obtainStyledAttributes.getDimension(2, 3.0f);
            this.f4223j = obtainStyledAttributes.getColor(8, -16711936);
            this.f4224k = obtainStyledAttributes.getDimension(9, this.f4224k);
            this.f4225l = obtainStyledAttributes.getColor(10, -65536);
            setProgress(obtainStyledAttributes.getInteger(7, 0));
            this.o = obtainStyledAttributes.getDimension(16, this.o);
            this.p = obtainStyledAttributes.getDimension(17, this.p);
            this.q = obtainStyledAttributes.getColor(15, -16776961);
            this.f4223j = obtainStyledAttributes.getColor(8, -16776961);
            this.s = obtainStyledAttributes.getColor(11, -1);
            this.r = obtainStyledAttributes.getDimension(12, 40.0f);
            this.t = obtainStyledAttributes.getColor(13, 2110968788);
            this.u = obtainStyledAttributes.getDimension(14, this.u);
            this.w = this.o;
            this.D = this.q;
            obtainStyledAttributes.recycle();
        }
        this.z = c(false);
        this.A = new RectF();
        this.B = new RectF();
        this.C = new RectF();
    }

    private final void a(MotionEvent motionEvent) {
        this.y = true;
        setProgress((int) b(((int) motionEvent.getRawX()) - getLeft()));
        m();
        invalidate();
        b bVar = this.E;
        if (bVar != null) {
            bVar.onProgress(this.f4226m);
        } else {
            d dVar = this.F;
            if (dVar != null) {
                dVar.onProgress(this.f4226m);
            }
        }
        this.z.cancel();
        ObjectAnimator c2 = c(true);
        this.z = c2;
        c2.start();
    }

    private final float b(int i2) {
        int i3;
        float f2;
        float width;
        float f3;
        if (this.v) {
            int width2 = getWidth() / 2;
            float width3 = (width2 - (getWidth() / 2)) + this.p;
            float width4 = ((getWidth() / 2) + width2) - this.p;
            if (i2 > width2) {
                if (i2 >= width4) {
                    i3 = this.f4218e;
                } else {
                    f2 = (this.f4218e - this.f4217d) * (i2 - width2);
                    width = getWidth() / 2.0f;
                    f3 = this.p;
                    return f2 / (width - f3);
                }
            } else if (i2 >= width2) {
                i3 = this.f4217d;
            } else if (i2 <= width3) {
                i3 = -this.f4218e;
            } else {
                f2 = (this.f4218e - this.f4217d) * (i2 - width2);
                width = getWidth() / 2.0f;
                f3 = this.p;
                return f2 / (width - f3);
            }
        } else {
            float width5 = getWidth() / 2.0f;
            float width6 = (width5 - (getWidth() / 2.0f)) + this.p;
            float width7 = (width5 + (getWidth() / 2.0f)) - this.p;
            float f4 = i2;
            if (f4 >= width7) {
                i3 = this.f4218e;
            } else if (f4 <= width6) {
                i3 = this.f4217d;
            } else {
                return ((this.f4218e - this.f4217d) * (f4 - width6)) / (width7 - width6);
            }
        }
        return i3;
    }

    private final ObjectAnimator c(boolean z) {
        float[] fArr = new float[2];
        fArr[0] = this.w;
        fArr[1] = z ? this.p : this.o;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "mThumbRadius", fArr);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: e.l.q.c.c0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                SeekBarView.f(SeekBarView.this, valueAnimator);
            }
        });
        ofFloat.addListener(new e(ofFloat));
        ofFloat.setInterpolator(new AccelerateInterpolator());
        return ofFloat;
    }

    public static final void d(SeekBarView seekBarView, ValueAnimator valueAnimator) {
        seekBarView.postInvalidate();
    }

    private final boolean e(MotionEvent motionEvent) {
        float left = this.x + getLeft();
        float f2 = 40;
        this.y = motionEvent.getRawX() > left - f2 && motionEvent.getRawX() < left + f2;
        e.l.h.k.b.a.a(L, "isTouchLegal " + this.y + ' ' + motionEvent.getRawX() + ' ' + motionEvent.getRawY() + ' ' + this.x);
        return this.y;
    }

    public static /* synthetic */ void f(SeekBarView seekBarView, ValueAnimator valueAnimator) {
        d(seekBarView, valueAnimator);
    }

    private final void m() {
        float f2;
        float measuredWidth;
        if (this.v) {
            f2 = this.H;
            measuredWidth = (int) ((this.f4226m * ((getMeasuredWidth() / 2.0f) - this.p)) / (this.f4218e - this.f4217d));
        } else {
            f2 = this.p;
            measuredWidth = (this.f4226m * (getMeasuredWidth() - (2 * this.p))) / (this.f4218e - this.f4217d);
        }
        this.x = f2 + measuredWidth;
    }

    private final void setProgress(int i2) {
        this.n.set(i2);
        this.f4226m = i2;
    }

    @k.e.a.d
    public final SeekBarView g(boolean z) {
        int i2;
        if (this.v && !z && (i2 = this.f4226m) < 0) {
            setProgress(-i2);
        }
        this.v = z;
        invalidate();
        return this;
    }

    public final float getCenterX() {
        return this.H;
    }

    public final float getCenterY() {
        return this.I;
    }

    public final int getProgress() {
        return this.f4226m;
    }

    @k.e.a.d
    public final ObservableInt getProgressO() {
        return this.n;
    }

    @k.e.a.d
    public final SeekBarView h(@k.e.a.e b bVar) {
        this.E = bVar;
        return this;
    }

    @k.e.a.d
    public final SeekBarView i(@k.e.a.e c cVar) {
        this.G = cVar;
        return this;
    }

    @k.e.a.d
    public final SeekBarView j(@k.e.a.e d dVar) {
        this.F = dVar;
        return this;
    }

    @k.e.a.d
    public final SeekBarView k(int i2) {
        if (this.v) {
            int i3 = this.f4218e;
            if (i2 <= i3 && i2 >= this.f4217d - i3) {
                setProgress(i2);
            } else {
                int i4 = this.f4217d;
                if (i2 < i4 - i3) {
                    setProgress(i4 - i3);
                } else {
                    setProgress(i3);
                }
            }
        } else {
            int i5 = this.f4217d;
            int i6 = this.f4218e;
            boolean z = false;
            if (i2 <= i6 && i5 <= i2) {
                z = true;
            }
            if (z) {
                setProgress(i2);
            } else if (i2 < i5) {
                setProgress(i5);
            } else {
                setProgress(i6);
            }
        }
        m();
        invalidate();
        return this;
    }

    @k.e.a.d
    public final SeekBarView l(boolean z) {
        if (z) {
            setEnabled(true);
            this.D = this.q;
        } else {
            setEnabled(false);
            setProgress(0);
            this.D = this.b;
        }
        invalidate();
        return this;
    }

    @Override // android.view.View
    public void onDraw(@k.e.a.d Canvas canvas) {
        super.onDraw(canvas);
        float f2 = this.p;
        this.f4216c.setColor(this.f4219f);
        this.f4216c.setStyle(Paint.Style.FILL);
        RectF rectF = this.B;
        rectF.left = f2;
        float f3 = 2;
        rectF.top = this.I - (this.f4220g / f3);
        rectF.right = getWidth() - this.p;
        RectF rectF2 = this.B;
        rectF2.bottom = this.I + (this.f4220g / f3);
        float f4 = this.u;
        canvas.drawRoundRect(rectF2, f4, f4, this.f4216c);
        this.f4216c.setStyle(Paint.Style.FILL);
        this.f4216c.setColor(this.f4223j);
        this.f4216c.setColor(this.f4223j);
        if (this.v) {
            f2 = this.H;
        }
        RectF rectF3 = this.C;
        float f5 = this.I;
        float f6 = this.f4220g;
        rectF3.top = f5 - (f6 / f3);
        rectF3.bottom = f5 + (f6 / f3);
        if (this.f4226m > 0) {
            rectF3.left = f2;
            rectF3.right = this.x;
        } else {
            rectF3.left = this.x;
            rectF3.right = f2;
        }
        float f7 = this.u;
        canvas.drawRoundRect(rectF3, f7, f7, this.f4216c);
        this.f4216c.setColor(this.D);
        canvas.drawCircle(this.x, this.I, this.w, this.f4216c);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        this.H = getMeasuredWidth() / 2.0f;
        this.I = getMeasuredHeight() / 2.0f;
        m();
    }

    @Override // android.view.View
    public boolean onTouchEvent(@k.e.a.d MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                a(motionEvent);
            } else if (action != 1) {
                if (action == 2 && this.y) {
                    setProgress((int) b(((int) motionEvent.getRawX()) - getLeft()));
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - this.J < 50) {
                        return true;
                    }
                    this.J = currentTimeMillis;
                    m();
                    invalidate();
                    b bVar = this.E;
                    if (bVar != null) {
                        bVar.onProgress(this.f4226m);
                    } else {
                        d dVar = this.F;
                        if (dVar != null) {
                            dVar.onProgress(this.f4226m);
                        }
                    }
                }
            } else {
                invalidate();
                if (this.y) {
                    this.z.cancel();
                    ObjectAnimator c2 = c(false);
                    this.z = c2;
                    c2.start();
                    b bVar2 = this.E;
                    if (bVar2 != null) {
                        bVar2.a(this.f4226m);
                    } else {
                        c cVar = this.G;
                        if (cVar != null) {
                            cVar.a(this.f4226m);
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final void setCenterX(float f2) {
        this.H = f2;
    }

    public final void setCenterY(float f2) {
        this.I = f2;
    }

    public final void setMThumbRadius(float f2) {
        this.w = f2;
    }

    public final void setProgressColor(@ColorInt int i2) {
        this.f4223j = i2;
        this.f4216c.setColor(this.f4219f);
    }

    public final void setProgressO(@k.e.a.d ObservableInt observableInt) {
        this.n = observableInt;
    }

    public final void setThumbColor(@ColorInt int i2) {
        this.q = i2;
        this.D = i2;
    }

    public /* synthetic */ SeekBarView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }
}
