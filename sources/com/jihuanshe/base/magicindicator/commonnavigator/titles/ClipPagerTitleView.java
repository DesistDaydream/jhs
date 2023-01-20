package com.jihuanshe.base.magicindicator.commonnavigator.titles;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;
import e.l.h.h.e;
import e.l.h.h.g.a.b;

/* loaded from: classes2.dex */
public class ClipPagerTitleView extends View implements b {
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f3845c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3846d;

    /* renamed from: e  reason: collision with root package name */
    private float f3847e;

    /* renamed from: f  reason: collision with root package name */
    private Paint f3848f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f3849g;

    public ClipPagerTitleView(Context context) {
        super(context);
        this.f3849g = new Rect();
        e(context);
    }

    private void e(Context context) {
        int a = e.a(context, 16.0d);
        Paint paint = new Paint(1);
        this.f3848f = paint;
        paint.setTextSize(a);
        int a2 = e.a(context, 10.0d);
        setPadding(a2, 0, a2, 0);
    }

    private int f(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : this.f3849g.height() + getPaddingTop() + getPaddingBottom();
        }
        return Math.min(this.f3849g.height() + getPaddingTop() + getPaddingBottom(), size);
    }

    private void g() {
        Paint paint = this.f3848f;
        String str = this.a;
        paint.getTextBounds(str, 0, str == null ? 0 : str.length(), this.f3849g);
    }

    private int h(int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE) {
            return mode != 0 ? size : this.f3849g.width() + getPaddingLeft() + getPaddingRight();
        }
        return Math.min(this.f3849g.width() + getPaddingLeft() + getPaddingRight(), size);
    }

    @Override // e.l.h.h.g.a.d
    public void a(int i2, int i3) {
    }

    @Override // e.l.h.h.g.a.d
    public void b(int i2, int i3, float f2, boolean z) {
        this.f3846d = z;
        this.f3847e = f2;
        invalidate();
    }

    @Override // e.l.h.h.g.a.d
    public void c(int i2, int i3) {
    }

    @Override // e.l.h.h.g.a.d
    public void d(int i2, int i3, float f2, boolean z) {
        this.f3846d = !z;
        this.f3847e = 1.0f - f2;
        invalidate();
    }

    public int getClipColor() {
        return this.f3845c;
    }

    @Override // e.l.h.h.g.a.b
    public int getContentBottom() {
        Paint.FontMetrics fontMetrics = this.f3848f.getFontMetrics();
        return (int) ((getHeight() / 2) + ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    @Override // e.l.h.h.g.a.b
    public int getContentLeft() {
        return (getLeft() + (getWidth() / 2)) - (this.f3849g.width() / 2);
    }

    @Override // e.l.h.h.g.a.b
    public int getContentRight() {
        return getLeft() + (getWidth() / 2) + (this.f3849g.width() / 2);
    }

    @Override // e.l.h.h.g.a.b
    public int getContentTop() {
        Paint.FontMetrics fontMetrics = this.f3848f.getFontMetrics();
        return (int) ((getHeight() / 2) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f));
    }

    public String getText() {
        return this.a;
    }

    public int getTextColor() {
        return this.b;
    }

    public float getTextSize() {
        return this.f3848f.getTextSize();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.f3848f.getFontMetrics();
        int height = (int) (((getHeight() - fontMetrics.bottom) - fontMetrics.top) / 2.0f);
        this.f3848f.setColor(this.b);
        float width = (getWidth() - this.f3849g.width()) / 2;
        float f2 = height;
        canvas.drawText(this.a, width, f2, this.f3848f);
        canvas.save();
        if (this.f3846d) {
            canvas.clipRect(0.0f, 0.0f, getWidth() * this.f3847e, getHeight());
        } else {
            canvas.clipRect(getWidth() * (1.0f - this.f3847e), 0.0f, getWidth(), getHeight());
        }
        this.f3848f.setColor(this.f3845c);
        canvas.drawText(this.a, width, f2, this.f3848f);
        canvas.restore();
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        g();
        setMeasuredDimension(h(i2), f(i3));
    }

    public void setClipColor(int i2) {
        this.f3845c = i2;
        invalidate();
    }

    public void setText(String str) {
        this.a = str;
        requestLayout();
    }

    public void setTextColor(int i2) {
        this.b = i2;
        invalidate();
    }

    public void setTextSize(float f2) {
        this.f3848f.setTextSize(f2);
        requestLayout();
    }
}
