package e.t.v.h.e;

import android.view.View;

/* loaded from: classes3.dex */
public class d extends a {
    private static final float b = 20.0f;
    private float a;

    @Override // e.t.v.h.e.a
    public void a(View view, float f2) {
        view.setRotation(0.0f);
    }

    @Override // e.t.v.h.e.a
    public void b(View view, float f2) {
        view.setRotation(0.0f);
    }

    @Override // e.t.v.h.e.a
    public void c(View view, float f2) {
        if (f2 < 0.0f) {
            this.a = f2 * 20.0f;
            view.setPivotX(view.getMeasuredWidth() * 0.5f);
            view.setPivotY(view.getMeasuredHeight());
            view.setRotation(this.a);
            return;
        }
        this.a = f2 * 20.0f;
        view.setPivotX(view.getMeasuredWidth() * 0.5f);
        view.setPivotY(view.getMeasuredHeight());
        view.setRotation(this.a);
    }
}
