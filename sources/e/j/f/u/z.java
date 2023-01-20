package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;

/* loaded from: classes2.dex */
public final class z extends x {

    /* renamed from: l  reason: collision with root package name */
    private static final int[] f11663l = {1, 1, 1, 1, 1, 1};

    /* renamed from: m  reason: collision with root package name */
    public static final int[][] f11664m = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: k  reason: collision with root package name */
    private final int[] f11665k = new int[4];

    public static String s(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    private static void t(StringBuilder sb, int i2) throws NotFoundException {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == f11664m[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // e.j.f.u.x
    public boolean h(String str) throws FormatException {
        return super.h(s(str));
    }

    @Override // e.j.f.u.x
    public int[] k(e.j.f.q.a aVar, int i2) throws NotFoundException {
        return x.n(aVar, i2, true, f11663l);
    }

    @Override // e.j.f.u.x
    public int l(e.j.f.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException {
        int[] iArr2 = this.f11665k;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int n = aVar.n();
        int i2 = iArr[1];
        int i3 = 0;
        for (int i4 = 0; i4 < 6 && i2 < n; i4++) {
            int j2 = x.j(aVar, iArr2, i2, x.f11661j);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (5 - i4);
            }
        }
        t(sb, i3);
        return i2;
    }

    @Override // e.j.f.u.x
    public BarcodeFormat q() {
        return BarcodeFormat.UPC_E;
    }
}
