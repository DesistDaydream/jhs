package com.aigestudio.wheelpicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.huawei.hms.support.api.entity.core.JosStatusCodes;
import com.xiaomi.mipush.sdk.Constants;
import e.a.a.c;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
public class WheelPicker extends View implements e.a.a.b, c, Runnable {
    public static final int g0 = 0;
    public static final int h0 = 1;
    public static final int i0 = 2;
    public static final int j0 = 0;
    public static final int k0 = 1;
    public static final int l0 = 2;
    private static final String m0 = WheelPicker.class.getSimpleName();
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private int R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private boolean W;
    private final Handler a;
    private boolean a0;
    private Paint b;
    private boolean b0;

    /* renamed from: c  reason: collision with root package name */
    private Scroller f1378c;
    private boolean c0;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f1379d;
    private boolean d0;

    /* renamed from: e  reason: collision with root package name */
    private a f1380e;
    private boolean e0;

    /* renamed from: f  reason: collision with root package name */
    private b f1381f;
    private boolean f0;

    /* renamed from: g  reason: collision with root package name */
    private Rect f1382g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f1383h;

    /* renamed from: i  reason: collision with root package name */
    private Rect f1384i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f1385j;

    /* renamed from: k  reason: collision with root package name */
    private Camera f1386k;

    /* renamed from: l  reason: collision with root package name */
    private Matrix f1387l;

    /* renamed from: m  reason: collision with root package name */
    private Matrix f1388m;
    private List n;
    private String o;
    private int p;
    private int q;
    private int r;
    private int s;
    private int t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* loaded from: classes.dex */
    public interface a {
        void e(WheelPicker wheelPicker, Object obj, int i2);
    }

    /* loaded from: classes.dex */
    public interface b {
        void a(int i2);

        void b(int i2);

        void c(int i2);
    }

    public WheelPicker(Context context) {
        this(context, null);
    }

    private void e() {
        if (this.W || this.v != -1) {
            Rect rect = this.f1385j;
            Rect rect2 = this.f1382g;
            int i2 = rect2.left;
            int i3 = this.M;
            int i4 = this.D;
            rect.set(i2, i3 - i4, rect2.right, i3 + i4);
        }
    }

    private int j(int i2) {
        return (int) (this.E - (Math.cos(Math.toRadians(i2)) * this.E));
    }

    private int k(int i2) {
        int i3;
        if (Math.abs(i2) > this.D) {
            if (this.P < 0) {
                i3 = -this.C;
            } else {
                i3 = this.C;
            }
            return i3 - i2;
        }
        return -i2;
    }

    private void l() {
        int i2 = this.B;
        if (i2 == 1) {
            this.N = this.f1382g.left;
        } else if (i2 != 2) {
            this.N = this.L;
        } else {
            this.N = this.f1382g.right;
        }
        this.O = (int) (this.M - ((this.b.ascent() + this.b.descent()) / 2.0f));
    }

    private void m() {
        int i2 = this.F;
        int i3 = this.C;
        int i4 = i2 * i3;
        this.H = this.b0 ? Integer.MIN_VALUE : ((-i3) * (this.n.size() - 1)) + i4;
        if (this.b0) {
            i4 = Integer.MAX_VALUE;
        }
        this.I = i4;
    }

    private void n() {
        if (this.V) {
            int i2 = this.x / 2;
            int i3 = this.M;
            int i4 = this.D;
            int i5 = i3 + i4;
            int i6 = i3 - i4;
            Rect rect = this.f1383h;
            Rect rect2 = this.f1382g;
            rect.set(rect2.left, i5 - i2, rect2.right, i5 + i2);
            Rect rect3 = this.f1384i;
            Rect rect4 = this.f1382g;
            rect3.set(rect4.left, i6 - i2, rect4.right, i6 + i2);
        }
    }

    private int o(int i2) {
        return (int) (Math.sin(Math.toRadians(i2)) * this.E);
    }

