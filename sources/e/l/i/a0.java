package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.ScoreView;

/* loaded from: classes2.dex */
public final class a0 {
    @k.e.a.d
    public static final a0 a = new a0();
    @k.e.a.d
    private static final String b = "android:scoreView_score";

    private a0() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d ScoreView scoreView, @k.e.a.e Float f2) {
        scoreView.setScore(f2);
    }
}
