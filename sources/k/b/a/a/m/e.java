package k.b.a.a.m;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes4.dex */
public class e {
    public static final String a = "$apr1$";
    private static final int b = 16;

    /* renamed from: c  reason: collision with root package name */
    public static final String f16076c = "$1$";

    /* renamed from: d  reason: collision with root package name */
    private static final int f16077d = 1000;

    public static String a(String str) {
        return c(str.getBytes(StandardCharsets.UTF_8));
    }

    public static String b(String str, String str2) {
        return d(str.getBytes(StandardCharsets.UTF_8), str2);
    }

    public static String c(byte[] bArr) {
        return d(bArr, a + a.b(8));
    }

    public static String d(byte[] bArr, String str) {
        if (str != null && !str.startsWith(a)) {
            str = a + str;
        }
        return h(bArr, str, a);
    }

    public static String e(byte[] bArr, Random random) {
        return d(bArr, a + a.c(8, random));
    }

    public static String f(byte[] bArr) {
        return g(bArr, f16076c + a.b(8));
    }

    public static String g(byte[] bArr, String str) {
        return h(bArr, str, f16076c);
    }

    public static String h(byte[] bArr, String str, String str2) {
        return i(bArr, str, str2, new SecureRandom());
    }

    public static String i(byte[] bArr, String str, String str2, Random random) {
        String group;
        int length = bArr.length;
        if (str == null) {
            group = a.c(8, random);
        } else {
            Matcher matcher = Pattern.compile("^" + str2.replace("$", "\\$") + "([\\.\\/a-zA-Z0-9]{1,8}).*").matcher(str);
            if (matcher.find()) {
                group = matcher.group(1);
            } else {
                throw new IllegalArgumentException("Invalid salt value: " + str);
            }
        }
        byte[] bytes = group.getBytes(StandardCharsets.UTF_8);
        MessageDigest v = c.v();
        v.update(bArr);
        v.update(str2.getBytes(StandardCharsets.UTF_8));
        v.update(bytes);
        MessageDigest v2 = c.v();
        v2.update(bArr);
        v2.update(bytes);
        v2.update(bArr);
        byte[] digest = v2.digest();
        int i2 = length;
        while (true) {
            int i3 = 16;
            if (i2 <= 0) {
                break;
            }
            if (i2 <= 16) {
                i3 = i2;
            }
            v.update(digest, 0, i3);
            i2 -= 16;
        }
        Arrays.fill(digest, (byte) 0);
        while (length > 0) {
            if ((length & 1) == 1) {
                v.update(digest[0]);
            } else {
                v.update(bArr[0]);
            }
            length >>= 1;
        }
        StringBuilder sb = new StringBuilder(str2 + group + "$");
        byte[] digest2 = v.digest();
        for (int i4 = 0; i4 < 1000; i4++) {
            v2 = c.v();
            int i5 = i4 & 1;
            if (i5 != 0) {
                v2.update(bArr);
            } else {
                v2.update(digest2, 0, 16);
            }
            if (i4 % 3 != 0) {
                v2.update(bytes);
            }
            if (i4 % 7 != 0) {
                v2.update(bArr);
            }
            if (i5 != 0) {
                v2.update(digest2, 0, 16);
            } else {
                v2.update(bArr);
            }
            digest2 = v2.digest();
        }
        a.a(digest2[0], digest2[6], digest2[12], 4, sb);
        a.a(digest2[1], digest2[7], digest2[13], 4, sb);
        a.a(digest2[2], digest2[8], digest2[14], 4, sb);
        a.a(digest2[3], digest2[9], digest2[15], 4, sb);
        a.a(digest2[4], digest2[10], digest2[5], 4, sb);
        a.a((byte) 0, (byte) 0, digest2[11], 2, sb);
        v.reset();
        v2.reset();
        Arrays.fill(bArr, (byte) 0);
        Arrays.fill(bytes, (byte) 0);
        Arrays.fill(digest2, (byte) 0);
        return sb.toString();
    }

    public static String j(byte[] bArr, Random random) {
        return g(bArr, f16076c + a.c(8, random));
    }
}
