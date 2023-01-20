package e.i.a.a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;

/* loaded from: classes.dex */
public class l implements View.OnTouchListener, View.OnLayoutChangeListener {
    private static float F = 3.0f;
    private static float G = 1.75f;
    private static float H = 1.0f;
    private static int I = 200;
    private static final int J = -1;
    private static final int K = 0;
    private static final int L = 1;
    private static final int M = 2;
    private static final int N = -1;
    private static final int O = 0;
    private static final int P = 1;
    private static final int Q = 2;
    private static int R = 1;
    private float B;

    /* renamed from: h  reason: collision with root package name */
    private ImageView f10055h;

    /* renamed from: i  reason: collision with root package name */
    private GestureDetector f10056i;

    /* renamed from: j  reason: collision with root package name */
    private e.i.a.a.c f10057j;
    private e.i.a.a.e p;
    private g q;
    private e.i.a.a.f r;
    private k s;
    private View.OnClickListener t;
    private View.OnLongClickListener u;
    private h v;
    private i w;
    private j x;
    private f y;
    private Interpolator a = new AccelerateDecelerateInterpolator();
    private int b = I;

    /* renamed from: c  reason: collision with root package name */
    private float f10050c = H;

    /* renamed from: d  reason: collision with root package name */
    private float f10051d = G;

    /* renamed from: e  reason: collision with root package name */
    private float f10052e = F;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10053f = true;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10054g = false;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f10058k = new Matrix();

    /* renamed from: l  reason: collision with root package name */
    private final Matrix f10059l = new Matrix();

    /* renamed from: m  reason: collision with root package name */
    private final Matrix f10060m = new Matrix();
    private final RectF n = new RectF();
    private final float[] o = new float[9];
    private int z = 2;
    private int A = 2;
    private boolean C = true;
    private ImageView.ScaleType D = ImageView.ScaleType.FIT_CENTER;
    private e.i.a.a.d E = new a();

    /* loaded from: classes.dex */
    public class a implements e.i.a.a.d {
        public a() {
        }

        @Override // e.i.a.a.d
        public void onDrag(float f2, float f3) {
            if (l.this.f10057j.e()) {
                return;
            }
            if (l.this.x != null) {
                l.this.x.onDrag(f2, f3);
            }
            l.this.f10060m.postTranslate(f2, f3);
            l.this.B();
            ViewParent parent = l.this.f10055h.getParent();
            if (!l.this.f10053f || l.this.f10057j.e() || l.this.f10054g) {
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
            } else if ((l.this.z == 2 || ((l.this.z == 0 && f2 >= 1.0f) || ((l.this.z == 1 && f2 <= -1.0f) || ((l.this.A == 0 && f3 >= 1.0f) || (l.this.A == 1 && f3 <= -1.0f))))) && parent != null) {
                parent.requestDisallowInterceptTouchEvent(false);
            }
        }

        @Override // e.i.a.a.d
        public void onFling(float f2, float f3, float f4, float f5) {
            l lVar = l.this;
            lVar.y = new f(lVar.f10055h.getContext());
            f fVar = l.this.y;
            l lVar2 = l.this;
            int J = lVar2.J(lVar2.f10055h);
            l lVar3 = l.this;
            fVar.b(J, lVar3.I(lVar3.f10055h), (int) f4, (int) f5);
            l.this.f10055h.post(l.this.y);
        }

        @Override // e.i.a.a.d
        public void onScale(float f2, float f3, float f4) {
            if (l.this.N() < l.this.f10052e || f2 < 1.0f) {
                if (l.this.v != null) {
                    l.this.v.onScaleChange(f2, f3, f4);
                }
                l.this.f10060m.postScale(f2, f2, f3, f4);
                l.this.B();
            }
        }
    }

