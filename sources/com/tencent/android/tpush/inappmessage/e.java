package com.tencent.android.tpush.inappmessage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes3.dex */
public class e extends View {
    private Paint a;
    private Paint b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f6122c;

    /* renamed from: d  reason: collision with root package name */
    private float f6123d;

    /* renamed from: e  reason: collision with root package name */
    private float f6124e;

    /* renamed from: f  reason: collision with root package name */
    private float f6125f;

    /* renamed from: g  reason: collision with root package name */
    private float f6126g;

    /* renamed from: h  reason: collision with root package name */
    private float f6127h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f6128i;

    public e(Context context) {
        super(context);
        this.a = new Paint();
        this.b = new Paint();
        this.f6122c = new Paint();
        this.f6128i = false;
        a();
    }

    private void a() {
        this.a.setAntiAlias(true);
        this.a.setColor(-2236963);
        this.a.setStrokeWidth(2.0f);
        this.a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.b.setAntiAlias(true);
        this.b.setColor(-6710887);
        this.b.setStrokeWidth(2.0f);
        this.b.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f6122c.setAntiAlias(true);
        this.f6122c.setColor(ViewCompat.MEASURED_STATE_MASK);
        this.f6122c.setStrokeWidth(3.0f);
        this.f6122c.setStyle(Paint.Style.FILL_AND_STROKE);
        float f2 = SizeUtil.dp30;
        this.f6123d = f2;
        this.f6124e = f2 * 0.33333334f;
        this.f6126g = f2 * 0.6666667f;
        this.f6125f = 0.33333334f * f2;
        this.f6127h = f2 * 0.6666667f;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, (getWidth() / 2.0f) - 1.0f, this.f6128i ? this.b : this.a);
        canvas.drawLine(this.f6124e, this.f6125f, this.f6126g, this.f6127h, this.f6122c);
        canvas.drawLine(this.f6126g, this.f6125f, this.f6124e, this.f6127h, this.f6122c);
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i2);
        float f2 = this.f6123d;
        setMeasuredDimension((int) f2, (int) f2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f6128i = true;
            invalidate();
            return true;
        } else if (motionEvent.getAction() == 1) {
            this.f6128i = false;
            invalidate();
            performClick();
            return true;
        } else {
            return super.onTouchEvent(motionEvent);
        }
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }
}
