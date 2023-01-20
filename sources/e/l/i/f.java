package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.widget.ConditionFilterBtn;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public final class f {
    @k.e.a.d
    public static final f a = new f();
    @k.e.a.d
    private static final String b = "android:rf_choose";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12159c = "android:rf_data";

    private f() {
    }

    @BindingAdapter({b, f12159c})
    @h.k2.k
    public static final void a(@k.e.a.d ConditionFilterBtn conditionFilterBtn, @k.e.a.e h.k2.u.l<? super List<Rarity>, t1> lVar, @k.e.a.e List<Rarity> list) {
        conditionFilterBtn.setListener(lVar);
        conditionFilterBtn.setData(list);
    }
}
