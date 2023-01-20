package com.vector.databinding.adapter;

import androidx.databinding.BindingAdapter;
import com.vector.view.CaptchaView;
import h.k2.k;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/vector/databinding/adapter/CaptchaViewBinding;", "", "()V", "COUNTDOWN_START", "", "COUNTDOWN_TEXT", "MAX_COUNT", "RESENT_TEXT", "setCountdownStart", "", "captchaView", "Lcom/vector/view/CaptchaView;", "flag", "", "setCountdownText", "text", "setMaxCount", "count", "", "setResendText", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class CaptchaViewBinding {
    @d
    public static final CaptchaViewBinding a = new CaptchaViewBinding();
    @d
    private static final String b = "android:captchaView_maxCount";
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final String f7664c = "android:captchaView_resendText";
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final String f7665d = "android:captchaView_countdownText";
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final String f7666e = "android:captchaView_countdownStart";

    private CaptchaViewBinding() {
    }

    @BindingAdapter({f7666e})
    @k
    public static final void a(@d CaptchaView captchaView, boolean z) {
        if (z) {
            captchaView.i();
        }
    }

    @BindingAdapter({f7665d})
    @k
    public static final void b(@d CaptchaView captchaView, @d String str) {
        captchaView.setSecondText(new CaptchaViewBinding$setCountdownText$1(str));
    }

    @BindingAdapter({b})
    @k
    public static final void c(@d CaptchaView captchaView, int i2) {
        captchaView.setMaxCount(i2);
    }

    @BindingAdapter({f7664c})
    @k
    public static final void d(@d CaptchaView captchaView, @d String str) {
        captchaView.setResendText(str);
    }
}
