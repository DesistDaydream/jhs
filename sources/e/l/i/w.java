package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.RankImageView;

/* loaded from: classes2.dex */
public final class w {
    @k.e.a.d
    public static final w a = new w();
    @k.e.a.d
    private static final String b = "android:rank_imageview_isOnClick";

    private w() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d RankImageView rankImageView, @k.e.a.e Boolean bool) {
        if (bool != null) {
            rankImageView.setOnClick(bool.booleanValue());
        }
    }

    public static /* synthetic */ void b(RankImageView rankImageView, Boolean bool, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            bool = Boolean.FALSE;
        }
        a(rankImageView, bool);
    }
}