    private void p() {
        this.t = 0;
        this.s = 0;
        if (this.U) {
            this.s = (int) this.b.measureText(String.valueOf(this.n.get(0)));
        } else if (q(this.Q)) {
            this.s = (int) this.b.measureText(String.valueOf(this.n.get(this.Q)));
        } else if (!TextUtils.isEmpty(this.o)) {
            this.s = (int) this.b.measureText(this.o);
        } else {
            for (Object obj : this.n) {
                String valueOf = String.valueOf(obj);
                this.s = Math.max(this.s, (int) this.b.measureText(valueOf));
            }
        }
        Paint.FontMetrics fontMetrics = this.b.getFontMetrics();
        this.t = (int) (fontMetrics.bottom - fontMetrics.top);
    }

    private boolean q(int i2) {
        return i2 >= 0 && i2 < this.n.size();
    }

    private int r(int i2, int i3, int i4) {
        return i2 == 1073741824 ? i3 : i2 == Integer.MIN_VALUE ? Math.min(i4, i3) : i4;
    }

    private void s() {
        int i2 = this.B;
        if (i2 == 1) {
            this.b.setTextAlign(Paint.Align.LEFT);
        } else if (i2 != 2) {
            this.b.setTextAlign(Paint.Align.CENTER);
        } else {
            this.b.setTextAlign(Paint.Align.RIGHT);
        }
    }

    private void t() {
        int i2 = this.p;
        if (i2 >= 2) {
            if (i2 % 2 == 0) {
                this.p = i2 + 1;
            }
            int i3 = this.p + 2;
            this.q = i3;
            this.r = i3 / 2;
            return;
        }
        throw new ArithmeticException("Wheel's visible item count can not be less than 2!");
    }

    @Override // e.a.a.c
    public boolean a() {
        return this.U;
    }

    @Override // e.a.a.c
    public boolean b() {
        return this.b0;
    }

    @Override // e.a.a.c
    public boolean c() {
        return this.a0;
    }

    @Override // e.a.a.c
    public boolean g() {
        return this.c0;
    }

    @Override // e.a.a.c
    public int getCurrentItemPosition() {
        return this.G;
    }

    @Override // e.a.a.c
    public int getCurtainColor() {
        return this.z;
    }

    @Override // e.a.a.c
    public List getData() {
        return this.n;
    }

    @Override // e.a.a.c
    public int getIndicatorColor() {
        return this.y;
    }

    @Override // e.a.a.c
    public int getIndicatorSize() {
        return this.x;
    }

    @Override // e.a.a.c
    public int getItemAlign() {
        return this.B;
    }

    @Override // e.a.a.c
    public int getItemSpace() {
        return this.A;
    }

    @Override // e.a.a.c
    public int getItemTextColor() {
        return this.u;
    }

    @Override // e.a.a.c
    public int getItemTextSize() {
        return this.w;
    }

    @Override // e.a.a.c
    public String getMaximumWidthText() {
        return this.o;
    }

    @Override // e.a.a.c
    public int getMaximumWidthTextPosition() {
        return this.Q;
    }

    @Override // e.a.a.c
    public int getSelectedItemPosition() {
        return this.F;
    }

    @Override // e.a.a.c
    public int getSelectedItemTextColor() {
        return this.v;
    }

    @Override // e.a.a.c
    public Typeface getTypeface() {
        Paint paint = this.b;
        if (paint != null) {
            return paint.getTypeface();
        }
        return null;
    }

    @Override // e.a.a.c
    public int getVisibleItemCount() {
        return this.p;
    }

    @Override // e.a.a.c
    public boolean h() {
        return this.W;
    }

