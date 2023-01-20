package e.t.v.h.e;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes3.dex */
public abstract class a implements ViewPager.PageTransformer {
    public abstract void a(View view, float f2);

    public abstract void b(View view, float f2);

    public abstract void c(View view, float f2);

    @Override // androidx.viewpager.widget.ViewPager.PageTransformer
    public void transformPage(@NonNull View view, float f2) {
        if (f2 < -1.0f) {
            a(view, f2);
        } else if (f2 <= 1.0f) {
            c(view, f2);
        } else {
            b(view, f2);
        }
    }
}
