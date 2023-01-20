package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.ConditionView;

/* loaded from: classes2.dex */
public final class g {
    @k.e.a.d
    public static final g a = new g();
    @k.e.a.d
    private static final String b = "android:condition_data";

    private g() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d ConditionView conditionView, @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        conditionView.setCondition(num.intValue());
    }
}
