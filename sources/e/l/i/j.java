package e.l.i;

import android.widget.ImageView;
import androidx.databinding.BindingAdapter;

/* loaded from: classes2.dex */
public final class j {
    @k.e.a.d
    public static final j a = new j();
    @k.e.a.d
    private static final String b = "android:drawable_icon";

    private j() {
    }

    @BindingAdapter(requireAll = true, value = {b})
    @h.k2.k
    public static final void a(@k.e.a.d ImageView imageView, int i2) {
        imageView.setImageResource(i2);
    }
}
