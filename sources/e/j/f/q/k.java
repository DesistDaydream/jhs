package e.j.f.q;

import com.google.zxing.DecodeHintType;
import java.nio.charset.Charset;
import java.util.Map;

/* loaded from: classes2.dex */
public final class k {
    private static final String a;
    public static final String b = "SJIS";

    /* renamed from: c  reason: collision with root package name */
    public static final String f11486c = "GB2312";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11487d = "EUC_JP";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11488e = "UTF8";

    /* renamed from: f  reason: collision with root package name */
    private static final String f11489f = "ISO8859_1";

    /* renamed from: g  reason: collision with root package name */
    private static final boolean f11490g;

    static {
        String name = Charset.defaultCharset().name();
        a = name;
        f11490g = b.equalsIgnoreCase(name) || f11487d.equalsIgnoreCase(name);
    }

    private k() {
    }

    public static String a(byte[] bArr, Map<DecodeHintType, ?> map) {
        byte[] bArr2 = bArr;
        if (map != null) {
            DecodeHintType decodeHintType = DecodeHintType.CHARACTER_SET;
            if (map.containsKey(decodeHintType)) {
                return map.get(decodeHintType).toString();
            }
        }
        int length = bArr2.length;
        boolean z = true;
        int i2 = 0;
        boolean z2 = bArr2.length > 3 && bArr2[0] == -17 && bArr2[1] == -69 && bArr2[2] == -65;
        int i3 = 0;
        boolean z3 = true;
        boolean z4 = true;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i4 < length && (z || z3 || z4)) {
            int i14 = bArr2[i4] & 255;
            if (z4) {
                if (i5 > 0) {
                    if ((i14 & 128) != 0) {
                        i5--;
                    }
                    z4 = false;
                } else if ((i14 & 128) != 0) {
                    if ((i14 & 64) != 0) {
                        i5++;
                        if ((i14 & 32) == 0) {
                            i7++;
                        } else {
                            i5++;
                            if ((i14 & 16) == 0) {
                                i8++;
                            } else {
                                i5++;
                                if ((i14 & 8) == 0) {
                                    i9++;
                                }
                            }
                        }
                    }
                    z4 = false;
                }
            }
            if (z) {
                if (i14 > 127 && i14 < 160) {
                    z = false;
                } else if (i14 > 159 && (i14 < 192 || i14 == 215 || i14 == 247)) {
                    i11++;
                }
            }
            if (z3) {
                if (i6 > 0) {
                    if (i14 >= 64 && i14 != 127 && i14 <= 252) {
                        i6--;
                    }
                    z3 = false;
                } else {
                    if (i14 != 128 && i14 != 160 && i14 <= 239) {
                        if (i14 <= 160 || i14 >= 224) {
                            if (i14 > 127) {
                                i6++;
                                int i15 = i12 + 1;
                                if (i15 > i2) {
                                    i2 = i15;
                                    i12 = i2;
                                } else {
                                    i12 = i15;
                                }
                            } else {
                                i12 = 0;
                            }
                            i13 = 0;
                        } else {
                            i3++;
                            int i16 = i13 + 1;
                            if (i16 > i10) {
                                i10 = i16;
                                i13 = i10;
                            } else {
                                i13 = i16;
                            }
                            i12 = 0;
                        }
                    }
                    z3 = false;
                }
            }
            i4++;
            bArr2 = bArr;
        }
        if (z4 && i5 > 0) {
            z4 = false;
        }
        if (z3 && i6 > 0) {
            z3 = false;
        }
        return (!z4 || (!z2 && (i7 + i8) + i9 <= 0)) ? (!z3 || (!f11490g && i10 < 3 && i2 < 3)) ? (z && z3) ? (!(i10 == 2 && i3 == 2) && i11 * 10 < length) ? f11489f : b : z ? f11489f : z3 ? b : z4 ? f11488e : a : b : f11488e;
    }
}
