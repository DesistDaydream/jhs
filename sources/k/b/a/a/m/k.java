package k.b.a.a.m;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class k {
    private static final int a = 5000;
    private static final int b = 999999999;

    /* renamed from: c  reason: collision with root package name */
    private static final int f16113c = 1000;

    /* renamed from: d  reason: collision with root package name */
    private static final String f16114d = "rounds=";

    /* renamed from: e  reason: collision with root package name */
    private static final int f16115e = 32;

    /* renamed from: f  reason: collision with root package name */
    public static final String f16116f = "$5$";

    /* renamed from: g  reason: collision with root package name */
    private static final int f16117g = 64;

    /* renamed from: h  reason: collision with root package name */
    public static final String f16118h = "$6$";

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f16119i = Pattern.compile("^\\$([56])\\$(rounds=(\\d+)\\$)?([\\.\\/a-zA-Z0-9]{1,16}).*");

    public static String a(byte[] bArr) {
        return b(bArr, null);
    }

    public static String b(byte[] bArr, String str) {
        if (str == null) {
            str = f16116f + a.b(8);
        }
        return d(bArr, str, f16116f, 32, "SHA-256");
    }

    public static String c(byte[] bArr, String str, Random random) {
        if (str == null) {
            str = f16116f + a.c(8, random);
        }
        return d(bArr, str, f16116f, 32, "SHA-256");
    }

    private static String d(byte[] bArr, String str, String str2, int i2, String str3) {
        int i3;
        boolean z;
        byte b2;
        byte[] bArr2;
        int i4;
        int length = bArr.length;
        if (str != null) {
            Matcher matcher = f16119i.matcher(str);
            if (matcher.find()) {
                if (matcher.group(3) != null) {
                    i3 = Math.max(1000, Math.min((int) b, Integer.parseInt(matcher.group(3))));
                    z = true;
                } else {
                    i3 = 5000;
                    z = false;
                }
                String group = matcher.group(4);
                byte[] bytes = group.getBytes(StandardCharsets.UTF_8);
                int length2 = bytes.length;
                MessageDigest s = c.s(str3);
                s.update(bArr);
                s.update(bytes);
                MessageDigest s2 = c.s(str3);
                s2.update(bArr);
                s2.update(bytes);
                s2.update(bArr);
                byte[] digest = s2.digest();
                int length3 = bArr.length;
                while (length3 > i2) {
                    s.update(digest, 0, i2);
                    length3 -= i2;
                }
                s.update(digest, 0, length3);
                for (int length4 = bArr.length; length4 > 0; length4 >>= 1) {
                    if ((length4 & 1) != 0) {
                        s.update(digest, 0, i2);
                    } else {
                        s.update(bArr);
                    }
                }
                byte[] digest2 = s.digest();
                MessageDigest s3 = c.s(str3);
                for (int i5 = 1; i5 <= length; i5++) {
                    s3.update(bArr);
                }
                byte[] digest3 = s3.digest();
                byte[] bArr3 = new byte[length];
                int i6 = 0;
                while (i6 < length - i2) {
                    System.arraycopy(digest3, 0, bArr3, i6, i2);
                    i6 += i2;
                }
                System.arraycopy(digest3, 0, bArr3, i6, length - i6);
                MessageDigest s4 = c.s(str3);
                for (int i7 = 1; i7 <= (digest2[0] & 255) + 16; i7++) {
                    s4.update(bytes);
                }
                byte[] digest4 = s4.digest();
                byte[] bArr4 = new byte[length2];
                int i8 = 0;
                while (i8 < length2 - i2) {
                    System.arraycopy(digest4, 0, bArr4, i8, i2);
                    i8 += i2;
                }
                System.arraycopy(digest4, 0, bArr4, i8, length2 - i8);
                MessageDigest messageDigest = s;
                int i9 = 0;
                while (i9 <= i3 - 1) {
                    messageDigest = c.s(str3);
                    int i10 = i9 & 1;
                    if (i10 != 0) {
                        bArr2 = bytes;
                        i4 = 0;
                        messageDigest.update(bArr3, 0, length);
                    } else {
                        bArr2 = bytes;
                        i4 = 0;
                        messageDigest.update(digest2, 0, i2);
                    }
                    if (i9 % 3 != 0) {
                        messageDigest.update(bArr4, i4, length2);
                    }
                    if (i9 % 7 != 0) {
                        messageDigest.update(bArr3, i4, length);
                    }
                    if (i10 != 0) {
                        messageDigest.update(digest2, i4, i2);
                    } else {
                        messageDigest.update(bArr3, i4, length);
                    }
                    digest2 = messageDigest.digest();
                    i9++;
                    bytes = bArr2;
                }
                byte[] bArr5 = bytes;
                StringBuilder sb = new StringBuilder(str2);
                if (z) {
                    sb.append(f16114d);
                    sb.append(i3);
                    sb.append("$");
                }
                sb.append(group);
                sb.append("$");
                if (i2 == 32) {
                    a.a(digest2[0], digest2[10], digest2[20], 4, sb);
                    a.a(digest2[21], digest2[1], digest2[11], 4, sb);
                    a.a(digest2[12], digest2[22], digest2[2], 4, sb);
                    a.a(digest2[3], digest2[13], digest2[23], 4, sb);
                    a.a(digest2[24], digest2[4], digest2[14], 4, sb);
                    a.a(digest2[15], digest2[25], digest2[5], 4, sb);
                    a.a(digest2[6], digest2[16], digest2[26], 4, sb);
                    a.a(digest2[27], digest2[7], digest2[17], 4, sb);
                    a.a(digest2[18], digest2[28], digest2[8], 4, sb);
                    a.a(digest2[9], digest2[19], digest2[29], 4, sb);
                    a.a((byte) 0, digest2[31], digest2[30], 3, sb);
                    b2 = 0;
                } else {
                    a.a(digest2[0], digest2[21], digest2[42], 4, sb);
                    a.a(digest2[22], digest2[43], digest2[1], 4, sb);
                    a.a(digest2[44], digest2[2], digest2[23], 4, sb);
                    a.a(digest2[3], digest2[24], digest2[45], 4, sb);
                    a.a(digest2[25], digest2[46], digest2[4], 4, sb);
                    a.a(digest2[47], digest2[5], digest2[26], 4, sb);
                    a.a(digest2[6], digest2[27], digest2[48], 4, sb);
                    a.a(digest2[28], digest2[49], digest2[7], 4, sb);
                    a.a(digest2[50], digest2[8], digest2[29], 4, sb);
                    a.a(digest2[9], digest2[30], digest2[51], 4, sb);
                    a.a(digest2[31], digest2[52], digest2[10], 4, sb);
                    a.a(digest2[53], digest2[11], digest2[32], 4, sb);
                    a.a(digest2[12], digest2[33], digest2[54], 4, sb);
                    a.a(digest2[34], digest2[55], digest2[13], 4, sb);
                    a.a(digest2[56], digest2[14], digest2[35], 4, sb);
                    a.a(digest2[15], digest2[36], digest2[57], 4, sb);
                    a.a(digest2[37], digest2[58], digest2[16], 4, sb);
                    a.a(digest2[59], digest2[17], digest2[38], 4, sb);
                    a.a(digest2[18], digest2[39], digest2[60], 4, sb);
                    a.a(digest2[40], digest2[61], digest2[19], 4, sb);
                    a.a(digest2[62], digest2[20], digest2[41], 4, sb);
                    b2 = 0;
                    a.a((byte) 0, (byte) 0, digest2[63], 2, sb);
                }
                Arrays.fill(digest4, b2);
                Arrays.fill(bArr3, b2);
                Arrays.fill(bArr4, b2);
                messageDigest.reset();
                s4.reset();
                Arrays.fill(bArr, b2);
                Arrays.fill(bArr5, b2);
                return sb.toString();
            }
            throw new IllegalArgumentException("Invalid salt value: " + str);
        }
        throw new IllegalArgumentException("Salt must not be null");
    }

    public static String e(byte[] bArr) {
        return f(bArr, null);
    }

    public static String f(byte[] bArr, String str) {
        if (str == null) {
            str = f16118h + a.b(8);
        }
        return d(bArr, str, f16118h, 64, "SHA-512");
    }

    public static String g(byte[] bArr, String str, Random random) {
        if (str == null) {
            str = f16118h + a.c(8, random);
        }
        return d(bArr, str, f16118h, 64, "SHA-512");
    }
}
