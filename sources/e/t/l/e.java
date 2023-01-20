package e.t.l;

import android.graphics.BitmapFactory;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a \u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u001a\u0010\u0007\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"UN_CONSTRAINED", "", "calcSimpleSize", "opts", "Landroid/graphics/BitmapFactory$Options;", "minSideLength", "maxPixels", "calcSampleSize", "width", "height", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class e {
    private static final int a = -1;

    public static final int a(@k.e.a.d BitmapFactory.Options options, int i2) {
        return c(options, -1, i2);
    }

    public static final int b(@k.e.a.d BitmapFactory.Options options, int i2, int i3) {
        return c(options, i2 > i3 ? i3 : i2, i2 * i3);
    }

    private static final int c(BitmapFactory.Options options, int i2, int i3) {
        int min;
        double d2 = options.outWidth;
        double d3 = options.outHeight;
        int i4 = 1;
        int ceil = i3 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d2 * d3) / i3));
        if (i2 == -1) {
            min = 128;
        } else {
            double d4 = i2;
            min = (int) Math.min(Math.floor(d2 / d4), Math.floor(d3 / d4));
        }
        if (min >= ceil) {
            if (i3 == -1 && i2 == -1) {
                ceil = 1;
            } else if (i2 != -1) {
                ceil = min;
            }
        }
        if (ceil <= 8) {
            while (i4 < ceil) {
                i4 <<= 1;
            }
            return i4;
        }
        return ((ceil + 7) / 8) * 8;
    }
}
