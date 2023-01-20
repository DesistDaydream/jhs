package com.google.zxing.pdf417.decoder;

import com.google.zxing.FormatException;
import e.j.f.v.c;
import java.math.BigInteger;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class DecodedBitStreamParser {
    private static final char[] A = ";<>@[\\]_`~!\r\t,:\n-.$/\"|*()?{}'".toCharArray();
    private static final char[] B = "0123456789&\r\t,:#-.$/+%*=^".toCharArray();
    private static final BigInteger[] C;
    private static final int D = 2;
    private static final int a = 900;
    private static final int b = 901;

    /* renamed from: c  reason: collision with root package name */
    private static final int f3275c = 902;

    /* renamed from: d  reason: collision with root package name */
    private static final int f3276d = 924;

    /* renamed from: e  reason: collision with root package name */
    private static final int f3277e = 925;

    /* renamed from: f  reason: collision with root package name */
    private static final int f3278f = 926;

    /* renamed from: g  reason: collision with root package name */
    private static final int f3279g = 927;

    /* renamed from: h  reason: collision with root package name */
    private static final int f3280h = 928;

    /* renamed from: i  reason: collision with root package name */
    private static final int f3281i = 923;

    /* renamed from: j  reason: collision with root package name */
    private static final int f3282j = 922;

    /* renamed from: k  reason: collision with root package name */
    private static final int f3283k = 913;

    /* renamed from: l  reason: collision with root package name */
    private static final int f3284l = 15;

    /* renamed from: m  reason: collision with root package name */
    private static final int f3285m = 0;
    private static final int n = 1;
    private static final int o = 2;
    private static final int p = 3;
    private static final int q = 4;
    private static final int r = 5;
    private static final int s = 6;
    private static final int t = 25;
    private static final int u = 27;
    private static final int v = 27;
    private static final int w = 28;
    private static final int x = 28;
    private static final int y = 29;
    private static final int z = 29;

    /* loaded from: classes2.dex */
    public enum Mode {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    /* loaded from: classes2.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Mode.values().length];
            a = iArr;
            try {
                iArr[Mode.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Mode.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Mode.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Mode.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[Mode.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Mode.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    static {
        BigInteger[] bigIntegerArr = new BigInteger[16];
        C = bigIntegerArr;
        bigIntegerArr[0] = BigInteger.ONE;
        BigInteger valueOf = BigInteger.valueOf(900L);
        bigIntegerArr[1] = valueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr2 = C;
            if (i2 >= bigIntegerArr2.length) {
                return;
            }
            bigIntegerArr2[i2] = bigIntegerArr2[i2 - 1].multiply(valueOf);
            i2++;
        }
    }

    private DecodedBitStreamParser() {
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0021 A[ADDED_TO_REGION, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static int a(int r16, int[] r17, java.nio.charset.Charset r18, int r19, java.lang.StringBuilder r20) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.a(int, int[], java.nio.charset.Charset, int, java.lang.StringBuilder):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x004e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static e.j.f.q.d b(int[] r6, java.lang.String r7) throws com.google.zxing.FormatException {
        /*
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            int r1 = r6.length
            r2 = 1
            int r1 = r1 << r2
            r0.<init>(r1)
            java.nio.charset.Charset r1 = java.nio.charset.StandardCharsets.ISO_8859_1
            r2 = r6[r2]
            e.j.f.v.c r3 = new e.j.f.v.c
            r3.<init>()
            r4 = 2
        L12:
            r5 = 0
            r5 = r6[r5]
            if (r4 >= r5) goto L6d
            r5 = 913(0x391, float:1.28E-42)
            if (r2 == r5) goto L58
            switch(r2) {
                case 900: goto L53;
                case 901: goto L4e;
                case 902: goto L49;
                default: goto L1e;
            }
        L1e:
            switch(r2) {
                case 922: goto L44;
                case 923: goto L44;
                case 924: goto L4e;
                case 925: goto L41;
                case 926: goto L3e;
                case 927: goto L2d;
                case 928: goto L28;
                default: goto L21;
            }
        L21:
            int r4 = r4 + (-1)
            int r2 = g(r6, r4, r0)
            goto L60
        L28:
            int r2 = d(r6, r4, r3)
            goto L60
        L2d:
            int r2 = r4 + 1
            r1 = r6[r4]
            com.google.zxing.common.CharacterSetECI r1 = com.google.zxing.common.CharacterSetECI.getCharacterSetECIByValue(r1)
            java.lang.String r1 = r1.name()
            java.nio.charset.Charset r1 = java.nio.charset.Charset.forName(r1)
            goto L60
        L3e:
            int r2 = r4 + 2
            goto L60
        L41:
            int r2 = r4 + 1
            goto L60
        L44:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L49:
            int r2 = f(r6, r4, r0)
            goto L60
        L4e:
            int r2 = a(r2, r6, r1, r4, r0)
            goto L60
        L53:
            int r2 = g(r6, r4, r0)
            goto L60
        L58:
            int r2 = r4 + 1
            r4 = r6[r4]
            char r4 = (char) r4
            r0.append(r4)
        L60:
            int r4 = r6.length
            if (r2 >= r4) goto L68
            int r4 = r2 + 1
            r2 = r6[r2]
            goto L12
        L68:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        L6d:
            int r6 = r0.length()
            if (r6 == 0) goto L81
            e.j.f.q.d r6 = new e.j.f.q.d
            java.lang.String r0 = r0.toString()
            r1 = 0
            r6.<init>(r1, r0, r1, r7)
            r6.o(r3)
            return r6
        L81:
            com.google.zxing.FormatException r6 = com.google.zxing.FormatException.getFormatInstance()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.pdf417.decoder.DecodedBitStreamParser.b(int[], java.lang.String):e.j.f.q.d");
    }

    private static String c(int[] iArr, int i2) throws FormatException {
        BigInteger bigInteger = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigInteger = bigInteger.add(C[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String bigInteger2 = bigInteger.toString();
        if (bigInteger2.charAt(0) == '1') {
            return bigInteger2.substring(1);
        }
        throw FormatException.getFormatInstance();
    }

    public static int d(int[] iArr, int i2, c cVar) throws FormatException {
        if (i2 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i3 = 0;
            while (i3 < 2) {
                iArr2[i3] = iArr[i2];
                i3++;
                i2++;
            }
            cVar.t(Integer.parseInt(c(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int g2 = g(iArr, i2, sb);
            cVar.n(sb.toString());
            int i4 = iArr[g2] == f3281i ? g2 + 1 : -1;
            while (g2 < iArr[0]) {
                int i5 = iArr[g2];
                if (i5 == f3282j) {
                    g2++;
                    cVar.q(true);
                } else if (i5 == f3281i) {
                    int i6 = g2 + 1;
                    switch (iArr[i6]) {
                        case 0:
                            StringBuilder sb2 = new StringBuilder();
                            g2 = g(iArr, i6 + 1, sb2);
                            cVar.o(sb2.toString());
                            continue;
                        case 1:
                            StringBuilder sb3 = new StringBuilder();
                            g2 = f(iArr, i6 + 1, sb3);
                            cVar.s(Integer.parseInt(sb3.toString()));
                            continue;
                        case 2:
                            StringBuilder sb4 = new StringBuilder();
                            g2 = f(iArr, i6 + 1, sb4);
                            cVar.v(Long.parseLong(sb4.toString()));
                            continue;
                        case 3:
                            StringBuilder sb5 = new StringBuilder();
                            g2 = g(iArr, i6 + 1, sb5);
                            cVar.u(sb5.toString());
                            continue;
                        case 4:
                            StringBuilder sb6 = new StringBuilder();
                            g2 = g(iArr, i6 + 1, sb6);
                            cVar.l(sb6.toString());
                            continue;
                        case 5:
                            StringBuilder sb7 = new StringBuilder();
                            g2 = f(iArr, i6 + 1, sb7);
                            cVar.p(Long.parseLong(sb7.toString()));
                            continue;
                        case 6:
                            StringBuilder sb8 = new StringBuilder();
                            g2 = f(iArr, i6 + 1, sb8);
                            cVar.m(Integer.parseInt(sb8.toString()));
                            continue;
                        default:
                            throw FormatException.getFormatInstance();
                    }
                } else {
                    throw FormatException.getFormatInstance();
                }
            }
            if (i4 != -1) {
                int i7 = g2 - i4;
                if (cVar.k()) {
                    i7--;
                }
                cVar.r(Arrays.copyOfRange(iArr, i4, i7 + i4));
            }
            return g2;
        }
        throw FormatException.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void e(int[] iArr, int[] iArr2, int i2, StringBuilder sb) {
        Mode mode;
        int i3;
        Mode mode2 = Mode.ALPHA;
        Mode mode3 = mode2;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4];
            char c2 = ' ';
            switch (a.a[mode2.ordinal()]) {
                case 1:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 != f3283k) {
                            switch (i5) {
                                case 27:
                                    mode2 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode2 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    Mode mode4 = mode;
                                    mode3 = mode2;
                                    mode2 = mode4;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 2:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                        break;
                    } else {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 != f3283k) {
                            switch (i5) {
                                case 27:
                                    mode = Mode.ALPHA_SHIFT;
                                    c2 = 0;
                                    Mode mode42 = mode;
                                    mode3 = mode2;
                                    mode2 = mode42;
                                    break;
                                case 28:
                                    mode2 = Mode.MIXED;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    Mode mode422 = mode;
                                    mode3 = mode2;
                                    mode2 = mode422;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 3:
                    if (i5 < 25) {
                        c2 = B[i5];
                        break;
                    } else {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 != f3283k) {
                            switch (i5) {
                                case 25:
                                    mode2 = Mode.PUNCT;
                                    break;
                                case 27:
                                    mode2 = Mode.LOWER;
                                    break;
                                case 28:
                                    mode2 = Mode.ALPHA;
                                    break;
                                case 29:
                                    mode = Mode.PUNCT_SHIFT;
                                    c2 = 0;
                                    Mode mode4222 = mode;
                                    mode3 = mode2;
                                    mode2 = mode4222;
                                    break;
                            }
                        } else {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                    break;
                case 4:
                    if (i5 < 29) {
                        c2 = A[i5];
                        break;
                    } else {
                        if (i5 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 == f3283k) {
                            sb.append((char) iArr2[i4]);
                        }
                        c2 = 0;
                        break;
                    }
                case 5:
                    if (i5 < 26) {
                        c2 = (char) (i5 + 65);
                    } else if (i5 != 26) {
                        if (i5 == 900) {
                            mode2 = Mode.ALPHA;
                            c2 = 0;
                            break;
                        }
                        mode2 = mode3;
                        c2 = 0;
                    }
                    mode2 = mode3;
                    break;
                case 6:
                    if (i5 < 29) {
                        c2 = A[i5];
                        mode2 = mode3;
                        break;
                    } else {
                        if (i5 == 29) {
                            mode2 = Mode.ALPHA;
                        } else if (i5 != 900) {
                            if (i5 == f3283k) {
                                sb.append((char) iArr2[i4]);
                            }
                            mode2 = mode3;
                        } else {
                            mode2 = Mode.ALPHA;
                        }
                        c2 = 0;
                        break;
                    }
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    private static int f(int[] iArr, int i2, StringBuilder sb) throws FormatException {
        int[] iArr2 = new int[15];
        boolean z2 = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z2) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z2 = true;
            }
            if (i5 < 900) {
                iArr2[i3] = i5;
                i3++;
            } else {
                if (i5 != 900 && i5 != 901 && i5 != 928) {
                    switch (i5) {
                    }
                }
                i4--;
                z2 = true;
            }
            if ((i3 % 15 == 0 || i5 == 902 || z2) && i3 > 0) {
                sb.append(c(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    private static int g(int[] iArr, int i2, StringBuilder sb) {
        int[] iArr2 = new int[(iArr[0] - i2) << 1];
        int[] iArr3 = new int[(iArr[0] - i2) << 1];
        boolean z2 = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z2) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i5 < 900) {
                iArr2[i3] = i5 / 30;
                iArr2[i3 + 1] = i5 % 30;
                i3 += 2;
            } else if (i5 != f3283k) {
                if (i5 != 928) {
                    switch (i5) {
                        case 900:
                            iArr2[i3] = 900;
                            i3++;
                            break;
                        case 901:
                        case 902:
                            break;
                        default:
                            switch (i5) {
                            }
                    }
                }
                i2 = i4 - 1;
                z2 = true;
            } else {
                iArr2[i3] = f3283k;
                i2 = i4 + 1;
                iArr3[i3] = iArr[i4];
                i3++;
            }
            i2 = i4;
        }
        e(iArr2, iArr3, i3, sb);
        return i2;
    }
}
