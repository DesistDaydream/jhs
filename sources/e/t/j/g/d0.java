package e.t.j.g;

import androidx.databinding.BindingAdapter;
import com.vector.view.pager.indicator.UnderlinePageIndicator;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\rH\u0007J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/vector/databinding/adapter/UnderlinePageIndicatorBinding;", "", "()V", "CORNER", "", "FADES", "LINE_WIDTH", "SELECTED_COLOR", "setCorner", "", "view", "Lcom/vector/view/pager/indicator/UnderlinePageIndicator;", "corner", "", "setFades", "fades", "setLineWidth", "width", "", "setSelectColor", "color", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d0 {
    @k.e.a.d
    public static final d0 a = new d0();
    @k.e.a.d
    private static final String b = "android:underlinePageIndicator_lineWidth";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14485c = "android:underlinePageIndicator_fades";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f14486d = "android:underlinePageIndicator_corner";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f14487e = "android:underlinePageIndicator_selectedColor";

    private d0() {
    }

    @BindingAdapter({f14486d})
    @h.k2.k
    public static final void a(@k.e.a.d UnderlinePageIndicator underlinePageIndicator, boolean z) {
        underlinePageIndicator.setCorner(Boolean.valueOf(z));
    }

    @BindingAdapter({f14485c})
    @h.k2.k
    public static final void b(@k.e.a.d UnderlinePageIndicator underlinePageIndicator, boolean z) {
        underlinePageIndicator.setFades(z);
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void c(@k.e.a.d UnderlinePageIndicator underlinePageIndicator, int i2) {
        underlinePageIndicator.setLineWidth(e.t.o.d.a.a(underlinePageIndicator.getContext()).d(i2));
    }

    @BindingAdapter({f14487e})
    @h.k2.k
    public static final void d(@k.e.a.d UnderlinePageIndicator underlinePageIndicator, int i2) {
        underlinePageIndicator.setSelectedColor(i2);
    }
}
