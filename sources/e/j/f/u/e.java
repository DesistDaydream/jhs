package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.moor.imkf.lib.jsoup.nodes.Attributes;
import java.util.Map;

/* loaded from: classes2.dex */
public final class e extends r {
    private static void g(int i2, int[] iArr) {
        for (int i3 = 0; i3 < 9; i3++) {
            int i4 = 1;
            if (((1 << (8 - i3)) & i2) != 0) {
                i4 = 2;
            }
            iArr[i3] = i4;
        }
    }

    private static String h(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (charAt != 0) {
                if (charAt != ' ') {
                    if (charAt == '@') {
                        sb.append("%V");
                    } else if (charAt == '`') {
                        sb.append("%W");
                    } else if (charAt != '-' && charAt != '.') {
                        if (charAt <= 26) {
                            sb.append('$');
                            sb.append((char) ((charAt - 1) + 65));
                        } else if (charAt < ' ') {
                            sb.append('%');
                            sb.append((char) ((charAt - 27) + 65));
                        } else if (charAt <= ',' || charAt == '/' || charAt == ':') {
                            sb.append(Attributes.InternalPrefix);
                            sb.append((char) ((charAt - '!') + 65));
                        } else if (charAt <= '9') {
                            sb.append((char) ((charAt - '0') + 48));
                        } else if (charAt <= '?') {
                            sb.append('%');
                            sb.append((char) ((charAt - ';') + 70));
                        } else if (charAt <= 'Z') {
                            sb.append((char) ((charAt - 'A') + 65));
                        } else if (charAt <= '_') {
                            sb.append('%');
                            sb.append((char) ((charAt - '[') + 75));
                        } else if (charAt <= 'z') {
                            sb.append('+');
                            sb.append((char) ((charAt - 'a') + 65));
                        } else if (charAt <= 127) {
                            sb.append('%');
                            sb.append((char) ((charAt - '{') + 80));
                        } else {
                            throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i2) + "'");
                        }
                    }
                }
                sb.append(charAt);
            } else {
                sb.append("%U");
            }
        }
        return sb.toString();
    }

    @Override // e.j.f.u.r, e.j.f.n
    public e.j.f.q.b a(String str, BarcodeFormat barcodeFormat, int i2, int i3, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_39) {
            return super.a(str, barcodeFormat, i2, i3, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_39, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // e.j.f.u.r
    public boolean[] d(String str) {
        int length = str.length();
        if (length <= 80) {
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (d.f11629e.indexOf(str.charAt(i2)) < 0) {
                    str = h(str);
                    length = str.length();
                    if (length > 80) {
                        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                    }
                } else {
                    i2++;
                }
            }
            int[] iArr = new int[9];
            int i3 = length + 25;
            for (int i4 = 0; i4 < length; i4++) {
                g(d.f11630f[d.f11629e.indexOf(str.charAt(i4))], iArr);
                for (int i5 = 0; i5 < 9; i5++) {
                    i3 += iArr[i5];
                }
            }
            boolean[] zArr = new boolean[i3];
            g(d.f11631g, iArr);
            int c2 = r.c(zArr, 0, iArr, true);
            int[] iArr2 = {1};
            int c3 = c2 + r.c(zArr, c2, iArr2, false);
            for (int i6 = 0; i6 < length; i6++) {
                g(d.f11630f[d.f11629e.indexOf(str.charAt(i6))], iArr);
                int c4 = c3 + r.c(zArr, c3, iArr, true);
                c3 = c4 + r.c(zArr, c4, iArr2, false);
            }
            g(d.f11631g, iArr);
            r.c(zArr, c3, iArr, true);
            return zArr;
        }
        throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
    }
}
