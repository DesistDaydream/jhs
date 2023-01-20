package com.jihuanshe.base.magicindicator.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import e.l.h.h.b;
import e.l.h.h.e;
import e.l.h.h.g.a.c;
import e.l.h.h.g.b.a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class LinePagerIndicator extends View implements c {

    /* renamed from: m  reason: collision with root package name */
    public static final int f3813m = 0;
    public static final int n = 1;
    public static final int o = 2;
    private int a;
    private Interpolator b;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f3814c;

    /* renamed from: d  reason: collision with root package name */
    private float f3815d;

    /* renamed from: e  reason: collision with root package name */
    private float f3816e;

    /* renamed from: f  reason: collision with root package name */
    private float f3817f;

    /* renamed from: g  reason: collision with root package name */
    private float f3818g;

    /* renamed from: h  reason: collision with root package name */
    private float f3819h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f3820i;

    /* renamed from: j  reason: collision with root package name */
    private List<a> f3821j;

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f3822k;

    /* renamed from: l  reason: collision with root package name */
    private RectF f3823l;

    public LinePagerIndicator(Context context) {
        super(context);
        this.b = new LinearInterpolator();
        this.f3814c = new LinearInterpolator();
        this.f3823l = new RectF();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.f3820i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3816e = e.a(context, 3.0d);
        this.f3818g = e.a(context, 10.0d);
    }

    @Override // e.l.h.h.g.a.c
    public void a(List<a> list) {
        this.f3821j = list;
    }

    public List<Integer> getColors() {
        return this.f3822k;
    }

    public Interpolator getEndInterpolator() {
        return this.f3814c;
    }

    public float getLineHeight() {
        return this.f3816e;
    }

    public float getLineWidth() {
        return this.f3818g;
    }

    public int getMode() {
        return this.a;
    }

    public Paint getPaint() {
        return this.f3820i;
    }

    public float getRoundRadius() {
        return this.f3819h;
    }

    public Interpolator getStartInterpolator() {
        return this.b;
    }

    public float getXOffset() {
        return this.f3817f;
    }

    public float getYOffset() {
        return this.f3815d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        RectF rectF = this.f3823l;
        float f2 = this.f3819h;
        canvas.drawRoundRect(rectF, f2, f2, this.f3820i);
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        int i4;
        List<a> list = this.f3821j;
        if (list == null || list.isEmpty()) {
            return;
        }
        List<Integer> list2 = this.f3822k;
        if (list2 != null && list2.size() > 0) {
            this.f3820i.setColor(e.l.h.h.a.a(f2, this.f3822k.get(Math.abs(i2) % this.f3822k.size()).intValue(), this.f3822k.get(Math.abs(i2 + 1) % this.f3822k.size()).intValue()));
        }
        a h2 = b.h(this.f3821j, i2);
        a h3 = b.h(this.f3821j, i2 + 1);
        int i5 = this.a;
        if (i5 == 0) {
            f7 = this.f3817f;
            f3 = h2.a + f7;
            f6 = h3.a + f7;
            f4 = h2.f12118c - f7;
            i4 = h3.f12118c;
        } else if (i5 == 1) {
            f7 = this.f3817f;
            f3 = h2.f12120e + f7;
            f6 = h3.f12120e + f7;
            f4 = h2.f12122g - f7;
            i4 = h3.f12122g;
        } else {
            f3 = h2.a + ((h2.f() - this.f3818g) / 2.0f);
            float f8 = h3.a + ((h3.f() - this.f3818g) / 2.0f);
            f4 = ((h2.f() + this.f3818g) / 2.0f) + h2.a;
            f5 = ((h3.f() + this.f3818g) / 2.0f) + h3.a;
            f6 = f8;
            this.f3823l.left = f3 + ((f6 - f3) * this.b.getInterpolation(f2));
            this.f3823l.right = f4 + ((f5 - f4) * this.f3814c.getInterpolation(f2));
            this.f3823l.top = (getHeight() - this.f3816e) - this.f3815d;
            this.f3823l.bottom = getHeight() - this.f3815d;
            invalidate();
        }
        f5 = i4 - f7;
        this.f3823l.left = f3 + ((f6 - f3) * this.b.getInterpolation(f2));
        this.f3823l.right = f4 + ((f5 - f4) * this.f3814c.getInterpolation(f2));
        this.f3823l.top = (getHeight() - this.f3816e) - this.f3815d;
        this.f3823l.bottom = getHeight() - this.f3815d;
        invalidate();
    }

    @Override // e.l.h.h.g.a.c
    public void onPageSelected(int i2) {
    }

    public void setColors(Integer... numArr) {
        this.f3822k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f3814c = interpolator;
        if (interpolator == null) {
            this.f3814c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f2) {
        this.f3816e = f2;
    }

    public void setLineWidth(float f2) {
        this.f3818g = f2;
    }

    public void setMode(int i2) {
        if (i2 != 2 && i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("mode " + i2 + " not supported.");
        }
        this.a = i2;
    }

    public void setRoundRadius(float f2) {
        this.f3819h = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.b = interpolator;
        if (interpolator == null) {
            this.b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f2) {
        this.f3817f = f2;
    }

    public void setYOffset(float f2) {
        this.f3815d = f2;
    }
}
