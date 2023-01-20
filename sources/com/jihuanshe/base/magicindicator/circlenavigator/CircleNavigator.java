package com.jihuanshe.base.magicindicator.circlenavigator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import e.l.h.h.e;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CircleNavigator extends View implements e.l.h.h.f.a {
    private int a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f3780c;

    /* renamed from: d  reason: collision with root package name */
    private int f3781d;

    /* renamed from: e  reason: collision with root package name */
    private int f3782e;

    /* renamed from: f  reason: collision with root package name */
    private int f3783f;

    /* renamed from: g  reason: collision with root package name */
    private Interpolator f3784g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f3785h;

    /* renamed from: i  reason: collision with root package name */
    private List<PointF> f3786i;

    /* renamed from: j  reason: collision with root package name */
    private float f3787j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3788k;

    /* renamed from: l  reason: collision with root package name */
    private a f3789l;

    /* renamed from: m  reason: collision with root package name */
    private float f3790m;
    private float n;
    private int o;
    private boolean p;

    /* loaded from: classes2.dex */
    public interface a {
        void onClick(int i2);
    }

    public CircleNavigator(Context context) {
        super(context);
        this.f3784g = new LinearInterpolator();
        this.f3785h = new Paint(1);
        this.f3786i = new ArrayList();
        this.p = true;
        c(context);
    }

    private void a(Canvas canvas) {
        this.f3785h.setStyle(Paint.Style.STROKE);
        this.f3785h.setStrokeWidth(this.f3780c);
        int size = this.f3786i.size();
        for (int i2 = 0; i2 < size; i2++) {
            PointF pointF = this.f3786i.get(i2);
            canvas.drawCircle(pointF.x, pointF.y, this.a, this.f3785h);
        }
    }

    private void b(Canvas canvas) {
        this.f3785h.setStyle(Paint.Style.FILL);
        if (this.f3786i.size() > 0) {
            canvas.drawCircle(this.f3787j, (int) ((getHeight() / 2.0f) + 0.5f), this.a, this.f3785h);
        }
    }

    private void c(Context context) {
        this.o = ViewConfiguration.get(context).getScaledTouchSlop();
        this.a = e.a(context, 3.0d);
        this.f3781d = e.a(context, 8.0d);
        this.f3780c = e.a(context, 1.0d);
    }

    private int i(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            return (this.a * 2) + (this.f3780c * 2) + getPaddingTop() + getPaddingBottom();
        }
        if (mode != 1073741824) {
            return 0;
        }
        return size;
    }

    private int j(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i3 = this.f3783f;
            return (this.f3780c * 2) + (this.a * i3 * 2) + ((i3 - 1) * this.f3781d) + getPaddingLeft() + getPaddingRight();
        } else if (mode != 1073741824) {
            return 0;
        } else {
            return size;
        }
    }

    private void k() {
        this.f3786i.clear();
        if (this.f3783f > 0) {
            int height = (int) ((getHeight() / 2.0f) + 0.5f);
            int i2 = this.a;
            int i3 = (i2 * 2) + this.f3781d;
            int paddingLeft = i2 + ((int) ((this.f3780c / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i4 = 0; i4 < this.f3783f; i4++) {
                this.f3786i.add(new PointF(paddingLeft, height));
                paddingLeft += i3;
            }
            this.f3787j = this.f3786i.get(this.f3782e).x;
        }
    }

    public boolean d() {
        return this.p;
    }

    @Override // e.l.h.h.f.a
    public void e() {
        k();
        invalidate();
    }

    @Override // e.l.h.h.f.a
    public void f() {
    }

    @Override // e.l.h.h.f.a
    public void g() {
    }

    public a getCircleClickListener() {
        return this.f3789l;
    }

    public int getCircleColor() {
        return this.b;
    }

    public int getCircleCount() {
        return this.f3783f;
    }

    public int getCircleSpacing() {
        return this.f3781d;
    }

    public int getRadius() {
        return this.a;
    }

    public Interpolator getStartInterpolator() {
        return this.f3784g;
    }

    public int getStrokeWidth() {
        return this.f3780c;
    }

    public boolean h() {
        return this.f3788k;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        this.f3785h.setColor(this.b);
        a(canvas);
        b(canvas);
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        k();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(j(i2), i(i3));
    }

    @Override // e.l.h.h.f.a
    public void onPageScrollStateChanged(int i2) {
    }

    @Override // e.l.h.h.f.a
    public void onPageScrolled(int i2, float f2, int i3) {
        if (!this.p || this.f3786i.isEmpty()) {
            return;
        }
        int min = Math.min(this.f3786i.size() - 1, i2);
        int min2 = Math.min(this.f3786i.size() - 1, i2 + 1);
        float f3 = this.f3786i.get(min).x;
        this.f3787j = f3 + ((this.f3786i.get(min2).x - f3) * this.f3784g.getInterpolation(f2));
        invalidate();
    }

    @Override // e.l.h.h.f.a
    public void onPageSelected(int i2) {
        this.f3782e = i2;
        if (this.p) {
            return;
        }
        this.f3787j = this.f3786i.get(i2).x;
        invalidate();
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.f3789l != null && Math.abs(x - this.f3790m) <= this.o && Math.abs(y - this.n) <= this.o) {
                float f2 = Float.MAX_VALUE;
                int i2 = 0;
                for (int i3 = 0; i3 < this.f3786i.size(); i3++) {
                    float abs = Math.abs(this.f3786i.get(i3).x - x);
                    if (abs < f2) {
                        i2 = i3;
                        f2 = abs;
                    }
                }
                this.f3789l.onClick(i2);
            }
        } else if (this.f3788k) {
            this.f3790m = x;
            this.n = y;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCircleClickListener(a aVar) {
        if (!this.f3788k) {
            this.f3788k = true;
        }
        this.f3789l = aVar;
    }

    public void setCircleColor(int i2) {
        this.b = i2;
        invalidate();
    }

    public void setCircleCount(int i2) {
        this.f3783f = i2;
    }

    public void setCircleSpacing(int i2) {
        this.f3781d = i2;
        k();
        invalidate();
    }

    public void setFollowTouch(boolean z) {
        this.p = z;
    }

    public void setRadius(int i2) {
        this.a = i2;
        k();
        invalidate();
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.f3784g = interpolator;
        if (interpolator == null) {
            this.f3784g = new LinearInterpolator();
        }
    }

    public void setStrokeWidth(int i2) {
        this.f3780c = i2;
        invalidate();
    }

    public void setTouchable(boolean z) {
        this.f3788k = z;
    }
}
