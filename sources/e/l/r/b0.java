package e.l.r;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import androidx.exifinterface.media.ExifInterface;
import com.vector.FileSuffix;
import com.vector.filecompatnew.BitmapKt;
import java.io.File;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class b0 {
    @k.e.a.d
    public static final b0 a = new b0();

    private b0() {
    }

    private final int a(int i2, int i3) {
        int i4;
        if (i2 % 2 == 1) {
            i2++;
        }
        if (i3 % 2 == 1) {
            i3++;
        }
        int max = Math.max(i2, i3);
        float min = Math.min(i2, i3) / max;
        if (min > 1.0f || min <= 0.5625d) {
            double d2 = min;
            if (d2 <= 0.5625d && d2 > 0.5d) {
                i4 = max / 1280;
                if (i4 == 0) {
                    return 1;
                }
            } else {
                return (int) Math.ceil(max / (1280.0d / d2));
            }
        } else if (max < 1664) {
            return 1;
        } else {
            if (max < 4990) {
                return 2;
            }
            boolean z = false;
            if (4991 <= max && max <= 10239) {
                z = true;
            }
            if (z) {
                return 4;
            }
            i4 = max / 1280;
            if (i4 == 0) {
                return 1;
            }
        }
        return i4;
    }

    private final String b(String str, int i2, String str2) {
        if (!e.t.n.a.a.d(str2, e.t.a.b()) || i2 == 100) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            Boolean bool = null;
            e.t.l.w.b(str, options, null, 2, null);
            options.inSampleSize = a(options.outWidth, options.outHeight);
            options.inJustDecodeBounds = false;
            Bitmap b = e.t.l.w.b(str, options, null, 2, null);
            if (b != null) {
                try {
                    bool = Boolean.valueOf(BitmapKt.y(b, new File(str2), Bitmap.CompressFormat.JPEG, i2));
                } catch (Exception unused) {
                    if (b != null) {
                        b.recycle();
                    }
                    return str;
                } catch (Throwable unused2) {
                    if (b != null) {
                        b.recycle();
                    }
                    return "";
                }
            }
            if (h.k2.v.f0.g(bool, Boolean.FALSE)) {
                str2 = "";
            }
            if (b != null) {
                b.recycle();
            }
            return str2;
        }
        return str2;
    }

    public static /* synthetic */ String d(b0 b0Var, String str, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 60;
        }
        return b0Var.c(str, i2);
    }

    private final int e(String str) {
        try {
            int attributeInt = e.t.m.a.a(str).getAttributeInt(ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private final String f(int i2, String str) {
        if (i2 != 0) {
            Bitmap b = e.t.l.w.b(str, null, null, 3, null);
            if (b == null) {
                return "";
            }
            int width = b.getWidth();
            int height = b.getHeight();
            Matrix matrix = new Matrix();
            matrix.postRotate(i2);
            String str2 = ((Object) w.f14319e.h()) + e.t.u.u.a.d(str) + FileSuffix.JPEG.getText();
            Bitmap createBitmap = Bitmap.createBitmap(b, 0, 0, width, height, matrix, true);
            b.recycle();
            boolean y = BitmapKt.y(createBitmap, new File(str2), Bitmap.CompressFormat.JPEG, 100);
            createBitmap.recycle();
            return y ? str2 : str;
        }
        return str;
    }

    @k.e.a.d
    public final String c(@k.e.a.d String str, int i2) {
        int e2 = e(str);
        String b = b(str, i2, ((Object) w.f14319e.h()) + e.t.u.u.a.d(str) + FileSuffix.JPEG.getText());
        return e2 != 0 ? f(e2, b) : b;
    }
}
