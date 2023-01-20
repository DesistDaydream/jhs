package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class u {
    private final int[] a = new int[4];
    private final StringBuilder b = new StringBuilder();

    private int a(e.j.f.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int n = aVar.n();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 2 && i2 < n; i4++) {
            int j2 = x.j(aVar, iArr2, i2, x.f11661j);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (1 - i4);
            }
            if (i4 != 1) {
                i2 = aVar.m(aVar.l(i2));
            }
        }
        if (sb.length() == 2) {
            if (Integer.parseInt(sb.toString()) % 4 == i3) {
                return i2;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static Map<ResultMetadataType, Object> c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(ResultMetadataType.class);
        enumMap.put((EnumMap) ResultMetadataType.ISSUE_NUMBER, (ResultMetadataType) Integer.valueOf(str));
        return enumMap;
    }

    public e.j.f.k b(int i2, e.j.f.q.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int a = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> c2 = c(sb2);
        float f2 = i2;
        e.j.f.k kVar = new e.j.f.k(sb2, null, new e.j.f.l[]{new e.j.f.l((iArr[0] + iArr[1]) / 2.0f, f2), new e.j.f.l(a, f2)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (c2 != null) {
            kVar.i(c2);
        }
        return kVar;
    }
}
