package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.model.Category;
import com.jihuanshe.ui.widget.CustomShopIndicatorView;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public final class i {
    @k.e.a.d
    public static final i a = new i();
    @k.e.a.d
    private static final String b = "android:csiv_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12174c = "android:csiv_listener";

    private i() {
    }

    @BindingAdapter({b, f12174c})
    @h.k2.k
    public static final void a(@k.e.a.d CustomShopIndicatorView customShopIndicatorView, @k.e.a.e List<Category> list, @k.e.a.e h.k2.u.l<? super Integer, t1> lVar) {
        customShopIndicatorView.scrollTo(0, 0);
        customShopIndicatorView.setData(list);
        customShopIndicatorView.setListener(lVar);
    }
}
