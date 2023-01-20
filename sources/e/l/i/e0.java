package e.l.i;

import androidx.databinding.BindingAdapter;
import com.jyn.vcview.VerificationCodeView;

/* loaded from: classes2.dex */
public final class e0 {
    @k.e.a.d
    public static final e0 a = new e0();
    @k.e.a.d
    private static final String b = "android:verify_listener";

    private e0() {
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void a(@k.e.a.d VerificationCodeView verificationCodeView, @k.e.a.e VerificationCodeView.b bVar) {
        verificationCodeView.setOnCodeFinishListener(bVar);
    }
}
