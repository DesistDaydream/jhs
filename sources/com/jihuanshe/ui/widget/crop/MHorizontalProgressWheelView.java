package com.jihuanshe.ui.widget.crop;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.core.content.ContextCompat;
import com.jihuanshe.R;
import e.t.o.d;
import h.k2.h;
import h.k2.v.u;
import h.o2.q;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class MHorizontalProgressWheelView extends View {
    @d
    private final Rect a;
    @e
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private float f4267c;
    @d

    /* renamed from: d  reason: collision with root package name */
    private Paint f4268d;
    @d

    /* renamed from: e  reason: collision with root package name */
    private Paint f4269e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private TextPaint f4270f;
    @e

    /* renamed from: g  reason: collision with root package name */
    private Paint f4271g;

    /* renamed from: h  reason: collision with root package name */
    private int f4272h;

    /* renamed from: i  reason: collision with root package name */
    private int f4273i;

    /* renamed from: j  reason: collision with root package name */
    private int f4274j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4275k;

    /* renamed from: l  reason: collision with root package name */
    private float f4276l;

    /* renamed from: m  reason: collision with root package name */
    private int f4277m;
    private final int n;
    private final int o;
    private final int p;
    private final int q;
    private final float r;
    private final float s;
    private final float t;
    private float u;
    private int v;
    private float w;
    @d
    private final List<e.l.q.c.q0.a> x;

    /* loaded from: classes2.dex */
    public interface a {
        void a(float f2, float f3, float f4);

        void onScrollEnd();

        void onScrollStart();
    }

    @h
    public MHorizontalProgressWheelView(@e Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public MHorizontalProgressWheelView(@e Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    @h
    public MHorizontalProgressWheelView(@e Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        int i3;
        int i4;
        Paint paint;
        String str;
        this.a = new Rect();
        this.f4268d = new Paint(1);
        this.f4269e = new Paint(1);
        this.f4270f = new TextPaint();
        d.a aVar = e.t.o.d.a;
        this.f4274j = d.a.c(aVar, null, 1, null).d(10);
        this.n = d.a.c(aVar, null, 1, null).d(1);
        this.o = d.a.c(aVar, null, 1, null).d(2);
        this.p = d.a.c(aVar, null, 1, null).d(6);
        this.q = d.a.c(aVar, null, 1, null).d(10);
        this.r = d.a.c(aVar, null, 1, null).d(16);
        this.s = d.a.c(aVar, null, 1, null).d(30);
        this.t = d.a.c(aVar, null, 1, null).d(8);
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        for (int i6 = -180; i6 <= 180; i6 += 2) {
            if (i6 % 10 == 0) {
                i3 = this.o;
                i4 = this.q;
                str = String.valueOf(i6);
                paint = this.f4269e;
            } else {
                i3 = this.n;
                i4 = this.p;
                paint = this.f4268d;
                str = null;
            }
            arrayList.add(new e.l.q.c.q0.a(i3, i4, str, paint));
            if (i6 < 0) {
                i5 += i3 + this.f4274j;
            }
        }
        this.v = i5;
        this.u = 180.0f / i5;
        t1 t1Var = t1.a;
        this.x = arrayList;
        a();
    }

    private final void a() {
        this.f4277m = ContextCompat.getColor(getContext(), R.color.ucrop_color_widget_rotate_mid_line);
        this.f4272h = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_horizontal_wheel_progress_line);
        this.f4273i = getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_height_horizontal_wheel_progress_line);
        this.f4268d.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4268d.setColor(Color.parseColor("#80ffffff"));
        this.f4269e.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4269e.setColor(Color.parseColor("#ccffffff"));
        this.f4270f.setTextSize(d.a.c(e.t.o.d.a, null, 1, null).d(11));
        this.f4270f.setColor(-1);
        Paint paint = new Paint(1);
        this.f4271g = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f4271g.setColor(this.f4277m);
        this.f4271g.setStrokeCap(Paint.Cap.ROUND);
        this.f4271g.setStrokeWidth(getContext().getResources().getDimensionPixelSize(R.dimen.ucrop_width_middle_wheel_progress_line));
    }

    private final void b(MotionEvent motionEvent, float f2) {
        float t;
        float f3 = this.f4276l;
        if (f2 < 0.0f) {
            t = q.m(f3 + f2, -this.v);
        } else {
            t = q.t(f3 + f2, this.v);
        }
        this.f4276l = t;
        if (f3 == t) {
            return;
        }
        postInvalidate();
        this.f4267c = motionEvent.getX();
        this.w += this.u * f2;
        a aVar = this.b;
        if (aVar != null) {
            aVar.a(-f2, this.f4276l, this.u * f2);
        }
    }

    public final void c(float f2) {
        float f3 = this.w + f2;
        this.w = f3;
        if (f3 > 180.0f) {
            this.w = f3 - 360;
        } else if (f3 < -180.0f) {
            this.w = f3 + 360;
        }
        this.f4276l = this.w / this.u;
        postInvalidate();
    }

    @Override // android.view.View
    public void onDraw(@k.e.a.d Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(0.0f, getMeasuredHeight() / 2.0f);
        canvas.getClipBounds(this.a);
        canvas.save();
        canvas.translate((-this.f4276l) - this.v, 0.0f);
        float measuredWidth = getMeasuredWidth() / 2.0f;
        int i2 = 0;
        for (Object obj : this.x) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            e.l.q.c.q0.a aVar = (e.l.q.c.q0.a) obj;
            canvas.drawRect(measuredWidth, this.t - (aVar.g() / 2), measuredWidth + aVar.h(), this.t + (aVar.g() / 2), aVar.i());
            String j2 = aVar.j();
            if (!(j2 == null || j2.length() == 0)) {
                canvas.drawText(aVar.j(), measuredWidth - (this.f4270f.measureText(aVar.j()) / 2.0f), this.s, this.f4270f);
            }
            measuredWidth += this.f4274j + aVar.h();
            i2 = i3;
        }
        canvas.restore();
        float f2 = 2;
        canvas.drawLine(this.a.centerX(), this.t - (this.r / f2), this.a.centerX(), this.t + (this.r / f2), this.f4271g);
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
        if (r0 != 3) goto L9;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(@k.e.a.d android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 1
            if (r0 == 0) goto L3b
            r2 = 0
            if (r0 == r1) goto L31
            r3 = 2
            if (r0 == r3) goto L11
            r5 = 3
            if (r0 == r5) goto L31
            goto L41
        L11:
            float r0 = r5.getX()
            float r3 = r4.f4267c
            float r0 = r0 - r3
            r3 = 0
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 != 0) goto L1e
            r2 = 1
        L1e:
            if (r2 != 0) goto L41
            boolean r2 = r4.f4275k
            if (r2 != 0) goto L2d
            r4.f4275k = r1
            com.jihuanshe.ui.widget.crop.MHorizontalProgressWheelView$a r2 = r4.b
            if (r2 == 0) goto L2d
            r2.onScrollStart()
        L2d:
            r4.b(r5, r0)
            goto L41
        L31:
            com.jihuanshe.ui.widget.crop.MHorizontalProgressWheelView$a r5 = r4.b
            if (r5 == 0) goto L41
            r4.f4275k = r2
            r5.onScrollEnd()
            goto L41
        L3b:
            float r5 = r5.getX()
            r4.f4267c = r5
        L41:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.widget.crop.MHorizontalProgressWheelView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void setMiddleLineColor(@ColorInt int i2) {
        this.f4277m = i2;
        this.f4271g.setColor(this.f4277m);
        invalidate();
    }

    public final void setScrollingListener(@e a aVar) {
        this.b = aVar;
    }

    public /* synthetic */ MHorizontalProgressWheelView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    @TargetApi(21)
    public MHorizontalProgressWheelView(@e Context context, @e AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        int i4;
        int i5;
        Paint paint;
        String str;
        this.a = new Rect();
        this.f4268d = new Paint(1);
        this.f4269e = new Paint(1);
        this.f4270f = new TextPaint();
        d.a aVar = e.t.o.d.a;
        this.f4274j = d.a.c(aVar, null, 1, null).d(10);
        this.n = d.a.c(aVar, null, 1, null).d(1);
        this.o = d.a.c(aVar, null, 1, null).d(2);
        this.p = d.a.c(aVar, null, 1, null).d(6);
        this.q = d.a.c(aVar, null, 1, null).d(10);
        this.r = d.a.c(aVar, null, 1, null).d(16);
        this.s = d.a.c(aVar, null, 1, null).d(30);
        this.t = d.a.c(aVar, null, 1, null).d(8);
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (int i7 = -180; i7 <= 180; i7 += 2) {
            if (i7 % 10 == 0) {
                i4 = this.o;
                i5 = this.q;
                str = String.valueOf(i7);
                paint = this.f4269e;
            } else {
                i4 = this.n;
                i5 = this.p;
                paint = this.f4268d;
                str = null;
            }
            arrayList.add(new e.l.q.c.q0.a(i4, i5, str, paint));
            if (i7 < 0) {
                i6 += i4 + this.f4274j;
            }
        }
        this.v = i6;
        this.u = 180.0f / i6;
        t1 t1Var = t1.a;
        this.x = arrayList;
    }
}