    /* loaded from: classes.dex */
    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (l.this.w == null || l.this.N() > l.H || motionEvent.getPointerCount() > l.R || motionEvent2.getPointerCount() > l.R) {
                return false;
            }
            return l.this.w.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (l.this.u != null) {
                l.this.u.onLongClick(l.this.f10055h);
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements GestureDetector.OnDoubleTapListener {
        public c() {
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            try {
                float N = l.this.N();
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (N < l.this.L()) {
                    l lVar = l.this;
                    lVar.o0(lVar.L(), x, y, true);
                } else if (N >= l.this.L() && N < l.this.K()) {
                    l lVar2 = l.this;
                    lVar2.o0(lVar2.K(), x, y, true);
                } else {
                    l lVar3 = l.this;
                    lVar3.o0(lVar3.M(), x, y, true);
                }
            } catch (ArrayIndexOutOfBoundsException unused) {
            }
            return true;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (l.this.t != null) {
                l.this.t.onClick(l.this.f10055h);
            }
            RectF E = l.this.E();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (l.this.s != null) {
                l.this.s.onViewTap(l.this.f10055h, x, y);
            }
            if (E != null) {
                if (!E.contains(x, y)) {
                    if (l.this.r != null) {
                        l.this.r.onOutsidePhotoTap(l.this.f10055h);
                        return false;
                    }
                    return false;
                }
                float width = (x - E.left) / E.width();
                float height = (y - E.top) / E.height();
                if (l.this.q != null) {
                    l.this.q.onPhotoTap(l.this.f10055h, width, height);
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class d {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements Runnable {
        private final float a;
        private final float b;

        /* renamed from: c  reason: collision with root package name */
        private final long f10061c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f10062d;

        /* renamed from: e  reason: collision with root package name */
        private final float f10063e;

        public e(float f2, float f3, float f4, float f5) {
            this.a = f4;
            this.b = f5;
            this.f10062d = f2;
            this.f10063e = f3;
        }

        private float a() {
            return l.this.a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f10061c)) * 1.0f) / l.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            float a = a();
            float f2 = this.f10062d;
            l.this.E.onScale((f2 + ((this.f10063e - f2) * a)) / l.this.N(), this.a, this.b);
            if (a < 1.0f) {
                e.i.a.a.b.a(l.this.f10055h, this);
            }
        }
    }

    /* loaded from: classes.dex */
    public class f implements Runnable {
        private final OverScroller a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f10065c;

        public f(Context context) {
            this.a = new OverScroller(context);
        }

        public void a() {
            this.a.forceFinished(true);
        }

        public void b(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF E = l.this.E();
            if (E == null) {
                return;
            }
            int round = Math.round(-E.left);
            float f2 = i2;
            if (f2 < E.width()) {
                i7 = Math.round(E.width() - f2);
                i6 = 0;
            } else {
                i6 = round;
                i7 = i6;
            }
            int round2 = Math.round(-E.top);
            float f3 = i3;
            if (f3 < E.height()) {
                i9 = Math.round(E.height() - f3);
                i8 = 0;
            } else {
                i8 = round2;
                i9 = i8;
            }
            this.b = round;
            this.f10065c = round2;
            if (round == i7 && round2 == i9) {
                return;
            }
            this.a.fling(round, round2, i4, i5, i6, i7, i8, i9, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.a.isFinished() && this.a.computeScrollOffset()) {
                int currX = this.a.getCurrX();
                int currY = this.a.getCurrY();
                l.this.f10060m.postTranslate(this.b - currX, this.f10065c - currY);
                l.this.B();
                this.b = currX;
                this.f10065c = currY;
                e.i.a.a.b.a(l.this.f10055h, this);
            }
        }
    }

    public l(ImageView imageView) {
        this.f10055h = imageView;
        imageView.setOnTouchListener(this);
        imageView.addOnLayoutChangeListener(this);
        if (imageView.isInEditMode()) {
            return;
        }
        this.B = 0.0f;
        this.f10057j = new e.i.a.a.c(imageView.getContext(), this.E);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new b());
        this.f10056i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new c());
    }

    private void A() {
        f fVar = this.y;
        if (fVar != null) {
            fVar.a();
            this.y = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B() {
        if (C()) {
            X(G());
        }
    }

    private boolean C() {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        RectF F2 = F(G());
        if (F2 == null) {
            return false;
        }
        float height = F2.height();
        float width = F2.width();
        float I2 = I(this.f10055h);
        float f7 = 0.0f;
        if (height <= I2) {
            int i2 = d.a[this.D.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    f5 = (I2 - height) / 2.0f;
                    f6 = F2.top;
                } else {
                    f5 = I2 - height;
                    f6 = F2.top;
                }
                f2 = f5 - f6;
            } else {
                f2 = -F2.top;
            }
            this.A = 2;
        } else {
            float f8 = F2.top;
            if (f8 > 0.0f) {
                this.A = 0;
                f2 = -f8;
            } else {
                float f9 = F2.bottom;
                if (f9 < I2) {
                    this.A = 1;
                    f2 = I2 - f9;
                } else {
                    this.A = -1;
                    f2 = 0.0f;
                }
            }
        }
        float J2 = J(this.f10055h);
        if (width <= J2) {
            int i3 = d.a[this.D.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f3 = (J2 - width) / 2.0f;
                    f4 = F2.left;
                } else {
                    f3 = J2 - width;
                    f4 = F2.left;
                }
                f7 = f3 - f4;
            } else {
                f7 = -F2.left;
            }
            this.z = 2;
        } else {
            float f10 = F2.left;
            if (f10 > 0.0f) {
                this.z = 0;
                f7 = -f10;
            } else {
                float f11 = F2.right;
                if (f11 < J2) {
                    f7 = J2 - f11;
                    this.z = 1;
                } else {
                    this.z = -1;
                }
            }
        }
        this.f10060m.postTranslate(f7, f2);
        return true;
    }

    private RectF F(Matrix matrix) {
        Drawable drawable = this.f10055h.getDrawable();
        if (drawable != null) {
            this.n.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            matrix.mapRect(this.n);
            return this.n;
        }
        return null;
    }

    private Matrix G() {
        this.f10059l.set(this.f10058k);
        this.f10059l.postConcat(this.f10060m);
        return this.f10059l;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int I(ImageView imageView) {
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int J(ImageView imageView) {
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float Q(Matrix matrix, int i2) {
        matrix.getValues(this.o);
        return this.o[i2];
    }

    private void T() {
        this.f10060m.reset();
        l0(this.B);
        X(G());
        C();
    }

    private void X(Matrix matrix) {
        RectF F2;
        this.f10055h.setImageMatrix(matrix);
        if (this.p == null || (F2 = F(matrix)) == null) {
            return;
        }
        this.p.onMatrixChanged(F2);
    }

    private void v0(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        float J2 = J(this.f10055h);
        float I2 = I(this.f10055h);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f10058k.reset();
        float f2 = intrinsicWidth;
        float f3 = J2 / f2;
        float f4 = intrinsicHeight;
        float f5 = I2 / f4;
        ImageView.ScaleType scaleType = this.D;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f10058k.postTranslate((J2 - f2) / 2.0f, (I2 - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f3, f5);
            this.f10058k.postScale(max, max);
            this.f10058k.postTranslate((J2 - (f2 * max)) / 2.0f, (I2 - (f4 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f3, f5));
            this.f10058k.postScale(min, min);
            this.f10058k.postTranslate((J2 - (f2 * min)) / 2.0f, (I2 - (f4 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, J2, I2);
            if (((int) this.B) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = d.a[this.D.ordinal()];
            if (i2 == 1) {
                this.f10058k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i2 == 2) {
                this.f10058k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i2 == 3) {
                this.f10058k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i2 == 4) {
                this.f10058k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        T();
    }

    public void D(Matrix matrix) {
        matrix.set(G());
    }

    public RectF E() {
        C();
        return F(G());
    }

    public Matrix H() {
        return this.f10059l;
    }

    public float K() {
        return this.f10052e;
    }

    public float L() {
        return this.f10051d;
    }

    public float M() {
        return this.f10050c;
    }

    public float N() {
        return (float) Math.sqrt(((float) Math.pow(Q(this.f10060m, 0), 2.0d)) + ((float) Math.pow(Q(this.f10060m, 3), 2.0d)));
    }

    public ImageView.ScaleType O() {
        return this.D;
    }

    public void P(Matrix matrix) {
        matrix.set(this.f10060m);
    }

    @Deprecated
    public boolean R() {
        return this.C;
    }

    public boolean S() {
        return this.C;
    }

    public void U(boolean z) {
        this.f10053f = z;
    }

    public void V(float f2) {
        this.B = f2 % 360.0f;
        update();
        l0(this.B);
        B();
    }

    public boolean W(Matrix matrix) {
        if (matrix != null) {
            if (this.f10055h.getDrawable() == null) {
                return false;
            }
            this.f10060m.set(matrix);
            B();
            return true;
        }
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    public void Y(float f2) {
        m.a(this.f10050c, this.f10051d, f2);
        this.f10052e = f2;
    }

    public void Z(float f2) {
        m.a(this.f10050c, f2, this.f10052e);
        this.f10051d = f2;
    }

    public void a0(float f2) {
        m.a(f2, this.f10051d, this.f10052e);
        this.f10050c = f2;
    }

    public void b0(View.OnClickListener onClickListener) {
        this.t = onClickListener;
    }

    public void c0(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.f10056i.setOnDoubleTapListener(onDoubleTapListener);
    }

    public void d0(View.OnLongClickListener onLongClickListener) {
        this.u = onLongClickListener;
    }

    public void e0(e.i.a.a.e eVar) {
        this.p = eVar;
    }

    public void f0(e.i.a.a.f fVar) {
        this.r = fVar;
    }

    public void g0(g gVar) {
        this.q = gVar;
    }

    public void h0(h hVar) {
        this.v = hVar;
    }

    public void i0(i iVar) {
        this.w = iVar;
    }

    public void j0(j jVar) {
        this.x = jVar;
    }

    public void k0(k kVar) {
        this.s = kVar;
    }

    public void l0(float f2) {
        this.f10060m.postRotate(f2 % 360.0f);
        B();
    }

    public void m0(float f2) {
        this.f10060m.setRotate(f2 % 360.0f);
        B();
    }

    public void n0(float f2) {
        p0(f2, false);
    }

    public void o0(float f2, float f3, float f4, boolean z) {
        if (f2 < this.f10050c || f2 > this.f10052e) {
            throw new IllegalArgumentException("Scale must be within the range of minScale and maxScale");
        }
        if (z) {
            this.f10055h.post(new e(N(), f2, f3, f4));
            return;
        }
        this.f10060m.setScale(f2, f2, f3, f4);
        B();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        if (i2 == i6 && i3 == i7 && i4 == i8 && i5 == i9) {
            return;
        }
        v0(this.f10055h.getDrawable());
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b2  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouch(android.view.View r11, android.view.MotionEvent r12) {
        /*
            r10 = this;
            boolean r0 = r10.C
            r1 = 0
            r2 = 1
            if (r0 == 0) goto Lbe
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = e.i.a.a.m.c(r0)
            if (r0 == 0) goto Lbe
            int r0 = r12.getAction()
            if (r0 == 0) goto L6e
            if (r0 == r2) goto L1b
            r3 = 3
            if (r0 == r3) goto L1b
            goto L7a
        L1b:
            float r0 = r10.N()
            float r3 = r10.f10050c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
            android.graphics.RectF r0 = r10.E()
            if (r0 == 0) goto L7a
            e.i.a.a.l$e r9 = new e.i.a.a.l$e
            float r5 = r10.N()
            float r6 = r10.f10050c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            goto L6c
        L44:
            float r0 = r10.N()
            float r3 = r10.f10052e
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 <= 0) goto L7a
            android.graphics.RectF r0 = r10.E()
            if (r0 == 0) goto L7a
            e.i.a.a.l$e r9 = new e.i.a.a.l$e
            float r5 = r10.N()
            float r6 = r10.f10052e
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
        L6c:
            r11 = 1
            goto L7b
        L6e:
            android.view.ViewParent r11 = r11.getParent()
            if (r11 == 0) goto L77
            r11.requestDisallowInterceptTouchEvent(r2)
        L77:
            r10.A()
        L7a:
            r11 = 0
        L7b:
            e.i.a.a.c r0 = r10.f10057j
            if (r0 == 0) goto Lb2
            boolean r11 = r0.e()
            e.i.a.a.c r0 = r10.f10057j
            boolean r0 = r0.d()
            e.i.a.a.c r3 = r10.f10057j
            boolean r3 = r3.f(r12)
            if (r11 != 0) goto L9b
            e.i.a.a.c r11 = r10.f10057j
            boolean r11 = r11.e()
            if (r11 != 0) goto L9b
            r11 = 1
            goto L9c
        L9b:
            r11 = 0
        L9c:
            if (r0 != 0) goto La8
            e.i.a.a.c r0 = r10.f10057j
            boolean r0 = r0.d()
            if (r0 != 0) goto La8
            r0 = 1
            goto La9
        La8:
            r0 = 0
        La9:
            if (r11 == 0) goto Lae
            if (r0 == 0) goto Lae
            r1 = 1
        Lae:
            r10.f10054g = r1
            r1 = r3
            goto Lb3
        Lb2:
            r1 = r11
        Lb3:
            android.view.GestureDetector r11 = r10.f10056i
            if (r11 == 0) goto Lbe
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto Lbe
            r1 = 1
        Lbe:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.i.a.a.l.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public void p0(float f2, boolean z) {
        o0(f2, this.f10055h.getRight() / 2, this.f10055h.getBottom() / 2, z);
    }

    public void q0(float f2, float f3, float f4) {
        m.a(f2, f3, f4);
        this.f10050c = f2;
        this.f10051d = f3;
        this.f10052e = f4;
    }

    public void r0(ImageView.ScaleType scaleType) {
        if (!m.d(scaleType) || scaleType == this.D) {
            return;
        }
        this.D = scaleType;
        update();
    }

    public void s0(Interpolator interpolator) {
        this.a = interpolator;
    }

    public void t0(int i2) {
        this.b = i2;
    }

    public void u0(boolean z) {
        this.C = z;
        update();
    }

    public void update() {
        if (this.C) {
            v0(this.f10055h.getDrawable());
        } else {
            T();
        }
    }
}
