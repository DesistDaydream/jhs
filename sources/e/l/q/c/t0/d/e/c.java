package e.l.q.c.t0.d.e;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;

/* loaded from: classes2.dex */
public class c extends b {

    /* renamed from: l  reason: collision with root package name */
    public final ScaleGestureDetector f14236l;

    /* loaded from: classes2.dex */
    public class a implements ScaleGestureDetector.OnScaleGestureListener {
        public a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            c.this.a.onScale(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
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

    public c(Context context) {
        super(context);
        this.f14236l = new ScaleGestureDetector(context, new a());
    }

    @Override // e.l.q.c.t0.d.e.a, e.l.q.c.t0.d.e.d
    public boolean c() {
        return this.f14236l.isInProgress();
    }

    @Override // e.l.q.c.t0.d.e.b, e.l.q.c.t0.d.e.a, e.l.q.c.t0.d.e.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        try {
            this.f14236l.onTouchEvent(motionEvent);
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
