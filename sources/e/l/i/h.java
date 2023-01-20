package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Category;
import com.jihuanshe.ui.widget.CPHorizontalScrollView;
import com.jihuanshe.ui.widget.CustomHorizontalScrollView;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public final class h {
    @k.e.a.d
    public static final h a = new h();
    @k.e.a.d
    private static final String b = "android:chsv_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12172c = "android:chsv_listener";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12173d = "android:chsv_first_type";

    private h() {
    }

    @BindingAdapter(requireAll = false, value = {f12173d, b, f12172c})
    @h.k2.k
    public static final void a(@k.e.a.d CPHorizontalScrollView cPHorizontalScrollView, @k.e.a.e Integer num, @k.e.a.e List<CardPackage> list, @k.e.a.e h.k2.u.l<? super Integer, t1> lVar) {
        cPHorizontalScrollView.f(num);
        cPHorizontalScrollView.setData(list);
        cPHorizontalScrollView.setListener(lVar);
    }

    @BindingAdapter(requireAll = false, value = {b, f12172c})
    @h.k2.k
    public static final void b(@k.e.a.d CustomHorizontalScrollView customHorizontalScrollView, @k.e.a.e List<Category> list, @k.e.a.e h.k2.u.l<? super Integer, t1> lVar) {
        customHorizontalScrollView.setData(list);
        customHorizontalScrollView.setListener(lVar);
    }
}
