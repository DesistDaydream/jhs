package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.shimmer.ShimmerFrameLayout;

/* loaded from: classes2.dex */
public final class b0 {
    @k.e.a.d
    public static final b0 a = new b0();
    @k.e.a.d
    private static final String b = "android:shimmer_start";

    private b0() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d ShimmerFrameLayout shimmerFrameLayout, @k.e.a.e Boolean bool) {
        if (h.k2.v.f0.g(bool, Boolean.TRUE)) {
            shimmerFrameLayout.h(true);
        } else {
            shimmerFrameLayout.b();
        }
    }
}
