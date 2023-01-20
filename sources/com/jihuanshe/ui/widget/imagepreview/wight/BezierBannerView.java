package com.jihuanshe.ui.widget.imagepreview.wight;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.ViewPager;
import com.jihuanshe.R;

/* loaded from: classes2.dex */
public class BezierBannerView extends View implements ViewPager.OnPageChangeListener {
    public static int L = 1;
    public static int M = 2;
    private static final String N = BezierBannerView.class.getName();
    private int A;
    private int B;
    private int C;
    public float D;
    public float E;
    public float F;
    public float G;
    public float H;
    public float I;
    private int J;
    public Interpolator K;
    private Paint a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Path f4295c;

    /* renamed from: d  reason: collision with root package name */
    private Path f4296d;

    /* renamed from: e  reason: collision with root package name */
    private int f4297e;

    /* renamed from: f  reason: collision with root package name */
    private int f4298f;

    /* renamed from: g  reason: collision with root package name */
    private float f4299g;

    /* renamed from: h  reason: collision with root package name */
    private float f4300h;

    /* renamed from: i  reason: collision with root package name */
    private float f4301i;

    /* renamed from: j  reason: collision with root package name */
    private float f4302j;

    /* renamed from: k  reason: collision with root package name */
    private float f4303k;

    /* renamed from: l  reason: collision with root package name */
    private float f4304l;

    /* renamed from: m  reason: collision with root package name */
    private float f4305m;
    public float n;
    public float o;
    public float p;
    public float q;
    public float r;
    public float s;
    public float t;
    public float u;
    private boolean v;
    private float w;
    private float x;
    private float y;
    private int z;

    public BezierBannerView(Context context) {
        this(context, null);
    }

    private float d(int i2) {
        if (i2 == 0) {
            return this.f4300h;
        }
        float f2 = this.f4299g;
        float f3 = this.f4302j;
        return (i2 * (f2 + (2.0f * f3))) + f3 + (this.f4300h - f3);
    }

    private void i() {
        Paint paint = new Paint(1);
        paint.setColor(this.f4297e);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setDither(true);
        this.a = paint;
        Paint paint2 = new Paint(1);
        paint2.setColor(this.f4298f);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setAntiAlias(true);
        paint2.setDither(true);
        this.b = paint2;
    }

