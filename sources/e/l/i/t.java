package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.PriceTextView;

/* loaded from: classes2.dex */
public final class t {
    @k.e.a.d
    public static final t a = new t();
    @k.e.a.d
    private static final String b = "android:ptv_price";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12211c = "android:ptv_type";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f12212d = "android:ptv_empty_text";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f12213e = "android:ptv_size";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f12214f = "android:ptv_show_zero";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f12215g = "android:ptv_bold";

    private t() {
    }

    @BindingAdapter(requireAll = false, value = {b, f12211c, f12212d, f12213e, f12214f, f12215g})
    @h.k2.k
    public static final void a(@k.e.a.d PriceTextView priceTextView, @k.e.a.e Float f2, @k.e.a.e Integer num, @k.e.a.e Integer num2, @k.e.a.e Integer num3, @k.e.a.e Boolean bool, @k.e.a.e Boolean bool2) {
        priceTextView.f(f2 == null ? 0.0f : f2.floatValue(), bool == null ? false : bool.booleanValue(), num2 == null ? R.string.shop_no_price : num2.intValue(), bool2 == null ? false : bool2.booleanValue(), num3 == null ? 8 : num3.intValue(), num == null ? 0 : num.intValue());
    }
}
