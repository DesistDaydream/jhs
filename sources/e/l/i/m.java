package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.FlexLayout;
import java.util.List;

/* loaded from: classes2.dex */
public final class m {
    @k.e.a.d
    public static final m a = new m();
    @k.e.a.d
    private static final String b = "android:flex_adapter";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12180c = "android:flex_data";

    private m() {
    }

    @BindingAdapter({b, f12180c})
    @h.k2.k
    public static final <T, A extends e.t.k.a.c.f<T>> void a(@k.e.a.d FlexLayout flexLayout, @k.e.a.d A a2, @k.e.a.e List<? extends T> list) {
        a2.setData(list);
        flexLayout.setAdapter(new e.t.k.a.c.c<>(a2));
    }
}
