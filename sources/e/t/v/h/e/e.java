package e.t.v.h.e;

import android.view.View;

/* loaded from: classes3.dex */
public class e extends a {
    private static final float a = 0.75f;

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
        if (f2 <= 0.0f) {
            view.setAlpha(1.0f);
            view.setTranslationX(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
        } else if (f2 <= 1.0f) {
            view.setAlpha(1.0f - f2);
            view.setTranslationX(view.getWidth() * (-f2));
            float abs = ((1.0f - Math.abs(f2)) * 0.25f) + 0.75f;
            view.setScaleX(abs);
            view.setScaleY(abs);
        }
    }
}
