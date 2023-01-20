package e.l.i;

import androidx.databinding.BindingAdapter;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;

/* loaded from: classes2.dex */
public final class k {
    @k.e.a.d
    public static final k a = new k();
    @k.e.a.d
    private static final String b = "android:expandableTextView_text";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f12175c = "android:expandableTextView_expand";

    private k() {
    }

    @BindingAdapter(requireAll = false, value = {b, f12175c})
    @h.k2.k
    public static final void a(@k.e.a.d ExpandableTextView expandableTextView, @k.e.a.e String str, @k.e.a.e e.e.a.a.a aVar) {
        expandableTextView.F(aVar);
        if (str == null) {
            str = "";
        }
        expandableTextView.setContent(str);
    }
}
