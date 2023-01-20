package e.i.a.a;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes.dex */
public class c {

    /* renamed from: k  reason: collision with root package name */
    private static final int f10041k = -1;
    private int a = -1;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private final ScaleGestureDetector f10042c;

    /* renamed from: d  reason: collision with root package name */
    private VelocityTracker f10043d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10044e;

    /* renamed from: f  reason: collision with root package name */
    private float f10045f;

    /* renamed from: g  reason: collision with root package name */
    private float f10046g;

    /* renamed from: h  reason: collision with root package name */
    private final float f10047h;

    /* renamed from: i  reason: collision with root package name */
    private final float f10048i;

    /* renamed from: j  reason: collision with root package name */
    private d f10049j;

    /* loaded from: classes.dex */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor >= 0.0f) {
                c.this.f10049j.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                return true;
            }
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

    public c(Context context, d dVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f10048i = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f10047h = viewConfiguration.getScaledTouchSlop();
        this.f10049j = dVar;
        this.f10042c = new ScaleGestureDetector(context, new a());
    }

    private float b(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    private float c(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    private boolean g(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.a = motionEvent.getPointerId(0);
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f10043d = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            }
            this.f10045f = b(motionEvent);
            this.f10046g = c(motionEvent);
            this.f10044e = false;
        } else if (action == 1) {
            this.a = -1;
            if (this.f10044e && this.f10043d != null) {
                this.f10045f = b(motionEvent);
                this.f10046g = c(motionEvent);
                this.f10043d.addMovement(motionEvent);
                this.f10043d.computeCurrentVelocity(1000);
                float xVelocity = this.f10043d.getXVelocity();
                float yVelocity = this.f10043d.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f10048i) {
                    this.f10049j.onFling(this.f10045f, this.f10046g, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f10043d;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f10043d = null;
            }
        } else if (action == 2) {
            float b = b(motionEvent);
            float c2 = c(motionEvent);
            float f2 = b - this.f10045f;
            float f3 = c2 - this.f10046g;
            if (!this.f10044e) {
                this.f10044e = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f10047h);
            }
            if (this.f10044e) {
                this.f10049j.onDrag(f2, f3);
                this.f10045f = b;
                this.f10046g = c2;
                VelocityTracker velocityTracker2 = this.f10043d;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.a = -1;
            VelocityTracker velocityTracker3 = this.f10043d;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f10043d = null;
            }
        } else if (action == 6) {
            int b2 = m.b(motionEvent.getAction());
            if (motionEvent.getPointerId(b2) == this.a) {
                int i2 = b2 == 0 ? 1 : 0;
                this.a = motionEvent.getPointerId(i2);
                this.f10045f = motionEvent.getX(i2);
                this.f10046g = motionEvent.getY(i2);
            }
        }
        int i3 = this.a;
        this.b = motionEvent.findPointerIndex(i3 != -1 ? i3 : 0);
        return true;
    }

    public boolean d() {
        return this.f10044e;
    }

    public boolean e() {
        return this.f10042c.isInProgress();
    }

    public boolean f(MotionEvent motionEvent) {
        try {
            this.f10042c.onTouchEvent(motionEvent);
            return g(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
