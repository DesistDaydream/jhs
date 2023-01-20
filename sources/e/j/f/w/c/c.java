package e.j.f.w.c;

import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import e.j.f.q.k;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* loaded from: classes2.dex */
public final class c {
    private static final char[] a = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ $%*+-./:".toCharArray();
    private static final int b = 1;

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
            try {
                a[Mode.TERMINATOR.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[Mode.FNC1_FIRST_POSITION.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[Mode.FNC1_SECOND_POSITION.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[Mode.STRUCTURED_APPEND.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[Mode.ECI.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[Mode.HANZI.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    private c() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static e.j.f.q.d a(byte[] bArr, g gVar, ErrorCorrectionLevel errorCorrectionLevel, Map<DecodeHintType, ?> map) throws FormatException {
        Mode forBits;
        Mode mode;
        e.j.f.q.c cVar = new e.j.f.q.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i2 = 1;
        ArrayList arrayList = new ArrayList(1);
        CharacterSetECI characterSetECI = null;
        boolean z = false;
        int i3 = -1;
        int i4 = -1;
        while (true) {
            try {
                if (cVar.a() < 4) {
                    forBits = Mode.TERMINATOR;
                } else {
                    forBits = Mode.forBits(cVar.d(4));
                }
                Mode mode2 = forBits;
                int[] iArr = a.a;
                switch (iArr[mode2.ordinal()]) {
                    case 5:
                        mode = mode2;
                        break;
                    case 6:
                    case 7:
                        mode = mode2;
                        z = true;
                        break;
                    case 8:
                        if (cVar.a() >= 16) {
                            int d2 = cVar.d(8);
                            i4 = cVar.d(8);
                            i3 = d2;
                            mode = mode2;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 9:
                        characterSetECI = CharacterSetECI.getCharacterSetECIByValue(g(cVar));
                        if (characterSetECI == null) {
                            throw FormatException.getFormatInstance();
                        }
                        mode = mode2;
                        break;
                    case 10:
                        int d3 = cVar.d(4);
                        int d4 = cVar.d(mode2.getCharacterCountBits(gVar));
                        if (d3 == i2) {
                            d(cVar, sb, d4);
                        }
                        mode = mode2;
                        break;
                    default:
                        int d5 = cVar.d(mode2.getCharacterCountBits(gVar));
                        int i5 = iArr[mode2.ordinal()];
                        if (i5 == i2) {
                            mode = mode2;
                            f(cVar, sb, d5);
                            break;
                        } else if (i5 == 2) {
                            mode = mode2;
                            b(cVar, sb, d5, z);
                            break;
                        } else if (i5 == 3) {
                            mode = mode2;
                            c(cVar, sb, d5, characterSetECI, arrayList, map);
                            break;
                        } else if (i5 == 4) {
                            e(cVar, sb, d5);
                            mode = mode2;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                }
                if (mode == Mode.TERMINATOR) {
                    return new e.j.f.q.d(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, errorCorrectionLevel == null ? null : errorCorrectionLevel.toString(), i3, i4);
                }
                i2 = 1;
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        }
    }

    private static void b(e.j.f.q.c cVar, StringBuilder sb, int i2, boolean z) throws FormatException {
        while (i2 > 1) {
            if (cVar.a() >= 11) {
                int d2 = cVar.d(11);
                sb.append(h(d2 / 45));
                sb.append(h(d2 % 45));
                i2 -= 2;
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i2 == 1) {
            if (cVar.a() >= 6) {
                sb.append(h(cVar.d(6)));
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static void c(e.j.f.q.c cVar, StringBuilder sb, int i2, CharacterSetECI characterSetECI, Collection<byte[]> collection, Map<DecodeHintType, ?> map) throws FormatException {
        String name;
        if ((i2 << 3) <= cVar.a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) cVar.d(8);
            }
            if (characterSetECI == null) {
                name = k.a(bArr, map);
            } else {
                name = characterSetECI.name();
            }
            try {
                sb.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        throw FormatException.getFormatInstance();
    }

    private static void d(e.j.f.q.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int d2 = cVar.d(13);
                int i4 = (d2 % 96) | ((d2 / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, k.f11486c));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        throw FormatException.getFormatInstance();
    }

    private static void e(e.j.f.q.c cVar, StringBuilder sb, int i2) throws FormatException {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int d2 = cVar.d(13);
                int i4 = (d2 % 192) | ((d2 / 192) << 8);
                int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
                bArr[i3] = (byte) (i5 >> 8);
                bArr[i3 + 1] = (byte) i5;
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, k.b));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw FormatException.getFormatInstance();
            }
        }
        throw FormatException.getFormatInstance();
    }

    private static void f(e.j.f.q.c cVar, StringBuilder sb, int i2) throws FormatException {
        while (i2 >= 3) {
            if (cVar.a() >= 10) {
                int d2 = cVar.d(10);
                if (d2 < 1000) {
                    sb.append(h(d2 / 100));
                    sb.append(h((d2 / 10) % 10));
                    sb.append(h(d2 % 10));
                    i2 -= 3;
                } else {
                    throw FormatException.getFormatInstance();
                }
            } else {
                throw FormatException.getFormatInstance();
            }
        }
        if (i2 == 2) {
            if (cVar.a() >= 7) {
                int d3 = cVar.d(7);
                if (d3 < 100) {
                    sb.append(h(d3 / 10));
                    sb.append(h(d3 % 10));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        } else if (i2 == 1) {
            if (cVar.a() >= 4) {
                int d4 = cVar.d(4);
                if (d4 < 10) {
                    sb.append(h(d4));
                    return;
                }
                throw FormatException.getFormatInstance();
            }
            throw FormatException.getFormatInstance();
        }
    }

    private static int g(e.j.f.q.c cVar) throws FormatException {
        int d2 = cVar.d(8);
        if ((d2 & 128) == 0) {
            return d2 & 127;
        }
        if ((d2 & 192) == 128) {
            return cVar.d(8) | ((d2 & 63) << 8);
        }
        if ((d2 & 224) == 192) {
            return cVar.d(16) | ((d2 & 31) << 16);
        }
        throw FormatException.getFormatInstance();
    }

    private static char h(int i2) throws FormatException {
        char[] cArr = a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw FormatException.getFormatInstance();
    }
}
