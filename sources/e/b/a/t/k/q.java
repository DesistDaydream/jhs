package e.b.a.t.k;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public abstract class q<T> extends j<T> {
    public q(ImageView imageView) {
        super(imageView);
    }

    @Override // e.b.a.t.k.j
    public void n(@Nullable T t) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.b).getLayoutParams();
        Drawable p = p(t);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            p = new i(p, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.b).setImageDrawable(p);
    }

    public abstract Drawable p(T t);

    @Deprecated
    public q(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
