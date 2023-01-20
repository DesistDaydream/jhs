package e.j.f.u;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.qq.e.comm.adevent.AdEventType;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.qcloud.tuikit.tuichat.component.camera.view.CameraInterface;
import java.util.Arrays;
import java.util.Map;

/* loaded from: classes2.dex */
public final class d extends q {

    /* renamed from: e  reason: collision with root package name */
    public static final String f11629e = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%";

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f11630f = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, TUIMessageBean.MSG_STATUS_DELETE, 82, 7, TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME, 70, 22, 385, 193, 448, CameraInterface.TYPE_CAPTURE, 400, AdEventType.VIDEO_CLICKED, 133, 388, 196, 168, 162, 138, 42};

    /* renamed from: g  reason: collision with root package name */
    public static final int f11631g = 148;
    private final boolean a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private final StringBuilder f11632c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f11633d;

    public d() {
        this(false);
    }

    private static String h(CharSequence charSequence) throws FormatException {
        int i2;
        char c2;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        int i3 = 0;
        while (i3 < length) {
            char charAt = charSequence.charAt(i3);
            if (charAt != '+' && charAt != '$' && charAt != '%' && charAt != '/') {
                sb.append(charAt);
            } else {
                i3++;
                char charAt2 = charSequence.charAt(i3);
                if (charAt != '$') {
                    if (charAt != '%') {
                        if (charAt != '+') {
                            if (charAt == '/') {
                                if (charAt2 >= 'A' && charAt2 <= 'O') {
                                    i2 = charAt2 - ' ';
                                } else if (charAt2 != 'Z') {
                                    throw FormatException.getFormatInstance();
                                } else {
                                    c2 = ':';
                                    sb.append(c2);
                                }
                            }
                            c2 = 0;
                            sb.append(c2);
                        } else if (charAt2 < 'A' || charAt2 > 'Z') {
                            throw FormatException.getFormatInstance();
                        } else {
                            i2 = charAt2 + ' ';
                        }
                    } else if (charAt2 >= 'A' && charAt2 <= 'E') {
                        i2 = charAt2 - '&';
                    } else if (charAt2 >= 'F' && charAt2 <= 'J') {
                        i2 = charAt2 - 11;
                    } else if (charAt2 >= 'K' && charAt2 <= 'O') {
                        i2 = charAt2 + 16;
                    } else if (charAt2 < 'P' || charAt2 > 'T') {
                        if (charAt2 != 'U') {
                            if (charAt2 == 'V') {
                                c2 = '@';
                            } else if (charAt2 == 'W') {
                                c2 = '`';
                            } else if (charAt2 != 'X' && charAt2 != 'Y' && charAt2 != 'Z') {
                                throw FormatException.getFormatInstance();
                            } else {
                                c2 = 127;
                            }
                            sb.append(c2);
                        }
                        c2 = 0;
                        sb.append(c2);
                    } else {
                        i2 = charAt2 + '+';
                    }
                } else if (charAt2 < 'A' || charAt2 > 'Z') {
                    throw FormatException.getFormatInstance();
                } else {
                    i2 = charAt2 - '@';
                }
                c2 = (char) i2;
                sb.append(c2);
            }
            i3++;
        }
        return sb.toString();
    }

    private static int[] i(e.j.f.q.a aVar, int[] iArr) throws NotFoundException {
        int n = aVar.n();
        int l2 = aVar.l(0);
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
                } else if (k(iArr) == 148 && aVar.p(Math.max(0, i2 - ((l2 - i2) / 2)), i2, false)) {
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

    private static char j(int i2) throws NotFoundException {
        int i3 = 0;
        while (true) {
            int[] iArr = f11630f;
            if (i3 >= iArr.length) {
                if (i2 == 148) {
                    return '*';
                }
                throw NotFoundException.getNotFoundInstance();
            } else if (iArr[i3] == i2) {
                return f11629e.charAt(i3);
            } else {
                i3++;
            }
        }
    }

    private static int k(int[] iArr) {
        int length = iArr.length;
        int i2 = 0;
        while (true) {
            int i3 = Integer.MAX_VALUE;
            for (int i4 : iArr) {
                if (i4 < i3 && i4 > i2) {
                    i3 = i4;
                }
            }
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < length; i8++) {
                int i9 = iArr[i8];
                if (i9 > i3) {
                    i6 |= 1 << ((length - 1) - i8);
                    i5++;
                    i7 += i9;
                }
            }
            if (i5 == 3) {
                for (int i10 = 0; i10 < length && i5 > 0; i10++) {
                    int i11 = iArr[i10];
                    if (i11 > i3) {
                        i5--;
                        if ((i11 << 1) >= i7) {
                            return -1;
                        }
                    }
                }
                return i6;
            } else if (i5 <= 3) {
                return -1;
            } else {
                i2 = i3;
            }
        }
    }

    @Override // e.j.f.u.q
    public e.j.f.k b(int i2, e.j.f.q.a aVar, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        int[] i3;
        String sb;
        int[] iArr = this.f11633d;
        Arrays.fill(iArr, 0);
        StringBuilder sb2 = this.f11632c;
        sb2.setLength(0);
        int l2 = aVar.l(i(aVar, iArr)[1]);
        int n = aVar.n();
        while (true) {
            q.f(aVar, l2, iArr);
            int k2 = k(iArr);
            if (k2 >= 0) {
                char j2 = j(k2);
                sb2.append(j2);
                int i4 = l2;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int l3 = aVar.l(i4);
                if (j2 == '*') {
                    sb2.setLength(sb2.length() - 1);
                    int i6 = 0;
                    for (int i7 : iArr) {
                        i6 += i7;
                    }
                    int i8 = (l3 - l2) - i6;
                    if (l3 != n && (i8 << 1) < i6) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    if (this.a) {
                        int length = sb2.length() - 1;
                        int i9 = 0;
                        for (int i10 = 0; i10 < length; i10++) {
                            i9 += f11629e.indexOf(this.f11632c.charAt(i10));
                        }
                        if (sb2.charAt(length) == f11629e.charAt(i9 % 43)) {
                            sb2.setLength(length);
                        } else {
                            throw ChecksumException.getChecksumInstance();
                        }
                    }
                    if (sb2.length() != 0) {
                        if (this.b) {
                            sb = h(sb2);
                        } else {
                            sb = sb2.toString();
                        }
                        float f2 = i2;
                        return new e.j.f.k(sb, null, new e.j.f.l[]{new e.j.f.l((i3[1] + i3[0]) / 2.0f, f2), new e.j.f.l(l2 + (i6 / 2.0f), f2)}, BarcodeFormat.CODE_39);
                    }
                    throw NotFoundException.getNotFoundInstance();
                }
                l2 = l3;
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    public d(boolean z) {
        this(z, false);
    }

    public d(boolean z, boolean z2) {
        this.a = z;
        this.b = z2;
        this.f11632c = new StringBuilder(20);
        this.f11633d = new int[9];
    }
}
