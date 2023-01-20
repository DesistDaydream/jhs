package j.q0;

import com.umeng.analytics.pro.am;
import h.k2.v.f0;
import j.p0;
import java.util.Arrays;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a%\u0010\u0005\u001a\u00020\u0004*\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0000*\u00020\u0004¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"", "", "beginIndex", "endIndex", "", "b", "([BII)Ljava/lang/String;", am.av, "(Ljava/lang/String;)[B", "okio"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class f {
    @k.e.a.d
    public static final byte[] a(@k.e.a.d String str) {
        int i2;
        int i3;
        char charAt;
        byte[] bArr = new byte[str.length() * 4];
        int length = str.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt2 = str.charAt(i4);
            if (f0.t(charAt2, 128) >= 0) {
                int length2 = str.length();
                int i5 = i4;
                while (i4 < length2) {
                    char charAt3 = str.charAt(i4);
                    if (f0.t(charAt3, 128) < 0) {
                        int i6 = i5 + 1;
                        bArr[i5] = (byte) charAt3;
                        i4++;
                        while (i4 < length2 && f0.t(str.charAt(i4), 128) < 0) {
                            bArr[i6] = (byte) str.charAt(i4);
                            i4++;
                            i6++;
                        }
                        i5 = i6;
                    } else {
                        if (f0.t(charAt3, 2048) < 0) {
                            int i7 = i5 + 1;
                            bArr[i5] = (byte) ((charAt3 >> 6) | 192);
                            i2 = i7 + 1;
                            bArr[i7] = (byte) ((charAt3 & k.b.a.a.o.e.a) | 128);
                        } else if (55296 > charAt3 || 57343 < charAt3) {
                            int i8 = i5 + 1;
                            bArr[i5] = (byte) ((charAt3 >> '\f') | 224);
                            int i9 = i8 + 1;
                            bArr[i8] = (byte) (((charAt3 >> 6) & 63) | 128);
                            i2 = i9 + 1;
                            bArr[i9] = (byte) ((charAt3 & k.b.a.a.o.e.a) | 128);
                        } else if (f0.t(charAt3, 56319) > 0 || length2 <= (i3 = i4 + 1) || 56320 > (charAt = str.charAt(i3)) || 57343 < charAt) {
                            i2 = i5 + 1;
                            bArr[i5] = p0.a;
                        } else {
                            int charAt4 = ((charAt3 << '\n') + str.charAt(i3)) - 56613888;
                            int i10 = i5 + 1;
                            bArr[i5] = (byte) ((charAt4 >> 18) | 240);
                            int i11 = i10 + 1;
                            bArr[i10] = (byte) (((charAt4 >> 12) & 63) | 128);
                            int i12 = i11 + 1;
                            bArr[i11] = (byte) (((charAt4 >> 6) & 63) | 128);
                            i2 = i12 + 1;
                            bArr[i12] = (byte) ((charAt4 & 63) | 128);
                            i4 += 2;
                            i5 = i2;
                        }
                        i4++;
                        i5 = i2;
                    }
                }
                return Arrays.copyOf(bArr, i5);
            }
            bArr[i4] = (byte) charAt2;
            i4++;
        }
        return Arrays.copyOf(bArr, str.length());
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x0098, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0119, code lost:
        if (((r16[r5] & 192) == 128) == false) goto L37;
     */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.String b(@k.e.a.d byte[] r16, int r17, int r18) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: j.q0.f.b(byte[], int, int):java.lang.String");
    }

    public static /* synthetic */ String c(byte[] bArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i2 = 0;
        }
        if ((i4 & 2) != 0) {
            i3 = bArr.length;
        }
        return b(bArr, i2, i3);
    }
}
