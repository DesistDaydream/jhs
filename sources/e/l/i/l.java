package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.FilterInfoBtn;
import com.jihuanshe.ui.widget.FilterTextView;
import h.t1;
import java.util.List;
import kotlin.Pair;

/* loaded from: classes2.dex */
public final class l {
    @k.e.a.d
    public static final l a = new l();
    @k.e.a.d
    private static final String b = "android:filterTv_data";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12176c = "android:filterTv_listener";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12177d = "android:filterTv_onShowState";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12178e = "android:filterTv_pos";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f12179f = "android:filterTv_stat";

    private l() {
    }

    @BindingAdapter({b, f12176c, f12177d})
    @h.k2.k
    public static final void a(@k.e.a.d FilterTextView filterTextView, @k.e.a.d List<Pair<String, String>> list, @k.e.a.e h.k2.u.l<? super Pair<String, String>, t1> lVar, @k.e.a.e h.k2.u.l<? super Boolean, t1> lVar2) {
        filterTextView.setDataList(list);
        filterTextView.setChooseListener(lVar);
        filterTextView.setOnShowStateListener(lVar2);
    }

    public static /* synthetic */ void b(FilterTextView filterTextView, List list, h.k2.u.l lVar, h.k2.u.l lVar2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            lVar = null;
        }
        if ((i2 & 8) != 0) {
            lVar2 = null;
        }
        a(filterTextView, list, lVar, lVar2);
    }

    @BindingAdapter({b, f12178e, f12176c})
    @h.k2.k
    public static final void c(@k.e.a.d FilterInfoBtn filterInfoBtn, @k.e.a.e List<e.l.s.a> list, @k.e.a.e Integer num, @k.e.a.e h.k2.u.l<? super e.l.s.a, t1> lVar) {
        filterInfoBtn.d(list, num == null ? 0 : num.intValue());
        filterInfoBtn.setChooseListener(lVar);
    }

    public static /* synthetic */ void d(FilterInfoBtn filterInfoBtn, List list, Integer num, h.k2.u.l lVar, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            lVar = null;
        }
        c(filterInfoBtn, list, num, lVar);
    }

    @BindingAdapter({f12179f})
    @h.k2.k
    public static final void e(@k.e.a.d FilterTextView filterTextView, @k.e.a.e h.k2.u.l<? super Pair<String, String>, t1> lVar) {
        filterTextView.setStatListener(lVar);
    }
}
