package e.j.f.r.d;

import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class j {
    private static final char a = 129;
    public static final char b = 230;

    /* renamed from: c  reason: collision with root package name */
    public static final char f11528c = 231;

    /* renamed from: d  reason: collision with root package name */
    public static final char f11529d = 235;

    /* renamed from: e  reason: collision with root package name */
    private static final char f11530e = 236;

    /* renamed from: f  reason: collision with root package name */
    private static final char f11531f = 237;

    /* renamed from: g  reason: collision with root package name */
    public static final char f11532g = 238;

    /* renamed from: h  reason: collision with root package name */
    public static final char f11533h = 239;

    /* renamed from: i  reason: collision with root package name */
    public static final char f11534i = 240;

    /* renamed from: j  reason: collision with root package name */
    public static final char f11535j = 254;

    /* renamed from: k  reason: collision with root package name */
    public static final char f11536k = 254;

    /* renamed from: l  reason: collision with root package name */
    private static final String f11537l = "[)>\u001e05\u001d";

    /* renamed from: m  reason: collision with root package name */
    private static final String f11538m = "[)>\u001e06\u001d";
    private static final String n = "\u001e\u0004";
    public static final int o = 0;
    public static final int p = 1;
    public static final int q = 2;
    public static final int r = 3;
    public static final int s = 4;
    public static final int t = 5;

    private j() {
    }

    public static int a(CharSequence charSequence, int i2) {
        int length = charSequence.length();
        int i3 = 0;
        if (i2 < length) {
            char charAt = charSequence.charAt(i2);
            while (g(charAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    charAt = charSequence.charAt(i2);
                }
            }
        }
        return i3;
    }

    public static String b(String str) {
        return c(str, SymbolShapeHint.FORCE_NONE, null, null);
    }

    public static String c(String str, SymbolShapeHint symbolShapeHint, e.j.f.c cVar, e.j.f.c cVar2) {
        int i2 = 0;
        g[] gVarArr = {new a(), new c(), new l(), new m(), new f(), new b()};
        h hVar = new h(str);
        hVar.o(symbolShapeHint);
        hVar.m(cVar, cVar2);
        if (str.startsWith(f11537l) && str.endsWith(n)) {
            hVar.s(f11530e);
            hVar.n(2);
            hVar.f11521f += 7;
        } else if (str.startsWith(f11538m) && str.endsWith(n)) {
            hVar.s(f11531f);
            hVar.n(2);
            hVar.f11521f += 7;
        }
        while (hVar.j()) {
            gVarArr[i2].a(hVar);
            if (hVar.f() >= 0) {
                i2 = hVar.f();
                hVar.k();
            }
        }
        int a2 = hVar.a();
        hVar.q();
        int b2 = hVar.h().b();
        if (a2 < b2 && i2 != 0 && i2 != 5 && i2 != 4) {
            hVar.s((char) 254);
        }
        StringBuilder b3 = hVar.b();
        if (b3.length() < b2) {
            b3.append(a);
        }
        while (b3.length() < b2) {
            b3.append(p(a, b3.length() + 1));
        }
        return hVar.b().toString();
    }

    private static int d(float[] fArr, int[] iArr, int i2, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil(fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    private static int e(byte[] bArr) {
        int i2 = 0;
        for (int i3 = 0; i3 < 6; i3++) {
            i2 += bArr[i3];
        }
        return i2;
    }

    public static void f(char c2) {
        String hexString;
        throw new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + Integer.toHexString(c2)) + ')');
    }

    public static boolean g(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public static boolean h(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    private static boolean i(char c2) {
        if (c2 != ' ') {
            if (c2 < '0' || c2 > '9') {
                return c2 >= 'A' && c2 <= 'Z';
            }
            return true;
        }
        return true;
    }

    private static boolean j(char c2) {
        return c2 >= ' ' && c2 <= '^';
    }

    private static boolean k(char c2) {
        if (c2 != ' ') {
            if (c2 < '0' || c2 > '9') {
                return c2 >= 'a' && c2 <= 'z';
            }
            return true;
        }
        return true;
    }

    private static boolean l(char c2) {
        if (n(c2) || c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean m(char c2) {
        return false;
    }

    private static boolean n(char c2) {
        return c2 == '\r' || c2 == '*' || c2 == '>';
    }

    public static int o(CharSequence charSequence, int i2, int i3) {
        float[] fArr;
        char c2;
        if (i2 >= charSequence.length()) {
            return i3;
        }
        if (i3 == 0) {
            fArr = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i3] = 0.0f;
        }
        int i4 = 0;
        while (true) {
            int i5 = i2 + i4;
            if (i5 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int d2 = d(fArr, iArr, Integer.MAX_VALUE, bArr);
                int e2 = e(bArr);
                if (iArr[0] == d2) {
                    return 0;
                }
                if (e2 != 1 || bArr[5] <= 0) {
                    if (e2 != 1 || bArr[4] <= 0) {
                        if (e2 != 1 || bArr[2] <= 0) {
                            return (e2 != 1 || bArr[3] <= 0) ? 1 : 3;
                        }
                        return 2;
                    }
                    return 4;
                }
                return 5;
            }
            char charAt = charSequence.charAt(i5);
            i4++;
            if (g(charAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (h(charAt)) {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (i(charAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (k(charAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (l(charAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (h(charAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (j(charAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (h(charAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (m(charAt)) {
                c2 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c2 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i4 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                d(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int e3 = e(bArr2);
                if (iArr2[0] < iArr2[c2] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (e3 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (e3 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (e3 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i6 = i2 + i4 + 1; i6 < charSequence.length(); i6++) {
                            char charAt2 = charSequence.charAt(i6);
                            if (n(charAt2)) {
                                return 3;
                            }
                            if (!l(charAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static char p(char c2, int i2) {
        int i3 = c2 + ((i2 * 149) % 253) + 1;
        if (i3 > 254) {
            i3 -= 254;
        }
        return (char) i3;
    }
}
