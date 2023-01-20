package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.bottomtab.BottomTabLayout;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {
    @k.e.a.d
    public static final c a = new c();
    @k.e.a.d
    private static final String b = "android:bottomTabLayout_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12149c = "android:bottomTabLayout_onTabSelect";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12150d = "bottomTabLayout_curPos";

    private c() {
    }

    @BindingAdapter(requireAll = false, value = {b, f12150d})
    @h.k2.k
    public static final void a(@k.e.a.d BottomTabLayout bottomTabLayout, @k.e.a.d List<e.l.q.c.p0.c> list, @k.e.a.e Integer num) {
        bottomTabLayout.c(list, num == null ? 0 : num.intValue());
    }

    @BindingAdapter(requireAll = false, value = {f12149c})
    @h.k2.k
    public static final void b(@k.e.a.d BottomTabLayout bottomTabLayout, @k.e.a.d BottomTabLayout.a aVar) {
        bottomTabLayout.setOnTabSelectListener(aVar);
    }
}
