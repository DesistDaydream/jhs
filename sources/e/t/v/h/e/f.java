package e.t.v.h.e;

import android.view.View;

/* loaded from: classes3.dex */
public class f extends a {
    private static final float a = 0.85f;
    private static final float b = 0.5f;

    @Override // e.t.v.h.e.a
    public void a(View view, float f2) {
        view.setAlpha(0.0f);
    }

    @Override // e.t.v.h.e.a
    public void b(View view, float f2) {
        view.setAlpha(0.0f);
    }

    @Override // e.t.v.h.e.a
    public void c(View view, float f2) {
        float max = Math.max((float) a, 1.0f - Math.abs(f2));
        int width = view.getWidth();
        float f3 = 1.0f - max;
        float height = (view.getHeight() * f3) / 2.0f;
        float f4 = (width * f3) / 2.0f;
        if (f2 < 0.0f) {
            view.setTranslationX(f4 - (height / 2.0f));
        } else {
            view.setTranslationX((-f4) + (height / 2.0f));
        }
        view.setScaleX(max);
        view.setScaleY(max);
        view.setAlpha((((max - a) / 0.14999998f) * 0.5f) + 0.5f);
    }
}
