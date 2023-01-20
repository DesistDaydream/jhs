package e.l.r;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Hashtable;

/* loaded from: classes2.dex */
public final class t0 {
    @k.e.a.d
    public static final t0 a = new t0();

    private t0() {
    }

    @k.e.a.e
    public final Bitmap a(@k.e.a.e String str, int i2, int i3, @k.e.a.e String str2, @k.e.a.e String str3, @k.e.a.e String str4, int i4, int i5) {
        if (!TextUtils.isEmpty(str) && i2 >= 0 && i3 >= 0) {
            try {
                Hashtable hashtable = new Hashtable();
                if (!TextUtils.isEmpty(str2)) {
                    hashtable.put(EncodeHintType.CHARACTER_SET, str2);
                }
                if (!TextUtils.isEmpty(str3)) {
                    hashtable.put(EncodeHintType.ERROR_CORRECTION, str3);
                }
                if (!TextUtils.isEmpty(str4)) {
                    hashtable.put(EncodeHintType.MARGIN, str4);
                }
                e.j.f.q.b a2 = new e.j.f.w.b().a(str, BarcodeFormat.QR_CODE, i2, i3, hashtable);
                int[] iArr = new int[i2 * i3];
                if (i3 > 0) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6 + 1;
                        if (i2 > 0) {
                            int i8 = 0;
                            while (true) {
                                int i9 = i8 + 1;
                                if (a2.f(i8, i6)) {
                                    iArr[(i6 * i2) + i8] = i4;
                                } else {
                                    iArr[(i6 * i2) + i8] = i5;
                                }
                                if (i9 >= i2) {
                                    break;
                                }
                                i8 = i9;
                            }
                        }
                        if (i7 >= i3) {
                            break;
                        }
                        i6 = i7;
                    }
                }
                Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                createBitmap.setPixels(iArr, 0, i2, 0, 0, i2, i3);
                return createBitmap;
            } catch (WriterException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return null;
    }
}
