package e.j.a.c.a;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class a {
    public static final TimeInterpolator a = new LinearInterpolator();
    public static final TimeInterpolator b = new FastOutSlowInInterpolator();

    /* renamed from: c  reason: collision with root package name */
    public static final TimeInterpolator f10551c = new FastOutLinearInInterpolator();

    /* renamed from: d  reason: collision with root package name */
    public static final TimeInterpolator f10552d = new LinearOutSlowInInterpolator();

    /* renamed from: e  reason: collision with root package name */
    public static final TimeInterpolator f10553e = new DecelerateInterpolator();

    public static float a(float f2, float f3, float f4) {
        return f2 + (f4 * (f3 - f2));
    }

    public static float b(float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, @FloatRange(from = 0.0d, to = 1.0d) float f6) {
        return f6 < f4 ? f2 : f6 > f5 ? f3 : a(f2, f3, (f6 - f4) / (f5 - f4));
    }

    public static int c(int i2, int i3, float f2) {
        return i2 + Math.round(f2 * (i3 - i2));
    }
}
