package e.l.q.c.t0.d.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* loaded from: classes2.dex */
public class a implements d {

    /* renamed from: h  reason: collision with root package name */
    private static final String f14227h = "CupcakeGestureDetector";
    public e a;
    public float b;

    /* renamed from: c  reason: collision with root package name */
    public float f14228c;

    /* renamed from: d  reason: collision with root package name */
    public final float f14229d;

    /* renamed from: e  reason: collision with root package name */
    public final float f14230e;

    /* renamed from: f  reason: collision with root package name */
    private VelocityTracker f14231f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f14232g;

    public a(Context context) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f14230e = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f14229d = viewConfiguration.getScaledTouchSlop();
    }

    @Override // e.l.q.c.t0.d.e.d
    public void a(e eVar) {
        this.a = eVar;
    }

    @Override // e.l.q.c.t0.d.e.d
    public boolean b() {
        return this.f14232g;
    }

    @Override // e.l.q.c.t0.d.e.d
    public boolean c() {
        return false;
    }

    public float d(MotionEvent motionEvent) {
        return motionEvent.getX();
    }

    public float e(MotionEvent motionEvent) {
        return motionEvent.getY();
    }

    @Override // e.l.q.c.t0.d.e.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int action = motionEvent.getAction();
        if (action == 0) {
            VelocityTracker obtain = VelocityTracker.obtain();
            this.f14231f = obtain;
            if (obtain != null) {
                obtain.addMovement(motionEvent);
            } else {
                e.l.q.c.t0.d.f.a.a().i(f14227h, "Velocity tracker is null");
            }
            this.b = d(motionEvent);
            this.f14228c = e(motionEvent);
            this.f14232g = false;
        } else if (action == 1) {
            if (this.f14232g && this.f14231f != null) {
                this.b = d(motionEvent);
                this.f14228c = e(motionEvent);
                this.f14231f.addMovement(motionEvent);
                this.f14231f.computeCurrentVelocity(1000);
                float xVelocity = this.f14231f.getXVelocity();
                float yVelocity = this.f14231f.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.f14230e) {
                    this.a.onFling(this.b, this.f14228c, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker2 = this.f14231f;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.f14231f = null;
            }
        } else if (action == 2) {
            float d2 = d(motionEvent);
            float e2 = e(motionEvent);
            float f2 = d2 - this.b;
            float f3 = e2 - this.f14228c;
            if (!this.f14232g) {
                this.f14232g = Math.sqrt((double) ((f2 * f2) + (f3 * f3))) >= ((double) this.f14229d);
            }
            if (this.f14232g) {
                this.a.onDrag(f2, f3);
                this.b = d2;
                this.f14228c = e2;
                VelocityTracker velocityTracker3 = this.f14231f;
                if (velocityTracker3 != null) {
                    velocityTracker3.addMovement(motionEvent);
                }
            }
        } else if (action == 3 && (velocityTracker = this.f14231f) != null) {
            velocityTracker.recycle();
            this.f14231f = null;
        }
        return true;
    }
}
