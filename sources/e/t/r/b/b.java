package e.t.r.b;

import android.view.MotionEvent;

/* loaded from: classes3.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    private static final int f14637h = 120;
    private a a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f14638c;

    /* renamed from: d  reason: collision with root package name */
    private float f14639d;

    /* renamed from: e  reason: collision with root package name */
    private float f14640e;

    /* renamed from: f  reason: collision with root package name */
    private float f14641f;

    /* renamed from: g  reason: collision with root package name */
    private float f14642g;

    public b(a aVar) {
        this.a = aVar;
    }

    private float a(MotionEvent motionEvent) {
        this.f14639d = motionEvent.getX(0);
        this.f14640e = motionEvent.getY(0);
        this.f14641f = motionEvent.getX(1);
        float y = motionEvent.getY(1);
        this.f14642g = y;
        return (y - this.f14640e) / (this.f14641f - this.f14639d);
    }

    public void b(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 2) {
            if ((actionMasked == 5 || actionMasked == 6) && motionEvent.getPointerCount() == 2) {
                this.b = a(motionEvent);
            }
        } else if (motionEvent.getPointerCount() > 1) {
            float a = a(motionEvent);
            this.f14638c = a;
            double degrees = Math.toDegrees(Math.atan(a)) - Math.toDegrees(Math.atan(this.b));
            if (Math.abs(degrees) <= 120.0d) {
                this.a.a((float) degrees, (this.f14641f + this.f14639d) / 2.0f, (this.f14642g + this.f14640e) / 2.0f);
            }
            this.b = this.f14638c;
        }
    }
}
