package com.jihuanshe.base.magicindicator.commonnavigator.indicators;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;
import e.l.h.h.b;
import e.l.h.h.g.a.c;
import e.l.h.h.g.b.a;
import java.util.List;

/* loaded from: classes2.dex */
public class TestPagerIndicator extends View implements c {
    private Paint a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f3824c;

    /* renamed from: d  reason: collision with root package name */
    private RectF f3825d;

    /* renamed from: e  reason: collision with root package name */
    private RectF f3826e;

    /* renamed from: f  reason: collision with root package name */
    private List<a> f3827f;

    public TestPagerIndicator(Context context) {
        super(context);
        this.f3825d = new RectF();
        this.f3826e = new RectF();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.a = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.b = -65536;
        this.f3824c = -16711936;
    }

    @Override // e.l.h.h.g.a.c
    public void a(List<a> list) {
        this.f3827f = list;
    }

    public int getInnerRectColor() {
        return this.f3824c;
    }

    public int getOutRectColor() {
        return this.b;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.a.setColor(this.b);
        canvas.drawRect(this.f3825d, this.a);
        this.a.setColor(this.f3824c);
        canvas.drawRect(this.f3826e, this.a);
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        List<a> list = this.f3827f;
        if (list == null || list.isEmpty()) {
            return;
        }
        a h2 = b.h(this.f3827f, i2);
        a h3 = b.h(this.f3827f, i2 + 1);
        RectF rectF = this.f3825d;
        int i4 = h2.a;
        rectF.left = i4 + ((h3.a - i4) * f2);
        int i5 = h2.b;
        rectF.top = i5 + ((h3.b - i5) * f2);
        int i6 = h2.f12118c;
        rectF.right = i6 + ((h3.f12118c - i6) * f2);
        int i7 = h2.f12119d;
        rectF.bottom = i7 + ((h3.f12119d - i7) * f2);
        RectF rectF2 = this.f3826e;
        int i8 = h2.f12120e;
        rectF2.left = i8 + ((h3.f12120e - i8) * f2);
        int i9 = h2.f12121f;
        rectF2.top = i9 + ((h3.f12121f - i9) * f2);
        int i10 = h2.f12122g;
        rectF2.right = i10 + ((h3.f12122g - i10) * f2);
        int i11 = h2.f12123h;
        rectF2.bottom = i11 + ((h3.f12123h - i11) * f2);
        invalidate();
    }

    @Override // e.l.h.h.g.a.c
    public void onPageSelected(int i2) {
    }

    public void setInnerRectColor(int i2) {
        this.f3824c = i2;
    }

    public void setOutRectColor(int i2) {
        this.b = i2;
    }
}
