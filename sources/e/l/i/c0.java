package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.SortImageView;

/* loaded from: classes2.dex */
public final class c0 {
    @k.e.a.d
    public static final c0 a = new c0();
    @k.e.a.d
    private static final String b = "android:sort_up";

    private c0() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d SortImageView sortImageView, @k.e.a.e Boolean bool) {
        if (bool == null) {
            return;
        }
        bool.booleanValue();
        sortImageView.setup(bool.booleanValue());
    }
}
