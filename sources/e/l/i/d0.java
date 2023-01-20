package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.StarRatingBar;

/* loaded from: classes2.dex */
public final class d0 {
    @k.e.a.d
    public static final d0 a = new d0();
    @k.e.a.d
    private static final String b = "android:starRatingBar_numStars";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12151c = "android:starRatingBar_rating";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12152d = "android:starRatingBar_isIndicator";

    private d0() {
    }

    @BindingAdapter({b, f12152d})
    @h.k2.k
    public static final void a(@k.e.a.d StarRatingBar starRatingBar, @k.e.a.e Integer num, @k.e.a.e Boolean bool) {
        starRatingBar.setNumStars(num == null ? 0 : num.intValue());
        starRatingBar.setIsIndicator(bool != null ? bool.booleanValue() : false);
    }

    @BindingAdapter({f12151c})
    @h.k2.k
    public static final void b(@k.e.a.d StarRatingBar starRatingBar, @k.e.a.e Float f2) {
        starRatingBar.setRating(f2 == null ? 0.0f : f2.floatValue());
    }
}
