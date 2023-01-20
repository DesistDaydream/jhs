package e.t.v.h.e;

import android.view.View;

/* loaded from: classes3.dex */
public class b extends a {
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
        view.setAlpha(1.0f - Math.abs(f2));
    }
}
