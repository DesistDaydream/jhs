package e.b.a.t.k;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* loaded from: classes.dex */
public class g extends j<Drawable> {
    public g(ImageView imageView) {
        super(imageView);
    }

    @Override // e.b.a.t.k.j
    /* renamed from: p */
    public void n(@Nullable Drawable drawable) {
        ((ImageView) this.b).setImageDrawable(drawable);
    }

    @Deprecated
    public g(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
