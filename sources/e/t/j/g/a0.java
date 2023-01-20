package e.t.j.g;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.RadioButton;
import androidx.databinding.BindingAdapter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/databinding/adapter/RadioButtonBinding;", "", "()V", "BUTTON_DRAWABLE", "", "setButtonDrawable", "", "radioBtn", "Landroid/widget/RadioButton;", e.j.a.b.c.f.f10128d, "Landroid/graphics/drawable/Drawable;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a0 {
    @k.e.a.d
    public static final a0 a = new a0();
    @k.e.a.d
    private static final String b = "android:radioButton_drawable";

    private a0() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d RadioButton radioButton, @k.e.a.e Drawable drawable) {
        if (Build.VERSION.SDK_INT >= 21) {
            radioButton.setButtonDrawable((Drawable) null);
        } else if (drawable == null) {
            radioButton.setButtonDrawable(new ColorDrawable(0));
        } else {
            radioButton.setButtonDrawable(drawable);
        }
    }
}
