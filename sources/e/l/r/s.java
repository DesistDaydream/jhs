package e.l.r;

import android.view.animation.TranslateAnimation;

/* loaded from: classes2.dex */
public final class s {
    @k.e.a.d
    public static final s a = new s();
    private static final long b = 400;

    private s() {
    }

    public static /* synthetic */ TranslateAnimation c(s sVar, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = b;
        }
        return sVar.b(j2);
    }

    public static /* synthetic */ TranslateAnimation e(s sVar, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = b;
        }
        return sVar.d(j2);
    }

    public static /* synthetic */ TranslateAnimation g(s sVar, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = b;
        }
        return sVar.f(j2);
    }

    public static /* synthetic */ TranslateAnimation i(s sVar, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = b;
        }
        return sVar.h(j2);
    }

    public final long a() {
        return b;
    }

    @k.e.a.d
    public final TranslateAnimation b(long j2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, -1.0f);
        translateAnimation.setDuration(j2);
        return translateAnimation;
    }

    @k.e.a.d
    public final TranslateAnimation d(long j2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 0.0f, 1, 1.0f);
        translateAnimation.setDuration(j2);
        return translateAnimation;
    }

    @k.e.a.d
    public final TranslateAnimation f(long j2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
        translateAnimation.setDuration(j2);
        return translateAnimation;
    }

    @k.e.a.d
    public final TranslateAnimation h(long j2) {
        TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, -1.0f, 1, 0.0f);
        translateAnimation.setDuration(j2);
        return translateAnimation;
    }
}
