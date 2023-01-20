package e.l.q.c.t0.d.e;

import android.content.Context;
import android.view.MotionEvent;

/* loaded from: classes2.dex */
public class b extends a {

    /* renamed from: k  reason: collision with root package name */
    private static final int f14233k = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f14234i;

    /* renamed from: j  reason: collision with root package name */
    private int f14235j;

    public b(Context context) {
        super(context);
        this.f14234i = -1;
        this.f14235j = 0;
    }

    @Override // e.l.q.c.t0.d.e.a
    public float d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f14235j);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    @Override // e.l.q.c.t0.d.e.a
    public float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f14235j);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    @Override // e.l.q.c.t0.d.e.a, e.l.q.c.t0.d.e.d
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f14234i = motionEvent.getPointerId(0);
        } else if (action == 1 || action == 3) {
            this.f14234i = -1;
        } else if (action == 6) {
            int a = e.l.q.c.t0.d.a.a(motionEvent.getAction());
            if (motionEvent.getPointerId(a) == this.f14234i) {
                int i2 = a == 0 ? 1 : 0;
                this.f14234i = motionEvent.getPointerId(i2);
                this.b = motionEvent.getX(i2);
                this.f14228c = motionEvent.getY(i2);
            }
        }
        int i3 = this.f14234i;
        this.f14235j = motionEvent.findPointerIndex(i3 != -1 ? i3 : 0);
        try {
            return super.onTouchEvent(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }
}
