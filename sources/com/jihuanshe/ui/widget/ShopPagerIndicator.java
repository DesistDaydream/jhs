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
public class ShopPagerIndicator extends View implements c {
    public static final int n = 0;
    public static final int o = 1;
    public static final int p = 2;
    private int a;
    private Interpolator b;

    /* renamed from: c */
    private Interpolator f4227c;

    /* renamed from: d */
    private float f4228d;

    /* renamed from: e */
    private float f4229e;

    /* renamed from: f */
    private float f4230f;

    /* renamed from: g */
    private float f4231g;

    /* renamed from: h */
    private float f4232h;

    /* renamed from: i */
    private int f4233i;

    /* renamed from: j */
    private Paint f4234j;

    /* renamed from: k */
    private List<a> f4235k;

    /* renamed from: l */
    private List<Integer> f4236l;

    /* renamed from: m */
    private Rect f4237m;

    public ShopPagerIndicator(Context context) {
        super(context);
        this.b = new LinearInterpolator();
        this.f4227c = new LinearInterpolator();
        this.f4237m = new Rect();
        b(context);
    }

    private void b(Context context) {
        Paint paint = new Paint(1);
        this.f4234j = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f4229e = e.a(context, 3.0d);
        this.f4231g = e.a(context, 10.0d);
        this.f4233i = d.b(context).d(36);
    }

    @Override // e.l.h.h.g.a.c
    public void a(List<a> list) {
        this.f4235k = list;
    }

    public List<Integer> getColors() {
        return this.f4236l;
    }

    public Interpolator getEndInterpolator() {
        return this.f4227c;
    }

    public float getLineHeight() {
        return this.f4229e;
    }

    public int getLineRectBottom() {
        return this.f4233i;
    }

    public float getLineWidth() {
        return this.f4231g;
    }

    public int getMode() {
        return this.a;
    }

    public Paint getPaint() {
        return this.f4234j;
    }

    public float getRoundRadius() {
        return this.f4232h;
    }

    public Interpolator getStartInterpolator() {
        return this.b;
    }

    public float getXOffset() {
        return this.f4230f;
    }

    public float getYOffset() {
        return this.f4228d;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        g0 g0Var = new g0(Res.k(R.color.white));
        g0Var.setBounds(this.f4237m);
        g0Var.draw(canvas);
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // e.l.h.h.g.a.c
    public void onPageScrolled(int i2, float f2, int i3) {
        List<a> list = this.f4235k;
        if (list == null || list.isEmpty()) {
            return;
        }
        a h2 = b.h(this.f4235k, i2);
        a h3 = b.h(this.f4235k, i2 + 1);
        float f3 = h2.a - (i2 == 0 ? 0.0f : this.f4230f);
        int i4 = h3.a;
        float f4 = h2.f12118c;
        float f5 = i2 != this.f4235k.size() + (-1) ? this.f4230f : 0.0f;
        int i5 = h3.f12118c;
        int size = this.f4235k.size() - 1;
        Rect rect = this.f4237m;
        rect.left = (int) f3;
        rect.right = (int) (f4 + f5);
        rect.top = 0;
        rect.bottom = this.f4233i;
        invalidate();
    }

    @Override // e.l.h.h.g.a.c
    public void onPageSelected(int i2) {
    }

    public void setColors(Integer... numArr) {
        this.f4236l = Arrays.asList(numArr);
    }

    public void setEndInterpolator(Interpolator interpolator) {
        this.f4227c = interpolator;
        if (interpolator == null) {
            this.f4227c = new LinearInterpolator();
        }
    }

    public void setLineHeight(float f2) {
        this.f4229e = f2;
    }

    public void setLineRectBottom(int i2) {
        this.f4233i = i2;
    }

    public void setLineWidth(float f2) {
        this.f4231g = f2;
    }

    public void setMode(int i2) {
        if (i2 != 2 && i2 != 0 && i2 != 1) {
            throw new IllegalArgumentException("mode " + i2 + " not supported.");
        }
        this.a = i2;
    }

    public void setRoundRadius(float f2) {
        this.f4232h = f2;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.b = interpolator;
        if (interpolator == null) {
            this.b = new LinearInterpolator();
        }
    }

    public void setXOffset(float f2) {
        this.f4230f = f2;
    }

    public void setYOffset(float f2) {
        this.f4228d = f2;
    }
}
