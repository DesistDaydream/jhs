package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.ui.widget.NumberView;

/* loaded from: classes2.dex */
public final class s {
    @k.e.a.d
    public static final s a = new s();
    @k.e.a.d
    private static final String b = "android:nv_current";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12208c = "android:nv_max";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12209d = "android:nv_change";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12210e = "android:nv_inputable";

    private s() {
    }

    @BindingAdapter(requireAll = false, value = {b, f12208c, f12209d, f12210e})
    @h.k2.k
    public static final void a(@k.e.a.d NumberView numberView, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e NumberView.a aVar, @k.e.a.e Boolean bool) {
        if (num2 != null) {
            numberView.setMaxCount(num2.intValue());
        }
        if (num != null) {
            numberView.setCurrentNumber(num.intValue());
        }
        if (bool != null) {
            numberView.setInputAble(bool.booleanValue());
        }
        numberView.setOnChangeListener(aVar);
    }
}
