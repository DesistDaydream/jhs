package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultMetadataType;
import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes2.dex */
public final class v {

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f11653c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};
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
        for (int i4 = 0; i4 < 5 && i2 < n; i4++) {
            int j2 = x.j(aVar, iArr2, i2, x.f11661j);
            sb.append((char) ((j2 % 10) + 48));
            for (int i5 : iArr2) {
                i2 += i5;
            }
            if (j2 >= 10) {
                i3 |= 1 << (4 - i4);
            }
            if (i4 != 4) {
                i2 = aVar.m(aVar.l(i2));
            }
        }
        if (sb.length() == 5) {
            if (d(sb.toString()) == c(i3)) {
                return i2;
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int c(int i2) throws NotFoundException {
        for (int i3 = 0; i3 < 10; i3++) {
            if (i2 == f11653c[i3]) {
                return i3;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int d(CharSequence charSequence) {
        int length = charSequence.length();
        int i2 = 0;
        for (int i3 = length - 2; i3 >= 0; i3 -= 2) {
            i2 += charSequence.charAt(i3) - '0';
        }
        int i4 = i2 * 3;
        for (int i5 = length - 1; i5 >= 0; i5 -= 2) {
            i4 += charSequence.charAt(i5) - '0';
        }
        return (i4 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x003e, code lost:
        if (r5.equals("90000") == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.String e(java.lang.String r5) {
        /*
            r0 = 0
            char r1 = r5.charAt(r0)
            r2 = 48
            java.lang.String r3 = ""
            r4 = 1
            if (r1 == r2) goto L50
            r2 = 53
            if (r1 == r2) goto L4d
            r2 = 57
            if (r1 == r2) goto L15
            goto L52
        L15:
            r5.hashCode()
            r1 = -1
            int r2 = r5.hashCode()
            switch(r2) {
                case 54118329: goto L38;
                case 54395376: goto L2d;
                case 54395377: goto L22;
                default: goto L20;
            }
        L20:
            r0 = -1
            goto L41
        L22:
            java.lang.String r0 = "99991"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L2b
            goto L20
        L2b:
            r0 = 2
            goto L41
        L2d:
            java.lang.String r0 = "99990"
            boolean r0 = r5.equals(r0)
            if (r0 != 0) goto L36
            goto L20
        L36:
            r0 = 1
            goto L41
        L38:
            java.lang.String r2 = "90000"
            boolean r2 = r5.equals(r2)
            if (r2 != 0) goto L41
            goto L20
        L41:
            switch(r0) {
                case 0: goto L4b;
                case 1: goto L48;
                case 2: goto L45;
                default: goto L44;
            }
        L44:
            goto L52
        L45:
            java.lang.String r5 = "0.00"
            return r5
        L48:
            java.lang.String r5 = "Used"
            return r5
        L4b:
            r5 = 0
            return r5
        L4d:
            java.lang.String r3 = "$"
            goto L52
        L50:
            java.lang.String r3 = "£"
        L52:
            java.lang.String r5 = r5.substring(r4)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L71
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r1 = "0"
            java.lang.String r5 = r1.concat(r5)
            goto L75
        L71:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L75:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r3)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.u.v.e(java.lang.String):java.lang.String");
    }

    private static Map<ResultMetadataType, Object> f(String str) {
        String e2;
        if (str.length() == 5 && (e2 = e(str)) != null) {
            EnumMap enumMap = new EnumMap(ResultMetadataType.class);
            enumMap.put((EnumMap) ResultMetadataType.SUGGESTED_PRICE, (ResultMetadataType) e2);
            return enumMap;
        }
        return null;
    }

    public e.j.f.k b(int i2, e.j.f.q.a aVar, int[] iArr) throws NotFoundException {
        StringBuilder sb = this.b;
        sb.setLength(0);
        int a = a(aVar, iArr, sb);
        String sb2 = sb.toString();
        Map<ResultMetadataType, Object> f2 = f(sb2);
        float f3 = i2;
        e.j.f.k kVar = new e.j.f.k(sb2, null, new e.j.f.l[]{new e.j.f.l((iArr[0] + iArr[1]) / 2.0f, f3), new e.j.f.l(a, f3)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (f2 != null) {
            kVar.i(f2);
        }
        return kVar;
    }
}
