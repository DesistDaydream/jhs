package e.t.j.g;

import androidx.databinding.BindingAdapter;
import com.vector.view.ProgressView;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/vector/databinding/adapter/ProgressViewBinding;", "", "()V", "ANIMATION_STATUS", "", "setAnimStatus", "", "view", "Lcom/vector/view/ProgressView;", "bool", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class z {
    @k.e.a.d
    public static final z a = new z();
    @k.e.a.d
    private static final String b = "android:progressView_animation_toggle";

    private z() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d ProgressView progressView, boolean z) {
        if (z) {
            progressView.z();
        } else {
            progressView.A();
        }
    }
}