    private void j(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BezierBannerView);
        this.f4297e = obtainStyledAttributes.getColor(0, -1);
        this.f4298f = obtainStyledAttributes.getColor(3, -5592406);
        this.f4300h = obtainStyledAttributes.getDimension(1, this.f4300h);
        this.f4302j = obtainStyledAttributes.getDimension(4, this.f4302j);
        this.f4299g = obtainStyledAttributes.getDimension(2, this.f4299g);
        obtainStyledAttributes.recycle();
    }

    private void k() {
        this.f4295c.reset();
        this.f4296d.reset();
        float interpolation = this.K.getInterpolation(this.y);
        this.n = g(d(this.z), d(this.z + 1) - this.f4300h, this.C);
        float f2 = this.f4300h;
        this.o = f2;
        this.f4301i = f(f2, 0.0f, interpolation);
        double radians = Math.toRadians(g(45.0f, 0.0f, this.B));
        float sin = (float) (Math.sin(radians) * this.f4301i);
        float cos = (float) (Math.cos(radians) * this.f4301i);
        this.p = g(d(this.z) + this.f4300h, d(this.z + 1), this.B);
        float f3 = this.f4300h;
        this.q = f3;
        this.f4304l = f(0.0f, f3, interpolation);
        double radians2 = Math.toRadians(g(0.0f, 45.0f, this.C));
        float cos2 = (float) (Math.cos(radians2) * this.f4304l);
        this.F = this.n + sin;
        this.G = this.o - cos;
        this.H = this.p - ((float) (Math.sin(radians2) * this.f4304l));
        this.I = this.f4300h - cos2;
        this.D = h(d(this.z) + this.f4300h, d(this.z + 1) - this.f4300h);
        this.E = this.f4300h;
        this.f4295c.moveTo(this.F, this.G);
        this.f4295c.quadTo(this.D, this.E, this.H, this.I);
        this.f4295c.lineTo(this.H, this.f4300h + cos2);
        this.f4295c.quadTo(this.D, this.f4300h, this.F, this.G + (cos * 2.0f));
        this.f4295c.lineTo(this.F, this.G);
        this.t = g(d(this.z + 1), d(this.z) + this.f4302j, this.C);
        this.u = this.f4300h;
        this.f4303k = f(this.f4302j, 0.0f, interpolation);
        double radians3 = Math.toRadians(g(45.0f, 0.0f, this.B));
        float sin2 = (float) (Math.sin(radians3) * this.f4303k);
        float cos3 = (float) (Math.cos(radians3) * this.f4303k);
        this.r = g(d(this.z + 1) - this.f4302j, d(this.z), this.B);
        this.s = this.f4300h;
        this.f4305m = f(0.0f, this.f4302j, interpolation);
        double radians4 = Math.toRadians(g(0.0f, 45.0f, this.C));
        float sin3 = (float) (Math.sin(radians4) * this.f4305m);
        float cos4 = (float) (Math.cos(radians4) * this.f4305m);
        float f4 = this.t - sin2;
        float f5 = this.u - cos3;
        float f6 = this.r + sin3;
        float h2 = h(d(this.z + 1) - this.f4302j, d(this.z) + this.f4302j);
        float f7 = this.f4300h;
        this.f4296d.moveTo(f4, f5);
        this.f4296d.quadTo(h2, f7, f6, this.s - cos4);
        this.f4296d.lineTo(f6, this.f4300h + cos4);
        this.f4296d.quadTo(h2, f7, f4, (cos3 * 2.0f) + f5);
        this.f4296d.lineTo(f4, f5);
    }

    private void l() {
        this.f4295c.reset();
        this.f4296d.reset();
        float interpolation = this.K.getInterpolation(this.y);
        this.n = g(d(this.z), d(this.z - 1) + this.f4300h, this.C);
        float f2 = this.f4300h;
        this.o = f2;
        this.f4301i = f(f2, 0.0f, interpolation);
        double radians = Math.toRadians(g(45.0f, 0.0f, this.B));
        float sin = (float) (Math.sin(radians) * this.f4301i);
        float cos = (float) (Math.cos(radians) * this.f4301i);
        this.p = g(d(this.z) - this.f4300h, d(this.z - 1), this.B);
        float f3 = this.f4300h;
        this.q = f3;
        this.f4304l = f(0.0f, f3, interpolation);
        double radians2 = Math.toRadians(g(0.0f, 45.0f, this.C));
        float cos2 = (float) (Math.cos(radians2) * this.f4304l);
        this.F = this.n - sin;
        this.G = this.o - cos;
        this.H = this.p + ((float) (Math.sin(radians2) * this.f4304l));
        this.I = this.f4300h - cos2;
        this.D = h(d(this.z) - this.f4300h, d(this.z - 1) + this.f4300h);
        this.E = this.f4300h;
        this.f4295c.moveTo(this.F, this.G);
        this.f4295c.quadTo(this.D, this.E, this.H, this.I);
        this.f4295c.lineTo(this.H, this.f4300h + cos2);
        this.f4295c.quadTo(this.D, this.f4300h, this.F, this.G + (cos * 2.0f));
        this.f4295c.lineTo(this.F, this.G);
        this.t = g(d(this.z - 1), d(this.z) - this.f4302j, this.C);
        this.u = this.f4300h;
        this.f4303k = f(this.f4302j, 0.0f, interpolation);
        double radians3 = Math.toRadians(g(45.0f, 0.0f, this.B));
        float sin2 = (float) (Math.sin(radians3) * this.f4303k);
        float cos3 = (float) (Math.cos(radians3) * this.f4303k);
        this.r = g(d(this.z - 1) + this.f4302j, d(this.z), this.B);
        this.s = this.f4300h;
        this.f4305m = f(0.0f, this.f4302j, interpolation);
        double radians4 = Math.toRadians(g(0.0f, 45.0f, this.C));
        float sin3 = (float) (Math.sin(radians4) * this.f4305m);
        float cos4 = (float) (Math.cos(radians4) * this.f4305m);
        float f4 = this.t + sin2;
        float f5 = this.u - cos3;
        float f6 = this.r - sin3;
        float h2 = h(d(this.z - 1) + this.f4302j, d(this.z) - this.f4302j);
        float f7 = this.f4300h;
        this.f4296d.moveTo(f4, f5);
        this.f4296d.quadTo(h2, f7, f6, this.s - cos4);
        this.f4296d.lineTo(f6, this.f4300h + cos4);
        this.f4296d.quadTo(h2, f7, f4, (cos3 * 2.0f) + f5);
        this.f4296d.lineTo(f4, f5);
    }

    public void c(ViewPager viewPager) {
        viewPager.addOnPageChangeListener(this);
        this.A = viewPager.getAdapter().getCount();
        this.z = viewPager.getCurrentItem();
        k();
        this.J = M;
        invalidate();
    }

    public float f(float f2, float f3, float f4) {
        return f2 + ((f3 - f2) * f4);
    }

    public float g(float f2, float f3, int i2) {
        float f4;
        float f5;
        if (i2 == this.B) {
            f4 = f3 - f2;
            f5 = this.w;
        } else {
            f4 = f3 - f2;
            f5 = this.x;
        }
        return f2 + (f4 * f5);
    }

    public float h(float f2, float f3) {
        return f2 + ((f3 - f2) * this.y);
    }

    public void m() {
        this.w = 0.0f;
        this.x = 0.0f;
        this.y = 0.0f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i2;
        super.onDraw(canvas);
        canvas.save();
        canvas.translate(getPaddingLeft(), getPaddingTop());
        for (int i3 = 0; i3 < this.A; i3++) {
            int i4 = this.J;
            if (i4 == M) {
                int i5 = this.z;
                if (i3 != i5 && i3 != i5 + 1) {
                    canvas.drawCircle(d(i3), this.f4300h, this.f4302j, this.b);
                }
            } else if (i4 == L && i3 != (i2 = this.z) && i3 != i2 - 1) {
                canvas.drawCircle(d(i3), this.f4300h, this.f4302j, this.b);
            }
        }
        canvas.drawCircle(this.r, this.s, this.f4305m, this.b);
        canvas.drawCircle(this.t, this.u, this.f4303k, this.b);
        canvas.drawPath(this.f4296d, this.b);
        canvas.drawCircle(this.p, this.q, this.f4304l, this.a);
        canvas.drawCircle(this.n, this.o, this.f4301i, this.a);
        canvas.drawPath(this.f4295c, this.a);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        float f2 = this.f4302j;
        int i4 = this.A;
        int paddingLeft = (int) ((f2 * 2.0f * i4) + ((this.f4300h - f2) * 2.0f) + ((i4 - 1) * this.f4299g) + getPaddingLeft() + getPaddingRight());
        int paddingTop = (int) ((this.f4300h * 2.0f) + getPaddingTop() + getPaddingBottom());
        if (mode != 1073741824 && mode == Integer.MIN_VALUE) {
            size = Math.min(size, paddingLeft);
        }
        if (mode2 != 1073741824 && mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(size2, paddingTop);
        }
        setMeasuredDimension(size, size2);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        if (f2 == 0.0f) {
            this.z = i2;
            Log.d(N, "到达");
            m();
        }
        float f3 = i2 + f2;
        int i4 = this.z;
        if (f3 - i4 > 0.0f) {
            int i5 = M;
            this.J = i5;
            if (i5 == i5 && f3 > i4 + 1) {
                this.z = i2;
                Log.d(N, "向左快速滑动");
                return;
            }
            setProgress(f2);
        } else if (f3 - i4 < 0.0f) {
            int i6 = L;
            this.J = i6;
            if (i6 == i6 && f3 < i4 - 1) {
                this.z = i2;
                Log.d(N, "向右快速滑动");
                return;
            }
            setProgress(1.0f - f2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
    }

    public void setDirection(int i2) {
        this.J = i2;
    }

    public void setProgress(float f2) {
        if (f2 == 0.0f) {
            return;
        }
        this.y = f2;
        if (f2 <= 0.5d) {
            this.w = f2 / 0.5f;
            this.x = 0.0f;
        } else {
            this.x = (f2 - 0.5f) / 0.5f;
            this.w = 1.0f;
        }
        if (this.J == M) {
            k();
        } else {
            l();
        }
        invalidate();
    }

    public BezierBannerView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierBannerView(Context context, @Nullable AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f4295c = new Path();
        this.f4296d = new Path();
        this.f4299g = 80.0f;
        this.f4300h = 30.0f;
        this.f4302j = 20.0f;
        this.v = false;
        this.w = 0.0f;
        this.x = 0.0f;
        this.z = 0;
        this.B = 1;
        this.C = 2;
        this.K = new AccelerateDecelerateInterpolator();
        j(attributeSet);
        i();
    }
}
