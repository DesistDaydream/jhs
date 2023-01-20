package com.jihuanshe.base.magicindicator.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import e.l.h.h.b;
import e.l.h.h.e;
import e.l.h.h.g.a.c;
import e.l.h.h.g.b.a;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class BezierPagerIndicator extends View implements c {
    private List<a> a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f3802c;

    /* renamed from: d  reason: collision with root package name */
    private float f3803d;

    /* renamed from: e  reason: collision with root package name */
    private float f3804e;

    /* renamed from: f  reason: collision with root package name */
    private float f3805f;

    /* renamed from: g  reason: collision with root package name */
    private float f3806g;

    /* renamed from: h  reason: collision with root package name */
    private float f3807h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f3808i;

    /* renamed from: j  reason: collision with root package name */
    private Path f3809j;

    /* renamed from: k  reason: collision with root package name */
    private List<Integer> f3810k;

    /* renamed from: l  reason: collision with root package name */
    private Interpolator f3811l;

    /* renamed from: m  reason: collision with root package name */
    private Interpolator f3812m;

    public BezierPagerIndicator(Context context) {
        super(context);
        this.f3809j = new Path();
        this.f3811l = new AccelerateInterpolator();
        this.f3812m = new DecelerateInterpolator();
        c(context);
    }

    private void b(Canvas canvas) {
        this.f3809j.reset();
        float height = (getHeight() - this.f3805f) - this.f3806g;
        this.f3809j.moveTo(this.f3804e, height);
        this.f3809j.lineTo(this.f3804e, height - this.f3803d);
        Path path = this.f3809j;
        float f2 = this.f3804e;
        float f3 = this.f3802c;
        path.quadTo(f2 + ((f3 - f2) / 2.0f), height, f3, height - this.b);
        this.f3809j.lineTo(this.f3802c, this.b + height);
        Path path2 = this.f3809j;
        float f4 = this.f3804e;
        path2.quadTo(((this.f3802c - f4) / 2.0f) + f4, height, f4, this.f3803d + height);
        this.f3809j.close();
        canvas.drawPath(this.f3809j, this.f3808i);
    }

    private void c(Context context) {
        Paint paint = new Paint(1);
        this.f3808i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f3806g = e.a(context, 3.5d);
        this.f3807h = e.a(context, 2.0d);
        this.f3805f = e.a(context, 1.5d);
    }

    @Override // e.l.h.h.g.a.c
    public void a(List<a> list) {
        this.a = list;
    }

    public float getMaxCircleRadius() {
        return this.f3806g;
    }

    public float getMinCircleRadius() {
        return this.f3807h;
    }

    public float getYOffset() {
        return this.f3805f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.drawCircle(this.f3802c, (getHeight() - this.f3805f) - this.f3806g, this.b, this.f3808i);
        canvas.drawCircle(this.f3804e, (getHeight() - this.f3805f) - this.f3806g, this.f3803d, this.f3808i);
        b(canvas);
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
        List<Integer> list2 = this.f3810k;
        if (list2 != null && list2.size() > 0) {
            this.f3808i.setColor(e.l.h.h.a.a(f2, this.f3810k.get(Math.abs(i2) % this.f3810k.size()).intValue(), this.f3810k.get(Math.abs(i2 + 1) % this.f3810k.size()).intValue()));
        }
        a h2 = b.h(this.a, i2);
        a h3 = b.h(this.a, i2 + 1);
        int i4 = h2.a;
        float f3 = i4 + ((h2.f12118c - i4) / 2);
        int i5 = h3.a;
        float f4 = (i5 + ((h3.f12118c - i5) / 2)) - f3;
        this.f3802c = (this.f3811l.getInterpolation(f2) * f4) + f3;
        this.f3804e = f3 + (f4 * this.f3812m.getInterpolation(f2));
        float f5 = this.f3806g;
        this.b = f5 + ((this.f3807h - f5) * this.f3812m.getInterpolation(f2));
        float f6 = this.f3807h;
        this.f3803d = f6 + ((this.f3806g - f6) * this.f3811l.getInterpolation(f2));
        invalidate();
    }

    @Override // e.l.h.h.g.a.c
    public void onPageSelected(int i2) {
    }

    public void setColors(Integer... numArr) {
        this.f3810k = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f3812m = interpolator;
        if (interpolator == null) {
            this.f3812m = new DecelerateInterpolator();
        }
    }

    public void setMaxCircleRadius(float f2) {
        this.f3806g = f2;
    }

    public void setMinCircleRadius(float f2) {
        this.f3807h = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f3811l = interpolator;
        if (interpolator == null) {
            this.f3811l = new AccelerateInterpolator();
        }
    }

    public void setYOffset(float f2) {
        this.f3805f = f2;
    }
}
