package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.ReaderException;
import com.google.zxing.ResultMetadataType;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public abstract class x extends q {

    /* renamed from: d  reason: collision with root package name */
    private static final float f11655d = 0.48f;

    /* renamed from: e  reason: collision with root package name */
    private static final float f11656e = 0.7f;

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f11657f = {1, 1, 1};

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f11658g = {1, 1, 1, 1, 1};

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f11659h = {1, 1, 1, 1, 1, 1};

    /* renamed from: i  reason: collision with root package name */
    public static final int[][] f11660i;

    /* renamed from: j  reason: collision with root package name */
    public static final int[][] f11661j;
    private final StringBuilder a = new StringBuilder(20);
    private final w b = new w();

    /* renamed from: c  reason: collision with root package name */
    private final l f11662c = new l();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f11660i = iArr;
        int[][] iArr2 = new int[20];
        f11661j = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i2 = 10; i2 < 20; i2++) {
            int[] iArr3 = f11660i[i2 - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i3 = 0; i3 < iArr3.length; i3++) {
                iArr4[i3] = iArr3[(iArr3.length - i3) - 1];
            }
            f11661j[i2] = iArr4;
        }
    }

    public static boolean i(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i2 = length - 1;
        return r(charSequence.subSequence(0, i2)) == Character.digit(charSequence.charAt(i2), 10);
    }

    public static int j(e.j.f.q.a aVar, int[] iArr, int i2, int[][] iArr2) throws NotFoundException {
        q.f(aVar, i2, iArr);
        int length = iArr2.length;
        float f2 = f11655d;
        int i3 = -1;
        for (int i4 = 0; i4 < length; i4++) {
            float e2 = q.e(iArr, iArr2[i4], f11656e);
            if (e2 < f2) {
                i3 = i4;
                f2 = e2;
            }
        }
        if (i3 >= 0) {
            return i3;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] n(e.j.f.q.a aVar, int i2, boolean z, int[] iArr) throws NotFoundException {
        return o(aVar, i2, z, iArr, new int[iArr.length]);
    }

    private static int[] o(e.j.f.q.a aVar, int i2, boolean z, int[] iArr, int[] iArr2) throws NotFoundException {
        int n = aVar.n();
        int m2 = z ? aVar.m(i2) : aVar.l(i2);
        int length = iArr.length;
        boolean z2 = z;
        int i3 = 0;
        int i4 = m2;
        while (m2 < n) {
            if (aVar.j(m2) != z2) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (q.e(iArr2, iArr, f11656e) < f11655d) {
                    return new int[]{i4, m2};
                } else {
                    i4 += iArr2[0] + iArr2[1];
                    int i5 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i5);
                    iArr2[i5] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z2 = !z2;
            }
            m2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public static int[] p(e.j.f.q.a aVar) throws NotFoundException {
        int[] iArr = new int[f11657f.length];
        int[] iArr2 = null;
        boolean z = false;
        int i2 = 0;
        while (!z) {
            int[] iArr3 = f11657f;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = o(aVar, i2, false, iArr3, iArr);
            int i3 = iArr2[0];
            int i4 = iArr2[1];
            int i5 = i3 - (i4 - i3);
            if (i5 >= 0) {
                z = aVar.p(i5, i3, false);
            }
            i2 = i4;
        }
        return iArr2;
    }

    public static int r(CharSequence charSequence) throws FormatException {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 1; i3 >= 0; i3 -= 2) {
            int charAt = charSequence.charAt(i3) - '0';
            if (charAt < 0 || charAt > 9) {
                throw FormatException.getFormatInstance();
            }
            i2 += charAt;
        }
        int i4 = i2 * 3;
        for (int i5 = length - 2; i5 >= 0; i5 -= 2) {
            int charAt2 = charSequence.charAt(i5) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw FormatException.getFormatInstance();
            }
            i4 += charAt2;
        }
        return (1000 - i4) % 10;
    }

    @Override // e.j.f.u.q
    public e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        return m(i2, aVar, p(aVar), map);
    }

    public boolean h(String str) throws FormatException {
        return i(str);
    }

    public int[] k(e.j.f.q.a aVar, int i2) throws NotFoundException {
        return n(aVar, i2, false, f11657f);
    }

    public abstract int l(e.j.f.q.a aVar, int[] iArr, StringBuilder sb) throws NotFoundException;

    public e.j.f.k m(int i2, e.j.f.q.a aVar, int[] iArr, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int i3;
        String c2;
        e.j.f.m mVar = map == null ? null : (e.j.f.m) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        boolean z = true;
        if (mVar != null) {
            mVar.a(new e.j.f.l((iArr[0] + iArr[1]) / 2.0f, i2));
        }
        StringBuilder sb = this.a;
        sb.setLength(0);
        int l2 = l(aVar, iArr, sb);
        if (mVar != null) {
            mVar.a(new e.j.f.l(l2, i2));
        }
        int[] k2 = k(aVar, l2);
        if (mVar != null) {
            mVar.a(new e.j.f.l((k2[0] + k2[1]) / 2.0f, i2));
        }
        int i4 = k2[1];
        int i5 = (i4 - k2[0]) + i4;
        if (i5 < aVar.n() && aVar.p(i4, i5, false)) {
            String sb2 = sb.toString();
            if (sb2.length() >= 8) {
                if (h(sb2)) {
                    BarcodeFormat q = q();
                    float f2 = i2;
                    e.j.f.k kVar = new e.j.f.k(sb2, null, new e.j.f.l[]{new e.j.f.l((iArr[1] + iArr[0]) / 2.0f, f2), new e.j.f.l((k2[1] + k2[0]) / 2.0f, f2)}, q);
                    try {
                        e.j.f.k a = this.b.a(i2, aVar, k2[1]);
                        kVar.j(ResultMetadataType.UPC_EAN_EXTENSION, a.g());
                        kVar.i(a.e());
                        kVar.a(a.f());
                        i3 = a.g().length();
                    } catch (ReaderException unused) {
                        i3 = 0;
                    }
                    int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
                    if (iArr2 != null) {
                        int length = iArr2.length;
                        int i6 = 0;
                        while (true) {
                            if (i6 >= length) {
                                z = false;
                                break;
                            } else if (i3 == iArr2[i6]) {
                                break;
                            } else {
                                i6++;
                            }
                        }
                        if (!z) {
                            throw NotFoundException.getNotFoundInstance();
                        }
                    }
                    if ((q == BarcodeFormat.EAN_13 || q == BarcodeFormat.UPC_A) && (c2 = this.f11662c.c(sb2)) != null) {
                        kVar.j(ResultMetadataType.POSSIBLE_COUNTRY, c2);
                    }
                    return kVar;
                }
                throw ChecksumException.getChecksumInstance();
            }
            throw FormatException.getFormatInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public abstract BarcodeFormat q();
}
