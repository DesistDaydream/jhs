package e.t.l.d0;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"recycleBitmap", "", "Landroid/widget/ImageView;", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    public static final void a(@k.e.a.d ImageView imageView) {
        if (imageView.getDrawable() == null || !(imageView.getDrawable() instanceof BitmapDrawable)) {
            return;
        }
        Drawable drawable = imageView.getDrawable();
        Objects.requireNonNull(drawable, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        ((BitmapDrawable) drawable).getBitmap().recycle();
    }
}
