package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.exam.ExamIndicatorView;
import java.util.List;

/* loaded from: classes2.dex */
public final class v {
    @k.e.a.d
    public static final v a = new v();
    @k.e.a.d
    private static final String b = "android:quiz_indicator_count";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12217c = "android:quiz_indicator_current";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12218d = "android:quiz_indicator_reset";

    private v() {
    }

    @BindingAdapter({f12218d})
    @h.k2.k
    public static final void a(@k.e.a.d ExamIndicatorView examIndicatorView, @k.e.a.e List<Integer> list) {
        if (list == null) {
            return;
        }
        examIndicatorView.c(list);
    }

    @BindingAdapter({f12217c})
    @h.k2.k
    public static final void b(@k.e.a.d ExamIndicatorView examIndicatorView, @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        examIndicatorView.setClear(num.intValue());
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void c(@k.e.a.d ExamIndicatorView examIndicatorView, @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        examIndicatorView.setCount(num.intValue());
    }
}
