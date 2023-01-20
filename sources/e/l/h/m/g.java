package e.l.h.m;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014¨\u0006\t"}, d2 = {"Lcom/jihuanshe/base/viewpager/ZoomOutTransformer;", "Lcom/jihuanshe/base/viewpager/BaseTransformer;", "()V", "onTransform", "", "page", "Landroid/view/View;", "position", "", "lib-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes2.dex */
public final class g extends a {
    @k.e.a.d
    public static final g a = new g();

    private g() {
    }

    @Override // e.l.h.m.a
    public void e(@k.e.a.d View view, float f2) {
        if (f2 < 0.0f) {
            view.setPivotX(view.getWidth() * 0.5f);
            view.setPivotY(view.getHeight() * 0.5f);
            float abs = 1.0f - Math.abs(f2);
            view.setScaleX(abs);
            view.setScaleY(abs);
        }
    }
}
