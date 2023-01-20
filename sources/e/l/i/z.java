package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.model.GradeDetail;
import com.jihuanshe.ui.widget.ScoreNumView;
import java.util.List;

/* loaded from: classes2.dex */
public final class z {
    @k.e.a.d
    public static final z a = new z();
    @k.e.a.d
    private static final String b = "android:snv_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12232c = "android:snv_gradeUserTotal";

    private z() {
    }

    @BindingAdapter({f12232c, b})
    @h.k2.k
    public static final void a(@k.e.a.d ScoreNumView scoreNumView, @k.e.a.e Integer num, @k.e.a.e List<GradeDetail> list) {
        if (list == null || num == null) {
            return;
        }
        scoreNumView.a(num.intValue(), list);
    }
}