    @Override // e.a.a.c
    public boolean i() {
        return this.V;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        String valueOf;
        int i2;
        int i3;
        b bVar = this.f1381f;
        if (bVar != null) {
            bVar.c(this.P);
        }
        int i4 = (-this.P) / this.C;
        int i5 = this.r;
        int i6 = i4 - i5;
        int i7 = this.F + i6;
        int i8 = -i5;
        while (i7 < this.F + i6 + this.q) {
            if (this.b0) {
                int size = i7 % this.n.size();
                if (size < 0) {
                    size += this.n.size();
                }
                valueOf = String.valueOf(this.n.get(size));
            } else {
                valueOf = q(i7) ? String.valueOf(this.n.get(i7)) : "";
            }
            this.b.setColor(this.u);
            this.b.setStyle(Paint.Style.FILL);
            int i9 = this.O;
            int i10 = this.C;
            int i11 = (i8 * i10) + i9 + (this.P % i10);
            if (this.c0) {
                int abs = i9 - Math.abs(i9 - i11);
                int i12 = this.f1382g.top;
                int i13 = this.O;
                float f2 = (-(1.0f - (((abs - i12) * 1.0f) / (i13 - i12)))) * 90.0f * (i11 > i13 ? 1 : i11 < i13 ? -1 : 0);
                if (f2 < -90.0f) {
                    f2 = -90.0f;
                }
                float f3 = f2 <= 90.0f ? f2 : 90.0f;
                i2 = o((int) f3);
                int i14 = this.L;
                int i15 = this.B;
                if (i15 == 1) {
                    i14 = this.f1382g.left;
                } else if (i15 == 2) {
                    i14 = this.f1382g.right;
                }
                int i16 = this.M - i2;
                this.f1386k.save();
                this.f1386k.rotateX(f3);
                this.f1386k.getMatrix(this.f1387l);
                this.f1386k.restore();
                float f4 = -i14;
                float f5 = -i16;
                this.f1387l.preTranslate(f4, f5);
                float f6 = i14;
                float f7 = i16;
                this.f1387l.postTranslate(f6, f7);
                this.f1386k.save();
                this.f1386k.translate(0.0f, 0.0f, j(i3));
                this.f1386k.getMatrix(this.f1388m);
                this.f1386k.restore();
                this.f1388m.preTranslate(f4, f5);
                this.f1388m.postTranslate(f6, f7);
                this.f1387l.postConcat(this.f1388m);
            } else {
                i2 = 0;
            }
            if (this.a0) {
                int i17 = this.O;
                int abs2 = (int) ((((i17 - Math.abs(i17 - i11)) * 1.0f) / this.O) * 255.0f);
                this.b.setAlpha(abs2 < 0 ? 0 : abs2);
            }
            if (this.c0) {
                i11 = this.O - i2;
            }
            if (this.v != -1) {
                canvas.save();
                if (this.c0) {
                    canvas.concat(this.f1387l);
                }
                canvas.clipRect(this.f1385j, Region.Op.DIFFERENCE);
                float f8 = i11;
                canvas.drawText(valueOf, this.N, f8, this.b);
                canvas.restore();
                this.b.setColor(this.v);
                canvas.save();
                if (this.c0) {
                    canvas.concat(this.f1387l);
                }
                canvas.clipRect(this.f1385j);
                canvas.drawText(valueOf, this.N, f8, this.b);
                canvas.restore();
            } else {
                canvas.save();
                canvas.clipRect(this.f1382g);
                if (this.c0) {
                    canvas.concat(this.f1387l);
                }
                canvas.drawText(valueOf, this.N, i11, this.b);
                canvas.restore();
            }
            if (this.f0) {
                canvas.save();
                canvas.clipRect(this.f1382g);
                this.b.setColor(-1166541);
                int i18 = this.M + (this.C * i8);
                Rect rect = this.f1382g;
                float f9 = i18;
                canvas.drawLine(rect.left, f9, rect.right, f9, this.b);
                this.b.setColor(-13421586);
                this.b.setStyle(Paint.Style.STROKE);
                int i19 = i18 - this.D;
                Rect rect2 = this.f1382g;
                canvas.drawRect(rect2.left, i19, rect2.right, i19 + this.C, this.b);
                canvas.restore();
            }
            i7++;
            i8++;
        }
        if (this.W) {
            this.b.setColor(this.z);
            this.b.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.f1385j, this.b);
        }
        if (this.V) {
            this.b.setColor(this.y);
            this.b.setStyle(Paint.Style.FILL);
            canvas.drawRect(this.f1383h, this.b);
            canvas.drawRect(this.f1384i, this.b);
        }
        if (this.f0) {
            this.b.setColor(1144254003);
            this.b.setStyle(Paint.Style.FILL);
            canvas.drawRect(0.0f, 0.0f, getPaddingLeft(), getHeight(), this.b);
            canvas.drawRect(0.0f, 0.0f, getWidth(), getPaddingTop(), this.b);
            canvas.drawRect(getWidth() - getPaddingRight(), 0.0f, getWidth(), getHeight(), this.b);
            canvas.drawRect(0.0f, getHeight() - getPaddingBottom(), getWidth(), getHeight(), this.b);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int i4 = this.s;
        int i5 = this.t;
        int i6 = this.p;
        int i7 = (i5 * i6) + (this.A * (i6 - 1));
        if (this.c0) {
            i7 = (int) ((i7 * 2) / 3.141592653589793d);
        }
        if (this.f0) {
            String str = m0;
            Log.i(str, "Wheel's content size is (" + i4 + Constants.COLON_SEPARATOR + i7 + ")");
        }
        int paddingLeft = i4 + getPaddingLeft() + getPaddingRight();
        int paddingTop = i7 + getPaddingTop() + getPaddingBottom();
        if (this.f0) {
            String str2 = m0;
            Log.i(str2, "Wheel's size is (" + paddingLeft + Constants.COLON_SEPARATOR + paddingTop + ")");
        }
        setMeasuredDimension(r(mode, size, paddingLeft), r(mode2, size2, paddingTop));
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        this.f1382g.set(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom());
        if (this.f0) {
            String str = m0;
            Log.i(str, "Wheel's drawn rect size is (" + this.f1382g.width() + Constants.COLON_SEPARATOR + this.f1382g.height() + ") and location is (" + this.f1382g.left + Constants.COLON_SEPARATOR + this.f1382g.top + ")");
        }
        this.L = this.f1382g.centerX();
        this.M = this.f1382g.centerY();
        l();
        this.E = this.f1382g.height() / 2;
        int height = this.f1382g.height() / this.p;
        this.C = height;
        this.D = height / 2;
        m();
        n();
        e();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            }
            VelocityTracker velocityTracker = this.f1379d;
            if (velocityTracker == null) {
                this.f1379d = VelocityTracker.obtain();
            } else {
                velocityTracker.clear();
            }
            this.f1379d.addMovement(motionEvent);
            if (!this.f1378c.isFinished()) {
                this.f1378c.abortAnimation();
                this.e0 = true;
            }
            int y = (int) motionEvent.getY();
            this.R = y;
            this.S = y;
        } else if (action == 1) {
            if (getParent() != null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
            if (!this.d0) {
                this.f1379d.addMovement(motionEvent);
                if (Build.VERSION.SDK_INT >= 4) {
                    this.f1379d.computeCurrentVelocity(1000, this.K);
                } else {
                    this.f1379d.computeCurrentVelocity(1000);
                }
                this.e0 = false;
                int yVelocity = (int) this.f1379d.getYVelocity();
                if (Math.abs(yVelocity) > this.J) {
                    this.f1378c.fling(0, this.P, 0, yVelocity, 0, 0, this.H, this.I);
                    Scroller scroller = this.f1378c;
                    scroller.setFinalY(scroller.getFinalY() + k(this.f1378c.getFinalY() % this.C));
                } else {
                    Scroller scroller2 = this.f1378c;
                    int i2 = this.P;
                    scroller2.startScroll(0, i2, 0, k(i2 % this.C));
                }
                if (!this.b0) {
                    int finalY = this.f1378c.getFinalY();
                    int i3 = this.I;
                    if (finalY > i3) {
                        this.f1378c.setFinalY(i3);
                    } else {
                        int finalY2 = this.f1378c.getFinalY();
                        int i4 = this.H;
                        if (finalY2 < i4) {
                            this.f1378c.setFinalY(i4);
                        }
                    }
                }
                this.a.post(this);
                VelocityTracker velocityTracker2 = this.f1379d;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.f1379d = null;
                }
            }
        } else if (action != 2) {
            if (action == 3) {
                if (getParent() != null) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
                VelocityTracker velocityTracker3 = this.f1379d;
                if (velocityTracker3 != null) {
                    velocityTracker3.recycle();
                    this.f1379d = null;
                }
            }
        } else if (Math.abs(this.S - motionEvent.getY()) < this.T) {
            this.d0 = true;
        } else {
            this.d0 = false;
            this.f1379d.addMovement(motionEvent);
            b bVar = this.f1381f;
            if (bVar != null) {
                bVar.a(1);
            }
            float y2 = motionEvent.getY() - this.R;
            if (Math.abs(y2) >= 1.0f) {
                this.P = (int) (this.P + y2);
                this.R = (int) motionEvent.getY();
                invalidate();
            }
        }
        return true;
    }

    @Override // java.lang.Runnable
    public void run() {
        List list = this.n;
        if (list == null || list.size() == 0) {
            return;
        }
        if (this.f1378c.isFinished() && !this.e0) {
            int i2 = this.C;
            if (i2 == 0) {
                return;
            }
            int size = (((-this.P) / i2) + this.F) % this.n.size();
            if (size < 0) {
                size += this.n.size();
            }
            if (this.f0) {
                String str = m0;
                Log.i(str, size + Constants.COLON_SEPARATOR + this.n.get(size) + Constants.COLON_SEPARATOR + this.P);
            }
            this.G = size;
            a aVar = this.f1380e;
            if (aVar != null) {
                aVar.e(this, this.n.get(size), size);
            }
            b bVar = this.f1381f;
            if (bVar != null) {
                bVar.b(size);
                this.f1381f.a(0);
            }
        }
        if (this.f1378c.computeScrollOffset()) {
            b bVar2 = this.f1381f;
            if (bVar2 != null) {
                bVar2.a(2);
            }
            this.P = this.f1378c.getCurrY();
            postInvalidate();
            this.a.postDelayed(this, 16L);
        }
    }

    @Override // e.a.a.c
    public void setAtmospheric(boolean z) {
        this.a0 = z;
        invalidate();
    }

    @Override // e.a.a.c
    public void setCurtain(boolean z) {
        this.W = z;
        e();
        invalidate();
    }

    @Override // e.a.a.c
    public void setCurtainColor(int i2) {
        this.z = i2;
        invalidate();
    }

    @Override // e.a.a.c
    public void setCurved(boolean z) {
        this.c0 = z;
        requestLayout();
        invalidate();
    }

    @Override // e.a.a.c
    public void setCyclic(boolean z) {
        this.b0 = z;
        m();
        invalidate();
    }

    @Override // e.a.a.c
    public void setData(List list) {
        Objects.requireNonNull(list, "WheelPicker's data can not be null!");
        this.n = list;
        if (this.F <= list.size() - 1 && this.G <= list.size() - 1) {
            this.F = this.G;
        } else {
            int size = list.size() - 1;
            this.G = size;
            this.F = size;
        }
        this.P = 0;
        p();
        m();
        requestLayout();
        invalidate();
    }

    @Override // e.a.a.b
    public void setDebug(boolean z) {
        this.f0 = z;
    }

    @Override // e.a.a.c
    public void setIndicator(boolean z) {
        this.V = z;
        n();
        invalidate();
    }

    @Override // e.a.a.c
    public void setIndicatorColor(int i2) {
        this.y = i2;
        invalidate();
    }

    @Override // e.a.a.c
    public void setIndicatorSize(int i2) {
        this.x = i2;
        n();
        invalidate();
    }

    @Override // e.a.a.c
    public void setItemAlign(int i2) {
        this.B = i2;
        s();
        l();
        invalidate();
    }

    @Override // e.a.a.c
    public void setItemSpace(int i2) {
        this.A = i2;
        requestLayout();
        invalidate();
    }

    @Override // e.a.a.c
    public void setItemTextColor(int i2) {
        this.u = i2;
        invalidate();
    }

    @Override // e.a.a.c
    public void setItemTextSize(int i2) {
        this.w = i2;
        this.b.setTextSize(i2);
        p();
        requestLayout();
        invalidate();
    }

    @Override // e.a.a.c
    public void setMaximumWidthText(String str) {
        Objects.requireNonNull(str, "Maximum width text can not be null!");
        this.o = str;
        p();
        requestLayout();
        invalidate();
    }

    @Override // e.a.a.c
    public void setMaximumWidthTextPosition(int i2) {
        if (q(i2)) {
            this.Q = i2;
            p();
            requestLayout();
            invalidate();
            return;
        }
        throw new ArrayIndexOutOfBoundsException("Maximum width text Position must in [0, " + this.n.size() + "), but current is " + i2);
    }

    @Override // e.a.a.c
    public void setOnItemSelectedListener(a aVar) {
        this.f1380e = aVar;
    }

    @Override // e.a.a.c
    public void setOnWheelChangeListener(b bVar) {
        this.f1381f = bVar;
    }

    @Override // e.a.a.c
    public void setSameWidth(boolean z) {
        this.U = z;
        p();
        requestLayout();
        invalidate();
    }

    @Override // e.a.a.c
    public void setSelectedItemPosition(int i2) {
        int max = Math.max(Math.min(i2, this.n.size() - 1), 0);
        this.F = max;
        this.G = max;
        this.P = 0;
        m();
        requestLayout();
        invalidate();
    }

    @Override // e.a.a.c
    public void setSelectedItemTextColor(int i2) {
        this.v = i2;
        e();
        invalidate();
    }

    @Override // e.a.a.c
    public void setTypeface(Typeface typeface) {
        Paint paint = this.b;
        if (paint != null) {
            paint.setTypeface(typeface);
        }
        p();
        requestLayout();
        invalidate();
    }

    @Override // e.a.a.c
    public void setVisibleItemCount(int i2) {
        this.p = i2;
        t();
        requestLayout();
    }

    public WheelPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a = new Handler();
        this.J = 50;
        this.K = JosStatusCodes.RTN_CODE_COMMON_ERROR;
        this.T = 8;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.WheelPicker);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.WheelPicker_wheel_data, 0);
        this.n = Arrays.asList(getResources().getStringArray(resourceId == 0 ? R.array.WheelArrayDefault : resourceId));
        this.w = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelPicker_wheel_item_text_size, getResources().getDimensionPixelSize(R.dimen.WheelItemTextSize));
        this.p = obtainStyledAttributes.getInt(R.styleable.WheelPicker_wheel_visible_item_count, 7);
        this.F = obtainStyledAttributes.getInt(R.styleable.WheelPicker_wheel_selected_item_position, 0);
        this.U = obtainStyledAttributes.getBoolean(R.styleable.WheelPicker_wheel_same_width, false);
        this.Q = obtainStyledAttributes.getInt(R.styleable.WheelPicker_wheel_maximum_width_text_position, -1);
        this.o = obtainStyledAttributes.getString(R.styleable.WheelPicker_wheel_maximum_width_text);
        this.v = obtainStyledAttributes.getColor(R.styleable.WheelPicker_wheel_selected_item_text_color, -1);
        this.u = obtainStyledAttributes.getColor(R.styleable.WheelPicker_wheel_item_text_color, -7829368);
        this.A = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelPicker_wheel_item_space, getResources().getDimensionPixelSize(R.dimen.WheelItemSpace));
        this.b0 = obtainStyledAttributes.getBoolean(R.styleable.WheelPicker_wheel_cyclic, false);
        this.V = obtainStyledAttributes.getBoolean(R.styleable.WheelPicker_wheel_indicator, false);
        this.y = obtainStyledAttributes.getColor(R.styleable.WheelPicker_wheel_indicator_color, -1166541);
        this.x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.WheelPicker_wheel_indicator_size, getResources().getDimensionPixelSize(R.dimen.WheelIndicatorSize));
        this.W = obtainStyledAttributes.getBoolean(R.styleable.WheelPicker_wheel_curtain, false);
        this.z = obtainStyledAttributes.getColor(R.styleable.WheelPicker_wheel_curtain_color, -1996488705);
        this.a0 = obtainStyledAttributes.getBoolean(R.styleable.WheelPicker_wheel_atmospheric, false);
        this.c0 = obtainStyledAttributes.getBoolean(R.styleable.WheelPicker_wheel_curved, false);
        this.B = obtainStyledAttributes.getInt(R.styleable.WheelPicker_wheel_item_align, 0);
        obtainStyledAttributes.recycle();
        t();
        Paint paint = new Paint(69);
        this.b = paint;
        paint.setTextSize(this.w);
        s();
        p();
        this.f1378c = new Scroller(getContext());
        if (Build.VERSION.SDK_INT >= 4) {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
            this.J = viewConfiguration.getScaledMinimumFlingVelocity();
            this.K = viewConfiguration.getScaledMaximumFlingVelocity();
            this.T = viewConfiguration.getScaledTouchSlop();
        }
        this.f1382g = new Rect();
        this.f1383h = new Rect();
        this.f1384i = new Rect();
        this.f1385j = new Rect();
        this.f1386k = new Camera();
        this.f1387l = new Matrix();
        this.f1388m = new Matrix();
    }
}
