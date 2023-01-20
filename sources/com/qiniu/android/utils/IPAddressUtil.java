package com.qiniu.android.utils;

/* loaded from: classes3.dex */
public class IPAddressUtil {
    private static final int INADDR16SZ = 16;
    private static final int INADDR4SZ = 4;
    private static final int INT16SZ = 2;

    public static byte[] convertFromIPv4MappedAddress(byte[] bArr) {
        if (isIPv4MappedAddress(bArr)) {
            byte[] bArr2 = new byte[4];
            System.arraycopy(bArr, 12, bArr2, 0, 4);
            return bArr2;
        }
        return null;
    }

    public static boolean isIPv4LiteralAddress(String str) {
        return textToNumericFormatV4(str) != null;
    }

    private static boolean isIPv4MappedAddress(byte[] bArr) {
        return bArr.length >= 16 && bArr[0] == 0 && bArr[1] == 0 && bArr[2] == 0 && bArr[3] == 0 && bArr[4] == 0 && bArr[5] == 0 && bArr[6] == 0 && bArr[7] == 0 && bArr[8] == 0 && bArr[9] == 0 && bArr[10] == -1 && bArr[11] == -1;
    }

    public static boolean isIPv6LiteralAddress(String str) {
        return textToNumericFormatV6(str) != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0065, code lost:
        if (r9 != 3) goto L40;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static byte[] textToNumericFormatV4(java.lang.String r15) {
        /*
            r0 = 4
            byte[] r0 = new byte[r0]
            int r1 = r15.length()
            r2 = 0
            if (r1 == 0) goto L89
            r3 = 15
            if (r1 <= r3) goto L10
            goto L89
        L10:
            r3 = 0
            r4 = 0
            r7 = r4
            r6 = 0
            r9 = 0
        L16:
            r10 = 3
            r11 = 255(0xff, double:1.26E-321)
            if (r6 >= r1) goto L4b
            char r13 = r15.charAt(r6)
            r14 = 46
            if (r13 != r14) goto L39
            int r13 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r13 < 0) goto L38
            int r13 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r13 > 0) goto L38
            if (r9 != r10) goto L2e
            goto L38
        L2e:
            int r10 = r9 + 1
            long r7 = r7 & r11
            int r8 = (int) r7
            byte r7 = (byte) r8
            r0[r9] = r7
            r7 = r4
            r9 = r10
            goto L48
        L38:
            return r2
        L39:
            r10 = 10
            int r10 = java.lang.Character.digit(r13, r10)
            if (r10 >= 0) goto L42
            return r2
        L42:
            r11 = 10
            long r7 = r7 * r11
            long r10 = (long) r10
            long r7 = r7 + r10
        L48:
            int r6 = r6 + 1
            goto L16
        L4b:
            int r15 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r15 < 0) goto L89
            r4 = 1
            int r15 = 4 - r9
            r1 = 8
            int r15 = r15 * 8
            long r4 = r4 << r15
            int r15 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r15 < 0) goto L5d
            goto L89
        L5d:
            r15 = 2
            r2 = 1
            if (r9 == 0) goto L68
            if (r9 == r2) goto L71
            if (r9 == r15) goto L7a
            if (r9 == r10) goto L81
            goto L88
        L68:
            r4 = 24
            long r4 = r7 >> r4
            long r4 = r4 & r11
            int r5 = (int) r4
            byte r4 = (byte) r5
            r0[r3] = r4
        L71:
            r4 = 16
            long r4 = r7 >> r4
            long r4 = r4 & r11
            int r5 = (int) r4
            byte r4 = (byte) r5
            r0[r2] = r4
        L7a:
            long r1 = r7 >> r1
            long r1 = r1 & r11
            int r2 = (int) r1
            byte r1 = (byte) r2
            r0[r15] = r1
        L81:
            long r1 = r7 >> r3
            long r1 = r1 & r11
            int r15 = (int) r1
            byte r15 = (byte) r15
            r0[r10] = r15
        L88:
            return r0
        L89:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.utils.IPAddressUtil.textToNumericFormatV4(java.lang.String):byte[]");
    }

    public static byte[] textToNumericFormatV6(String str) {
        int i2;
        byte[] textToNumericFormatV4;
        if (str.length() < 2) {
            return null;
        }
        char[] charArray = str.toCharArray();
        byte[] bArr = new byte[16];
        int length = charArray.length;
        int indexOf = str.indexOf("%");
        if (indexOf == length - 1) {
            return null;
        }
        if (indexOf != -1) {
            length = indexOf;
        }
        if (charArray[0] != ':') {
            i2 = 0;
        } else if (charArray[1] != ':') {
            return null;
        } else {
            i2 = 1;
        }
        int i3 = i2;
        int i4 = 0;
        boolean z = false;
        int i5 = 0;
        int i6 = -1;
        while (true) {
            if (i2 >= length) {
                break;
            }
            int i7 = i2 + 1;
            char c2 = charArray[i2];
            int digit = Character.digit(c2, 16);
            if (digit != -1) {
                i4 = (i4 << 4) | digit;
                if (i4 > 65535) {
                    return null;
                }
                i2 = i7;
                z = true;
            } else if (c2 == ':') {
                if (z) {
                    if (i7 == length || i5 + 2 > 16) {
                        return null;
                    }
                    int i8 = i5 + 1;
                    bArr[i5] = (byte) ((i4 >> 8) & 255);
                    i5 = i8 + 1;
                    bArr[i8] = (byte) (i4 & 255);
                    i2 = i7;
                    i3 = i2;
                    i4 = 0;
                    z = false;
                } else if (i6 != -1) {
                    return null;
                } else {
                    i2 = i7;
                    i3 = i2;
                    i6 = i5;
                }
            } else if (c2 != '.' || i5 + 4 > 16) {
                return null;
            } else {
                String substring = str.substring(i3, length);
                int i9 = 0;
                int i10 = 0;
                while (true) {
                    int indexOf2 = substring.indexOf(46, i9);
                    if (indexOf2 == -1) {
                        break;
                    }
                    i10++;
                    i9 = indexOf2 + 1;
                }
                if (i10 != 3 || (textToNumericFormatV4 = textToNumericFormatV4(substring)) == null) {
                    return null;
                }
                int i11 = 0;
                while (i11 < 4) {
                    bArr[i5] = textToNumericFormatV4[i11];
                    i11++;
                    i5++;
                }
                z = false;
            }
        }
        if (z) {
            if (i5 + 2 > 16) {
                return null;
            }
            int i12 = i5 + 1;
            bArr[i5] = (byte) ((i4 >> 8) & 255);
            i5 = i12 + 1;
            bArr[i12] = (byte) (i4 & 255);
        }
        if (i6 != -1) {
            int i13 = i5 - i6;
            if (i5 == 16) {
                return null;
            }
            for (int i14 = 1; i14 <= i13; i14++) {
                int i15 = (i6 + i13) - i14;
                bArr[16 - i14] = bArr[i15];
                bArr[i15] = 0;
            }
            i5 = 16;
        }
        if (i5 != 16) {
            return null;
        }
        byte[] convertFromIPv4MappedAddress = convertFromIPv4MappedAddress(bArr);
        return convertFromIPv4MappedAddress != null ? convertFromIPv4MappedAddress : bArr;
    }
}
