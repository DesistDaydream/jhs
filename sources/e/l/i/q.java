package e.l.i;

import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.databinding.BindingAdapter;
import java.util.List;

/* loaded from: classes2.dex */
public final class q {
    @k.e.a.d
    public static final q a = new q();
    @k.e.a.d
    private static final String b = "android:list_adapter";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12196c = "android:list_data";

    private q() {
    }

    @BindingAdapter({b, f12196c})
    @h.k2.k
    public static final <T, A extends e.l.g.e<T>> void a(@k.e.a.d ListView listView, @k.e.a.e e.l.g.e<T> eVar, @k.e.a.e List<? extends T> list) {
        if (listView.getAdapter() != null || !h.k2.v.f0.g(eVar, listView.getAdapter())) {
            listView.setAdapter((ListAdapter) eVar);
        }
        if (eVar == null) {
            return;
        }
        eVar.f(list);
    }
}
