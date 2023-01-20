package com.jihuanshe.base.magicindicator.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import e.l.h.h.b;
import e.l.h.h.e;
import e.l.h.h.g.a.c;
import e.l.h.h.g.b.a;
import java.util.List;

/* loaded from: classes2.dex */
public class TriangularPagerIndicator extends View implements c {
    private List<a> a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private int f3828c;

    /* renamed from: d  reason: collision with root package name */
    private int f3829d;

    /* renamed from: e  reason: collision with root package name */
    private int f3830e;

    /* renamed from: f  reason: collision with root package name */
    private int f3831f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3832g;

    /* renamed from: h  reason: collision with root package name */
    private float f3833h;

    /* renamed from: i  reason: collision with root package name */
    private Path f3834i;

    /* renamed from: j  reason: collision with root package name */
    private Interpolator f3835j;

    /* renamed from: k  reason: collision with root package name */
    private float f3836k;

    public TriangularPagerIndicator(Context context) {
        super(context);
        this.f3834i = new Path();
        this.f3835j = new LinearInterpolator();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.b = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3828c = e.a(context, 3.0d);
        this.f3831f = e.a(context, 14.0d);
        this.f3830e = e.a(context, 8.0d);
    }

    @Override // e.l.h.h.g.a.c
    public void a(List<a> list) {
        this.a = list;
    }

    public boolean c() {
        return this.f3832g;
    }

    public int getLineColor() {
        return this.f3829d;
    }

    public int getLineHeight() {
        return this.f3828c;
    }

    public Interpolator getStartInterpolator() {
        return this.f3835j;
    }

    public int getTriangleHeight() {
        return this.f3830e;
    }

    public int getTriangleWidth() {
        return this.f3831f;
    }

    public float getYOffset() {
        return this.f3833h;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.b.setColor(this.f3829d);
        if (this.f3832g) {
            canvas.drawRect(0.0f, (getHeight() - this.f3833h) - this.f3830e, getWidth(), ((getHeight() - this.f3833h) - this.f3830e) + this.f3828c, this.b);
        } else {
            canvas.drawRect(0.0f, (getHeight() - this.f3828c) - this.f3833h, getWidth(), getHeight() - this.f3833h, this.b);
        }
        this.f3834i.reset();
        if (this.f3832g) {
            this.f3834i.moveTo(this.f3836k - (this.f3831f / 2), (getHeight() - this.f3833h) - this.f3830e);
            this.f3834i.lineTo(this.f3836k, getHeight() - this.f3833h);
            this.f3834i.lineTo(this.f3836k + (this.f3831f / 2), (getHeight() - this.f3833h) - this.f3830e);
        } else {
            this.f3834i.moveTo(this.f3836k - (this.f3831f / 2), getHeight() - this.f3833h);
            this.f3834i.lineTo(this.f3836k, (getHeight() - this.f3830e) - this.f3833h);
            this.f3834i.lineTo(this.f3836k + (this.f3831f / 2), getHeight() - this.f3833h);
        }
        this.f3834i.close();
        canvas.drawPath(this.f3834i, this.b);
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        List<a> list = this.a;
        if (list == null || list.isEmpty()) {
            return;
        }
        a h2 = b.h(this.a, i2);
        a h3 = b.h(this.a, i2 + 1);
        int i4 = h2.a;
        float f3 = i4 + ((h2.f12118c - i4) / 2);
        int i5 = h3.a;
        this.f3836k = f3 + (((i5 + ((h3.f12118c - i5) / 2)) - f3) * this.f3835j.getInterpolation(f2));
        invalidate();
    }

    @Override // e.l.h.h.g.a.c
    public void onPageSelected(int i2) {
    }

    public void setLineColor(int i2) {
        this.f3829d = i2;
    }

    public void setLineHeight(int i2) {
        this.f3828c = i2;
    }

    public void setReverse(boolean z) {
        this.f3832g = z;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f3835j = interpolator;
        if (interpolator == null) {
            this.f3835j = new LinearInterpolator();
        }
    }

    public void setTriangleHeight(int i2) {
        this.f3830e = i2;
    }

    public void setTriangleWidth(int i2) {
        this.f3831f = i2;
    }

    public void setYOffset(float f2) {
        this.f3833h = f2;
    }
}
