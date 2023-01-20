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
import java.util.List;

/* loaded from: classes2.dex */
public class WrapPagerIndicator extends View implements c {
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f3837c;

    /* renamed from: d  reason: collision with root package name */
    private float f3838d;

    /* renamed from: e  reason: collision with root package name */
    private Interpolator f3839e;

    /* renamed from: f  reason: collision with root package name */
    private Interpolator f3840f;

    /* renamed from: g  reason: collision with root package name */
    private List<a> f3841g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f3842h;

    /* renamed from: i  reason: collision with root package name */
    private RectF f3843i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3844j;

    public WrapPagerIndicator(Context context) {
        super(context);
        this.f3839e = new LinearInterpolator();
        this.f3840f = new LinearInterpolator();
        this.f3843i = new RectF();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.f3842h = paint;
        paint.setStyle(Paint.Style.FILL);
        this.a = e.a(context, 6.0d);
        this.b = e.a(context, 10.0d);
    }

    @Override // e.l.h.h.g.a.c
    public void a(List<a> list) {
        this.f3841g = list;
    }

    public Interpolator getEndInterpolator() {
        return this.f3840f;
    }

    public int getFillColor() {
        return this.f3837c;
    }

    public int getHorizontalPadding() {
        return this.b;
    }

    public Paint getPaint() {
        return this.f3842h;
    }

    public float getRoundRadius() {
        return this.f3838d;
    }

    public Interpolator getStartInterpolator() {
        return this.f3839e;
    }

    public int getVerticalPadding() {
        return this.a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f3842h.setColor(this.f3837c);
        RectF rectF = this.f3843i;
        float f2 = this.f3838d;
        canvas.drawRoundRect(rectF, f2, f2, this.f3842h);
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        List<a> list = this.f3841g;
        if (list == null || list.isEmpty()) {
            return;
        }
        a h2 = b.h(this.f3841g, i2);
        a h3 = b.h(this.f3841g, i2 + 1);
        RectF rectF = this.f3843i;
        int i4 = h2.f12120e;
        rectF.left = (i4 - this.b) + ((h3.f12120e - i4) * this.f3840f.getInterpolation(f2));
        RectF rectF2 = this.f3843i;
        rectF2.top = h2.f12121f - this.a;
        int i5 = h2.f12122g;
        rectF2.right = this.b + i5 + ((h3.f12122g - i5) * this.f3839e.getInterpolation(f2));
        RectF rectF3 = this.f3843i;
        rectF3.bottom = h2.f12123h + this.a;
        if (!this.f3844j) {
            this.f3838d = rectF3.height() / 2.0f;
        }
        invalidate();
    }

    @Override // e.l.h.h.g.a.c
    public void onPageSelected(int i2) {
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f3840f = interpolator;
        if (interpolator == null) {
            this.f3840f = new LinearInterpolator();
        }
    }

    public void setFillColor(int i2) {
        this.f3837c = i2;
    }

    public void setHorizontalPadding(int i2) {
        this.b = i2;
    }

    public void setRoundRadius(float f2) {
        this.f3838d = f2;
        this.f3844j = true;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f3839e = interpolator;
        if (interpolator == null) {
            this.f3839e = new LinearInterpolator();
        }
    }

    public void setVerticalPadding(int i2) {
        this.a = i2;
    }
}
