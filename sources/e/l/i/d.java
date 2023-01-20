package e.l.i;

import android.content.res.ColorStateList;
import androidx.databinding.BindingAdapter;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes2.dex */
public final class d {
    @k.e.a.d
    public static final d a = new d();
    @k.e.a.d
    private static final String b = "btn_backgroundTint";

    private d() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d MaterialButton materialButton, @k.e.a.e Integer num) {
        materialButton.setBackgroundTintList(num == null ? null : ColorStateList.valueOf(num.intValue()));
    }
}
