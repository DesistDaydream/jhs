package com.vector.network.photo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.Scroller;
import com.vector.network.image.NImageView;

/* loaded from: classes3.dex */
public class PhotoView extends NImageView {
    private static final int h0 = 35;
    private static final int i0 = 340;
    private static final float j0 = 2.5f;
    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private float F;
    private float G;
    private float H;
    private int I;
    private int J;
    private float K;
    private float L;
    private RectF M;
    private RectF N;
    private RectF O;
    private RectF P;
    private RectF Q;
    private PointF R;
    private PointF S;
    private PointF T;
    private l U;
    private RectF V;
    private Info W;
    private long a0;
    private Runnable b0;

    /* renamed from: c  reason: collision with root package name */
    public int f7837c;
    private View.OnLongClickListener c0;

    /* renamed from: d  reason: collision with root package name */
    private int f7838d;
    private e.t.r.b.a d0;

    /* renamed from: e  reason: collision with root package name */
    private int f7839e;
    private ScaleGestureDetector.OnScaleGestureListener e0;

    /* renamed from: f  reason: collision with root package name */
    private float f7840f;
    private Runnable f0;

    /* renamed from: g  reason: collision with root package name */
    private int f7841g;
    private GestureDetector.OnGestureListener g0;

    /* renamed from: h  reason: collision with root package name */
    private int f7842h;

    /* renamed from: i  reason: collision with root package name */
    private int f7843i;

    /* renamed from: j  reason: collision with root package name */
    private int f7844j;

    /* renamed from: k  reason: collision with root package name */
    private Matrix f7845k;

    /* renamed from: l  reason: collision with root package name */
    private Matrix f7846l;

    /* renamed from: m  reason: collision with root package name */
    private Matrix f7847m;
    private Matrix n;
    private e.t.r.b.b o;
    private GestureDetector p;
    private ScaleGestureDetector q;
    private View.OnClickListener r;
    private ImageView.ScaleType s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    /* loaded from: classes3.dex */
    public class a implements e.t.r.b.a {
        public a() {
        }

