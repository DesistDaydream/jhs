package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class r implements e.j.f.n {
    public static int c(boolean[] zArr, int i2, int[] iArr, boolean z) {
        int i3 = 0;
        for (int i4 : iArr) {
            int i5 = 0;
            while (i5 < i4) {
                zArr[i2] = z;
                i5++;
                i2++;
            }
            i3 += i4;
            z = !z;
        }
        return i3;
    }

    private static e.j.f.q.b f(boolean[] zArr, int i2, int i3, int i4) {
        int length = zArr.length;
        int i5 = i4 + length;
        int max = Math.max(i2, i5);
        int max2 = Math.max(1, i3);
        int i6 = max / i5;
        int i7 = (max - (length * i6)) / 2;
        e.j.f.q.b bVar = new e.j.f.q.b(max, max2);
        int i8 = 0;
        while (i8 < length) {
            if (zArr[i8]) {
                bVar.s(i7, 0, i6, max2);
            }
            i8++;
            i7 += i6;
        }
        return bVar;
    }

    @Override // e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i2 >= 0 && i3 >= 0) {
            int e2 = e();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    e2 = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return f(d(str), i2, i3, e2);
        }
        throw new IllegalArgumentException("Negative size is not allowed. Input: " + i2 + 'x' + i3);
    }

    @Override // e.j.f.n
    public final e.j.f.q.b b(String str, BarcodeFormat barcodeFormat, int i2, int i3) throws WriterException {
        return a(str, barcodeFormat, i2, i3, null);
    }

    public abstract boolean[] d(String str);

    public int e() {
        return 10;
    }
}
