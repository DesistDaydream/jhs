package e.j.f.w.e;

import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import e.j.f.w.c.g;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class c {
    private static final int[] a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};
    public static final String b = "ISO-8859-1";

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private c() {
    }

    public static void a(String str, e.j.f.q.a aVar, String str2) throws WriterException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                aVar.c(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    public static void b(CharSequence charSequence, e.j.f.q.a aVar) throws WriterException {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int r = r(charSequence.charAt(i2));
            if (r == -1) {
                throw new WriterException();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int r2 = r(charSequence.charAt(i3));
                if (r2 != -1) {
                    aVar.c((r * 45) + r2, 11);
                    i2 += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                aVar.c(r, 6);
                i2 = i3;
            }
        }
    }

    public static void c(String str, Mode mode, e.j.f.q.a aVar, String str2) throws WriterException {
        int i2 = a.a[mode.ordinal()];
        if (i2 == 1) {
            h(str, aVar);
        } else if (i2 == 2) {
            b(str, aVar);
        } else if (i2 == 3) {
            a(str, aVar, str2);
        } else if (i2 == 4) {
            e(str, aVar);
        } else {
            throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
        }
    }

    private static void d(CharacterSetECI characterSetECI, e.j.f.q.a aVar) {
        aVar.c(Mode.ECI.getBits(), 4);
        aVar.c(characterSetECI.getValue(), 8);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0035 A[LOOP:0: B:32:0x0008->B:45:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void e(java.lang.String r6, e.j.f.q.a r7) throws com.google.zxing.WriterException {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.c(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            com.google.zxing.WriterException r6 = new com.google.zxing.WriterException
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.w.e.c.e(java.lang.String, e.j.f.q.a):void");
    }

    public static void f(int i2, g gVar, Mode mode, e.j.f.q.a aVar) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(gVar);
        int i3 = 1 << characterCountBits;
        if (i2 < i3) {
            aVar.c(i2, characterCountBits);
            return;
        }
        throw new WriterException(i2 + " is bigger than " + (i3 - 1));
    }

    public static void g(Mode mode, e.j.f.q.a aVar) {
        aVar.c(mode.getBits(), 4);
    }

    public static void h(CharSequence charSequence, e.j.f.q.a aVar) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                aVar.c((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    aVar.c((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    aVar.c(charAt, 4);
                }
            }
        }
    }

    private static int i(Mode mode, e.j.f.q.a aVar, e.j.f.q.a aVar2, g gVar) {
        return aVar.n() + mode.getCharacterCountBits(gVar) + aVar2.n();
    }

    private static int j(b bVar) {
        return d.a(bVar) + d.c(bVar) + d.d(bVar) + d.e(bVar);
    }

    private static int k(e.j.f.q.a aVar, ErrorCorrectionLevel errorCorrectionLevel, g gVar, b bVar) throws WriterException {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            e.a(aVar, errorCorrectionLevel, gVar, i4, bVar);
            int j2 = j(bVar);
            if (j2 < i2) {
                i3 = i4;
                i2 = j2;
            }
        }
        return i3;
    }

    public static Mode l(String str) {
        return m(str, null);
    }

    private static Mode m(String str, String str2) {
        if ("Shift_JIS".equals(str2) && u(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else if (r(charAt) == -1) {
                return Mode.BYTE;
            } else {
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        if (z2) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static g n(int i2, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i3 = 1; i3 <= 40; i3++) {
            g i4 = g.i(i3);
            if (x(i2, i4, errorCorrectionLevel)) {
                return i4;
            }
        }
        throw new WriterException("Data too big");
    }

    public static f o(String str, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        return p(str, errorCorrectionLevel, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:80:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static e.j.f.w.e.f p(java.lang.String r7, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel r8, java.util.Map<com.google.zxing.EncodeHintType, ?> r9) throws com.google.zxing.WriterException {
        /*
            r0 = 1
            r1 = 0
            if (r9 == 0) goto Le
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.CHARACTER_SET
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto Le
            r2 = 1
            goto Lf
        Le:
            r2 = 0
        Lf:
            if (r2 == 0) goto L1c
            com.google.zxing.EncodeHintType r3 = com.google.zxing.EncodeHintType.CHARACTER_SET
            java.lang.Object r3 = r9.get(r3)
            java.lang.String r3 = r3.toString()
            goto L1e
        L1c:
            java.lang.String r3 = "ISO-8859-1"
        L1e:
            com.google.zxing.qrcode.decoder.Mode r4 = m(r7, r3)
            e.j.f.q.a r5 = new e.j.f.q.a
            r5.<init>()
            com.google.zxing.qrcode.decoder.Mode r6 = com.google.zxing.qrcode.decoder.Mode.BYTE
            if (r4 != r6) goto L36
            if (r2 == 0) goto L36
            com.google.zxing.common.CharacterSetECI r2 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByName(r3)
            if (r2 == 0) goto L36
            d(r2, r5)
        L36:
            if (r9 == 0) goto L41
            com.google.zxing.EncodeHintType r2 = com.google.zxing.EncodeHintType.GS1_FORMAT
            boolean r2 = r9.containsKey(r2)
            if (r2 == 0) goto L41
            goto L42
        L41:
            r0 = 0
        L42:
            if (r0 == 0) goto L5d
            com.google.zxing.EncodeHintType r0 = com.google.zxing.EncodeHintType.GS1_FORMAT
            java.lang.Object r0 = r9.get(r0)
            java.lang.String r0 = r0.toString()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L5d
            com.google.zxing.qrcode.decoder.Mode r0 = com.google.zxing.qrcode.decoder.Mode.FNC1_FIRST_POSITION
            g(r0, r5)
        L5d:
            g(r4, r5)
            e.j.f.q.a r0 = new e.j.f.q.a
            r0.<init>()
            c(r7, r4, r0, r3)
            if (r9 == 0) goto L95
            com.google.zxing.EncodeHintType r1 = com.google.zxing.EncodeHintType.QR_VERSION
            boolean r2 = r9.containsKey(r1)
            if (r2 == 0) goto L95
            java.lang.Object r9 = r9.get(r1)
            java.lang.String r9 = r9.toString()
            int r9 = java.lang.Integer.parseInt(r9)
            e.j.f.w.c.g r9 = e.j.f.w.c.g.i(r9)
            int r1 = i(r4, r5, r0, r9)
            boolean r1 = x(r1, r9, r8)
            if (r1 == 0) goto L8d
            goto L99
        L8d:
            com.google.zxing.WriterException r7 = new com.google.zxing.WriterException
            java.lang.String r8 = "Data too big for requested version"
            r7.<init>(r8)
            throw r7
        L95:
            e.j.f.w.c.g r9 = v(r8, r4, r5, r0)
        L99:
            e.j.f.q.a r1 = new e.j.f.q.a
            r1.<init>()
            r1.b(r5)
            if (r4 != r6) goto La8
            int r7 = r0.o()
            goto Lac
        La8:
            int r7 = r7.length()
        Lac:
            f(r7, r9, r4, r1)
            r1.b(r0)
            e.j.f.w.c.g$b r7 = r9.f(r8)
            int r0 = r9.h()
            int r2 = r7.d()
            int r0 = r0 - r2
            w(r0, r1)
            int r2 = r9.h()
            int r7 = r7.c()
            e.j.f.q.a r7 = t(r1, r2, r0, r7)
            e.j.f.w.e.f r0 = new e.j.f.w.e.f
            r0.<init>()
            r0.g(r8)
            r0.j(r4)
            r0.k(r9)
            int r1 = r9.e()
            e.j.f.w.e.b r2 = new e.j.f.w.e.b
            r2.<init>(r1, r1)
            int r1 = k(r7, r8, r9, r2)
            r0.h(r1)
            e.j.f.w.e.e.a(r7, r8, r9, r1, r2)
            r0.i(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.f.w.e.c.p(java.lang.String, com.google.zxing.qrcode.decoder.ErrorCorrectionLevel, java.util.Map):e.j.f.w.e.f");
    }

    public static byte[] q(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & 255;
        }
        new e.j.f.q.m.d(e.j.f.q.m.a.f11502l).b(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    public static int r(int i2) {
        int[] iArr = a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public static void s(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws WriterException {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i4 != i7 + i6) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            }
            iArr[0] = i11;
            iArr2[0] = i13;
            return;
        }
        throw new WriterException("Block ID too large");
    }

    public static e.j.f.q.a t(e.j.f.q.a aVar, int i2, int i3, int i4) throws WriterException {
        if (aVar.o() == i3) {
            ArrayList<e.j.f.w.e.a> arrayList = new ArrayList(i4);
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                s(i2, i3, i4, i8, iArr, iArr2);
                int i9 = iArr[0];
                byte[] bArr = new byte[i9];
                aVar.v(i5 << 3, bArr, 0, i9);
                byte[] q = q(bArr, iArr2[0]);
                arrayList.add(new e.j.f.w.e.a(bArr, q));
                i6 = Math.max(i6, i9);
                i7 = Math.max(i7, q.length);
                i5 += iArr[0];
            }
            if (i3 == i5) {
                e.j.f.q.a aVar2 = new e.j.f.q.a();
                for (int i10 = 0; i10 < i6; i10++) {
                    for (e.j.f.w.e.a aVar3 : arrayList) {
                        byte[] a2 = aVar3.a();
                        if (i10 < a2.length) {
                            aVar2.c(a2[i10], 8);
                        }
                    }
                }
                for (int i11 = 0; i11 < i7; i11++) {
                    for (e.j.f.w.e.a aVar4 : arrayList) {
                        byte[] b2 = aVar4.b();
                        if (i11 < b2.length) {
                            aVar2.c(b2[i11], 8);
                        }
                    }
                }
                if (i2 == aVar2.o()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i2 + " and " + aVar2.o() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    private static boolean u(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & 255;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static g v(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, e.j.f.q.a aVar, e.j.f.q.a aVar2) throws WriterException {
        return n(i(mode, aVar, aVar2, n(i(mode, aVar, aVar2, g.i(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    public static void w(int i2, e.j.f.q.a aVar) throws WriterException {
        int i3 = i2 << 3;
        if (aVar.n() <= i3) {
            for (int i4 = 0; i4 < 4 && aVar.n() < i3; i4++) {
                aVar.a(false);
            }
            int n = aVar.n() & 7;
            if (n > 0) {
                while (n < 8) {
                    aVar.a(false);
                    n++;
                }
            }
            int o = i2 - aVar.o();
            for (int i5 = 0; i5 < o; i5++) {
                aVar.c((i5 & 1) == 0 ? 236 : 17, 8);
            }
            if (aVar.n() != i3) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.n() + " > " + i3);
    }

    private static boolean x(int i2, g gVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return gVar.h() - gVar.f(errorCorrectionLevel).d() >= (i2 + 7) / 8;
    }
}
