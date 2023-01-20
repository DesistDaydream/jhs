package e.l.r;

import android.graphics.Bitmap;
import androidx.core.view.ViewCompat;

/* loaded from: classes2.dex */
public final class h0 {
    @k.e.a.d
    public static final h0 a = new h0();

    private h0() {
    }

    @k.e.a.d
    public final Bitmap a(@k.e.a.d Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int[] iArr = new int[width * height];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        if (height > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (width > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        int i6 = (width * i2) + i4;
                        if (iArr[i6] != 0) {
                            int i7 = iArr[i6];
                            int i8 = (int) ((((16711680 & i7) >> 16) * 0.44d) + (((65280 & i7) >> 8) * 0.45d) + ((i7 & 255) * 0.11d));
                            iArr[i6] = i8 | (i8 << 16) | ViewCompat.MEASURED_STATE_MASK | (i8 << 8);
                        }
                        if (i5 >= width) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= height) {
                    break;
                }
                i2 = i3;
            }
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_4444);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return createBitmap;
    }

    @k.e.a.d
    public final Bitmap b(@k.e.a.d Bitmap bitmap) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
        if (width > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (height > 0) {
                    int i4 = 0;
                    while (true) {
                        int i5 = i4 + 1;
                        int pixel = copy.getPixel(i2, i4);
                        int i6 = (-16777216) & pixel;
                        int i7 = ((int) (((((double) ((float) ((16711680 & pixel) >> 16))) * 0.3d) + (((double) ((float) ((65280 & pixel) >> 8))) * 0.59d)) + (((double) ((float) (pixel & 255))) * 0.11d))) <= 95 ? 0 : 255;
                        copy.setPixel(i2, i4, (i7 << 16) | i6 | (i7 << 8) | i7);
                        if (i5 >= height) {
                            break;
                        }
                        i4 = i5;
                    }
                }
                if (i3 >= width) {
                    break;
                }
                i2 = i3;
            }
        }
        return copy;
    }
}
