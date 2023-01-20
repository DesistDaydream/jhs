package e.t.j.g;

import androidx.annotation.ColorInt;
import androidx.databinding.BindingAdapter;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.vector.view.SideBar;
import e.t.j.h.l0;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JQ\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0001\u0010\u0011\u001a\u0004\u0018\u00010\u000f2\n\b\u0001\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/vector/databinding/adapter/SideBarBinding;", "", "()V", "ON_TOUCH_LETTER", "", "SELECTIONS", "TEXT_COLOR", "TEXT_COLOR_FOCUS", "TEXT_GAP", "TEXT_SIZE", "setAttrs", "", "view", "Lcom/vector/view/SideBar;", "size", "", "gap", "color", "colorFocus", "selections", "", "(Lcom/vector/view/SideBar;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;[Ljava/lang/String;)V", "setOnTouchLetter", AbsServerManager.BUNDLE_BINDER, "Lcom/vector/databinding/onBind/OnTouchLetterBinder;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c0 {
    @k.e.a.d
    public static final c0 a = new c0();
    @k.e.a.d
    private static final String b = "android:sideBar_textSize";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14480c = "android:sideBar_textGap";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f14481d = "android:sideBar_textColor";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f14482e = "android:sideBar_textColorFocus";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f14483f = "android:sideBar_selections";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f14484g = "android:sideBar_onTouchLetter";

    private c0() {
    }

    @BindingAdapter(requireAll = false, value = {b, f14480c, f14481d, f14482e, f14483f})
    @h.k2.k
    public static final void a(@k.e.a.d SideBar sideBar, @k.e.a.e Integer num, @k.e.a.e Integer num2, @ColorInt @k.e.a.e Integer num3, @ColorInt @k.e.a.e Integer num4, @k.e.a.e String[] strArr) {
        if (num != null) {
            sideBar.setTextSize(e.t.o.d.a.a(sideBar.getContext()).d(num.intValue()));
        }
        if (num2 != null) {
            sideBar.setTextGap(e.t.o.d.a.a(sideBar.getContext()).d(num2.intValue()));
        }
        if (num3 != null) {
            sideBar.setColor(num3.intValue());
        }
        if (num4 != null) {
            sideBar.setColorFocus(num4.intValue());
        }
        if (strArr == null) {
            return;
        }
        sideBar.setSelections(strArr);
    }

    @BindingAdapter({f14484g})
    @h.k2.k
    public static final void b(@k.e.a.d SideBar sideBar, @k.e.a.d l0 l0Var) {
        sideBar.setOnTouchLetterChangeListener(l0Var.a());
    }
}
