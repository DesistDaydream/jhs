package e.j.f.u;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public final class f extends q {

    /* renamed from: c  reason: collision with root package name */
    public static final String f11634c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*";

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f11635d = f11634c.toCharArray();

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f11636e;

    /* renamed from: f  reason: collision with root package name */
    private static final int f11637f;
    private final StringBuilder a = new StringBuilder(20);
    private final int[] b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, TUIMessageBean.MSG_STATUS_DELETE, 266, TypedValues.Cycle.TYPE_WAVE_OFFSET, TypedValues.Cycle.TYPE_EASING, TTAdConstant.DEEPLINK_FALL_BACK_CODE, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, TypedValues.Cycle.TYPE_CUSTOM_WAVE_SHAPE, 406, TTAdConstant.IMAGE_LIST_SIZE_CODE, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f11636e = iArr;
        f11637f = iArr[47];
    }

    private static void h(CharSequence charSequence) throws ChecksumException {
        int length = charSequence.length();
        i(charSequence, length - 2, 20);
        i(charSequence, length - 1, 15);
    }

    private static void i(CharSequence charSequence, int i2, int i3) throws ChecksumException {
        int i4 = 0;
        int i5 = 1;
        for (int i6 = i2 - 1; i6 >= 0; i6--) {
            i4 += f11634c.indexOf(charSequence.charAt(i6)) * i5;
            i5++;
            if (i5 > i3) {
                i5 = 1;
            }
        }
        if (charSequence.charAt(i2) != f11635d[i4 % 47]) {
            throw ChecksumException.getChecksumInstance();
        }
    }

    private static String j(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt < 'a' || charAt > 'd') {
                sb.append(charAt);
            } else if (i3 < length - 1) {
                i3++;
                char charAt2 = charSequence.charAt(i3);
                switch (charAt) {
                    case 'a':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i2 = charAt2 - '@';
                            c2 = (char) i2;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        break;
                    case 'b':
                        if (charAt2 >= 'A' && charAt2 <= 'E') {
                            i2 = charAt2 - '&';
                        } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                            i2 = charAt2 - 11;
                        } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                            i2 = charAt2 + 16;
                        } else if (charAt2 >= 'P' && charAt2 <= 'S') {
                            i2 = charAt2 + '+';
                        } else if (charAt2 >= 'T' && charAt2 <= 'Z') {
                            c2 = 127;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                        c2 = (char) i2;
                        break;
                    case 'c':
                        if (charAt2 >= 'A' && charAt2 <= 'O') {
                            i2 = charAt2 - ' ';
                            c2 = (char) i2;
                            break;
                        } else if (charAt2 == 'Z') {
                            c2 = ':';
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    case 'd':
                        if (charAt2 >= 'A' && charAt2 <= 'Z') {
                            i2 = charAt2 + ' ';
                            c2 = (char) i2;
                            break;
                        } else {
                            throw FormatException.getFormatInstance();
                        }
                    default:
                        c2 = 0;
                        break;
                }
                sb.append(c2);
            } else {
                throw FormatException.getFormatInstance();
            }
            i3++;
        }
        return sb.toString();
    }

    private int[] k(e.j.f.q.a aVar) throws NotFoundException {
        int n = aVar.n();
        int l2 = aVar.l(0);
        Arrays.fill(this.b, 0);
        int[] iArr = this.b;
        int length = iArr.length;
        int i2 = l2;
        boolean z = false;
        int i3 = 0;
        while (l2 < n) {
            if (aVar.j(l2) != z) {
                iArr[i3] = iArr[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else if (m(iArr) == f11637f) {
                    return new int[]{i2, l2};
                } else {
                    i2 += iArr[0] + iArr[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i4);
                    iArr[i4] = 0;
                    iArr[i3] = 0;
                    i3--;
                }
                iArr[i3] = 1;
                z = !z;
            }
            l2++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static char l(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = f11636e;
            if (i3 < iArr.length) {
                if (iArr[i3] == i2) {
                    return f11635d[i3];
                }
                i3++;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    private static int m(int[] iArr) {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 += i3;
        }
        int length = iArr.length;
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            int round = Math.round((iArr[i5] * 9.0f) / i2);
            if (round <= 0 || round > 4) {
                return -1;
            }
            if ((i5 & 1) == 0) {
                for (int i6 = 0; i6 < round; i6++) {
                    i4 = (i4 << 1) | 1;
                }
            } else {
                i4 <<= round;
            }
        }
        return i4;
    }

    @Override // e.j.f.u.q
    public e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] k2;
        int l2 = aVar.l(k(aVar)[1]);
        int n = aVar.n();
        int[] iArr = this.b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.a;
        sb.setLength(0);
        while (true) {
            q.f(aVar, l2, iArr);
            int m2 = m(iArr);
            if (m2 >= 0) {
                char l3 = l(m2);
                sb.append(l3);
                int i3 = l2;
                for (int i4 : iArr) {
                    i3 += i4;
                }
                int l4 = aVar.l(i3);
                if (l3 == '*') {
                    sb.deleteCharAt(sb.length() - 1);
                    int i5 = 0;
                    for (int i6 : iArr) {
                        i5 += i6;
                    }
                    if (l4 != n && aVar.j(l4)) {
                        if (sb.length() >= 2) {
                            h(sb);
                            sb.setLength(sb.length() - 2);
                            float f2 = i2;
                            return new e.j.f.k(j(sb), null, new e.j.f.l[]{new e.j.f.l((k2[1] + k2[0]) / 2.0f, f2), new e.j.f.l(l2 + (i5 / 2.0f), f2)}, BarcodeFormat.CODE_93);
                        }
                        throw NotFoundException.getNotFoundInstance();
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                l2 = l4;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }
}
