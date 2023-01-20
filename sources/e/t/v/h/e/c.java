package e.t.v.h.e;

import android.view.View;
import android.view.animation.OvershootInterpolator;

/* loaded from: classes3.dex */
public class c extends a {
    private OvershootInterpolator a;

    @Override // e.t.v.h.e.a
    public void a(View view, float f2) {
    }

    @Override // e.t.v.h.e.a
    public void b(View view, float f2) {
    }

    @Override // e.t.v.h.e.a
    public void c(View view, float f2) {
        float f3;
        float f4;
        int interpolation;
        if (this.a == null) {
            this.a = new OvershootInterpolator();
        }
        int width = view.getWidth();
        if (f2 < 0.0f) {
            return;
        }
        if (((int) (((int) (this.a.getInterpolation(f3) * f4)) - ((1.0f - f2) * width))) > 0) {
            view.setTranslationX(-interpolation);
        }
    }
}
