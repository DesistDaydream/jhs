package e.l.q.c.t0.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.core.view.MotionEventCompat;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public class d implements e.l.q.c.t0.d.c, View.OnTouchListener, e.l.q.c.t0.d.e.e, ViewTreeObserver.OnGlobalLayoutListener {
    public static final int G = -1;
    public static final int H = 0;
    public static final int I = 1;
    public static final int J = 2;
    private int A;
    private float B;
    private boolean C;
    private ImageView.ScaleType D;
    private Interpolator a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    private float f14210c;

    /* renamed from: d  reason: collision with root package name */
    private float f14211d;

    /* renamed from: e  reason: collision with root package name */
    private float f14212e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14213f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14214g;

    /* renamed from: h  reason: collision with root package name */
    private WeakReference<ImageView> f14215h;

    /* renamed from: i  reason: collision with root package name */
    private GestureDetector f14216i;

    /* renamed from: j  reason: collision with root package name */
    private e.l.q.c.t0.d.e.d f14217j;

    /* renamed from: k  reason: collision with root package name */
    private final Matrix f14218k;

    /* renamed from: l  reason: collision with root package name */
    private final Matrix f14219l;

    /* renamed from: m  reason: collision with root package name */
    private final Matrix f14220m;
    private final RectF n;
    private final float[] o;
    private e p;
    private f q;
    private i r;
    private View.OnLongClickListener s;
    private g t;
    private h u;
    private int v;
    private int w;
    private int x;
    private int y;
    private RunnableC0398d z;
    private static final String E = "PhotoViewAttacher";
    private static final boolean F = Log.isLoggable(E, 3);
    public static int K = 1;

    /* loaded from: classes2.dex */
    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (d.this.u == null || d.this.getScale() > 1.0f || MotionEventCompat.getPointerCount(motionEvent) > d.K || MotionEventCompat.getPointerCount(motionEvent2) > d.K) {
                return false;
            }
            return d.this.u.onFling(motionEvent, motionEvent2, f2, f3);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (d.this.r() == null || d.this.s == null || d.this.r().getY() != 0.0f || d.this.r().getX() != 0.0f) {
                return;
            }
            d.this.s.onLongClick(d.this.r());
        }
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.MATRIX.ordinal()] = 1;
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
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements Runnable {
        private final float a;
        private final float b;

        /* renamed from: c  reason: collision with root package name */
        private final long f14221c = System.currentTimeMillis();

        /* renamed from: d  reason: collision with root package name */
        private final float f14222d;

        /* renamed from: e  reason: collision with root package name */
        private final float f14223e;

        public c(float f2, float f3, float f4, float f5) {
            this.a = f4;
            this.b = f5;
            this.f14222d = f2;
            this.f14223e = f3;
        }

        private float a() {
            return d.this.a.getInterpolation(Math.min(1.0f, (((float) (System.currentTimeMillis() - this.f14221c)) * 1.0f) / d.this.b));
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView r = d.this.r();
            if (r == null) {
                return;
            }
            float a = a();
            float f2 = this.f14222d;
            d.this.onScale((f2 + ((this.f14223e - f2) * a)) / d.this.getScale(), this.a, this.b);
            if (a < 1.0f) {
                e.l.q.c.t0.d.a.d(r, this);
            }
        }
    }

    /* renamed from: e.l.q.c.t0.d.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class RunnableC0398d implements Runnable {
        private final e.l.q.c.t0.d.g.d a;
        private int b;

        /* renamed from: c  reason: collision with root package name */
        private int f14225c;

        public RunnableC0398d(Context context) {
            this.a = e.l.q.c.t0.d.g.d.f(context);
        }

        public void a() {
            if (d.F) {
                e.l.q.c.t0.d.f.a.a().d(d.E, "Cancel Fling");
            }
            this.a.c(true);
        }

        public void b(int i2, int i3, int i4, int i5) {
            int i6;
            int i7;
            int i8;
            int i9;
            RectF displayRect = d.this.getDisplayRect();
            if (displayRect == null) {
                return;
            }
            int round = Math.round(-displayRect.left);
            float f2 = i2;
            if (f2 < displayRect.width()) {
                i7 = Math.round(displayRect.width() - f2);
                i6 = 0;
            } else {
                i6 = round;
                i7 = i6;
            }
            int round2 = Math.round(-displayRect.top);
            float f3 = i3;
            if (f3 < displayRect.height()) {
                i9 = Math.round(displayRect.height() - f3);
                i8 = 0;
            } else {
                i8 = round2;
                i9 = i8;
            }
            this.b = round;
            this.f14225c = round2;
            if (d.F) {
                e.l.q.c.t0.d.f.a.a().d(d.E, "fling. StartX:" + round + " StartY:" + round2 + " MaxX:" + i7 + " MaxY:" + i9);
            }
            if (round == i7 && round2 == i9) {
                return;
            }
            this.a.b(round, round2, i4, i5, i6, i7, i8, i9, 0, 0);
        }

        @Override // java.lang.Runnable
        public void run() {
            ImageView r;
            if (this.a.g() || (r = d.this.r()) == null || !this.a.a()) {
                return;
            }
            int d2 = this.a.d();
            int e2 = this.a.e();
            if (d.F) {
                e.l.q.c.t0.d.f.b a = e.l.q.c.t0.d.f.a.a();
                a.d(d.E, "fling run(). CurrentX:" + this.b + " CurrentY:" + this.f14225c + " NewX:" + d2 + " NewY:" + e2);
            }
            d.this.f14220m.postTranslate(this.b - d2, this.f14225c - e2);
            d dVar = d.this;
            dVar.C(dVar.p());
            this.b = d2;
            this.f14225c = e2;
            e.l.q.c.t0.d.a.d(r, this);
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        void onMatrixChanged(RectF rectF);
    }

    /* loaded from: classes2.dex */
    public interface f {
        void a();

        void b(View view, float f2, float f3);
    }

    /* loaded from: classes2.dex */
    public interface g {
        void onScaleChange(float f2, float f3, float f4);
    }

    /* loaded from: classes2.dex */
    public interface h {
        boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3);
    }

    /* loaded from: classes2.dex */
    public interface i {
        void onViewTap(View view, float f2, float f3);
    }

    public d(ImageView imageView) {
        this(imageView, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C(Matrix matrix) {
        RectF o;
        ImageView r = r();
        if (r != null) {
            k();
            r.setImageMatrix(matrix);
            if (this.p == null || (o = o(matrix)) == null) {
                return;
            }
            this.p.onMatrixChanged(o);
        }
    }

    private static void D(ImageView imageView) {
        if (imageView == null || (imageView instanceof e.l.q.c.t0.d.c) || ImageView.ScaleType.MATRIX.equals(imageView.getScaleType())) {
            return;
        }
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void F(Drawable drawable) {
        ImageView r = r();
        if (r == null || drawable == null) {
            return;
        }
        float t = t(r);
        float s = s(r);
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        this.f14218k.reset();
        float f2 = intrinsicWidth;
        float f3 = t / f2;
        float f4 = intrinsicHeight;
        float f5 = s / f4;
        ImageView.ScaleType scaleType = this.D;
        if (scaleType == ImageView.ScaleType.CENTER) {
            this.f14218k.postTranslate((t - f2) / 2.0f, (s - f4) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            float max = Math.max(f3, f5);
            this.f14218k.postScale(max, max);
            this.f14218k.postTranslate((t - (f2 * max)) / 2.0f, (s - (f4 * max)) / 2.0f);
        } else if (scaleType == ImageView.ScaleType.CENTER_INSIDE) {
            float min = Math.min(1.0f, Math.min(f3, f5));
            this.f14218k.postScale(min, min);
            this.f14218k.postTranslate((t - (f2 * min)) / 2.0f, (s - (f4 * min)) / 2.0f);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, f2, f4);
            RectF rectF2 = new RectF(0.0f, 0.0f, t, s);
            if (((int) this.B) % 180 != 0) {
                rectF = new RectF(0.0f, 0.0f, f4, f2);
            }
            int i2 = b.a[this.D.ordinal()];
            if (i2 == 2) {
                this.f14218k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.START);
            } else if (i2 == 3) {
                this.f14218k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.END);
            } else if (i2 == 4) {
                this.f14218k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
            } else if (i2 == 5) {
                this.f14218k.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.FILL);
            }
        }
        A();
    }

    private void i() {
        RunnableC0398d runnableC0398d = this.z;
        if (runnableC0398d != null) {
            runnableC0398d.a();
            this.z = null;
        }
    }

    private void j() {
        if (l()) {
            C(p());
        }
    }

    private void k() {
        ImageView r = r();
        if (r != null && !(r instanceof e.l.q.c.t0.d.c) && !ImageView.ScaleType.MATRIX.equals(r.getScaleType())) {
            throw new IllegalStateException("The ImageView's ScaleType has been changed since attaching a PhotoViewAttacher. You should call setScaleType on the PhotoViewAttacher instead of on the ImageView");
        }
    }

    private boolean l() {
        RectF o;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        float f7;
        ImageView r = r();
        if (r == null || (o = o(p())) == null) {
            return false;
        }
        float height = o.height();
        float width = o.width();
        float s = s(r);
        float f8 = 0.0f;
        if (height <= s) {
            int i2 = b.a[this.D.ordinal()];
            if (i2 != 2) {
                if (i2 != 3) {
                    s = (s - height) / 2.0f;
                    f3 = o.top;
                } else {
                    s -= height;
                    f3 = o.top;
                }
                f4 = s - f3;
            } else {
                f2 = o.top;
                f4 = -f2;
            }
        } else {
            f2 = o.top;
            if (f2 <= 0.0f) {
                f3 = o.bottom;
                if (f3 >= s) {
                    f4 = 0.0f;
                }
                f4 = s - f3;
            }
            f4 = -f2;
        }
        float t = t(r);
        if (width <= t) {
            int i3 = b.a[this.D.ordinal()];
            if (i3 != 2) {
                if (i3 != 3) {
                    f6 = (t - width) / 2.0f;
                    f7 = o.left;
                } else {
                    f6 = t - width;
                    f7 = o.left;
                }
                f5 = f6 - f7;
            } else {
                f5 = -o.left;
            }
            f8 = f5;
            this.A = 2;
        } else {
            float f9 = o.left;
            if (f9 > 0.0f) {
                this.A = 0;
                f8 = -f9;
            } else {
                float f10 = o.right;
                if (f10 < t) {
                    f8 = t - f10;
                    this.A = 1;
                } else {
                    this.A = -1;
                }
            }
        }
        this.f14220m.postTranslate(f8, f4);
        return true;
    }

    private static void m(float f2, float f3, float f4) {
        if (f2 >= f3) {
            throw new IllegalArgumentException("Minimum zoom has to be less than Medium zoom. Call setMinimumZoom() with a more appropriate value");
        }
        if (f3 >= f4) {
            throw new IllegalArgumentException("Medium zoom has to be less than Maximum zoom. Call setMaximumZoom() with a more appropriate value");
        }
    }

    private RectF o(Matrix matrix) {
        Drawable drawable;
        ImageView r = r();
        if (r == null || (drawable = r.getDrawable()) == null) {
            return null;
        }
        this.n.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        matrix.mapRect(this.n);
        return this.n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Matrix p() {
        this.f14219l.set(this.f14218k);
        this.f14219l.postConcat(this.f14220m);
        return this.f14219l;
    }

    private int s(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getHeight() - imageView.getPaddingTop()) - imageView.getPaddingBottom();
    }

    private int t(ImageView imageView) {
        if (imageView == null) {
            return 0;
        }
        return (imageView.getWidth() - imageView.getPaddingLeft()) - imageView.getPaddingRight();
    }

    private float x(Matrix matrix, int i2) {
        matrix.getValues(this.o);
        return this.o[i2];
    }

    private static boolean y(ImageView imageView) {
        return (imageView == null || imageView.getDrawable() == null) ? false : true;
    }

    private static boolean z(ImageView.ScaleType scaleType) {
        if (scaleType == null) {
            return false;
        }
        if (b.a[scaleType.ordinal()] != 1) {
            return true;
        }
        throw new IllegalArgumentException(scaleType.name() + " is not supported in PhotoView");
    }

    public void A() {
        this.f14220m.reset();
        setRotationBy(this.B);
        C(p());
        l();
    }

    public void B(float f2) {
        this.B = f2 % 360.0f;
        update();
        setRotationBy(this.B);
        j();
    }

    public void E(Interpolator interpolator) {
        this.a = interpolator;
    }

    @Override // e.l.q.c.t0.d.c
    public boolean b() {
        return this.C;
    }

    @Override // e.l.q.c.t0.d.c
    public void getDisplayMatrix(Matrix matrix) {
        matrix.set(p());
    }

    @Override // e.l.q.c.t0.d.c
    public RectF getDisplayRect() {
        l();
        return o(p());
    }

    @Override // e.l.q.c.t0.d.c
    public e.l.q.c.t0.d.c getIPhotoViewImplementation() {
        return this;
    }

    @Override // e.l.q.c.t0.d.c
    public float getMaximumScale() {
        return this.f14212e;
    }

    @Override // e.l.q.c.t0.d.c
    public float getMediumScale() {
        return this.f14211d;
    }

    @Override // e.l.q.c.t0.d.c
    public float getMinimumScale() {
        return this.f14210c;
    }

    @Override // e.l.q.c.t0.d.c
    public float getScale() {
        return (float) Math.sqrt(((float) Math.pow(x(this.f14220m, 0), 2.0d)) + ((float) Math.pow(x(this.f14220m, 3), 2.0d)));
    }

    @Override // e.l.q.c.t0.d.c
    public ImageView.ScaleType getScaleType() {
        return this.D;
    }

    @Override // e.l.q.c.t0.d.c
    public Bitmap getVisibleRectangleBitmap() {
        ImageView r = r();
        if (r == null) {
            return null;
        }
        return r.getDrawingCache();
    }

    public void n() {
        WeakReference<ImageView> weakReference = this.f14215h;
        if (weakReference == null) {
            return;
        }
        ImageView imageView = weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this);
            }
            imageView.setOnTouchListener(null);
            i();
        }
        GestureDetector gestureDetector = this.f14216i;
        if (gestureDetector != null) {
            gestureDetector.setOnDoubleTapListener(null);
        }
        this.p = null;
        this.q = null;
        this.r = null;
        this.f14215h = null;
    }

    @Override // e.l.q.c.t0.d.e.e
    public void onDrag(float f2, float f3) {
        if (this.f14217j.c()) {
            return;
        }
        if (F) {
            e.l.q.c.t0.d.f.a.a().d(E, String.format("onDrag: dx: %.2f. dy: %.2f", Float.valueOf(f2), Float.valueOf(f3)));
        }
        ImageView r = r();
        this.f14220m.postTranslate(f2, f3);
        j();
        ViewParent parent = r.getParent();
        if (!this.f14213f || this.f14217j.c() || this.f14214g) {
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
                return;
            }
            return;
        }
        int i2 = this.A;
        if ((i2 == 2 || ((i2 == 0 && f2 >= 1.0f) || (i2 == 1 && f2 <= -1.0f))) && parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
    }

    @Override // e.l.q.c.t0.d.e.e
    public void onFling(float f2, float f3, float f4, float f5) {
        if (F) {
            e.l.q.c.t0.d.f.b a2 = e.l.q.c.t0.d.f.a.a();
            a2.d(E, "onFling. sX: " + f2 + " sY: " + f3 + " Vx: " + f4 + " Vy: " + f5);
        }
        ImageView r = r();
        RunnableC0398d runnableC0398d = new RunnableC0398d(r.getContext());
        this.z = runnableC0398d;
        runnableC0398d.b(t(r), s(r), (int) f4, (int) f5);
        r.post(this.z);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public void onGlobalLayout() {
        ImageView r = r();
        if (r != null) {
            if (this.C) {
                int top = r.getTop();
                int right = r.getRight();
                int bottom = r.getBottom();
                int left = r.getLeft();
                if (top == this.v && bottom == this.x && left == this.y && right == this.w) {
                    return;
                }
                F(r.getDrawable());
                this.v = top;
                this.w = right;
                this.x = bottom;
                this.y = left;
                return;
            }
            F(r.getDrawable());
        }
    }

    @Override // e.l.q.c.t0.d.e.e
    public void onScale(float f2, float f3, float f4) {
        if (F) {
            e.l.q.c.t0.d.f.a.a().d(E, String.format("onScale: scale: %.2f. fX: %.2f. fY: %.2f", Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)));
        }
        if (getScale() < this.f14212e || f2 < 1.0f) {
            if (getScale() > this.f14210c || f2 > 1.0f) {
                g gVar = this.t;
                if (gVar != null) {
                    gVar.onScaleChange(f2, f3, f4);
                }
                this.f14220m.postScale(f2, f2, f3, f4);
                j();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0095  */
    @Override // android.view.View.OnTouchListener
    @android.annotation.SuppressLint({"ClickableViewAccessibility"})
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
            if (r0 == 0) goto La1
            r0 = r11
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            boolean r0 = y(r0)
            if (r0 == 0) goto La1
            android.view.ViewParent r0 = r11.getParent()
            int r3 = r12.getAction()
            if (r3 == 0) goto L49
            if (r3 == r2) goto L1f
            r0 = 3
            if (r3 == r0) goto L1f
            goto L5d
        L1f:
            float r0 = r10.getScale()
            float r3 = r10.f14210c
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 >= 0) goto L5d
            android.graphics.RectF r0 = r10.getDisplayRect()
            if (r0 == 0) goto L5d
            e.l.q.c.t0.d.d$c r9 = new e.l.q.c.t0.d.d$c
            float r5 = r10.getScale()
            float r6 = r10.f14210c
            float r7 = r0.centerX()
            float r8 = r0.centerY()
            r3 = r9
            r4 = r10
            r3.<init>(r5, r6, r7, r8)
            r11.post(r9)
            r11 = 1
            goto L5e
        L49:
            if (r0 == 0) goto L4f
            r0.requestDisallowInterceptTouchEvent(r2)
            goto L5a
        L4f:
            e.l.q.c.t0.d.f.b r11 = e.l.q.c.t0.d.f.a.a()
            java.lang.String r0 = "PhotoViewAttacher"
            java.lang.String r3 = "onTouch getParent() returned null"
            r11.i(r0, r3)
        L5a:
            r10.i()
        L5d:
            r11 = 0
        L5e:
            e.l.q.c.t0.d.e.d r0 = r10.f14217j
            if (r0 == 0) goto L95
            boolean r11 = r0.c()
            e.l.q.c.t0.d.e.d r0 = r10.f14217j
            boolean r0 = r0.b()
            e.l.q.c.t0.d.e.d r3 = r10.f14217j
            boolean r3 = r3.onTouchEvent(r12)
            if (r11 != 0) goto L7e
            e.l.q.c.t0.d.e.d r11 = r10.f14217j
            boolean r11 = r11.c()
            if (r11 != 0) goto L7e
            r11 = 1
            goto L7f
        L7e:
            r11 = 0
        L7f:
            if (r0 != 0) goto L8b
            e.l.q.c.t0.d.e.d r0 = r10.f14217j
            boolean r0 = r0.b()
            if (r0 != 0) goto L8b
            r0 = 1
            goto L8c
        L8b:
            r0 = 0
        L8c:
            if (r11 == 0) goto L91
            if (r0 == 0) goto L91
            r1 = 1
        L91:
            r10.f14214g = r1
            r1 = r3
            goto L96
        L95:
            r1 = r11
        L96:
            android.view.GestureDetector r11 = r10.f14216i
            if (r11 == 0) goto La1
            boolean r11 = r11.onTouchEvent(r12)
            if (r11 == 0) goto La1
            r1 = 1
        La1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.l.q.c.t0.d.d.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public Matrix q() {
        return this.f14219l;
    }

    public ImageView r() {
        WeakReference<ImageView> weakReference = this.f14215h;
        ImageView imageView = weakReference != null ? weakReference.get() : null;
        if (imageView == null) {
            n();
            e.l.q.c.t0.d.f.a.a().i(E, "ImageView no longer exists. You should not use this PhotoViewAttacher any more.");
        }
        return imageView;
    }

    @Override // e.l.q.c.t0.d.c
    public void setAllowParentInterceptOnEdge(boolean z) {
        this.f14213f = z;
    }

    @Override // e.l.q.c.t0.d.c
    public boolean setDisplayMatrix(Matrix matrix) {
        if (matrix != null) {
            ImageView r = r();
            if (r == null || r.getDrawable() == null) {
                return false;
            }
            this.f14220m.set(matrix);
            C(p());
            l();
            return true;
        }
        throw new IllegalArgumentException("Matrix cannot be null");
    }

    @Override // e.l.q.c.t0.d.c
    public void setMaximumScale(float f2) {
        m(this.f14210c, this.f14211d, f2);
        this.f14212e = f2;
    }

    @Override // e.l.q.c.t0.d.c
    public void setMediumScale(float f2) {
        m(this.f14210c, f2, this.f14212e);
        this.f14211d = f2;
    }

    @Override // e.l.q.c.t0.d.c
    public void setMinimumScale(float f2) {
        m(f2, this.f14211d, this.f14212e);
        this.f14210c = f2;
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        if (onDoubleTapListener != null) {
            this.f14216i.setOnDoubleTapListener(onDoubleTapListener);
        } else {
            this.f14216i.setOnDoubleTapListener(new e.l.q.c.t0.d.b(this));
        }
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.s = onLongClickListener;
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnMatrixChangeListener(e eVar) {
        this.p = eVar;
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnPhotoTapListener(f fVar) {
        this.q = fVar;
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnScaleChangeListener(g gVar) {
        this.t = gVar;
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnSingleFlingListener(h hVar) {
        this.u = hVar;
    }

    @Override // e.l.q.c.t0.d.c
    public void setOnViewTapListener(i iVar) {
        this.r = iVar;
    }

    @Override // e.l.q.c.t0.d.c
    public void setRotationBy(float f2) {
        this.f14220m.postRotate(f2 % 360.0f);
        j();
    }

    @Override // e.l.q.c.t0.d.c
    public void setRotationTo(float f2) {
        this.f14220m.setRotate(f2 % 360.0f);
        j();
    }

    @Override // e.l.q.c.t0.d.c
    public void setScale(float f2) {
        setScale(f2, false);
    }

    @Override // e.l.q.c.t0.d.c
    public void setScaleLevels(float f2, float f3, float f4) {
        m(f2, f3, f4);
        this.f14210c = f2;
        this.f14211d = f3;
        this.f14212e = f4;
    }

    @Override // e.l.q.c.t0.d.c
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!z(scaleType) || scaleType == this.D) {
            return;
        }
        this.D = scaleType;
        update();
    }

    @Override // e.l.q.c.t0.d.c
    public void setZoomTransitionDuration(int i2) {
        if (i2 < 0) {
            i2 = 200;
        }
        this.b = i2;
    }

    @Override // e.l.q.c.t0.d.c
    public void setZoomable(boolean z) {
        this.C = z;
        update();
    }

    @Nullable
    public f u() {
        return this.q;
    }

    public void update() {
        ImageView r = r();
        if (r != null) {
            if (this.C) {
                D(r);
                F(r.getDrawable());
                return;
            }
            A();
        }
    }

    @Nullable
    public i v() {
        return this.r;
    }

    public void w(Matrix matrix) {
        matrix.set(this.f14220m);
    }

    public d(ImageView imageView, boolean z) {
        this.a = new AccelerateDecelerateInterpolator();
        this.b = 200;
        this.f14210c = 1.0f;
        this.f14211d = 1.75f;
        this.f14212e = 3.0f;
        this.f14213f = true;
        this.f14214g = false;
        this.f14218k = new Matrix();
        this.f14219l = new Matrix();
        this.f14220m = new Matrix();
        this.n = new RectF();
        this.o = new float[9];
        this.A = 2;
        this.D = ImageView.ScaleType.FIT_CENTER;
        this.f14215h = new WeakReference<>(imageView);
        imageView.setDrawingCacheEnabled(true);
        imageView.setOnTouchListener(this);
        ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        D(imageView);
        if (imageView.isInEditMode()) {
            return;
        }
        this.f14217j = e.l.q.c.t0.d.e.f.a(imageView.getContext(), this);
        GestureDetector gestureDetector = new GestureDetector(imageView.getContext(), new a());
        this.f14216i = gestureDetector;
        gestureDetector.setOnDoubleTapListener(new e.l.q.c.t0.d.b(this));
        this.B = 0.0f;
        setZoomable(z);
    }

    @Override // e.l.q.c.t0.d.c
    public void setScale(float f2, boolean z) {
        ImageView r = r();
        if (r != null) {
            setScale(f2, r.getRight() / 2, r.getBottom() / 2, z);
        }
    }

    @Override // e.l.q.c.t0.d.c
    public void setScale(float f2, float f3, float f4, boolean z) {
        ImageView r = r();
        if (r != null) {
            if (f2 < this.f14210c || f2 > this.f14212e) {
                e.l.q.c.t0.d.f.a.a().i(E, "Scale must be within the range of minScale and maxScale");
            } else if (z) {
                r.post(new c(getScale(), f2, f3, f4));
            } else {
                this.f14220m.setScale(f2, f2, f3, f4);
                j();
            }
        }
    }
}
