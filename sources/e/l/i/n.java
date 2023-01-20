package e.l.i;

import androidx.annotation.ColorInt;
import androidx.databinding.BindingAdapter;
import com.jihuanshe.model.Game;
import com.jihuanshe.ui.widget.GameFilterBtn;
import h.t1;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;

/* loaded from: classes2.dex */
public final class n {
    @k.e.a.d
    public static final n a = new n();
    @k.e.a.d
    private static final String b = "android:gf_choose";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12181c = "android:gf_multiChoose";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12182d = "android:gf_text_tint_color";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12183e = "android:gf_data";

    private n() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d GameFilterBtn gameFilterBtn, @k.e.a.e h.k2.u.l<? super Game, t1> lVar) {
        gameFilterBtn.setListener(lVar);
    }

    @BindingAdapter({f12183e})
    @h.k2.k
    public static final void b(@k.e.a.d GameFilterBtn gameFilterBtn, @k.e.a.e List<Game> list) {
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        gameFilterBtn.setData(list);
    }

    @BindingAdapter({f12181c})
    @h.k2.k
    public static final void c(@k.e.a.d GameFilterBtn gameFilterBtn, @k.e.a.e h.k2.u.l<? super List<Game>, t1> lVar) {
        gameFilterBtn.setMultiListener(lVar);
    }

    @BindingAdapter({f12182d})
    @h.k2.k
    public static final void d(@k.e.a.d GameFilterBtn gameFilterBtn, @ColorInt @k.e.a.e Integer num) {
        if (num != null) {
            gameFilterBtn.setTextAndDrawableTint(num.intValue());
        }
    }
}
