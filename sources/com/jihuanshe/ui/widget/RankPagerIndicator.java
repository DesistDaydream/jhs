package com.jihuanshe.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.l.h.h.b;
import e.l.h.h.e;
import e.l.h.h.g.a.c;
import e.l.h.h.g.b.a;
import e.l.q.c.g0;
import e.t.o.d;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes2.dex */
public class RankPagerIndicator extends View implements c {
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    private int a;
    private Interpolator b;

    /* renamed from: c  reason: collision with root package name */
    private Interpolator f4184c;

    /* renamed from: d  reason: collision with root package name */
    private float f4185d;

    /* renamed from: e  reason: collision with root package name */
    private float f4186e;

    /* renamed from: f  reason: collision with root package name */
    private float f4187f;

    /* renamed from: g  reason: collision with root package name */
    private float f4188g;

    /* renamed from: h  reason: collision with root package name */
    private float f4189h;

    /* renamed from: i  reason: collision with root package name */
    private int f4190i;

    /* renamed from: j  reason: collision with root package name */
    private Paint f4191j;

    /* renamed from: k  reason: collision with root package name */
    private List<a> f4192k;

    /* renamed from: l  reason: collision with root package name */
    private List<Integer> f4193l;

    /* renamed from: m  reason: collision with root package name */
    private int f4194m;
    private Rect n;

    public RankPagerIndicator(Context context) {
        super(context);
        this.b = new LinearInterpolator();
        this.f4184c = new LinearInterpolator();
        this.f4194m = R.color.black;
        this.n = new Rect();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.f4191j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f4186e = e.a(context, 3.0d);
        this.f4188g = e.a(context, 10.0d);
        this.f4190i = d.b(context).d(36);
    }

    @Override // e.l.h.h.g.a.c
    public void a(List<a> list) {
        this.f4192k = list;
    }

    public List<Integer> getColors() {
        return this.f4193l;
    }

    public Interpolator getEndInterpolator() {
        return this.f4184c;
    }

    public float getLineHeight() {
        return this.f4186e;
    }

    public int getLineRectBottom() {
        return this.f4190i;
    }

    public float getLineWidth() {
        return this.f4188g;
    }

    public int getMode() {
        return this.a;
    }

    public Paint getPaint() {
        return this.f4191j;
    }

    public float getRoundRadius() {
        return this.f4189h;
    }

    public Interpolator getStartInterpolator() {
        return this.b;
    }

    public float getXOffset() {
        return this.f4187f;
    }

    public float getYOffset() {
        return this.f4185d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        g0 g0Var = new g0(Res.k(this.f4194m));
        g0Var.setBounds(this.n);
        g0Var.draw(canvas);
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        List<a> list = this.f4192k;
        if (list == null || list.isEmpty()) {
            return;
        }
        a h2 = b.h(this.f4192k, i2);
        a h3 = b.h(this.f4192k, i2 + 1);
        float f3 = h2.a - (i2 == 0 ? 0.0f : this.f4187f);
        int i4 = h3.a;
        float f4 = h2.f12118c;
        float f5 = i2 != this.f4192k.size() + (-1) ? this.f4187f : 0.0f;
        int i5 = h3.f12118c;
        int size = this.f4192k.size() - 1;
        Rect rect = this.n;
        rect.left = (int) f3;
        rect.right = (int) (f4 + f5);
        rect.top = 0;
        rect.bottom = this.f4190i;
        invalidate();
    }

    @Override // e.l.h.h.g.a.c
    public void onPageSelected(int i2) {
    }

    public void setColors(Integer... numArr) {
        this.f4193l = Arrays.asList(numArr);
    }

    public void setDrawableTint(int i2) {
        this.f4194m = i2;
        postInvalidate();
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f4184c = interpolator;
        if (interpolator == null) {
            this.f4184c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f2) {
        this.f4186e = f2;
    }

    public void setLineRectBottom(int i2) {
        this.f4190i = i2;
    }

    public void setLineWidth(float f2) {
        this.f4188g = f2;
    }

    public void setMode(int i2) {
        if (i2 != 2 && i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("mode " + i2 + " not supported.");
        }
        this.a = i2;
    }

    public void setRoundRadius(float f2) {
        this.f4189h = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.b = interpolator;
        if (interpolator == null) {
            this.b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f2) {
        this.f4187f = f2;
    }

    public void setYOffset(float f2) {
        this.f4185d = f2;
    }
}
