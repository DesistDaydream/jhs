package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public final class n extends r {

    /* renamed from: c  reason: collision with root package name */
    private static final int f11649c = 3;

    /* renamed from: d  reason: collision with root package name */
    private static final int f11650d = 1;
    private static final int[] a = {1, 1, 1, 1};
    private static final int[] b = {3, 1, 1};

    /* renamed from: e  reason: collision with root package name */
    private static final int[][] f11651e = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override // e.j.f.u.r, e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.ITF) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode ITF, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // e.j.f.u.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length % 2 == 0) {
            if (length <= 80) {
                boolean[] zArr = new boolean[(length * 9) + 9];
                int c2 = r.c(zArr, 0, a, true);
                for (int i2 = 0; i2 < length; i2 += 2) {
                    int digit = Character.digit(str.charAt(i2), 10);
                    int digit2 = Character.digit(str.charAt(i2 + 1), 10);
                    int[] iArr = new int[10];
                    for (int i3 = 0; i3 < 5; i3++) {
                        int i4 = i3 * 2;
                        int[][] iArr2 = f11651e;
                        iArr[i4] = iArr2[digit][i3];
                        iArr[i4 + 1] = iArr2[digit2][i3];
                    }
                    c2 += r.c(zArr, c2, iArr, true);
                }
                r.c(zArr, c2, b, true);
                return zArr;
            }
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        throw new IllegalArgumentException("The length of the input should be even");
    }
}
