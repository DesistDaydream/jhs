package e.t.l;

import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\n\u001a\u00020\u000b*\u00020\u0001\u001a\n\u0010\f\u001a\u00020\u000b*\u00020\u0001\"\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00018Æ\u0002¢\u0006\u0006\u001a\u0004\b\t\u0010\u0003¨\u0006\r"}, d2 = {"alpha", "", "getAlpha", "(I)I", "blue", "getBlue", "green", "getGreen", "red", "getRed", "isDark", "", "isLight", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    public static final int a(@ColorInt int i2) {
        return (i2 >> 24) & 255;
    }

    public static final int b(@ColorInt int i2) {
        return i2 & 255;
    }

    public static final int c(@ColorInt int i2) {
        return (i2 >> 8) & 255;
    }

    public static final int d(@ColorInt int i2) {
        return (i2 >> 16) & 255;
    }

    public static final boolean e(int i2) {
        return ColorUtils.calculateLuminance(i2) < 0.5d;
    }

    public static final boolean f(int i2) {
        return ColorUtils.calculateLuminance(i2) >= 0.5d;
    }
}
