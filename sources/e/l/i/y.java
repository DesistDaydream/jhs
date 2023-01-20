package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.model.Rarity;
import com.jihuanshe.ui.widget.RarityFilterBtn;
import h.t1;
import java.util.List;

/* loaded from: classes2.dex */
public final class y {
    @k.e.a.d
    public static final y a = new y();
    @k.e.a.d
    private static final String b = "android:rf_choose";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12230c = "android:rf_data";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12231d = "android:rf_stat";

    private y() {
    }

    @BindingAdapter({b, f12230c})
    @h.k2.k
    public static final void a(@k.e.a.d RarityFilterBtn rarityFilterBtn, @k.e.a.e h.k2.u.l<? super List<Rarity>, t1> lVar, @k.e.a.e List<Rarity> list) {
        rarityFilterBtn.setListener(lVar);
        rarityFilterBtn.setData(list);
    }

    @BindingAdapter({f12231d})
    @h.k2.k
    public static final void b(@k.e.a.d RarityFilterBtn rarityFilterBtn, @k.e.a.e h.k2.u.l<? super List<Rarity>, t1> lVar) {
        rarityFilterBtn.setStatListener(lVar);
    }
}