        @Override // e.t.r.b.a
        public void a(float f2, float f3, float f4) {
            PhotoView.C(PhotoView.this, f2);
            if (!PhotoView.this.C) {
                if (Math.abs(PhotoView.this.F) >= PhotoView.this.f7838d) {
                    PhotoView.this.C = true;
                    PhotoView.this.F = 0.0f;
                    return;
                }
                return;
            }
            PhotoView.Y(PhotoView.this, f2);
            PhotoView.this.f7846l.postRotate(f2, f3, f4);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ScaleGestureDetector.OnScaleGestureListener {
        public b() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            PhotoView.z0(PhotoView.this, scaleFactor);
            PhotoView.this.f7846l.postScale(scaleFactor, scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            PhotoView.this.P0();
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (PhotoView.this.r != null) {
                PhotoView.this.r.onClick(PhotoView.this);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends GestureDetector.SimpleOnGestureListener {
        public d() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            float f2;
            float f3;
            PhotoView.this.U.e();
            float width = PhotoView.this.O.left + (PhotoView.this.O.width() / 2.0f);
            float height = PhotoView.this.O.top + (PhotoView.this.O.height() / 2.0f);
            PhotoView.this.S.set(width, height);
            PhotoView.this.T.set(width, height);
            PhotoView.this.I = 0;
            PhotoView.this.J = 0;
            if (PhotoView.this.B) {
                f2 = PhotoView.this.H;
                f3 = 1.0f;
            } else {
                float f4 = PhotoView.this.H;
                float f5 = PhotoView.this.f7840f;
                PhotoView.this.S.set(motionEvent.getX(), motionEvent.getY());
                f2 = f4;
                f3 = f5;
            }
            PhotoView.this.n.reset();
            PhotoView.this.n.postTranslate(-PhotoView.this.N.left, -PhotoView.this.N.top);
            PhotoView.this.n.postTranslate(PhotoView.this.T.x, PhotoView.this.T.y);
            PhotoView.this.n.postTranslate(-PhotoView.this.K, -PhotoView.this.L);
            PhotoView.this.n.postRotate(PhotoView.this.G, PhotoView.this.T.x, PhotoView.this.T.y);
            PhotoView.this.n.postScale(f3, f3, PhotoView.this.S.x, PhotoView.this.S.y);
            PhotoView.this.n.postTranslate(PhotoView.this.I, PhotoView.this.J);
            PhotoView.this.n.mapRect(PhotoView.this.P, PhotoView.this.N);
            PhotoView photoView = PhotoView.this;
            photoView.M0(photoView.P);
            PhotoView photoView2 = PhotoView.this;
            photoView2.B = !photoView2.B;
            PhotoView.this.U.j(f2, f3);
            PhotoView.this.U.d();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            PhotoView.this.w = false;
            PhotoView.this.t = false;
            PhotoView.this.C = false;
            PhotoView photoView = PhotoView.this;
            photoView.removeCallbacks(photoView.f0);
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (PhotoView.this.t) {
                return false;
            }
            if ((PhotoView.this.D || PhotoView.this.E) && !PhotoView.this.U.a) {
                float f4 = (((float) Math.round(PhotoView.this.O.left)) >= PhotoView.this.M.left || ((float) Math.round(PhotoView.this.O.right)) <= PhotoView.this.M.right) ? 0.0f : f2;
                float f5 = (((float) Math.round(PhotoView.this.O.top)) >= PhotoView.this.M.top || ((float) Math.round(PhotoView.this.O.bottom)) <= PhotoView.this.M.bottom) ? 0.0f : f3;
                if (PhotoView.this.C || PhotoView.this.G % 90.0f != 0.0f) {
                    float f6 = ((int) (PhotoView.this.G / 90.0f)) * 90;
                    float f7 = PhotoView.this.G % 90.0f;
                    if (f7 > 45.0f) {
                        f6 += 90.0f;
                    } else if (f7 < -45.0f) {
                        f6 -= 90.0f;
                    }
                    PhotoView.this.U.h((int) PhotoView.this.G, (int) f6);
                    PhotoView.this.G = f6;
                }
                PhotoView photoView = PhotoView.this;
                photoView.M0(photoView.O);
                PhotoView.this.U.g(f4, f5);
                PhotoView.this.U.d();
                return super.onFling(motionEvent, motionEvent2, f2, f3);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (PhotoView.this.c0 != null) {
                PhotoView.this.c0.onLongClick(PhotoView.this);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (PhotoView.this.U.a) {
                PhotoView.this.U.e();
            }
            if (PhotoView.this.H0(f2)) {
                if (f2 < 0.0f && PhotoView.this.O.left - f2 > PhotoView.this.M.left) {
                    f2 = PhotoView.this.O.left;
                }
                if (f2 > 0.0f && PhotoView.this.O.right - f2 < PhotoView.this.M.right) {
                    f2 = PhotoView.this.O.right - PhotoView.this.M.right;
                }
                PhotoView.this.f7846l.postTranslate(-f2, 0.0f);
                PhotoView.S(PhotoView.this, f2);
            } else if (PhotoView.this.D || PhotoView.this.t || PhotoView.this.w) {
                PhotoView.this.J0();
                if (!PhotoView.this.t) {
                    if (f2 < 0.0f && PhotoView.this.O.left - f2 > PhotoView.this.Q.left) {
                        PhotoView photoView = PhotoView.this;
                        f2 = photoView.j1(photoView.O.left - PhotoView.this.Q.left, f2);
                    }
                    if (f2 > 0.0f && PhotoView.this.O.right - f2 < PhotoView.this.Q.right) {
                        PhotoView photoView2 = PhotoView.this;
                        f2 = photoView2.j1(photoView2.O.right - PhotoView.this.Q.right, f2);
                    }
                }
                PhotoView.S(PhotoView.this, f2);
                PhotoView.this.f7846l.postTranslate(-f2, 0.0f);
                PhotoView.this.w = true;
            }
            if (PhotoView.this.I0(f3)) {
                if (f3 < 0.0f && PhotoView.this.O.top - f3 > PhotoView.this.M.top) {
                    f3 = PhotoView.this.O.top;
                }
                if (f3 > 0.0f && PhotoView.this.O.bottom - f3 < PhotoView.this.M.bottom) {
                    f3 = PhotoView.this.O.bottom - PhotoView.this.M.bottom;
                }
                PhotoView.this.f7846l.postTranslate(0.0f, -f3);
                PhotoView.d0(PhotoView.this, f3);
            } else if (PhotoView.this.E || PhotoView.this.w || PhotoView.this.t) {
                PhotoView.this.J0();
                if (!PhotoView.this.t) {
                    if (f3 < 0.0f && PhotoView.this.O.top - f3 > PhotoView.this.Q.top) {
                        PhotoView photoView3 = PhotoView.this;
                        f3 = photoView3.k1(photoView3.O.top - PhotoView.this.Q.top, f3);
                    }
                    if (f3 > 0.0f && PhotoView.this.O.bottom - f3 < PhotoView.this.Q.bottom) {
                        PhotoView photoView4 = PhotoView.this;
                        f3 = photoView4.k1(photoView4.O.bottom - PhotoView.this.Q.bottom, f3);
                    }
                }
                PhotoView.this.f7846l.postTranslate(0.0f, -f3);
                PhotoView.d0(PhotoView.this, f3);
                PhotoView.this.w = true;
            }
            PhotoView.this.P0();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            PhotoView photoView = PhotoView.this;
            photoView.postDelayed(photoView.f0, 250L);
            return false;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements Runnable {
        public final /* synthetic */ float a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f7848c;

        public e(float f2, float f3, g gVar) {
            this.a = f2;
            this.b = f3;
            this.f7848c = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            PhotoView.this.U.f(1.0f, 1.0f, this.a - 1.0f, this.b - 1.0f, PhotoView.this.f7839e / 2, this.f7848c);
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class f {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            a = iArr;
            try {
                iArr[ImageView.ScaleType.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface g {
        float a();
    }

    /* loaded from: classes3.dex */
    public class h implements g {
        public h() {
        }

        @Override // com.vector.network.photo.PhotoView.g
        public float a() {
            return PhotoView.this.O.bottom;
        }
    }

    /* loaded from: classes3.dex */
    public class i implements Interpolator {
        private Interpolator a;

        public /* synthetic */ i(PhotoView photoView, a aVar) {
            this();
        }

        public void a(Interpolator interpolator) {
            this.a = interpolator;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f2) {
            Interpolator interpolator = this.a;
            return interpolator != null ? interpolator.getInterpolation(f2) : f2;
        }

        private i() {
            this.a = new DecelerateInterpolator();
        }
    }

    /* loaded from: classes3.dex */
    public class j implements g {
        public j() {
        }

        @Override // com.vector.network.photo.PhotoView.g
        public float a() {
            return (PhotoView.this.O.top + PhotoView.this.O.bottom) / 2.0f;
        }
    }

    /* loaded from: classes3.dex */
    public class k implements g {
        public k() {
        }

        @Override // com.vector.network.photo.PhotoView.g
        public float a() {
            return PhotoView.this.O.top;
        }
    }

    /* loaded from: classes3.dex */
    public class l implements Runnable {
        public boolean a;
        public OverScroller b;

        /* renamed from: c  reason: collision with root package name */
        public OverScroller f7850c;

        /* renamed from: d  reason: collision with root package name */
        public Scroller f7851d;

        /* renamed from: e  reason: collision with root package name */
        public Scroller f7852e;

        /* renamed from: f  reason: collision with root package name */
        public Scroller f7853f;

        /* renamed from: g  reason: collision with root package name */
        public g f7854g;

        /* renamed from: h  reason: collision with root package name */
        public int f7855h;

        /* renamed from: i  reason: collision with root package name */
        public int f7856i;

        /* renamed from: j  reason: collision with root package name */
        public int f7857j;

        /* renamed from: k  reason: collision with root package name */
        public int f7858k;

        /* renamed from: l  reason: collision with root package name */
        public RectF f7859l = new RectF();

        /* renamed from: m  reason: collision with root package name */
        public i f7860m;

        public l() {
            this.f7860m = new i(PhotoView.this, null);
            Context context = PhotoView.this.getContext();
            this.b = new OverScroller(context, this.f7860m);
            this.f7851d = new Scroller(context, this.f7860m);
            this.f7850c = new OverScroller(context, this.f7860m);
            this.f7852e = new Scroller(context, this.f7860m);
            this.f7853f = new Scroller(context, this.f7860m);
        }

        private void a() {
            PhotoView.this.f7846l.reset();
            PhotoView.this.f7846l.postTranslate(-PhotoView.this.N.left, -PhotoView.this.N.top);
            PhotoView.this.f7846l.postTranslate(PhotoView.this.T.x, PhotoView.this.T.y);
            PhotoView.this.f7846l.postTranslate(-PhotoView.this.K, -PhotoView.this.L);
            PhotoView.this.f7846l.postRotate(PhotoView.this.G, PhotoView.this.T.x, PhotoView.this.T.y);
            PhotoView.this.f7846l.postScale(PhotoView.this.H, PhotoView.this.H, PhotoView.this.S.x, PhotoView.this.S.y);
            PhotoView.this.f7846l.postTranslate(PhotoView.this.I, PhotoView.this.J);
            PhotoView.this.P0();
        }

        private void b() {
            if (this.a) {
                PhotoView.this.post(this);
            }
        }

        public void c(Interpolator interpolator) {
            this.f7860m.a(interpolator);
        }

        public void d() {
            this.a = true;
            b();
        }

        public void e() {
            PhotoView.this.removeCallbacks(this);
            this.b.abortAnimation();
            this.f7851d.abortAnimation();
            this.f7850c.abortAnimation();
            this.f7853f.abortAnimation();
            this.a = false;
        }

        public void f(float f2, float f3, float f4, float f5, int i2, g gVar) {
            this.f7852e.startScroll((int) (f2 * 10000.0f), (int) (f3 * 10000.0f), (int) (f4 * 10000.0f), (int) (f5 * 10000.0f), i2);
            this.f7854g = gVar;
        }

        public void g(float f2, float f3) {
            int i2;
            int i3;
            int i4;
            int i5;
            int i6 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            this.f7855h = i6 < 0 ? Integer.MAX_VALUE : 0;
            int i7 = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
            RectF rectF = PhotoView.this.O;
            int abs = (int) (i7 > 0 ? Math.abs(rectF.left) : rectF.right - PhotoView.this.M.right);
            if (i6 < 0) {
                abs = Integer.MAX_VALUE - abs;
            }
            int i8 = i6 < 0 ? abs : 0;
            int i9 = i6 < 0 ? Integer.MAX_VALUE : abs;
            if (i6 < 0) {
                abs = Integer.MAX_VALUE - i8;
            }
            int i10 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            this.f7856i = i10 < 0 ? Integer.MAX_VALUE : 0;
            int i11 = (f3 > 0.0f ? 1 : (f3 == 0.0f ? 0 : -1));
            RectF rectF2 = PhotoView.this.O;
            int abs2 = (int) (i11 > 0 ? Math.abs(rectF2.top) : rectF2.bottom - PhotoView.this.M.bottom);
            if (i10 < 0) {
                abs2 = Integer.MAX_VALUE - abs2;
            }
            int i12 = i10 < 0 ? abs2 : 0;
            int i13 = i10 < 0 ? Integer.MAX_VALUE : abs2;
            if (i10 < 0) {
                abs2 = Integer.MAX_VALUE - i12;
            }
            if (i7 == 0) {
                i2 = 0;
                i3 = 0;
            } else {
                i2 = i8;
                i3 = i9;
            }
            if (i11 == 0) {
                i4 = 0;
                i5 = 0;
            } else {
                i4 = i12;
                i5 = i13;
            }
            this.f7850c.fling(this.f7855h, this.f7856i, (int) f2, (int) f3, i2, i3, i4, i5, Math.abs(abs) < PhotoView.this.f7842h * 2 ? 0 : PhotoView.this.f7842h, Math.abs(abs2) < PhotoView.this.f7842h * 2 ? 0 : PhotoView.this.f7842h);
        }

        public void h(int i2, int i3) {
            this.f7853f.startScroll(i2, 0, i3 - i2, 0, PhotoView.this.f7839e);
        }

        public void i(int i2, int i3, int i4) {
            this.f7853f.startScroll(i2, 0, i3 - i2, 0, i4);
        }

        public void j(float f2, float f3) {
            this.f7851d.startScroll((int) (f2 * 10000.0f), 0, (int) ((f3 - f2) * 10000.0f), 0, PhotoView.this.f7839e);
        }

        public void k(int i2, int i3, int i4, int i5) {
            this.f7857j = 0;
            this.f7858k = 0;
            this.b.startScroll(0, 0, i4, i5, PhotoView.this.f7839e);
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            boolean z2 = true;
            boolean z3 = false;
            if (this.f7851d.computeScrollOffset()) {
                PhotoView.this.H = this.f7851d.getCurrX() / 10000.0f;
                z = false;
            } else {
                z = true;
            }
            if (this.b.computeScrollOffset()) {
                int currX = this.b.getCurrX() - this.f7857j;
                int currY = this.b.getCurrY() - this.f7858k;
                PhotoView.Q(PhotoView.this, currX);
                PhotoView.b0(PhotoView.this, currY);
                this.f7857j = this.b.getCurrX();
                this.f7858k = this.b.getCurrY();
                z = false;
            }
            if (this.f7850c.computeScrollOffset()) {
                int currX2 = this.f7850c.getCurrX() - this.f7855h;
                int currY2 = this.f7850c.getCurrY() - this.f7856i;
                this.f7855h = this.f7850c.getCurrX();
                this.f7856i = this.f7850c.getCurrY();
                PhotoView.Q(PhotoView.this, currX2);
                PhotoView.b0(PhotoView.this, currY2);
                z = false;
            }
            if (this.f7853f.computeScrollOffset()) {
                PhotoView.this.G = this.f7853f.getCurrX();
                z = false;
            }
            if (this.f7852e.computeScrollOffset() || PhotoView.this.V != null) {
                float currX3 = this.f7852e.getCurrX() / 10000.0f;
                float currY3 = this.f7852e.getCurrY() / 10000.0f;
                PhotoView.this.n.setScale(currX3, currY3, (PhotoView.this.O.left + PhotoView.this.O.right) / 2.0f, this.f7854g.a());
                PhotoView.this.n.mapRect(this.f7859l, PhotoView.this.O);
                if (currX3 == 1.0f) {
                    this.f7859l.left = PhotoView.this.M.left;
                    this.f7859l.right = PhotoView.this.M.right;
                }
                if (currY3 == 1.0f) {
                    this.f7859l.top = PhotoView.this.M.top;
                    this.f7859l.bottom = PhotoView.this.M.bottom;
                }
                PhotoView.this.V = this.f7859l;
            }
            if (!z) {
                a();
                b();
                return;
            }
            this.a = false;
            if (PhotoView.this.D) {
                if (PhotoView.this.O.left <= 0.0f) {
                    if (PhotoView.this.O.right < PhotoView.this.M.width()) {
                        PhotoView photoView = PhotoView.this;
                        PhotoView.R(photoView, (int) (photoView.M.width() - PhotoView.this.O.right));
                    }
                } else {
                    PhotoView photoView2 = PhotoView.this;
                    PhotoView.S(photoView2, photoView2.O.left);
                }
                z3 = true;
            }
            if (!PhotoView.this.E) {
                z2 = z3;
            } else if (PhotoView.this.O.top <= 0.0f) {
                if (PhotoView.this.O.bottom < PhotoView.this.M.height()) {
                    PhotoView photoView3 = PhotoView.this;
                    PhotoView.c0(photoView3, (int) (photoView3.M.height() - PhotoView.this.O.bottom));
                }
            } else {
                PhotoView photoView4 = PhotoView.this;
                PhotoView.d0(photoView4, photoView4.O.top);
            }
            if (z2) {
                a();
            }
            PhotoView.this.invalidate();
            if (PhotoView.this.b0 != null) {
                PhotoView.this.b0.run();
                PhotoView.this.b0 = null;
            }
        }
    }

    public PhotoView(Context context) {
        super(context);
        this.f7837c = 16384;
        this.f7841g = 0;
        this.f7842h = 0;
        this.f7843i = 0;
        this.f7844j = 500;
        this.f7845k = new Matrix();
        this.f7846l = new Matrix();
        this.f7847m = new Matrix();
        this.n = new Matrix();
        this.x = false;
        this.y = false;
        this.H = 1.0f;
        this.M = new RectF();
        this.N = new RectF();
        this.O = new RectF();
        this.P = new RectF();
        this.Q = new RectF();
        this.R = new PointF();
        this.S = new PointF();
        this.T = new PointF();
        this.U = new l();
        this.d0 = new a();
        this.e0 = new b();
        this.f0 = new c();
        this.g0 = new d();
        init();
    }

    public static /* synthetic */ float C(PhotoView photoView, float f2) {
        float f3 = photoView.F + f2;
        photoView.F = f3;
        return f3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (this.w) {
            return;
        }
        f1(this.M, this.O, this.Q);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(RectF rectF) {
        float f2;
        int i2;
        int i3 = 0;
        if (rectF.width() <= this.M.width()) {
            if (!e1(rectF)) {
                i2 = -((int) (((this.M.width() - rectF.width()) / 2.0f) - rectF.left));
            }
            i2 = 0;
        } else {
            float f3 = rectF.left;
            RectF rectF2 = this.M;
            float f4 = rectF2.left;
            if (f3 > f4) {
                f2 = f3 - f4;
            } else {
                float f5 = rectF.right;
                float f6 = rectF2.right;
                if (f5 < f6) {
                    f2 = f5 - f6;
                }
                i2 = 0;
            }
            i2 = (int) f2;
        }
        if (rectF.height() <= this.M.height()) {
            if (!d1(rectF)) {
                i3 = -((int) (((this.M.height() - rectF.height()) / 2.0f) - rectF.top));
            }
        } else {
            float f7 = rectF.top;
            RectF rectF3 = this.M;
            float f8 = rectF3.top;
            if (f7 > f8) {
                i3 = (int) (f7 - f8);
            } else {
                float f9 = rectF.bottom;
                float f10 = rectF3.bottom;
                if (f9 < f10) {
                    i3 = (int) (f9 - f10);
                }
            }
        }
        if (i2 == 0 && i3 == 0) {
            return;
        }
        if (!this.U.f7850c.isFinished()) {
            this.U.f7850c.abortAnimation();
        }
        this.U.k(this.I, this.J, -i2, -i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        this.f7847m.set(this.f7845k);
        this.f7847m.postConcat(this.f7846l);
        setImageMatrix(this.f7847m);
        this.f7846l.mapRect(this.O, this.N);
        this.D = this.O.width() > this.M.width();
        this.E = this.O.height() > this.M.height();
    }

    public static /* synthetic */ int Q(PhotoView photoView, int i2) {
        int i3 = photoView.I + i2;
        photoView.I = i3;
        return i3;
    }

    private static int Q0(Drawable drawable) {
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicHeight <= 0) {
            intrinsicHeight = drawable.getMinimumHeight();
        }
        return intrinsicHeight <= 0 ? drawable.getBounds().height() : intrinsicHeight;
    }

    public static /* synthetic */ int R(PhotoView photoView, int i2) {
        int i3 = photoView.I - i2;
        photoView.I = i3;
        return i3;
    }

    private static int R0(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        if (intrinsicWidth <= 0) {
            intrinsicWidth = drawable.getMinimumWidth();
        }
        return intrinsicWidth <= 0 ? drawable.getBounds().width() : intrinsicWidth;
    }

    public static /* synthetic */ int S(PhotoView photoView, float f2) {
        int i2 = (int) (photoView.I - f2);
        photoView.I = i2;
        return i2;
    }

    public static Info S0(ImageView imageView) {
        int[] iArr = new int[2];
        T0(imageView, iArr);
        Drawable drawable = imageView.getDrawable();
        Matrix imageMatrix = imageView.getImageMatrix();
        RectF rectF = new RectF(0.0f, 0.0f, R0(drawable), Q0(drawable));
        imageMatrix.mapRect(rectF);
        RectF rectF2 = new RectF(iArr[0] + rectF.left, iArr[1] + rectF.top, iArr[0] + rectF.right, iArr[1] + rectF.bottom);
        RectF rectF3 = new RectF(0.0f, 0.0f, imageView.getWidth(), imageView.getHeight());
        return new Info(rectF2, rectF, rectF3, new RectF(rectF3), new PointF(rectF3.width() / 2.0f, rectF3.height() / 2.0f), 1.0f, 0.0f, imageView.getScaleType());
    }

    private static void T0(View view, int[] iArr) {
        iArr[0] = iArr[0] + view.getLeft();
        iArr[1] = iArr[1] + view.getTop();
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            if (view2.getId() == 16908290) {
                return;
            }
            iArr[0] = iArr[0] - view2.getScrollX();
            iArr[1] = iArr[1] - view2.getScrollY();
            iArr[0] = iArr[0] + view2.getLeft();
            iArr[1] = iArr[1] + view2.getTop();
            parent = view2.getParent();
        }
        iArr[0] = (int) (iArr[0] + 0.5f);
        iArr[1] = (int) (iArr[1] + 0.5f);
    }

    private boolean U0(Drawable drawable) {
        if (drawable.getIntrinsicHeight() <= 0 || drawable.getIntrinsicWidth() <= 0) {
            if (drawable.getMinimumWidth() <= 0 || drawable.getMinimumHeight() <= 0) {
                return drawable.getBounds().width() > 0 && drawable.getBounds().height() > 0;
            }
            return true;
        }
        return true;
    }

    private void V0() {
        if (this.u && this.v) {
            this.f7845k.reset();
            this.f7846l.reset();
            this.B = false;
            Drawable drawable = getDrawable();
            int width = getWidth();
            int height = getHeight();
            int R0 = R0(drawable);
            int Q0 = Q0(drawable);
            float f2 = R0;
            float f3 = Q0;
            this.N.set(0.0f, 0.0f, f2, f3);
            int i2 = (width - R0) / 2;
            int i3 = (height - Q0) / 2;
            float f4 = R0 > width ? width / f2 : 1.0f;
            float f5 = Q0 > height ? height / f3 : 1.0f;
            if (f4 >= f5) {
                f4 = f5;
            }
            this.f7845k.reset();
            this.f7845k.postTranslate(i2, i3);
            Matrix matrix = this.f7845k;
            PointF pointF = this.R;
            matrix.postScale(f4, f4, pointF.x, pointF.y);
            this.f7845k.mapRect(this.N);
            this.K = this.N.width() / 2.0f;
            this.L = this.N.height() / 2.0f;
            PointF pointF2 = this.R;
            float f6 = pointF2.x;
            if (f6 > 0.0f) {
                float f7 = this.K;
                if (f7 > 0.0f && f6 / f7 > 1.0f) {
                    this.f7840f = (f6 / f7) + 1.0f;
                }
            }
            this.S.set(pointF2);
            this.T.set(this.S);
            P0();
            switch (f.a[this.s.ordinal()]) {
                case 1:
                    W0();
                    break;
                case 2:
                    X0();
                    break;
                case 3:
                    Y0();
                    break;
                case 4:
                    Z0();
                    break;
                case 5:
                    b1();
                    break;
                case 6:
                    a1();
                    break;
                case 7:
                    c1();
                    break;
            }
            this.z = true;
            if (this.W != null && System.currentTimeMillis() - this.a0 < this.f7844j) {
                F0(this.W);
            }
            this.W = null;
        }
    }

    private void W0() {
        if (this.u && this.v) {
            Drawable drawable = getDrawable();
            int R0 = R0(drawable);
            int Q0 = Q0(drawable);
            float f2 = R0;
            if (f2 > this.M.width() || Q0 > this.M.height()) {
                float width = f2 / this.O.width();
                float height = Q0 / this.O.height();
                if (width <= height) {
                    width = height;
                }
                this.H = width;
                Matrix matrix = this.f7846l;
                PointF pointF = this.R;
                matrix.postScale(width, width, pointF.x, pointF.y);
                P0();
                i1();
            }
        }
    }

    private void X0() {
        if (this.O.width() < this.M.width() || this.O.height() < this.M.height()) {
            float width = this.M.width() / this.O.width();
            float height = this.M.height() / this.O.height();
            if (width <= height) {
                width = height;
            }
            this.H = width;
            Matrix matrix = this.f7846l;
            PointF pointF = this.R;
            matrix.postScale(width, width, pointF.x, pointF.y);
            P0();
            i1();
        }
    }

    public static /* synthetic */ float Y(PhotoView photoView, float f2) {
        float f3 = photoView.G + f2;
        photoView.G = f3;
        return f3;
    }

    private void Y0() {
        if (this.O.width() > this.M.width() || this.O.height() > this.M.height()) {
            float width = this.M.width() / this.O.width();
            float height = this.M.height() / this.O.height();
            if (width >= height) {
                width = height;
            }
            this.H = width;
            Matrix matrix = this.f7846l;
            PointF pointF = this.R;
            matrix.postScale(width, width, pointF.x, pointF.y);
            P0();
            i1();
        }
    }

    private void Z0() {
        if (this.O.width() < this.M.width()) {
            float width = this.M.width() / this.O.width();
            this.H = width;
            Matrix matrix = this.f7846l;
            PointF pointF = this.R;
            matrix.postScale(width, width, pointF.x, pointF.y);
            P0();
            i1();
        }
    }

    private void a1() {
        Z0();
        float f2 = this.M.bottom - this.O.bottom;
        this.J = (int) (this.J + f2);
        this.f7846l.postTranslate(0.0f, f2);
        P0();
        i1();
    }

    public static /* synthetic */ int b0(PhotoView photoView, int i2) {
        int i3 = photoView.J + i2;
        photoView.J = i3;
        return i3;
    }

    private void b1() {
        Z0();
        float f2 = -this.O.top;
        this.f7846l.postTranslate(0.0f, f2);
        P0();
        i1();
        this.J = (int) (this.J + f2);
    }

    public static /* synthetic */ int c0(PhotoView photoView, int i2) {
        int i3 = photoView.J - i2;
        photoView.J = i3;
        return i3;
    }

    private void c1() {
        float width = this.M.width() / this.O.width();
        float height = this.M.height() / this.O.height();
        Matrix matrix = this.f7846l;
        PointF pointF = this.R;
        matrix.postScale(width, height, pointF.x, pointF.y);
        P0();
        i1();
    }

    public static /* synthetic */ int d0(PhotoView photoView, float f2) {
        int i2 = (int) (photoView.J - f2);
        photoView.J = i2;
        return i2;
    }

    private boolean d1(RectF rectF) {
        return Math.abs(((float) Math.round(rectF.top)) - ((this.M.height() - rectF.height()) / 2.0f)) < 1.0f;
    }

    private boolean e1(RectF rectF) {
        return Math.abs(((float) Math.round(rectF.left)) - ((this.M.width() - rectF.width()) / 2.0f)) < 1.0f;
    }

    private void f1(RectF rectF, RectF rectF2, RectF rectF3) {
        float f2 = rectF.left;
        float f3 = rectF2.left;
        if (f2 <= f3) {
            f2 = f3;
        }
        float f4 = rectF.right;
        float f5 = rectF2.right;
        if (f4 >= f5) {
            f4 = f5;
        }
        if (f2 > f4) {
            rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
            return;
        }
        float f6 = rectF.top;
        float f7 = rectF2.top;
        if (f6 <= f7) {
            f6 = f7;
        }
        float f8 = rectF.bottom;
        float f9 = rectF2.bottom;
        if (f8 >= f9) {
            f8 = f9;
        }
        if (f6 > f8) {
            rectF3.set(0.0f, 0.0f, 0.0f, 0.0f);
        } else {
            rectF3.set(f2, f6, f4, f8);
        }
    }

    private void g1() {
        l lVar = this.U;
        if (lVar.a) {
            return;
        }
        if (this.C || this.G % 90.0f != 0.0f) {
            float f2 = this.G;
            float f3 = ((int) (f2 / 90.0f)) * 90;
            float f4 = f2 % 90.0f;
            if (f4 > 45.0f) {
                f3 += 90.0f;
            } else if (f4 < -45.0f) {
                f3 -= 90.0f;
            }
            lVar.h((int) f2, (int) f3);
            this.G = f3;
        }
        float f5 = this.H;
        if (f5 < 1.0f) {
            this.U.j(f5, 1.0f);
            f5 = 1.0f;
        } else {
            float f6 = this.f7840f;
            if (f5 > f6) {
                this.U.j(f5, f6);
                f5 = f6;
            }
        }
        RectF rectF = this.O;
        float width = rectF.left + (rectF.width() / 2.0f);
        RectF rectF2 = this.O;
        float height = rectF2.top + (rectF2.height() / 2.0f);
        this.S.set(width, height);
        this.T.set(width, height);
        this.I = 0;
        this.J = 0;
        this.n.reset();
        Matrix matrix = this.n;
        RectF rectF3 = this.N;
        matrix.postTranslate(-rectF3.left, -rectF3.top);
        this.n.postTranslate(width - this.K, height - this.L);
        this.n.postScale(f5, f5, width, height);
        this.n.postRotate(this.G, width, height);
        this.n.mapRect(this.P, this.N);
        M0(this.P);
        this.U.d();
    }

    private void h1() {
        this.f7846l.reset();
        P0();
        this.H = 1.0f;
        this.I = 0;
        this.J = 0;
    }

    private void i1() {
        Drawable drawable = getDrawable();
        this.N.set(0.0f, 0.0f, R0(drawable), Q0(drawable));
        this.f7845k.set(this.f7847m);
        this.f7845k.mapRect(this.N);
        this.K = this.N.width() / 2.0f;
        this.L = this.N.height() / 2.0f;
        this.H = 1.0f;
        this.I = 0;
        this.J = 0;
        this.f7846l.reset();
    }

    private void init() {
        super.setScaleType(ImageView.ScaleType.MATRIX);
        if (this.s == null) {
            this.s = ImageView.ScaleType.CENTER_INSIDE;
        }
        this.o = new e.t.r.b.b(this.d0);
        this.p = new GestureDetector(getContext(), this.g0);
        this.q = new ScaleGestureDetector(getContext(), this.e0);
        float f2 = getResources().getDisplayMetrics().density;
        int i2 = (int) (30.0f * f2);
        this.f7841g = i2;
        this.f7842h = i2;
        this.f7843i = (int) (f2 * 140.0f);
        this.f7838d = 35;
        this.f7839e = i0;
        this.f7840f = j0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float j1(float f2, float f3) {
        return f3 * (Math.abs(Math.abs(f2) - this.f7843i) / this.f7843i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float k1(float f2, float f3) {
        return f3 * (Math.abs(Math.abs(f2) - this.f7843i) / this.f7843i);
    }

    public static /* synthetic */ float z0(PhotoView photoView, float f2) {
        float f3 = photoView.H * f2;
        photoView.H = f3;
        return f3;
    }

    public void F0(Info info) {
        if (this.z) {
            h1();
            Info info2 = getInfo();
            float width = info.mImgRect.width() / info2.mImgRect.width();
            float height = info.mImgRect.height() / info2.mImgRect.height();
            if (width >= height) {
                width = height;
            }
            RectF rectF = info.mRect;
            float width2 = rectF.left + (rectF.width() / 2.0f);
            RectF rectF2 = info.mRect;
            float height2 = rectF2.top + (rectF2.height() / 2.0f);
            RectF rectF3 = info2.mRect;
            float width3 = rectF3.left + (rectF3.width() / 2.0f);
            RectF rectF4 = info2.mRect;
            float height3 = rectF4.top + (rectF4.height() / 2.0f);
            this.f7846l.reset();
            float f2 = width2 - width3;
            float f3 = height2 - height3;
            this.f7846l.postTranslate(f2, f3);
            this.f7846l.postScale(width, width, width2, height2);
            this.f7846l.postRotate(info.mDegrees, width2, height2);
            P0();
            this.S.set(width2, height2);
            this.T.set(width2, height2);
            this.U.k(0, 0, (int) (-f2), (int) (-f3));
            this.U.j(width, 1.0f);
            this.U.h((int) info.mDegrees, 0);
            if (info.mWidgetRect.width() < info.mImgRect.width() || info.mWidgetRect.height() < info.mImgRect.height()) {
                float width4 = info.mWidgetRect.width() / info.mImgRect.width();
                float height4 = info.mWidgetRect.height() / info.mImgRect.height();
                if (width4 > 1.0f) {
                    width4 = 1.0f;
                }
                if (height4 > 1.0f) {
                    height4 = 1.0f;
                }
                ImageView.ScaleType scaleType = info.mScaleType;
                g kVar = scaleType == ImageView.ScaleType.FIT_START ? new k() : scaleType == ImageView.ScaleType.FIT_END ? new h() : new j();
                this.U.f(width4, height4, 1.0f - width4, 1.0f - height4, this.f7839e / 3, kVar);
                Matrix matrix = this.n;
                RectF rectF5 = this.O;
                matrix.setScale(width4, height4, (rectF5.left + rectF5.right) / 2.0f, kVar.a());
                this.n.mapRect(this.U.f7859l, this.O);
                this.V = this.U.f7859l;
            }
            this.U.d();
            return;
        }
        this.W = info;
        this.a0 = System.currentTimeMillis();
    }

    public void G0(Info info, Runnable runnable) {
        if (this.z) {
            this.U.e();
            this.I = 0;
            this.J = 0;
            RectF rectF = info.mRect;
            float width = rectF.left + (rectF.width() / 2.0f);
            RectF rectF2 = info.mRect;
            float height = rectF2.top + (rectF2.height() / 2.0f);
            PointF pointF = this.S;
            RectF rectF3 = this.O;
            float width2 = rectF3.left + (rectF3.width() / 2.0f);
            RectF rectF4 = this.O;
            pointF.set(width2, rectF4.top + (rectF4.height() / 2.0f));
            this.T.set(this.S);
            PointF pointF2 = this.S;
            this.f7846l.postRotate(-this.G, pointF2.x, pointF2.y);
            this.f7846l.mapRect(this.O, this.N);
            float width3 = info.mImgRect.width() / this.N.width();
            float height2 = info.mImgRect.height() / this.N.height();
            if (width3 <= height2) {
                width3 = height2;
            }
            Matrix matrix = this.f7846l;
            float f2 = this.G;
            PointF pointF3 = this.S;
            matrix.postRotate(f2, pointF3.x, pointF3.y);
            this.f7846l.mapRect(this.O, this.N);
            this.G %= 360.0f;
            l lVar = this.U;
            PointF pointF4 = this.S;
            lVar.k(0, 0, (int) (width - pointF4.x), (int) (height - pointF4.y));
            this.U.j(this.H, width3);
            this.U.i((int) this.G, (int) info.mDegrees, (this.f7839e * 2) / 3);
            if (info.mWidgetRect.width() < info.mRect.width() || info.mWidgetRect.height() < info.mRect.height()) {
                float width4 = info.mWidgetRect.width() / info.mRect.width();
                float height3 = info.mWidgetRect.height() / info.mRect.height();
                if (width4 > 1.0f) {
                    width4 = 1.0f;
                }
                if (height3 > 1.0f) {
                    height3 = 1.0f;
                }
                ImageView.ScaleType scaleType = info.mScaleType;
                postDelayed(new e(width4, height3, scaleType == ImageView.ScaleType.FIT_START ? new k() : scaleType == ImageView.ScaleType.FIT_END ? new h() : new j()), this.f7839e / 2);
            }
            this.b0 = runnable;
            this.U.d();
        }
    }

    public boolean H0(float f2) {
        if (this.O.width() <= this.M.width()) {
            return false;
        }
        if (f2 >= 0.0f || Math.round(this.O.left) - f2 < this.M.left) {
            return f2 <= 0.0f || ((float) Math.round(this.O.right)) - f2 > this.M.right;
        }
        return false;
    }

    public boolean I0(float f2) {
        if (this.O.height() <= this.M.height()) {
            return false;
        }
        if (f2 >= 0.0f || Math.round(this.O.top) - f2 < this.M.top) {
            return f2 <= 0.0f || ((float) Math.round(this.O.bottom)) - f2 > this.M.bottom;
        }
        return false;
    }

    public void K0() {
        this.x = false;
    }

    public void L0() {
        this.y = false;
    }

    public void N0() {
        this.x = true;
    }

    public void O0() {
        this.y = true;
    }

    @Override // android.view.View
    public boolean canScrollHorizontally(int i2) {
        if (this.t) {
            return true;
        }
        return H0(i2);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int i2) {
        if (this.t) {
            return true;
        }
        return I0(i2);
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.x) {
            int actionMasked = motionEvent.getActionMasked();
            if (motionEvent.getPointerCount() >= 2) {
                this.t = true;
            }
            this.p.onTouchEvent(motionEvent);
            if (this.y) {
                this.o.b(motionEvent);
            }
            this.q.onTouchEvent(motionEvent);
            if (actionMasked == 1 || actionMasked == 3) {
                g1();
            }
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.vector.network.image.NImageView, android.view.View
    public void draw(Canvas canvas) {
        RectF rectF = this.V;
        if (rectF != null) {
            canvas.clipRect(rectF);
            this.V = null;
        }
        this.f7837c = canvas.getMaximumBitmapHeight();
        super.draw(canvas);
    }

    public int getAnimaDuring() {
        return this.f7839e;
    }

    public int getDefaultAnimaDuring() {
        return i0;
    }

    public Info getInfo() {
        RectF rectF = new RectF();
        int[] iArr = new int[2];
        T0(this, iArr);
        RectF rectF2 = this.O;
        rectF.set(iArr[0] + rectF2.left, iArr[1] + rectF2.top, iArr[0] + rectF2.right, iArr[1] + rectF2.bottom);
        return new Info(rectF, this.O, this.M, this.N, this.R, this.H, this.G, this.s);
    }

    public float getMaxScale() {
        return this.f7840f;
    }

    public void l1(float f2) {
        this.G += f2;
        RectF rectF = this.M;
        int width = (int) (rectF.left + (rectF.width() / 2.0f));
        RectF rectF2 = this.M;
        this.f7846l.postRotate(f2, width, (int) (rectF2.top + (rectF2.height() / 2.0f)));
        P0();
    }

    @Override // com.vector.network.image.NImageView, android.widget.ImageView, android.view.View
    public void onMeasure(int i2, int i3) {
        if (!this.u) {
            super.onMeasure(i2, i3);
            return;
        }
        Drawable drawable = getDrawable();
        int R0 = R0(drawable);
        int Q0 = Q0(drawable);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(-2, -2);
        }
        int i4 = layoutParams.width;
        if (i4 != -1 ? mode != 1073741824 && (mode != Integer.MIN_VALUE || R0 <= size) : mode == 0) {
            size = R0;
        }
        int i5 = layoutParams.height;
        if (i5 != -1 ? mode2 != 1073741824 && (mode2 != Integer.MIN_VALUE || Q0 <= size2) : mode2 == 0) {
            size2 = Q0;
        }
        if (this.A) {
            float f2 = R0;
            float f3 = Q0;
            float f4 = size;
            float f5 = size2;
            if (f2 / f3 != f4 / f5) {
                float f6 = f5 / f3;
                float f7 = f4 / f2;
                if (f6 >= f7) {
                    f6 = f7;
                }
                if (i4 != -1) {
                    size = (int) (f2 * f6);
                }
                if (i5 != -1) {
                    size2 = (int) (f3 * f6);
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        this.M.set(0.0f, 0.0f, i2, i3);
        this.R.set(i2 / 2, i3 / 2);
        if (this.v) {
            return;
        }
        this.v = true;
        V0();
    }

    @Override // android.widget.ImageView
    public void setAdjustViewBounds(boolean z) {
        super.setAdjustViewBounds(z);
        this.A = z;
    }

    public void setAnimaDuring(int i2) {
        this.f7839e = i2;
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (drawable == null) {
            this.u = false;
        } else if (U0(drawable)) {
            if (!this.u) {
                this.u = true;
            }
            V0();
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i2) {
        Drawable drawable;
        try {
            drawable = getResources().getDrawable(i2);
        } catch (Exception unused) {
            drawable = null;
        }
        setImageDrawable(drawable);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.U.c(interpolator);
    }

    public void setMaxAnimFromWaiteTime(int i2) {
        this.f7844j = i2;
    }

    public void setMaxScale(float f2) {
        this.f7840f = f2;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        super.setOnClickListener(onClickListener);
        this.r = onClickListener;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.c0 = onLongClickListener;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (scaleType == ImageView.ScaleType.MATRIX || scaleType == this.s) {
            return;
        }
        this.s = scaleType;
        if (this.z) {
            V0();
        }
    }

    public PhotoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7837c = 16384;
        this.f7841g = 0;
        this.f7842h = 0;
        this.f7843i = 0;
        this.f7844j = 500;
        this.f7845k = new Matrix();
        this.f7846l = new Matrix();
        this.f7847m = new Matrix();
        this.n = new Matrix();
        this.x = false;
        this.y = false;
        this.H = 1.0f;
        this.M = new RectF();
        this.N = new RectF();
        this.O = new RectF();
        this.P = new RectF();
        this.Q = new RectF();
        this.R = new PointF();
        this.S = new PointF();
        this.T = new PointF();
        this.U = new l();
        this.d0 = new a();
        this.e0 = new b();
        this.f0 = new c();
        this.g0 = new d();
        init();
    }

    public PhotoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7837c = 16384;
        this.f7841g = 0;
        this.f7842h = 0;
        this.f7843i = 0;
        this.f7844j = 500;
        this.f7845k = new Matrix();
        this.f7846l = new Matrix();
        this.f7847m = new Matrix();
        this.n = new Matrix();
        this.x = false;
        this.y = false;
        this.H = 1.0f;
        this.M = new RectF();
        this.N = new RectF();
        this.O = new RectF();
        this.P = new RectF();
        this.Q = new RectF();
        this.R = new PointF();
        this.S = new PointF();
        this.T = new PointF();
        this.U = new l();
        this.d0 = new a();
        this.e0 = new b();
        this.f0 = new c();
        this.g0 = new d();
        init();
    }
}
